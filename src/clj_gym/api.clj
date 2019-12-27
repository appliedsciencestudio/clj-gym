(ns clj-gym.api
  "API for interacting with OpenAI's HTTP server:
  https://github.com/openai/gym-http-api/"
  (:require [cheshire.core :as json]
            [clj-gym.environments :as environment]
            [clj-http.client :as http]
            [clojure.set :refer [rename-keys]]))


(def ^:dynamic *url* "http://localhost:5000/v1/envs/")
;; TODO switch to `with-gym-server` macro?


(defn create-env!
  "Create instance of environment."
  [env-id]
  (-> (http/post *url* {:content-type :json :accept :json
                        :body (json/generate-string {:env_id env-id})})
      :body
      (json/parse-string true)
      :instance_id))


(defn envs
  "Returns all running environments."
  []
  (-> (http/get *url*)
      :body
      json/parse-string
      (get "all_envs")))


(defn reset-env!
  "Reset environment and return initial observation."
  [instance-id]
  (-> (http/post (str *url* instance-id "/reset/")
                 {:content-type :json :accept :json})
      :body
      (json/parse-string true)))


(defn step!
  "Step though environment using action.
  Returns map with keys `observation` `reward` `done` `info`"
  ([instance-id action] (step! instance-id action false))
  ([^String instance-id ^Integer action {:keys [render?] :as opts}]
   (-> (http/post (str *url* instance-id "/step/")
                  {:content-type :json :accept :json
                   :body (json/generate-string {:action action
                                                :render render?})})
       :body
       (json/parse-string true))))


(defn action-space
  "Name and dimensions/bounds of action_space."
  [instance-id]
  (-> (http/get (str *url* instance-id "/action_space/"))
      :body
      (json/parse-string true)
      :info))


(defn action-space-sample
  "Name and dimensions/bounds of action_space."
  [instance-id]
  (-> (http/get (str *url* instance-id "/action_space/sample"))
      :body
      (json/parse-string true)))


(defn observation-space
  "Name and dimensions/bounds of observation_space."
  [instance-id]
  (-> (http/get (str *url* instance-id "/observation_space/"))
      :body
      (json/parse-string true)
      :info))


(defn start-monitor!
  [instance-id {:keys [directory force? resume?]
                :or {directory "/tmp/openai-gym/monitor"}
                :as opts}]
  (-> (http/post (str *url* instance-id "/monitor/start/")
                 {:content-type :json :accept :json
                  :body (json/generate-string (rename-keys opts
                                                           {:force? :force
                                                            :resume? :resume}))})
      :body
      (json/parse-string true)))


(defn close-monitor!
  "Flush monitor data to disk."
  [instance-id]
  (-> (http/post (str *url* instance-id "/monitor/close/")
                 {:content-type :json :accept :json})
      :body
      (json/parse-string true)))


;; TODO implement `upload`
;; TODO implement `shutdown`?


(comment
  ;; start an environment
  (create-env! (environment/ids :cart-pole-v1))

  ;; what environments have we created?
  (envs)

  (reset-env! (key (first (envs))))

  (step! (key (first (envs))) 0)

  ;; get the spaces of some random environment
  ((juxt identity action-space observation-space) (rand-nth (keys (envs))))

  (action-space-sample (key (first (envs))))
  
  (close-monitor! (key (first (envs))))

  
  ;;;; copying the minimal Python sample:
  ;; env = gym.make('CartPole-v0')
  ;; env.reset()
  ;; for _ in range(1000):
  ;;   env.render()
  ;;   env.step(env.action_space.sample()) # take a random action
  ;; env.close()

  (let [id (create-env! "CartPole-v1")  ; I used the Stringy env ID here.
                                        ; Could've also used `(environment/ids :cart-pole-v1)`.
        num-actions (:n (action-space id))]
    (start-monitor! id {:directory "/tmp/monitor"
                        :force? true})
    (reset-env! id)
    (dotimes [x 1000]
      (println "step #" x)
      ;; TODO break out if `done` in last run
      (step! id (rand-int num-actions) {:render? true}))
    (close-monitor! id))
  
  )
