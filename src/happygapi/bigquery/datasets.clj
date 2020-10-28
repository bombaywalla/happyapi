(ns happygapi.bigquery.datasets
  "BigQuery API: datasets.
  A data platform for customers to create, manage, share and query data.
  See: https://cloud.google.com/bigquery/api/reference/rest/v2/datasets"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/datasets/patch
  
  Required parameters: datasetId, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :defaultEncryptionConfiguration {:kmsKeyName string},
   :defaultPartitionExpirationMs string,
   :labels {},
   :selfLink string,
   :etag string,
   :defaultTableExpirationMs string,
   :lastModifiedTime string,
   :friendlyName string,
   :satisfiesPZS boolean,
   :id string,
   :kind string,
   :access [{:userByEmail string,
             :role string,
             :iamMember string,
             :specialGroup string,
             :routine {:routineId string,
                       :datasetId string,
                       :projectId string},
             :domain string,
             :view {:datasetId string,
                    :tableId string,
                    :projectId string},
             :groupByEmail string}],
   :location string,
   :datasetReference {:projectId string, :datasetId string}}
  
  Updates information in an existing dataset. The update method replaces the entire dataset resource, whereas the patch method only replaces fields that are provided in the submitted dataset resource. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:datasetId :projectId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}"
     #{:datasetId :projectId}
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

(defn update$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/datasets/update
  
  Required parameters: datasetId, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :defaultEncryptionConfiguration {:kmsKeyName string},
   :defaultPartitionExpirationMs string,
   :labels {},
   :selfLink string,
   :etag string,
   :defaultTableExpirationMs string,
   :lastModifiedTime string,
   :friendlyName string,
   :satisfiesPZS boolean,
   :id string,
   :kind string,
   :access [{:userByEmail string,
             :role string,
             :iamMember string,
             :specialGroup string,
             :routine {:routineId string,
                       :datasetId string,
                       :projectId string},
             :domain string,
             :view {:datasetId string,
                    :tableId string,
                    :projectId string},
             :groupByEmail string}],
   :location string,
   :datasetReference {:projectId string, :datasetId string}}
  
  Updates information in an existing dataset. The update method replaces the entire dataset resource, whereas the patch method only replaces fields that are provided in the submitted dataset resource."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:datasetId :projectId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}"
     #{:datasetId :projectId}
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

(defn list$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/datasets/list
  
  Required parameters: projectId
  
  Optional parameters: filter, maxResults, all, pageToken
  
  Lists all datasets in the specified project to which you have been granted the READER dataset role."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/bigquery.readonly"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets"
     #{:projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/datasets/delete
  
  Required parameters: projectId, datasetId
  
  Optional parameters: deleteContents
  
  Deletes the dataset specified by the datasetId value. Before you can delete a dataset, you must delete all its tables, either manually or by specifying deleteContents. Immediately after deletion, you can create another dataset with the same name."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:datasetId :projectId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}"
     #{:datasetId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/datasets/insert
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :defaultEncryptionConfiguration {:kmsKeyName string},
   :defaultPartitionExpirationMs string,
   :labels {},
   :selfLink string,
   :etag string,
   :defaultTableExpirationMs string,
   :lastModifiedTime string,
   :friendlyName string,
   :satisfiesPZS boolean,
   :id string,
   :kind string,
   :access [{:userByEmail string,
             :role string,
             :iamMember string,
             :specialGroup string,
             :routine {:routineId string,
                       :datasetId string,
                       :projectId string},
             :domain string,
             :view {:datasetId string,
                    :tableId string,
                    :projectId string},
             :groupByEmail string}],
   :location string,
   :datasetReference {:projectId string, :datasetId string}}
  
  Creates a new empty dataset."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets"
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

(defn get$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/datasets/get
  
  Required parameters: projectId, datasetId
  
  Optional parameters: none
  
  Returns the dataset specified by datasetID."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/bigquery.readonly"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:datasetId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}"
     #{:datasetId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
