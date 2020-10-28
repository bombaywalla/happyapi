(ns happygapi.dfareporting.accountActiveAdSummaries
  "DCM/DFA Reporting And Trafficking API: accountActiveAdSummaries.
  Manage your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/accountActiveAdSummaries"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/accountActiveAdSummaries/get
  
  Required parameters: profileId, summaryAccountId
  
  Optional parameters: none
  
  Gets the account's active ad summary by account ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:summaryAccountId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/accountActiveAdSummaries/{summaryAccountId}"
     #{:summaryAccountId :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
