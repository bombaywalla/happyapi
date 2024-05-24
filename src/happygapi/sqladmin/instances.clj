(ns happygapi.sqladmin.instances
  "Cloud SQL Admin API: instances.
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/docs/reference/rest/v1/instances"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn failover$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/failover
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:failoverContext {:settingsVersion string, :kind string}}
  
  Initiates a manual failover of a high availability (HA) primary instance to a standby instance, which becomes the primary instance. Users are then rerouted to the new primary. For more information, see the [Overview of high availability](https://cloud.google.com/sql/docs/mysql/high-availability) page in the Cloud SQL documentation. If using Legacy HA (MySQL only), this causes the instance to failover to its failover replica instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/failover"
     #{:instance :project}
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

(defn get$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/get
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Retrieves a resource containing information about a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/insert
  
  Required parameters: project
  
  Optional parameters: none
  
  Body: 
  
  {:onPremisesConfiguration {:sourceInstance InstanceReference,
                             :clientCertificate string,
                             :password string,
                             :clientKey string,
                             :caCertificate string,
                             :username string,
                             :kind string,
                             :dumpFilePath string,
                             :hostPort string},
   :diskEncryptionConfiguration {:kmsKeyName string, :kind string},
   :databaseVersion string,
   :maxDiskSize string,
   :replicationCluster {:psaWriteEndpoint string,
                        :failoverDrReplicaName string,
                        :drReplica boolean},
   :instanceType string,
   :rootPassword string,
   :currentDiskSize string,
   :gceZone string,
   :name string,
   :masterInstanceName string,
   :createTime string,
   :settings {:dataCacheConfig DataCacheConfig,
              :activeDirectoryConfig SqlActiveDirectoryConfig,
              :availabilityType string,
              :timeZone string,
              :tier string,
              :databaseFlags [DatabaseFlags],
              :databaseReplicationEnabled boolean,
              :sqlServerAuditConfig SqlServerAuditConfig,
              :settingsVersion string,
              :storageAutoResizeLimit string,
              :crashSafeReplicationEnabled boolean,
              :activationPolicy string,
              :deletionProtectionEnabled boolean,
              :collation string,
              :storageAutoResize boolean,
              :pricingPlan string,
              :locationPreference LocationPreference,
              :insightsConfig InsightsConfig,
              :advancedMachineFeatures AdvancedMachineFeatures,
              :ipConfiguration IpConfiguration,
              :passwordValidationPolicy PasswordValidationPolicy,
              :enableGoogleMlIntegration boolean,
              :kind string,
              :maintenanceWindow MaintenanceWindow,
              :edition string,
              :backupConfiguration BackupConfiguration,
              :denyMaintenancePeriods [DenyMaintenancePeriod],
              :dataDiskSizeGb string,
              :replicationType string,
              :userLabels {},
              :dataDiskType string,
              :connectorEnforcement string,
              :authorizedGaeApplications [string]},
   :selfLink string,
   :primaryDnsName string,
   :etag string,
   :ipAddresses [{:type string, :ipAddress string, :timeToRetire string}],
   :state string,
   :ipv6Address string,
   :availableMaintenanceVersions [string],
   :region string,
   :diskEncryptionStatus {:kmsKeyVersionName string, :kind string},
   :replicaNames [string],
   :sqlNetworkArchitecture string,
   :pscServiceAttachmentLink string,
   :geminiConfig {:entitled boolean,
                  :googleVacuumMgmtEnabled boolean,
                  :oomSessionCancelEnabled boolean,
                  :activeQueryEnabled boolean,
                  :indexAdvisorEnabled boolean,
                  :flagRecommenderEnabled boolean},
   :failoverReplica {:name string, :available boolean},
   :satisfiesPzs boolean,
   :dnsName string,
   :project string,
   :kind string,
   :backendType string,
   :maintenanceVersion string,
   :serviceAccountEmailAddress string,
   :scheduledMaintenance {:startTime string,
                          :canDefer boolean,
                          :canReschedule boolean,
                          :scheduleDeadlineTime string},
   :replicaConfiguration {:kind string,
                          :mysqlReplicaConfiguration MySqlReplicaConfiguration,
                          :failoverTarget boolean,
                          :cascadableReplica boolean},
   :serverCaCert {:instance string,
                  :expirationTime string,
                  :cert string,
                  :createTime string,
                  :selfLink string,
                  :sha1Fingerprint string,
                  :kind string,
                  :commonName string,
                  :certSerialNumber string},
   :connectionName string,
   :secondaryGceZone string,
   :outOfDiskReport {:sqlOutOfDiskState string,
                     :sqlMinRecommendedIncreaseSizeGb integer},
   :writeEndpoint string,
   :suspensionReason [string],
   :databaseInstalledVersion string}
  
  Creates a new Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances"
     #{:project}
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

(defn demoteMaster$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/demoteMaster
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:demoteMasterContext {:kind string,
                         :verifyGtidConsistency boolean,
                         :masterInstanceName string,
                         :replicaConfiguration DemoteMasterConfiguration,
                         :skipReplicationSetup boolean}}
  
  Demotes the stand-alone instance to be a Cloud SQL read replica for an external database server."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/demoteMaster"
     #{:instance :project}
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

(defn restart$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/restart
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Restarts a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/restart"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/patch
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:onPremisesConfiguration {:sourceInstance InstanceReference,
                             :clientCertificate string,
                             :password string,
                             :clientKey string,
                             :caCertificate string,
                             :username string,
                             :kind string,
                             :dumpFilePath string,
                             :hostPort string},
   :diskEncryptionConfiguration {:kmsKeyName string, :kind string},
   :databaseVersion string,
   :maxDiskSize string,
   :replicationCluster {:psaWriteEndpoint string,
                        :failoverDrReplicaName string,
                        :drReplica boolean},
   :instanceType string,
   :rootPassword string,
   :currentDiskSize string,
   :gceZone string,
   :name string,
   :masterInstanceName string,
   :createTime string,
   :settings {:dataCacheConfig DataCacheConfig,
              :activeDirectoryConfig SqlActiveDirectoryConfig,
              :availabilityType string,
              :timeZone string,
              :tier string,
              :databaseFlags [DatabaseFlags],
              :databaseReplicationEnabled boolean,
              :sqlServerAuditConfig SqlServerAuditConfig,
              :settingsVersion string,
              :storageAutoResizeLimit string,
              :crashSafeReplicationEnabled boolean,
              :activationPolicy string,
              :deletionProtectionEnabled boolean,
              :collation string,
              :storageAutoResize boolean,
              :pricingPlan string,
              :locationPreference LocationPreference,
              :insightsConfig InsightsConfig,
              :advancedMachineFeatures AdvancedMachineFeatures,
              :ipConfiguration IpConfiguration,
              :passwordValidationPolicy PasswordValidationPolicy,
              :enableGoogleMlIntegration boolean,
              :kind string,
              :maintenanceWindow MaintenanceWindow,
              :edition string,
              :backupConfiguration BackupConfiguration,
              :denyMaintenancePeriods [DenyMaintenancePeriod],
              :dataDiskSizeGb string,
              :replicationType string,
              :userLabels {},
              :dataDiskType string,
              :connectorEnforcement string,
              :authorizedGaeApplications [string]},
   :selfLink string,
   :primaryDnsName string,
   :etag string,
   :ipAddresses [{:type string, :ipAddress string, :timeToRetire string}],
   :state string,
   :ipv6Address string,
   :availableMaintenanceVersions [string],
   :region string,
   :diskEncryptionStatus {:kmsKeyVersionName string, :kind string},
   :replicaNames [string],
   :sqlNetworkArchitecture string,
   :pscServiceAttachmentLink string,
   :geminiConfig {:entitled boolean,
                  :googleVacuumMgmtEnabled boolean,
                  :oomSessionCancelEnabled boolean,
                  :activeQueryEnabled boolean,
                  :indexAdvisorEnabled boolean,
                  :flagRecommenderEnabled boolean},
   :failoverReplica {:name string, :available boolean},
   :satisfiesPzs boolean,
   :dnsName string,
   :project string,
   :kind string,
   :backendType string,
   :maintenanceVersion string,
   :serviceAccountEmailAddress string,
   :scheduledMaintenance {:startTime string,
                          :canDefer boolean,
                          :canReschedule boolean,
                          :scheduleDeadlineTime string},
   :replicaConfiguration {:kind string,
                          :mysqlReplicaConfiguration MySqlReplicaConfiguration,
                          :failoverTarget boolean,
                          :cascadableReplica boolean},
   :serverCaCert {:instance string,
                  :expirationTime string,
                  :cert string,
                  :createTime string,
                  :selfLink string,
                  :sha1Fingerprint string,
                  :kind string,
                  :commonName string,
                  :certSerialNumber string},
   :connectionName string,
   :secondaryGceZone string,
   :outOfDiskReport {:sqlOutOfDiskState string,
                     :sqlMinRecommendedIncreaseSizeGb integer},
   :writeEndpoint string,
   :suspensionReason [string],
   :databaseInstalledVersion string}
  
  Partially updates settings of a Cloud SQL instance by merging the request with the current configuration. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}"
     #{:instance :project}
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

(defn addServerCa$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/addServerCa
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Adds a new trusted Certificate Authority (CA) version for the specified instance. Required to prepare for a certificate rotation. If a CA version was previously added but never used in a certificate rotation, this operation replaces that version. There cannot be more than one CA version waiting to be rotated in."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/addServerCa"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn stopReplica$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/stopReplica
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Stops the replication in the read replica instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/stopReplica"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/update
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:onPremisesConfiguration {:sourceInstance InstanceReference,
                             :clientCertificate string,
                             :password string,
                             :clientKey string,
                             :caCertificate string,
                             :username string,
                             :kind string,
                             :dumpFilePath string,
                             :hostPort string},
   :diskEncryptionConfiguration {:kmsKeyName string, :kind string},
   :databaseVersion string,
   :maxDiskSize string,
   :replicationCluster {:psaWriteEndpoint string,
                        :failoverDrReplicaName string,
                        :drReplica boolean},
   :instanceType string,
   :rootPassword string,
   :currentDiskSize string,
   :gceZone string,
   :name string,
   :masterInstanceName string,
   :createTime string,
   :settings {:dataCacheConfig DataCacheConfig,
              :activeDirectoryConfig SqlActiveDirectoryConfig,
              :availabilityType string,
              :timeZone string,
              :tier string,
              :databaseFlags [DatabaseFlags],
              :databaseReplicationEnabled boolean,
              :sqlServerAuditConfig SqlServerAuditConfig,
              :settingsVersion string,
              :storageAutoResizeLimit string,
              :crashSafeReplicationEnabled boolean,
              :activationPolicy string,
              :deletionProtectionEnabled boolean,
              :collation string,
              :storageAutoResize boolean,
              :pricingPlan string,
              :locationPreference LocationPreference,
              :insightsConfig InsightsConfig,
              :advancedMachineFeatures AdvancedMachineFeatures,
              :ipConfiguration IpConfiguration,
              :passwordValidationPolicy PasswordValidationPolicy,
              :enableGoogleMlIntegration boolean,
              :kind string,
              :maintenanceWindow MaintenanceWindow,
              :edition string,
              :backupConfiguration BackupConfiguration,
              :denyMaintenancePeriods [DenyMaintenancePeriod],
              :dataDiskSizeGb string,
              :replicationType string,
              :userLabels {},
              :dataDiskType string,
              :connectorEnforcement string,
              :authorizedGaeApplications [string]},
   :selfLink string,
   :primaryDnsName string,
   :etag string,
   :ipAddresses [{:type string, :ipAddress string, :timeToRetire string}],
   :state string,
   :ipv6Address string,
   :availableMaintenanceVersions [string],
   :region string,
   :diskEncryptionStatus {:kmsKeyVersionName string, :kind string},
   :replicaNames [string],
   :sqlNetworkArchitecture string,
   :pscServiceAttachmentLink string,
   :geminiConfig {:entitled boolean,
                  :googleVacuumMgmtEnabled boolean,
                  :oomSessionCancelEnabled boolean,
                  :activeQueryEnabled boolean,
                  :indexAdvisorEnabled boolean,
                  :flagRecommenderEnabled boolean},
   :failoverReplica {:name string, :available boolean},
   :satisfiesPzs boolean,
   :dnsName string,
   :project string,
   :kind string,
   :backendType string,
   :maintenanceVersion string,
   :serviceAccountEmailAddress string,
   :scheduledMaintenance {:startTime string,
                          :canDefer boolean,
                          :canReschedule boolean,
                          :scheduleDeadlineTime string},
   :replicaConfiguration {:kind string,
                          :mysqlReplicaConfiguration MySqlReplicaConfiguration,
                          :failoverTarget boolean,
                          :cascadableReplica boolean},
   :serverCaCert {:instance string,
                  :expirationTime string,
                  :cert string,
                  :createTime string,
                  :selfLink string,
                  :sha1Fingerprint string,
                  :kind string,
                  :commonName string,
                  :certSerialNumber string},
   :connectionName string,
   :secondaryGceZone string,
   :outOfDiskReport {:sqlOutOfDiskState string,
                     :sqlMinRecommendedIncreaseSizeGb integer},
   :writeEndpoint string,
   :suspensionReason [string],
   :databaseInstalledVersion string}
  
  Updates settings of a Cloud SQL instance. Using this operation might cause your instance to restart."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}"
     #{:instance :project}
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
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/delete
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Deletes a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn releaseSsrsLease$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/releaseSsrsLease
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Release a lease for the setup of SQL Server Reporting Services (SSRS)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/releaseSsrsLease"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn export$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/export
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:exportContext {:uri string,
                   :databases [string],
                   :kind string,
                   :sqlExportOptions {:tables [string],
                                      :schemaOnly boolean,
                                      :mysqlExportOptions {:masterData integer},
                                      :threads integer,
                                      :parallel boolean},
                   :csvExportOptions {:selectQuery string,
                                      :escapeCharacter string,
                                      :quoteCharacter string,
                                      :fieldsTerminatedBy string,
                                      :linesTerminatedBy string},
                   :fileType string,
                   :offload boolean,
                   :bakExportOptions {:striped boolean,
                                      :stripeCount integer,
                                      :bakType string,
                                      :copyOnly boolean,
                                      :differentialBase boolean}}}
  
  Exports data from a Cloud SQL instance to a Cloud Storage bucket as a SQL dump or CSV file."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/export"
     #{:instance :project}
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

