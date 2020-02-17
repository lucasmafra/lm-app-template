(ns {{raw-name}}.system
  (:gen-class)
  (:require [com.stuartsierra.component :as component]
            [common-clj.components.config.edn-config :as edn-config]))

(def app-deps [])

(def system
  (component/system-map
   :config            (edn-config/new-config)))

(def -main (partial component/start system))
