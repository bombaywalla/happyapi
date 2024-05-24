(ns happygapi.cloudsearch.debug
  "Cloud Search API: debug.
  Cloud Search provides cloud-based search capabilities over Google Workspace data. The Cloud Search API allows indexing of non-Google Workspace data into Cloud Search.
  See: https://developers.google.com/cloud-search/docs/guides/docs/reference/rest/v1/debug"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn datasources-items-checkAccess$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/debug/datasources/items/checkAccess
  
  Required parameters: name
  
  Optional parameters: debugOptions.enableDebugging
  
  Body: 
  
  {:gsuitePrincipal {:gsuiteUserEmail string,
                     :gsuiteGroupEmail string,
                     :gsuiteDomain boolean},
   :userResourceName string,
   :groupResourceName string}
  
  Checks whether an item is accessible by specified principal. Principal must be a user; groups and domain values aren't supported. **Note:** This API requires an admin account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.debug"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/debug/{+name}:checkAccess"
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

(defn datasources-items-searchByViewUrl$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/debug/datasources/items/searchByViewUrl
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:viewUrl string,
   :pageToken string,
   :debugOptions {:enableDebugging boolean}}
  
  Fetches the item whose viewUrl exactly matches that of the URL provided in the request. **Note:** This API requires an admin account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.debug"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/debug/{+name}/items:searchByViewUrl"
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

(defn datasources-items-unmappedids-list$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/debug/datasources/items/unmappedids/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, debugOptions.enableDebugging
  
  List all unmapped identities for a specific item. **Note:** This API requires an admin account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.debug"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/debug/{+parent}/unmappedids"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn identitysources-unmappedids-list$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/debug/identitysources/unmappedids/list
  
  Required parameters: parent
  
  Optional parameters: resolutionStatusCode, pageToken, pageSize, debugOptions.enableDebugging
  
  Lists unmapped user identities for an identity source. **Note:** This API requires an admin account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.debug"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/debug/{+parent}/unmappedids"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn identitysources-items-listForunmappedidentity$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/debug/identitysources/items/listForunmappedidentity
  
  Required parameters: parent
  
  Optional parameters: userResourceName, groupResourceName, pageToken, pageSize, debugOptions.enableDebugging
  
  Lists names of items associated with an unmapped identity. **Note:** This API requires an admin account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.debug"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/debug/{+parent}/items:forunmappedidentity"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
