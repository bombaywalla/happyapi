(ns happygapi.doubleclicksearch.savedColumns
  "Search Ads 360 API: savedColumns.
  The Search Ads 360 API allows developers to automate uploading conversions and downloading reports from Search Ads 360.
  See: https://developers.google.com/search-ads"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/search-ads
  
  Required parameters: agencyId, advertiserId
  
  Optional parameters: none
  
  Retrieve the list of saved columns for a specified advertiser."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId :agencyId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://doubleclicksearch.googleapis.com/"
     "doubleclicksearch/v2/agency/{agencyId}/advertiser/{advertiserId}/savedcolumns"
     #{:advertiserId :agencyId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
