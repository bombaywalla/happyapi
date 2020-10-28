(ns happygapi.apigateway.projects
  "API Gateway API: projects.
  
  See:  https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+name}/locations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-gateways-get$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/gateways/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Gateway."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-gateways-setIamPolicy$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/gateways/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:bindings [ApigatewayBinding],
            :etag string,
            :auditConfigs [ApigatewayAuditConfig],
            :version integer}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-gateways-create$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/gateways/create
  
  Required parameters: parent
  
  Optional parameters: gatewayId
  
  Body: 
  
  {:defaultHostname string,
   :apiConfig string,
   :displayName string,
   :name string,
   :createTime string,
   :updateTime string,
   :state string,
   :labels {}}
  
  Creates a new Gateway in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+parent}/gateways"
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

(defn locations-gateways-delete$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/gateways/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single Gateway."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-gateways-getIamPolicy$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/gateways/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-gateways-list$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/gateways/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, orderBy, filter, pageSize
  
  Lists Gateways in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+parent}/gateways"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-gateways-patch$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/gateways/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:defaultHostname string,
   :apiConfig string,
   :displayName string,
   :name string,
   :createTime string,
   :updateTime string,
   :state string,
   :labels {}}
  
  Updates the parameters of a single Gateway."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+name}"
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

(defn locations-gateways-testIamPermissions$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/gateways/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-apis-patch$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/apis/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:state string,
   :displayName string,
   :createTime string,
   :updateTime string,
   :managedService string,
   :labels {},
   :name string}
  
  Updates the parameters of a single Api."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+name}"
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

(defn locations-apis-get$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/apis/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Api."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-create$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/apis/create
  
  Required parameters: parent
  
  Optional parameters: apiId
  
  Body: 
  
  {:state string,
   :displayName string,
   :createTime string,
   :updateTime string,
   :managedService string,
   :labels {},
   :name string}
  
  Creates a new Api in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+parent}/apis"
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

(defn locations-apis-delete$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/apis/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single Api."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-testIamPermissions$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/apis/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-apis-setIamPolicy$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/apis/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:bindings [ApigatewayBinding],
            :etag string,
            :auditConfigs [ApigatewayAuditConfig],
            :version integer}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-apis-getIamPolicy$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/apis/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-list$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/apis/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, orderBy, pageToken, filter
  
  Lists Apis in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+parent}/apis"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-configs-list$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/apis/configs/list
  
  Required parameters: parent
  
  Optional parameters: filter, orderBy, pageSize, pageToken
  
  Lists ApiConfigs in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+parent}/configs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-configs-getIamPolicy$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/apis/configs/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-configs-delete$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/apis/configs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single ApiConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-configs-patch$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/apis/configs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:serviceConfigId string,
   :labels {},
   :gatewayConfig {:backendConfig ApigatewayBackendConfig},
   :displayName string,
   :name string,
   :grpcServices [{:fileDescriptorSet ApigatewayApiConfigFile,
                   :source [ApigatewayApiConfigFile]}],
   :createTime string,
   :state string,
   :managedServiceConfigs [{:contents string, :path string}],
   :updateTime string,
   :openapiDocuments [{:document ApigatewayApiConfigFile}]}
  
  Updates the parameters of a single ApiConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+name}"
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

(defn locations-apis-configs-testIamPermissions$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/apis/configs/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-apis-configs-create$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/apis/configs/create
  
  Required parameters: parent
  
  Optional parameters: apiConfigId
  
  Body: 
  
  {:serviceConfigId string,
   :labels {},
   :gatewayConfig {:backendConfig ApigatewayBackendConfig},
   :displayName string,
   :name string,
   :grpcServices [{:fileDescriptorSet ApigatewayApiConfigFile,
                   :source [ApigatewayApiConfigFile]}],
   :createTime string,
   :state string,
   :managedServiceConfigs [{:contents string, :path string}],
   :updateTime string,
   :openapiDocuments [{:document ApigatewayApiConfigFile}]}
  
  Creates a new ApiConfig in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+parent}/configs"
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

(defn locations-apis-configs-get$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/apis/configs/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets details of a single ApiConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-configs-setIamPolicy$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/apis/configs/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:bindings [ApigatewayBinding],
            :etag string,
            :auditConfigs [ApigatewayAuditConfig],
            :version integer}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-operations-get$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-delete$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-cancel$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+name}:cancel"
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

(defn locations-operations-list$
  " https://cloud.google.com/api-gateway/docsapi/reference/rest/v1beta/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigateway.googleapis.com/"
     "v1beta/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))