(defn demote$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/demote
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:demoteContext {:kind string,
                   :sourceRepresentativeInstanceName string}}
  
  Demotes an existing standalone instance to be a Cloud SQL read replica for an external database server."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/demote"
     #{:instance :project}
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

(defn listServerCas$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/listServerCas
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Lists all of the trusted Certificate Authorities (CAs) for the specified instance. There can be up to three CAs listed: the CA that was used to sign the certificate that is currently in use, a CA that has been added but not yet used to sign a certificate, and a CA used to sign a certificate that has previously rotated out."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/listServerCas"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn promoteReplica$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/promoteReplica
  
  Required parameters: project, instance
  
  Optional parameters: failover
  
  Promotes the read replica instance to be an independent Cloud SQL primary instance. Using this operation might cause your instance to restart."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/promoteReplica"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn acquireSsrsLease$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/acquireSsrsLease
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:acquireSsrsLeaseContext {:setupLogin string,
                             :serviceLogin string,
                             :reportDatabase string,
                             :duration string}}
  
  Acquire a lease for the setup of SQL Server Reporting Services (SSRS)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/acquireSsrsLease"
     #{:instance :project}
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

(defn resetSslConfig$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/resetSslConfig
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Deletes all client certificates and generates a new server SSL certificate for the instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/resetSslConfig"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, pageToken
  
  Lists instances under a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn clone$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/clone
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:cloneContext {:kind string,
                  :pitrTimestampMs string,
                  :destinationInstanceName string,
                  :binLogCoordinates BinLogCoordinates,
                  :pointInTime string,
                  :allocatedIpRange string,
                  :databaseNames [string],
                  :preferredZone string}}
  
  Creates a Cloud SQL instance as a clone of the source instance. Using this operation might cause your instance to restart."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/clone"
     #{:instance :project}
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

