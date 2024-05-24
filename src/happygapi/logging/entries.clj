(ns happygapi.logging.entries
  "Cloud Logging API: entries.
  Writes log entries and manages your Cloud Logging configuration.
  See: https://cloud.google.com/logging/docs/docs/reference/rest/v2/entries"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn copy$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/entries/copy
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :filter string, :destination string}
  
  Copies a set of log entries from a log bucket to a Cloud Storage bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/entries:copy"
     #{}
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

(defn write$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/entries/write
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:logName string,
   :resource {:type string, :labels {}},
   :labels {},
   :entries [{:traceSampled boolean,
              :jsonPayload {},
              :labels {},
              :spanId string,
              :receiveTimestamp string,
              :trace string,
              :operation LogEntryOperation,
              :logName string,
              :textPayload string,
              :sourceLocation LogEntrySourceLocation,
              :split LogSplit,
              :resource MonitoredResource,
              :severity string,
              :insertId string,
              :httpRequest HttpRequest,
              :protoPayload {},
              :errorGroups [LogErrorGroup],
              :timestamp string,
              :metadata MonitoredResourceMetadata}],
   :partialSuccess boolean,
   :dryRun boolean}
  
  Writes log entries to Logging. This API method is the only way to send log entries to Logging. This method is used, directly or indirectly, by the Logging agent (fluentd) and all logging libraries configured to use Logging. A single request may contain log entries for a maximum of 1000 different resource names (projects, organizations, billing accounts or folders), where the resource name for a log entry is determined from its logName field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/entries:write"
     #{}
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
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/entries/list
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:projectIds [string],
   :resourceNames [string],
   :filter string,
   :orderBy string,
   :pageSize integer,
   :pageToken string}
  
  Lists log entries. Use this method to retrieve log entries that originated from a project/folder/organization/billing account. For ways to export log entries, see Exporting Logs (https://cloud.google.com/logging/docs/export)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/entries:list"
     #{}
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

(defn tail$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/entries/tail
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:resourceNames [string], :filter string, :bufferWindow string}
  
  Streaming read of log entries as they are received. Until the stream is terminated, it will continue reading logs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/entries:tail"
     #{}
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
