(ns happygapi.sqladmin.operations
  "Cloud SQL Admin API: operations.
  API for Cloud SQL database instance management
  See: https://cloud.google.com/sql/docs"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/operations/get
  
  Required parameters: project, operation
  
  Optional parameters: none
  
  Retrieves an instance operation that has been performed on an instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:operation :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/operations/{operation}"
     #{:operation :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/operations/list
  
  Required parameters: project
  
  Optional parameters: instance, maxResults, pageToken
  
  Lists all instance operations that have been performed on the given Cloud SQL instance in the reverse chronological order of the start time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/operations"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn cancel$
  "https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/operations/cancel
  
  Required parameters: project, operation
  
  Optional parameters: none
  
  Cancels an instance operation that has been performed on an instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:operation :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/operations/{operation}/cancel"
     #{:operation :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
