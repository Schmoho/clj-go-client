(ns go-api.api.bioentity
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


(defn-spec get-annotations-by-gene-id-api-bioentity-gene-id-function-get-with-http-info any?
  "Get Annotations By Gene Id
  Returns GO terms associated with a gene, e.g. ZFIN:ZDB-GENE-050417-357"
  ([id string?, ] (get-annotations-by-gene-id-api-bioentity-gene-id-function-get-with-http-info id nil))
  ([id string?, {:keys [slim start rows]} (s/map-of keyword? any?)]
   (check-required-params id)
   (call-api "/api/bioentity/gene/{id}/function" :get
             {:path-params   {"id" id }
              :header-params {}
              :query-params  {"slim" (with-collection-format slim :multi) "start" start "rows" rows }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec get-annotations-by-gene-id-api-bioentity-gene-id-function-get any-type-spec
  "Get Annotations By Gene Id
  Returns GO terms associated with a gene, e.g. ZFIN:ZDB-GENE-050417-357"
  ([id string?, ] (get-annotations-by-gene-id-api-bioentity-gene-id-function-get id nil))
  ([id string?, optional-params any?]
   (let [res (:data (get-annotations-by-gene-id-api-bioentity-gene-id-function-get-with-http-info id optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any-type-spec res st/string-transformer)
        res))))


(defn-spec get-annotations-by-goterm-id-api-bioentity-function-id-get-with-http-info any?
  "Get Annotations By Goterm Id
  Get gene or gene product information via a GO term id, e.g. GO:0044598."
  ([id string?, ] (get-annotations-by-goterm-id-api-bioentity-function-id-get-with-http-info id nil))
  ([id string?, {:keys [evidence start rows]} (s/map-of keyword? any?)]
   (check-required-params id)
   (call-api "/api/bioentity/function/{id}" :get
             {:path-params   {"id" id }
              :header-params {}
              :query-params  {"evidence" (with-collection-format evidence :multi) "start" start "rows" rows }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec get-annotations-by-goterm-id-api-bioentity-function-id-get any-type-spec
  "Get Annotations By Goterm Id
  Get gene or gene product information via a GO term id, e.g. GO:0044598."
  ([id string?, ] (get-annotations-by-goterm-id-api-bioentity-function-id-get id nil))
  ([id string?, optional-params any?]
   (let [res (:data (get-annotations-by-goterm-id-api-bioentity-function-id-get-with-http-info id optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any-type-spec res st/string-transformer)
        res))))


(defn-spec get-bioentity-by-id-api-bioentity-id-get-with-http-info any?
  "Get Bioentity By Id
  Get bio-entities (genes) by their identifiers."
  ([id string?, ] (get-bioentity-by-id-api-bioentity-id-get-with-http-info id nil))
  ([id string?, {:keys [start rows]} (s/map-of keyword? any?)]
   (check-required-params id)
   (call-api "/api/bioentity/{id}" :get
             {:path-params   {"id" id }
              :header-params {}
              :query-params  {"start" start "rows" rows }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec get-bioentity-by-id-api-bioentity-id-get any-type-spec
  "Get Bioentity By Id
  Get bio-entities (genes) by their identifiers."
  ([id string?, ] (get-bioentity-by-id-api-bioentity-id-get id nil))
  ([id string?, optional-params any?]
   (let [res (:data (get-bioentity-by-id-api-bioentity-id-get-with-http-info id optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any-type-spec res st/string-transformer)
        res))))


(defn-spec get-genes-by-goterm-id-api-bioentity-function-id-genes-get-with-http-info any?
  "Get Genes By Goterm Id
  Returns genes annotated to the provided GO Term. e.g. GO:0044598"
  ([id string?, ] (get-genes-by-goterm-id-api-bioentity-function-id-genes-get-with-http-info id nil))
  ([id string?, {:keys [taxon relationship_type relation slim start rows]} (s/map-of keyword? any?)]
   (check-required-params id)
   (call-api "/api/bioentity/function/{id}/genes" :get
             {:path-params   {"id" id }
              :header-params {}
              :query-params  {"taxon" (with-collection-format taxon :multi) "relationship_type" relationship_type "relation" relation "slim" (with-collection-format slim :multi) "start" start "rows" rows }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec get-genes-by-goterm-id-api-bioentity-function-id-genes-get any-type-spec
  "Get Genes By Goterm Id
  Returns genes annotated to the provided GO Term. e.g. GO:0044598"
  ([id string?, ] (get-genes-by-goterm-id-api-bioentity-function-id-genes-get id nil))
  ([id string?, optional-params any?]
   (let [res (:data (get-genes-by-goterm-id-api-bioentity-function-id-genes-get-with-http-info id optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any-type-spec res st/string-transformer)
        res))))


(defn-spec get-taxon-by-goterm-id-api-bioentity-function-id-taxons-get-with-http-info any?
  "Get Taxon By Goterm Id
  Returns taxon information for genes annotated to the provided GO term, e.g. GO:0044598"
  ([id string?, ] (get-taxon-by-goterm-id-api-bioentity-function-id-taxons-get-with-http-info id nil))
  ([id string?, {:keys [evidence start rows]} (s/map-of keyword? any?)]
   (check-required-params id)
   (call-api "/api/bioentity/function/{id}/taxons" :get
             {:path-params   {"id" id }
              :header-params {}
              :query-params  {"evidence" (with-collection-format evidence :multi) "start" start "rows" rows }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec get-taxon-by-goterm-id-api-bioentity-function-id-taxons-get any-type-spec
  "Get Taxon By Goterm Id
  Returns taxon information for genes annotated to the provided GO term, e.g. GO:0044598"
  ([id string?, ] (get-taxon-by-goterm-id-api-bioentity-function-id-taxons-get id nil))
  ([id string?, optional-params any?]
   (let [res (:data (get-taxon-by-goterm-id-api-bioentity-function-id-taxons-get-with-http-info id optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any-type-spec res st/string-transformer)
        res))))


