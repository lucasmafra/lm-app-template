(ns dev
  (:require [com.stuartsierra.component :as component]
            [com.stuartsierra.component.repl :refer [set-init start stop reset]]
            [common-clj.components.config.in-memory-config :as imc]
            [{{sanitized}}.system :refer [system]]))

(def config
  {:app-name :{{raw-name}}})

(def dev-system
  (merge system
         (component/system-map
          :config (imc/new-config config :dev))))

(set-init (constantly dev-system))
