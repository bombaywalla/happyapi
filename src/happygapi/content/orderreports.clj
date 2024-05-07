(ns happygapi.content.orderreports
  "Content API for Shopping: orderreports.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/guides/quickstart"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn listdisbursements$
  "https://developers.google.com/shopping-content/guides/quickstart
  
  Required parameters: merchantId
  
  Optional parameters: maxResults, pageToken, disbursementStartDate, disbursementEndDate
  
  Retrieves a report for disbursements from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orderreports/disbursements"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listtransactions$
  "https://developers.google.com/shopping-content/guides/quickstart
  
  Required parameters: merchantId, disbursementId
  
  Optional parameters: maxResults, pageToken, transactionStartDate, transactionEndDate
  
  Retrieves a list of transactions for a disbursement from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:disbursementId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orderreports/disbursements/{disbursementId}/transactions"
     #{:disbursementId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
