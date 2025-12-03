(ns go-api.specs.app-routers-bioentity-relationship-type
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def app-routers-bioentity-relationship-type-data
  {
   })

(def app-routers-bioentity-relationship-type-spec
  (ds/spec
    {:name ::app-routers-bioentity-relationship-type
     :spec app-routers-bioentity-relationship-type-data}))
