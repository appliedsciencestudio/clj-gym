(ns clj-gym.environments
  (:require [camel-snake-kebab.core :as csk]
            [clojure.string :as string]))

(comment
  
  ;; from https://github.com/openai/gym/wiki/Table-of-environments
  (into {} (mapv (juxt (comp keyword
                     #(string/replace % #"-v-" "-v")
                     csk/->kebab-case)
               identity)
         ["MountainCar-v0"
          "MountainCarContinuous-v0"
          "Pendulum-v0"
          "CartPole-v0"
          "CartPole-v1"
          "Acrobot-v1"
          "LunarLander-v2"
          "LunarLanderContinuous-v2"
          "MemorizeDigits-v0"
          "BipedalWalker-v2"
          "BipedalWalkerHardcore-v2"
          "CubeCrash-v0"
          "CubeCrashSparse-v0"
          "CubeCrashScreenBecomesBlack-v0"
          "CarRacing-v0"
          "Adventure-ram-v0"
          "Adventure-ram-v4"
          "Adventure-ramDeterministic-v0"
          "Adventure-ramDeterministic-v4"
          "Adventure-ramNoFrameskip-v0"
          "Adventure-ramNoFrameskip-v4"
          "AirRaid-ram-v0"
          "AirRaid-ram-v4"
          "AirRaid-ramDeterministic-v0"
          "AirRaid-ramDeterministic-v4"
          "AirRaid-ramNoFrameskip-v0"
          "AirRaid-ramNoFrameskip-v4"
          "Alien-ram-v0"
          "Alien-ram-v4"
          "Alien-ramDeterministic-v0"
          "Alien-ramDeterministic-v4"
          "Alien-ramNoFrameskip-v0"
          "Alien-ramNoFrameskip-v4"
          "Amidar-ram-v0"
          "Amidar-ram-v4"
          "Amidar-ramDeterministic-v0"
          "Amidar-ramDeterministic-v4"
          "Amidar-ramNoFrameskip-v0"
          "Amidar-ramNoFrameskip-v4"
          "Assault-ram-v0"
          "Assault-ram-v4"
          "Assault-ramDeterministic-v0"
          "Assault-ramDeterministic-v4"
          "Assault-ramNoFrameskip-v0"
          "Assault-ramNoFrameskip-v4"
          "Asterix-ram-v0"
          "Asterix-ram-v4"
          "Asterix-ramDeterministic-v0"
          "Asterix-ramDeterministic-v4"
          "Asterix-ramNoFrameskip-v0"
          "Asterix-ramNoFrameskip-v4"
          "Asteroids-ram-v0"
          "Asteroids-ram-v4"
          "Asteroids-ramDeterministic-v0"
          "Asteroids-ramDeterministic-v4"
          "Asteroids-ramNoFrameskip-v0"
          "Asteroids-ramNoFrameskip-v4"
          "Atlantis-ram-v0"
          "Atlantis-ram-v4"
          "Atlantis-ramDeterministic-v0"
          "Atlantis-ramDeterministic-v4"
          "Atlantis-ramNoFrameskip-v0"
          "Atlantis-ramNoFrameskip-v4"
          "BankHeist-ram-v0"
          "BankHeist-ram-v4"
          "BankHeist-ramDeterministic-v0"
          "BankHeist-ramDeterministic-v4"
          "BankHeist-ramNoFrameskip-v0"
          "BankHeist-ramNoFrameskip-v4"
          "BattleZone-ram-v0"
          "BattleZone-ram-v4"
          "BattleZone-ramDeterministic-v0"
          "BattleZone-ramDeterministic-v4"
          "BattleZone-ramNoFrameskip-v0"
          "BattleZone-ramNoFrameskip-v4"
          "BeamRider-ram-v0"
          "BeamRider-ram-v4"
          "BeamRider-ramDeterministic-v0"
          "BeamRider-ramDeterministic-v4"
          "BeamRider-ramNoFrameskip-v0"
          "BeamRider-ramNoFrameskip-v4"
          "Berzerk-ram-v0"
          "Berzerk-ram-v4"
          "Berzerk-ramDeterministic-v0"
          "Berzerk-ramDeterministic-v4"
          "Berzerk-ramNoFrameskip-v0"
          "Berzerk-ramNoFrameskip-v4"
          "Bowling-ram-v0"
          "Bowling-ram-v4"
          "Bowling-ramDeterministic-v0"
          "Bowling-ramDeterministic-v4"
          "Bowling-ramNoFrameskip-v0"
          "Bowling-ramNoFrameskip-v4"
          "Boxing-ram-v0"
          "Boxing-ram-v4"
          "Boxing-ramDeterministic-v0"
          "Boxing-ramDeterministic-v4"
          "Boxing-ramNoFrameskip-v0"
          "Boxing-ramNoFrameskip-v4"
          "Breakout-ram-v0"
          "Breakout-ram-v4"
          "Breakout-ramDeterministic-v0"
          "Breakout-ramDeterministic-v4"
          "Breakout-ramNoFrameskip-v0"
          "Breakout-ramNoFrameskip-v4"
          "Carnival-ram-v0"
          "Carnival-ram-v4"
          "Carnival-ramDeterministic-v0"
          "Carnival-ramDeterministic-v4"
          "Carnival-ramNoFrameskip-v0"
          "Carnival-ramNoFrameskip-v4"
          "Centipede-ram-v0"
          "Centipede-ram-v4"
          "Centipede-ramDeterministic-v0"
          "Centipede-ramDeterministic-v4"
          "Centipede-ramNoFrameskip-v0"
          "Centipede-ramNoFrameskip-v4"
          "ChopperCommand-ram-v0"
          "ChopperCommand-ram-v4"
          "ChopperCommand-ramDeterministic-v0"
          "ChopperCommand-ramDeterministic-v4"
          "ChopperCommand-ramNoFrameskip-v0"
          "ChopperCommand-ramNoFrameskip-v4"
          "CrazyClimber-ram-v0"
          "CrazyClimber-ram-v4"
          "CrazyClimber-ramDeterministic-v0"
          "CrazyClimber-ramDeterministic-v4"
          "CrazyClimber-ramNoFrameskip-v0"
          "CrazyClimber-ramNoFrameskip-v4"
          "Defender-ram-v0"
          "Defender-ram-v4"
          "Defender-ramDeterministic-v0"
          "Defender-ramDeterministic-v4"
          "Defender-ramNoFrameskip-v0"
          "Defender-ramNoFrameskip-v4"
          "DemonAttack-ram-v0"
          "DemonAttack-ram-v4"
          "DemonAttack-ramDeterministic-v0"
          "DemonAttack-ramDeterministic-v4"
          "DemonAttack-ramNoFrameskip-v0"
          "DemonAttack-ramNoFrameskip-v4"
          "DoubleDunk-ram-v0"
          "DoubleDunk-ram-v4"
          "DoubleDunk-ramDeterministic-v0"
          "DoubleDunk-ramDeterministic-v4"
          "DoubleDunk-ramNoFrameskip-v0"
          "DoubleDunk-ramNoFrameskip-v4"
          "ElevatorAction-ram-v0"
          "ElevatorAction-ram-v4"
          "ElevatorAction-ramDeterministic-v0"
          "ElevatorAction-ramDeterministic-v4"
          "ElevatorAction-ramNoFrameskip-v0"
          "ElevatorAction-ramNoFrameskip-v4"
          "Enduro-ram-v0"
          "Enduro-ram-v4"
          "Enduro-ramDeterministic-v0"
          "Enduro-ramDeterministic-v4"
          "Enduro-ramNoFrameskip-v0"
          "Enduro-ramNoFrameskip-v4"
          "FishingDerby-ram-v0"
          "FishingDerby-ram-v4"
          "FishingDerby-ramDeterministic-v0"
          "FishingDerby-ramDeterministic-v4"
          "FishingDerby-ramNoFrameskip-v0"
          "FishingDerby-ramNoFrameskip-v4"
          "Freeway-ram-v0"
          "Freeway-ram-v4"
          "Freeway-ramDeterministic-v0"
          "Freeway-ramDeterministic-v4"
          "Freeway-ramNoFrameskip-v0"
          "Freeway-ramNoFrameskip-v4"
          "Frostbite-ram-v0"
          "Frostbite-ram-v4"
          "Frostbite-ramDeterministic-v0"
          "Frostbite-ramDeterministic-v4"
          "Frostbite-ramNoFrameskip-v0"
          "Frostbite-ramNoFrameskip-v4"
          "Gopher-ram-v0"
          "Gopher-ram-v4"
          "Gopher-ramDeterministic-v0"
          "Gopher-ramDeterministic-v4"
          "Gopher-ramNoFrameskip-v0"
          "Gopher-ramNoFrameskip-v4"
          "Gravitar-ram-v0"
          "Gravitar-ram-v4"
          "Gravitar-ramDeterministic-v0"
          "Gravitar-ramDeterministic-v4"
          "Gravitar-ramNoFrameskip-v0"
          "Gravitar-ramNoFrameskip-v4"
          "Hero-ram-v0"
          "Hero-ram-v4"
          "Hero-ramDeterministic-v0"
          "Hero-ramDeterministic-v4"
          "Hero-ramNoFrameskip-v0"
          "Hero-ramNoFrameskip-v4"
          "IceHockey-ram-v0"
          "IceHockey-ram-v4"
          "IceHockey-ramDeterministic-v0"
          "IceHockey-ramDeterministic-v4"
          "IceHockey-ramNoFrameskip-v0"
          "IceHockey-ramNoFrameskip-v4"
          "Jamesbond-ram-v0"
          "Jamesbond-ram-v4"
          "Jamesbond-ramDeterministic-v0"
          "Jamesbond-ramDeterministic-v4"
          "Jamesbond-ramNoFrameskip-v0"
          "Jamesbond-ramNoFrameskip-v4"
          "JourneyEscape-ram-v0"
          "JourneyEscape-ram-v4"
          "JourneyEscape-ramDeterministic-v0"
          "JourneyEscape-ramDeterministic-v4"
          "JourneyEscape-ramNoFrameskip-v0"
          "JourneyEscape-ramNoFrameskip-v4"
          "Kangaroo-ram-v0"
          "Kangaroo-ram-v4"
          "Kangaroo-ramDeterministic-v0"
          "Kangaroo-ramDeterministic-v4"
          "Kangaroo-ramNoFrameskip-v0"
          "Kangaroo-ramNoFrameskip-v4"
          "Krull-ram-v0"
          "Krull-ram-v4"
          "Krull-ramDeterministic-v0"
          "Krull-ramDeterministic-v4"
          "Krull-ramNoFrameskip-v0"
          "Krull-ramNoFrameskip-v4"
          "KungFuMaster-ram-v0"
          "KungFuMaster-ram-v4"
          "KungFuMaster-ramDeterministic-v0"
          "KungFuMaster-ramDeterministic-v4"
          "KungFuMaster-ramNoFrameskip-v0"
          "KungFuMaster-ramNoFrameskip-v4"
          "MontezumaRevenge-ram-v0"
          "MontezumaRevenge-ram-v4"
          "MontezumaRevenge-ramDeterministic-v0"
          "MontezumaRevenge-ramDeterministic-v4"
          "MontezumaRevenge-ramNoFrameskip-v0"
          "MontezumaRevenge-ramNoFrameskip-v4"
          "MsPacman-ram-v0"
          "MsPacman-ram-v4"
          "MsPacman-ramDeterministic-v0"
          "MsPacman-ramDeterministic-v4"
          "MsPacman-ramNoFrameskip-v0"
          "MsPacman-ramNoFrameskip-v4"
          "NameThisGame-ram-v0"
          "NameThisGame-ram-v4"
          "NameThisGame-ramDeterministic-v0"
          "NameThisGame-ramDeterministic-v4"
          "NameThisGame-ramNoFrameskip-v0"
          "NameThisGame-ramNoFrameskip-v4"
          "Phoenix-ram-v0"
          "Phoenix-ram-v4"
          "Phoenix-ramDeterministic-v0"
          "Phoenix-ramDeterministic-v4"
          "Phoenix-ramNoFrameskip-v0"
          "Phoenix-ramNoFrameskip-v4"
          "Pitfall-ram-v0"
          "Pitfall-ram-v4"
          "Pitfall-ramDeterministic-v0"
          "Pitfall-ramDeterministic-v4"
          "Pitfall-ramNoFrameskip-v0"
          "Pitfall-ramNoFrameskip-v4"
          "Pong-ram-v0"
          "Pong-ram-v4"
          "Pong-ramDeterministic-v0"
          "Pong-ramDeterministic-v4"
          "Pong-ramNoFrameskip-v0"
          "Pong-ramNoFrameskip-v4"
          "Pooyan-ram-v0"
          "Pooyan-ram-v4"
          "Pooyan-ramDeterministic-v0"
          "Pooyan-ramDeterministic-v4"
          "Pooyan-ramNoFrameskip-v0"
          "Pooyan-ramNoFrameskip-v4"
          "PrivateEye-ram-v0"
          "PrivateEye-ram-v4"
          "PrivateEye-ramDeterministic-v0"
          "PrivateEye-ramDeterministic-v4"
          "PrivateEye-ramNoFrameskip-v0"
          "PrivateEye-ramNoFrameskip-v4"
          "Qbert-ram-v0"
          "Qbert-ram-v4"
          "Qbert-ramDeterministic-v0"
          "Qbert-ramDeterministic-v4"
          "Qbert-ramNoFrameskip-v0"
          "Qbert-ramNoFrameskip-v4"
          "Riverraid-ram-v0"
          "Riverraid-ram-v4"
          "Riverraid-ramDeterministic-v0"
          "Riverraid-ramDeterministic-v4"
          "Riverraid-ramNoFrameskip-v0"
          "Riverraid-ramNoFrameskip-v4"
          "RoadRunner-ram-v0"
          "RoadRunner-ram-v4"
          "RoadRunner-ramDeterministic-v0"
          "RoadRunner-ramDeterministic-v4"
          "RoadRunner-ramNoFrameskip-v0"
          "RoadRunner-ramNoFrameskip-v4"
          "Robotank-ram-v0"
          "Robotank-ram-v4"
          "Robotank-ramDeterministic-v0"
          "Robotank-ramDeterministic-v4"
          "Robotank-ramNoFrameskip-v0"
          "Robotank-ramNoFrameskip-v4"
          "Seaquest-ram-v0"
          "Seaquest-ram-v4"
          "Seaquest-ramDeterministic-v0"
          "Seaquest-ramDeterministic-v4"
          "Seaquest-ramNoFrameskip-v0"
          "Seaquest-ramNoFrameskip-v4"
          "Skiing-ram-v0"
          "Skiing-ram-v4"
          "Skiing-ramDeterministic-v0"
          "Skiing-ramDeterministic-v4"
          "Skiing-ramNoFrameskip-v0"
          "Skiing-ramNoFrameskip-v4"
          "Solaris-ram-v0"
          "Solaris-ram-v4"
          "Solaris-ramDeterministic-v0"
          "Solaris-ramDeterministic-v4"
          "Solaris-ramNoFrameskip-v0"
          "Solaris-ramNoFrameskip-v4"
          "SpaceInvaders-ram-v0"
          "SpaceInvaders-ram-v4"
          "SpaceInvaders-ramDeterministic-v0"
          "SpaceInvaders-ramDeterministic-v4"
          "SpaceInvaders-ramNoFrameskip-v0"
          "SpaceInvaders-ramNoFrameskip-v4"
          "StarGunner-ram-v0"
          "StarGunner-ram-v4"
          "StarGunner-ramDeterministic-v0"
          "StarGunner-ramDeterministic-v4"
          "StarGunner-ramNoFrameskip-v0"
          "StarGunner-ramNoFrameskip-v4"
          "Tennis-ram-v0"
          "Tennis-ram-v4"
          "Tennis-ramDeterministic-v0"
          "Tennis-ramDeterministic-v4"
          "Tennis-ramNoFrameskip-v0"
          "Tennis-ramNoFrameskip-v4"
          "TimePilot-ram-v0"
          "TimePilot-ram-v4"
          "TimePilot-ramDeterministic-v0"
          "TimePilot-ramDeterministic-v4"
          "TimePilot-ramNoFrameskip-v0"
          "TimePilot-ramNoFrameskip-v4"
          "Tutankham-ram-v0"
          "Tutankham-ram-v4"
          "Tutankham-ramDeterministic-v0"
          "Tutankham-ramDeterministic-v4"
          "Tutankham-ramNoFrameskip-v0"
          "Tutankham-ramNoFrameskip-v4"
          "UpNDown-ram-v0"
          "UpNDown-ram-v4"
          "UpNDown-ramDeterministic-v0"
          "UpNDown-ramDeterministic-v4"
          "UpNDown-ramNoFrameskip-v0"
          "UpNDown-ramNoFrameskip-v4"
          "Venture-ram-v0"
          "Venture-ram-v4"
          "Venture-ramDeterministic-v0"
          "Venture-ramDeterministic-v4"
          "Venture-ramNoFrameskip-v0"
          "Venture-ramNoFrameskip-v4"
          "VideoPinball-ram-v0"
          "VideoPinball-ram-v4"
          "VideoPinball-ramDeterministic-v0"
          "VideoPinball-ramDeterministic-v4"
          "VideoPinball-ramNoFrameskip-v0"
          "VideoPinball-ramNoFrameskip-v4"
          "WizardOfWor-ram-v0"
          "WizardOfWor-ram-v4"
          "WizardOfWor-ramDeterministic-v0"
          "WizardOfWor-ramDeterministic-v4"
          "WizardOfWor-ramNoFrameskip-v0"
          "WizardOfWor-ramNoFrameskip-v4"
          "YarsRevenge-ram-v0"
          "YarsRevenge-ram-v4"
          "YarsRevenge-ramDeterministic-v0"
          "YarsRevenge-ramDeterministic-v4"
          "YarsRevenge-ramNoFrameskip-v0"
          "YarsRevenge-ramNoFrameskip-v4"
          "Zaxxon-ram-v0"
          "Zaxxon-ram-v4"
          "Zaxxon-ramDeterministic-v0"
          "Zaxxon-ramDeterministic-v4"
          "Zaxxon-ramNoFrameskip-v0"
          "Zaxxon-ramNoFrameskip-v4"
          "Alien-v0"
          "Alien-v4"
          "AlienDeterministic-v0"
          "AlienDeterministic-v4"
          "AlienNoFrameskip-v0"
          "AlienNoFrameskip-v4"
          "Asterix-v0"
          "Asterix-v4"
          "AsterixDeterministic-v0"
          "AsterixDeterministic-v4"
          "AsterixNoFrameskip-v0"
          "AsterixNoFrameskip-v4"
          "Asteroids-v0"
          "Asteroids-v4"
          "AsteroidsDeterministic-v0"
          "AsteroidsDeterministic-v4"
          "AsteroidsNoFrameskip-v0"
          "AsteroidsNoFrameskip-v4"
          "Atlantis-v0"
          "Atlantis-v4"
          "AtlantisDeterministic-v0"
          "AtlantisDeterministic-v4"
          "AtlantisNoFrameskip-v0"
          "AtlantisNoFrameskip-v4"
          "BattleZone-v0"
          "BattleZone-v4"
          "BattleZoneDeterministic-v0"
          "BattleZoneDeterministic-v4"
          "BattleZoneNoFrameskip-v0"
          "BattleZoneNoFrameskip-v4"
          "BeamRider-v0"
          "BeamRider-v4"
          "BeamRiderDeterministic-v0"
          "BeamRiderDeterministic-v4"
          "BeamRiderNoFrameskip-v0"
          "BeamRiderNoFrameskip-v4"
          "Berzerk-v0"
          "Berzerk-v4"
          "BerzerkDeterministic-v0"
          "BerzerkDeterministic-v4"
          "BerzerkNoFrameskip-v0"
          "BerzerkNoFrameskip-v4"
          "Bowling-v0"
          "Bowling-v4"
          "BowlingDeterministic-v0"
          "BowlingDeterministic-v4"
          "BowlingNoFrameskip-v0"
          "BowlingNoFrameskip-v4"
          "Boxing-v0"
          "Boxing-v4"
          "BoxingDeterministic-v0"
          "BoxingDeterministic-v4"
          "BoxingNoFrameskip-v0"
          "BoxingNoFrameskip-v4"
          "Breakout-v0"
          "Breakout-v4"
          "BreakoutDeterministic-v0"
          "BreakoutDeterministic-v4"
          "BreakoutNoFrameskip-v0"
          "BreakoutNoFrameskip-v4"
          "ChopperCommand-v0"
          "ChopperCommand-v4"
          "ChopperCommandDeterministic-v0"
          "ChopperCommandDeterministic-v4"
          "ChopperCommandNoFrameskip-v0"
          "ChopperCommandNoFrameskip-v4"
          "CrazyClimber-v0"
          "CrazyClimber-v4"
          "CrazyClimberDeterministic-v0"
          "CrazyClimberDeterministic-v4"
          "CrazyClimberNoFrameskip-v0"
          "CrazyClimberNoFrameskip-v4"
          "Defender-v0"
          "Defender-v4"
          "DefenderDeterministic-v0"
          "DefenderDeterministic-v4"
          "DefenderNoFrameskip-v0"
          "DefenderNoFrameskip-v4"
          "DemonAttack-v0"
          "DemonAttack-v4"
          "DemonAttackDeterministic-v0"
          "DemonAttackDeterministic-v4"
          "DemonAttackNoFrameskip-v0"
          "DemonAttackNoFrameskip-v4"
          "ElevatorAction-v0"
          "ElevatorAction-v4"
          "ElevatorActionDeterministic-v0"
          "ElevatorActionDeterministic-v4"
          "ElevatorActionNoFrameskip-v0"
          "ElevatorActionNoFrameskip-v4"
          "Enduro-v0"
          "Enduro-v4"
          "EnduroDeterministic-v0"
          "EnduroDeterministic-v4"
          "EnduroNoFrameskip-v0"
          "EnduroNoFrameskip-v4"
          "FishingDerby-v0"
          "FishingDerby-v4"
          "FishingDerbyDeterministic-v0"
          "FishingDerbyDeterministic-v4"
          "FishingDerbyNoFrameskip-v0"
          "FishingDerbyNoFrameskip-v4"
          "Freeway-v0"
          "Freeway-v4"
          "FreewayDeterministic-v0"
          "FreewayDeterministic-v4"
          "FreewayNoFrameskip-v0"
          "FreewayNoFrameskip-v4"
          "Frostbite-v0"
          "Frostbite-v4"
          "FrostbiteDeterministic-v0"
          "FrostbiteDeterministic-v4"
          "FrostbiteNoFrameskip-v0"
          "FrostbiteNoFrameskip-v4"
          "Gravitar-v0"
          "Gravitar-v4"
          "GravitarDeterministic-v0"
          "GravitarDeterministic-v4"
          "GravitarNoFrameskip-v0"
          "GravitarNoFrameskip-v4"
          "Hero-v0"
          "Hero-v4"
          "HeroDeterministic-v0"
          "HeroDeterministic-v4"
          "HeroNoFrameskip-v0"
          "HeroNoFrameskip-v4"
          "IceHockey-v0"
          "IceHockey-v4"
          "IceHockeyDeterministic-v0"
          "IceHockeyDeterministic-v4"
          "IceHockeyNoFrameskip-v0"
          "IceHockeyNoFrameskip-v4"
          "Jamesbond-v0"
          "Jamesbond-v4"
          "JamesbondDeterministic-v0"
          "JamesbondDeterministic-v4"
          "JamesbondNoFrameskip-v0"
          "JamesbondNoFrameskip-v4"
          "Kangaroo-v0"
          "Kangaroo-v4"
          "KangarooDeterministic-v0"
          "KangarooDeterministic-v4"
          "KangarooNoFrameskip-v0"
          "KangarooNoFrameskip-v4"
          "Krull-v0"
          "Krull-v4"
          "KrullDeterministic-v0"
          "KrullDeterministic-v4"
          "KrullNoFrameskip-v0"
          "KrullNoFrameskip-v4"
          "KungFuMaster-v0"
          "KungFuMaster-v4"
          "KungFuMasterDeterministic-v0"
          "KungFuMasterDeterministic-v4"
          "KungFuMasterNoFrameskip-v0"
          "KungFuMasterNoFrameskip-v4"
          "MontezumaRevenge-v0"
          "MontezumaRevenge-v4"
          "MontezumaRevengeDeterministic-v0"
          "MontezumaRevengeDeterministic-v4"
          "MontezumaRevengeNoFrameskip-v0"
          "MontezumaRevengeNoFrameskip-v4"
          "MsPacman-v0"
          "MsPacman-v4"
          "MsPacmanDeterministic-v0"
          "MsPacmanDeterministic-v4"
          "MsPacmanNoFrameskip-v0"
          "MsPacmanNoFrameskip-v4"
          "NameThisGame-v0"
          "NameThisGame-v4"
          "NameThisGameDeterministic-v0"
          "NameThisGameDeterministic-v4"
          "NameThisGameNoFrameskip-v0"
          "NameThisGameNoFrameskip-v4"
          "Phoenix-v0"
          "Phoenix-v4"
          "PhoenixDeterministic-v0"
          "PhoenixDeterministic-v4"
          "PhoenixNoFrameskip-v0"
          "PhoenixNoFrameskip-v4"
          "Pitfall-v0"
          "Pitfall-v4"
          "PitfallDeterministic-v0"
          "PitfallDeterministic-v4"
          "PitfallNoFrameskip-v0"
          "PitfallNoFrameskip-v4"
          "Pong-v0"
          "Pong-v4"
          "PongDeterministic-v0"
          "PongDeterministic-v4"
          "PongNoFrameskip-v0"
          "PongNoFrameskip-v4"
          "PrivateEye-v0"
          "PrivateEye-v4"
          "PrivateEyeDeterministic-v0"
          "PrivateEyeDeterministic-v4"
          "PrivateEyeNoFrameskip-v0"
          "PrivateEyeNoFrameskip-v4"
          "Qbert-v0"
          "Qbert-v4"
          "QbertDeterministic-v0"
          "QbertDeterministic-v4"
          "QbertNoFrameskip-v0"
          "QbertNoFrameskip-v4"
          "Riverraid-v0"
          "Riverraid-v4"
          "RiverraidDeterministic-v0"
          "RiverraidDeterministic-v4"
          "RiverraidNoFrameskip-v0"
          "RiverraidNoFrameskip-v4"
          "RoadRunner-v0"
          "RoadRunner-v4"
          "RoadRunnerDeterministic-v0"
          "RoadRunnerDeterministic-v4"
          "RoadRunnerNoFrameskip-v0"
          "RoadRunnerNoFrameskip-v4"
          "Robotank-v0"
          "Robotank-v4"
          "RobotankDeterministic-v0"
          "RobotankDeterministic-v4"
          "RobotankNoFrameskip-v0"
          "RobotankNoFrameskip-v4"
          "Seaquest-v0"
          "Seaquest-v4"
          "SeaquestDeterministic-v0"
          "SeaquestDeterministic-v4"
          "SeaquestNoFrameskip-v0"
          "SeaquestNoFrameskip-v4"
          "Solaris-v0"
          "Solaris-v4"
          "SolarisDeterministic-v0"
          "SolarisDeterministic-v4"
          "SolarisNoFrameskip-v0"
          "SolarisNoFrameskip-v4"
          "SpaceInvaders-v0"
          "SpaceInvaders-v4"
          "SpaceInvadersDeterministic-v0"
          "SpaceInvadersDeterministic-v4"
          "SpaceInvadersNoFrameskip-v0"
          "SpaceInvadersNoFrameskip-v4"
          "StarGunner-v0"
          "StarGunner-v4"
          "StarGunnerDeterministic-v0"
          "StarGunnerDeterministic-v4"
          "StarGunnerNoFrameskip-v0"
          "StarGunnerNoFrameskip-v4"
          "TimePilot-v0"
          "TimePilot-v4"
          "TimePilotDeterministic-v0"
          "TimePilotDeterministic-v4"
          "TimePilotNoFrameskip-v0"
          "TimePilotNoFrameskip-v4"
          "UpNDown-v0"
          "UpNDown-v4"
          "UpNDownDeterministic-v0"
          "UpNDownDeterministic-v4"
          "UpNDownNoFrameskip-v0"
          "UpNDownNoFrameskip-v4"
          "Venture-v0"
          "Venture-v4"
          "VentureDeterministic-v0"
          "VentureDeterministic-v4"
          "VentureNoFrameskip-v0"
          "VentureNoFrameskip-v4"
          "YarsRevenge-v0"
          "YarsRevenge-v4"
          "YarsRevengeDeterministic-v0"
          "YarsRevengeDeterministic-v4"
          "YarsRevengeNoFrameskip-v0"
          "YarsRevengeNoFrameskip-v4"
          "Zaxxon-v0"
          "Zaxxon-v4"
          "ZaxxonDeterministic-v0"
          "ZaxxonDeterministic-v4"
          "ZaxxonNoFrameskip-v0"
          "ZaxxonNoFrameskip-v4"
          "JourneyEscape-v0"
          "JourneyEscape-v4"
          "JourneyEscapeDeterministic-v0"
          "JourneyEscapeDeterministic-v4"
          "JourneyEscapeNoFrameskip-v0"
          "JourneyEscapeNoFrameskip-v4"
          "Adventure-v0"
          "Adventure-v4"
          "AdventureDeterministic-v0"
          "AdventureDeterministic-v4"
          "AdventureNoFrameskip-v0"
          "AdventureNoFrameskip-v4"
          "AirRaid-v0"
          "AirRaid-v4"
          "AirRaidDeterministic-v0"
          "AirRaidDeterministic-v4"
          "AirRaidNoFrameskip-v0"
          "AirRaidNoFrameskip-v4"
          "Amidar-v0"
          "Amidar-v4"
          "AmidarDeterministic-v0"
          "AmidarDeterministic-v4"
          "AmidarNoFrameskip-v0"
          "AmidarNoFrameskip-v4"
          "Assault-v0"
          "Assault-v4"
          "AssaultDeterministic-v0"
          "AssaultDeterministic-v4"
          "AssaultNoFrameskip-v0"
          "AssaultNoFrameskip-v4"
          "BankHeist-v0"
          "BankHeist-v4"
          "BankHeistDeterministic-v0"
          "BankHeistDeterministic-v4"
          "BankHeistNoFrameskip-v0"
          "BankHeistNoFrameskip-v4"
          "Carnival-v0"
          "Carnival-v4"
          "CarnivalDeterministic-v0"
          "CarnivalDeterministic-v4"
          "CarnivalNoFrameskip-v0"
          "CarnivalNoFrameskip-v4"
          "Centipede-v0"
          "Centipede-v4"
          "CentipedeDeterministic-v0"
          "CentipedeDeterministic-v4"
          "CentipedeNoFrameskip-v0"
          "CentipedeNoFrameskip-v4"
          "DoubleDunk-v0"
          "DoubleDunk-v4"
          "DoubleDunkDeterministic-v0"
          "DoubleDunkDeterministic-v4"
          "DoubleDunkNoFrameskip-v0"
          "DoubleDunkNoFrameskip-v4"
          "Gopher-v0"
          "Gopher-v4"
          "GopherDeterministic-v0"
          "GopherDeterministic-v4"
          "GopherNoFrameskip-v0"
          "GopherNoFrameskip-v4"
          "Pooyan-v0"
          "Pooyan-v4"
          "PooyanDeterministic-v0"
          "PooyanDeterministic-v4"
          "PooyanNoFrameskip-v0"
          "PooyanNoFrameskip-v4"
          "Skiing-v0"
          "Skiing-v4"
          "SkiingDeterministic-v0"
          "SkiingDeterministic-v4"
          "SkiingNoFrameskip-v0"
          "SkiingNoFrameskip-v4"
          "Tennis-v0"
          "Tennis-v4"
          "TennisDeterministic-v0"
          "TennisDeterministic-v4"
          "TennisNoFrameskip-v0"
          "TennisNoFrameskip-v4"
          "Tutankham-v0"
          "Tutankham-v4"
          "TutankhamDeterministic-v0"
          "TutankhamDeterministic-v4"
          "TutankhamNoFrameskip-v0"
          "TutankhamNoFrameskip-v4"
          "VideoPinball-v0"
          "VideoPinball-v4"
          "VideoPinballDeterministic-v0"
          "VideoPinballDeterministic-v4"
          "VideoPinballNoFrameskip-v0"
          "VideoPinballNoFrameskip-v4"
          "WizardOfWor-v0"
          "WizardOfWor-v4"
          "WizardOfWorDeterministic-v0"
          "WizardOfWorDeterministic-v4"
          "WizardOfWorNoFrameskip-v0"
          "WizardOfWorNoFrameskip-v4"
          "Roulette-v0"
          "Reverse-v0"
          "ReversedAddition-v0"
          "ReversedAddition3-v0"
          "GuessingGame-v0"
          "HotterColder-v0"
          "NChain-v0"
          "Copy-v0"
          "RepeatCopy-v0"
          "DuplicatedInput-v0"
          "FrozenLake-v0"
          "CliffWalking-v0"
          "FrozenLake8x8-v0"
          "Taxi-v2"
          "KellyCoinflipGeneralized-v0"
          "KellyCoinflip-v0"
          "Blackjack-v0"]))

  )


