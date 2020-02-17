(ns flows.aux.init
  (:require [{{raw-name}}.system :refer [system]]
            [com.stuartsierra.component :as component]
            [common-clj.components.config.edn-config :as edn-config]
            [schema.core :as s]
            [state-flow.cljtest :as state-flow.cljtest]
            [state-flow.core :as state-flow]))

(def test-system
  (merge system
         (component/system-map
          :config (edn-config/new-config :test))))

(defn init! [world]
  (let [started (component/start test-system)]
    (assoc world :system started)))

(defn run!*
  [flow state]
  (s/with-fn-validation (state-flow/run! flow state)))

(defmacro defflow
  [name & flows]
  `(state-flow.cljtest/defflow ~name {:init   #(init! {})
                                      :runner run!*}
                               ~@flows))
