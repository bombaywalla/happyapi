(ns happygapi.searchconsole.urlInspection
  "Google Search Console API: urlInspection.
  The Search Console API provides access to both Search Console data (verified users only) and to public information on an URL basis (anyone)
  See: https://developer.chrome.com/docs/lighthouse/overview/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn index-inspect$
  "https://developer.chrome.com/docs/lighthouse/overview
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:languageCode string, :inspectionUrl string, :siteUrl string}
  
  Index inspection."
  {:scopes ["https://www.googleapis.com/auth/webmasters"
            "https://www.googleapis.com/auth/webmasters.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://searchconsole.googleapis.com/"
     "v1/urlInspection/index:inspect"
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
