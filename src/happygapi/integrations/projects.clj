(ns happygapi.integrations.projects
  "Application Integration API: projects.
  
  See: https://cloud.google.com/application-integration"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getClientmetadata$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets the metadata info for the requested client"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/clientmetadata"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-getClients$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets the client configuration for the given project and location resource name"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/clients"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-integrations-executeEvent$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: triggerId
  
  Body: 
  
  {}
  
  Executes an integration on receiving events from Integration Connector triggers, Eventarc or CPS Trigger. Input data to integration is received in body in json format"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:executeEvent"
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

(defn locations-integrations-execute$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:doNotPropagateError boolean,
   :parameterEntries [{:masked boolean,
                       :dataType string,
                       :key string,
                       :value EnterpriseCrmFrontendsEventbusProtoParameterValueType}],
   :parameters {:parameters [EnterpriseCrmFrontendsEventbusProtoParameterEntry]},
   :inputParameters {},
   :triggerId string,
   :executionId string,
   :requestId string}
  
  Executes integrations synchronously by passing the trigger id in the request body. The request is not returned until the requested executions are either fulfilled or experienced an error. If the integration name is not specified (passing `-`), all of the associated integration under the given trigger_id will be executed. Otherwise only the specified integration for the given `trigger_id` is executed. This is helpful for execution the integration from UI."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:execute"
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

(defn locations-integrations-schedule$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:triggerId string,
   :scheduleTime string,
   :requestId string,
   :inputParameters {},
   :parameterEntries [{:masked boolean,
                       :dataType string,
                       :key string,
                       :value EnterpriseCrmFrontendsEventbusProtoParameterValueType}],
   :parameters {:parameters [EnterpriseCrmEventbusProtoParameterEntry]},
   :userGeneratedExecutionId string}
  
  Schedules an integration for execution by passing the trigger id and the scheduled time in the request body."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:schedule"
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

(defn locations-integrations-delete$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete the selected integration and all versions inside"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-integrations-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, orderBy, pageSize
  
  Returns the list of all integrations in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/integrations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-integrations-test$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:deadlineSecondsTime string,
   :clientId string,
   :configParameters {},
   :testMode boolean,
   :triggerId string,
   :parameters {:parameters [EnterpriseCrmFrontendsEventbusProtoParameterEntry]},
   :integrationVersion {:triggerConfigsInternal [EnterpriseCrmFrontendsEventbusProtoTriggerConfig],
                        :description string,
                        :taskConfigsInternal [EnterpriseCrmFrontendsEventbusProtoTaskConfig],
                        :name string,
                        :triggerConfigs [GoogleCloudIntegrationsV1alphaTriggerConfig],
                        :integrationParameters [GoogleCloudIntegrationsV1alphaIntegrationParameter],
                        :cloudLoggingDetails GoogleCloudIntegrationsV1alphaCloudLoggingDetails,
                        :createTime string,
                        :userLabel string,
                        :state string,
                        :lastModifierEmail string,
                        :runAsServiceAccount string,
                        :updateTime string,
                        :taskConfigs [GoogleCloudIntegrationsV1alphaTaskConfig],
                        :errorCatcherConfigs [GoogleCloudIntegrationsV1alphaErrorCatcherConfig],
                        :databasePersistencePolicy string,
                        :status string,
                        :integrationConfigParameters [GoogleCloudIntegrationsV1alphaIntegrationConfigParameter],
                        :snapshotNumber string,
                        :origin string,
                        :enableVariableMasking boolean,
                        :integrationParametersInternal EnterpriseCrmFrontendsEventbusProtoWorkflowParameters,
                        :teardown EnterpriseCrmEventbusProtoTeardown,
                        :createdFromTemplate string,
                        :lockHolder string,
                        :parentTemplateId string},
   :inputParameters {}}
  
  Execute the integration in draft state"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:test"
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

(defn locations-integrations-versions-unpublish$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Sets the status of the ACTIVE integration to SNAPSHOT with a new tag \"PREVIOUSLY_PUBLISHED\" after validating it. The \"HEAD\" and \"PUBLISH_REQUESTED\" tags do not change. This RPC throws an exception if the version being snapshot is not ACTIVE. Audit fields added include action, action_by, action_timestamp."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:unpublish"
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

(defn locations-integrations-versions-get$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a integration in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-integrations-versions-patch$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:triggerConfigsInternal [{:description string,
                             :properties {},
                             :cloudSchedulerConfig EnterpriseCrmEventbusProtoCloudSchedulerConfig,
                             :triggerId string,
                             :errorCatcherId string,
                             :nextTasksExecutionPolicy string,
                             :startTasks [EnterpriseCrmEventbusProtoNextTask],
                             :triggerCriteria EnterpriseCrmEventbusProtoTriggerCriteria,
                             :alertConfig [EnterpriseCrmEventbusProtoWorkflowAlertConfig],
                             :label string,
                             :triggerType string,
                             :position EnterpriseCrmEventbusProtoCoordinate,
                             :triggerName string,
                             :enabledClients [string],
                             :triggerNumber string,
                             :pauseWorkflowExecutions boolean}],
   :description string,
   :taskConfigsInternal [{:description string,
                          :failurePolicy EnterpriseCrmEventbusProtoFailurePolicy,
                          :errorCatcherId string,
                          :nextTasksExecutionPolicy string,
                          :disableStrictTypeValidation boolean,
                          :taskSpec string,
                          :incomingEdgeCount integer,
                          :createTime string,
                          :taskType string,
                          :preconditionLabel string,
                          :rollbackStrategy EnterpriseCrmFrontendsEventbusProtoRollbackStrategy,
                          :nextTasks [EnterpriseCrmEventbusProtoNextTask],
                          :synchronousCallFailurePolicy EnterpriseCrmEventbusProtoFailurePolicy,
                          :taskTemplateName string,
                          :jsonValidationOption string,
                          :lastModifiedTime string,
                          :alertConfigs [EnterpriseCrmEventbusProtoTaskAlertConfig],
                          :label string,
                          :position EnterpriseCrmEventbusProtoCoordinate,
                          :taskEntity EnterpriseCrmFrontendsEventbusProtoTaskEntity,
                          :externalTaskType string,
                          :creatorEmail string,
                          :taskName string,
                          :parameters {},
                          :taskNumber string,
                          :taskExecutionStrategy string,
                          :successPolicy EnterpriseCrmEventbusProtoSuccessPolicy,
                          :precondition string}],
   :name string,
   :triggerConfigs [{:description string,
                     :properties {},
                     :cloudSchedulerConfig GoogleCloudIntegrationsV1alphaCloudSchedulerConfig,
                     :triggerId string,
                     :errorCatcherId string,
                     :nextTasksExecutionPolicy string,
                     :startTasks [GoogleCloudIntegrationsV1alphaNextTask],
                     :alertConfig [GoogleCloudIntegrationsV1alphaIntegrationAlertConfig],
                     :label string,
                     :triggerType string,
                     :position GoogleCloudIntegrationsV1alphaCoordinate,
                     :trigger string,
                     :triggerNumber string}],
   :integrationParameters [{:containsLargeData boolean,
                            :producer string,
                            :key string,
                            :displayName string,
                            :isTransient boolean,
                            :searchable boolean,
                            :jsonSchema string,
                            :dataType string,
                            :defaultValue GoogleCloudIntegrationsV1alphaValueType,
                            :inputOutputType string,
                            :masked boolean}],
   :cloudLoggingDetails {:cloudLoggingSeverity string,
                         :enableCloudLogging boolean},
   :createTime string,
   :userLabel string,
   :state string,
   :lastModifierEmail string,
   :runAsServiceAccount string,
   :updateTime string,
   :taskConfigs [{:description string,
                  :failurePolicy GoogleCloudIntegrationsV1alphaFailurePolicy,
                  :errorCatcherId string,
                  :task string,
                  :nextTasksExecutionPolicy string,
                  :taskTemplate string,
                  :displayName string,
                  :nextTasks [GoogleCloudIntegrationsV1alphaNextTask],
                  :synchronousCallFailurePolicy GoogleCloudIntegrationsV1alphaFailurePolicy,
                  :jsonValidationOption string,
                  :position GoogleCloudIntegrationsV1alphaCoordinate,
                  :externalTaskType string,
                  :taskId string,
                  :parameters {},
                  :taskExecutionStrategy string,
                  :successPolicy GoogleCloudIntegrationsV1alphaSuccessPolicy}],
   :errorCatcherConfigs [{:description string,
                          :position GoogleCloudIntegrationsV1alphaCoordinate,
                          :errorCatcherId string,
                          :errorCatcherNumber string,
                          :startErrorTasks [GoogleCloudIntegrationsV1alphaNextTask],
                          :label string}],
   :databasePersistencePolicy string,
   :status string,
   :integrationConfigParameters [{:value GoogleCloudIntegrationsV1alphaValueType,
                                  :parameter GoogleCloudIntegrationsV1alphaIntegrationParameter}],
   :snapshotNumber string,
   :origin string,
   :enableVariableMasking boolean,
   :integrationParametersInternal {:parameters [EnterpriseCrmFrontendsEventbusProtoWorkflowParameterEntry]},
   :teardown {:teardownTaskConfigs [EnterpriseCrmEventbusProtoTeardownTaskConfig]},
   :createdFromTemplate string,
   :lockHolder string,
   :parentTemplateId string}
  
  Update a integration with a draft version in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-integrations-versions-create$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: newIntegration, createSampleIntegrations
  
  Body: 
  
  {:triggerConfigsInternal [{:description string,
                             :properties {},
                             :cloudSchedulerConfig EnterpriseCrmEventbusProtoCloudSchedulerConfig,
                             :triggerId string,
                             :errorCatcherId string,
                             :nextTasksExecutionPolicy string,
                             :startTasks [EnterpriseCrmEventbusProtoNextTask],
                             :triggerCriteria EnterpriseCrmEventbusProtoTriggerCriteria,
                             :alertConfig [EnterpriseCrmEventbusProtoWorkflowAlertConfig],
                             :label string,
                             :triggerType string,
                             :position EnterpriseCrmEventbusProtoCoordinate,
                             :triggerName string,
                             :enabledClients [string],
                             :triggerNumber string,
                             :pauseWorkflowExecutions boolean}],
   :description string,
   :taskConfigsInternal [{:description string,
                          :failurePolicy EnterpriseCrmEventbusProtoFailurePolicy,
                          :errorCatcherId string,
                          :nextTasksExecutionPolicy string,
                          :disableStrictTypeValidation boolean,
                          :taskSpec string,
                          :incomingEdgeCount integer,
                          :createTime string,
                          :taskType string,
                          :preconditionLabel string,
                          :rollbackStrategy EnterpriseCrmFrontendsEventbusProtoRollbackStrategy,
                          :nextTasks [EnterpriseCrmEventbusProtoNextTask],
                          :synchronousCallFailurePolicy EnterpriseCrmEventbusProtoFailurePolicy,
                          :taskTemplateName string,
                          :jsonValidationOption string,
                          :lastModifiedTime string,
                          :alertConfigs [EnterpriseCrmEventbusProtoTaskAlertConfig],
                          :label string,
                          :position EnterpriseCrmEventbusProtoCoordinate,
                          :taskEntity EnterpriseCrmFrontendsEventbusProtoTaskEntity,
                          :externalTaskType string,
                          :creatorEmail string,
                          :taskName string,
                          :parameters {},
                          :taskNumber string,
                          :taskExecutionStrategy string,
                          :successPolicy EnterpriseCrmEventbusProtoSuccessPolicy,
                          :precondition string}],
   :name string,
   :triggerConfigs [{:description string,
                     :properties {},
                     :cloudSchedulerConfig GoogleCloudIntegrationsV1alphaCloudSchedulerConfig,
                     :triggerId string,
                     :errorCatcherId string,
                     :nextTasksExecutionPolicy string,
                     :startTasks [GoogleCloudIntegrationsV1alphaNextTask],
                     :alertConfig [GoogleCloudIntegrationsV1alphaIntegrationAlertConfig],
                     :label string,
                     :triggerType string,
                     :position GoogleCloudIntegrationsV1alphaCoordinate,
                     :trigger string,
                     :triggerNumber string}],
   :integrationParameters [{:containsLargeData boolean,
                            :producer string,
                            :key string,
                            :displayName string,
                            :isTransient boolean,
                            :searchable boolean,
                            :jsonSchema string,
                            :dataType string,
                            :defaultValue GoogleCloudIntegrationsV1alphaValueType,
                            :inputOutputType string,
                            :masked boolean}],
   :cloudLoggingDetails {:cloudLoggingSeverity string,
                         :enableCloudLogging boolean},
   :createTime string,
   :userLabel string,
   :state string,
   :lastModifierEmail string,
   :runAsServiceAccount string,
   :updateTime string,
   :taskConfigs [{:description string,
                  :failurePolicy GoogleCloudIntegrationsV1alphaFailurePolicy,
                  :errorCatcherId string,
                  :task string,
                  :nextTasksExecutionPolicy string,
                  :taskTemplate string,
                  :displayName string,
                  :nextTasks [GoogleCloudIntegrationsV1alphaNextTask],
                  :synchronousCallFailurePolicy GoogleCloudIntegrationsV1alphaFailurePolicy,
                  :jsonValidationOption string,
                  :position GoogleCloudIntegrationsV1alphaCoordinate,
                  :externalTaskType string,
                  :taskId string,
                  :parameters {},
                  :taskExecutionStrategy string,
                  :successPolicy GoogleCloudIntegrationsV1alphaSuccessPolicy}],
   :errorCatcherConfigs [{:description string,
                          :position GoogleCloudIntegrationsV1alphaCoordinate,
                          :errorCatcherId string,
                          :errorCatcherNumber string,
                          :startErrorTasks [GoogleCloudIntegrationsV1alphaNextTask],
                          :label string}],
   :databasePersistencePolicy string,
   :status string,
   :integrationConfigParameters [{:value GoogleCloudIntegrationsV1alphaValueType,
                                  :parameter GoogleCloudIntegrationsV1alphaIntegrationParameter}],
   :snapshotNumber string,
   :origin string,
   :enableVariableMasking boolean,
   :integrationParametersInternal {:parameters [EnterpriseCrmFrontendsEventbusProtoWorkflowParameterEntry]},
   :teardown {:teardownTaskConfigs [EnterpriseCrmEventbusProtoTeardownTaskConfig]},
   :createdFromTemplate string,
   :lockHolder string,
   :parentTemplateId string}
  
  Create a integration with a draft version in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/versions"
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

(defn locations-integrations-versions-delete$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Soft-deletes the integration. Changes the status of the integration to ARCHIVED. If the integration being ARCHIVED is tagged as \"HEAD\", the tag is removed from this snapshot and set to the previous non-ARCHIVED snapshot. The PUBLISH_REQUESTED, DUE_FOR_DELETION tags are removed too. This RPC throws an exception if the version being deleted is DRAFT, and if the `locked_by` user is not the same as the user performing the Delete. Audit fields updated include last_modified_timestamp, last_modified_by. Any existing lock is released when Deleting a integration. Currently, there is no undelete mechanism."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-integrations-versions-downloadJsonPackage$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: files
  
  Downloads an Integration version package like IntegrationVersion,Integration Config etc. Retrieves the IntegrationVersion package for a given `integration_id` and returns the response as a JSON."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:downloadJsonPackage"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-integrations-versions-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: orderBy, pageSize, fieldMask, filter, pageToken
  
  Returns the list of all integration versions in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/versions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-integrations-versions-download$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: files, fileFormat
  
  Downloads an integration. Retrieves the `IntegrationVersion` for a given `integration_id` and returns the response as a string."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:download"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-integrations-versions-publish$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:configParameters {}}
  
  This RPC throws an exception if the integration is in ARCHIVED or ACTIVE state. This RPC throws an exception if the version being published is DRAFT, and if the `locked_by` user is not the same as the user performing the Publish. Audit fields updated include last_published_timestamp, last_published_by, last_modified_timestamp, last_modified_by. Any existing lock is on this integration is released."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:publish"
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

(defn locations-integrations-versions-upload$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:fileFormat string, :content string}
  
  Uploads an integration. The content can be a previously downloaded integration. Performs the same function as CreateDraftIntegrationVersion, but accepts input in a string format, which holds the complete representation of the IntegrationVersion content."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/versions:upload"
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

(defn locations-integrations-executions-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: filterParams.workflowName, filterParams.startTime, filterParams.parameterKey, filterParams.parameterValue, truncateParams, filterParams.taskStatuses, snapshotMetadataWithoutParams, filterParams.parameterPairValue, filterParams.eventStatuses, filterParams.customFilter, filterParams.parameterType, pageToken, filter, pageSize, filterParams.executionId, filterParams.endTime, readMask, filterParams.parameterPairKey, refreshAcl, orderBy
  
  Lists the results of all the integration executions. The response includes the same information as the [execution log](https://cloud.google.com/application-integration/docs/viewing-logs) in the Integration UI."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/executions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-integrations-executions-get$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Get an execution in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-integrations-executions-download$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Download the execution."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:download"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-integrations-executions-suspensions-resolve$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:suspension {:lastModifyTime string,
                :name string,
                :createTime string,
                :integration string,
                :state string,
                :suspensionConfig EnterpriseCrmEventbusProtoSuspensionConfig,
                :audit GoogleCloudIntegrationsV1alphaSuspensionAudit,
                :approvalConfig GoogleCloudIntegrationsV1alphaSuspensionApprovalConfig,
                :eventExecutionInfoId string,
                :taskId string}}
  
  * Resolves (lifts/rejects) any number of suspensions. If the integration is already running, only the status of the suspension is updated. Otherwise, the suspended integration will begin execution again."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:resolve"
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

(defn locations-integrations-executions-suspensions-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: orderBy, filter, pageToken, pageSize
  
  * Lists suspensions associated with a specific execution. Only those with permissions to resolve the relevant suspensions will be able to view them."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/suspensions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-integrations-executions-suspensions-lift$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:suspensionResult string}
  
  * Lifts suspension for the Suspension task. Fetch corresponding suspension with provided suspension Id, resolve suspension, and set up suspension result for the Suspension Task."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:lift"
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

(defn locations-products-sfdcInstances-patch$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :deleteTime string,
   :displayName string,
   :name string,
   :authConfigId [string],
   :createTime string,
   :serviceAuthority string,
   :updateTime string,
   :sfdcOrgId string}
  
  Updates an sfdc instance. Updates the sfdc instance in spanner. Returns the sfdc instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-products-sfdcInstances-get$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an sfdc instance. If the instance doesn't exist, Code.NOT_FOUND exception will be thrown."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-products-sfdcInstances-create$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :deleteTime string,
   :displayName string,
   :name string,
   :authConfigId [string],
   :createTime string,
   :serviceAuthority string,
   :updateTime string,
   :sfdcOrgId string}
  
  Creates an sfdc instance record. Store the sfdc instance in Spanner. Returns the sfdc instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/sfdcInstances"
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

(defn locations-products-sfdcInstances-delete$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an sfdc instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-products-sfdcInstances-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize, readMask
  
  Lists all sfdc instances that match the filter. Restrict to sfdc instances belonging to the current client only."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/sfdcInstances"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-products-sfdcInstances-sfdcChannels-delete$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an sfdc channel."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-products-sfdcInstances-sfdcChannels-get$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an sfdc channel. If the channel doesn't exist, Code.NOT_FOUND exception will be thrown."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-products-sfdcInstances-sfdcChannels-patch$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :lastReplayId string,
   :deleteTime string,
   :displayName string,
   :name string,
   :channelTopic string,
   :createTime string,
   :updateTime string,
   :isActive boolean}
  
  Updates an sfdc channel. Updates the sfdc channel in spanner. Returns the sfdc channel."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-products-sfdcInstances-sfdcChannels-create$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :lastReplayId string,
   :deleteTime string,
   :displayName string,
   :name string,
   :channelTopic string,
   :createTime string,
   :updateTime string,
   :isActive boolean}
  
  Creates an sfdc channel record. Store the sfdc channel in Spanner. Returns the sfdc channel."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/sfdcChannels"
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

(defn locations-products-sfdcInstances-sfdcChannels-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, pageToken, readMask
  
  Lists all sfdc channels that match the filter. Restrict to sfdc channels belonging to the current client only."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/sfdcChannels"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-products-cloudFunctions-create$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:functionName string, :functionRegion string, :projectId string}
  
  Creates a cloud function project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/cloudFunctions"
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

(defn locations-products-certificates-create$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :credentialId string,
   :displayName string,
   :requestorId string,
   :name string,
   :rawCertificate {:sslCertificate string,
                    :encryptedPrivateKey string,
                    :passphrase string},
   :validEndTime string,
   :validStartTime string,
   :certificateStatus string}
  
  Creates a new certificate. The certificate will be registered to the trawler service and will be encrypted using cloud KMS and stored in Spanner Returns the certificate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/certificates"
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

(defn locations-products-certificates-get$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a certificates in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-products-certificates-patch$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :credentialId string,
   :displayName string,
   :requestorId string,
   :name string,
   :rawCertificate {:sslCertificate string,
                    :encryptedPrivateKey string,
                    :passphrase string},
   :validEndTime string,
   :validStartTime string,
   :certificateStatus string}
  
  Updates the certificate by id. If new certificate file is updated, it will register with the trawler service, re-encrypt with cloud KMS and update the Spanner record. Other fields will directly update the Spanner record. Returns the Certificate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-products-certificates-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: pageToken, readMask, pageSize, filter
  
  List all the certificates that match the filter. Restrict to certificate of current client only."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/certificates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-products-certificates-delete$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a certificate"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-products-integrations-schedule$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:triggerId string,
   :scheduleTime string,
   :requestId string,
   :inputParameters {},
   :parameterEntries [{:masked boolean,
                       :dataType string,
                       :key string,
                       :value EnterpriseCrmFrontendsEventbusProtoParameterValueType}],
   :parameters {:parameters [EnterpriseCrmEventbusProtoParameterEntry]},
   :userGeneratedExecutionId string}
  
  Schedules an integration for execution by passing the trigger id and the scheduled time in the request body."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:schedule"
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

