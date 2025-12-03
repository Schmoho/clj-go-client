(ns go-api.api.pathways
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


(defn-spec get-gocams-by-geneproduct-id-api-gp-id-models-get-with-http-info any?
  "Get Gocams By Geneproduct Id
  Returns GO-CAM models associated with a given Gene Product identifier. (e.g. MGI:3588192, ZFIN:ZDB-GENE-000403-1)."
  ([id string?, ] (get-gocams-by-geneproduct-id-api-gp-id-models-get-with-http-info id nil))
  ([id string?, {:keys [causalmf]} (s/map-of keyword? any?)]
   (check-required-params id)
   (call-api "/api/gp/{id}/models" :get
             {:path-params   {"id" id }
              :header-params {}
              :query-params  {"causalmf" causalmf }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec get-gocams-by-geneproduct-id-api-gp-id-models-get any-type-spec
  "Get Gocams By Geneproduct Id
  Returns GO-CAM models associated with a given Gene Product identifier. (e.g. MGI:3588192, ZFIN:ZDB-GENE-000403-1)."
  ([id string?, ] (get-gocams-by-geneproduct-id-api-gp-id-models-get id nil))
  ([id string?, optional-params any?]
   (let [res (:data (get-gocams-by-geneproduct-id-api-gp-id-models-get-with-http-info id optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any-type-spec res st/string-transformer)
        res))))


