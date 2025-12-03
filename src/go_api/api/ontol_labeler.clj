(ns go-api.api.ontol-labeler
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


(defn-spec expand-curie-api-ontol-labeler-get-with-http-info any?
  "Expand Curie
  Fetches a map from IDs to labels e.g. GO:0003677."
  [id (s/coll-of string?)]
  (check-required-params id)
  (call-api "/api/ontol/labeler" :get
            {:path-params   {}
             :header-params {}
             :query-params  {"id" (with-collection-format id :multi) }
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec expand-curie-api-ontol-labeler-get any-type-spec
  "Expand Curie
  Fetches a map from IDs to labels e.g. GO:0003677."
  [id (s/coll-of string?)]
  (let [res (:data (expand-curie-api-ontol-labeler-get-with-http-info id))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


