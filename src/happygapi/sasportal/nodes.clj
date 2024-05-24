(ns happygapi.sasportal.nodes
  "SAS Portal API: nodes.
  
  See: https://developers.google.com/spectrum-access-system/docs/reference/rest/v1alpha1/nodes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a requested node."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sasportal.googleapis.com/"
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

(defn devices-get$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/devices/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details about a device."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sasportal.googleapis.com/"
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

(defn devices-patch$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/devices/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:serialNumber string,
   :activeConfig {:category string,
                  :installationParams SasPortalInstallationParams,
                  :state string,
                  :measurementCapabilities [string],
                  :updateTime string,
                  :callSign string,
                  :userId string,
                  :isSigned boolean,
                  :airInterface SasPortalDeviceAirInterface,
                  :model SasPortalDeviceModel},
   :grantRangeAllowlists [{:lowFrequencyMhz number,
                           :highFrequencyMhz number}],
   :displayName string,
   :name string,
   :state string,
   :deviceMetadata {:commonChannelGroup string,
                    :antennaModel string,
                    :nrqzValidation SasPortalNrqzValidation,
                    :nrqzValidated boolean,
                    :interferenceCoordinationGroup string},
   :grants [{:moveList [SasPortalDpaMoveList],
             :lastHeartbeatTransmitExpireTime string,
             :state string,
             :grantId string,
             :frequencyRange SasPortalFrequencyRange,
             :expireTime string,
             :suspensionReason [string],
             :maxEirp number,
             :channelType string}],
   :preloadedConfig {:category string,
                     :installationParams SasPortalInstallationParams,
                     :state string,
                     :measurementCapabilities [string],
                     :updateTime string,
                     :callSign string,
                     :userId string,
                     :isSigned boolean,
                     :airInterface SasPortalDeviceAirInterface,
                     :model SasPortalDeviceModel},
   :currentChannels [{:frequencyRange SasPortalFrequencyRange,
                      :score number}],
   :fccId string}
  
  Updates a device."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://sasportal.googleapis.com/"
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

(defn devices-updateSigned$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/devices/updateSigned
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:encodedDevice string, :installerId string}
  
  Updates a signed device."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+name}:updateSigned"
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

(defn devices-createSigned$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/devices/createSigned
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:installerId string, :encodedDevice string}
  
  Creates a signed device under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices:createSigned"
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

(defn devices-create$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/devices/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:serialNumber string,
   :activeConfig {:category string,
                  :installationParams SasPortalInstallationParams,
                  :state string,
                  :measurementCapabilities [string],
                  :updateTime string,
                  :callSign string,
                  :userId string,
                  :isSigned boolean,
                  :airInterface SasPortalDeviceAirInterface,
                  :model SasPortalDeviceModel},
   :grantRangeAllowlists [{:lowFrequencyMhz number,
                           :highFrequencyMhz number}],
   :displayName string,
   :name string,
   :state string,
   :deviceMetadata {:commonChannelGroup string,
                    :antennaModel string,
                    :nrqzValidation SasPortalNrqzValidation,
                    :nrqzValidated boolean,
                    :interferenceCoordinationGroup string},
   :grants [{:moveList [SasPortalDpaMoveList],
             :lastHeartbeatTransmitExpireTime string,
             :state string,
             :grantId string,
             :frequencyRange SasPortalFrequencyRange,
             :expireTime string,
             :suspensionReason [string],
             :maxEirp number,
             :channelType string}],
   :preloadedConfig {:category string,
                     :installationParams SasPortalInstallationParams,
                     :state string,
                     :measurementCapabilities [string],
                     :updateTime string,
                     :callSign string,
                     :userId string,
                     :isSigned boolean,
                     :airInterface SasPortalDeviceAirInterface,
                     :model SasPortalDeviceModel},
   :currentChannels [{:frequencyRange SasPortalFrequencyRange,
                      :score number}],
   :fccId string}
  
  Creates a device under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices"
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

(defn devices-move$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/devices/move
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:destination string}
  
  Moves a device under another node or customer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+name}:move"
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

(defn devices-delete$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/devices/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a device."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sasportal.googleapis.com/"
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

(defn devices-list$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/devices/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists devices under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn devices-signDevice$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/devices/signDevice
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:device {:serialNumber string,
            :activeConfig SasPortalDeviceConfig,
            :grantRangeAllowlists [SasPortalFrequencyRange],
            :displayName string,
            :name string,
            :state string,
            :deviceMetadata SasPortalDeviceMetadata,
            :grants [SasPortalDeviceGrant],
            :preloadedConfig SasPortalDeviceConfig,
            :currentChannels [SasPortalChannelWithScore],
            :fccId string}}
  
  Signs a device."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+name}:signDevice"
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

(defn nodes-move$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/nodes/move
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:destination string}
  
  Moves a node under another node or customer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+name}:move"
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

(defn nodes-delete$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/nodes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a node."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sasportal.googleapis.com/"
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

(defn nodes-create$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/nodes/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :displayName string, :sasUserIds [string]}
  
  Creates a new node."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/nodes"
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

(defn nodes-list$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/nodes/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists nodes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/nodes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-patch$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/nodes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :displayName string, :sasUserIds [string]}
  
  Updates an existing node."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://sasportal.googleapis.com/"
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

(defn nodes-get$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/nodes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a requested node."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sasportal.googleapis.com/"
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

(defn nodes-nodes-list$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/nodes/nodes/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists nodes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/nodes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-nodes-create$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/nodes/nodes/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :displayName string, :sasUserIds [string]}
  
  Creates a new node."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/nodes"
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

(defn nodes-deployments-create$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/nodes/deployments/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:sasUserIds [string],
   :name string,
   :frns [string],
   :displayName string}
  
  Creates a new deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/deployments"
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

(defn nodes-deployments-list$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/nodes/deployments/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists deployments."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-devices-createSigned$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/nodes/devices/createSigned
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:installerId string, :encodedDevice string}
  
  Creates a signed device under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices:createSigned"
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

(defn nodes-devices-list$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/nodes/devices/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists devices under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-devices-create$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/nodes/devices/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:serialNumber string,
   :activeConfig {:category string,
                  :installationParams SasPortalInstallationParams,
                  :state string,
                  :measurementCapabilities [string],
                  :updateTime string,
                  :callSign string,
                  :userId string,
                  :isSigned boolean,
                  :airInterface SasPortalDeviceAirInterface,
                  :model SasPortalDeviceModel},
   :grantRangeAllowlists [{:lowFrequencyMhz number,
                           :highFrequencyMhz number}],
   :displayName string,
   :name string,
   :state string,
   :deviceMetadata {:commonChannelGroup string,
                    :antennaModel string,
                    :nrqzValidation SasPortalNrqzValidation,
                    :nrqzValidated boolean,
                    :interferenceCoordinationGroup string},
   :grants [{:moveList [SasPortalDpaMoveList],
             :lastHeartbeatTransmitExpireTime string,
             :state string,
             :grantId string,
             :frequencyRange SasPortalFrequencyRange,
             :expireTime string,
             :suspensionReason [string],
             :maxEirp number,
             :channelType string}],
   :preloadedConfig {:category string,
                     :installationParams SasPortalInstallationParams,
                     :state string,
                     :measurementCapabilities [string],
                     :updateTime string,
                     :callSign string,
                     :userId string,
                     :isSigned boolean,
                     :airInterface SasPortalDeviceAirInterface,
                     :model SasPortalDeviceModel},
   :currentChannels [{:frequencyRange SasPortalFrequencyRange,
                      :score number}],
   :fccId string}
  
  Creates a device under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices"
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

(defn deployments-move$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/deployments/move
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:destination string}
  
  Moves a deployment under another node or customer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+name}:move"
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

(defn deployments-delete$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/deployments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sasportal.googleapis.com/"
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

(defn deployments-list$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/deployments/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists deployments."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-patch$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/deployments/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:sasUserIds [string],
   :name string,
   :frns [string],
   :displayName string}
  
  Updates an existing deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://sasportal.googleapis.com/"
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

(defn deployments-get$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/deployments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a requested deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sasportal.googleapis.com/"
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

(defn deployments-devices-createSigned$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/deployments/devices/createSigned
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:installerId string, :encodedDevice string}
  
  Creates a signed device under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices:createSigned"
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

(defn deployments-devices-create$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/deployments/devices/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:serialNumber string,
   :activeConfig {:category string,
                  :installationParams SasPortalInstallationParams,
                  :state string,
                  :measurementCapabilities [string],
                  :updateTime string,
                  :callSign string,
                  :userId string,
                  :isSigned boolean,
                  :airInterface SasPortalDeviceAirInterface,
                  :model SasPortalDeviceModel},
   :grantRangeAllowlists [{:lowFrequencyMhz number,
                           :highFrequencyMhz number}],
   :displayName string,
   :name string,
   :state string,
   :deviceMetadata {:commonChannelGroup string,
                    :antennaModel string,
                    :nrqzValidation SasPortalNrqzValidation,
                    :nrqzValidated boolean,
                    :interferenceCoordinationGroup string},
   :grants [{:moveList [SasPortalDpaMoveList],
             :lastHeartbeatTransmitExpireTime string,
             :state string,
             :grantId string,
             :frequencyRange SasPortalFrequencyRange,
             :expireTime string,
             :suspensionReason [string],
             :maxEirp number,
             :channelType string}],
   :preloadedConfig {:category string,
                     :installationParams SasPortalInstallationParams,
                     :state string,
                     :measurementCapabilities [string],
                     :updateTime string,
                     :callSign string,
                     :userId string,
                     :isSigned boolean,
                     :airInterface SasPortalDeviceAirInterface,
                     :model SasPortalDeviceModel},
   :currentChannels [{:frequencyRange SasPortalFrequencyRange,
                      :score number}],
   :fccId string}
  
  Creates a device under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices"
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

(defn deployments-devices-list$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/nodes/deployments/devices/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists devices under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
