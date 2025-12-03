(ns go-api.api.users-and-groups
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


(defn-spec get-group-metadata-by-name-api-groups-name-get-with-http-info any?
  "Get Group Metadata By Name
  Get GO group metadata by name"
  [name string?]
  (check-required-params name)
  (call-api "/api/groups/{name}" :get
            {:path-params   {"name" name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-group-metadata-by-name-api-groups-name-get any-type-spec
  "Get Group Metadata By Name
  Get GO group metadata by name"
  [name string?]
  (let [res (:data (get-group-metadata-by-name-api-groups-name-get-with-http-info name))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


(defn-spec get-groups-api-groups-get-with-http-info any?
  "Get Groups
  Get GO groups"
  []
  (call-api "/api/groups" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-groups-api-groups-get any-type-spec
  "Get Groups
  Get GO groups"
  []
  (let [res (:data (get-groups-api-groups-get-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


(defn-spec get-users-api-users-get-with-http-info any?
  "Get Users
  Get GO users."
  []
  (call-api "/api/users" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-users-api-users-get any-type-spec
  "Get Users
  Get GO users."
  []
  (let [res (:data (get-users-api-users-get-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode any-type-spec res st/string-transformer)
       res)))


