(ns happygapi.content.pos
  "Content API for Shopping: pos.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/docs/reference/rest/v2.1/pos"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn custombatch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/pos/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:batchId integer,
              :merchantId string,
              :method string,
              :targetMerchantId string,
              :storeCode string,
              :store PosStore,
              :inventory PosInventory,
              :sale PosSale}]}
  
  Batches multiple POS-related calls in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "pos/batch"
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

(defn delete$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/pos/delete
  
  Required parameters: merchantId, targetMerchantId, storeCode
  
  Optional parameters: none
  
  Deletes a store for the given merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:targetMerchantId :storeCode :merchantId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/store/{storeCode}"
     #{:targetMerchantId :storeCode :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/pos/get
  
  Required parameters: merchantId, targetMerchantId, storeCode
  
  Optional parameters: none
  
  Retrieves information about the given store."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:targetMerchantId :storeCode :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/store/{storeCode}"
     #{:targetMerchantId :storeCode :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/pos/insert
  
  Required parameters: merchantId, targetMerchantId
  
  Optional parameters: none
  
  Body: 
  
  {:websiteUrl string,
   :gcidCategory [string],
   :matchingStatusHint string,
   :storeAddress string,
   :kind string,
   :storeCode string,
   :matchingStatus string,
   :placeId string,
   :phoneNumber string,
   :storeName string}
  
  Creates a store for the given merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetMerchantId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/store"
     #{:targetMerchantId :merchantId}
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

(defn inventory$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/pos/inventory
  
  Required parameters: merchantId, targetMerchantId
  
  Optional parameters: none
  
  Body: 
  
  {:pickupSla string,
   :contentLanguage string,
   :pickupMethod string,
   :storeCode string,
   :gtin string,
   :quantity string,
   :targetCountry string,
   :timestamp string,
   :price {:value string, :currency string},
   :itemId string}
  
  Submit inventory for the given merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetMerchantId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/inventory"
     #{:targetMerchantId :merchantId}
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

(defn list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/pos/list
  
  Required parameters: merchantId, targetMerchantId
  
  Optional parameters: none
  
  Lists the stores of the target merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:targetMerchantId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/store"
     #{:targetMerchantId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sale$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/pos/sale
  
  Required parameters: merchantId, targetMerchantId
  
  Optional parameters: none
  
  Body: 
  
  {:saleId string,
   :contentLanguage string,
   :storeCode string,
   :gtin string,
   :quantity string,
   :targetCountry string,
   :timestamp string,
   :price {:value string, :currency string},
   :itemId string}
  
  Submit a sale event for the given merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetMerchantId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/sale"
     #{:targetMerchantId :merchantId}
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
