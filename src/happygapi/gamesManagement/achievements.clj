(ns happygapi.gamesManagement.achievements
  "Google Play Game Management: achievements.
  The Google Play Game Management API allows developers to manage resources from the Google Play Game service.
  See: https://games.withgoogle.com/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn reset$
  "https://games.withgoogle.com
  
  Required parameters: achievementId
  
  Optional parameters: none
  
  Resets the achievement with the given ID for the currently authenticated player. This method is only accessible to whitelisted tester accounts for your application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:achievementId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gamesmanagement.googleapis.com/"
     "games/v1management/achievements/{achievementId}/reset"
     #{:achievementId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resetAll$
  "https://games.withgoogle.com
  
  Required parameters: none
  
  Optional parameters: none
  
  Resets all achievements for the currently authenticated player for your application. This method is only accessible to whitelisted tester accounts for your application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gamesmanagement.googleapis.com/"
     "games/v1management/achievements/reset"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resetAllForAllPlayers$
  "https://games.withgoogle.com
  
  Required parameters: none
  
  Optional parameters: none
  
  Resets all draft achievements for all players. This method is only available to user accounts for your developer console."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gamesmanagement.googleapis.com/"
     "games/v1management/achievements/resetAllForAllPlayers"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resetForAllPlayers$
  "https://games.withgoogle.com
  
  Required parameters: achievementId
  
  Optional parameters: none
  
  Resets the achievement with the given ID for all players. This method is only available to user accounts for your developer console. Only draft achievements can be reset."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:achievementId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gamesmanagement.googleapis.com/"
     "games/v1management/achievements/{achievementId}/resetForAllPlayers"
     #{:achievementId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resetMultipleForAllPlayers$
  "https://games.withgoogle.com
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:kind string, :achievement_ids [string]}
  
  Resets achievements with the given IDs for all players. This method is only available to user accounts for your developer console. Only draft achievements may be reset."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gamesmanagement.googleapis.com/"
     "games/v1management/achievements/resetMultipleForAllPlayers"
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
