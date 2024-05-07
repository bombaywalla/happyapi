(ns happygapi.cloudkms.projects
  "Cloud Key Management Service (KMS) API: projects.
  Manages keys and performs cryptographic operations in a central cloud service, for direct use by other cloud resources and applications. 
  See: https://cloud.google.com/security/products/security-key-management"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-getEkmConfig$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/getEkmConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the EkmConfig singleton resource for a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-updateEkmConfig$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/updateEkmConfig
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :defaultEkmConnection string}
  
  Updates the EkmConfig singleton resource for a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
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

(defn locations-generateRandomBytes$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/generateRandomBytes
  
  Required parameters: location
  
  Optional parameters: none
  
  Body: 
  
  {:lengthBytes integer, :protectionLevel string}
  
  Generate random bytes using the Cloud KMS randomness source in the provided location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+location}:generateRandomBytes"
     #{:location}
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

(defn locations-list$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}/locations"
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
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-ekmConnections-list$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConnections/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists EkmConnections."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/ekmConnections"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-ekmConnections-get$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConnections/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns metadata for a given EkmConnection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-ekmConnections-create$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConnections/create
  
  Required parameters: parent
  
  Optional parameters: ekmConnectionId
  
  Body: 
  
  {:name string,
   :createTime string,
   :serviceResolvers [{:serviceDirectoryService string,
                       :endpointFilter string,
                       :hostname string,
                       :serverCertificates [Certificate]}],
   :etag string,
   :keyManagementMode string,
   :cryptoSpacePath string}
  
  Creates a new EkmConnection in a given Project and Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/ekmConnections"
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

(defn locations-ekmConnections-patch$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConnections/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :createTime string,
   :serviceResolvers [{:serviceDirectoryService string,
                       :endpointFilter string,
                       :hostname string,
                       :serverCertificates [Certificate]}],
   :etag string,
   :keyManagementMode string,
   :cryptoSpacePath string}
  
  Updates an EkmConnection's metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
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

