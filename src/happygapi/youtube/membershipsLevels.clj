(ns happygapi.youtube.membershipsLevels
  "YouTube Data API v3: membershipsLevels.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/youtube/v3/docs/membershipsLevels/list
  
  Required parameters: part
  
  Optional parameters: none
  
  Retrieves a list of all pricing levels offered by a creator to the fans."
  {:scopes ["https://www.googleapis.com/auth/youtube.channel-memberships.creator"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/membershipsLevels"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
