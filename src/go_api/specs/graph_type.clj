(ns go-api.specs.graph-type
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def graph-type-data
  {
   })

(def graph-type-spec
  (ds/spec
    {:name ::graph-type
     :spec graph-type-data}))
