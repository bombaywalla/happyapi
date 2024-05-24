(ns happygapi.compute.routes
  "Compute Engine API: routes.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/docs/reference/rest/v1/routes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/routes/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves the list of Route resources available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/routes"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/routes/get
  
  Required parameters: project, route
  
  Optional parameters: none
  
  Returns the specified Route resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:route :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/routes/{route}"
     #{:route :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/routes/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:nextHopIp string,
   :description string,
   :tags [string],
   :nextHopNetwork string,
   :nextHopInstance string,
   :creationTimestamp string,
   :nextHopPeering string,
   :nextHopIlb string,
   :routeStatus string,
   :name string,
   :selfLink string,
   :warnings [{:code string,
               :message string,
               :data [{:key string, :value string}]}],
   :nextHopVpnTunnel string,
   :priority integer,
   :id string,
   :kind string,
   :nextHopHub string,
   :network string,
   :asPaths [{:pathSegmentType string, :asLists [integer]}],
   :nextHopGateway string,
   :routeType string,
   :destRange string}
  
  Creates a Route resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/routes"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/routes/delete
  
  Required parameters: project, route
  
  Optional parameters: requestId
  
  Deletes the specified Route resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:route :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/routes/{route}"
     #{:route :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