(defn restoreBackup$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/restoreBackup
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:restoreBackupContext {:kind string,
                          :backupRunId string,
                          :instanceId string,
                          :project string}}
  
  Restores a backup of a Cloud SQL instance. Using this operation might cause your instance to restart."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/restoreBackup"
     #{:instance :project}
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

(defn startReplica$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/startReplica
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Starts the replication in the read replica instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/startReplica"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn rotateServerCa$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/rotateServerCa
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:rotateServerCaContext {:kind string, :nextVersion string}}
  
  Rotates the server certificate to one signed by the Certificate Authority (CA) version previously added with the addServerCA method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/rotateServerCa"
     #{:instance :project}
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

(defn truncateLog$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/truncateLog
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:truncateLogContext {:kind string, :logType string}}
  
  Truncate MySQL general and slow query log tables MySQL only."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/truncateLog"
     #{:instance :project}
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

(defn switchover$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/switchover
  
  Required parameters: project, instance
  
  Optional parameters: dbTimeout
  
  Switches over from the primary instance to the designated DR replica instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/switchover"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reencrypt$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/reencrypt
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:backupReencryptionConfig {:backupLimit integer, :backupType string}}
  
  Reencrypt CMEK instance with latest key version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/reencrypt"
     #{:instance :project}
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

(defn import$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/instances/import
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:importContext {:uri string,
                   :database string,
                   :kind string,
                   :fileType string,
                   :csvImportOptions {:table string,
                                      :columns [string],
                                      :escapeCharacter string,
                                      :quoteCharacter string,
                                      :fieldsTerminatedBy string,
                                      :linesTerminatedBy string},
                   :importUser string,
                   :bakImportOptions {:encryptionOptions {:certPath string,
                                                          :pvkPath string,
                                                          :pvkPassword string},
                                      :striped boolean,
                                      :noRecovery boolean,
                                      :recoveryOnly boolean,
                                      :bakType string,
                                      :stopAt string,
                                      :stopAtMark string},
                   :sqlImportOptions {:threads integer,
                                      :parallel boolean}}}
  
  Imports data into a Cloud SQL instance from a SQL dump or CSV file in Cloud Storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/import"
     #{:instance :project}
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
