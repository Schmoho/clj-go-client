(ns go-api.api.bioentityset-slimmer
  (:require [go-api.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [go-api.specs.graph-type :refer :all]
            [go-api.specs.autocomplete-category :refer :all]
            [go-api.specs.validation-error :refer :all]
            [go-api.specs.http-validation-error :refer :all]
            [go-api.specs.app-routers-slimmer-relationship-type :refer :all]
            [go-api.specs.validation-error-loc-inner :refer :all]
            [go-api.specs.go-hierarchy-item :refer :all]
            [go-api.specs.app-routers-bioentity-relationship-type :refer :all]
            )
  (:import (java.io File)))


(defn-spec slimmer-function-api-bioentityset-slimmer-function-get-with-http-info any?
  "Slimmer Function
  For a given gene(s), summarize its annotations over a defined set of slim."
  ([subject (s/coll-of string?), slim (s/coll-of string?), ] (slimmer-function-api-bioentityset-slimmer-function-get-with-http-info subject slim nil))
  ([subject (s/coll-of string?), slim (s/coll-of string?), {:keys [relationship_type exclude_automatic_assertions rows start]} (s/map-of keyword? any?)]
   (check-required-params subject slim)
   (call-api "/api/bioentityset/slimmer/function" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"relationship_type" relationship_type "subject" (with-collection-format subject :multi) "slim" (with-collection-format slim :multi) "exclude_automatic_assertions" exclude_automatic_assertions "rows" rows "start" start }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec slimmer-function-api-bioentityset-slimmer-function-get any-type-spec
  "Slimmer Function
  For a given gene(s), summarize its annotations over a defined set of slim."
  ([subject (s/coll-of string?), slim (s/coll-of string?), ] (slimmer-function-api-bioentityset-slimmer-function-get subject slim nil))
  ([subject (s/coll-of string?), slim (s/coll-of string?), optional-params any?]
   (let [res (:data (slimmer-function-api-bioentityset-slimmer-function-get-with-http-info subject slim optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any-type-spec res st/string-transformer)
        res))))