(defn locations-products-integrations-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, orderBy, pageToken
  
  Returns the list of all integrations in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/integrations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-products-integrations-execute$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:doNotPropagateError boolean,
   :parameterEntries [{:masked boolean,
                       :dataType string,
                       :key string,
                       :value EnterpriseCrmFrontendsEventbusProtoParameterValueType}],
   :parameters {:parameters [EnterpriseCrmFrontendsEventbusProtoParameterEntry]},
   :inputParameters {},
   :triggerId string,
   :executionId string,
   :requestId string}
  
  Executes integrations synchronously by passing the trigger id in the request body. The request is not returned until the requested executions are either fulfilled or experienced an error. If the integration name is not specified (passing `-`), all of the associated integration under the given trigger_id will be executed. Otherwise only the specified integration for the given `trigger_id` is executed. This is helpful for execution the integration from UI."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:execute"
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

(defn locations-products-integrations-test$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:deadlineSecondsTime string,
   :clientId string,
   :configParameters {},
   :testMode boolean,
   :triggerId string,
   :parameters {:parameters [EnterpriseCrmFrontendsEventbusProtoParameterEntry]},
   :integrationVersion {:triggerConfigsInternal [EnterpriseCrmFrontendsEventbusProtoTriggerConfig],
                        :description string,
                        :taskConfigsInternal [EnterpriseCrmFrontendsEventbusProtoTaskConfig],
                        :name string,
                        :triggerConfigs [GoogleCloudIntegrationsV1alphaTriggerConfig],
                        :integrationParameters [GoogleCloudIntegrationsV1alphaIntegrationParameter],
                        :cloudLoggingDetails GoogleCloudIntegrationsV1alphaCloudLoggingDetails,
                        :createTime string,
                        :userLabel string,
                        :state string,
                        :lastModifierEmail string,
                        :runAsServiceAccount string,
                        :updateTime string,
                        :taskConfigs [GoogleCloudIntegrationsV1alphaTaskConfig],
                        :errorCatcherConfigs [GoogleCloudIntegrationsV1alphaErrorCatcherConfig],
                        :databasePersistencePolicy string,
                        :status string,
                        :integrationConfigParameters [GoogleCloudIntegrationsV1alphaIntegrationConfigParameter],
                        :snapshotNumber string,
                        :origin string,
                        :enableVariableMasking boolean,
                        :integrationParametersInternal EnterpriseCrmFrontendsEventbusProtoWorkflowParameters,
                        :teardown EnterpriseCrmEventbusProtoTeardown,
                        :createdFromTemplate string,
                        :lockHolder string,
                        :parentTemplateId string},
   :inputParameters {}}
  
  Execute the integration in draft state"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:test"
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

