(ns happygapi.compute.instanceGroupManagers
  "Compute Engine API: instanceGroupManagers.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/products/compute"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn listManagedInstances$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/listManagedInstances
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Lists all of the instances in the managed instance group. Each instance in the list has a currentAction, which indicates the action that the managed instance group is performing on the instance. For example, if the group is still creating an instance, the currentAction is CREATING. If a previous action failed, the list displays the errors for that failed action. The orderBy query parameter is not supported. The `pageToken` query parameter is supported only if the group's `listManagedInstancesResults` field is set to `PAGINATED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/listManagedInstances"
     #{:zone :instanceGroupManager :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setInstanceTemplate$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/setInstanceTemplate
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:instanceTemplate string}
  
  Specifies the instance template to use when creating new instances in this group. The templates for existing instances in the group do not change unless you run recreateInstances, run applyUpdatesToInstances, or set the group's updatePolicy.type to PROACTIVE."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/setInstanceTemplate"
     #{:zone :instanceGroupManager :project}
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

(defn listErrors$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/listErrors
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Lists all errors thrown by actions on instances for a given managed instance group. The filter and orderBy query parameters are not supported."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/listErrors"
     #{:zone :instanceGroupManager :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/get
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: none
  
  Returns all of the details about the specified managed instance group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}"
     #{:zone :instanceGroupManager :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/insert
  
  Required parameters: project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :updatePolicy {:type string,
                  :instanceRedistributionType string,
                  :minimalAction string,
                  :mostDisruptiveAllowedAction string,
                  :maxSurge FixedOrPercent,
                  :maxUnavailable FixedOrPercent,
                  :replacementMethod string},
   :instanceLifecyclePolicy {:forceUpdateOnRepair string,
                             :defaultActionOnFailure string},
   :creationTimestamp string,
   :zone string,
   :name string,
   :selfLink string,
   :targetPools [string],
   :region string,
   :currentActions {:recreating integer,
                    :restarting integer,
                    :starting integer,
                    :creating integer,
                    :deleting integer,
                    :stopping integer,
                    :suspending integer,
                    :refreshing integer,
                    :abandoning integer,
                    :resuming integer,
                    :verifying integer,
                    :none integer,
                    :creatingWithoutRetries integer},
   :autoHealingPolicies [{:healthCheck string, :initialDelaySec integer}],
   :listManagedInstancesResults string,
   :status {:isStable boolean,
            :allInstancesConfig InstanceGroupManagerStatusAllInstancesConfig,
            :versionTarget InstanceGroupManagerStatusVersionTarget,
            :stateful InstanceGroupManagerStatusStateful,
            :autoscaler string},
   :instanceGroup string,
   :id string,
   :kind string,
   :allInstancesConfig {:properties InstancePropertiesPatch},
   :distributionPolicy {:zones [DistributionPolicyZoneConfiguration],
                        :targetShape string},
   :statefulPolicy {:preservedState StatefulPolicyPreservedState},
   :baseInstanceName string,
   :versions [{:name string,
               :instanceTemplate string,
               :targetSize FixedOrPercent}],
   :targetSize integer,
   :instanceTemplate string,
   :fingerprint string,
   :namedPorts [{:name string, :port integer}]}
  
  Creates a managed instance group using the information that you specify in the request. After the group is created, instances in the group are created using the specified instance template. This operation is marked as DONE when the group is created even if the instances in the group have not yet been created. You must separately verify the status of the individual instances with the listmanagedinstances method. A managed instance group can have up to 1000 VM instances per group. Please contact Cloud Support if you need an increase in this limit."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers"
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

(defn abandonInstances$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/abandonInstances
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [string]}
  
  Flags the specified instances to be removed from the managed instance group. Abandoning an instance does not delete the instance, but it does remove the instance from any target pools that are applied by the managed instance group. This method reduces the targetSize of the managed instance group by the number of instances that you abandon. This operation is marked as DONE when the action is scheduled even if the instances have not yet been removed from the group. You must separately verify the status of the abandoning action with the listmanagedinstances method. If the group is part of a backend service that has enabled connection draining, it can take up to 60 seconds after the connection draining duration has elapsed before the VM instance is removed or deleted. You can specify a maximum of 1000 instances with this method per request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/abandonInstances"
     #{:zone :instanceGroupManager :project}
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

