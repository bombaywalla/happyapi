(ns happygapi.homegraph.devices
  "HomeGraph API: devices.
  
  See: https://developers.home.google.com/cloud-to-cloud/get-started"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn query$
  "https://developers.home.google.com/cloud-to-cloud/get-started
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string,
   :agentUserId string,
   :inputs [{:payload QueryRequestPayload}]}
  
  Gets the current states in Home Graph for the given set of the third-party user's devices. The third-party user's identity is passed in via the `agent_user_id` (see QueryRequest). This request must be authorized using service account credentials from your Actions console project."
  {:scopes ["https://www.googleapis.com/auth/homegraph"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://homegraph.googleapis.com/"
     "v1/devices:query"
     #{}
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

(defn requestSync$
  "https://developers.home.google.com/cloud-to-cloud/get-started
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:async boolean, :agentUserId string}
  
  Requests Google to send an `action.devices.SYNC` [intent](https://developers.home.google.com/cloud-to-cloud/intents/sync) to your smart home Action to update device metadata for the given user. The third-party user's identity is passed via the `agent_user_id` (see RequestSyncDevicesRequest). This request must be authorized using service account credentials from your Actions console project."
  {:scopes ["https://www.googleapis.com/auth/homegraph"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://homegraph.googleapis.com/"
     "v1/devices:requestSync"
     #{}
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

(defn sync$
  "https://developers.home.google.com/cloud-to-cloud/get-started
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:agentUserId string, :requestId string}
  
  Gets all the devices associated with the given third-party user. The third-party user's identity is passed in via the `agent_user_id` (see SyncRequest). This request must be authorized using service account credentials from your Actions console project."
  {:scopes ["https://www.googleapis.com/auth/homegraph"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://homegraph.googleapis.com/"
     "v1/devices:sync"
     #{}
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

(defn reportStateAndNotification$
  "https://developers.home.google.com/cloud-to-cloud/get-started
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:agentUserId string,
   :payload {:devices ReportStateAndNotificationDevice},
   :eventId string,
   :requestId string,
   :followUpToken string}
  
  Reports device state and optionally sends device notifications. Called by your smart home Action when the state of a third-party device changes or you need to send a notification about the device. See [Implement Report State](https://developers.home.google.com/cloud-to-cloud/integration/report-state) for more information. This method updates the device state according to its declared [traits](https://developers.home.google.com/cloud-to-cloud/primer/device-types-and-traits). Publishing a new state value outside of these traits will result in an `INVALID_ARGUMENT` error response. The third-party user's identity is passed in via the `agent_user_id` (see ReportStateAndNotificationRequest). This request must be authorized using service account credentials from your Actions console project."
  {:scopes ["https://www.googleapis.com/auth/homegraph"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://homegraph.googleapis.com/"
     "v1/devices:reportStateAndNotification"
     #{}
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
