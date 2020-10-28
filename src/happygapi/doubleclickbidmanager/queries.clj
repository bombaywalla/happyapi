(ns happygapi.doubleclickbidmanager.queries
  "DoubleClick Bid Manager API: queries.
  DoubleClick Bid Manager API allows users to manage and create campaigns and reports.
  See: https://developers.google.com/bid-manager/api/reference/rest/v1.1/queries"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn deletequery$
  "https://developers.google.com/bid-manager/api/reference/rest/v1.1/queries/deletequery
  
  Required parameters: queryId
  
  Optional parameters: none
  
  Deletes a stored query as well as the associated stored reports."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:queryId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://doubleclickbidmanager.googleapis.com/doubleclickbidmanager/v1.1/"
     "query/{queryId}"
     #{:queryId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn runquery$
  "https://developers.google.com/bid-manager/api/reference/rest/v1.1/queries/runquery
  
  Required parameters: queryId
  
  Optional parameters: asynchronous
  
  Body: 
  
  {:reportDataEndTimeMs string,
   :timezoneCode string,
   :reportDataStartTimeMs string,
   :dataRange string}
  
  Runs a stored query to generate a report."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:queryId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://doubleclickbidmanager.googleapis.com/doubleclickbidmanager/v1.1/"
     "query/{queryId}"
     #{:queryId}
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

(defn getquery$
  "https://developers.google.com/bid-manager/api/reference/rest/v1.1/queries/getquery
  
  Required parameters: queryId
  
  Optional parameters: none
  
  Retrieves a stored query."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:queryId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://doubleclickbidmanager.googleapis.com/doubleclickbidmanager/v1.1/"
     "query/{queryId}"
     #{:queryId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn createquery$
  "https://developers.google.com/bid-manager/api/reference/rest/v1.1/queries/createquery
  
  Required parameters: none
  
  Optional parameters: asynchronous
  
  Body: 
  
  {:reportDataStartTimeMs string,
   :kind string,
   :metadata {:format string,
              :locale string,
              :sendNotification boolean,
              :dataRange string,
              :latestReportRunTimeMs string,
              :title string,
              :running boolean,
              :googleCloudStoragePathForLatestReport string,
              :reportCount integer,
              :shareEmailAddress [string],
              :googleDrivePathForLatestReport string},
   :schedule {:nextRunTimezoneCode string,
              :endTimeMs string,
              :frequency string,
              :nextRunMinuteOfDay integer,
              :startTimeMs string},
   :params {:filters [FilterPair],
            :metrics [string],
            :type string,
            :groupBys [string],
            :includeInviteData boolean,
            :options Options},
   :timezoneCode string,
   :reportDataEndTimeMs string,
   :queryId string}
  
  Creates a query."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://doubleclickbidmanager.googleapis.com/doubleclickbidmanager/v1.1/"
     "query"
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

(defn listqueries$
  "https://developers.google.com/bid-manager/api/reference/rest/v1.1/queries/listqueries
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize
  
  Retrieves stored queries."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://doubleclickbidmanager.googleapis.com/doubleclickbidmanager/v1.1/"
     "queries"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