(def ids
  {:up-n-down-ram-deterministic-v0 "UpNDown-ramDeterministic-v0",
   :chopper-command-v4 "ChopperCommand-v4",
   :up-n-down-deterministic-v0 "UpNDownDeterministic-v0",
   :double-dunk-v0 "DoubleDunk-v0",
   :beam-rider-no-frameskip-v0 "BeamRiderNoFrameskip-v0",
   :fishing-derby-v0 "FishingDerby-v0",
   :robotank-ram-no-frameskip-v4 "Robotank-ramNoFrameskip-v4",
   :double-dunk-ram-deterministic-v4 "DoubleDunk-ramDeterministic-v4",
   :bank-heist-no-frameskip-v0 "BankHeistNoFrameskip-v0",
   :demon-attack-v4 "DemonAttack-v4",
   :beam-rider-no-frameskip-v4 "BeamRiderNoFrameskip-v4",
   :berzerk-v4 "Berzerk-v4",
   :venture-ram-no-frameskip-v4 "Venture-ramNoFrameskip-v4",
   :pong-ram-v4 "Pong-ram-v4",
   :asteroids-ram-deterministic-v4 "Asteroids-ramDeterministic-v4",
   :pooyan-ram-v4 "Pooyan-ram-v4",
   :star-gunner-deterministic-v4 "StarGunnerDeterministic-v4",
   :journey-escape-ram-no-frameskip-v0 "JourneyEscape-ramNoFrameskip-v0",
   :alien-v4 "Alien-v4",
   :jamesbond-ram-no-frameskip-v0 "Jamesbond-ramNoFrameskip-v0",
   :kung-fu-master-ram-deterministic-v0 "KungFuMaster-ramDeterministic-v0",
   :enduro-no-frameskip-v0 "EnduroNoFrameskip-v0",
   :pong-no-frameskip-v4 "PongNoFrameskip-v4",
   :up-n-down-ram-no-frameskip-v0 "UpNDown-ramNoFrameskip-v0",
   :chopper-command-ram-deterministic-v0 "ChopperCommand-ramDeterministic-v0",
   :gopher-ram-no-frameskip-v4 "Gopher-ramNoFrameskip-v4",
   :montezuma-revenge-no-frameskip-v0 "MontezumaRevengeNoFrameskip-v0",
   :tennis-ram-v0 "Tennis-ram-v0",
   :breakout-ram-v0 "Breakout-ram-v0",
   :riverraid-ram-v0 "Riverraid-ram-v0",
   :beam-rider-v0 "BeamRider-v0",
   :ice-hockey-ram-deterministic-v4 "IceHockey-ramDeterministic-v4",
   :phoenix-ram-deterministic-v0 "Phoenix-ramDeterministic-v0",
   :name-this-game-ram-deterministic-v4 "NameThisGame-ramDeterministic-v4",
   :enduro-ram-v4 "Enduro-ram-v4",
   :yars-revenge-v0 "YarsRevenge-v0",
   :name-this-game-deterministic-v0 "NameThisGameDeterministic-v0",
   :ice-hockey-v0 "IceHockey-v0",
   :riverraid-v0 "Riverraid-v0",
   :up-n-down-no-frameskip-v0 "UpNDownNoFrameskip-v0",
   :name-this-game-ram-no-frameskip-v4 "NameThisGame-ramNoFrameskip-v4",
   :ms-pacman-no-frameskip-v0 "MsPacmanNoFrameskip-v0",
   :bowling-deterministic-v0 "BowlingDeterministic-v0",
   :solaris-v0 "Solaris-v0",
   :venture-ram-deterministic-v0 "Venture-ramDeterministic-v0",
   :gopher-ram-no-frameskip-v0 "Gopher-ramNoFrameskip-v0",
   :assault-v0 "Assault-v0",
   :tutankham-ram-deterministic-v0 "Tutankham-ramDeterministic-v0",
   :asterix-ram-deterministic-v4 "Asterix-ramDeterministic-v4",
   :freeway-v0 "Freeway-v0",
   :alien-ram-no-frameskip-v0 "Alien-ramNoFrameskip-v0",
   :gravitar-deterministic-v0 "GravitarDeterministic-v0",
   :ms-pacman-v4 "MsPacman-v4",
   :solaris-ram-v4 "Solaris-ram-v4",
   :pooyan-no-frameskip-v4 "PooyanNoFrameskip-v4",
   :asterix-v4 "Asterix-v4",
   :air-raid-ram-deterministic-v0 "AirRaid-ramDeterministic-v0",
   :ice-hockey-v4 "IceHockey-v4",
   :boxing-ram-v4 "Boxing-ram-v4",
   :hero-no-frameskip-v0 "HeroNoFrameskip-v0",
   :solaris-no-frameskip-v4 "SolarisNoFrameskip-v4",
   :kangaroo-ram-v4 "Kangaroo-ram-v4",
   :tennis-deterministic-v4 "TennisDeterministic-v4",
   :centipede-v4 "Centipede-v4",
   :car-racing-v0 "CarRacing-v0",
   :pong-v0 "Pong-v0",
   :amidar-deterministic-v4 "AmidarDeterministic-v4",
   :adventure-deterministic-v4 "AdventureDeterministic-v4",
   :solaris-ram-deterministic-v4 "Solaris-ramDeterministic-v4",
   :solaris-ram-no-frameskip-v0 "Solaris-ramNoFrameskip-v0",
   :adventure-ram-deterministic-v4 "Adventure-ramDeterministic-v4",
   :jamesbond-deterministic-v0 "JamesbondDeterministic-v0",
   :kung-fu-master-no-frameskip-v4 "KungFuMasterNoFrameskip-v4",
   :time-pilot-ram-no-frameskip-v0 "TimePilot-ramNoFrameskip-v0",
   :phoenix-ram-no-frameskip-v4 "Phoenix-ramNoFrameskip-v4",
   :journey-escape-deterministic-v0 "JourneyEscapeDeterministic-v0",
   :air-raid-no-frameskip-v0 "AirRaidNoFrameskip-v0",
   :boxing-no-frameskip-v0 "BoxingNoFrameskip-v0",
   :demon-attack-deterministic-v4 "DemonAttackDeterministic-v4",
   :frozen-lake-v0 "FrozenLake-v0",
   :fishing-derby-ram-no-frameskip-v0 "FishingDerby-ramNoFrameskip-v0",
   :robotank-deterministic-v0 "RobotankDeterministic-v0",
   :pitfall-no-frameskip-v4 "PitfallNoFrameskip-v4",
   :kelly-coinflip-generalized-v0 "KellyCoinflipGeneralized-v0",
   :breakout-ram-v4 "Breakout-ram-v4",
   :zaxxon-no-frameskip-v4 "ZaxxonNoFrameskip-v4",
   :ms-pacman-ram-deterministic-v4 "MsPacman-ramDeterministic-v4",
   :battle-zone-ram-v0 "BattleZone-ram-v0",
   :robotank-ram-v0 "Robotank-ram-v0",
   :battle-zone-no-frameskip-v0 "BattleZoneNoFrameskip-v0",
   :centipede-ram-v0 "Centipede-ram-v0",
   :riverraid-ram-no-frameskip-v4 "Riverraid-ramNoFrameskip-v4",
   :time-pilot-ram-deterministic-v4 "TimePilot-ramDeterministic-v4",
   :yars-revenge-deterministic-v0 "YarsRevengeDeterministic-v0",
   :bipedal-walker-v2 "BipedalWalker-v2",
   :demon-attack-ram-v4 "DemonAttack-ram-v4",
   :pong-ram-v0 "Pong-ram-v0",
   :solaris-no-frameskip-v0 "SolarisNoFrameskip-v0",
   :hero-ram-v4 "Hero-ram-v4",
   :wizard-of-wor-deterministic-v4 "WizardOfWorDeterministic-v4",
   :freeway-ram-deterministic-v4 "Freeway-ramDeterministic-v4",
   :tutankham-ram-v0 "Tutankham-ram-v0",
   :robotank-v0 "Robotank-v0",
   :space-invaders-deterministic-v4 "SpaceInvadersDeterministic-v4",
   :freeway-no-frameskip-v0 "FreewayNoFrameskip-v0",
   :krull-deterministic-v4 "KrullDeterministic-v4",
   :asterix-ram-v4 "Asterix-ram-v4",
   :crazy-climber-v0 "CrazyClimber-v0",
   :demon-attack-v0 "DemonAttack-v0",
   :pooyan-ram-no-frameskip-v4 "Pooyan-ramNoFrameskip-v4",
   :hero-ram-no-frameskip-v0 "Hero-ramNoFrameskip-v0",
   :defender-ram-v0 "Defender-ram-v0",
   :atlantis-ram-v4 "Atlantis-ram-v4",
   :kangaroo-ram-deterministic-v4 "Kangaroo-ramDeterministic-v4",
   :jamesbond-v4 "Jamesbond-v4",
   :carnival-no-frameskip-v0 "CarnivalNoFrameskip-v0",
   :tennis-no-frameskip-v0 "TennisNoFrameskip-v0",
   :seaquest-v0 "Seaquest-v0",
   :zaxxon-v0 "Zaxxon-v0",
   :zaxxon-ram-no-frameskip-v4 "Zaxxon-ramNoFrameskip-v4",
   :space-invaders-ram-v4 "SpaceInvaders-ram-v4",
   :gopher-ram-deterministic-v0 "Gopher-ramDeterministic-v0",
   :crazy-climber-ram-v0 "CrazyClimber-ram-v0",
   :star-gunner-ram-no-frameskip-v0 "StarGunner-ramNoFrameskip-v0",
   :pong-deterministic-v0 "PongDeterministic-v0",
   :demon-attack-ram-deterministic-v0 "DemonAttack-ramDeterministic-v0",
   :air-raid-deterministic-v0 "AirRaidDeterministic-v0",
   :cliff-walking-v0 "CliffWalking-v0",
   :zaxxon-ram-v4 "Zaxxon-ram-v4",
   :gravitar-deterministic-v4 "GravitarDeterministic-v4",
   :pong-ram-deterministic-v0 "Pong-ramDeterministic-v0",
   :battle-zone-deterministic-v0 "BattleZoneDeterministic-v0",
   :gravitar-v0 "Gravitar-v0",
   :gopher-no-frameskip-v0 "GopherNoFrameskip-v0",
   :copy-v0 "Copy-v0",
   :assault-ram-no-frameskip-v0 "Assault-ramNoFrameskip-v0",
   :asteroids-ram-v4 "Asteroids-ram-v4",
   :ms-pacman-deterministic-v0 "MsPacmanDeterministic-v0",
   :up-n-down-ram-v0 "UpNDown-ram-v0",
   :name-this-game-ram-v4 "NameThisGame-ram-v4",
   :pitfall-no-frameskip-v0 "PitfallNoFrameskip-v0",
   :amidar-ram-deterministic-v4 "Amidar-ramDeterministic-v4",
   :bowling-deterministic-v4 "BowlingDeterministic-v4",
   :hero-ram-v0 "Hero-ram-v0",
   :pooyan-ram-no-frameskip-v0 "Pooyan-ramNoFrameskip-v0",
   :space-invaders-ram-no-frameskip-v4 "SpaceInvaders-ramNoFrameskip-v4",
   :hero-ram-deterministic-v0 "Hero-ramDeterministic-v0",
   :riverraid-ram-deterministic-v4 "Riverraid-ramDeterministic-v4",
   :alien-no-frameskip-v0 "AlienNoFrameskip-v0",
   :asteroids-ram-no-frameskip-v0 "Asteroids-ramNoFrameskip-v0",
   :pong-ram-no-frameskip-v0 "Pong-ramNoFrameskip-v0",
   :alien-v0 "Alien-v0",
   :berzerk-ram-v0 "Berzerk-ram-v0",
   :freeway-ram-v4 "Freeway-ram-v4",
   :yars-revenge-no-frameskip-v0 "YarsRevengeNoFrameskip-v0",
   :bank-heist-deterministic-v0 "BankHeistDeterministic-v0",
   :krull-ram-v0 "Krull-ram-v0",
   :atlantis-ram-no-frameskip-v4 "Atlantis-ramNoFrameskip-v4",
   :bowling-ram-deterministic-v4 "Bowling-ramDeterministic-v4",
   :atlantis-deterministic-v4 "AtlantisDeterministic-v4",
   :zaxxon-ram-deterministic-v0 "Zaxxon-ramDeterministic-v0",
   :pitfall-ram-v4 "Pitfall-ram-v4",
   :atlantis-ram-v0 "Atlantis-ram-v0",
   :wizard-of-wor-ram-v4 "WizardOfWor-ram-v4",
   :berzerk-ram-v4 "Berzerk-ram-v4",
   :journey-escape-no-frameskip-v4 "JourneyEscapeNoFrameskip-v4",
   :boxing-ram-no-frameskip-v0 "Boxing-ramNoFrameskip-v0",
   :asterix-no-frameskip-v4 "AsterixNoFrameskip-v4",
   :double-dunk-ram-no-frameskip-v0 "DoubleDunk-ramNoFrameskip-v0",
   :defender-ram-deterministic-v0 "Defender-ramDeterministic-v0",
   :double-dunk-ram-v4 "DoubleDunk-ram-v4",
   :demon-attack-no-frameskip-v0 "DemonAttackNoFrameskip-v0",
   :gravitar-ram-deterministic-v0 "Gravitar-ramDeterministic-v0",
   :reversed-addition-3-v0 "ReversedAddition3-v0",
   :chopper-command-ram-deterministic-v4 "ChopperCommand-ramDeterministic-v4",
   :hotter-colder-v0 "HotterColder-v0",
   :time-pilot-v4 "TimePilot-v4",
   :pooyan-deterministic-v0 "PooyanDeterministic-v0",
   :jamesbond-ram-v4 "Jamesbond-ram-v4",
   :chopper-command-deterministic-v0 "ChopperCommandDeterministic-v0",
   :riverraid-ram-no-frameskip-v0 "Riverraid-ramNoFrameskip-v0",
   :asterix-v0 "Asterix-v0",
   :video-pinball-ram-v4 "VideoPinball-ram-v4",
   :bowling-no-frameskip-v4 "BowlingNoFrameskip-v4",
   :private-eye-no-frameskip-v4 "PrivateEyeNoFrameskip-v4",
   :battle-zone-v4 "BattleZone-v4",
   :skiing-ram-v4 "Skiing-ram-v4",
   :adventure-no-frameskip-v0 "AdventureNoFrameskip-v0",
   :gopher-ram-v0 "Gopher-ram-v0",
   :fishing-derby-ram-deterministic-v4 "FishingDerby-ramDeterministic-v4",
   :time-pilot-deterministic-v0 "TimePilotDeterministic-v0",
   :berzerk-v0 "Berzerk-v0",
   :star-gunner-ram-deterministic-v4 "StarGunner-ramDeterministic-v4",
   :berzerk-no-frameskip-v0 "BerzerkNoFrameskip-v0",
   :ice-hockey-ram-v0 "IceHockey-ram-v0",
   :amidar-ram-v4 "Amidar-ram-v4",
   :boxing-ram-deterministic-v0 "Boxing-ramDeterministic-v0",
   :carnival-deterministic-v0 "CarnivalDeterministic-v0",
   :alien-ram-deterministic-v0 "Alien-ramDeterministic-v0",
   :adventure-no-frameskip-v4 "AdventureNoFrameskip-v4",
   :guessing-game-v0 "GuessingGame-v0",
   :video-pinball-ram-no-frameskip-v4 "VideoPinball-ramNoFrameskip-v4",
   :battle-zone-deterministic-v4 "BattleZoneDeterministic-v4",
   :memorize-digits-v0 "MemorizeDigits-v0",
   :pitfall-ram-no-frameskip-v0 "Pitfall-ramNoFrameskip-v0",
   :alien-ram-v4 "Alien-ram-v4",
   :defender-deterministic-v0 "DefenderDeterministic-v0",
   :time-pilot-ram-deterministic-v0 "TimePilot-ramDeterministic-v0",
   :venture-ram-no-frameskip-v0 "Venture-ramNoFrameskip-v0",
   :double-dunk-no-frameskip-v0 "DoubleDunkNoFrameskip-v0",
   :defender-ram-deterministic-v4 "Defender-ramDeterministic-v4",
   :berzerk-deterministic-v0 "BerzerkDeterministic-v0",
   :amidar-ram-deterministic-v0 "Amidar-ramDeterministic-v0",
   :frostbite-ram-deterministic-v4 "Frostbite-ramDeterministic-v4",
   :fishing-derby-no-frameskip-v0 "FishingDerbyNoFrameskip-v0",
   :journey-escape-ram-v0 "JourneyEscape-ram-v0",
   :amidar-v4 "Amidar-v4",
   :space-invaders-no-frameskip-v0 "SpaceInvadersNoFrameskip-v0",
   :frostbite-no-frameskip-v0 "FrostbiteNoFrameskip-v0",
   :enduro-v4 "Enduro-v4",
   :seaquest-ram-v0 "Seaquest-ram-v0",
   :journey-escape-ram-v4 "JourneyEscape-ram-v4",
   :berzerk-ram-deterministic-v4 "Berzerk-ramDeterministic-v4",
   :amidar-deterministic-v0 "AmidarDeterministic-v0",
   :pitfall-deterministic-v0 "PitfallDeterministic-v0",
   :assault-ram-v4 "Assault-ram-v4",
   :kung-fu-master-ram-no-frameskip-v4 "KungFuMaster-ramNoFrameskip-v4",
   :pooyan-ram-deterministic-v4 "Pooyan-ramDeterministic-v4",
   :chopper-command-ram-no-frameskip-v4 "ChopperCommand-ramNoFrameskip-v4",
   :enduro-ram-no-frameskip-v4 "Enduro-ramNoFrameskip-v4",
   :solaris-ram-deterministic-v0 "Solaris-ramDeterministic-v0",
   :bank-heist-v4 "BankHeist-v4",
   :riverraid-no-frameskip-v4 "RiverraidNoFrameskip-v4",
   :tutankham-ram-no-frameskip-v4 "Tutankham-ramNoFrameskip-v4",
   :adventure-deterministic-v0 "AdventureDeterministic-v0",
   :montezuma-revenge-deterministic-v0 "MontezumaRevengeDeterministic-v0",
   :yars-revenge-ram-deterministic-v4 "YarsRevenge-ramDeterministic-v4",
   :phoenix-deterministic-v4 "PhoenixDeterministic-v4",
   :road-runner-no-frameskip-v0 "RoadRunnerNoFrameskip-v0",
   :bowling-v0 "Bowling-v0",
   :demon-attack-ram-no-frameskip-v0 "DemonAttack-ramNoFrameskip-v0",
   :video-pinball-deterministic-v4 "VideoPinballDeterministic-v4",
   :lunar-lander-v2 "LunarLander-v2",
   :qbert-ram-v4 "Qbert-ram-v4",
   :bowling-ram-deterministic-v0 "Bowling-ramDeterministic-v0",
   :air-raid-ram-v4 "AirRaid-ram-v4",
   :tutankham-no-frameskip-v0 "TutankhamNoFrameskip-v0",
   :tutankham-ram-no-frameskip-v0 "Tutankham-ramNoFrameskip-v0",
   :tennis-ram-v4 "Tennis-ram-v4",
   :phoenix-ram-v4 "Phoenix-ram-v4",
   :ms-pacman-deterministic-v4 "MsPacmanDeterministic-v4",
   :time-pilot-v0 "TimePilot-v0",
   :alien-ram-deterministic-v4 "Alien-ramDeterministic-v4",
   :double-dunk-ram-no-frameskip-v4 "DoubleDunk-ramNoFrameskip-v4",
   :centipede-ram-no-frameskip-v4 "Centipede-ramNoFrameskip-v4",
   :riverraid-ram-deterministic-v0 "Riverraid-ramDeterministic-v0",
   :pong-ram-deterministic-v4 "Pong-ramDeterministic-v4",
   :solaris-ram-no-frameskip-v4 "Solaris-ramNoFrameskip-v4",
   :up-n-down-deterministic-v4 "UpNDownDeterministic-v4",
   :assault-ram-v0 "Assault-ram-v0",
   :gopher-ram-v4 "Gopher-ram-v4",
   :gravitar-no-frameskip-v4 "GravitarNoFrameskip-v4",
   :centipede-no-frameskip-v4 "CentipedeNoFrameskip-v4",
   :kung-fu-master-deterministic-v0 "KungFuMasterDeterministic-v0",
   :defender-no-frameskip-v0 "DefenderNoFrameskip-v0",
   :seaquest-v4 "Seaquest-v4",
   :jamesbond-ram-deterministic-v0 "Jamesbond-ramDeterministic-v0",
   :star-gunner-ram-v0 "StarGunner-ram-v0",
   :venture-ram-deterministic-v4 "Venture-ramDeterministic-v4",
   :reverse-v0 "Reverse-v0",
   :journey-escape-no-frameskip-v0 "JourneyEscapeNoFrameskip-v0",
   :kung-fu-master-ram-no-frameskip-v0 "KungFuMaster-ramNoFrameskip-v0",
   :air-raid-v4 "AirRaid-v4",
   :atlantis-ram-deterministic-v0 "Atlantis-ramDeterministic-v0",
   :battle-zone-ram-no-frameskip-v0 "BattleZone-ramNoFrameskip-v0",
   :name-this-game-ram-v0 "NameThisGame-ram-v0",
   :star-gunner-v0 "StarGunner-v0",
   :road-runner-ram-deterministic-v4 "RoadRunner-ramDeterministic-v4",
   :adventure-ram-v4 "Adventure-ram-v4",
   :pooyan-v0 "Pooyan-v0",
   :gopher-deterministic-v0 "GopherDeterministic-v0",
   :demon-attack-no-frameskip-v4 "DemonAttackNoFrameskip-v4",
   :time-pilot-no-frameskip-v4 "TimePilotNoFrameskip-v4",
   :carnival-v0 "Carnival-v0",
   :krull-v0 "Krull-v0",
   :defender-ram-no-frameskip-v4 "Defender-ramNoFrameskip-v4",
   :qbert-deterministic-v4 "QbertDeterministic-v4",
   :elevator-action-no-frameskip-v0 "ElevatorActionNoFrameskip-v0",
   :asterix-ram-no-frameskip-v4 "Asterix-ramNoFrameskip-v4",
   :up-n-down-no-frameskip-v4 "UpNDownNoFrameskip-v4",
   :krull-ram-v4 "Krull-ram-v4",
   :wizard-of-wor-ram-no-frameskip-v4 "WizardOfWor-ramNoFrameskip-v4",
   :skiing-ram-v0 "Skiing-ram-v0",
   :jamesbond-no-frameskip-v0 "JamesbondNoFrameskip-v0",
   :seaquest-ram-deterministic-v0 "Seaquest-ramDeterministic-v0",
   :adventure-ram-no-frameskip-v0 "Adventure-ramNoFrameskip-v0",
   :carnival-no-frameskip-v4 "CarnivalNoFrameskip-v4",
   :tennis-deterministic-v0 "TennisDeterministic-v0",
   :phoenix-no-frameskip-v4 "PhoenixNoFrameskip-v4",
   :skiing-no-frameskip-v4 "SkiingNoFrameskip-v4",
   :private-eye-deterministic-v4 "PrivateEyeDeterministic-v4",
   :krull-ram-no-frameskip-v4 "Krull-ramNoFrameskip-v4",
   :air-raid-ram-deterministic-v4 "AirRaid-ramDeterministic-v4",
   :zaxxon-ram-no-frameskip-v0 "Zaxxon-ramNoFrameskip-v0",
   :skiing-v0 "Skiing-v0",
   :frozen-lake-8x-8-v0 "FrozenLake8x8-v0",
   :asteroids-ram-no-frameskip-v4 "Asteroids-ramNoFrameskip-v4",
   :breakout-ram-deterministic-v0 "Breakout-ramDeterministic-v0",
   :bowling-ram-v0 "Bowling-ram-v0",
   :ice-hockey-deterministic-v0 "IceHockeyDeterministic-v0",
   :breakout-ram-deterministic-v4 "Breakout-ramDeterministic-v4",
   :adventure-ram-v0 "Adventure-ram-v0",
   :video-pinball-v0 "VideoPinball-v0",
   :demon-attack-deterministic-v0 "DemonAttackDeterministic-v0",
   :hero-v4 "Hero-v4",
   :jamesbond-ram-deterministic-v4 "Jamesbond-ramDeterministic-v4",
   :qbert-no-frameskip-v4 "QbertNoFrameskip-v4",
   :qbert-v4 "Qbert-v4",
   :hero-no-frameskip-v4 "HeroNoFrameskip-v4",
   :breakout-v4 "Breakout-v4",
   :breakout-v0 "Breakout-v0",
   :ms-pacman-no-frameskip-v4 "MsPacmanNoFrameskip-v4",
   :gopher-v0 "Gopher-v0",
   :carnival-ram-v0 "Carnival-ram-v0",
   :crazy-climber-no-frameskip-v4 "CrazyClimberNoFrameskip-v4",
   :n-chain-v0 "NChain-v0",
   :assault-v4 "Assault-v4",
   :atlantis-v0 "Atlantis-v0",
   :elevator-action-ram-deterministic-v0 "ElevatorAction-ramDeterministic-v0",
   :double-dunk-v4 "DoubleDunk-v4",
   :taxi-v2 "Taxi-v2",
   :frostbite-ram-no-frameskip-v0 "Frostbite-ramNoFrameskip-v0",
   :yars-revenge-ram-no-frameskip-v0 "YarsRevenge-ramNoFrameskip-v0",
   :hero-ram-no-frameskip-v4 "Hero-ramNoFrameskip-v4",
   :blackjack-v0 "Blackjack-v0",
   :kung-fu-master-ram-v4 "KungFuMaster-ram-v4",
   :bowling-ram-v4 "Bowling-ram-v4",
   :ice-hockey-ram-no-frameskip-v0 "IceHockey-ramNoFrameskip-v0",
   :chopper-command-ram-no-frameskip-v0 "ChopperCommand-ramNoFrameskip-v0",
   :fishing-derby-ram-v4 "FishingDerby-ram-v4",
   :venture-no-frameskip-v4 "VentureNoFrameskip-v4",
   :wizard-of-wor-deterministic-v0 "WizardOfWorDeterministic-v0",
   :fishing-derby-v4 "FishingDerby-v4",
   :private-eye-v0 "PrivateEye-v0",
   :asterix-ram-deterministic-v0 "Asterix-ramDeterministic-v0",
   :assault-no-frameskip-v0 "AssaultNoFrameskip-v0",
   :jamesbond-no-frameskip-v4 "JamesbondNoFrameskip-v4",
   :road-runner-ram-v0 "RoadRunner-ram-v0",
   :kung-fu-master-no-frameskip-v0 "KungFuMasterNoFrameskip-v0",
   :adventure-v0 "Adventure-v0",
   :beam-rider-ram-v4 "BeamRider-ram-v4",
   :name-this-game-deterministic-v4 "NameThisGameDeterministic-v4",
   :elevator-action-v4 "ElevatorAction-v4",
   :enduro-deterministic-v4 "EnduroDeterministic-v4",
   :assault-deterministic-v0 "AssaultDeterministic-v0",
   :bank-heist-deterministic-v4 "BankHeistDeterministic-v4",
   :elevator-action-ram-no-frameskip-v0 "ElevatorAction-ramNoFrameskip-v0",
   :venture-ram-v0 "Venture-ram-v0",
   :skiing-deterministic-v4 "SkiingDeterministic-v4",
   :robotank-ram-no-frameskip-v0 "Robotank-ramNoFrameskip-v0",
   :montezuma-revenge-no-frameskip-v4 "MontezumaRevengeNoFrameskip-v4",
   :zaxxon-deterministic-v0 "ZaxxonDeterministic-v0",
   :cart-pole-v0 "CartPole-v0",
   :road-runner-ram-no-frameskip-v0 "RoadRunner-ramNoFrameskip-v0",
   :bank-heist-v0 "BankHeist-v0",
   :robotank-deterministic-v4 "RobotankDeterministic-v4",
   :amidar-no-frameskip-v4 "AmidarNoFrameskip-v4",
   :fishing-derby-no-frameskip-v4 "FishingDerbyNoFrameskip-v4",
   :freeway-ram-deterministic-v0 "Freeway-ramDeterministic-v0",
   :cube-crash-screen-becomes-black-v0 "CubeCrashScreenBecomesBlack-v0",
   :robotank-no-frameskip-v4 "RobotankNoFrameskip-v4",
   :phoenix-v4 "Phoenix-v4",
   :beam-rider-ram-deterministic-v0 "BeamRider-ramDeterministic-v0",
   :defender-no-frameskip-v4 "DefenderNoFrameskip-v4",
   :asteroids-v0 "Asteroids-v0",
   :enduro-ram-no-frameskip-v0 "Enduro-ramNoFrameskip-v0",
   :ms-pacman-ram-deterministic-v0 "MsPacman-ramDeterministic-v0",
   :kangaroo-v4 "Kangaroo-v4",
   :ice-hockey-ram-no-frameskip-v4 "IceHockey-ramNoFrameskip-v4",
   :yars-revenge-ram-v0 "YarsRevenge-ram-v0",
   :hero-ram-deterministic-v4 "Hero-ramDeterministic-v4",
   :road-runner-deterministic-v4 "RoadRunnerDeterministic-v4",
   :carnival-deterministic-v4 "CarnivalDeterministic-v4",
   :asteroids-no-frameskip-v0 "AsteroidsNoFrameskip-v0",
   :gravitar-ram-no-frameskip-v4 "Gravitar-ramNoFrameskip-v4",
   :venture-deterministic-v0 "VentureDeterministic-v0",
   :carnival-ram-no-frameskip-v4 "Carnival-ramNoFrameskip-v4",
   :tennis-ram-no-frameskip-v0 "Tennis-ramNoFrameskip-v0",
   :road-runner-ram-deterministic-v0 "RoadRunner-ramDeterministic-v0",
   :hero-v0 "Hero-v0",
   :enduro-no-frameskip-v4 "EnduroNoFrameskip-v4",
   :crazy-climber-ram-no-frameskip-v0 "CrazyClimber-ramNoFrameskip-v0",
   :pooyan-deterministic-v4 "PooyanDeterministic-v4",
   :krull-no-frameskip-v4 "KrullNoFrameskip-v4",
   :video-pinball-ram-v0 "VideoPinball-ram-v0",
   :gravitar-ram-v0 "Gravitar-ram-v0",
   :solaris-deterministic-v0 "SolarisDeterministic-v0",
   :zaxxon-ram-v0 "Zaxxon-ram-v0",
   :boxing-deterministic-v0 "BoxingDeterministic-v0",
   :berzerk-no-frameskip-v4 "BerzerkNoFrameskip-v4",
   :centipede-v0 "Centipede-v0",
   :gopher-v4 "Gopher-v4",
   :elevator-action-v0 "ElevatorAction-v0",
   :bowling-v4 "Bowling-v4",
   :private-eye-ram-deterministic-v4 "PrivateEye-ramDeterministic-v4",
   :skiing-ram-deterministic-v0 "Skiing-ramDeterministic-v0",
   :crazy-climber-v4 "CrazyClimber-v4",
   :berzerk-ram-no-frameskip-v0 "Berzerk-ramNoFrameskip-v0",
   :qbert-deterministic-v0 "QbertDeterministic-v0",
   :carnival-ram-deterministic-v0 "Carnival-ramDeterministic-v0",
   :asteroids-deterministic-v0 "AsteroidsDeterministic-v0",
   :chopper-command-no-frameskip-v0 "ChopperCommandNoFrameskip-v0",
   :boxing-ram-deterministic-v4 "Boxing-ramDeterministic-v4",
   :freeway-ram-v0 "Freeway-ram-v0",
   :hero-deterministic-v4 "HeroDeterministic-v4",
   :qbert-ram-deterministic-v0 "Qbert-ramDeterministic-v0",
   :star-gunner-ram-v4 "StarGunner-ram-v4",
   :boxing-ram-no-frameskip-v4 "Boxing-ramNoFrameskip-v4",
   :mountain-car-continuous-v0 "MountainCarContinuous-v0",
   :jamesbond-v0 "Jamesbond-v0",
   :tennis-ram-deterministic-v0 "Tennis-ramDeterministic-v0",
   :robotank-v4 "Robotank-v4",
   :seaquest-deterministic-v0 "SeaquestDeterministic-v0",
   :time-pilot-ram-no-frameskip-v4 "TimePilot-ramNoFrameskip-v4",
   :elevator-action-deterministic-v0 "ElevatorActionDeterministic-v0",
   :centipede-deterministic-v4 "CentipedeDeterministic-v4",
   :mountain-car-v0 "MountainCar-v0",
   :asterix-ram-no-frameskip-v0 "Asterix-ramNoFrameskip-v0",
   :montezuma-revenge-v0 "MontezumaRevenge-v0",
   :bank-heist-ram-v4 "BankHeist-ram-v4",
   :gravitar-ram-v4 "Gravitar-ram-v4",
   :star-gunner-deterministic-v0 "StarGunnerDeterministic-v0",
   :riverraid-deterministic-v4 "RiverraidDeterministic-v4",
   :phoenix-deterministic-v0 "PhoenixDeterministic-v0",
   :breakout-deterministic-v4 "BreakoutDeterministic-v4",
   :breakout-no-frameskip-v4 "BreakoutNoFrameskip-v4",
   :carnival-ram-v4 "Carnival-ram-v4",
   :private-eye-ram-deterministic-v0 "PrivateEye-ramDeterministic-v0",
   :boxing-ram-v0 "Boxing-ram-v0",
   :cart-pole-v1 "CartPole-v1",
   :name-this-game-no-frameskip-v4 "NameThisGameNoFrameskip-v4",
   :battle-zone-ram-v4 "BattleZone-ram-v4",
   :defender-v0 "Defender-v0",
   :amidar-ram-no-frameskip-v0 "Amidar-ramNoFrameskip-v0",
   :frostbite-no-frameskip-v4 "FrostbiteNoFrameskip-v4",
   :assault-deterministic-v4 "AssaultDeterministic-v4",
   :asterix-ram-v0 "Asterix-ram-v0",
   :frostbite-ram-v4 "Frostbite-ram-v4",
   :seaquest-ram-deterministic-v4 "Seaquest-ramDeterministic-v4",
   :kung-fu-master-v0 "KungFuMaster-v0",
   :elevator-action-deterministic-v4 "ElevatorActionDeterministic-v4",
   :venture-deterministic-v4 "VentureDeterministic-v4",
   :space-invaders-v4 "SpaceInvaders-v4",
   :reversed-addition-v0 "ReversedAddition-v0",
   :assault-no-frameskip-v4 "AssaultNoFrameskip-v4",
   :kangaroo-ram-v0 "Kangaroo-ram-v0",
   :montezuma-revenge-deterministic-v4 "MontezumaRevengeDeterministic-v4",
   :tutankham-ram-deterministic-v4 "Tutankham-ramDeterministic-v4",
   :video-pinball-ram-deterministic-v4 "VideoPinball-ramDeterministic-v4",
   :asteroids-deterministic-v4 "AsteroidsDeterministic-v4",
   :fishing-derby-ram-v0 "FishingDerby-ram-v0",
   :venture-ram-v4 "Venture-ram-v4",
   :battle-zone-v0 "BattleZone-v0",
   :frostbite-deterministic-v0 "FrostbiteDeterministic-v0",
   :phoenix-ram-v0 "Phoenix-ram-v0",
   :atlantis-ram-deterministic-v4 "Atlantis-ramDeterministic-v4",
   :robotank-ram-deterministic-v4 "Robotank-ramDeterministic-v4",
   :ms-pacman-ram-no-frameskip-v4 "MsPacman-ramNoFrameskip-v4",
   :video-pinball-deterministic-v0 "VideoPinballDeterministic-v0",
   :kangaroo-ram-no-frameskip-v0 "Kangaroo-ramNoFrameskip-v0",
   :pong-v4 "Pong-v4",
   :star-gunner-no-frameskip-v4 "StarGunnerNoFrameskip-v4",
   :journey-escape-ram-no-frameskip-v4 "JourneyEscape-ramNoFrameskip-v4",
   :crazy-climber-ram-deterministic-v0 "CrazyClimber-ramDeterministic-v0",
   :private-eye-deterministic-v0 "PrivateEyeDeterministic-v0",
   :tennis-ram-no-frameskip-v4 "Tennis-ramNoFrameskip-v4",
   :beam-rider-ram-no-frameskip-v4 "BeamRider-ramNoFrameskip-v4",
   :venture-v4 "Venture-v4",
   :skiing-deterministic-v0 "SkiingDeterministic-v0",
   :star-gunner-ram-no-frameskip-v4 "StarGunner-ramNoFrameskip-v4",
   :phoenix-no-frameskip-v0 "PhoenixNoFrameskip-v0",
   :montezuma-revenge-ram-v0 "MontezumaRevenge-ram-v0",
   :wizard-of-wor-ram-deterministic-v0 "WizardOfWor-ramDeterministic-v0",
   :beam-rider-v4 "BeamRider-v4",
   :freeway-ram-no-frameskip-v0 "Freeway-ramNoFrameskip-v0",
   :venture-v0 "Venture-v0",
   :asteroids-ram-deterministic-v0 "Asteroids-ramDeterministic-v0",
   :zaxxon-deterministic-v4 "ZaxxonDeterministic-v4",
   :pitfall-ram-deterministic-v0 "Pitfall-ramDeterministic-v0",
   :montezuma-revenge-v4 "MontezumaRevenge-v4",
   :breakout-ram-no-frameskip-v4 "Breakout-ramNoFrameskip-v4",
   :bank-heist-ram-no-frameskip-v0 "BankHeist-ramNoFrameskip-v0",
   :double-dunk-no-frameskip-v4 "DoubleDunkNoFrameskip-v4",
   :crazy-climber-deterministic-v4 "CrazyClimberDeterministic-v4",
   :private-eye-no-frameskip-v0 "PrivateEyeNoFrameskip-v0",
   :time-pilot-deterministic-v4 "TimePilotDeterministic-v4",
   :yars-revenge-ram-deterministic-v0 "YarsRevenge-ramDeterministic-v0",
   :riverraid-v4 "Riverraid-v4",
   :ice-hockey-ram-deterministic-v0 "IceHockey-ramDeterministic-v0",
   :jamesbond-ram-no-frameskip-v4 "Jamesbond-ramNoFrameskip-v4",
   :double-dunk-deterministic-v0 "DoubleDunkDeterministic-v0",
   :space-invaders-no-frameskip-v4 "SpaceInvadersNoFrameskip-v4",
   :road-runner-v0 "RoadRunner-v0",
   :space-invaders-v0 "SpaceInvaders-v0",
   :bowling-no-frameskip-v0 "BowlingNoFrameskip-v0",
   :breakout-ram-no-frameskip-v0 "Breakout-ramNoFrameskip-v0",
   :berzerk-ram-no-frameskip-v4 "Berzerk-ramNoFrameskip-v4",
   :ice-hockey-deterministic-v4 "IceHockeyDeterministic-v4",
   :boxing-no-frameskip-v4 "BoxingNoFrameskip-v4",
   :carnival-ram-deterministic-v4 "Carnival-ramDeterministic-v4",
   :video-pinball-ram-no-frameskip-v0 "VideoPinball-ramNoFrameskip-v0",
   :yars-revenge-v4 "YarsRevenge-v4",
   :beam-rider-deterministic-v0 "BeamRiderDeterministic-v0",
   :centipede-no-frameskip-v0 "CentipedeNoFrameskip-v0",
   :freeway-no-frameskip-v4 "FreewayNoFrameskip-v4",
   :skiing-ram-no-frameskip-v4 "Skiing-ramNoFrameskip-v4",
   :atlantis-ram-no-frameskip-v0 "Atlantis-ramNoFrameskip-v0",
   :solaris-deterministic-v4 "SolarisDeterministic-v4",
   :up-n-down-ram-no-frameskip-v4 "UpNDown-ramNoFrameskip-v4",
   :tennis-v0 "Tennis-v0",
   :alien-ram-v0 "Alien-ram-v0",
   :bank-heist-ram-deterministic-v0 "BankHeist-ramDeterministic-v0",
   :adventure-ram-no-frameskip-v4 "Adventure-ramNoFrameskip-v4",
   :bowling-ram-no-frameskip-v0 "Bowling-ramNoFrameskip-v0",
   :asterix-deterministic-v4 "AsterixDeterministic-v4",
   :skiing-v4 "Skiing-v4",
   :asteroids-v4 "Asteroids-v4",
   :pooyan-ram-v0 "Pooyan-ram-v0",
   :centipede-ram-v4 "Centipede-ram-v4",
   :tutankham-v0 "Tutankham-v0",
   :defender-ram-no-frameskip-v0 "Defender-ramNoFrameskip-v0",
   :pong-deterministic-v4 "PongDeterministic-v4",
   :adventure-v4 "Adventure-v4",
   :wizard-of-wor-ram-deterministic-v4 "WizardOfWor-ramDeterministic-v4",
   :battle-zone-ram-deterministic-v4 "BattleZone-ramDeterministic-v4",
   :assault-ram-deterministic-v4 "Assault-ramDeterministic-v4",
   :seaquest-ram-no-frameskip-v0 "Seaquest-ramNoFrameskip-v0",
   :freeway-ram-no-frameskip-v4 "Freeway-ramNoFrameskip-v4",
   :ms-pacman-ram-no-frameskip-v0 "MsPacman-ramNoFrameskip-v0",
   :private-eye-v4 "PrivateEye-v4",
   :seaquest-ram-no-frameskip-v4 "Seaquest-ramNoFrameskip-v4",
   :montezuma-revenge-ram-v4 "MontezumaRevenge-ram-v4",
   :amidar-no-frameskip-v0 "AmidarNoFrameskip-v0",
   :demon-attack-ram-v0 "DemonAttack-ram-v0",
   :zaxxon-v4 "Zaxxon-v4",
   :road-runner-no-frameskip-v4 "RoadRunnerNoFrameskip-v4",
   :video-pinball-v4 "VideoPinball-v4",
   :journey-escape-ram-deterministic-v0 "JourneyEscape-ramDeterministic-v0",
   :phoenix-ram-deterministic-v4 "Phoenix-ramDeterministic-v4",
   :space-invaders-ram-deterministic-v4 "SpaceInvaders-ramDeterministic-v4",
   :qbert-ram-no-frameskip-v0 "Qbert-ramNoFrameskip-v0",
   :cube-crash-v0 "CubeCrash-v0",
   :krull-no-frameskip-v0 "KrullNoFrameskip-v0",
   :krull-deterministic-v0 "KrullDeterministic-v0",
   :tennis-v4 "Tennis-v4",
   :defender-v4 "Defender-v4",
   :wizard-of-wor-no-frameskip-v0 "WizardOfWorNoFrameskip-v0",
   :kung-fu-master-v4 "KungFuMaster-v4",
   :enduro-v0 "Enduro-v0",
   :amidar-ram-no-frameskip-v4 "Amidar-ramNoFrameskip-v4",
   :tutankham-deterministic-v4 "TutankhamDeterministic-v4",
   :tutankham-no-frameskip-v4 "TutankhamNoFrameskip-v4",
   :pitfall-ram-deterministic-v4 "Pitfall-ramDeterministic-v4",
   :ms-pacman-ram-v4 "MsPacman-ram-v4",
   :gopher-no-frameskip-v4 "GopherNoFrameskip-v4",
   :pendulum-v0 "Pendulum-v0",
   :elevator-action-ram-v4 "ElevatorAction-ram-v4",
   :gravitar-no-frameskip-v0 "GravitarNoFrameskip-v0",
   :gopher-ram-deterministic-v4 "Gopher-ramDeterministic-v4",
   :enduro-ram-v0 "Enduro-ram-v0",
   :kangaroo-no-frameskip-v4 "KangarooNoFrameskip-v4",
   :montezuma-revenge-ram-deterministic-v4 "MontezumaRevenge-ramDeterministic-v4",
   :frostbite-v4 "Frostbite-v4",
   :cube-crash-sparse-v0 "CubeCrashSparse-v0",
   :tutankham-deterministic-v0 "TutankhamDeterministic-v0",
   :robotank-ram-v4 "Robotank-ram-v4",
   :chopper-command-no-frameskip-v4 "ChopperCommandNoFrameskip-v4",
   :bank-heist-ram-deterministic-v4 "BankHeist-ramDeterministic-v4",
   :name-this-game-v4 "NameThisGame-v4",
   :kangaroo-v0 "Kangaroo-v0",
   :qbert-no-frameskip-v0 "QbertNoFrameskip-v0",
   :gravitar-ram-no-frameskip-v0 "Gravitar-ramNoFrameskip-v0",
   :alien-no-frameskip-v4 "AlienNoFrameskip-v4",
   :atlantis-deterministic-v0 "AtlantisDeterministic-v0",
   :space-invaders-ram-deterministic-v0 "SpaceInvaders-ramDeterministic-v0",
   :carnival-ram-no-frameskip-v0 "Carnival-ramNoFrameskip-v0",
   :qbert-v0 "Qbert-v0",
   :wizard-of-wor-v4 "WizardOfWor-v4",
   :tutankham-v4 "Tutankham-v4",
   :chopper-command-v0 "ChopperCommand-v0",
   :elevator-action-ram-v0 "ElevatorAction-ram-v0",
   :enduro-ram-deterministic-v0 "Enduro-ramDeterministic-v0",
   :riverraid-deterministic-v0 "RiverraidDeterministic-v0",
   :wizard-of-wor-ram-no-frameskip-v0 "WizardOfWor-ramNoFrameskip-v0",
   :centipede-deterministic-v0 "CentipedeDeterministic-v0",
   :road-runner-ram-v4 "RoadRunner-ram-v4",
   :robotank-no-frameskip-v0 "RobotankNoFrameskip-v0",
   :air-raid-no-frameskip-v4 "AirRaidNoFrameskip-v4",
   :road-runner-deterministic-v0 "RoadRunnerDeterministic-v0",
   :bank-heist-ram-no-frameskip-v4 "BankHeist-ramNoFrameskip-v4",
   :acrobot-v1 "Acrobot-v1",
   :freeway-deterministic-v4 "FreewayDeterministic-v4",
   :kangaroo-ram-deterministic-v0 "Kangaroo-ramDeterministic-v0",
   :zaxxon-no-frameskip-v0 "ZaxxonNoFrameskip-v0",
   :yars-revenge-no-frameskip-v4 "YarsRevengeNoFrameskip-v4",
   :double-dunk-ram-v0 "DoubleDunk-ram-v0",
   :ice-hockey-no-frameskip-v4 "IceHockeyNoFrameskip-v4",
   :private-eye-ram-no-frameskip-v0 "PrivateEye-ramNoFrameskip-v0",
   :seaquest-no-frameskip-v0 "SeaquestNoFrameskip-v0",
   :kangaroo-ram-no-frameskip-v4 "Kangaroo-ramNoFrameskip-v4",
   :elevator-action-no-frameskip-v4 "ElevatorActionNoFrameskip-v4",
   :tennis-ram-deterministic-v4 "Tennis-ramDeterministic-v4",
   :up-n-down-v4 "UpNDown-v4",
   :private-eye-ram-v4 "PrivateEye-ram-v4",
   :name-this-game-ram-no-frameskip-v0 "NameThisGame-ramNoFrameskip-v0",
   :air-raid-ram-no-frameskip-v0 "AirRaid-ramNoFrameskip-v0",
   :star-gunner-no-frameskip-v0 "StarGunnerNoFrameskip-v0",
   :ms-pacman-ram-v0 "MsPacman-ram-v0",
   :pooyan-ram-deterministic-v0 "Pooyan-ramDeterministic-v0",
   :beam-rider-ram-no-frameskip-v0 "BeamRider-ramNoFrameskip-v0",
   :up-n-down-ram-deterministic-v4 "UpNDown-ramDeterministic-v4",
   :amidar-ram-v0 "Amidar-ram-v0",
   :venture-no-frameskip-v0 "VentureNoFrameskip-v0",
   :demon-attack-ram-no-frameskip-v4 "DemonAttack-ramNoFrameskip-v4",
   :freeway-v4 "Freeway-v4",
   :centipede-ram-no-frameskip-v0 "Centipede-ramNoFrameskip-v0",
   :private-eye-ram-v0 "PrivateEye-ram-v0",
   :fishing-derby-deterministic-v4 "FishingDerbyDeterministic-v4",
   :pitfall-ram-v0 "Pitfall-ram-v0",
   :ms-pacman-v0 "MsPacman-v0",
   :name-this-game-ram-deterministic-v0 "NameThisGame-ramDeterministic-v0",
   :frostbite-ram-no-frameskip-v4 "Frostbite-ramNoFrameskip-v4",
   :boxing-v0 "Boxing-v0",
   :crazy-climber-deterministic-v0 "CrazyClimberDeterministic-v0",
   :krull-ram-deterministic-v4 "Krull-ramDeterministic-v4",
   :robotank-ram-deterministic-v0 "Robotank-ramDeterministic-v0",
   :breakout-no-frameskip-v0 "BreakoutNoFrameskip-v0",
   :road-runner-v4 "RoadRunner-v4",
   :gravitar-v4 "Gravitar-v4",
   :elevator-action-ram-no-frameskip-v4 "ElevatorAction-ramNoFrameskip-v4",
   :frostbite-deterministic-v4 "FrostbiteDeterministic-v4",
   :bank-heist-no-frameskip-v4 "BankHeistNoFrameskip-v4",
   :defender-ram-v4 "Defender-ram-v4",
   :time-pilot-no-frameskip-v0 "TimePilotNoFrameskip-v0",
   :kung-fu-master-ram-v0 "KungFuMaster-ram-v0",
   :air-raid-deterministic-v4 "AirRaidDeterministic-v4",
   :time-pilot-ram-v4 "TimePilot-ram-v4",
   :gravitar-ram-deterministic-v4 "Gravitar-ramDeterministic-v4",
   :boxing-v4 "Boxing-v4",
   :crazy-climber-ram-v4 "CrazyClimber-ram-v4",
   :krull-v4 "Krull-v4",
   :assault-ram-no-frameskip-v4 "Assault-ramNoFrameskip-v4",
   :space-invaders-deterministic-v0 "SpaceInvadersDeterministic-v0",
   :riverraid-no-frameskip-v0 "RiverraidNoFrameskip-v0",
   :frostbite-v0 "Frostbite-v0",
   :phoenix-v0 "Phoenix-v0",
   :fishing-derby-ram-no-frameskip-v4 "FishingDerby-ramNoFrameskip-v4",
   :solaris-ram-v0 "Solaris-ram-v0",
   :skiing-ram-deterministic-v4 "Skiing-ramDeterministic-v4",
   :breakout-deterministic-v0 "BreakoutDeterministic-v0",
   :atlantis-v4 "Atlantis-v4",
   :repeat-copy-v0 "RepeatCopy-v0",
   :ice-hockey-ram-v4 "IceHockey-ram-v4",
   :crazy-climber-ram-no-frameskip-v4 "CrazyClimber-ramNoFrameskip-v4",
   :frostbite-ram-v0 "Frostbite-ram-v0",
   :crazy-climber-no-frameskip-v0 "CrazyClimberNoFrameskip-v0",
   :asterix-deterministic-v0 "AsterixDeterministic-v0",
   :tutankham-ram-v4 "Tutankham-ram-v4",
   :star-gunner-ram-deterministic-v0 "StarGunner-ramDeterministic-v0",
   :krull-ram-no-frameskip-v0 "Krull-ramNoFrameskip-v0",
   :kangaroo-no-frameskip-v0 "KangarooNoFrameskip-v0",
   :time-pilot-ram-v0 "TimePilot-ram-v0",
   :frostbite-ram-deterministic-v0 "Frostbite-ramDeterministic-v0",
   :space-invaders-ram-no-frameskip-v0 "SpaceInvaders-ramNoFrameskip-v0",
   :enduro-ram-deterministic-v4 "Enduro-ramDeterministic-v4",
   :carnival-v4 "Carnival-v4",
   :beam-rider-ram-deterministic-v4 "BeamRider-ramDeterministic-v4",
   :jamesbond-deterministic-v4 "JamesbondDeterministic-v4",
   :bipedal-walker-hardcore-v2 "BipedalWalkerHardcore-v2",
   :phoenix-ram-no-frameskip-v0 "Phoenix-ramNoFrameskip-v0",
   :name-this-game-v0 "NameThisGame-v0",
   :wizard-of-wor-ram-v0 "WizardOfWor-ram-v0",
   :double-dunk-ram-deterministic-v0 "DoubleDunk-ramDeterministic-v0",
   :pong-ram-no-frameskip-v4 "Pong-ramNoFrameskip-v4",
   :riverraid-ram-v4 "Riverraid-ram-v4",
   :battle-zone-no-frameskip-v4 "BattleZoneNoFrameskip-v4",
   :alien-deterministic-v0 "AlienDeterministic-v0",
   :road-runner-ram-no-frameskip-v4 "RoadRunner-ramNoFrameskip-v4",
   :pitfall-deterministic-v4 "PitfallDeterministic-v4",
   :fishing-derby-deterministic-v0 "FishingDerbyDeterministic-v0",
   :video-pinball-ram-deterministic-v0 "VideoPinball-ramDeterministic-v0",
   :beam-rider-ram-v0 "BeamRider-ram-v0",
   :fishing-derby-ram-deterministic-v0 "FishingDerby-ramDeterministic-v0",
   :chopper-command-ram-v0 "ChopperCommand-ram-v0",
   :atlantis-no-frameskip-v0 "AtlantisNoFrameskip-v0",
   :pitfall-ram-no-frameskip-v4 "Pitfall-ramNoFrameskip-v4",
   :up-n-down-v0 "UpNDown-v0",
   :seaquest-deterministic-v4 "SeaquestDeterministic-v4",
   :amidar-v0 "Amidar-v0",
   :pooyan-v4 "Pooyan-v4",
   :hero-deterministic-v0 "HeroDeterministic-v0",
   :journey-escape-v4 "JourneyEscape-v4",
   :battle-zone-ram-no-frameskip-v4 "BattleZone-ramNoFrameskip-v4",
   :yars-revenge-deterministic-v4 "YarsRevengeDeterministic-v4",
   :name-this-game-no-frameskip-v0 "NameThisGameNoFrameskip-v0",
   :tennis-no-frameskip-v4 "TennisNoFrameskip-v4",
   :crazy-climber-ram-deterministic-v4 "CrazyClimber-ramDeterministic-v4",
   :alien-ram-no-frameskip-v4 "Alien-ramNoFrameskip-v4",
   :elevator-action-ram-deterministic-v4 "ElevatorAction-ramDeterministic-v4",
   :double-dunk-deterministic-v4 "DoubleDunkDeterministic-v4",
   :up-n-down-ram-v4 "UpNDown-ram-v4",
   :assault-ram-deterministic-v0 "Assault-ramDeterministic-v0",
   :kelly-coinflip-v0 "KellyCoinflip-v0",
   :freeway-deterministic-v0 "FreewayDeterministic-v0",
   :adventure-ram-deterministic-v0 "Adventure-ramDeterministic-v0",
   :krull-ram-deterministic-v0 "Krull-ramDeterministic-v0",
   :bank-heist-ram-v0 "BankHeist-ram-v0",
   :asteroids-ram-v0 "Asteroids-ram-v0",
   :qbert-ram-no-frameskip-v4 "Qbert-ramNoFrameskip-v4",
   :pooyan-no-frameskip-v0 "PooyanNoFrameskip-v0",
   :pitfall-v0 "Pitfall-v0",
   :skiing-ram-no-frameskip-v0 "Skiing-ramNoFrameskip-v0",
   :atlantis-no-frameskip-v4 "AtlantisNoFrameskip-v4",
   :enduro-deterministic-v0 "EnduroDeterministic-v0",
   :yars-revenge-ram-v4 "YarsRevenge-ram-v4",
   :montezuma-revenge-ram-no-frameskip-v0 "MontezumaRevenge-ramNoFrameskip-v0",
   :roulette-v0 "Roulette-v0",
   :montezuma-revenge-ram-no-frameskip-v4 "MontezumaRevenge-ramNoFrameskip-v4",
   :asteroids-no-frameskip-v4 "AsteroidsNoFrameskip-v4",
   :kangaroo-deterministic-v0 "KangarooDeterministic-v0",
   :alien-deterministic-v4 "AlienDeterministic-v4",
   :beam-rider-deterministic-v4 "BeamRiderDeterministic-v4",
   :defender-deterministic-v4 "DefenderDeterministic-v4",
   :asterix-no-frameskip-v0 "AsterixNoFrameskip-v0",
   :duplicated-input-v0 "DuplicatedInput-v0",
   :kangaroo-deterministic-v4 "KangarooDeterministic-v4",
   :kung-fu-master-deterministic-v4 "KungFuMasterDeterministic-v4",
   :seaquest-no-frameskip-v4 "SeaquestNoFrameskip-v4",
   :qbert-ram-v0 "Qbert-ram-v0",
   :air-raid-ram-no-frameskip-v4 "AirRaid-ramNoFrameskip-v4",
   :yars-revenge-ram-no-frameskip-v4 "YarsRevenge-ramNoFrameskip-v4",
   :centipede-ram-deterministic-v0 "Centipede-ramDeterministic-v0",
   :bowling-ram-no-frameskip-v4 "Bowling-ramNoFrameskip-v4",
   :solaris-v4 "Solaris-v4",
   :video-pinball-no-frameskip-v4 "VideoPinballNoFrameskip-v4",
   :journey-escape-ram-deterministic-v4 "JourneyEscape-ramDeterministic-v4",
   :lunar-lander-continuous-v2 "LunarLanderContinuous-v2",
   :berzerk-deterministic-v4 "BerzerkDeterministic-v4",
   :gopher-deterministic-v4 "GopherDeterministic-v4",
   :montezuma-revenge-ram-deterministic-v0 "MontezumaRevenge-ramDeterministic-v0",
   :wizard-of-wor-v0 "WizardOfWor-v0",
   :chopper-command-deterministic-v4 "ChopperCommandDeterministic-v4",
   :chopper-command-ram-v4 "ChopperCommand-ram-v4",
   :centipede-ram-deterministic-v4 "Centipede-ramDeterministic-v4",
   :journey-escape-deterministic-v4 "JourneyEscapeDeterministic-v4",
   :video-pinball-no-frameskip-v0 "VideoPinballNoFrameskip-v0",
   :journey-escape-v0 "JourneyEscape-v0",
   :star-gunner-v4 "StarGunner-v4",
   :berzerk-ram-deterministic-v0 "Berzerk-ramDeterministic-v0",
   :battle-zone-ram-deterministic-v0 "BattleZone-ramDeterministic-v0",
   :boxing-deterministic-v4 "BoxingDeterministic-v4",
   :pitfall-v4 "Pitfall-v4",
   :zaxxon-ram-deterministic-v4 "Zaxxon-ramDeterministic-v4",
   :wizard-of-wor-no-frameskip-v4 "WizardOfWorNoFrameskip-v4",
   :seaquest-ram-v4 "Seaquest-ram-v4",
   :qbert-ram-deterministic-v4 "Qbert-ramDeterministic-v4",
   :ice-hockey-no-frameskip-v0 "IceHockeyNoFrameskip-v0",
   :private-eye-ram-no-frameskip-v4 "PrivateEye-ramNoFrameskip-v4",
   :pong-no-frameskip-v0 "PongNoFrameskip-v0",
   :space-invaders-ram-v0 "SpaceInvaders-ram-v0",
   :air-raid-v0 "AirRaid-v0",
   :demon-attack-ram-deterministic-v4 "DemonAttack-ramDeterministic-v4",
   :air-raid-ram-v0 "AirRaid-ram-v0",
   :kung-fu-master-ram-deterministic-v4 "KungFuMaster-ramDeterministic-v4",
   :jamesbond-ram-v0 "Jamesbond-ram-v0",
   :skiing-no-frameskip-v0 "SkiingNoFrameskip-v0"})
