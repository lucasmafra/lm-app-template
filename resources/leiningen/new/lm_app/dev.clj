(ns dev
  (:require [com.stuartsierra.component :as component]
            [com.stuartsierra.component.repl :refer [set-init start stop reset]]
            [{{sanitized}}.system :refer [system]]))

(set-init (constantly system))
