(ns happygapi.toolresults.projects
  "Cloud Tool Results API: projects.
  Reads and publishes results from Firebase Test Lab.
  See: https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getSettings$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/getSettings
  
  Required parameters: projectId
  
  Optional parameters: none
  Gets the Tool Results settings for a project.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to read from project"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/settings"
     #{:projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn initializeSettings$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/initializeSettings
  
  Required parameters: projectId
  
  Optional parameters: none
  Creates resources for settings which have not yet been set.
  
  Currently, this creates a single resource: a Google Cloud Storage bucket, to be used as the default bucket for this project. The bucket is created in an FTL-own storage project. Except for in rare cases, calling this method in parallel from multiple clients will only create a single bucket. In order to avoid unnecessary storage charges, the bucket is configured to automatically delete objects older than 90 days.
  
  The bucket is created with the following permissions: - Owner access for owners of central storage project (FTL-owned) - Writer access for owners/editors of customer project - Reader access for viewers of customer project The default ACL on objects created in the bucket is: - Owner access for owners of central storage project - Reader access for owners/editors/viewers of customer project See Google Cloud Storage documentation for more details.
  
  If there is already a default bucket set and the project can access the bucket, this call does nothing. However, if the project doesn't have the permission to access the bucket or the bucket is deleted, a new bucket will be created.
  
  May return any canonical error codes, including the following:
  
  - PERMISSION_DENIED - if the user is not authorized to write to project - Any error code raised by Google Cloud Storage"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}:initializeSettings"
     #{:projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-create$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/create
  
  Required parameters: projectId
  
  Optional parameters: requestId
  
  Body: 
  
  {:displayName string, :historyId string, :name string}
  
  Creates a History.
  
  The returned History will have the id set.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to write to project - INVALID_ARGUMENT - if the request is malformed - NOT_FOUND - if the containing project does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories"
     #{:projectId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-get$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/get
  
  Required parameters: historyId, projectId
  
  Optional parameters: none
  Gets a History.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to read project - INVALID_ARGUMENT - if the request is malformed - NOT_FOUND - if the History does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:historyId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}"
     #{:historyId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-list$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/list
  
  Required parameters: projectId
  
  Optional parameters: filterByName, pageSize, pageToken
  Lists Histories for a given Project.
  
  The histories are sorted by modification time in descending order. The history_id key will be used to order the history with the same modification time.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to read project - INVALID_ARGUMENT - if the request is malformed - NOT_FOUND - if the History does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories"
     #{:projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-create$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/create
  
  Required parameters: historyId, projectId
  
  Optional parameters: requestId
  
  Body: 
  
  {:completionTime {:nanos integer, :seconds string},
   :creationTime {:nanos integer, :seconds string},
   :executionId string,
   :outcome {:failureDetail FailureDetail,
             :inconclusiveDetail InconclusiveDetail,
             :skippedDetail SkippedDetail,
             :successDetail SuccessDetail,
             :summary string},
   :specification {:androidTest AndroidTest},
   :state string,
   :testExecutionMatrixId string}
  
  Creates an Execution.
  
  The returned Execution will have the id set.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to write to project - INVALID_ARGUMENT - if the request is malformed - NOT_FOUND - if the containing History does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:historyId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions"
     #{:historyId :projectId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-get$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/get
  
  Required parameters: executionId, historyId, projectId
  
  Optional parameters: none
  Gets an Execution.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to write to project - INVALID_ARGUMENT - if the request is malformed - NOT_FOUND - if the Execution does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:executionId :historyId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}"
     #{:executionId :historyId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-list$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/list
  
  Required parameters: historyId, projectId
  
  Optional parameters: pageSize, pageToken
  Lists Executions for a given History.
  
  The executions are sorted by creation_time in descending order. The execution_id key will be used to order the executions with the same creation_time.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to read project - INVALID_ARGUMENT - if the request is malformed - NOT_FOUND - if the containing History does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:historyId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions"
     #{:historyId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-patch$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/patch
  
  Required parameters: executionId, historyId, projectId
  
  Optional parameters: requestId
  
  Body: 
  
  {:completionTime {:nanos integer, :seconds string},
   :creationTime {:nanos integer, :seconds string},
   :executionId string,
   :outcome {:failureDetail FailureDetail,
             :inconclusiveDetail InconclusiveDetail,
             :skippedDetail SkippedDetail,
             :successDetail SuccessDetail,
             :summary string},
   :specification {:androidTest AndroidTest},
   :state string,
   :testExecutionMatrixId string}
  
  Updates an existing Execution with the supplied partial entity.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to write to project - INVALID_ARGUMENT - if the request is malformed - FAILED_PRECONDITION - if the requested state transition is illegal - NOT_FOUND - if the containing History does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:executionId :historyId :projectId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}"
     #{:executionId :historyId :projectId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-clusters-get$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/clusters/get
  
  Required parameters: clusterId, executionId, historyId, projectId
  
  Optional parameters: none
  Retrieves a single screenshot cluster by its ID"
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:executionId :historyId :clusterId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/clusters/{clusterId}"
     #{:executionId :historyId :clusterId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-clusters-list$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/clusters/list
  
  Required parameters: executionId, historyId, projectId
  
  Optional parameters: none
  Lists Screenshot Clusters
  
  Returns the list of screenshot clusters corresponding to an execution. Screenshot clusters are created after the execution is finished. Clusters are created from a set of screenshots. Between any two screenshots, a matching score is calculated based off their metadata that determines how similar they are. Screenshots are placed in the cluster that has screens which have the highest matching scores."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{:executionId :historyId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/clusters"
     #{:executionId :historyId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-environments-get$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/environments/get
  
  Required parameters: environmentId, executionId, historyId, projectId
  
  Optional parameters: none
  Gets an Environment.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to read project - INVALID_ARGUMENT - if the request is malformed - NOT_FOUND - if the Environment does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:executionId :historyId :environmentId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/environments/{environmentId}"
     #{:executionId :historyId :environmentId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-environments-list$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/environments/list
  
  Required parameters: executionId, historyId, projectId
  
  Optional parameters: pageSize, pageToken
  Lists Environments for a given Execution.
  
  The Environments are sorted by display name.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to read project - INVALID_ARGUMENT - if the request is malformed - NOT_FOUND - if the containing Execution does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:executionId :historyId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/environments"
     #{:executionId :historyId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-steps-create$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/steps/create
  
  Required parameters: executionId, historyId, projectId
  
  Optional parameters: requestId
  
  Body: 
  
  {:creationTime {:nanos integer, :seconds string},
   :description string,
   :runDuration {:nanos integer, :seconds string},
   :labels [{:key string, :value string}],
   :multiStep {:multistepNumber integer,
               :primaryStep PrimaryStep,
               :primaryStepId string},
   :name string,
   :outcome {:failureDetail FailureDetail,
             :inconclusiveDetail InconclusiveDetail,
             :skippedDetail SkippedDetail,
             :successDetail SuccessDetail,
             :summary string},
   :state string,
   :deviceUsageDuration {:nanos integer, :seconds string},
   :completionTime {:nanos integer, :seconds string},
   :stepId string,
   :hasImages boolean,
   :dimensionValue [{:key string, :value string}],
   :toolExecutionStep {:toolExecution ToolExecution},
   :testExecutionStep {:testIssues [TestIssue],
                       :testSuiteOverviews [TestSuiteOverview],
                       :testTiming TestTiming,
                       :toolExecution ToolExecution}}
  
  Creates a Step.
  
  The returned Step will have the id set.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to write to project - INVALID_ARGUMENT - if the request is malformed - FAILED_PRECONDITION - if the step is too large (more than 10Mib) - NOT_FOUND - if the containing Execution does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:executionId :historyId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/steps"
     #{:executionId :historyId :projectId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-steps-get$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/steps/get
  
  Required parameters: executionId, historyId, projectId, stepId
  
  Optional parameters: none
  Gets a Step.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to read project - INVALID_ARGUMENT - if the request is malformed - NOT_FOUND - if the Step does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:executionId :historyId :stepId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/steps/{stepId}"
     #{:executionId :historyId :stepId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-steps-getPerfMetricsSummary$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/steps/getPerfMetricsSummary
  
  Required parameters: executionId, historyId, projectId, stepId
  
  Optional parameters: none
  Retrieves a PerfMetricsSummary.
  
  May return any of the following error code(s): - NOT_FOUND - The specified PerfMetricsSummary does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:executionId :historyId :stepId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/steps/{stepId}/perfMetricsSummary"
     #{:executionId :historyId :stepId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-steps-list$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/steps/list
  
  Required parameters: executionId, historyId, projectId
  
  Optional parameters: pageSize, pageToken
  Lists Steps for a given Execution.
  
  The steps are sorted by creation_time in descending order. The step_id key will be used to order the steps with the same creation_time.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to read project - INVALID_ARGUMENT - if the request is malformed - FAILED_PRECONDITION - if an argument in the request happens to be invalid; e.g. if an attempt is made to list the children of a nonexistent Step - NOT_FOUND - if the containing Execution does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:executionId :historyId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/steps"
     #{:executionId :historyId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-steps-patch$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/steps/patch
  
  Required parameters: executionId, historyId, projectId, stepId
  
  Optional parameters: requestId
  
  Body: 
  
  {:creationTime {:nanos integer, :seconds string},
   :description string,
   :runDuration {:nanos integer, :seconds string},
   :labels [{:key string, :value string}],
   :multiStep {:multistepNumber integer,
               :primaryStep PrimaryStep,
               :primaryStepId string},
   :name string,
   :outcome {:failureDetail FailureDetail,
             :inconclusiveDetail InconclusiveDetail,
             :skippedDetail SkippedDetail,
             :successDetail SuccessDetail,
             :summary string},
   :state string,
   :deviceUsageDuration {:nanos integer, :seconds string},
   :completionTime {:nanos integer, :seconds string},
   :stepId string,
   :hasImages boolean,
   :dimensionValue [{:key string, :value string}],
   :toolExecutionStep {:toolExecution ToolExecution},
   :testExecutionStep {:testIssues [TestIssue],
                       :testSuiteOverviews [TestSuiteOverview],
                       :testTiming TestTiming,
                       :toolExecution ToolExecution}}
  
  Updates an existing Step with the supplied partial entity.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to write project - INVALID_ARGUMENT - if the request is malformed - FAILED_PRECONDITION - if the requested state transition is illegal (e.g try to upload a duplicate xml file), if the updated step is too large (more than 10Mib) - NOT_FOUND - if the containing Execution does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{:executionId :historyId :stepId :projectId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/steps/{stepId}"
     #{:executionId :historyId :stepId :projectId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-steps-publishXunitXmlFiles$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/steps/publishXunitXmlFiles
  
  Required parameters: executionId, historyId, projectId, stepId
  
  Optional parameters: none
  
  Body: 
  
  {:xunitXmlFiles [{:fileUri string}]}
  
  Publish xml files to an existing Step.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to write project - INVALID_ARGUMENT - if the request is malformed - FAILED_PRECONDITION - if the requested state transition is illegal, e.g try to upload a duplicate xml file or a file too large. - NOT_FOUND - if the containing Execution does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{:executionId :historyId :stepId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/steps/{stepId}:publishXunitXmlFiles"
     #{:executionId :historyId :stepId :projectId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-steps-perfMetricsSummary-create$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/steps/perfMetricsSummary/create
  
  Required parameters: executionId, historyId, projectId, stepId
  
  Optional parameters: none
  
  Body: 
  
  {:appStartTime {:fullyDrawnTime Duration,
                  :initialDisplayTime Duration},
   :executionId string,
   :graphicsStats {:totalFrames string,
                   :highInputLatencyCount string,
                   :p50Millis string,
                   :slowUiThreadCount string,
                   :slowDrawCount string,
                   :jankyFrames string,
                   :missedVsyncCount string,
                   :p90Millis string,
                   :buckets [GraphicsStatsBucket],
                   :p99Millis string,
                   :slowBitmapUploadCount string,
                   :p95Millis string},
   :historyId string,
   :perfEnvironment {:cpuInfo CPUInfo, :memoryInfo MemoryInfo},
   :perfMetrics [string],
   :projectId string,
   :stepId string}
  
  Creates a PerfMetricsSummary resource. Returns the existing one if it has already been created.
  
  May return any of the following error code(s): - NOT_FOUND - The containing Step does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{:executionId :historyId :stepId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/steps/{stepId}/perfMetricsSummary"
     #{:executionId :historyId :stepId :projectId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-steps-perfSampleSeries-create$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/steps/perfSampleSeries/create
  
  Required parameters: executionId, historyId, projectId, stepId
  
  Optional parameters: none
  
  Body: 
  
  {:basicPerfSampleSeries {:perfMetricType string,
                           :perfUnit string,
                           :sampleSeriesLabel string},
   :executionId string,
   :historyId string,
   :projectId string,
   :sampleSeriesId string,
   :stepId string}
  
  Creates a PerfSampleSeries.
  
  May return any of the following error code(s): - ALREADY_EXISTS - PerfMetricSummary already exists for the given Step - NOT_FOUND - The containing Step does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{:executionId :historyId :stepId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/steps/{stepId}/perfSampleSeries"
     #{:executionId :historyId :stepId :projectId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-steps-perfSampleSeries-get$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/steps/perfSampleSeries/get
  
  Required parameters: executionId, historyId, projectId, sampleSeriesId, stepId
  
  Optional parameters: none
  Gets a PerfSampleSeries.
  
  May return any of the following error code(s): - NOT_FOUND - The specified PerfSampleSeries does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:executionId
            :historyId
            :sampleSeriesId
            :stepId
            :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/steps/{stepId}/perfSampleSeries/{sampleSeriesId}"
     #{:executionId :historyId :sampleSeriesId :stepId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-steps-perfSampleSeries-list$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/steps/perfSampleSeries/list
  
  Required parameters: executionId, historyId, projectId, stepId
  
  Optional parameters: filter
  Lists PerfSampleSeries for a given Step.
  
  The request provides an optional filter which specifies one or more PerfMetricsType to include in the result; if none returns all. The resulting PerfSampleSeries are sorted by ids.
  
  May return any of the following canonical error codes: - NOT_FOUND - The containing Step does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:executionId :historyId :stepId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/steps/{stepId}/perfSampleSeries"
     #{:executionId :historyId :stepId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-steps-perfSampleSeries-samples-batchCreate$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/steps/perfSampleSeries/samples/batchCreate
  
  Required parameters: executionId, historyId, projectId, sampleSeriesId, stepId
  
  Optional parameters: none
  
  Body: 
  
  {:perfSamples [{:sampleTime Timestamp, :value number}]}
  
  Creates a batch of PerfSamples - a client can submit multiple batches of Perf Samples through repeated calls to this method in order to split up a large request payload - duplicates and existing timestamp entries will be ignored. - the batch operation may partially succeed - the set of elements successfully inserted is returned in the response (omits items which already existed in the database).
  
  May return any of the following canonical error codes: - NOT_FOUND - The containing PerfSampleSeries does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{:executionId
            :historyId
            :sampleSeriesId
            :stepId
            :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/steps/{stepId}/perfSampleSeries/{sampleSeriesId}/samples:batchCreate"
     #{:executionId :historyId :sampleSeriesId :stepId :projectId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-steps-perfSampleSeries-samples-list$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/steps/perfSampleSeries/samples/list
  
  Required parameters: executionId, historyId, projectId, sampleSeriesId, stepId
  
  Optional parameters: pageSize, pageToken
  Lists the Performance Samples of a given Sample Series - The list results are sorted by timestamps ascending - The default page size is 500 samples; and maximum size allowed 5000 - The response token indicates the last returned PerfSample timestamp - When the results size exceeds the page size, submit a subsequent request including the page token to return the rest of the samples up to the page limit
  
  May return any of the following canonical error codes: - OUT_OF_RANGE - The specified request page_token is out of valid range - NOT_FOUND - The containing PerfSampleSeries does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:executionId
            :historyId
            :sampleSeriesId
            :stepId
            :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/steps/{stepId}/perfSampleSeries/{sampleSeriesId}/samples"
     #{:executionId :historyId :sampleSeriesId :stepId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-steps-testCases-get$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/steps/testCases/get
  
  Required parameters: executionId, historyId, projectId, stepId, testCaseId
  
  Optional parameters: none
  Gets details of a Test Case for a Step. Experimental test cases API. Still in active development.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to write to project - INVALID_ARGUMENT - if the request is malformed - NOT_FOUND - if the containing Test Case does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:executionId :historyId :testCaseId :stepId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/steps/{stepId}/testCases/{testCaseId}"
     #{:executionId :historyId :testCaseId :stepId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-steps-testCases-list$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/steps/testCases/list
  
  Required parameters: executionId, historyId, projectId, stepId
  
  Optional parameters: pageSize, pageToken
  Lists Test Cases attached to a Step. Experimental test cases API. Still in active development.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to write to project - INVALID_ARGUMENT - if the request is malformed - NOT_FOUND - if the containing Step does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:executionId :historyId :stepId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/steps/{stepId}/testCases"
     #{:executionId :historyId :stepId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn histories-executions-steps-thumbnails-list$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1beta3/projects/histories/executions/steps/thumbnails/list
  
  Required parameters: executionId, historyId, projectId, stepId
  
  Optional parameters: pageSize, pageToken
  Lists thumbnails of images attached to a step.
  
  May return any of the following canonical error codes: - PERMISSION_DENIED - if the user is not authorized to read from the project, or from any of the images - INVALID_ARGUMENT - if the request is malformed - NOT_FOUND - if the step does not exist, or if any of the images do not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:executionId :historyId :stepId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/toolresults/v1beta3/projects/"
     "{projectId}/histories/{historyId}/executions/{executionId}/steps/{stepId}/thumbnails"
     #{:executionId :historyId :stepId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))