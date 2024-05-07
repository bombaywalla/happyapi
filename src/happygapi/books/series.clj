(ns happygapi.books.series
  "Books API: series.
  The Google Books API allows clients to access the Google Books repository.
  See: https://developers.google.com/books/docs/v1/getting_started?csw=1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/series/get
  
  Required parameters: series_id
  
  Optional parameters: none
  
  Returns Series metadata for the given series ids."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:series_id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/series/get"
     #{:series_id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn membership-get$
  "https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/series/membership/get
  
  Required parameters: series_id
  
  Optional parameters: page_size, page_token
  
  Returns Series membership data given the series id."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:series_id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/series/membership/get"
     #{:series_id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
