(ns happygapi.chromemanagement.customers
  "Chrome Management API: customers.
  The Chrome Management API is a suite of services that allows Chrome administrators to view, manage and gain insights on their Chrome OS and Chrome Browser devices.
  See: https://developers.google.com/chrome/management/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn telemetry-devices-get$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.telemetry.devices/get
  
  Required parameters: name
  
  Optional parameters: readMask
  
  Get telemetry device."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.telemetry.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
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

(defn telemetry-devices-list$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.telemetry.devices/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken, readMask
  
  List all telemetry devices."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.telemetry.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+parent}/telemetry/devices"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn telemetry-notificationConfigs-list$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.telemetry.notificationConfigs/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  List all telemetry notification configs."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.telemetry.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+parent}/telemetry/notificationConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn telemetry-notificationConfigs-create$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.telemetry.notificationConfigs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:customer string,
   :filter {:userEmail string,
            :telemetryEventNotificationFilter GoogleChromeManagementV1TelemetryEventNotificationFilter,
            :deviceOrgUnitId string,
            :userOrgUnitId string,
            :deviceId string},
   :name string,
   :googleCloudPubsubTopic string}
  
  Create a telemetry notification config."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.telemetry.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+parent}/telemetry/notificationConfigs"
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

(defn telemetry-notificationConfigs-delete$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.telemetry.notificationConfigs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a telemetry notification config."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.telemetry.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://chromemanagement.googleapis.com/"
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

(defn telemetry-events-list$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.telemetry.events/list
  
  Required parameters: parent
  
  Optional parameters: readMask, filter, pageSize, pageToken
  
  List telemetry events."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.telemetry.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+parent}/telemetry/events"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn telemetry-users-list$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.telemetry.users/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, readMask, filter, pageToken
  
  List all telemetry users."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.telemetry.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+parent}/telemetry/users"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn telemetry-users-get$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.telemetry.users/get
  
  Required parameters: name
  
  Optional parameters: readMask
  
  Get telemetry user."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.telemetry.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
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

(defn apps-fetchDevicesRequestingExtension$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.apps/fetchDevicesRequestingExtension
  
  Required parameters: customer
  
  Optional parameters: pageSize, orgUnitId, extensionId, pageToken
  
  Get a list of devices that have requested to install an extension."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.appdetails.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+customer}/apps:fetchDevicesRequestingExtension"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-fetchUsersRequestingExtension$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.apps/fetchUsersRequestingExtension
  
  Required parameters: customer
  
  Optional parameters: orgUnitId, pageSize, extensionId, pageToken
  
  Get a list of users that have requested to install an extension."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.appdetails.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+customer}/apps:fetchUsersRequestingExtension"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-countChromeAppRequests$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.apps/countChromeAppRequests
  
  Required parameters: customer
  
  Optional parameters: orgUnitId, pageToken, orderBy, pageSize
  
  Generate summary of app installation requests."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.appdetails.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+customer}/apps:countChromeAppRequests"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-web-get$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.apps.web/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a specific app for a customer by its resource name."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.appdetails.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
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

(defn apps-chrome-get$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.apps.chrome/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a specific app for a customer by its resource name."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.appdetails.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
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

(defn apps-android-get$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.apps.android/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a specific app for a customer by its resource name."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.appdetails.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
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

(defn reports-countChromeDevicesThatNeedAttention$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.reports/countChromeDevicesThatNeedAttention
  
  Required parameters: customer
  
  Optional parameters: readMask, orgUnitId
  
  Counts of ChromeOS devices that have not synced policies or have lacked user activity in the past 28 days, are out of date, or are not complaint. Further information can be found here https://support.google.com/chrome/a/answer/10564947"
  {:scopes ["https://www.googleapis.com/auth/chrome.management.reports.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+customer}/reports:countChromeDevicesThatNeedAttention"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-countChromeHardwareFleetDevices$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.reports/countChromeHardwareFleetDevices
  
  Required parameters: customer
  
  Optional parameters: readMask, orgUnitId
  
  Counts of devices with a specific hardware specification from the requested hardware type (for example model name, processor type). Further information can be found here https://support.google.com/chrome/a/answer/10564947"
  {:scopes ["https://www.googleapis.com/auth/chrome.management.reports.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+customer}/reports:countChromeHardwareFleetDevices"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-findInstalledAppDevices$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.reports/findInstalledAppDevices
  
  Required parameters: customer
  
  Optional parameters: pageSize, appId, orgUnitId, appType, orderBy, pageToken, filter
  
  Generate report of managed Chrome browser devices that have a specified app installed."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.reports.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+customer}/reports:findInstalledAppDevices"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-countChromeCrashEvents$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.reports/countChromeCrashEvents
  
  Required parameters: customer
  
  Optional parameters: orgUnitId, orderBy, filter
  
  Get a count of Chrome crash events."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.reports.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+customer}/reports:countChromeCrashEvents"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-countChromeVersions$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.reports/countChromeVersions
  
  Required parameters: customer
  
  Optional parameters: filter, orgUnitId, pageSize, pageToken
  
  Generate report of installed Chrome versions."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.reports.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+customer}/reports:countChromeVersions"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-countPrintJobsByPrinter$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.reports/countPrintJobsByPrinter
  
  Required parameters: customer
  
  Optional parameters: orderBy, pageSize, filter, printerOrgUnitId, pageToken
  
  Get a summary of printing done by each printer."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.reports.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+customer}/reports:countPrintJobsByPrinter"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-countChromeDevicesReachingAutoExpirationDate$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.reports/countChromeDevicesReachingAutoExpirationDate
  
  Required parameters: customer
  
  Optional parameters: orgUnitId, minAueDate, maxAueDate
  
  Generate report of the number of devices expiring in each month of the selected time frame. Devices are grouped by auto update expiration date and model. Further information can be found [here](https://support.google.com/chrome/a/answer/10564947)."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.reports.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+customer}/reports:countChromeDevicesReachingAutoExpirationDate"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-enumeratePrintJobs$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.reports/enumeratePrintJobs
  
  Required parameters: customer
  
  Optional parameters: pageToken, printerOrgUnitId, filter, orderBy, pageSize
  
  Get a list of print jobs."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.reports.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+customer}/reports:enumeratePrintJobs"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-countPrintJobsByUser$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.reports/countPrintJobsByUser
  
  Required parameters: customer
  
  Optional parameters: pageToken, pageSize, printerOrgUnitId, orderBy, filter
  
  Get a summary of printing done by each user."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.reports.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+customer}/reports:countPrintJobsByUser"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-countChromeBrowsersNeedingAttention$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.reports/countChromeBrowsersNeedingAttention
  
  Required parameters: customer
  
  Optional parameters: orgUnitId
  
  Count of Chrome Browsers that have been recently enrolled, have new policy to be synced, or have no recent activity."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.reports.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+customer}/reports:countChromeBrowsersNeedingAttention"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-countInstalledApps$
  "https://developers.google.com/chrome/management/reference/rest/v1/customers.reports/countInstalledApps
  
  Required parameters: customer
  
  Optional parameters: orgUnitId, orderBy, filter, pageSize, pageToken
  
  Generate report of app installations."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.reports.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+customer}/reports:countInstalledApps"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
