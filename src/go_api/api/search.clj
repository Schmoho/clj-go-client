(ns go-api.api.search
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


(defn-spec autocomplete-term-api-search-entity-autocomplete-term-get-with-http-info any?
  "Autocomplete Term
  Returns a list of matching concepts or entities over annotation classes and bio-entities."
  ([term string?, ] (autocomplete-term-api-search-entity-autocomplete-term-get-with-http-info term nil))
  ([term string?, {:keys [start rows category]} (s/map-of keyword? any?)]
   (check-required-params term)
   (call-api "/api/search/entity/autocomplete/{term}" :get
             {:path-params   {"term" term }
              :header-params {}
              :query-params  {"start" start "rows" rows "category" category }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec autocomplete-term-api-search-entity-autocomplete-term-get any-type-spec
  "Autocomplete Term
  Returns a list of matching concepts or entities over annotation classes and bio-entities."
  ([term string?, ] (autocomplete-term-api-search-entity-autocomplete-term-get term nil))
  ([term string?, optional-params any?]
   (let [res (:data (autocomplete-term-api-search-entity-autocomplete-term-get-with-http-info term optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any-type-spec res st/string-transformer)
        res))))


