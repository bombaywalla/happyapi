(ns happygapi.fcmdata.projects
  "Firebase Cloud Messaging Data API: projects.
  Provides additional information about Firebase Cloud Messaging (FCM) message sends and deliveries.
  See: https://firebase.google.com/docs/cloud-messaging"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn androidApps-deliveryData-list$
  "https://firebase.google.com/docs/cloud-messaging
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  List aggregate delivery data for the given Android application."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://fcmdata.googleapis.com/"
     "v1beta1/{+parent}/deliveryData"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
