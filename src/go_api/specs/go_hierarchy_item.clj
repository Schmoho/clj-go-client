(ns go-api.specs.go-hierarchy-item
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def go-hierarchy-item-data
  {
   (ds/req :GO) string?
   (ds/req :label) string?
   (ds/req :hierarchy) string?
   })

(def go-hierarchy-item-spec
  (ds/spec
    {:name ::go-hierarchy-item
     :spec go-hierarchy-item-data}))
