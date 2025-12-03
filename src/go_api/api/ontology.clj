(ns go-api.api.ontology
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


(defn-spec get-ancestors-shared-between-two-terms-api-association-between-subject-object-get-with-http-info any?
  "Get Ancestors Shared Between Two Terms
  Returns the ancestor ontology terms shared by two ontology terms."
  ([subject string?, object string?, ] (get-ancestors-shared-between-two-terms-api-association-between-subject-object-get-with-http-info subject object nil))
  ([subject string?, object string?, {:keys [relation]} (s/map-of keyword? any?)]
   (check-required-params subject object)
   (call-api "/api/association/between/{subject}/{object}" :get
             {:path-params   {"subject" subject "object" object }
              :header-params {}
              :query-params  {"relation" relation }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec get-ancestors-shared-between-two-terms-api-association-between-subject-object-get any-type-spec
  "Get Ancestors Shared Between Two Terms
  Returns the ancestor ontology terms shared by two ontology terms."
  ([subject string?, object string?, ] (get-ancestors-shared-between-two-terms-api-association-between-subject-object-get subject object nil))
  ([subject string?, object string?, optional-params any?]
   (let [res (:data (get-ancestors-shared-between-two-terms-api-association-between-subject-object-get-with-http-info subject object optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any-type-spec res st/string-transformer)
        res))))


(defn-spec get-ancestors-shared-by-two-terms-api-ontology-shared-subject-object-get-with-http-info any?
  "Get Ancestors Shared By Two Terms
  Returns the ancestor ontology terms shared by two ontology terms."
  [subject string?, object string?]
  (check-required-params subject object)
  (call-api "/api/ontology/shared/{subject}/{object}" :get
            {:path-params   {"subject" subject "object" object }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-ancestors-shared-by-two-terms-api-ontology-shared-subject-object-get any-type-spec
  "Get Ancestors Shared By Two Terms
  Returns the ancestor ontology terms shared by two ontology terms."
  [subject string?, object string?]
  (let [res (:data (get-ancestors-shared-by-two-terms-api-ontology-shared-subject-object-get-with-http-info subject object))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


(defn-spec get-go-hierarchy-go-id-api-go-id-hierarchy-get-with-http-info any?
  "Get Go Hierarchy Go Id
  Returns parent and children relationships for a given GO ID, e.g. GO:0005885"
  [id string?]
  (check-required-params id)
  (call-api "/api/go/{id}/hierarchy" :get
            {:path-params   {"id" id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-go-hierarchy-go-id-api-go-id-hierarchy-get (s/coll-of go-hierarchy-item-spec)
  "Get Go Hierarchy Go Id
  Returns parent and children relationships for a given GO ID, e.g. GO:0005885"
  [id string?]
  (let [res (:data (get-go-hierarchy-go-id-api-go-id-hierarchy-get-with-http-info id))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of go-hierarchy-item-spec) res st/string-transformer)
       res)))


(defn-spec get-go-term-detail-by-go-id-api-go-id-get-with-http-info any?
  "Get Go Term Detail By Go Id
  Returns GO-CAM model identifiers for a given GO term ID, e.g. GO:0008150"
  [id string?]
  (check-required-params id)
  (call-api "/api/go/{id}" :get
            {:path-params   {"id" id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-go-term-detail-by-go-id-api-go-id-get any-type-spec
  "Get Go Term Detail By Go Id
  Returns GO-CAM model identifiers for a given GO term ID, e.g. GO:0008150"
  [id string?]
  (let [res (:data (get-go-term-detail-by-go-id-api-go-id-get-with-http-info id))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


(defn-spec get-gocam-models-by-go-id-api-go-id-models-get-with-http-info any?
  "Get Gocam Models By Go Id
  Returns GO-CAM model identifiers for a given GO term ID, e.g. GO:0008150"
  [id string?]
  (check-required-params id)
  (call-api "/api/go/{id}/models" :get
            {:path-params   {"id" id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-gocam-models-by-go-id-api-go-id-models-get any-type-spec
  "Get Gocam Models By Go Id
  Returns GO-CAM model identifiers for a given GO term ID, e.g. GO:0008150"
  [id string?]
  (let [res (:data (get-gocam-models-by-go-id-api-go-id-models-get-with-http-info id))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


(defn-spec get-ribbon-results-api-ontology-ribbon-get-with-http-info any?
  "Get Ribbon Results
  Fetch the summary of annotations for a given gene or set of genes."
  ([] (get-ribbon-results-api-ontology-ribbon-get-with-http-info nil))
  ([{:keys [subset subject ecodes exclude_IBA exclude_PB cross_aspect]} (s/map-of keyword? any?)]
   (call-api "/api/ontology/ribbon/" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"subset" subset "subject" (with-collection-format subject :multi) "ecodes" (with-collection-format ecodes :multi) "exclude_IBA" exclude_IBA "exclude_PB" exclude_PB "cross_aspect" cross_aspect }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec get-ribbon-results-api-ontology-ribbon-get any-type-spec
  "Get Ribbon Results
  Fetch the summary of annotations for a given gene or set of genes."
  ([] (get-ribbon-results-api-ontology-ribbon-get nil))
  ([optional-params any?]
   (let [res (:data (get-ribbon-results-api-ontology-ribbon-get-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any-type-spec res st/string-transformer)
        res))))


(defn-spec get-subgraph-by-term-id-api-ontology-term-id-subgraph-get-with-http-info any?
  "Get Subgraph By Term Id
  Extract a subgraph from an ontology term. e.g. GO:0003677 using the relationships is_a and part_of."
  ([id string?, ] (get-subgraph-by-term-id-api-ontology-term-id-subgraph-get-with-http-info id nil))
  ([id string?, {:keys [start rows]} (s/map-of keyword? any?)]
   (check-required-params id)
   (call-api "/api/ontology/term/{id}/subgraph" :get
             {:path-params   {"id" id }
              :header-params {}
              :query-params  {"start" start "rows" rows }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec get-subgraph-by-term-id-api-ontology-term-id-subgraph-get any-type-spec
  "Get Subgraph By Term Id
  Extract a subgraph from an ontology term. e.g. GO:0003677 using the relationships is_a and part_of."
  ([id string?, ] (get-subgraph-by-term-id-api-ontology-term-id-subgraph-get id nil))
  ([id string?, optional-params any?]
   (let [res (:data (get-subgraph-by-term-id-api-ontology-term-id-subgraph-get-with-http-info id optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any-type-spec res st/string-transformer)
        res))))


(defn-spec get-subset-by-id-api-ontology-subset-id-get-with-http-info any?
  "Get Subset By Id
  Returns a subset (slim) by its id which is usually a name. (e.g. goslim_agr)"
  [id string?]
  (check-required-params id)
  (call-api "/api/ontology/subset/{id}" :get
            {:path-params   {"id" id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-subset-by-id-api-ontology-subset-id-get any-type-spec
  "Get Subset By Id
  Returns a subset (slim) by its id which is usually a name. (e.g. goslim_agr)"
  [id string?]
  (let [res (:data (get-subset-by-id-api-ontology-subset-id-get-with-http-info id))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


(defn-spec get-subsets-by-term-api-ontology-term-id-subsets-get-with-http-info any?
  "Get Subsets By Term
  Returns subsets (slims) associated to an ontology term. (e.g. GO:0003677)"
  [id string?]
  (check-required-params id)
  (call-api "/api/ontology/term/{id}/subsets" :get
            {:path-params   {"id" id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-subsets-by-term-api-ontology-term-id-subsets-get any-type-spec
  "Get Subsets By Term
  Returns subsets (slims) associated to an ontology term. (e.g. GO:0003677)"
  [id string?]
  (let [res (:data (get-subsets-by-term-api-ontology-term-id-subsets-get-with-http-info id))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


(defn-spec get-term-graph-by-id-api-ontology-term-id-graph-get-with-http-info any?
  "Get Term Graph By Id
  Returns graph of an ontology term, e.g. GO:0003677."
  ([id string?, ] (get-term-graph-by-id-api-ontology-term-id-graph-get-with-http-info id nil))
  ([id string?, {:keys [graph_type]} (s/map-of keyword? any?)]
   (check-required-params id)
   (call-api "/api/ontology/term/{id}/graph" :get
             {:path-params   {"id" id }
              :header-params {}
              :query-params  {"graph_type" graph_type }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec get-term-graph-by-id-api-ontology-term-id-graph-get any-type-spec
  "Get Term Graph By Id
  Returns graph of an ontology term, e.g. GO:0003677."
  ([id string?, ] (get-term-graph-by-id-api-ontology-term-id-graph-get id nil))
  ([id string?, optional-params any?]
   (let [res (:data (get-term-graph-by-id-api-ontology-term-id-graph-get-with-http-info id optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any-type-spec res st/string-transformer)
        res))))


(defn-spec get-term-metadata-by-id-api-ontology-term-id-get-with-http-info any?
  "Get Term Metadata By Id
  Returns metadata of an ontology term, e.g. GO:0003677."
  [id string?]
  (check-required-params id)
  (call-api "/api/ontology/term/{id}" :get
            {:path-params   {"id" id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-term-metadata-by-id-api-ontology-term-id-get any-type-spec
  "Get Term Metadata By Id
  Returns metadata of an ontology term, e.g. GO:0003677."
  [id string?]
  (let [res (:data (get-term-metadata-by-id-api-ontology-term-id-get-with-http-info id))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


