(ns happygapi.datastore.projects
  "Cloud Datastore API: projects.
  Accesses the schemaless NoSQL database to provide fully managed, robust, scalable storage for your application. 
  See: https://cloud.google.com/datastore/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn rollback$
  "https://cloud.google.com/datastore/api/reference/rest/v1/projects/rollback
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:databaseId string, :transaction string}
  
  Rolls back a transaction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:rollback"
     #{:projectId}
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

(defn reserveIds$
  "https://cloud.google.com/datastore/api/reference/rest/v1/projects/reserveIds
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:databaseId string,
   :keys [{:partitionId PartitionId, :path [PathElement]}]}
  
  Prevents the supplied keys' IDs from being auto-allocated by Cloud Datastore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:reserveIds"
     #{:projectId}
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

(defn lookup$
  "https://cloud.google.com/datastore/api/reference/rest/v1/projects/lookup
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:databaseId string,
   :readOptions {:readConsistency string,
                 :transaction string,
                 :newTransaction TransactionOptions,
                 :readTime string},
   :keys [{:partitionId PartitionId, :path [PathElement]}],
   :propertyMask {:paths [string]}}
  
  Looks up entities by key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:lookup"
     #{:projectId}
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

(defn runQuery$
  "https://cloud.google.com/datastore/api/reference/rest/v1/projects/runQuery
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:databaseId string,
   :partitionId {:projectId string,
                 :databaseId string,
                 :namespaceId string},
   :readOptions {:readConsistency string,
                 :transaction string,
                 :newTransaction TransactionOptions,
                 :readTime string},
   :query {:limit integer,
           :offset integer,
           :endCursor string,
           :filter Filter,
           :kind [KindExpression],
           :order [PropertyOrder],
           :distinctOn [PropertyReference],
           :projection [Projection],
           :startCursor string},
   :gqlQuery {:queryString string,
              :allowLiterals boolean,
              :namedBindings {},
              :positionalBindings [GqlQueryParameter]},
   :propertyMask {:paths [string]},
   :explainOptions {:analyze boolean}}
  
  Queries for entities."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:runQuery"
     #{:projectId}
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

(defn export$
  "https://cloud.google.com/datastore/api/reference/rest/v1/projects/export
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :entityFilter {:kinds [string], :namespaceIds [string]},
   :outputUrlPrefix string}
  
  Exports a copy of all or a subset of entities from Google Cloud Datastore to another storage system, such as Google Cloud Storage. Recent updates to entities may not be reflected in the export. The export occurs in the background and its progress can be monitored and managed via the Operation resource that is created. The output of an export may only be used once the associated operation is done. If an export operation is cancelled before completion it may leave partial data behind in Google Cloud Storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:export"
     #{:projectId}
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

(defn beginTransaction$
  "https://cloud.google.com/datastore/api/reference/rest/v1/projects/beginTransaction
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:databaseId string,
   :transactionOptions {:readWrite ReadWrite, :readOnly ReadOnly}}
  
  Begins a new transaction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:beginTransaction"
     #{:projectId}
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

(defn commit$
  "https://cloud.google.com/datastore/api/reference/rest/v1/projects/commit
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:databaseId string,
   :mode string,
   :transaction string,
   :singleUseTransaction {:readWrite ReadWrite, :readOnly ReadOnly},
   :mutations [{:insert Entity,
                :update Entity,
                :upsert Entity,
                :delete Key,
                :baseVersion string,
                :updateTime string,
                :propertyMask PropertyMask}]}
  
  Commits a transaction, optionally creating, deleting or modifying some entities."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:commit"
     #{:projectId}
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

(defn runAggregationQuery$
  "https://cloud.google.com/datastore/api/reference/rest/v1/projects/runAggregationQuery
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:databaseId string,
   :partitionId {:projectId string,
                 :databaseId string,
                 :namespaceId string},
   :readOptions {:readConsistency string,
                 :transaction string,
                 :newTransaction TransactionOptions,
                 :readTime string},
   :aggregationQuery {:nestedQuery Query, :aggregations [Aggregation]},
   :gqlQuery {:queryString string,
              :allowLiterals boolean,
              :namedBindings {},
              :positionalBindings [GqlQueryParameter]},
   :explainOptions {:analyze boolean}}
  
  Runs an aggregation query."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:runAggregationQuery"
     #{:projectId}
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

(defn allocateIds$
  "https://cloud.google.com/datastore/api/reference/rest/v1/projects/allocateIds
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:databaseId string,
   :keys [{:partitionId PartitionId, :path [PathElement]}]}
  
  Allocates IDs for the given keys, which is useful for referencing an entity before it is inserted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:allocateIds"
     #{:projectId}
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

(defn import$
  "https://cloud.google.com/datastore/api/reference/rest/v1/projects/import
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :inputUrl string,
   :entityFilter {:kinds [string], :namespaceIds [string]}}
  
  Imports entities into Google Cloud Datastore. Existing entities with the same key are overwritten. The import occurs in the background and its progress can be monitored and managed via the Operation resource that is created. If an ImportEntities operation is cancelled, it is possible that a subset of the data has already been imported to Cloud Datastore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:import"
     #{:projectId}
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

(defn operations-list$
  "https://cloud.google.com/datastore/api/reference/rest/v1/projects/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn operations-get$
  "https://cloud.google.com/datastore/api/reference/rest/v1/projects/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn operations-delete$
  "https://cloud.google.com/datastore/api/reference/rest/v1/projects/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn operations-cancel$
  "https://cloud.google.com/datastore/api/reference/rest/v1/projects/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn indexes-create$
  "https://cloud.google.com/datastore/api/reference/rest/v1/projects/indexes/create
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string,
   :indexId string,
   :kind string,
   :ancestor string,
   :properties [{:name string, :direction string}],
   :state string}
  
  Creates the specified index. A newly created index's initial state is `CREATING`. On completion of the returned google.longrunning.Operation, the state will be `READY`. If the index already exists, the call will return an `ALREADY_EXISTS` status. During index creation, the process could result in an error, in which case the index will move to the `ERROR` state. The process can be recovered by fixing the data that caused the error, removing the index with delete, then re-creating the index with create. Indexes with a single property cannot be created."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}/indexes"
     #{:projectId}
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

(defn indexes-delete$
  "https://cloud.google.com/datastore/api/reference/rest/v1/projects/indexes/delete
  
  Required parameters: projectId, indexId
  
  Optional parameters: none
  
  Deletes an existing index. An index can only be deleted if it is in a `READY` or `ERROR` state. On successful execution of the request, the index will be in a `DELETING` state. And on completion of the returned google.longrunning.Operation, the index will be removed. During index deletion, the process could result in an error, in which case the index will move to the `ERROR` state. The process can be recovered by fixing the data that caused the error, followed by calling delete again."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:indexId :projectId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}/indexes/{indexId}"
     #{:indexId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn indexes-get$
  "https://cloud.google.com/datastore/api/reference/rest/v1/projects/indexes/get
  
  Required parameters: projectId, indexId
  
  Optional parameters: none
  
  Gets an index."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:indexId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}/indexes/{indexId}"
     #{:indexId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn indexes-list$
  "https://cloud.google.com/datastore/api/reference/rest/v1/projects/indexes/list
  
  Required parameters: projectId
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists the indexes that match the specified filters. Datastore uses an eventually consistent query to fetch the list of indexes and may occasionally return stale results."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}/indexes"
     #{:projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
