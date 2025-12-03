(ns go-api.api.identifier-prefixes
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


(defn-spec get-all-prefixes-api-identifier-prefixes-get-with-http-info any?
  "Get All Prefixes
  Returns a list of all prefixes in the GO namespace."
  []
  (call-api "/api/identifier/prefixes" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-all-prefixes-api-identifier-prefixes-get any-type-spec
  "Get All Prefixes
  Returns a list of all prefixes in the GO namespace."
  []
  (let [res (:data (get-all-prefixes-api-identifier-prefixes-get-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


(defn-spec get-contract-uri-api-identifier-prefixes-contract-get-with-http-info any?
  "Get Contract Uri
  Enter a full URI of the identified resource to contract to CURIE format, e.g. 'http://purl.obolibrary.org/obo/GO_0008150'."
  [uri string?]
  (check-required-params uri)
  (call-api "/api/identifier/prefixes/contract/" :get
            {:path-params   {}
             :header-params {}
             :query-params  {"uri" uri }
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-contract-uri-api-identifier-prefixes-contract-get any-type-spec
  "Get Contract Uri
  Enter a full URI of the identified resource to contract to CURIE format, e.g. 'http://purl.obolibrary.org/obo/GO_0008150'."
  [uri string?]
  (let [res (:data (get-contract-uri-api-identifier-prefixes-contract-get-with-http-info uri))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


(defn-spec get-expand-curie-api-identifier-prefixes-expand-id-get-with-http-info any?
  "Get Expand Curie
  Enter a CURIE of the identified resource to expand to full URI format.  e.g. MGI:3588192, MGI:MGI:3588192"
  [id string?]
  (check-required-params id)
  (call-api "/api/identifier/prefixes/expand/{id}" :get
            {:path-params   {"id" id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-expand-curie-api-identifier-prefixes-expand-id-get any-type-spec
  "Get Expand Curie
  Enter a CURIE of the identified resource to expand to full URI format.  e.g. MGI:3588192, MGI:MGI:3588192"
  [id string?]
  (let [res (:data (get-expand-curie-api-identifier-prefixes-expand-id-get-with-http-info id))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