(defn locations-products-integrations-versions-unpublish$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Sets the status of the ACTIVE integration to SNAPSHOT with a new tag \"PREVIOUSLY_PUBLISHED\" after validating it. The \"HEAD\" and \"PUBLISH_REQUESTED\" tags do not change. This RPC throws an exception if the version being snapshot is not ACTIVE. Audit fields added include action, action_by, action_timestamp."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:unpublish"
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

(defn locations-products-integrations-versions-get$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a integration in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-products-integrations-versions-patch$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:triggerConfigsInternal [{:description string,
                             :properties {},
                             :cloudSchedulerConfig EnterpriseCrmEventbusProtoCloudSchedulerConfig,
                             :triggerId string,
                             :errorCatcherId string,
                             :nextTasksExecutionPolicy string,
                             :startTasks [EnterpriseCrmEventbusProtoNextTask],
                             :triggerCriteria EnterpriseCrmEventbusProtoTriggerCriteria,
                             :alertConfig [EnterpriseCrmEventbusProtoWorkflowAlertConfig],
                             :label string,
                             :triggerType string,
                             :position EnterpriseCrmEventbusProtoCoordinate,
                             :triggerName string,
                             :enabledClients [string],
                             :triggerNumber string,
                             :pauseWorkflowExecutions boolean}],
   :description string,
   :taskConfigsInternal [{:description string,
                          :failurePolicy EnterpriseCrmEventbusProtoFailurePolicy,
                          :errorCatcherId string,
                          :nextTasksExecutionPolicy string,
                          :disableStrictTypeValidation boolean,
                          :taskSpec string,
                          :incomingEdgeCount integer,
                          :createTime string,
                          :taskType string,
                          :preconditionLabel string,
                          :rollbackStrategy EnterpriseCrmFrontendsEventbusProtoRollbackStrategy,
                          :nextTasks [EnterpriseCrmEventbusProtoNextTask],
                          :synchronousCallFailurePolicy EnterpriseCrmEventbusProtoFailurePolicy,
                          :taskTemplateName string,
                          :jsonValidationOption string,
                          :lastModifiedTime string,
                          :alertConfigs [EnterpriseCrmEventbusProtoTaskAlertConfig],
                          :label string,
                          :position EnterpriseCrmEventbusProtoCoordinate,
                          :taskEntity EnterpriseCrmFrontendsEventbusProtoTaskEntity,
                          :externalTaskType string,
                          :creatorEmail string,
                          :taskName string,
                          :parameters {},
                          :taskNumber string,
                          :taskExecutionStrategy string,
                          :successPolicy EnterpriseCrmEventbusProtoSuccessPolicy,
                          :precondition string}],
   :name string,
   :triggerConfigs [{:description string,
                     :properties {},
                     :cloudSchedulerConfig GoogleCloudIntegrationsV1alphaCloudSchedulerConfig,
                     :triggerId string,
                     :errorCatcherId string,
                     :nextTasksExecutionPolicy string,
                     :startTasks [GoogleCloudIntegrationsV1alphaNextTask],
                     :alertConfig [GoogleCloudIntegrationsV1alphaIntegrationAlertConfig],
                     :label string,
                     :triggerType string,
                     :position GoogleCloudIntegrationsV1alphaCoordinate,
                     :trigger string,
                     :triggerNumber string}],
   :integrationParameters [{:containsLargeData boolean,
                            :producer string,
                            :key string,
                            :displayName string,
                            :isTransient boolean,
                            :searchable boolean,
                            :jsonSchema string,
                            :dataType string,
                            :defaultValue GoogleCloudIntegrationsV1alphaValueType,
                            :inputOutputType string,
                            :masked boolean}],
   :cloudLoggingDetails {:cloudLoggingSeverity string,
                         :enableCloudLogging boolean},
   :createTime string,
   :userLabel string,
   :state string,
   :lastModifierEmail string,
   :runAsServiceAccount string,
   :updateTime string,
   :taskConfigs [{:description string,
                  :failurePolicy GoogleCloudIntegrationsV1alphaFailurePolicy,
                  :errorCatcherId string,
                  :task string,
                  :nextTasksExecutionPolicy string,
                  :taskTemplate string,
                  :displayName string,
                  :nextTasks [GoogleCloudIntegrationsV1alphaNextTask],
                  :synchronousCallFailurePolicy GoogleCloudIntegrationsV1alphaFailurePolicy,
                  :jsonValidationOption string,
                  :position GoogleCloudIntegrationsV1alphaCoordinate,
                  :externalTaskType string,
                  :taskId string,
                  :parameters {},
                  :taskExecutionStrategy string,
                  :successPolicy GoogleCloudIntegrationsV1alphaSuccessPolicy}],
   :errorCatcherConfigs [{:description string,
                          :position GoogleCloudIntegrationsV1alphaCoordinate,
                          :errorCatcherId string,
                          :errorCatcherNumber string,
                          :startErrorTasks [GoogleCloudIntegrationsV1alphaNextTask],
                          :label string}],
   :databasePersistencePolicy string,
   :status string,
   :integrationConfigParameters [{:value GoogleCloudIntegrationsV1alphaValueType,
                                  :parameter GoogleCloudIntegrationsV1alphaIntegrationParameter}],
   :snapshotNumber string,
   :origin string,
   :enableVariableMasking boolean,
   :integrationParametersInternal {:parameters [EnterpriseCrmFrontendsEventbusProtoWorkflowParameterEntry]},
   :teardown {:teardownTaskConfigs [EnterpriseCrmEventbusProtoTeardownTaskConfig]},
   :createdFromTemplate string,
   :lockHolder string,
   :parentTemplateId string}
  
  Update a integration with a draft version in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-products-integrations-versions-create$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: createSampleIntegrations, newIntegration
  
  Body: 
  
  {:triggerConfigsInternal [{:description string,
                             :properties {},
                             :cloudSchedulerConfig EnterpriseCrmEventbusProtoCloudSchedulerConfig,
                             :triggerId string,
                             :errorCatcherId string,
                             :nextTasksExecutionPolicy string,
                             :startTasks [EnterpriseCrmEventbusProtoNextTask],
                             :triggerCriteria EnterpriseCrmEventbusProtoTriggerCriteria,
                             :alertConfig [EnterpriseCrmEventbusProtoWorkflowAlertConfig],
                             :label string,
                             :triggerType string,
                             :position EnterpriseCrmEventbusProtoCoordinate,
                             :triggerName string,
                             :enabledClients [string],
                             :triggerNumber string,
                             :pauseWorkflowExecutions boolean}],
   :description string,
   :taskConfigsInternal [{:description string,
                          :failurePolicy EnterpriseCrmEventbusProtoFailurePolicy,
                          :errorCatcherId string,
                          :nextTasksExecutionPolicy string,
                          :disableStrictTypeValidation boolean,
                          :taskSpec string,
                          :incomingEdgeCount integer,
                          :createTime string,
                          :taskType string,
                          :preconditionLabel string,
                          :rollbackStrategy EnterpriseCrmFrontendsEventbusProtoRollbackStrategy,
                          :nextTasks [EnterpriseCrmEventbusProtoNextTask],
                          :synchronousCallFailurePolicy EnterpriseCrmEventbusProtoFailurePolicy,
                          :taskTemplateName string,
                          :jsonValidationOption string,
                          :lastModifiedTime string,
                          :alertConfigs [EnterpriseCrmEventbusProtoTaskAlertConfig],
                          :label string,
                          :position EnterpriseCrmEventbusProtoCoordinate,
                          :taskEntity EnterpriseCrmFrontendsEventbusProtoTaskEntity,
                          :externalTaskType string,
                          :creatorEmail string,
                          :taskName string,
                          :parameters {},
                          :taskNumber string,
                          :taskExecutionStrategy string,
                          :successPolicy EnterpriseCrmEventbusProtoSuccessPolicy,
                          :precondition string}],
   :name string,
   :triggerConfigs [{:description string,
                     :properties {},
                     :cloudSchedulerConfig GoogleCloudIntegrationsV1alphaCloudSchedulerConfig,
                     :triggerId string,
                     :errorCatcherId string,
                     :nextTasksExecutionPolicy string,
                     :startTasks [GoogleCloudIntegrationsV1alphaNextTask],
                     :alertConfig [GoogleCloudIntegrationsV1alphaIntegrationAlertConfig],
                     :label string,
                     :triggerType string,
                     :position GoogleCloudIntegrationsV1alphaCoordinate,
                     :trigger string,
                     :triggerNumber string}],
   :integrationParameters [{:containsLargeData boolean,
                            :producer string,
                            :key string,
                            :displayName string,
                            :isTransient boolean,
                            :searchable boolean,
                            :jsonSchema string,
                            :dataType string,
                            :defaultValue GoogleCloudIntegrationsV1alphaValueType,
                            :inputOutputType string,
                            :masked boolean}],
   :cloudLoggingDetails {:cloudLoggingSeverity string,
                         :enableCloudLogging boolean},
   :createTime string,
   :userLabel string,
   :state string,
   :lastModifierEmail string,
   :runAsServiceAccount string,
   :updateTime string,
   :taskConfigs [{:description string,
                  :failurePolicy GoogleCloudIntegrationsV1alphaFailurePolicy,
                  :errorCatcherId string,
                  :task string,
                  :nextTasksExecutionPolicy string,
                  :taskTemplate string,
                  :displayName string,
                  :nextTasks [GoogleCloudIntegrationsV1alphaNextTask],
                  :synchronousCallFailurePolicy GoogleCloudIntegrationsV1alphaFailurePolicy,
                  :jsonValidationOption string,
                  :position GoogleCloudIntegrationsV1alphaCoordinate,
                  :externalTaskType string,
                  :taskId string,
                  :parameters {},
                  :taskExecutionStrategy string,
                  :successPolicy GoogleCloudIntegrationsV1alphaSuccessPolicy}],
   :errorCatcherConfigs [{:description string,
                          :position GoogleCloudIntegrationsV1alphaCoordinate,
                          :errorCatcherId string,
                          :errorCatcherNumber string,
                          :startErrorTasks [GoogleCloudIntegrationsV1alphaNextTask],
                          :label string}],
   :databasePersistencePolicy string,
   :status string,
   :integrationConfigParameters [{:value GoogleCloudIntegrationsV1alphaValueType,
                                  :parameter GoogleCloudIntegrationsV1alphaIntegrationParameter}],
   :snapshotNumber string,
   :origin string,
   :enableVariableMasking boolean,
   :integrationParametersInternal {:parameters [EnterpriseCrmFrontendsEventbusProtoWorkflowParameterEntry]},
   :teardown {:teardownTaskConfigs [EnterpriseCrmEventbusProtoTeardownTaskConfig]},
   :createdFromTemplate string,
   :lockHolder string,
   :parentTemplateId string}
  
  Create a integration with a draft version in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/versions"
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

(defn locations-products-integrations-versions-delete$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Soft-deletes the integration. Changes the status of the integration to ARCHIVED. If the integration being ARCHIVED is tagged as \"HEAD\", the tag is removed from this snapshot and set to the previous non-ARCHIVED snapshot. The PUBLISH_REQUESTED, DUE_FOR_DELETION tags are removed too. This RPC throws an exception if the version being deleted is DRAFT, and if the `locked_by` user is not the same as the user performing the Delete. Audit fields updated include last_modified_timestamp, last_modified_by. Any existing lock is released when Deleting a integration. Currently, there is no undelete mechanism."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-products-integrations-versions-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: pageToken, filter, fieldMask, pageSize, orderBy
  
  Returns the list of all integration versions in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/versions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-products-integrations-versions-takeoverEditLock$
  "https://cloud.google.com/application-integration
  
  Required parameters: integrationVersion
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Clears the `locked_by` and `locked_at_timestamp`in the DRAFT version of this integration. It then performs the same action as the CreateDraftIntegrationVersion (i.e., copies the DRAFT version of the integration as a SNAPSHOT and then creates a new DRAFT version with the `locked_by` set to the `user_taking_over` and the `locked_at_timestamp` set to the current timestamp). Both the `locked_by` and `user_taking_over` are notified via email about the takeover. This RPC throws an exception if the integration is not in DRAFT status or if the `locked_by` and `locked_at_timestamp` fields are not set.The TakeoverEdit lock is treated the same as an edit of the integration, and hence shares ACLs with edit. Audit fields updated include last_modified_timestamp, last_modified_by."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:integrationVersion})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+integrationVersion}:takeoverEditLock"
     #{:integrationVersion}
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

(defn locations-products-integrations-versions-download$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: files, fileFormat
  
  Downloads an integration. Retrieves the `IntegrationVersion` for a given `integration_id` and returns the response as a string."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:download"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-products-integrations-versions-publish$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:configParameters {}}
  
  This RPC throws an exception if the integration is in ARCHIVED or ACTIVE state. This RPC throws an exception if the version being published is DRAFT, and if the `locked_by` user is not the same as the user performing the Publish. Audit fields updated include last_published_timestamp, last_published_by, last_modified_timestamp, last_modified_by. Any existing lock is on this integration is released."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:publish"
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

(defn locations-products-integrations-versions-upload$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:fileFormat string, :content string}
  
  Uploads an integration. The content can be a previously downloaded integration. Performs the same function as CreateDraftIntegrationVersion, but accepts input in a string format, which holds the complete representation of the IntegrationVersion content."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/versions:upload"
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

(defn locations-products-integrations-executions-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: filterParams.workflowName, filterParams.startTime, filterParams.parameterKey, filterParams.parameterValue, truncateParams, filterParams.taskStatuses, snapshotMetadataWithoutParams, filterParams.parameterPairValue, filterParams.eventStatuses, filterParams.customFilter, filterParams.parameterType, pageToken, filter, pageSize, filterParams.executionId, filterParams.endTime, readMask, filterParams.parameterPairKey, refreshAcl, orderBy
  
  Lists the results of all the integration executions. The response includes the same information as the [execution log](https://cloud.google.com/application-integration/docs/viewing-logs) in the Integration UI."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/executions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-products-integrations-executions-get$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Get an execution in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-products-integrations-executions-download$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Download the execution."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:download"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-products-integrations-executions-cancel$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancellation of an execution"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:cancel"
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

(defn locations-products-integrations-executions-suspensions-resolve$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:suspension {:lastModifyTime string,
                :name string,
                :createTime string,
                :integration string,
                :state string,
                :suspensionConfig EnterpriseCrmEventbusProtoSuspensionConfig,
                :audit GoogleCloudIntegrationsV1alphaSuspensionAudit,
                :approvalConfig GoogleCloudIntegrationsV1alphaSuspensionApprovalConfig,
                :eventExecutionInfoId string,
                :taskId string}}
  
  * Resolves (lifts/rejects) any number of suspensions. If the integration is already running, only the status of the suspension is updated. Otherwise, the suspended integration will begin execution again."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:resolve"
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

(defn locations-products-integrations-executions-suspensions-lift$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:suspensionResult string}
  
  * Lifts suspension for the Suspension task. Fetch corresponding suspension with provided suspension Id, resolve suspension, and set up suspension result for the Suspension Task."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+name}:lift"
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

(defn locations-products-integrations-executions-suspensions-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken, orderBy
  
  * Lists suspensions associated with a specific execution. Only those with permissions to resolve the relevant suspensions will be able to view them."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/suspensions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-products-authConfigs-patch$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: updateMask, clientCertificate.encryptedPrivateKey, clientCertificate.passphrase, clientCertificate.sslCertificate
  
  Body: 
  
  {:decryptedCredential {:oauth2ClientCredentials GoogleCloudIntegrationsV1alphaOAuth2ClientCredentials,
                         :authToken GoogleCloudIntegrationsV1alphaAuthToken,
                         :credentialType string,
                         :usernameAndPassword GoogleCloudIntegrationsV1alphaUsernameAndPassword,
                         :jwt GoogleCloudIntegrationsV1alphaJwt,
                         :serviceAccountCredentials GoogleCloudIntegrationsV1alphaServiceAccountCredentials,
                         :oauth2AuthorizationCode GoogleCloudIntegrationsV1alphaOAuth2AuthorizationCode,
                         :oauth2ResourceOwnerCredentials GoogleCloudIntegrationsV1alphaOAuth2ResourceOwnerCredentials,
                         :oidcToken GoogleCloudIntegrationsV1alphaOidcToken},
   :description string,
   :encryptedCredential string,
   :overrideValidTime string,
   :displayName string,
   :name string,
   :credentialType string,
   :expiryNotificationDuration [string],
   :createTime string,
   :state string,
   :lastModifierEmail string,
   :updateTime string,
   :reason string,
   :certificateId string,
   :creatorEmail string,
   :validTime string,
   :visibility string}
  
  Updates an auth config. If credential is updated, fetch the encrypted auth config from Spanner, decrypt with Cloud KMS key, update the credential fields, re-encrypt with Cloud KMS key and update the Spanner record. For other fields, directly update the Spanner record. Returns the encrypted auth config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-products-authConfigs-get$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a complete auth config. If the auth config doesn't exist, Code.NOT_FOUND exception will be thrown. Returns the decrypted auth config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-products-authConfigs-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: pageToken, readMask, pageSize, filter
  
  Lists all auth configs that match the filter. Restrict to auth configs belong to the current client only."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/authConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-products-authConfigs-create$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: clientCertificate.encryptedPrivateKey, clientCertificate.passphrase, clientCertificate.sslCertificate
  
  Body: 
  
  {:decryptedCredential {:oauth2ClientCredentials GoogleCloudIntegrationsV1alphaOAuth2ClientCredentials,
                         :authToken GoogleCloudIntegrationsV1alphaAuthToken,
                         :credentialType string,
                         :usernameAndPassword GoogleCloudIntegrationsV1alphaUsernameAndPassword,
                         :jwt GoogleCloudIntegrationsV1alphaJwt,
                         :serviceAccountCredentials GoogleCloudIntegrationsV1alphaServiceAccountCredentials,
                         :oauth2AuthorizationCode GoogleCloudIntegrationsV1alphaOAuth2AuthorizationCode,
                         :oauth2ResourceOwnerCredentials GoogleCloudIntegrationsV1alphaOAuth2ResourceOwnerCredentials,
                         :oidcToken GoogleCloudIntegrationsV1alphaOidcToken},
   :description string,
   :encryptedCredential string,
   :overrideValidTime string,
   :displayName string,
   :name string,
   :credentialType string,
   :expiryNotificationDuration [string],
   :createTime string,
   :state string,
   :lastModifierEmail string,
   :updateTime string,
   :reason string,
   :certificateId string,
   :creatorEmail string,
   :validTime string,
   :visibility string}
  
  Creates an auth config record. Fetch corresponding credentials for specific auth types, e.g. access token for OAuth 2.0, JWT token for JWT. Encrypt the auth config with Cloud KMS and store the encrypted credentials in Spanner. Returns the encrypted auth config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/authConfigs"
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

(defn locations-products-authConfigs-delete$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an auth config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-clients-switchVariableMasking$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:enableVariableMasking boolean}
  
  Update variable masking for provisioned client"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/clients:switchVariableMasking"
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

(defn locations-clients-deprovision$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Perform the deprovisioning steps to disable a user GCP project to use IP and purge all related data in a wipeout-compliant way."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/clients:deprovision"
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

(defn locations-clients-switch$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:cloudKmsConfig {:key string,
                    :kmsRing string,
                    :kmsLocation string,
                    :kmsProjectId string,
                    :keyVersion string}}
  
  Update client from GMEK to CMEK"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/clients:switch"
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

(defn locations-clients-provision$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:cloudKmsConfig {:key string,
                    :kmsRing string,
                    :kmsLocation string,
                    :kmsProjectId string,
                    :keyVersion string},
   :skipCpProvision boolean,
   :createSampleWorkflows boolean,
   :provisionGmek boolean,
   :runAsServiceAccount string}
  
  Perform the provisioning steps to enable a user GCP project to use IP. If GCP project already registered on IP end via Apigee Integration, provisioning will fail."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/clients:provision"
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

(defn locations-clients-replace$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:runAsServiceAccount string}
  
  Update run-as service account for provisioned client"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/clients:replace"
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

(defn locations-sfdcInstances-get$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an sfdc instance. If the instance doesn't exist, Code.NOT_FOUND exception will be thrown."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-sfdcInstances-patch$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :deleteTime string,
   :displayName string,
   :name string,
   :authConfigId [string],
   :createTime string,
   :serviceAuthority string,
   :updateTime string,
   :sfdcOrgId string}
  
  Updates an sfdc instance. Updates the sfdc instance in spanner. Returns the sfdc instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-sfdcInstances-delete$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an sfdc instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-sfdcInstances-create$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :deleteTime string,
   :displayName string,
   :name string,
   :authConfigId [string],
   :createTime string,
   :serviceAuthority string,
   :updateTime string,
   :sfdcOrgId string}
  
  Creates an sfdc instance record. Store the sfdc instance in Spanner. Returns the sfdc instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/sfdcInstances"
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

(defn locations-sfdcInstances-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: pageSize, readMask, pageToken, filter
  
  Lists all sfdc instances that match the filter. Restrict to sfdc instances belonging to the current client only."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/sfdcInstances"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-sfdcInstances-sfdcChannels-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, pageToken, readMask
  
  Lists all sfdc channels that match the filter. Restrict to sfdc channels belonging to the current client only."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/sfdcChannels"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-sfdcInstances-sfdcChannels-patch$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :lastReplayId string,
   :deleteTime string,
   :displayName string,
   :name string,
   :channelTopic string,
   :createTime string,
   :updateTime string,
   :isActive boolean}
  
  Updates an sfdc channel. Updates the sfdc channel in spanner. Returns the sfdc channel."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-sfdcInstances-sfdcChannels-get$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an sfdc channel. If the channel doesn't exist, Code.NOT_FOUND exception will be thrown."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-sfdcInstances-sfdcChannels-delete$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an sfdc channel."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-sfdcInstances-sfdcChannels-create$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :lastReplayId string,
   :deleteTime string,
   :displayName string,
   :name string,
   :channelTopic string,
   :createTime string,
   :updateTime string,
   :isActive boolean}
  
  Creates an sfdc channel record. Store the sfdc channel in Spanner. Returns the sfdc channel."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/sfdcChannels"
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

(defn locations-certificates-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, readMask
  
  List all the certificates that match the filter. Restrict to certificate of current client only."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/certificates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-certificates-get$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a certificates in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-certificates-delete$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a certificate"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-certificates-create$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :credentialId string,
   :displayName string,
   :requestorId string,
   :name string,
   :rawCertificate {:sslCertificate string,
                    :encryptedPrivateKey string,
                    :passphrase string},
   :validEndTime string,
   :validStartTime string,
   :certificateStatus string}
  
  Creates a new certificate. The certificate will be registered to the trawler service and will be encrypted using cloud KMS and stored in Spanner Returns the certificate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/certificates"
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

(defn locations-certificates-patch$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :credentialId string,
   :displayName string,
   :requestorId string,
   :name string,
   :rawCertificate {:sslCertificate string,
                    :encryptedPrivateKey string,
                    :passphrase string},
   :validEndTime string,
   :validStartTime string,
   :certificateStatus string}
  
  Updates the certificate by id. If new certificate file is updated, it will register with the trawler service, re-encrypt with cloud KMS and update the Spanner record. Other fields will directly update the Spanner record. Returns the Certificate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-authConfigs-patch$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: updateMask, clientCertificate.encryptedPrivateKey, clientCertificate.sslCertificate, clientCertificate.passphrase
  
  Body: 
  
  {:decryptedCredential {:oauth2ClientCredentials GoogleCloudIntegrationsV1alphaOAuth2ClientCredentials,
                         :authToken GoogleCloudIntegrationsV1alphaAuthToken,
                         :credentialType string,
                         :usernameAndPassword GoogleCloudIntegrationsV1alphaUsernameAndPassword,
                         :jwt GoogleCloudIntegrationsV1alphaJwt,
                         :serviceAccountCredentials GoogleCloudIntegrationsV1alphaServiceAccountCredentials,
                         :oauth2AuthorizationCode GoogleCloudIntegrationsV1alphaOAuth2AuthorizationCode,
                         :oauth2ResourceOwnerCredentials GoogleCloudIntegrationsV1alphaOAuth2ResourceOwnerCredentials,
                         :oidcToken GoogleCloudIntegrationsV1alphaOidcToken},
   :description string,
   :encryptedCredential string,
   :overrideValidTime string,
   :displayName string,
   :name string,
   :credentialType string,
   :expiryNotificationDuration [string],
   :createTime string,
   :state string,
   :lastModifierEmail string,
   :updateTime string,
   :reason string,
   :certificateId string,
   :creatorEmail string,
   :validTime string,
   :visibility string}
  
  Updates an auth config. If credential is updated, fetch the encrypted auth config from Spanner, decrypt with Cloud KMS key, update the credential fields, re-encrypt with Cloud KMS key and update the Spanner record. For other fields, directly update the Spanner record. Returns the encrypted auth config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-authConfigs-create$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: clientCertificate.sslCertificate, clientCertificate.passphrase, clientCertificate.encryptedPrivateKey
  
  Body: 
  
  {:decryptedCredential {:oauth2ClientCredentials GoogleCloudIntegrationsV1alphaOAuth2ClientCredentials,
                         :authToken GoogleCloudIntegrationsV1alphaAuthToken,
                         :credentialType string,
                         :usernameAndPassword GoogleCloudIntegrationsV1alphaUsernameAndPassword,
                         :jwt GoogleCloudIntegrationsV1alphaJwt,
                         :serviceAccountCredentials GoogleCloudIntegrationsV1alphaServiceAccountCredentials,
                         :oauth2AuthorizationCode GoogleCloudIntegrationsV1alphaOAuth2AuthorizationCode,
                         :oauth2ResourceOwnerCredentials GoogleCloudIntegrationsV1alphaOAuth2ResourceOwnerCredentials,
                         :oidcToken GoogleCloudIntegrationsV1alphaOidcToken},
   :description string,
   :encryptedCredential string,
   :overrideValidTime string,
   :displayName string,
   :name string,
   :credentialType string,
   :expiryNotificationDuration [string],
   :createTime string,
   :state string,
   :lastModifierEmail string,
   :updateTime string,
   :reason string,
   :certificateId string,
   :creatorEmail string,
   :validTime string,
   :visibility string}
  
  Creates an auth config record. Fetch corresponding credentials for specific auth types, e.g. access token for OAuth 2.0, JWT token for JWT. Encrypt the auth config with Cloud KMS and store the encrypted credentials in Spanner. Returns the encrypted auth config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/authConfigs"
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

(defn locations-authConfigs-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: pageSize, readMask, filter, pageToken
  
  Lists all auth configs that match the filter. Restrict to auth configs belong to the current client only."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/authConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-authConfigs-delete$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an auth config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-authConfigs-get$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a complete auth config. If the auth config doesn't exist, Code.NOT_FOUND exception will be thrown. Returns the decrypted auth config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-appsScriptProjects-link$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:scriptId string}
  
  Links a existing Apps Script project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/appsScriptProjects:link"
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

(defn locations-appsScriptProjects-create$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:appsScriptProject string, :authConfigId string}
  
  Creates an Apps Script project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/appsScriptProjects"
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

(defn locations-connections-getConnectionSchemaMetadata$
  "https://cloud.google.com/application-integration
  
  Required parameters: name
  
  Optional parameters: none
  
  Lists the available entities and actions associated with a Connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
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

(defn locations-connections-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: orderBy, pageSize, filter, pageToken
  
  Lists Connections in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/connections"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-runtimeEntitySchemas-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists the JSON schemas for the properties of runtime entities, filtered by entity name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/runtimeEntitySchemas"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-runtimeActionSchemas-list$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists the JSON schemas for the inputs and outputs of actions, filtered by action name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/runtimeActionSchemas"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-cloudFunctions-create$
  "https://cloud.google.com/application-integration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:functionName string, :functionRegion string, :projectId string}
  
  Creates a cloud function project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/{+parent}/cloudFunctions"
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
