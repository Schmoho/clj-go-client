(ns go-api.specs.app-routers-slimmer-relationship-type
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def app-routers-slimmer-relationship-type-data
  {
   })

(def app-routers-slimmer-relationship-type-spec
  (ds/spec
    {:name ::app-routers-slimmer-relationship-type
     :spec app-routers-slimmer-relationship-type-data}))
