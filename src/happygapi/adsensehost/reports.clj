(ns happygapi.adsensehost.reports
  "AdSense Host API: reports.
  Generates performance reports, generates ad codes, and provides publisher management capabilities for AdSense Hosts.
  See: https://developers.google.com/adsense/host/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn generate$
  "https://developers.google.com/adsense/host/v4.1/docs/reports/generate
  
  Required parameters: startDate, endDate
  
  Optional parameters: locale, filter, dimension, startIndex, metric, sort, maxResults
  
  Generate an AdSense report based on the report request sent in the query parameters. Returns the result as JSON; to retrieve output in CSV format specify \"alt=csv\" as a query parameter."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:startDate :endDate})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "reports"
     #{:startDate :endDate}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
