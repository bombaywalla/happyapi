(ns happygapi.youtube.tests
  "YouTube Data API v3: tests.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/youtube/v3/docs/tests/insert
  
  Required parameters: part
  
  Optional parameters: externalChannelId
  
  Body: 
  
  {:id string, :featuredPart boolean, :gaia string, :snippet {}}
  
  POST method."
  {:scopes ["https://www.googleapis.com/auth/youtube.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/tests"
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
