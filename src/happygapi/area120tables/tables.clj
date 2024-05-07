(ns happygapi.area120tables.tables
  "Area120 Tables API: tables.
  
  See: https://support.google.com/area120-tables/answer/10011390"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://support.google.com/area120-tables/answer/10011390
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a table. Returns NOT_FOUND if the table does not exist."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/spreadsheets.readonly"
            "https://www.googleapis.com/auth/tables"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://support.google.com/area120-tables/answer/10011390
  
  Required parameters: none
  
  Optional parameters: pageSize, orderBy, pageToken
  
  Lists tables for the user."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/spreadsheets.readonly"
            "https://www.googleapis.com/auth/tables"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/tables"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn rows-get$
  "https://support.google.com/area120-tables/answer/10011390
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets a row. Returns NOT_FOUND if the row does not exist in the table."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/spreadsheets.readonly"
            "https://www.googleapis.com/auth/tables"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn rows-patch$
  "https://support.google.com/area120-tables/answer/10011390
  
  Required parameters: name
  
  Optional parameters: view, updateMask
  
  Body: 
  
  {:values {}, :name string, :createTime string, :updateTime string}
  
  Updates a row."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/tables"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/{+name}"
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

(defn rows-delete$
  "https://support.google.com/area120-tables/answer/10011390
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a row."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/tables"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn rows-batchDelete$
  "https://support.google.com/area120-tables/answer/10011390
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:names [string]}
  
  Deletes multiple rows."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/tables"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/{+parent}/rows:batchDelete"
     #{:parent}
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

(defn rows-batchCreate$
  "https://support.google.com/area120-tables/answer/10011390
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:view string, :parent string, :row Row}]}
  
  Creates multiple rows."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/tables"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/{+parent}/rows:batchCreate"
     #{:parent}
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

(defn rows-batchUpdate$
  "https://support.google.com/area120-tables/answer/10011390
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:view string, :updateMask string, :row Row}]}
  
  Updates multiple rows."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/tables"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/{+parent}/rows:batchUpdate"
     #{:parent}
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

(defn rows-create$
  "https://support.google.com/area120-tables/answer/10011390
  
  Required parameters: parent
  
  Optional parameters: view
  
  Body: 
  
  {:values {}, :name string, :createTime string, :updateTime string}
  
  Creates a row."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/tables"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/{+parent}/rows"
     #{:parent}
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

(defn rows-list$
  "https://support.google.com/area120-tables/answer/10011390
  
  Required parameters: parent
  
  Optional parameters: pageToken, view, pageSize, orderBy, filter
  
  Lists rows in a table. Returns NOT_FOUND if the table does not exist."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/spreadsheets.readonly"
            "https://www.googleapis.com/auth/tables"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/{+parent}/rows"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
