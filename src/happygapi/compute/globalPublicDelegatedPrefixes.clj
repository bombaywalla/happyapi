(ns happygapi.compute.globalPublicDelegatedPrefixes
  "Compute Engine API: globalPublicDelegatedPrefixes.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/products/compute"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/products/compute/v1/docs/globalPublicDelegatedPrefixes/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Lists the global PublicDelegatedPrefixes for a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/publicDelegatedPrefixes"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/products/compute/v1/docs/globalPublicDelegatedPrefixes/get
  
  Required parameters: project, publicDelegatedPrefix
  
  Optional parameters: none
  
  Returns the specified global PublicDelegatedPrefix resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:publicDelegatedPrefix :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/publicDelegatedPrefixes/{publicDelegatedPrefix}"
     #{:publicDelegatedPrefix :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/products/compute/v1/docs/globalPublicDelegatedPrefixes/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :allocatablePrefixLength integer,
   :creationTimestamp string,
   :isLiveMigration boolean,
   :name string,
   :ipCidrRange string,
   :mode string,
   :selfLink string,
   :byoipApiVersion string,
   :region string,
   :status string,
   :id string,
   :kind string,
   :parentPrefix string,
   :publicDelegatedSubPrefixs [{:description string,
                                :allocatablePrefixLength integer,
                                :delegateeProject string,
                                :name string,
                                :ipCidrRange string,
                                :mode string,
                                :region string,
                                :status string,
                                :isAddress boolean}],
   :fingerprint string}
  
  Creates a global PublicDelegatedPrefix in the specified project using the parameters that are included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/publicDelegatedPrefixes"
     #{:project}
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
  "https://cloud.google.com/products/compute/v1/docs/globalPublicDelegatedPrefixes/delete
  
  Required parameters: project, publicDelegatedPrefix
  
  Optional parameters: requestId
  
  Deletes the specified global PublicDelegatedPrefix."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:publicDelegatedPrefix :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/publicDelegatedPrefixes/{publicDelegatedPrefix}"
     #{:publicDelegatedPrefix :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/products/compute/v1/docs/globalPublicDelegatedPrefixes/patch
  
  Required parameters: project, publicDelegatedPrefix
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :allocatablePrefixLength integer,
   :creationTimestamp string,
   :isLiveMigration boolean,
   :name string,
   :ipCidrRange string,
   :mode string,
   :selfLink string,
   :byoipApiVersion string,
   :region string,
   :status string,
   :id string,
   :kind string,
   :parentPrefix string,
   :publicDelegatedSubPrefixs [{:description string,
                                :allocatablePrefixLength integer,
                                :delegateeProject string,
                                :name string,
                                :ipCidrRange string,
                                :mode string,
                                :region string,
                                :status string,
                                :isAddress boolean}],
   :fingerprint string}
  
  Patches the specified global PublicDelegatedPrefix resource with the data included in the request. This method supports PATCH semantics and uses JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:publicDelegatedPrefix :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/publicDelegatedPrefixes/{publicDelegatedPrefix}"
     #{:publicDelegatedPrefix :project}
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
