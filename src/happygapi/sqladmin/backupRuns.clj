(ns happygapi.sqladmin.backupRuns
  "Cloud SQL Admin API: backupRuns.
  API for Cloud SQL database instance management
  See: https://cloud.google.com/sql/docs"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/backupRuns/delete
  
  Required parameters: project, instance, id
  
  Optional parameters: none
  
  Deletes the backup taken by a backup run."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project :id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/backupRuns/{id}"
     #{:instance :project :id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/backupRuns/get
  
  Required parameters: project, instance, id
  
  Optional parameters: none
  
  Retrieves a resource containing information about a backup run."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project :id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/backupRuns/{id}"
     #{:instance :project :id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/backupRuns/insert
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :timeZone string,
   :diskEncryptionConfiguration {:kmsKeyName string, :kind string},
   :instance string,
   :startTime string,
   :windowStartTime string,
   :endTime string,
   :enqueuedTime string,
   :selfLink string,
   :type string,
   :diskEncryptionStatus {:kmsKeyVersionName string, :kind string},
   :status string,
   :id string,
   :kind string,
   :error {:kind string, :code string, :message string},
   :location string,
   :backupKind string}
  
  Creates a new backup run on demand."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/backupRuns"
     #{:instance :project}
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
  "https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/backupRuns/list
  
  Required parameters: project, instance
  
  Optional parameters: maxResults, pageToken
  
  Lists all backup runs associated with the project or a given instance and configuration in the reverse chronological order of the backup initiation time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/backupRuns"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
