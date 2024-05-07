(ns happygapi.factchecktools.claims
  "Fact Check Tools API: claims.
  
  See: https://developers.google.com/fact-check/tools/api/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://developers.google.com/fact-check/tools/api/reference/rest/v1alpha1/claims/search
  
  Required parameters: none
  
  Optional parameters: maxAgeDays, reviewPublisherSiteFilter, offset, languageCode, query, pageToken, pageSize
  
  Search through fact-checked claims."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://factchecktools.googleapis.com/"
     "v1alpha1/claims:search"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn imageSearch$
  "https://developers.google.com/fact-check/tools/api/reference/rest/v1alpha1/claims/imageSearch
  
  Required parameters: none
  
  Optional parameters: languageCode, pageSize, offset, pageToken, imageUri
  
  Search through fact-checked claims using an image as the query."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://factchecktools.googleapis.com/"
     "v1alpha1/claims:imageSearch"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
