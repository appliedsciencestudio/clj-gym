(ns clj-gym.api
  "API for interacting with OpenAI's HTTP server:
  https://github.com/openai/gym-http-api/"
  (:require [clj-http.client :as http]
            [cheshire.core :as json]))

(def ^:dynamic *url* "http://localhost:5000")

(defn- req [method rel-url body & [kw?]]
  (-> (merge {:url (str *url* "/v1/envs/" rel-url)
              :method method
              :content-type :json :accept :json}
             (when body {:body (json/generate-string body)}))
      http/request
      :body
      (json/parse-string kw?)))

(defn create
  "Create instance of environment."
  [env-id]
  (get (req :post nil {:env_id env-id}) "instance_id"))

(defn envs
  "All running environments."
  []
  ((req :get nil nil) "all_envs"))

(defn reset
  "Reset environment and return initial observation."
  [instance-id]
  (req :post (str instance-id "/reset/") nil true))

(defn step
  "Step though environment using action.
  Return map of {\"observation\" _ \"reward\" _ \"done\" _ \"info\" _}"
  [instance-id action & {:keys [render?]}]
  (req :post (str instance-id "/step/") {:action action
                                         :render (if render? true false)} true))

(defn action-space
  "Name and dimensions/bounds of action_space."
  [instance-id]
  (:info (req :get (str instance-id "/action_space/") nil true)))

(defn observation-space
  "Name and dimensions/bounds of observation_space."
  [instance-id]
  (:info (req :get (str instance-id "/observation_space/") nil true)))

(defn start-monitor [instance-id directory & {:keys [force? resume? video-callable]}]
  (req :post (str instance-id "/monitor/start/")
       {:directory directory
        :force (if force? true false)
        :resume (if resume? true false)
        :video_callable (case video-callable
                          true 1
                          nil false
                          video-callable)}))

(defn close-monitor
  "Flush monitor data to disk."
  [instance-id]
  (req :post (str instance-id "/monitor/close/") nil))
