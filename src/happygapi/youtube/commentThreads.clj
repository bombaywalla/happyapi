(ns happygapi.youtube.commentThreads
  "YouTube Data API v3: commentThreads.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/api/reference/rest/v3/commentThreads"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/youtube/api/reference/rest/v3/commentThreads/list
  
  Required parameters: part
  
  Optional parameters: textFormat, channelId, allThreadsRelatedToChannelId, pageToken, id, videoId, order, searchTerms, moderationStatus, maxResults
  
  Retrieves a list of resources, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/commentThreads"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/youtube/api/reference/rest/v3/commentThreads/insert
  
  Required parameters: part
  
  Optional parameters: none
  
  Body: 
  
  {:snippet {:topLevelComment Comment,
             :canReply boolean,
             :isPublic boolean,
             :channelId string,
             :totalReplyCount integer,
             :videoId string},
   :id string,
   :kind string,
   :etag string,
   :replies {:comments [Comment]}}
  
  Inserts a new resource into this collection."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/commentThreads"
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

(defn update$
  "https://developers.google.com/youtube/api/reference/rest/v3/commentThreads/update
  
  Required parameters: part
  
  Optional parameters: none
  
  Body: 
  
  {:snippet {:topLevelComment Comment,
             :canReply boolean,
             :isPublic boolean,
             :channelId string,
             :totalReplyCount integer,
             :videoId string},
   :id string,
   :kind string,
   :etag string,
   :replies {:comments [Comment]}}
  
  Updates an existing resource."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/commentThreads"
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
