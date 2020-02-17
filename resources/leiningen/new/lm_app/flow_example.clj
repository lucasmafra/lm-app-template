(ns flows.example
  (:require [flows.aux.init :refer [defflow]]
            [state-flow.assertions.matcher-combinators :refer [match?]]
            [state-flow.core :as state-flow :refer [flow]]))

(defflow example
  (flow "fixme"
     (match? 1 0)))
