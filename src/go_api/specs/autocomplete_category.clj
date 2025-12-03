(ns go-api.specs.autocomplete-category
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def autocomplete-category-data
  {
   })

(def autocomplete-category-spec
  (ds/spec
    {:name ::autocomplete-category
     :spec autocomplete-category-data}))
