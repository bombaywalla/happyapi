(ns happygapi.compute.regionTargetHttpProxies
  "Compute Engine API: regionTargetHttpProxies.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/products/compute"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/products/compute/v1/docs/regionTargetHttpProxies/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves the list of TargetHttpProxy resources available to the specified project in the specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetHttpProxies"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/products/compute/v1/docs/regionTargetHttpProxies/get
  
  Required parameters: project, region, targetHttpProxy
  
  Optional parameters: none
  
  Returns the specified TargetHttpProxy resource in the specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:targetHttpProxy :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetHttpProxies/{targetHttpProxy}"
     #{:targetHttpProxy :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/products/compute/v1/docs/regionTargetHttpProxies/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :urlMap string,
   :name string,
   :httpKeepAliveTimeoutSec integer,
   :selfLink string,
   :region string,
   :id string,
   :kind string,
   :fingerprint string,
   :proxyBind boolean}
  
  Creates a TargetHttpProxy resource in the specified project and region using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetHttpProxies"
     #{:region :project}
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
  "https://cloud.google.com/products/compute/v1/docs/regionTargetHttpProxies/delete
  
  Required parameters: project, region, targetHttpProxy
  
  Optional parameters: requestId
  
  Deletes the specified TargetHttpProxy resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:targetHttpProxy :region :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetHttpProxies/{targetHttpProxy}"
     #{:targetHttpProxy :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setUrlMap$
  "https://cloud.google.com/products/compute/v1/docs/regionTargetHttpProxies/setUrlMap
  
  Required parameters: project, region, targetHttpProxy
  
  Optional parameters: requestId
  
  Body: 
  
  {:urlMap string}
  
  Changes the URL map for TargetHttpProxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:targetHttpProxy :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetHttpProxies/{targetHttpProxy}/setUrlMap"
     #{:targetHttpProxy :region :project}
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
