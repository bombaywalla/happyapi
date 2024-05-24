(ns happygapi.tagmanager.accounts
  "Tag Manager API: accounts.
  This API allows clients to access and modify container and tag configuration.
  See: https://developers.google.com/tag-managerdocs/reference/rest/v2/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/list
  
  Required parameters: none
  
  Optional parameters: includeGoogleTags, pageToken
  
  Lists all GTM Accounts that a user has access to."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.manage.accounts"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/accounts"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/get
  
  Required parameters: path
  
  Optional parameters: none
  
  Gets a GTM Account."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.manage.accounts"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/update
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Body: 
  
  {:path string,
   :accountId string,
   :name string,
   :shareData boolean,
   :fingerprint string,
   :tagManagerUrl string,
   :features {:supportUserPermissions boolean,
              :supportMultipleContainers boolean}}
  
  Updates a GTM Account."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.manage.accounts"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
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

(defn user_permissions-create$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/user_permissions/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:path string,
   :accountId string,
   :emailAddress string,
   :accountAccess {:permission string},
   :containerAccess [{:containerId string, :permission string}]}
  
  Creates a user's Account & Container access."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.manage.users"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/user_permissions"
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

(defn user_permissions-list$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/user_permissions/list
  
  Required parameters: parent
  
  Optional parameters: pageToken
  
  List all users that have access to the account along with Account and Container user access granted to each of them."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.manage.users"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/user_permissions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn user_permissions-get$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/user_permissions/get
  
  Required parameters: path
  
  Optional parameters: none
  
  Gets a user's Account & Container access."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.manage.users"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn user_permissions-update$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/user_permissions/update
  
  Required parameters: path
  
  Optional parameters: none
  
  Body: 
  
  {:path string,
   :accountId string,
   :emailAddress string,
   :accountAccess {:permission string},
   :containerAccess [{:containerId string, :permission string}]}
  
  Updates a user's Account & Container access."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.manage.users"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
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

(defn user_permissions-delete$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/user_permissions/delete
  
  Required parameters: path
  
  Optional parameters: none
  
  Removes a user from the account, revoking access to it and all of its containers."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.manage.users"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-get$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/get
  
  Required parameters: path
  
  Optional parameters: none
  
  Gets a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-lookup$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/lookup
  
  Required parameters: none
  
  Optional parameters: destinationId
  
  Looks up a Container by destination ID."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/accounts/containers:lookup"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-create$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:path string,
   :features {:supportWorkspaces boolean,
              :supportVersions boolean,
              :supportEnvironments boolean,
              :supportClients boolean,
              :supportGtagConfigs boolean,
              :supportTransformations boolean,
              :supportBuiltInVariables boolean,
              :supportTemplates boolean,
              :supportVariables boolean,
              :supportTriggers boolean,
              :supportUserPermissions boolean,
              :supportZones boolean,
              :supportFolders boolean,
              :supportTags boolean},
   :tagIds [string],
   :taggingServerUrls [string],
   :name string,
   :containerId string,
   :domainName [string],
   :notes string,
   :tagManagerUrl string,
   :publicId string,
   :usageContext [string],
   :accountId string,
   :fingerprint string}
  
  Creates a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/containers"
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

(defn containers-snippet$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/snippet
  
  Required parameters: path
  
  Optional parameters: none
  
  Gets the tagging snippet for a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:snippet"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-update$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/update
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Body: 
  
  {:path string,
   :features {:supportWorkspaces boolean,
              :supportVersions boolean,
              :supportEnvironments boolean,
              :supportClients boolean,
              :supportGtagConfigs boolean,
              :supportTransformations boolean,
              :supportBuiltInVariables boolean,
              :supportTemplates boolean,
              :supportVariables boolean,
              :supportTriggers boolean,
              :supportUserPermissions boolean,
              :supportZones boolean,
              :supportFolders boolean,
              :supportTags boolean},
   :tagIds [string],
   :taggingServerUrls [string],
   :name string,
   :containerId string,
   :domainName [string],
   :notes string,
   :tagManagerUrl string,
   :publicId string,
   :usageContext [string],
   :accountId string,
   :fingerprint string}
  
  Updates a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
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

(defn containers-delete$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/delete
  
  Required parameters: path
  
  Optional parameters: none
  
  Deletes a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.delete.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-combine$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/combine
  
  Required parameters: path
  
  Optional parameters: containerId, allowUserPermissionFeatureUpdate, settingSource
  
  Combines Containers."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:combine"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-list$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/list
  
  Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all Containers that belongs to a GTM Account."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/containers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-move_tag_id$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/move_tag_id
  
  Required parameters: path
  
  Optional parameters: tagId, tagName, copyUsers, copySettings, allowUserPermissionFeatureUpdate, copyTermsOfService
  
  Move Tag ID out of a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:move_tag_id"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-destinations-get$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/destinations/get
  
  Required parameters: path
  
  Optional parameters: none
  
  Gets a Destination."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-destinations-list$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/destinations/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all Destinations linked to a GTM Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/destinations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-destinations-link$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/destinations/link
  
  Required parameters: parent
  
  Optional parameters: destinationId, allowUserPermissionFeatureUpdate
  
  Adds a Destination to this Container and removes it from the Container to which it is currently linked."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/destinations:link"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-get$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/get
  
  Required parameters: path
  
  Optional parameters: none
  
  Gets a Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-quick_preview$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/quick_preview
  
  Required parameters: path
  
  Optional parameters: none
  
  Quick previews a workspace by creating a fake container version from all entities in the provided workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containerversions"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:quick_preview"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-create$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:path string,
   :accountId string,
   :containerId string,
   :workspaceId string,
   :name string,
   :description string,
   :fingerprint string,
   :tagManagerUrl string}
  
  Creates a Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/workspaces"
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

(defn containers-workspaces-update$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/update
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Body: 
  
  {:path string,
   :accountId string,
   :containerId string,
   :workspaceId string,
   :name string,
   :description string,
   :fingerprint string,
   :tagManagerUrl string}
  
  Updates a Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
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

(defn containers-workspaces-delete$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/delete
  
  Required parameters: path
  
  Optional parameters: none
  
  Deletes a Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.delete.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-sync$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/sync
  
  Required parameters: path
  
  Optional parameters: none
  
  Syncs a workspace to the latest container version by updating all unmodified workspace entities and displaying conflicts for modified entities."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:sync"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-list$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/list
  
  Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all Workspaces that belong to a GTM Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/workspaces"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-resolve_conflict$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/resolve_conflict
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Body: 
  
  {:variable {:path string,
              :parentFolderId string,
              :workspaceId string,
              :scheduleStartMs string,
              :name string,
              :containerId string,
              :type string,
              :enablingTriggerId [string],
              :scheduleEndMs string,
              :notes string,
              :disablingTriggerId [string],
              :tagManagerUrl string,
              :variableId string,
              :formatValue VariableFormatValue,
              :accountId string,
              :parameter [Parameter],
              :fingerprint string},
   :zone {:path string,
          :typeRestriction ZoneTypeRestriction,
          :workspaceId string,
          :zoneId string,
          :name string,
          :containerId string,
          :childContainer [ZoneChildContainer],
          :boundary ZoneBoundary,
          :notes string,
          :tagManagerUrl string,
          :accountId string,
          :fingerprint string},
   :folder {:path string,
            :workspaceId string,
            :name string,
            :containerId string,
            :notes string,
            :folderId string,
            :tagManagerUrl string,
            :accountId string,
            :fingerprint string},
   :gtagConfig {:path string,
                :workspaceId string,
                :containerId string,
                :type string,
                :gtagConfigId string,
                :tagManagerUrl string,
                :accountId string,
                :parameter [Parameter],
                :fingerprint string},
   :customTemplate {:galleryReference GalleryReference,
                    :path string,
                    :workspaceId string,
                    :name string,
                    :containerId string,
                    :templateData string,
                    :tagManagerUrl string,
                    :templateId string,
                    :accountId string,
                    :fingerprint string},
   :client {:path string,
            :clientId string,
            :parentFolderId string,
            :workspaceId string,
            :name string,
            :containerId string,
            :type string,
            :priority integer,
            :notes string,
            :tagManagerUrl string,
            :accountId string,
            :parameter [Parameter],
            :fingerprint string},
   :transformation {:path string,
                    :parentFolderId string,
                    :workspaceId string,
                    :name string,
                    :containerId string,
                    :type string,
                    :notes string,
                    :tagManagerUrl string,
                    :accountId string,
                    :transformationId string,
                    :parameter [Parameter],
                    :fingerprint string},
   :builtInVariable {:path string,
                     :accountId string,
                     :containerId string,
                     :workspaceId string,
                     :type string,
                     :name string},
   :tag {:monitoringMetadataTagNameKey string,
         :path string,
         :parentFolderId string,
         :setupTag [SetupTag],
         :paused boolean,
         :firingRuleId [string],
         :tagFiringOption string,
         :workspaceId string,
         :scheduleStartMs string,
         :firingTriggerId [string],
         :consentSettings TagConsentSetting,
         :name string,
         :containerId string,
         :type string,
         :tagId string,
         :blockingRuleId [string],
         :teardownTag [TeardownTag],
         :priority Parameter,
         :monitoringMetadata Parameter,
         :scheduleEndMs string,
         :notes string,
         :tagManagerUrl string,
         :blockingTriggerId [string],
         :accountId string,
         :parameter [Parameter],
         :fingerprint string,
         :liveOnly boolean},
   :trigger {:checkValidation Parameter,
             :path string,
             :parentFolderId string,
             :selector Parameter,
             :eventName Parameter,
             :customEventFilter [Condition],
             :visiblePercentageMax Parameter,
             :workspaceId string,
             :triggerId string,
             :limit Parameter,
             :horizontalScrollPercentageList Parameter,
             :name string,
             :verticalScrollPercentageList Parameter,
             :containerId string,
             :visibilitySelector Parameter,
             :type string,
             :autoEventFilter [Condition],
             :waitForTags Parameter,
             :waitForTagsTimeout Parameter,
             :continuousTimeMinMilliseconds Parameter,
             :filter [Condition],
             :visiblePercentageMin Parameter,
             :uniqueTriggerId Parameter,
             :notes string,
             :maxTimerLengthSeconds Parameter,
             :interval Parameter,
             :tagManagerUrl string,
             :totalTimeMinMilliseconds Parameter,
             :intervalSeconds Parameter,
             :accountId string,
             :parameter [Parameter],
             :fingerprint string},
   :changeStatus string}
  
  Resolves a merge conflict for a workspace entity by updating it to the resolved entity passed in the request."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:resolve_conflict"
     #{:path}
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

(defn containers-workspaces-getStatus$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/getStatus
  
  Required parameters: path
  
  Optional parameters: none
  
  Finds conflicting and modified entities in the workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}/status"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-create_version$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/create_version
  
  Required parameters: path
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :notes string}
  
  Creates a Container Version from the entities present in the workspace, deletes the workspace, and sets the base container version to the newly created version."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containerversions"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:create_version"
     #{:path}
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

(defn containers-workspaces-tags-create$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/tags/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:monitoringMetadataTagNameKey string,
   :path string,
   :parentFolderId string,
   :setupTag [{:tagName string, :stopOnSetupFailure boolean}],
   :paused boolean,
   :firingRuleId [string],
   :tagFiringOption string,
   :workspaceId string,
   :scheduleStartMs string,
   :firingTriggerId [string],
   :consentSettings {:consentStatus string, :consentType Parameter},
   :name string,
   :containerId string,
   :type string,
   :tagId string,
   :blockingRuleId [string],
   :teardownTag [{:tagName string, :stopTeardownOnFailure boolean}],
   :priority {:type string,
              :key string,
              :value string,
              :list [Parameter],
              :map [Parameter],
              :isWeakReference boolean},
   :monitoringMetadata {:type string,
                        :key string,
                        :value string,
                        :list [Parameter],
                        :map [Parameter],
                        :isWeakReference boolean},
   :scheduleEndMs string,
   :notes string,
   :tagManagerUrl string,
   :blockingTriggerId [string],
   :accountId string,
   :parameter [{:type string,
                :key string,
                :value string,
                :list [Parameter],
                :map [Parameter],
                :isWeakReference boolean}],
   :fingerprint string,
   :liveOnly boolean}
  
  Creates a GTM Tag."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/tags"
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

(defn containers-workspaces-tags-list$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/tags/list
  
  Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all GTM Tags of a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/tags"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-tags-get$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/tags/get
  
  Required parameters: path
  
  Optional parameters: none
  
  Gets a GTM Tag."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-tags-update$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/tags/update
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Body: 
  
  {:monitoringMetadataTagNameKey string,
   :path string,
   :parentFolderId string,
   :setupTag [{:tagName string, :stopOnSetupFailure boolean}],
   :paused boolean,
   :firingRuleId [string],
   :tagFiringOption string,
   :workspaceId string,
   :scheduleStartMs string,
   :firingTriggerId [string],
   :consentSettings {:consentStatus string, :consentType Parameter},
   :name string,
   :containerId string,
   :type string,
   :tagId string,
   :blockingRuleId [string],
   :teardownTag [{:tagName string, :stopTeardownOnFailure boolean}],
   :priority {:type string,
              :key string,
              :value string,
              :list [Parameter],
              :map [Parameter],
              :isWeakReference boolean},
   :monitoringMetadata {:type string,
                        :key string,
                        :value string,
                        :list [Parameter],
                        :map [Parameter],
                        :isWeakReference boolean},
   :scheduleEndMs string,
   :notes string,
   :tagManagerUrl string,
   :blockingTriggerId [string],
   :accountId string,
   :parameter [{:type string,
                :key string,
                :value string,
                :list [Parameter],
                :map [Parameter],
                :isWeakReference boolean}],
   :fingerprint string,
   :liveOnly boolean}
  
  Updates a GTM Tag."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
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

(defn containers-workspaces-tags-delete$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/tags/delete
  
  Required parameters: path
  
  Optional parameters: none
  
  Deletes a GTM Tag."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-tags-revert$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/tags/revert
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Reverts changes to a GTM Tag in a GTM Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:revert"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-folders-create$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/folders/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:path string,
   :workspaceId string,
   :name string,
   :containerId string,
   :notes string,
   :folderId string,
   :tagManagerUrl string,
   :accountId string,
   :fingerprint string}
  
  Creates a GTM Folder."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/folders"
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

(defn containers-workspaces-folders-list$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/folders/list
  
  Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all GTM Folders of a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/folders"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-folders-get$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/folders/get
  
  Required parameters: path
  
  Optional parameters: none
  
  Gets a GTM Folder."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-folders-entities$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/folders/entities
  
  Required parameters: path
  
  Optional parameters: pageToken
  
  List all entities in a GTM Folder."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:entities"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-folders-update$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/folders/update
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Body: 
  
  {:path string,
   :workspaceId string,
   :name string,
   :containerId string,
   :notes string,
   :folderId string,
   :tagManagerUrl string,
   :accountId string,
   :fingerprint string}
  
  Updates a GTM Folder."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
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

(defn containers-workspaces-folders-delete$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/folders/delete
  
  Required parameters: path
  
  Optional parameters: none
  
  Deletes a GTM Folder."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-folders-move_entities_to_folder$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/folders/move_entities_to_folder
  
  Required parameters: path
  
  Optional parameters: tagId, variableId, triggerId
  
  Body: 
  
  {:path string,
   :workspaceId string,
   :name string,
   :containerId string,
   :notes string,
   :folderId string,
   :tagManagerUrl string,
   :accountId string,
   :fingerprint string}
  
  Moves entities to a GTM Folder. If {folder_id} in the request path equals 0, this will instead move entities out of the folder they currently belong to."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:move_entities_to_folder"
     #{:path}
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

(defn containers-workspaces-folders-revert$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/folders/revert
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Reverts changes to a GTM Folder in a GTM Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:revert"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-transformations-create$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/transformations/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:path string,
   :parentFolderId string,
   :workspaceId string,
   :name string,
   :containerId string,
   :type string,
   :notes string,
   :tagManagerUrl string,
   :accountId string,
   :transformationId string,
   :parameter [{:type string,
                :key string,
                :value string,
                :list [Parameter],
                :map [Parameter],
                :isWeakReference boolean}],
   :fingerprint string}
  
  Creates a GTM Transformation."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/transformations"
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

(defn containers-workspaces-transformations-list$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/transformations/list
  
  Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all GTM Transformations of a GTM container workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/transformations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-transformations-get$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/transformations/get
  
  Required parameters: path
  
  Optional parameters: none
  
  Gets a GTM Transformation."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-transformations-update$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/transformations/update
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Body: 
  
  {:path string,
   :parentFolderId string,
   :workspaceId string,
   :name string,
   :containerId string,
   :type string,
   :notes string,
   :tagManagerUrl string,
   :accountId string,
   :transformationId string,
   :parameter [{:type string,
                :key string,
                :value string,
                :list [Parameter],
                :map [Parameter],
                :isWeakReference boolean}],
   :fingerprint string}
  
  Updates a GTM Transformation."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
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

(defn containers-workspaces-transformations-delete$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/transformations/delete
  
  Required parameters: path
  
  Optional parameters: none
  
  Deletes a GTM Transformation."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-transformations-revert$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/transformations/revert
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Reverts changes to a GTM Transformation in a GTM Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:revert"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-clients-create$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/clients/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:path string,
   :clientId string,
   :parentFolderId string,
   :workspaceId string,
   :name string,
   :containerId string,
   :type string,
   :priority integer,
   :notes string,
   :tagManagerUrl string,
   :accountId string,
   :parameter [{:type string,
                :key string,
                :value string,
                :list [Parameter],
                :map [Parameter],
                :isWeakReference boolean}],
   :fingerprint string}
  
  Creates a GTM Client."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/clients"
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

(defn containers-workspaces-clients-list$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/clients/list
  
  Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all GTM Clients of a GTM container workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/clients"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-clients-get$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/clients/get
  
  Required parameters: path
  
  Optional parameters: none
  
  Gets a GTM Client."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-clients-update$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/clients/update
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Body: 
  
  {:path string,
   :clientId string,
   :parentFolderId string,
   :workspaceId string,
   :name string,
   :containerId string,
   :type string,
   :priority integer,
   :notes string,
   :tagManagerUrl string,
   :accountId string,
   :parameter [{:type string,
                :key string,
                :value string,
                :list [Parameter],
                :map [Parameter],
                :isWeakReference boolean}],
   :fingerprint string}
  
  Updates a GTM Client."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
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

(defn containers-workspaces-clients-delete$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/clients/delete
  
  Required parameters: path
  
  Optional parameters: none
  
  Deletes a GTM Client."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-clients-revert$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/clients/revert
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Reverts changes to a GTM Client in a GTM Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:revert"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-variables-create$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/variables/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:path string,
   :parentFolderId string,
   :workspaceId string,
   :scheduleStartMs string,
   :name string,
   :containerId string,
   :type string,
   :enablingTriggerId [string],
   :scheduleEndMs string,
   :notes string,
   :disablingTriggerId [string],
   :tagManagerUrl string,
   :variableId string,
   :formatValue {:caseConversionType string,
                 :convertNullToValue Parameter,
                 :convertUndefinedToValue Parameter,
                 :convertTrueToValue Parameter,
                 :convertFalseToValue Parameter},
   :accountId string,
   :parameter [{:type string,
                :key string,
                :value string,
                :list [Parameter],
                :map [Parameter],
                :isWeakReference boolean}],
   :fingerprint string}
  
  Creates a GTM Variable."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/variables"
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

(defn containers-workspaces-variables-list$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/variables/list
  
  Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all GTM Variables of a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/variables"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-variables-get$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/variables/get
  
  Required parameters: path
  
  Optional parameters: none
  
  Gets a GTM Variable."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-variables-update$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/variables/update
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Body: 
  
  {:path string,
   :parentFolderId string,
   :workspaceId string,
   :scheduleStartMs string,
   :name string,
   :containerId string,
   :type string,
   :enablingTriggerId [string],
   :scheduleEndMs string,
   :notes string,
   :disablingTriggerId [string],
   :tagManagerUrl string,
   :variableId string,
   :formatValue {:caseConversionType string,
                 :convertNullToValue Parameter,
                 :convertUndefinedToValue Parameter,
                 :convertTrueToValue Parameter,
                 :convertFalseToValue Parameter},
   :accountId string,
   :parameter [{:type string,
                :key string,
                :value string,
                :list [Parameter],
                :map [Parameter],
                :isWeakReference boolean}],
   :fingerprint string}
  
  Updates a GTM Variable."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
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

(defn containers-workspaces-variables-delete$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/variables/delete
  
  Required parameters: path
  
  Optional parameters: none
  
  Deletes a GTM Variable."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-variables-revert$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/variables/revert
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Reverts changes to a GTM Variable in a GTM Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:revert"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-triggers-create$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/triggers/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:checkValidation {:type string,
                     :key string,
                     :value string,
                     :list [Parameter],
                     :map [Parameter],
                     :isWeakReference boolean},
   :path string,
   :parentFolderId string,
   :selector {:type string,
              :key string,
              :value string,
              :list [Parameter],
              :map [Parameter],
              :isWeakReference boolean},
   :eventName {:type string,
               :key string,
               :value string,
               :list [Parameter],
               :map [Parameter],
               :isWeakReference boolean},
   :customEventFilter [{:type string, :parameter [Parameter]}],
   :visiblePercentageMax {:type string,
                          :key string,
                          :value string,
                          :list [Parameter],
                          :map [Parameter],
                          :isWeakReference boolean},
   :workspaceId string,
   :triggerId string,
   :limit {:type string,
           :key string,
           :value string,
           :list [Parameter],
           :map [Parameter],
           :isWeakReference boolean},
   :horizontalScrollPercentageList {:type string,
                                    :key string,
                                    :value string,
                                    :list [Parameter],
                                    :map [Parameter],
                                    :isWeakReference boolean},
   :name string,
   :verticalScrollPercentageList {:type string,
                                  :key string,
                                  :value string,
                                  :list [Parameter],
                                  :map [Parameter],
                                  :isWeakReference boolean},
   :containerId string,
   :visibilitySelector {:type string,
                        :key string,
                        :value string,
                        :list [Parameter],
                        :map [Parameter],
                        :isWeakReference boolean},
   :type string,
   :autoEventFilter [{:type string, :parameter [Parameter]}],
   :waitForTags {:type string,
                 :key string,
                 :value string,
                 :list [Parameter],
                 :map [Parameter],
                 :isWeakReference boolean},
   :waitForTagsTimeout {:type string,
                        :key string,
                        :value string,
                        :list [Parameter],
                        :map [Parameter],
                        :isWeakReference boolean},
   :continuousTimeMinMilliseconds {:type string,
                                   :key string,
                                   :value string,
                                   :list [Parameter],
                                   :map [Parameter],
                                   :isWeakReference boolean},
   :filter [{:type string, :parameter [Parameter]}],
   :visiblePercentageMin {:type string,
                          :key string,
                          :value string,
                          :list [Parameter],
                          :map [Parameter],
                          :isWeakReference boolean},
   :uniqueTriggerId {:type string,
                     :key string,
                     :value string,
                     :list [Parameter],
                     :map [Parameter],
                     :isWeakReference boolean},
   :notes string,
   :maxTimerLengthSeconds {:type string,
                           :key string,
                           :value string,
                           :list [Parameter],
                           :map [Parameter],
                           :isWeakReference boolean},
   :interval {:type string,
              :key string,
              :value string,
              :list [Parameter],
              :map [Parameter],
              :isWeakReference boolean},
   :tagManagerUrl string,
   :totalTimeMinMilliseconds {:type string,
                              :key string,
                              :value string,
                              :list [Parameter],
                              :map [Parameter],
                              :isWeakReference boolean},
   :intervalSeconds {:type string,
                     :key string,
                     :value string,
                     :list [Parameter],
                     :map [Parameter],
                     :isWeakReference boolean},
   :accountId string,
   :parameter [{:type string,
                :key string,
                :value string,
                :list [Parameter],
                :map [Parameter],
                :isWeakReference boolean}],
   :fingerprint string}
  
  Creates a GTM Trigger."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/triggers"
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

(defn containers-workspaces-triggers-list$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/triggers/list
  
  Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all GTM Triggers of a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/triggers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-triggers-get$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/triggers/get
  
  Required parameters: path
  
  Optional parameters: none
  
  Gets a GTM Trigger."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-triggers-update$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/triggers/update
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Body: 
  
  {:checkValidation {:type string,
                     :key string,
                     :value string,
                     :list [Parameter],
                     :map [Parameter],
                     :isWeakReference boolean},
   :path string,
   :parentFolderId string,
   :selector {:type string,
              :key string,
              :value string,
              :list [Parameter],
              :map [Parameter],
              :isWeakReference boolean},
   :eventName {:type string,
               :key string,
               :value string,
               :list [Parameter],
               :map [Parameter],
               :isWeakReference boolean},
   :customEventFilter [{:type string, :parameter [Parameter]}],
   :visiblePercentageMax {:type string,
                          :key string,
                          :value string,
                          :list [Parameter],
                          :map [Parameter],
                          :isWeakReference boolean},
   :workspaceId string,
   :triggerId string,
   :limit {:type string,
           :key string,
           :value string,
           :list [Parameter],
           :map [Parameter],
           :isWeakReference boolean},
   :horizontalScrollPercentageList {:type string,
                                    :key string,
                                    :value string,
                                    :list [Parameter],
                                    :map [Parameter],
                                    :isWeakReference boolean},
   :name string,
   :verticalScrollPercentageList {:type string,
                                  :key string,
                                  :value string,
                                  :list [Parameter],
                                  :map [Parameter],
                                  :isWeakReference boolean},
   :containerId string,
   :visibilitySelector {:type string,
                        :key string,
                        :value string,
                        :list [Parameter],
                        :map [Parameter],
                        :isWeakReference boolean},
   :type string,
   :autoEventFilter [{:type string, :parameter [Parameter]}],
   :waitForTags {:type string,
                 :key string,
                 :value string,
                 :list [Parameter],
                 :map [Parameter],
                 :isWeakReference boolean},
   :waitForTagsTimeout {:type string,
                        :key string,
                        :value string,
                        :list [Parameter],
                        :map [Parameter],
                        :isWeakReference boolean},
   :continuousTimeMinMilliseconds {:type string,
                                   :key string,
                                   :value string,
                                   :list [Parameter],
                                   :map [Parameter],
                                   :isWeakReference boolean},
   :filter [{:type string, :parameter [Parameter]}],
   :visiblePercentageMin {:type string,
                          :key string,
                          :value string,
                          :list [Parameter],
                          :map [Parameter],
                          :isWeakReference boolean},
   :uniqueTriggerId {:type string,
                     :key string,
                     :value string,
                     :list [Parameter],
                     :map [Parameter],
                     :isWeakReference boolean},
   :notes string,
   :maxTimerLengthSeconds {:type string,
                           :key string,
                           :value string,
                           :list [Parameter],
                           :map [Parameter],
                           :isWeakReference boolean},
   :interval {:type string,
              :key string,
              :value string,
              :list [Parameter],
              :map [Parameter],
              :isWeakReference boolean},
   :tagManagerUrl string,
   :totalTimeMinMilliseconds {:type string,
                              :key string,
                              :value string,
                              :list [Parameter],
                              :map [Parameter],
                              :isWeakReference boolean},
   :intervalSeconds {:type string,
                     :key string,
                     :value string,
                     :list [Parameter],
                     :map [Parameter],
                     :isWeakReference boolean},
   :accountId string,
   :parameter [{:type string,
                :key string,
                :value string,
                :list [Parameter],
                :map [Parameter],
                :isWeakReference boolean}],
   :fingerprint string}
  
  Updates a GTM Trigger."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
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

(defn containers-workspaces-triggers-delete$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/triggers/delete
  
  Required parameters: path
  
  Optional parameters: none
  
  Deletes a GTM Trigger."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-triggers-revert$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/triggers/revert
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Reverts changes to a GTM Trigger in a GTM Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:revert"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-built_in_variables-create$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/built_in_variables/create
  
  Required parameters: parent
  
  Optional parameters: type
  
  Creates one or more GTM Built-In Variables."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/built_in_variables"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-built_in_variables-delete$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/built_in_variables/delete
  
  Required parameters: path
  
  Optional parameters: type
  
  Deletes one or more GTM Built-In Variables."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-built_in_variables-list$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/built_in_variables/list
  
  Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all the enabled Built-In Variables of a GTM Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/built_in_variables"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-built_in_variables-revert$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/built_in_variables/revert
  
  Required parameters: path
  
  Optional parameters: type
  
  Reverts changes to a GTM Built-In Variables in a GTM Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}/built_in_variables:revert"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-zones-create$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/zones/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:path string,
   :typeRestriction {:enable boolean, :whitelistedTypeId [string]},
   :workspaceId string,
   :zoneId string,
   :name string,
   :containerId string,
   :childContainer [{:publicId string, :nickname string}],
   :boundary {:condition [Condition],
              :customEvaluationTriggerId [string]},
   :notes string,
   :tagManagerUrl string,
   :accountId string,
   :fingerprint string}
  
  Creates a GTM Zone."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/zones"
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

(defn containers-workspaces-zones-list$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/zones/list
  
  Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all GTM Zones of a GTM container workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/zones"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-zones-get$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/zones/get
  
  Required parameters: path
  
  Optional parameters: none
  
  Gets a GTM Zone."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-zones-update$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/zones/update
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Body: 
  
  {:path string,
   :typeRestriction {:enable boolean, :whitelistedTypeId [string]},
   :workspaceId string,
   :zoneId string,
   :name string,
   :containerId string,
   :childContainer [{:publicId string, :nickname string}],
   :boundary {:condition [Condition],
              :customEvaluationTriggerId [string]},
   :notes string,
   :tagManagerUrl string,
   :accountId string,
   :fingerprint string}
  
  Updates a GTM Zone."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
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

(defn containers-workspaces-zones-delete$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/zones/delete
  
  Required parameters: path
  
  Optional parameters: none
  
  Deletes a GTM Zone."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-zones-revert$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/zones/revert
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Reverts changes to a GTM Zone in a GTM Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:revert"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-templates-create$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/templates/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:galleryReference {:host string,
                      :owner string,
                      :repository string,
                      :version string,
                      :isModified boolean,
                      :signature string},
   :path string,
   :workspaceId string,
   :name string,
   :containerId string,
   :templateData string,
   :tagManagerUrl string,
   :templateId string,
   :accountId string,
   :fingerprint string}
  
  Creates a GTM Custom Template."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/templates"
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

(defn containers-workspaces-templates-list$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/templates/list
  
  Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all GTM Templates of a GTM container workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/templates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-templates-get$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/templates/get
  
  Required parameters: path
  
  Optional parameters: none
  
  Gets a GTM Template."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-templates-update$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/templates/update
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Body: 
  
  {:galleryReference {:host string,
                      :owner string,
                      :repository string,
                      :version string,
                      :isModified boolean,
                      :signature string},
   :path string,
   :workspaceId string,
   :name string,
   :containerId string,
   :templateData string,
   :tagManagerUrl string,
   :templateId string,
   :accountId string,
   :fingerprint string}
  
  Updates a GTM Template."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
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

(defn containers-workspaces-templates-delete$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/templates/delete
  
  Required parameters: path
  
  Optional parameters: none
  
  Deletes a GTM Template."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-templates-revert$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/templates/revert
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Reverts changes to a GTM Template in a GTM Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:revert"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-gtag_config-create$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/gtag_config/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:path string,
   :workspaceId string,
   :containerId string,
   :type string,
   :gtagConfigId string,
   :tagManagerUrl string,
   :accountId string,
   :parameter [{:type string,
                :key string,
                :value string,
                :list [Parameter],
                :map [Parameter],
                :isWeakReference boolean}],
   :fingerprint string}
  
  Creates a Google tag config."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/gtag_config"
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

(defn containers-workspaces-gtag_config-list$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/gtag_config/list
  
  Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all Google tag configs in a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/gtag_config"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-gtag_config-get$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/gtag_config/get
  
  Required parameters: path
  
  Optional parameters: none
  
  Gets a Google tag config."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-gtag_config-update$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/gtag_config/update
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Body: 
  
  {:path string,
   :workspaceId string,
   :containerId string,
   :type string,
   :gtagConfigId string,
   :tagManagerUrl string,
   :accountId string,
   :parameter [{:type string,
                :key string,
                :value string,
                :list [Parameter],
                :map [Parameter],
                :isWeakReference boolean}],
   :fingerprint string}
  
  Updates a Google tag config."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
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

(defn containers-workspaces-gtag_config-delete$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/workspaces/gtag_config/delete
  
  Required parameters: path
  
  Optional parameters: none
  
  Deletes a Google tag config."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-versions-get$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/versions/get
  
  Required parameters: path
  
  Optional parameters: containerVersionId
  
  Gets a Container Version."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.edit.containerversions"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-versions-update$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/versions/update
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Body: 
  
  {:description string,
   :path string,
   :deleted boolean,
   :variable [{:path string,
               :parentFolderId string,
               :workspaceId string,
               :scheduleStartMs string,
               :name string,
               :containerId string,
               :type string,
               :enablingTriggerId [string],
               :scheduleEndMs string,
               :notes string,
               :disablingTriggerId [string],
               :tagManagerUrl string,
               :variableId string,
               :formatValue VariableFormatValue,
               :accountId string,
               :parameter [Parameter],
               :fingerprint string}],
   :zone [{:path string,
           :typeRestriction ZoneTypeRestriction,
           :workspaceId string,
           :zoneId string,
           :name string,
           :containerId string,
           :childContainer [ZoneChildContainer],
           :boundary ZoneBoundary,
           :notes string,
           :tagManagerUrl string,
           :accountId string,
           :fingerprint string}],
   :folder [{:path string,
             :workspaceId string,
             :name string,
             :containerId string,
             :notes string,
             :folderId string,
             :tagManagerUrl string,
             :accountId string,
             :fingerprint string}],
   :name string,
   :containerId string,
   :gtagConfig [{:path string,
                 :workspaceId string,
                 :containerId string,
                 :type string,
                 :gtagConfigId string,
                 :tagManagerUrl string,
                 :accountId string,
                 :parameter [Parameter],
                 :fingerprint string}],
   :customTemplate [{:galleryReference GalleryReference,
                     :path string,
                     :workspaceId string,
                     :name string,
                     :containerId string,
                     :templateData string,
                     :tagManagerUrl string,
                     :templateId string,
                     :accountId string,
                     :fingerprint string}],
   :client [{:path string,
             :clientId string,
             :parentFolderId string,
             :workspaceId string,
             :name string,
             :containerId string,
             :type string,
             :priority integer,
             :notes string,
             :tagManagerUrl string,
             :accountId string,
             :parameter [Parameter],
             :fingerprint string}],
   :transformation [{:path string,
                     :parentFolderId string,
                     :workspaceId string,
                     :name string,
                     :containerId string,
                     :type string,
                     :notes string,
                     :tagManagerUrl string,
                     :accountId string,
                     :transformationId string,
                     :parameter [Parameter],
                     :fingerprint string}],
   :containerVersionId string,
   :container {:path string,
               :features ContainerFeatures,
               :tagIds [string],
               :taggingServerUrls [string],
               :name string,
               :containerId string,
               :domainName [string],
               :notes string,
               :tagManagerUrl string,
               :publicId string,
               :usageContext [string],
               :accountId string,
               :fingerprint string},
   :builtInVariable [{:path string,
                      :accountId string,
                      :containerId string,
                      :workspaceId string,
                      :type string,
                      :name string}],
   :tag [{:monitoringMetadataTagNameKey string,
          :path string,
          :parentFolderId string,
          :setupTag [SetupTag],
          :paused boolean,
          :firingRuleId [string],
          :tagFiringOption string,
          :workspaceId string,
          :scheduleStartMs string,
          :firingTriggerId [string],
          :consentSettings TagConsentSetting,
          :name string,
          :containerId string,
          :type string,
          :tagId string,
          :blockingRuleId [string],
          :teardownTag [TeardownTag],
          :priority Parameter,
          :monitoringMetadata Parameter,
          :scheduleEndMs string,
          :notes string,
          :tagManagerUrl string,
          :blockingTriggerId [string],
          :accountId string,
          :parameter [Parameter],
          :fingerprint string,
          :liveOnly boolean}],
   :tagManagerUrl string,
   :trigger [{:checkValidation Parameter,
              :path string,
              :parentFolderId string,
              :selector Parameter,
              :eventName Parameter,
              :customEventFilter [Condition],
              :visiblePercentageMax Parameter,
              :workspaceId string,
              :triggerId string,
              :limit Parameter,
              :horizontalScrollPercentageList Parameter,
              :name string,
              :verticalScrollPercentageList Parameter,
              :containerId string,
              :visibilitySelector Parameter,
              :type string,
              :autoEventFilter [Condition],
              :waitForTags Parameter,
              :waitForTagsTimeout Parameter,
              :continuousTimeMinMilliseconds Parameter,
              :filter [Condition],
              :visiblePercentageMin Parameter,
              :uniqueTriggerId Parameter,
              :notes string,
              :maxTimerLengthSeconds Parameter,
              :interval Parameter,
              :tagManagerUrl string,
              :totalTimeMinMilliseconds Parameter,
              :intervalSeconds Parameter,
              :accountId string,
              :parameter [Parameter],
              :fingerprint string}],
   :accountId string,
   :fingerprint string}
  
  Updates a Container Version."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containerversions"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
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

(defn containers-versions-delete$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/versions/delete
  
  Required parameters: path
  
  Optional parameters: none
  
  Deletes a Container Version."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containerversions"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-versions-undelete$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/versions/undelete
  
  Required parameters: path
  
  Optional parameters: none
  
  Undeletes a Container Version."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containerversions"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:undelete"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-versions-publish$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/versions/publish
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Publishes a Container Version."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.publish"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:publish"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-versions-set_latest$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/versions/set_latest
  
  Required parameters: path
  
  Optional parameters: none
  
  Sets the latest version used for synchronization of workspaces when detecting conflicts and errors."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:set_latest"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-versions-live$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/versions/live
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets the live (i.e. published) container version"
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/versions:live"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-version_headers-list$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/version_headers/list
  
  Required parameters: parent
  
  Optional parameters: includeDeleted, pageToken
  
  Lists all Container Versions of a GTM Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.edit.containerversions"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/version_headers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-version_headers-latest$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/version_headers/latest
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets the latest container version header"
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/version_headers:latest"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-environments-create$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/environments/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :path string,
   :workspaceId string,
   :enableDebug boolean,
   :name string,
   :containerId string,
   :type string,
   :authorizationTimestamp string,
   :environmentId string,
   :containerVersionId string,
   :authorizationCode string,
   :url string,
   :tagManagerUrl string,
   :accountId string,
   :fingerprint string}
  
  Creates a GTM Environment."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/environments"
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

(defn containers-environments-list$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/environments/list
  
  Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all GTM Environments of a GTM Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+parent}/environments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-environments-get$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/environments/get
  
  Required parameters: path
  
  Optional parameters: none
  
  Gets a GTM Environment."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-environments-update$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/environments/update
  
  Required parameters: path
  
  Optional parameters: fingerprint
  
  Body: 
  
  {:description string,
   :path string,
   :workspaceId string,
   :enableDebug boolean,
   :name string,
   :containerId string,
   :type string,
   :authorizationTimestamp string,
   :environmentId string,
   :containerVersionId string,
   :authorizationCode string,
   :url string,
   :tagManagerUrl string,
   :accountId string,
   :fingerprint string}
  
  Updates a GTM Environment."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
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

(defn containers-environments-delete$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/environments/delete
  
  Required parameters: path
  
  Optional parameters: none
  
  Deletes a GTM Environment."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{:path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn containers-environments-reauthorize$
  "https://developers.google.com/tag-managerapi/reference/rest/v2/accounts/containers/environments/reauthorize
  
  Required parameters: path
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :path string,
   :workspaceId string,
   :enableDebug boolean,
   :name string,
   :containerId string,
   :type string,
   :authorizationTimestamp string,
   :environmentId string,
   :containerVersionId string,
   :authorizationCode string,
   :url string,
   :tagManagerUrl string,
   :accountId string,
   :fingerprint string}
  
  Re-generates the authorization code for a GTM Environment."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.publish"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:path})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tagmanager.googleapis.com/"
     "tagmanager/v2/{+path}:reauthorize"
     #{:path}
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
