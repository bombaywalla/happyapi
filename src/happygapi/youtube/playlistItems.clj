(ns happygapi.youtube.playlistItems
  "YouTube Data API v3: playlistItems.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/youtube/v3/docs/playlistItems/update
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:status {:privacyStatus string},
   :etag string,
   :snippet {:videoOwnerChannelTitle string,
             :description string,
             :publishedAt string,
             :channelId string,
             :thumbnails ThumbnailDetails,
             :title string,
             :resourceId ResourceId,
             :videoOwnerChannelId string,
             :position integer,
             :channelTitle string,
             :playlistId string},
   :kind string,
   :contentDetails {:startAt string,
                    :note string,
                    :videoPublishedAt string,
                    :endAt string,
                    :videoId string},
   :id string}
  
  Updates an existing resource."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/playlistItems"
     #{:part}
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

(defn insert$
  "https://developers.google.com/youtube/v3/docs/playlistItems/insert
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:status {:privacyStatus string},
   :etag string,
   :snippet {:videoOwnerChannelTitle string,
             :description string,
             :publishedAt string,
             :channelId string,
             :thumbnails ThumbnailDetails,
             :title string,
             :resourceId ResourceId,
             :videoOwnerChannelId string,
             :position integer,
             :channelTitle string,
             :playlistId string},
   :kind string,
   :contentDetails {:startAt string,
                    :note string,
                    :videoPublishedAt string,
                    :endAt string,
                    :videoId string},
   :id string}
  
  Inserts a new resource into this collection."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/playlistItems"
     #{:part}
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
  "https://developers.google.com/youtube/v3/docs/playlistItems/delete
  
  Required parameters: id
  
  Optional parameters: onBehalfOfContentOwner
  
  Deletes a resource."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/playlistItems"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/youtube/v3/docs/playlistItems/list
  
  Required parameters: part
  
  Optional parameters: videoId, id, onBehalfOfContentOwner, pageToken, maxResults, playlistId
  
  Retrieves a list of resources, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/playlistItems"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
