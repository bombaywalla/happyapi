(ns happygapi.playcustomapp.accounts
  "Google Play Custom App Publishing API: accounts.
  API to create and publish custom Android apps
  See: https://developers.google.com/android/work/play/custom-app-api/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn customApps-create$
  "https://developers.google.com/android/work/play/custom-app-api
  
  Required parameters: account
  
  Optional parameters: none
  
  Body: 
  
  {:packageName string,
   :title string,
   :organizations [{:organizationName string, :organizationId string}],
   :languageCode string}
  
  Creates a new custom app."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:account})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://playcustomapp.googleapis.com/"
     "playcustomapp/v1/accounts/{account}/customApps"
     #{:account}
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
