(ns happygapi.content.orderreturns
  "Content API for Shopping: orderreturns.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/guides/quickstart"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn acknowledge$
  "https://developers.google.com/shopping-content/guides/quickstart
  
  Required parameters: merchantId, returnId
  
  Optional parameters: none
  
  Body: 
  
  {:operationId string}
  
  Acks an order return in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:returnId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orderreturns/{returnId}/acknowledge"
     #{:returnId :merchantId}
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

(defn createorderreturn$
  "https://developers.google.com/shopping-content/guides/quickstart
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:orderId string,
   :operationId string,
   :lineItems [{:lineItemId string,
                :productId string,
                :quantity integer}],
   :returnMethodType string}
  
  Create return in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orderreturns/createOrderReturn"
     #{:merchantId}
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

(defn get$
  "https://developers.google.com/shopping-content/guides/quickstart
  
  Required parameters: merchantId, returnId
  
  Optional parameters: none
  
  Retrieves an order return from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:returnId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orderreturns/{returnId}"
     #{:returnId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/shopping-content/guides/quickstart
  
  Required parameters: merchantId
  
  Optional parameters: createdEndDate, shipmentTypes, shipmentTrackingNumbers, shipmentStatus, createdStartDate, googleOrderIds, pageToken, acknowledged, maxResults, orderBy, shipmentStates
  
  Lists order returns in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orderreturns"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn process$
  "https://developers.google.com/shopping-content/guides/quickstart
  
  Required parameters: merchantId, returnId
  
  Optional parameters: none
  
  Body: 
  
  {:operationId string,
   :returnItems [{:returnItemId string,
                  :refund OrderreturnsRefundOperation,
                  :reject OrderreturnsRejectOperation}],
   :fullChargeReturnShippingCost boolean,
   :refundShippingFee {:returnRefundReason string,
                       :fullRefund boolean,
                       :partialRefund OrderreturnsPartialRefund,
                       :reasonText string,
                       :paymentType string}}
  
  Processes return in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:returnId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orderreturns/{returnId}/process"
     #{:returnId :merchantId}
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

(defn labels-create$
  "https://developers.google.com/shopping-content/guides/quickstart
  
  Required parameters: merchantId, returnId
  
  Optional parameters: none
  
  Body: 
  
  {:labelUri string, :carrier string, :trackingId string}
  
  Links a return shipping label to a return id. You can only create one return label per return id. Since the label is sent to the buyer, the linked return label cannot be updated or deleted. If you try to create multiple return shipping labels for a single return id, every create request except the first will fail."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:returnId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orderreturns/{returnId}/labels"
     #{:returnId :merchantId}
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
