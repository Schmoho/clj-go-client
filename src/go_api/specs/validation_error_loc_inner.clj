(ns go-api.specs.validation-error-loc-inner
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def validation-error-loc-inner-data
  {
   })

(def validation-error-loc-inner-spec
  (ds/spec
    {:name ::validation-error-loc-inner
     :spec validation-error-loc-inner-data}))
