(ns happygapi.cloudsearch.stats
  "Cloud Search API: stats.
  Cloud Search provides cloud-based search capabilities over Google Workspace data. The Cloud Search API allows indexing of non-Google Workspace data into Cloud Search.
  See: https://developers.google.com/cloud-search/docs/guides/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getIndex$
  "https://developers.google.com/cloud-search/docs/reference/rest/v1/stats/getIndex
  
  Required parameters: none
  
  Optional parameters: fromDate.year, fromDate.month, fromDate.day, toDate.year, toDate.month, toDate.day
  
  Gets indexed item statistics aggreggated across all data sources. This API only returns statistics for previous dates; it doesn't return statistics for the current day. **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/index"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getQuery$
  "https://developers.google.com/cloud-search/docs/reference/rest/v1/stats/getQuery
  
  Required parameters: none
  
  Optional parameters: fromDate.year, fromDate.month, fromDate.day, toDate.year, toDate.month, toDate.day
  
  Get the query statistics for customer. **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/query"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getUser$
  "https://developers.google.com/cloud-search/docs/reference/rest/v1/stats/getUser
  
  Required parameters: none
  
  Optional parameters: fromDate.year, fromDate.month, fromDate.day, toDate.year, toDate.month, toDate.day
  
  Get the users statistics for customer. **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/user"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getSession$
  "https://developers.google.com/cloud-search/docs/reference/rest/v1/stats/getSession
  
  Required parameters: none
  
  Optional parameters: fromDate.year, fromDate.month, fromDate.day, toDate.year, toDate.month, toDate.day
  
  Get the # of search sessions, % of successful sessions with a click query statistics for customer. **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/session"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getSearchapplication$
  "https://developers.google.com/cloud-search/docs/reference/rest/v1/stats/getSearchapplication
  
  Required parameters: none
  
  Optional parameters: startDate.year, startDate.month, startDate.day, endDate.year, endDate.month, endDate.day
  
  Get search application stats for customer. **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/searchapplication"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn index-datasources-get$
  "https://developers.google.com/cloud-search/docs/reference/rest/v1/stats.index.datasources/get
  
  Required parameters: name
  
  Optional parameters: fromDate.year, fromDate.month, fromDate.day, toDate.year, toDate.month, toDate.day
  
  Gets indexed item statistics for a single data source. **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/index/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn query-searchapplications-get$
  "https://developers.google.com/cloud-search/docs/reference/rest/v1/stats.query.searchapplications/get
  
  Required parameters: name
  
  Optional parameters: fromDate.year, fromDate.month, fromDate.day, toDate.year, toDate.month, toDate.day
  
  Get the query statistics for search application. **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/query/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn user-searchapplications-get$
  "https://developers.google.com/cloud-search/docs/reference/rest/v1/stats.user.searchapplications/get
  
  Required parameters: name
  
  Optional parameters: fromDate.year, fromDate.month, fromDate.day, toDate.year, toDate.month, toDate.day
  
  Get the users statistics for search application. **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/user/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn session-searchapplications-get$
  "https://developers.google.com/cloud-search/docs/reference/rest/v1/stats.session.searchapplications/get
  
  Required parameters: name
  
  Optional parameters: fromDate.year, fromDate.month, fromDate.day, toDate.year, toDate.month, toDate.day
  
  Get the # of search sessions, % of successful sessions with a click query statistics for search application. **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/session/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
