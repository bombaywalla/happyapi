(ns happygapi.content.settlementtransactions
  "Content API for Shopping: settlementtransactions.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/guides/quickstart"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/shopping-content/guides/quickstart
  
  Required parameters: merchantId, settlementId
  
  Optional parameters: maxResults, pageToken, transactionIds
  
  Retrieves a list of transactions for the settlement."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:settlementId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/settlementreports/{settlementId}/transactions"
     #{:settlementId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
