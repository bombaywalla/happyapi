(ns happygapi.containeranalysis.projects
  "Container Analysis API: projects.
  This API is a prerequisite for leveraging Artifact Analysis scanning capabilities in both Artifact Registry and with Advanced Vulnerability Insights (runtime scanning) in GKE. In addition, the Container Analysis API is an implementation of the Grafeas API, which enables storing, querying, and retrieval of critical metadata about all of your software artifacts.
  See: https://cloud.google.com/container-analysis/api/reference/rest/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-occurrences-getVulnerabilitySummary$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/locations/occurrences/getVulnerabilitySummary
  
  Required parameters: parent
  
  Optional parameters: filter
  
  Gets a summary of the number and severity of occurrences."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1/{+parent}/occurrences:vulnerabilitySummary"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-occurrences-get$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/locations/occurrences/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified occurrence."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
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

(defn locations-occurrences-getNotes$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/locations/occurrences/getNotes
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the note attached to the specified occurrence. Consumer projects can use this method to get a note that belongs to a provider project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1/{+name}/notes"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-occurrences-list$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/locations/occurrences/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists occurrences for the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1/{+parent}/occurrences"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-resources-exportSBOM$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/locations/resources/exportSBOM
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:cloudStorageLocation {}}
  
  Generates an SBOM for the given resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1/{+name}:exportSBOM"
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

(defn locations-notes-get$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/locations/notes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified note."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
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

(defn locations-notes-list$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/locations/notes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists notes for the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1/{+parent}/notes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-notes-occurrences-list$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/locations/notes/occurrences/list
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists occurrences referencing the specified note. Provider projects can use this method to get all occurrences across consumer projects referencing the specified note."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1/{+name}/occurrences"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn notes-get$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/notes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified note."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
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

(defn notes-setIamPolicy$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/notes/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :etag string, :bindings [Binding]}}
  
  Sets the access control policy on the specified note or occurrence. Requires `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy` permission if the resource is a note or an occurrence, respectively. The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
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

(defn notes-patch$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/notes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:relatedUrl [{:url string, :label string}],
   :package {:maintainer string,
             :description string,
             :architecture string,
             :license License,
             :name string,
             :packageType string,
             :digest [Digest],
             :cpeUri string,
             :url string,
             :distribution [Distribution],
             :version Version},
   :vulnerabilityAssessment {:assessment Assessment,
                             :title string,
                             :product Product,
                             :shortDescription string,
                             :languageCode string,
                             :longDescription string,
                             :publisher Publisher},
   :discovery {:analysisKind string},
   :relatedNoteNames [string],
   :sbomReference {:version string, :format string},
   :expirationTime string,
   :name string,
   :createTime string,
   :vulnerability {:cvssVersion string,
                   :severity string,
                   :windowsDetails [WindowsDetail],
                   :cvssV2 CVSS,
                   :details [Detail],
                   :cvssV3 CVSSv3,
                   :sourceUpdateTime string,
                   :cvssScore number},
   :updateTime string,
   :shortDescription string,
   :upgrade {:windowsUpdate WindowsUpdate,
             :distributions [UpgradeDistribution],
             :package string,
             :version Version},
   :dsseAttestation {:hint DSSEHint},
   :build {:builderVersion string},
   :attestation {:hint Hint},
   :kind string,
   :deployment {:resourceUri [string]},
   :image {:fingerprint Fingerprint, :resourceUrl string},
   :longDescription string,
   :compliance {:description string,
                :remediation string,
                :scanInstructions string,
                :impact string,
                :version [ComplianceVersion],
                :cisBenchmark CisBenchmark,
                :rationale string,
                :title string}}
  
  Updates the specified note."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://containeranalysis.googleapis.com/"
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

(defn notes-testIamPermissions$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/notes/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns the permissions that a caller has on the specified note or occurrence. Requires list permission on the project (for example, `containeranalysis.notes.list`). The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
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

(defn notes-create$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/notes/create
  
  Required parameters: parent
  
  Optional parameters: noteId
  
  Body: 
  
  {:relatedUrl [{:url string, :label string}],
   :package {:maintainer string,
             :description string,
             :architecture string,
             :license License,
             :name string,
             :packageType string,
             :digest [Digest],
             :cpeUri string,
             :url string,
             :distribution [Distribution],
             :version Version},
   :vulnerabilityAssessment {:assessment Assessment,
                             :title string,
                             :product Product,
                             :shortDescription string,
                             :languageCode string,
                             :longDescription string,
                             :publisher Publisher},
   :discovery {:analysisKind string},
   :relatedNoteNames [string],
   :sbomReference {:version string, :format string},
   :expirationTime string,
   :name string,
   :createTime string,
   :vulnerability {:cvssVersion string,
                   :severity string,
                   :windowsDetails [WindowsDetail],
                   :cvssV2 CVSS,
                   :details [Detail],
                   :cvssV3 CVSSv3,
                   :sourceUpdateTime string,
                   :cvssScore number},
   :updateTime string,
   :shortDescription string,
   :upgrade {:windowsUpdate WindowsUpdate,
             :distributions [UpgradeDistribution],
             :package string,
             :version Version},
   :dsseAttestation {:hint DSSEHint},
   :build {:builderVersion string},
   :attestation {:hint Hint},
   :kind string,
   :deployment {:resourceUri [string]},
   :image {:fingerprint Fingerprint, :resourceUrl string},
   :longDescription string,
   :compliance {:description string,
                :remediation string,
                :scanInstructions string,
                :impact string,
                :version [ComplianceVersion],
                :cisBenchmark CisBenchmark,
                :rationale string,
                :title string}}
  
  Creates a new note."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1/{+parent}/notes"
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

(defn notes-batchCreate$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/notes/batchCreate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:notes {}}
  
  Creates new notes in batch."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1/{+parent}/notes:batchCreate"
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

(defn notes-delete$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/notes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified note."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://containeranalysis.googleapis.com/"
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

(defn notes-getIamPolicy$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/notes/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a note or an occurrence resource. Requires `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy` permission if the resource is a note or occurrence, respectively. The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn notes-list$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/notes/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists notes for the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1/{+parent}/notes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn notes-occurrences-list$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/notes/occurrences/list
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists occurrences referencing the specified note. Provider projects can use this method to get all occurrences across consumer projects referencing the specified note."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1/{+name}/occurrences"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn occurrences-get$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/occurrences/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified occurrence."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
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

(defn occurrences-setIamPolicy$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/occurrences/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :etag string, :bindings [Binding]}}
  
  Sets the access control policy on the specified note or occurrence. Requires `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy` permission if the resource is a note or an occurrence, respectively. The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
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

(defn occurrences-patch$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/occurrences/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:noteName string,
   :remediation string,
   :package {:name string,
             :architecture string,
             :version Version,
             :packageType string,
             :license License,
             :cpeUri string,
             :location [Location]},
   :envelope {:payload string,
              :signatures [EnvelopeSignature],
              :payloadType string},
   :resourceUri string,
   :discovery {:archiveTime string,
               :analysisCompleted AnalysisCompleted,
               :lastScanTime string,
               :analysisStatus string,
               :continuousAnalysis string,
               :sbomStatus SBOMStatus,
               :analysisStatusError Status,
               :analysisError [Status],
               :cpe string},
   :sbomReference {:payload SbomReferenceIntotoPayload,
                   :signatures [EnvelopeSignature],
                   :payloadType string},
   :name string,
   :createTime string,
   :vulnerability {:cvssv3 CVSS,
                   :relatedUrls [RelatedUrl],
                   :type string,
                   :cvssVersion string,
                   :shortDescription string,
                   :extraDetails string,
                   :cvssScore number,
                   :severity string,
                   :fixAvailable boolean,
                   :vexAssessment VexAssessment,
                   :longDescription string,
                   :cvssV2 CVSS,
                   :effectiveSeverity string,
                   :packageIssue [PackageIssue]},
   :updateTime string,
   :upgrade {:package string,
             :distribution UpgradeDistribution,
             :parsedVersion Version,
             :windowsUpdate WindowsUpdate},
   :dsseAttestation {:statement InTotoStatement, :envelope Envelope},
   :build {:intotoProvenance InTotoProvenance,
           :provenanceBytes string,
           :provenance BuildProvenance,
           :intotoStatement InTotoStatement,
           :inTotoSlsaProvenanceV1 InTotoSlsaProvenanceV1},
   :attestation {:serializedPayload string,
                 :signatures [Signature],
                 :jwts [Jwt]},
   :kind string,
   :deployment {:platform string,
                :deployTime string,
                :resourceUri [string],
                :config string,
                :address string,
                :userEmail string,
                :undeployTime string},
   :image {:layerInfo [Layer],
           :distance integer,
           :baseResourceUrl string,
           :fingerprint Fingerprint},
   :compliance {:version ComplianceVersion,
                :nonCompliantFiles [NonCompliantFile],
                :nonComplianceReason string}}
  
  Updates the specified occurrence."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://containeranalysis.googleapis.com/"
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

(defn occurrences-testIamPermissions$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/occurrences/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns the permissions that a caller has on the specified note or occurrence. Requires list permission on the project (for example, `containeranalysis.notes.list`). The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
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

(defn occurrences-create$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/occurrences/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:noteName string,
   :remediation string,
   :package {:name string,
             :architecture string,
             :version Version,
             :packageType string,
             :license License,
             :cpeUri string,
             :location [Location]},
   :envelope {:payload string,
              :signatures [EnvelopeSignature],
              :payloadType string},
   :resourceUri string,
   :discovery {:archiveTime string,
               :analysisCompleted AnalysisCompleted,
               :lastScanTime string,
               :analysisStatus string,
               :continuousAnalysis string,
               :sbomStatus SBOMStatus,
               :analysisStatusError Status,
               :analysisError [Status],
               :cpe string},
   :sbomReference {:payload SbomReferenceIntotoPayload,
                   :signatures [EnvelopeSignature],
                   :payloadType string},
   :name string,
   :createTime string,
   :vulnerability {:cvssv3 CVSS,
                   :relatedUrls [RelatedUrl],
                   :type string,
                   :cvssVersion string,
                   :shortDescription string,
                   :extraDetails string,
                   :cvssScore number,
                   :severity string,
                   :fixAvailable boolean,
                   :vexAssessment VexAssessment,
                   :longDescription string,
                   :cvssV2 CVSS,
                   :effectiveSeverity string,
                   :packageIssue [PackageIssue]},
   :updateTime string,
   :upgrade {:package string,
             :distribution UpgradeDistribution,
             :parsedVersion Version,
             :windowsUpdate WindowsUpdate},
   :dsseAttestation {:statement InTotoStatement, :envelope Envelope},
   :build {:intotoProvenance InTotoProvenance,
           :provenanceBytes string,
           :provenance BuildProvenance,
           :intotoStatement InTotoStatement,
           :inTotoSlsaProvenanceV1 InTotoSlsaProvenanceV1},
   :attestation {:serializedPayload string,
                 :signatures [Signature],
                 :jwts [Jwt]},
   :kind string,
   :deployment {:platform string,
                :deployTime string,
                :resourceUri [string],
                :config string,
                :address string,
                :userEmail string,
                :undeployTime string},
   :image {:layerInfo [Layer],
           :distance integer,
           :baseResourceUrl string,
           :fingerprint Fingerprint},
   :compliance {:version ComplianceVersion,
                :nonCompliantFiles [NonCompliantFile],
                :nonComplianceReason string}}
  
  Creates a new occurrence."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1/{+parent}/occurrences"
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

(defn occurrences-batchCreate$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/occurrences/batchCreate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:occurrences [{:noteName string,
                  :remediation string,
                  :package PackageOccurrence,
                  :envelope Envelope,
                  :resourceUri string,
                  :discovery DiscoveryOccurrence,
                  :sbomReference SBOMReferenceOccurrence,
                  :name string,
                  :createTime string,
                  :vulnerability VulnerabilityOccurrence,
                  :updateTime string,
                  :upgrade UpgradeOccurrence,
                  :dsseAttestation DSSEAttestationOccurrence,
                  :build BuildOccurrence,
                  :attestation AttestationOccurrence,
                  :kind string,
                  :deployment DeploymentOccurrence,
                  :image ImageOccurrence,
                  :compliance ComplianceOccurrence}]}
  
  Creates new occurrences in batch."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1/{+parent}/occurrences:batchCreate"
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

(defn occurrences-delete$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/occurrences/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified occurrence. For example, use this method to delete an occurrence when the occurrence is no longer applicable for the given resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://containeranalysis.googleapis.com/"
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

(defn occurrences-getVulnerabilitySummary$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/occurrences/getVulnerabilitySummary
  
  Required parameters: parent
  
  Optional parameters: filter
  
  Gets a summary of the number and severity of occurrences."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1/{+parent}/occurrences:vulnerabilitySummary"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn occurrences-getIamPolicy$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/occurrences/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a note or an occurrence resource. Requires `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy` permission if the resource is a note or occurrence, respectively. The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn occurrences-list$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/occurrences/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists occurrences for the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1/{+parent}/occurrences"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn occurrences-getNotes$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/occurrences/getNotes
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the note attached to the specified occurrence. Consumer projects can use this method to get a note that belongs to a provider project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1/{+name}/notes"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resources-exportSBOM$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1/projects/resources/exportSBOM
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:cloudStorageLocation {}}
  
  Generates an SBOM for the given resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1/{+name}:exportSBOM"
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