(defn locations-ekmConnections-verifyConnectivity$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConnections/verifyConnectivity
  
  Required parameters: name
  
  Optional parameters: none
  
  Verifies that Cloud KMS can successfully connect to the external key manager specified by an EkmConnection. If there is an error connecting to the EKM, this method returns a FAILED_PRECONDITION status containing structured information as described at https://cloud.google.com/kms/docs/reference/ekm_errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:verifyConnectivity"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-ekmConnections-setIamPolicy$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConnections/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
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

(defn locations-ekmConnections-getIamPolicy$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConnections/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-ekmConnections-testIamPermissions$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConnections/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
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

(defn locations-keyRings-list$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists KeyRings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/keyRings"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-get$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns metadata for a given KeyRing."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-create$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/create
  
  Required parameters: parent
  
  Optional parameters: keyRingId
  
  Body: 
  
  {:name string, :createTime string}
  
  Create a new KeyRing in a given Project and Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/keyRings"
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

(defn locations-keyRings-setIamPolicy$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
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

(defn locations-keyRings-getIamPolicy$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-testIamPermissions$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
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

(defn locations-keyRings-cryptoKeys-get$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns metadata for a given CryptoKey, as well as its primary CryptoKeyVersion."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-setIamPolicy$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
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

(defn locations-keyRings-cryptoKeys-patch$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :nextRotationTime string,
   :importOnly boolean,
   :primary {:reimportEligible boolean,
             :algorithm string,
             :generateTime string,
             :generationFailureReason string,
             :importFailureReason string,
             :name string,
             :importTime string,
             :createTime string,
             :state string,
             :externalProtectionLevelOptions ExternalProtectionLevelOptions,
             :importJob string,
             :attestation KeyOperationAttestation,
             :protectionLevel string,
             :externalDestructionFailureReason string,
             :destroyTime string,
             :destroyEventTime string},
   :purpose string,
   :name string,
   :createTime string,
   :rotationPeriod string,
   :versionTemplate {:protectionLevel string, :algorithm string},
   :cryptoKeyBackend string,
   :destroyScheduledDuration string}
  
  Update a CryptoKey."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
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

(defn locations-keyRings-cryptoKeys-testIamPermissions$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
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

(defn locations-keyRings-cryptoKeys-create$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/create
  
  Required parameters: parent
  
  Optional parameters: cryptoKeyId, skipInitialVersionCreation
  
  Body: 
  
  {:labels {},
   :nextRotationTime string,
   :importOnly boolean,
   :primary {:reimportEligible boolean,
             :algorithm string,
             :generateTime string,
             :generationFailureReason string,
             :importFailureReason string,
             :name string,
             :importTime string,
             :createTime string,
             :state string,
             :externalProtectionLevelOptions ExternalProtectionLevelOptions,
             :importJob string,
             :attestation KeyOperationAttestation,
             :protectionLevel string,
             :externalDestructionFailureReason string,
             :destroyTime string,
             :destroyEventTime string},
   :purpose string,
   :name string,
   :createTime string,
   :rotationPeriod string,
   :versionTemplate {:protectionLevel string, :algorithm string},
   :cryptoKeyBackend string,
   :destroyScheduledDuration string}
  
  Create a new CryptoKey within a KeyRing. CryptoKey.purpose and CryptoKey.version_template.algorithm are required."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/cryptoKeys"
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

(defn locations-keyRings-cryptoKeys-encrypt$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/encrypt
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:plaintext string,
   :additionalAuthenticatedData string,
   :plaintextCrc32c string,
   :additionalAuthenticatedDataCrc32c string}
  
  Encrypts data, so that it can only be recovered by a call to Decrypt. The CryptoKey.purpose must be ENCRYPT_DECRYPT."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:encrypt"
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

(defn locations-keyRings-cryptoKeys-getIamPolicy$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-list$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, versionView, filter, orderBy
  
  Lists CryptoKeys."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/cryptoKeys"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-updatePrimaryVersion$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/updatePrimaryVersion
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:cryptoKeyVersionId string}
  
  Update the version of a CryptoKey that will be used in Encrypt. Returns an error if called on a key whose purpose is not ENCRYPT_DECRYPT."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:updatePrimaryVersion"
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

(defn locations-keyRings-cryptoKeys-decrypt$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/decrypt
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:ciphertext string,
   :additionalAuthenticatedData string,
   :ciphertextCrc32c string,
   :additionalAuthenticatedDataCrc32c string}
  
  Decrypts data that was protected by Encrypt. The CryptoKey.purpose must be ENCRYPT_DECRYPT."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:decrypt"
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

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-get$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns metadata for a given CryptoKeyVersion."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-patch$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:reimportEligible boolean,
   :algorithm string,
   :generateTime string,
   :generationFailureReason string,
   :importFailureReason string,
   :name string,
   :importTime string,
   :createTime string,
   :state string,
   :externalProtectionLevelOptions {:externalKeyUri string,
                                    :ekmConnectionKeyPath string},
   :importJob string,
   :attestation {:format string,
                 :content string,
                 :certChains CertificateChains},
   :protectionLevel string,
   :externalDestructionFailureReason string,
   :destroyTime string,
   :destroyEventTime string}
  
  Update a CryptoKeyVersion's metadata. state may be changed between ENABLED and DISABLED using this method. See DestroyCryptoKeyVersion and RestoreCryptoKeyVersion to move between other states."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
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

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-restore$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/restore
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Restore a CryptoKeyVersion in the DESTROY_SCHEDULED state. Upon restoration of the CryptoKeyVersion, state will be set to DISABLED, and destroy_time will be cleared."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:restore"
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

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-create$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:reimportEligible boolean,
   :algorithm string,
   :generateTime string,
   :generationFailureReason string,
   :importFailureReason string,
   :name string,
   :importTime string,
   :createTime string,
   :state string,
   :externalProtectionLevelOptions {:externalKeyUri string,
                                    :ekmConnectionKeyPath string},
   :importJob string,
   :attestation {:format string,
                 :content string,
                 :certChains CertificateChains},
   :protectionLevel string,
   :externalDestructionFailureReason string,
   :destroyTime string,
   :destroyEventTime string}
  
  Create a new CryptoKeyVersion in a CryptoKey. The server will assign the next sequential id. If unset, state will be set to ENABLED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/cryptoKeyVersions"
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

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-destroy$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/destroy
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Schedule a CryptoKeyVersion for destruction. Upon calling this method, CryptoKeyVersion.state will be set to DESTROY_SCHEDULED, and destroy_time will be set to the time destroy_scheduled_duration in the future. At that time, the state will automatically change to DESTROYED, and the key material will be irrevocably destroyed. Before the destroy_time is reached, RestoreCryptoKeyVersion may be called to reverse the process."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:destroy"
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

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-getPublicKey$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/getPublicKey
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the public key for the given CryptoKeyVersion. The CryptoKey.purpose must be ASYMMETRIC_SIGN or ASYMMETRIC_DECRYPT."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}/publicKey"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-asymmetricSign$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/asymmetricSign
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:digest {:sha256 string, :sha384 string, :sha512 string},
   :digestCrc32c string,
   :data string,
   :dataCrc32c string}
  
  Signs data using a CryptoKeyVersion with CryptoKey.purpose ASYMMETRIC_SIGN, producing a signature that can be verified with the public key retrieved from GetPublicKey."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:asymmetricSign"
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

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-macSign$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/macSign
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:data string, :dataCrc32c string}
  
  Signs data using a CryptoKeyVersion with CryptoKey.purpose MAC, producing a tag that can be verified by another source with the same key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:macSign"
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

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-list$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, view, filter, orderBy
  
  Lists CryptoKeyVersions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/cryptoKeyVersions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-rawDecrypt$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/rawDecrypt
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:ciphertext string,
   :additionalAuthenticatedData string,
   :initializationVector string,
   :tagLength integer,
   :ciphertextCrc32c string,
   :additionalAuthenticatedDataCrc32c string,
   :initializationVectorCrc32c string}
  
  Decrypts data that was originally encrypted using a raw cryptographic mechanism. The CryptoKey.purpose must be RAW_ENCRYPT_DECRYPT."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:rawDecrypt"
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

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-macVerify$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/macVerify
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:data string, :dataCrc32c string, :mac string, :macCrc32c string}
  
  Verifies MAC tag using a CryptoKeyVersion with CryptoKey.purpose MAC, and returns a response that indicates whether or not the verification was successful."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:macVerify"
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

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-rawEncrypt$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/rawEncrypt
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:plaintext string,
   :additionalAuthenticatedData string,
   :plaintextCrc32c string,
   :additionalAuthenticatedDataCrc32c string,
   :initializationVector string,
   :initializationVectorCrc32c string}
  
  Encrypts data using portable cryptographic primitives. Most users should choose Encrypt and Decrypt rather than their raw counterparts. The CryptoKey.purpose must be RAW_ENCRYPT_DECRYPT."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:rawEncrypt"
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

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-import$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:cryptoKeyVersion string,
   :algorithm string,
   :importJob string,
   :wrappedKey string,
   :rsaAesWrappedKey string}
  
  Import wrapped key material into a CryptoKeyVersion. All requests must specify a CryptoKey. If a CryptoKeyVersion is additionally specified in the request, key material will be reimported into that version. Otherwise, a new version will be created, and will be assigned the next sequential id within the CryptoKey."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/cryptoKeyVersions:import"
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

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-asymmetricDecrypt$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/asymmetricDecrypt
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:ciphertext string, :ciphertextCrc32c string}
  
  Decrypts data that was encrypted with a public key retrieved from GetPublicKey corresponding to a CryptoKeyVersion with CryptoKey.purpose ASYMMETRIC_DECRYPT."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:asymmetricDecrypt"
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

(defn locations-keyRings-importJobs-list$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/importJobs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists ImportJobs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/importJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-importJobs-get$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/importJobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns metadata for a given ImportJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-importJobs-create$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/importJobs/create
  
  Required parameters: parent
  
  Optional parameters: importJobId
  
  Body: 
  
  {:generateTime string,
   :name string,
   :createTime string,
   :expireEventTime string,
   :state string,
   :publicKey {:pem string},
   :attestation {:format string,
                 :content string,
                 :certChains CertificateChains},
   :expireTime string,
   :importMethod string,
   :protectionLevel string}
  
  Create a new ImportJob within a KeyRing. ImportJob.import_method is required."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/importJobs"
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

(defn locations-keyRings-importJobs-setIamPolicy$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/importJobs/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
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

(defn locations-keyRings-importJobs-getIamPolicy$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/importJobs/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-importJobs-testIamPermissions$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/importJobs/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
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

(defn locations-ekmConfig-setIamPolicy$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConfig/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
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

(defn locations-ekmConfig-getIamPolicy$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConfig/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-ekmConfig-testIamPermissions$
  "https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConfig/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
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
