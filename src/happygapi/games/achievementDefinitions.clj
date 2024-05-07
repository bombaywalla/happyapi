(ns happygapi.games.achievementDefinitions
  "Google Play Game Services: achievementDefinitions.
  The Google Play games service allows developers to enhance games with social leaderboards, achievements, game state, sign-in with Google, and more.
  See: https://games.withgoogle.com/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://games.withgoogle.com
  
  Required parameters: none
  
  Optional parameters: language, maxResults, pageToken
  
  Lists all the achievement definitions for your application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/achievements"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