(defn updatePerInstanceConfigs$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/updatePerInstanceConfigs
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:perInstanceConfigs [{:name string,
                         :preservedState PreservedState,
                         :status string,
                         :fingerprint string}]}
  
  Inserts or updates per-instance configurations for the managed instance group. perInstanceConfig.name serves as a key used to distinguish whether to perform insert or patch."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/updatePerInstanceConfigs"
     #{:zone :instanceGroupManager :project}
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

(defn recreateInstances$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/recreateInstances
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [string]}
  
  Flags the specified VM instances in the managed instance group to be immediately recreated. Each instance is recreated using the group's current configuration. This operation is marked as DONE when the flag is set even if the instances have not yet been recreated. You must separately verify the status of each instance by checking its currentAction field; for more information, see Checking the status of managed instances. If the group is part of a backend service that has enabled connection draining, it can take up to 60 seconds after the connection draining duration has elapsed before the VM instance is removed or deleted. You can specify a maximum of 1000 instances with this method per request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/recreateInstances"
     #{:zone :instanceGroupManager :project}
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

(defn applyUpdatesToInstances$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/applyUpdatesToInstances
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: none
  
  Body: 
  
  {:instances [string],
   :minimalAction string,
   :mostDisruptiveAllowedAction string,
   :allInstances boolean}
  
  Applies changes to selected instances on the managed instance group. This method can be used to apply new overrides and/or new versions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/applyUpdatesToInstances"
     #{:zone :instanceGroupManager :project}
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

(defn patch$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/patch
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :updatePolicy {:type string,
                  :instanceRedistributionType string,
                  :minimalAction string,
                  :mostDisruptiveAllowedAction string,
                  :maxSurge FixedOrPercent,
                  :maxUnavailable FixedOrPercent,
                  :replacementMethod string},
   :instanceLifecyclePolicy {:forceUpdateOnRepair string,
                             :defaultActionOnFailure string},
   :creationTimestamp string,
   :zone string,
   :name string,
   :selfLink string,
   :targetPools [string],
   :region string,
   :currentActions {:recreating integer,
                    :restarting integer,
                    :starting integer,
                    :creating integer,
                    :deleting integer,
                    :stopping integer,
                    :suspending integer,
                    :refreshing integer,
                    :abandoning integer,
                    :resuming integer,
                    :verifying integer,
                    :none integer,
                    :creatingWithoutRetries integer},
   :autoHealingPolicies [{:healthCheck string, :initialDelaySec integer}],
   :listManagedInstancesResults string,
   :status {:isStable boolean,
            :allInstancesConfig InstanceGroupManagerStatusAllInstancesConfig,
            :versionTarget InstanceGroupManagerStatusVersionTarget,
            :stateful InstanceGroupManagerStatusStateful,
            :autoscaler string},
   :instanceGroup string,
   :id string,
   :kind string,
   :allInstancesConfig {:properties InstancePropertiesPatch},
   :distributionPolicy {:zones [DistributionPolicyZoneConfiguration],
                        :targetShape string},
   :statefulPolicy {:preservedState StatefulPolicyPreservedState},
   :baseInstanceName string,
   :versions [{:name string,
               :instanceTemplate string,
               :targetSize FixedOrPercent}],
   :targetSize integer,
   :instanceTemplate string,
   :fingerprint string,
   :namedPorts [{:name string, :port integer}]}
  
  Updates a managed instance group using the information that you specify in the request. This operation is marked as DONE when the group is patched even if the instances in the group are still in the process of being patched. You must separately verify the status of the individual instances with the listManagedInstances method. This method supports PATCH semantics and uses the JSON merge patch format and processing rules. If you update your group to specify a new template or instance configuration, it's possible that your intended specification for each VM in the group is different from the current state of that VM. To learn how to apply an updated configuration to the VMs in a MIG, see Updating instances in a MIG."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}"
     #{:zone :instanceGroupManager :project}
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
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken, returnPartialSuccess, serviceProjectNumber
  
  Retrieves the list of managed instance groups and groups them by zone. To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to `true`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/instanceGroupManagers"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deletePerInstanceConfigs$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/deletePerInstanceConfigs
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: none
  
  Body: 
  
  {:names [string]}
  
  Deletes selected per-instance configurations for the managed instance group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/deletePerInstanceConfigs"
     #{:zone :instanceGroupManager :project}
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
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/delete
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Deletes the specified managed instance group and all of the instances in that group. Note that the instance group must not belong to a backend service. Read Deleting an instance group for more information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}"
     #{:zone :instanceGroupManager :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resize$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/resize
  
  Required parameters: instanceGroupManager, project, size, zone
  
  Optional parameters: requestId
  
  Resizes the managed instance group. If you increase the size, the group creates new instances using the current instance template. If you decrease the size, the group deletes instances. The resize operation is marked DONE when the resize actions are scheduled even if the group has not yet added or deleted any instances. You must separately verify the status of the creating or deleting actions with the listmanagedinstances method. When resizing down, the instance group arbitrarily chooses the order in which VMs are deleted. The group takes into account some VM attributes when making the selection including: + The status of the VM instance. + The health of the VM instance. + The instance template version the VM is based on. + For regional managed instance groups, the location of the VM instance. This list is subject to change. If the group is part of a backend service that has enabled connection draining, it can take up to 60 seconds after the connection draining duration has elapsed before the VM instance is removed or deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :size :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/resize"
     #{:zone :instanceGroupManager :size :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listPerInstanceConfigs$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/listPerInstanceConfigs
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Lists all of the per-instance configurations defined for the managed instance group. The orderBy query parameter is not supported."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/listPerInstanceConfigs"
     #{:zone :instanceGroupManager :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setTargetPools$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/setTargetPools
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:targetPools [string], :fingerprint string}
  
  Modifies the target pools to which all instances in this managed instance group are assigned. The target pools automatically apply to all of the instances in the managed instance group. This operation is marked DONE when you make the request even if the instances have not yet been added to their target pools. The change might take some time to apply to all of the instances in the group depending on the size of the group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/setTargetPools"
     #{:zone :instanceGroupManager :project}
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
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/list
  
  Required parameters: project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves a list of managed instance groups that are contained within the specified project and zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers"
     #{:zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patchPerInstanceConfigs$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/patchPerInstanceConfigs
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:perInstanceConfigs [{:name string,
                         :preservedState PreservedState,
                         :status string,
                         :fingerprint string}]}
  
  Inserts or patches per-instance configurations for the managed instance group. perInstanceConfig.name serves as a key used to distinguish whether to perform insert or patch."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/patchPerInstanceConfigs"
     #{:zone :instanceGroupManager :project}
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

(defn createInstances$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/createInstances
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [{:name string,
                :preservedState PreservedState,
                :status string,
                :fingerprint string}]}
  
  Creates instances with per-instance configurations in this managed instance group. Instances are created using the current instance template. The create instances operation is marked DONE if the createInstances request is successful. The underlying actions take additional time. You must separately verify the status of the creating or actions with the listmanagedinstances method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/createInstances"
     #{:zone :instanceGroupManager :project}
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

(defn deleteInstances$
  "https://cloud.google.com/products/compute/v1/docs/instanceGroupManagers/deleteInstances
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [string], :skipInstancesOnValidationError boolean}
  
  Flags the specified instances in the managed instance group for immediate deletion. The instances are also removed from any target pools of which they were a member. This method reduces the targetSize of the managed instance group by the number of instances that you delete. This operation is marked as DONE when the action is scheduled even if the instances are still being deleted. You must separately verify the status of the deleting action with the listmanagedinstances method. If the group is part of a backend service that has enabled connection draining, it can take up to 60 seconds after the connection draining duration has elapsed before the VM instance is removed or deleted. You can specify a maximum of 1000 instances with this method per request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/deleteInstances"
     #{:zone :instanceGroupManager :project}
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
