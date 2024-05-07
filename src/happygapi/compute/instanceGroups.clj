(ns happygapi.compute.instanceGroups
  "Compute Engine API: instanceGroups.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/products/compute"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroups/get
  
  Required parameters: instanceGroup, project, zone
  
  Optional parameters: none
  
  Returns the specified zonal instance group. Get a list of available zonal instance groups by making a list() request. For managed instance groups, use the instanceGroupManagers or regionInstanceGroupManagers methods instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project :instanceGroup})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroups/{instanceGroup}"
     #{:zone :project :instanceGroup}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroups/insert
  
  Required parameters: project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :zone string,
   :name string,
   :selfLink string,
   :size integer,
   :region string,
   :id string,
   :kind string,
   :network string,
   :fingerprint string,
   :subnetwork string,
   :namedPorts [{:name string, :port integer}]}
  
  Creates an instance group in the specified project using the parameters that are included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroups"
     #{:zone :project}
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

(defn addInstances$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroups/addInstances
  
  Required parameters: instanceGroup, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [{:instance string}]}
  
  Adds a list of instances to the specified instance group. All of the instances in the instance group must be in the same network/subnetwork. Read Adding instances for more information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project :instanceGroup})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroups/{instanceGroup}/addInstances"
     #{:zone :project :instanceGroup}
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

(defn aggregatedList$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroups/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken, returnPartialSuccess, serviceProjectNumber
  
  Retrieves the list of instance groups and sorts them by zone. To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to `true`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/instanceGroups"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroups/delete
  
  Required parameters: instanceGroup, project, zone
  
  Optional parameters: requestId
  
  Deletes the specified instance group. The instances in the group are not deleted. Note that instance group must not belong to a backend service. Read Deleting an instance group for more information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project :instanceGroup})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroups/{instanceGroup}"
     #{:zone :project :instanceGroup}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setNamedPorts$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroups/setNamedPorts
  
  Required parameters: instanceGroup, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:namedPorts [{:name string, :port integer}], :fingerprint string}
  
  Sets the named ports for the specified instance group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project :instanceGroup})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroups/{instanceGroup}/setNamedPorts"
     #{:zone :project :instanceGroup}
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
  "https://cloud.google.com/products/compute/v1/docs/instanceGroups/list
  
  Required parameters: project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves the list of zonal instance group resources contained within the specified zone. For managed instance groups, use the instanceGroupManagers or regionInstanceGroupManagers methods instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroups"
     #{:zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listInstances$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroups/listInstances
  
  Required parameters: instanceGroup, project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Body: 
  
  {:instanceState string}
  
  Lists the instances in the specified instance group. The orderBy query parameter is not supported. The filter query parameter is supported, but only for expressions that use `eq` (equal) or `ne` (not equal) operators."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project :instanceGroup})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroups/{instanceGroup}/listInstances"
     #{:zone :project :instanceGroup}
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

(defn removeInstances$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroups/removeInstances
  
  Required parameters: instanceGroup, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [{:instance string}]}
  
  Removes one or more instances from the specified instance group, but does not delete those instances. If the group is part of a backend service that has enabled connection draining, it can take up to 60 seconds after the connection draining duration before the VM instance is removed or deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project :instanceGroup})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroups/{instanceGroup}/removeInstances"
     #{:zone :project :instanceGroup}
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
