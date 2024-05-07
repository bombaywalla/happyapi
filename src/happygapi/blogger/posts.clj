(ns happygapi.blogger.posts
  "Blogger API: posts.
  The Blogger API provides access to posts, comments and pages of a Blogger blog.
  See: https://developers.google.com/blogger/docs/3.0/getting_started"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/blogger/docs/3.0/getting_started
  
  Required parameters: blogId, postId
  
  Optional parameters: fetchImages, view, maxComments, fetchBody
  
  Gets a post by blog id and post id"
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :postId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/posts/{postId}"
     #{:blogId :postId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/blogger/docs/3.0/getting_started
  
  Required parameters: blogId
  
  Optional parameters: fetchBody, fetchImages, isDraft
  
  Body: 
  
  {:labels [string],
   :titleLink string,
   :content string,
   :updated string,
   :images [{:url string}],
   :selfLink string,
   :etag string,
   :title string,
   :author {:displayName string,
            :url string,
            :id string,
            :image {:url string}},
   :replies {:items [{:inReplyTo {:id string},
                      :content string,
                      :updated string,
                      :selfLink string,
                      :author {:image {:url string},
                               :url string,
                               :displayName string,
                               :id string},
                      :status string,
                      :id string,
                      :kind string,
                      :post {:id string},
                      :blog {:id string},
                      :published string}],
             :totalItems string,
             :selfLink string},
   :status string,
   :customMetaData string,
   :trashed string,
   :id string,
   :kind string,
   :url string,
   :readerComments string,
   :location {:name string, :span string, :lng number, :lat number},
   :blog {:id string},
   :published string}
  
  Inserts a post."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:blogId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/posts"
     #{:blogId}
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

(defn patch$
  "https://developers.google.com/blogger/docs/3.0/getting_started
  
  Required parameters: blogId, postId
  
  Optional parameters: revert, publish, fetchImages, fetchBody, maxComments
  
  Body: 
  
  {:labels [string],
   :titleLink string,
   :content string,
   :updated string,
   :images [{:url string}],
   :selfLink string,
   :etag string,
   :title string,
   :author {:displayName string,
            :url string,
            :id string,
            :image {:url string}},
   :replies {:items [{:inReplyTo {:id string},
                      :content string,
                      :updated string,
                      :selfLink string,
                      :author {:image {:url string},
                               :url string,
                               :displayName string,
                               :id string},
                      :status string,
                      :id string,
                      :kind string,
                      :post {:id string},
                      :blog {:id string},
                      :published string}],
             :totalItems string,
             :selfLink string},
   :status string,
   :customMetaData string,
   :trashed string,
   :id string,
   :kind string,
   :url string,
   :readerComments string,
   :location {:name string, :span string, :lng number, :lat number},
   :blog {:id string},
   :published string}
  
  Patches a post."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:blogId :postId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/posts/{postId}"
     #{:blogId :postId}
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
  "https://developers.google.com/blogger/docs/3.0/getting_started
  
  Required parameters: blogId, postId
  
  Optional parameters: maxComments, revert, fetchImages, fetchBody, publish
  
  Body: 
  
  {:labels [string],
   :titleLink string,
   :content string,
   :updated string,
   :images [{:url string}],
   :selfLink string,
   :etag string,
   :title string,
   :author {:displayName string,
            :url string,
            :id string,
            :image {:url string}},
   :replies {:items [{:inReplyTo {:id string},
                      :content string,
                      :updated string,
                      :selfLink string,
                      :author {:image {:url string},
                               :url string,
                               :displayName string,
                               :id string},
                      :status string,
                      :id string,
                      :kind string,
                      :post {:id string},
                      :blog {:id string},
                      :published string}],
             :totalItems string,
             :selfLink string},
   :status string,
   :customMetaData string,
   :trashed string,
   :id string,
   :kind string,
   :url string,
   :readerComments string,
   :location {:name string, :span string, :lng number, :lat number},
   :blog {:id string},
   :published string}
  
  Updates a post by blog id and post id."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:blogId :postId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/posts/{postId}"
     #{:blogId :postId}
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
  "https://developers.google.com/blogger/docs/3.0/getting_started
  
  Required parameters: blogId, postId
  
  Optional parameters: useTrash
  
  Deletes a post by blog id and post id."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :postId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/posts/{postId}"
     #{:blogId :postId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn search$
  "https://developers.google.com/blogger/docs/3.0/getting_started
  
  Required parameters: q, blogId
  
  Optional parameters: orderBy, fetchBodies
  
  Searches for posts matching given query terms in the specified blog."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :q})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/posts/search"
     #{:blogId :q}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn revert$
  "https://developers.google.com/blogger/docs/3.0/getting_started
  
  Required parameters: blogId, postId
  
  Optional parameters: none
  
  Reverts a published or scheduled post to draft state."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :postId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/posts/{postId}/revert"
     #{:blogId :postId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/blogger/docs/3.0/getting_started
  
  Required parameters: blogId
  
  Optional parameters: labels, startDate, sortOption, pageToken, endDate, fetchBodies, status, fetchImages, maxResults, view, orderBy
  
  Lists posts."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/posts"
     #{:blogId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn publish$
  "https://developers.google.com/blogger/docs/3.0/getting_started
  
  Required parameters: postId, blogId
  
  Optional parameters: publishDate
  
  Publishes a post."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :postId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/posts/{postId}/publish"
     #{:blogId :postId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getByPath$
  "https://developers.google.com/blogger/docs/3.0/getting_started
  
  Required parameters: path, blogId
  
  Optional parameters: maxComments, view
  
  Gets a post by path."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/posts/bypath"
     #{:blogId :path}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
