(ns happygapi.books.volumes
  "Books API: volumes.
  The Google Books API allows clients to access the Google Books repository.
  See: https://developers.google.com/books/docs/v1/getting_started?csw=1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/volumes/get
  
  Required parameters: volumeId
  
  Optional parameters: country, includeNonComicsSeries, partner, projection, source, user_library_consistent_read
  
  Gets volume information for a single volume."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:volumeId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/volumes/{volumeId}"
     #{:volumeId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/volumes/list
  
  Required parameters: q
  
  Optional parameters: maxAllowedMaturityRating, partner, printType, libraryRestrict, langRestrict, source, filter, showPreorders, download, startIndex, projection, maxResults, orderBy
  
  Performs a book search."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:q})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/volumes"
     #{:q}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn associated-list$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/volumes/associated/list
  
  Required parameters: volumeId
  
  Optional parameters: association, locale, maxAllowedMaturityRating, source
  
  Return a list of associated books."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:volumeId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/volumes/{volumeId}/associated"
     #{:volumeId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn mybooks-list$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/volumes/mybooks/list
  
  Required parameters: none
  
  Optional parameters: acquireMethod, country, locale, maxResults, processingState, source, startIndex
  
  Return a list of books in My Library."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/volumes/mybooks"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn recommended-list$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/volumes/recommended/list
  
  Required parameters: none
  
  Optional parameters: locale, maxAllowedMaturityRating, source
  
  Return a list of recommended books for the current user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/volumes/recommended"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn recommended-rate$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/volumes/recommended/rate
  
  Required parameters: rating, volumeId
  
  Optional parameters: locale, source
  
  Rate a recommended book for the current user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:volumeId :rating})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/volumes/recommended/rate"
     #{:volumeId :rating}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn useruploaded-list$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/volumes/useruploaded/list
  
  Required parameters: none
  
  Optional parameters: locale, maxResults, processingState, source, startIndex, volumeId
  
  Return a list of books uploaded by the current user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/volumes/useruploaded"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
