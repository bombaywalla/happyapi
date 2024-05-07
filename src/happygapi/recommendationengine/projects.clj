(ns happygapi.recommendationengine.projects
  "Recommendations AI (Beta): projects.
  Note that we now highly recommend new customers to use Retail API, which incorporates the GA version of the Recommendations AI funtionalities. To enable Retail API, please visit https://console.cloud.google.com/apis/library/retail.googleapis.com. The Recommendations AI service enables customers to build end-to-end personalized recommendation systems without requiring a high level of expertise in machine learning, recommendation system, or Google Cloud.
  See: https://cloud.google.com/recommendations-ai/docs"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-catalogs-list$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all the catalog configurations associated with the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+parent}/catalogs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-patch$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :displayName string,
   :defaultEventStoreId string,
   :catalogItemLevelConfig {:eventItemLevel string,
                            :predictItemLevel string}}
  
  Updates the catalog configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-operations-list$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-operations-get$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-eventStores-operations-list$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.eventStores.operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-eventStores-operations-get$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.eventStores.operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-eventStores-predictionApiKeyRegistrations-create$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.eventStores.predictionApiKeyRegistrations/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:predictionApiKeyRegistration {:apiKey string}}
  
  Register an API key for use with predict method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+parent}/predictionApiKeyRegistrations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-eventStores-predictionApiKeyRegistrations-list$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.eventStores.predictionApiKeyRegistrations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List the registered apiKeys for use with predict method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+parent}/predictionApiKeyRegistrations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-eventStores-predictionApiKeyRegistrations-delete$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.eventStores.predictionApiKeyRegistrations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Unregister an apiKey from using for predict method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-eventStores-placements-predict$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.eventStores.placements/predict
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:userEvent {:eventType string,
               :userInfo GoogleCloudRecommendationengineV1beta1UserInfo,
               :eventDetail GoogleCloudRecommendationengineV1beta1EventDetail,
               :productEventDetail GoogleCloudRecommendationengineV1beta1ProductEventDetail,
               :eventTime string,
               :eventSource string},
   :pageSize integer,
   :pageToken string,
   :filter string,
   :dryRun boolean,
   :params {},
   :labels {}}
  
  Makes a recommendation prediction. If using API Key based authentication, the API Key must be registered using the PredictionApiKeyRegistry service. [Learn more](https://cloud.google.com/recommendations-ai/docs/setting-up#register-key)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+name}:predict"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-eventStores-userEvents-write$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.eventStores.userEvents/write
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:eventType string,
   :userInfo {:visitorId string,
              :userId string,
              :ipAddress string,
              :userAgent string,
              :directUserRequest boolean},
   :eventDetail {:uri string,
                 :referrerUri string,
                 :pageViewId string,
                 :experimentIds [string],
                 :recommendationToken string,
                 :eventAttributes GoogleCloudRecommendationengineV1beta1FeatureMap},
   :productEventDetail {:searchQuery string,
                        :pageCategories [GoogleCloudRecommendationengineV1beta1CatalogItemCategoryHierarchy],
                        :productDetails [GoogleCloudRecommendationengineV1beta1ProductDetail],
                        :listId string,
                        :cartId string,
                        :purchaseTransaction GoogleCloudRecommendationengineV1beta1PurchaseTransaction},
   :eventTime string,
   :eventSource string}
  
  Writes a single user event."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+parent}/userEvents:write"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-eventStores-userEvents-collect$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.eventStores.userEvents/collect
  
  Required parameters: parent
  
  Optional parameters: userEvent, uri, ets
  
  Writes a single user event from the browser. This uses a GET request to due to browser restriction of POST-ing to a 3rd party domain. This method is used only by the Recommendations AI JavaScript pixel. Users should not call this method directly."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+parent}/userEvents:collect"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-eventStores-userEvents-list$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.eventStores.userEvents/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Gets a list of user events within a time range, with potential filtering. The method does not list unjoined user events. Unjoined user event definition: when a user event is ingested from Recommendations AI User Event APIs, the catalog item included in the user event is connected with the current catalog. If a catalog item of the ingested event is not in the current catalog, it could lead to degraded model quality. This is called an unjoined event."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+parent}/userEvents"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-eventStores-userEvents-purge$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.eventStores.userEvents/purge
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:filter string, :force boolean}
  
  Deletes permanently all user events specified by the filter provided. Depending on the number of events specified by the filter, this operation could take hours or days to complete. To test a filter, use the list command first."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+parent}/userEvents:purge"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-eventStores-userEvents-import$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.eventStores.userEvents/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string,
   :inputConfig {:catalogInlineSource GoogleCloudRecommendationengineV1beta1CatalogInlineSource,
                 :gcsSource GoogleCloudRecommendationengineV1beta1GcsSource,
                 :userEventInlineSource GoogleCloudRecommendationengineV1beta1UserEventInlineSource,
                 :bigQuerySource GoogleCloudRecommendationengineV1beta1BigQuerySource},
   :errorsConfig {:gcsPrefix string}}
  
  Bulk import of User events. Request processing might be synchronous. Events that already exist are skipped. Use this method for backfilling historical user events. Operation.response is of type ImportResponse. Note that it is possible for a subset of the items to be successfully inserted. Operation.metadata is of type ImportMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+parent}/userEvents:import"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-eventStores-userEvents-rejoin$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.eventStores.userEvents/rejoin
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:userEventRejoinScope string}
  
  Triggers a user event rejoin operation with latest catalog data. Events will not be annotated with detailed catalog information if catalog item is missing at the time the user event is ingested, and these events are stored as unjoined events with a limited usage on training and serving. This API can be used to trigger a 'join' operation on specified events with latest version of catalog items. It can also be used to correct events joined with wrong catalog items."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+parent}/userEvents:rejoin"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-catalogItems-create$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.catalogItems/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :tags [string],
   :productMetadata {:exactPrice GoogleCloudRecommendationengineV1beta1ProductCatalogItemExactPrice,
                     :priceRange GoogleCloudRecommendationengineV1beta1ProductCatalogItemPriceRange,
                     :costs {},
                     :currencyCode string,
                     :stockState string,
                     :availableQuantity string,
                     :canonicalProductUri string,
                     :images [GoogleCloudRecommendationengineV1beta1Image]},
   :itemAttributes {:categoricalFeatures {}, :numericalFeatures {}},
   :title string,
   :languageCode string,
   :itemGroupId string,
   :id string,
   :categoryHierarchies [{:categories [string]}]}
  
  Creates a catalog item."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+parent}/catalogItems"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-catalogItems-get$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.catalogItems/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a specific catalog item."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-catalogItems-list$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.catalogItems/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Gets a list of catalog items."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+parent}/catalogItems"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-catalogItems-patch$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.catalogItems/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :tags [string],
   :productMetadata {:exactPrice GoogleCloudRecommendationengineV1beta1ProductCatalogItemExactPrice,
                     :priceRange GoogleCloudRecommendationengineV1beta1ProductCatalogItemPriceRange,
                     :costs {},
                     :currencyCode string,
                     :stockState string,
                     :availableQuantity string,
                     :canonicalProductUri string,
                     :images [GoogleCloudRecommendationengineV1beta1Image]},
   :itemAttributes {:categoricalFeatures {}, :numericalFeatures {}},
   :title string,
   :languageCode string,
   :itemGroupId string,
   :id string,
   :categoryHierarchies [{:categories [string]}]}
  
  Updates a catalog item. Partial updating is supported. Non-existing items will be created."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-catalogItems-delete$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.catalogItems/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a catalog item."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-catalogItems-import$
  "https://cloud.google.com/recommendations-ai/docs/reference/rest/v1beta1/projects.locations.catalogs.catalogItems/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string,
   :inputConfig {:catalogInlineSource GoogleCloudRecommendationengineV1beta1CatalogInlineSource,
                 :gcsSource GoogleCloudRecommendationengineV1beta1GcsSource,
                 :userEventInlineSource GoogleCloudRecommendationengineV1beta1UserEventInlineSource,
                 :bigQuerySource GoogleCloudRecommendationengineV1beta1BigQuerySource},
   :errorsConfig {:gcsPrefix string},
   :updateMask string}
  
  Bulk import of multiple catalog items. Request processing may be synchronous. No partial updating supported. Non-existing items will be created. Operation.response is of type ImportResponse. Note that it is possible for a subset of the items to be successfully updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recommendationengine.googleapis.com/"
     "v1beta1/{+parent}/catalogItems:import"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
