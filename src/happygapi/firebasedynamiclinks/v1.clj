(ns happygapi.firebasedynamiclinks.v1
  "Firebase Dynamic Links API: v1.
  Programmatically creates and manages Firebase Dynamic Links.
  See: https://firebase.google.com/docs/dynamic-links/docs/reference/rest/v1/v1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn $
  "https://firebase.google.com/docs/dynamic-links/api/reference/rest/v1/getLinkStats
  
  Required parameters: dynamicLink
  
  Optional parameters: durationDays, sdkVersion
  
  Fetches analytics stats of a short Dynamic Link for a given duration. Metrics include number of clicks, redirects, installs, app first opens, and app reopens."
  {:scopes ["https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:dynamicLink})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebasedynamiclinks.googleapis.com/"
     "v1/{dynamicLink}/linkStats"
     #{:dynamicLink}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://firebase.google.com/docs/dynamic-links/api/reference/rest/v1/installAttribution
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:device {:deviceModelName string,
            :languageCodeRaw string,
            :screenResolutionHeight string,
            :screenResolutionWidth string,
            :timezone string,
            :languageCode string,
            :languageCodeFromWebview string},
   :uniqueMatchLinkToCheck string,
   :retrievalMethod string,
   :iosVersion string,
   :appInstallationTime string,
   :sdkVersion string,
   :bundleId string,
   :visualStyle string}
  
  Get iOS strong/weak-match info for post-install attribution."
  {:scopes ["https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasedynamiclinks.googleapis.com/"
     "v1/installAttribution"
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

(defn $
  "https://firebase.google.com/docs/dynamic-links/api/reference/rest/v1/reopenAttribution
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:requestedLink string, :bundleId string, :sdkVersion string}
  
  Get iOS reopen attribution for app universal link open deeplinking."
  {:scopes ["https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasedynamiclinks.googleapis.com/"
     "v1/reopenAttribution"
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
