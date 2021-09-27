(ns happygapi.bigquery.tabledata
  "BigQuery API: tabledata.
  A data platform for customers to create, manage, share and query data.
  See: https://cloud.google.com/bigquery/api/reference/rest/v2/tabledata"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tabledata/list
  
  Required parameters: projectId, datasetId, tableId
  
  Optional parameters: maxResults, selectedFields, pageToken, startIndex
  
  Retrieves table data from a specified set of rows. Requires the READER dataset role."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:tableId :datasetId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}/tables/{tableId}/data"
     #{:tableId :datasetId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insertAll$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tabledata/insertAll
  
  Required parameters: projectId, datasetId, tableId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
   :ignoreUnknownValues boolean,
   :templateSuffix string,
   :skipInvalidRows boolean,
   :rows [{:json {}, :insertId string}]}
  
  Streams data into BigQuery one record at a time without needing to run a load job. Requires the WRITER dataset role."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/bigquery.insertdata"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:tableId :datasetId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}/tables/{tableId}/insertAll"
     #{:tableId :datasetId :projectId}
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
