(ns happygapi.doubleclicksearch.reports
  "Search Ads 360 API: reports.
  The Search Ads 360 API allows developers to automate uploading conversions and downloading reports from Search Ads 360.
  See: https://developers.google.com/search-ads"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn generate$
  "https://developers.google.com/search-ads
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:timeRange {:changedMetricsSinceTimestamp string,
               :changedAttributesSinceTimestamp string,
               :startDate string,
               :endDate string},
   :filters [{:column {:productReportPerspective string,
                       :customMetricName string,
                       :startDate string,
                       :headerText string,
                       :endDate string,
                       :groupByColumn boolean,
                       :platformSource string,
                       :customDimensionName string,
                       :savedColumnName string,
                       :columnName string},
              :operator string,
              :values [any]}],
   :columns [{:productReportPerspective string,
              :customMetricName string,
              :startDate string,
              :headerText string,
              :endDate string,
              :groupByColumn boolean,
              :platformSource string,
              :customDimensionName string,
              :savedColumnName string,
              :columnName string}],
   :includeRemovedEntities boolean,
   :verifySingleTimeZone boolean,
   :includeDeletedEntities boolean,
   :statisticsCurrency string,
   :reportScope {:agencyId string,
                 :advertiserId string,
                 :engineAccountId string,
                 :campaignId string,
                 :adGroupId string,
                 :keywordId string,
                 :adId string},
   :reportType string,
   :startRow integer,
   :maxRowsPerFile integer,
   :rowCount integer,
   :downloadFormat string,
   :orderBy [{:column {:productReportPerspective string,
                       :customMetricName string,
                       :startDate string,
                       :headerText string,
                       :endDate string,
                       :groupByColumn boolean,
                       :platformSource string,
                       :customDimensionName string,
                       :savedColumnName string,
                       :columnName string},
              :sortOrder string}]}
  
  Generates and returns a report immediately."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://doubleclicksearch.googleapis.com/"
     "doubleclicksearch/v2/reports/generate"
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

(defn get$
  "https://developers.google.com/search-ads
  
  Required parameters: reportId
  
  Optional parameters: none
  
  Polls for the status of a report request."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://doubleclicksearch.googleapis.com/"
     "doubleclicksearch/v2/reports/{reportId}"
     #{:reportId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getFile$
  "https://developers.google.com/search-ads
  
  Required parameters: reportId, reportFragment
  
  Optional parameters: none
  
  Downloads a report file encoded in UTF-8."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportFragment :reportId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://doubleclicksearch.googleapis.com/"
     "doubleclicksearch/v2/reports/{reportId}/files/{reportFragment}"
     #{:reportFragment :reportId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getIdMappingFile$
  "https://developers.google.com/search-ads
  
  Required parameters: agencyId, advertiserId
  
  Optional parameters: none
  
  Downloads a csv file(encoded in UTF-8) that contains ID mappings between legacy SA360 and new SA360. The file includes all children entities of the given advertiser(e.g. engine accounts, campaigns, ad groups, etc.) that exist in both legacy SA360 and new SA360."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId :agencyId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://doubleclicksearch.googleapis.com/"
     "doubleclicksearch/v2/agency/{agencyId}/advertiser/{advertiserId}/idmapping"
     #{:advertiserId :agencyId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn request$
  "https://developers.google.com/search-ads
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:timeRange {:changedMetricsSinceTimestamp string,
               :changedAttributesSinceTimestamp string,
               :startDate string,
               :endDate string},
   :filters [{:column {:productReportPerspective string,
                       :customMetricName string,
                       :startDate string,
                       :headerText string,
                       :endDate string,
                       :groupByColumn boolean,
                       :platformSource string,
                       :customDimensionName string,
                       :savedColumnName string,
                       :columnName string},
              :operator string,
              :values [any]}],
   :columns [{:productReportPerspective string,
              :customMetricName string,
              :startDate string,
              :headerText string,
              :endDate string,
              :groupByColumn boolean,
              :platformSource string,
              :customDimensionName string,
              :savedColumnName string,
              :columnName string}],
   :includeRemovedEntities boolean,
   :verifySingleTimeZone boolean,
   :includeDeletedEntities boolean,
   :statisticsCurrency string,
   :reportScope {:agencyId string,
                 :advertiserId string,
                 :engineAccountId string,
                 :campaignId string,
                 :adGroupId string,
                 :keywordId string,
                 :adId string},
   :reportType string,
   :startRow integer,
   :maxRowsPerFile integer,
   :rowCount integer,
   :downloadFormat string,
   :orderBy [{:column {:productReportPerspective string,
                       :customMetricName string,
                       :startDate string,
                       :headerText string,
                       :endDate string,
                       :groupByColumn boolean,
                       :platformSource string,
                       :customDimensionName string,
                       :savedColumnName string,
                       :columnName string},
              :sortOrder string}]}
  
  Inserts a report request into the reporting system."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://doubleclicksearch.googleapis.com/"
     "doubleclicksearch/v2/reports"
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
