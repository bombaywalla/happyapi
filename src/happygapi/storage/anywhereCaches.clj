(ns happygapi.storage.anywhereCaches
  "Cloud Storage JSON API: anywhereCaches.
  Stores and retrieves potentially large, immutable data objects.
  See: https://cloud.google.com/storage/docs/json_api"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://cloud.google.com/storage/docs/reference/rest/v1/anywhereCaches/insert
  
  Required parameters: bucket
  
  Optional parameters: none
  
  Body: 
  
  {:zone string,
   :createTime string,
   :selfLink string,
   :anywhereCacheId string,
   :state string,
   :updateTime string,
   :ttl string,
   :id string,
   :kind string,
   :pendingUpdate boolean,
   :admissionPolicy string,
   :bucket string}
  
  Creates an Anywhere Cache instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:bucket})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/anywhereCaches"
     #{:bucket}
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

(defn update$
  "https://cloud.google.com/storage/docs/reference/rest/v1/anywhereCaches/update
  
  Required parameters: bucket, anywhereCacheId
  
  Optional parameters: none
  
  Body: 
  
  {:zone string,
   :createTime string,
   :selfLink string,
   :anywhereCacheId string,
   :state string,
   :updateTime string,
   :ttl string,
   :id string,
   :kind string,
   :pendingUpdate boolean,
   :admissionPolicy string,
   :bucket string}
  
  Updates the config(ttl and admissionPolicy) of an Anywhere Cache instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:anywhereCacheId :bucket})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/anywhereCaches/{anywhereCacheId}"
     #{:anywhereCacheId :bucket}
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
  "https://cloud.google.com/storage/docs/reference/rest/v1/anywhereCaches/get
  
  Required parameters: bucket, anywhereCacheId
  
  Optional parameters: none
  
  Returns the metadata of an Anywhere Cache instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:anywhereCacheId :bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/anywhereCaches/{anywhereCacheId}"
     #{:anywhereCacheId :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/storage/docs/reference/rest/v1/anywhereCaches/list
  
  Required parameters: bucket
  
  Optional parameters: pageSize, pageToken
  
  Returns a list of Anywhere Cache instances of the bucket matching the criteria."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/anywhereCaches"
     #{:bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn pause$
  "https://cloud.google.com/storage/docs/reference/rest/v1/anywhereCaches/pause
  
  Required parameters: bucket, anywhereCacheId
  
  Optional parameters: none
  
  Pauses an Anywhere Cache instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:anywhereCacheId :bucket})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/anywhereCaches/{anywhereCacheId}/pause"
     #{:anywhereCacheId :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resume$
  "https://cloud.google.com/storage/docs/reference/rest/v1/anywhereCaches/resume
  
  Required parameters: bucket, anywhereCacheId
  
  Optional parameters: none
  
  Resumes a paused or disabled Anywhere Cache instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:anywhereCacheId :bucket})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/anywhereCaches/{anywhereCacheId}/resume"
     #{:anywhereCacheId :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn disable$
  "https://cloud.google.com/storage/docs/reference/rest/v1/anywhereCaches/disable
  
  Required parameters: bucket, anywhereCacheId
  
  Optional parameters: none
  
  Disables an Anywhere Cache instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:anywhereCacheId :bucket})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/anywhereCaches/{anywhereCacheId}/disable"
     #{:anywhereCacheId :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
