(ns happygapi.deploymentmanager.resources
  "Cloud Deployment Manager V2 API: resources.
  The Google Cloud Deployment Manager v2 API provides services for configuring, deploying, and viewing Google Cloud services and APIs via templates which specify deployments of Cloud resources.
  See: https://cloud.google.com/deployment-manager/docs"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/deployment-manager/docs
  
  Required parameters: project, deployment, resource
  
  Optional parameters: none
  
  Gets information about a single resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.cloudman"
            "https://www.googleapis.com/auth/ndev.cloudman.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :resource :deployment})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://deploymentmanager.googleapis.com/"
     "deploymentmanager/v2/projects/{project}/global/deployments/{deployment}/resources/{resource}"
     #{:project :resource :deployment}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/deployment-manager/docs
  
  Required parameters: project, deployment
  
  Optional parameters: maxResults, pageToken, filter, orderBy
  
  Lists all resources in a given deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.cloudman"
            "https://www.googleapis.com/auth/ndev.cloudman.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :deployment})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://deploymentmanager.googleapis.com/"
     "deploymentmanager/v2/projects/{project}/global/deployments/{deployment}/resources"
     #{:project :deployment}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
