(ns happygapi.searchconsole.sitemaps
  "Google Search Console API: sitemaps.
  The Search Console API provides access to both Search Console data (verified users only) and to public information on an URL basis (anyone)
  See: https://developer.chrome.com/docs/lighthouse/overview/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developer.chrome.com/docs/lighthouse/overview
  
  Required parameters: feedpath, siteUrl
  
  Optional parameters: none
  
  Retrieves information about a specific sitemap."
  {:scopes ["https://www.googleapis.com/auth/webmasters"
            "https://www.googleapis.com/auth/webmasters.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:feedpath :siteUrl})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://searchconsole.googleapis.com/"
     "webmasters/v3/sites/{siteUrl}/sitemaps/{feedpath}"
     #{:feedpath :siteUrl}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn submit$
  "https://developer.chrome.com/docs/lighthouse/overview
  
  Required parameters: feedpath, siteUrl
  
  Optional parameters: none
  
  Submits a sitemap for a site."
  {:scopes ["https://www.googleapis.com/auth/webmasters"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:feedpath :siteUrl})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://searchconsole.googleapis.com/"
     "webmasters/v3/sites/{siteUrl}/sitemaps/{feedpath}"
     #{:feedpath :siteUrl}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developer.chrome.com/docs/lighthouse/overview
  
  Required parameters: siteUrl
  
  Optional parameters: sitemapIndex
  
   Lists the [sitemaps-entries](/webmaster-tools/v3/sitemaps) submitted for this site, or included in the sitemap index file (if `sitemapIndex` is specified in the request)."
  {:scopes ["https://www.googleapis.com/auth/webmasters"
            "https://www.googleapis.com/auth/webmasters.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:siteUrl})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://searchconsole.googleapis.com/"
     "webmasters/v3/sites/{siteUrl}/sitemaps"
     #{:siteUrl}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developer.chrome.com/docs/lighthouse/overview
  
  Required parameters: siteUrl, feedpath
  
  Optional parameters: none
  
  Deletes a sitemap from the Sitemaps report. Does not stop Google from crawling this sitemap or the URLs that were previously crawled in the deleted sitemap."
  {:scopes ["https://www.googleapis.com/auth/webmasters"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:feedpath :siteUrl})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://searchconsole.googleapis.com/"
     "webmasters/v3/sites/{siteUrl}/sitemaps/{feedpath}"
     #{:feedpath :siteUrl}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
