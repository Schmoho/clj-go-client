(ns go-api.api.models
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


(defn-spec get-geneproducts-by-model-id-api-models-gp-get-with-http-info any?
  "Get Geneproducts By Model Id
  Returns gene product details based on a GO-CAM model ID."
  ([] (get-geneproducts-by-model-id-api-models-gp-get-with-http-info nil))
  ([{:keys [gocams]} (s/map-of keyword? any?)]
   (call-api "/api/models/gp" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"gocams" (with-collection-format gocams :multi) }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec get-geneproducts-by-model-id-api-models-gp-get any-type-spec
  "Get Geneproducts By Model Id
  Returns gene product details based on a GO-CAM model ID."
  ([] (get-geneproducts-by-model-id-api-models-gp-get nil))
  ([optional-params any?]
   (let [res (:data (get-geneproducts-by-model-id-api-models-gp-get-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any-type-spec res st/string-transformer)
        res))))


(defn-spec get-go-cam-models-by-orcid-api-users-orcid-get-with-http-info any?
  "Get Go Cam Models By Orcid
  Get GO-CAM models by ORCID"
  [orcid string?]
  (check-required-params orcid)
  (call-api "/api/users/{orcid}" :get
            {:path-params   {"orcid" orcid }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-go-cam-models-by-orcid-api-users-orcid-get any-type-spec
  "Get Go Cam Models By Orcid
  Get GO-CAM models by ORCID"
  [orcid string?]
  (let [res (:data (get-go-cam-models-by-orcid-api-users-orcid-get-with-http-info orcid))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


(defn-spec get-gocam-models-api-models-get-with-http-info any?
  "Get Gocam Models
  Returns metadata of GO-CAM models, e.g. 59a6110e00000067."
  ([] (get-gocam-models-api-models-get-with-http-info nil))
  ([{:keys [start size last group user pmid causalmf]} (s/map-of keyword? any?)]
   (call-api "/api/models" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"start" start "size" size "last" last "group" group "user" user "pmid" pmid "causalmf" causalmf }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec get-gocam-models-api-models-get any-type-spec
  "Get Gocam Models
  Returns metadata of GO-CAM models, e.g. 59a6110e00000067."
  ([] (get-gocam-models-api-models-get nil))
  ([optional-params any?]
   (let [res (:data (get-gocam-models-api-models-get-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any-type-spec res st/string-transformer)
        res))))


(defn-spec get-goterms-by-model-id-api-models-go-get-with-http-info any?
  "Get Goterms By Model Id
  Returns go term details based on a GO-CAM model ID."
  ([] (get-goterms-by-model-id-api-models-go-get-with-http-info nil))
  ([{:keys [gocams]} (s/map-of keyword? any?)]
   (call-api "/api/models/go" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"gocams" (with-collection-format gocams :multi) }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec get-goterms-by-model-id-api-models-go-get any-type-spec
  "Get Goterms By Model Id
  Returns go term details based on a GO-CAM model ID."
  ([] (get-goterms-by-model-id-api-models-go-get nil))
  ([optional-params any?]
   (let [res (:data (get-goterms-by-model-id-api-models-go-get-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any-type-spec res st/string-transformer)
        res))))


(defn-spec get-gp-models-by-orcid-api-users-orcid-gp-get-with-http-info any?
  "Get Gp Models By Orcid
  Get GPs by orcid"
  [orcid string?]
  (check-required-params orcid)
  (call-api "/api/users/{orcid}/gp" :get
            {:path-params   {"orcid" orcid }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-gp-models-by-orcid-api-users-orcid-gp-get any-type-spec
  "Get Gp Models By Orcid
  Get GPs by orcid"
  [orcid string?]
  (let [res (:data (get-gp-models-by-orcid-api-users-orcid-gp-get-with-http-info orcid))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


(defn-spec get-model-details-by-model-id-json-api-go-cam-id-get-with-http-info any?
  "Get Model Details By Model Id Json
  Returns model details based on a GO-CAM model ID in JSON format."
  [id string?]
  (check-required-params id)
  (call-api "/api/go-cam/{id}" :get
            {:path-params   {"id" id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-model-details-by-model-id-json-api-go-cam-id-get any-type-spec
  "Get Model Details By Model Id Json
  Returns model details based on a GO-CAM model ID in JSON format."
  [id string?]
  (let [res (:data (get-model-details-by-model-id-json-api-go-cam-id-get-with-http-info id))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


(defn-spec get-model-details-by-pmid-api-pmid-id-models-get-with-http-info any?
  "Get Model Details By Pmid
  Returns models for a given publication identifier (PMID)."
  [id string?]
  (check-required-params id)
  (call-api "/api/pmid/{id}/models" :get
            {:path-params   {"id" id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-model-details-by-pmid-api-pmid-id-models-get any-type-spec
  "Get Model Details By Pmid
  Returns models for a given publication identifier (PMID)."
  [id string?]
  (let [res (:data (get-model-details-by-pmid-api-pmid-id-models-get-with-http-info id))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


(defn-spec get-models-by-orcid-api-users-orcid-models-get-with-http-info any?
  "Get Models By Orcid
  Returns model details based on an orcid."
  [orcid string?]
  (check-required-params orcid)
  (call-api "/api/users/{orcid}/models" :get
            {:path-params   {"orcid" orcid }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-models-by-orcid-api-users-orcid-models-get any-type-spec
  "Get Models By Orcid
  Returns model details based on an orcid."
  [orcid string?]
  (let [res (:data (get-models-by-orcid-api-users-orcid-models-get-with-http-info orcid))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


(defn-spec get-pmid-by-model-id-api-models-pmid-get-with-http-info any?
  "Get Pmid By Model Id
  Returns PMID details based on a GO CAM ID."
  ([] (get-pmid-by-model-id-api-models-pmid-get-with-http-info nil))
  ([{:keys [gocams]} (s/map-of keyword? any?)]
   (call-api "/api/models/pmid" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"gocams" (with-collection-format gocams :multi) }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec get-pmid-by-model-id-api-models-pmid-get any-type-spec
  "Get Pmid By Model Id
  Returns PMID details based on a GO CAM ID."
  ([] (get-pmid-by-model-id-api-models-pmid-get nil))
  ([optional-params any?]
   (let [res (:data (get-pmid-by-model-id-api-models-pmid-get-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any-type-spec res st/string-transformer)
        res))))


(defn-spec get-term-details-by-model-id-api-models-id-get-with-http-info any?
  "Get Term Details By Model Id
  Returns model details based on a GO-CAM model ID."
  [id string?]
  (check-required-params id)
  (call-api "/api/models/{id}" :get
            {:path-params   {"id" id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-term-details-by-model-id-api-models-id-get any-type-spec
  "Get Term Details By Model Id
  Returns model details based on a GO-CAM model ID."
  [id string?]
  (let [res (:data (get-term-details-by-model-id-api-models-id-get-with-http-info id))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


(defn-spec get-term-details-by-taxon-id-api-taxon-taxon-models-get-with-http-info any?
  "Get Term Details By Taxon Id
  Returns model details based on a NCBI Taxon ID."
  [taxon string?]
  (check-required-params taxon)
  (call-api "/api/taxon/{taxon}/models" :get
            {:path-params   {"taxon" taxon }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-term-details-by-taxon-id-api-taxon-taxon-models-get any-type-spec
  "Get Term Details By Taxon Id
  Returns model details based on a NCBI Taxon ID."
  [taxon string?]
  (let [res (:data (get-term-details-by-taxon-id-api-taxon-taxon-models-get-with-http-info taxon))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


