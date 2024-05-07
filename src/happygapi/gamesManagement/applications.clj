(ns happygapi.gamesManagement.applications
  "Google Play Game Management: applications.
  The Google Play Game Management API allows developers to manage resources from the Google Play Game service.
  See: https://games.withgoogle.com/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn listHidden$
  "https://games.withgoogle.com
  
  Required parameters: applicationId
  
  Optional parameters: maxResults, pageToken
  
  Get the list of players hidden from the given application. This method is only available to user accounts for your developer console."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:applicationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gamesmanagement.googleapis.com/"
     "games/v1management/applications/{applicationId}/players/hidden"
     #{:applicationId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
