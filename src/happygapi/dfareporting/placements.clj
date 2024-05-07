(ns happygapi.dfareporting.placements
  "Campaign Manager 360 API: placements.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Body: 
  
  {:directorySiteId string,
   :placementGroupIdDimensionValue {:dimensionName string,
                                    :value string,
                                    :id string,
                                    :matchType string,
                                    :kind string,
                                    :etag string},
   :keyName string,
   :primary boolean,
   :siteId string,
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :id string,
                      :matchType string,
                      :kind string,
                      :etag string},
   :additionalSizes [{:id string,
                      :width integer,
                      :height integer,
                      :iab boolean,
                      :kind string}],
   :wrappingOptOut boolean,
   :pricingSchedule {:testingStartDate string,
                     :startDate string,
                     :endDate string,
                     :pricingType string,
                     :capCostOption string,
                     :flighted boolean,
                     :pricingPeriods [PricingSchedulePricingPeriod],
                     :floodlightActivityId string},
   :adBlockingOptOut boolean,
   :compatibility string,
   :tagFormats [string],
   :vpaidAdapterChoice string,
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :id string,
                                :matchType string,
                                :kind string,
                                :etag string},
   :name string,
   :placementStrategyId string,
   :campaignId string,
   :conversionDomainOverride {:conversionDomains [PlacementSingleConversionDomain]},
   :createInfo {:time string},
   :videoActiveViewOptOut boolean,
   :partnerWrappingData {:measurementPartner string,
                         :linkStatus string,
                         :wrappedTag string,
                         :tagWrappingMode string},
   :campaignIdDimensionValue {:dimensionName string,
                              :value string,
                              :id string,
                              :matchType string,
                              :kind string,
                              :etag string},
   :size {:id string,
          :width integer,
          :height integer,
          :iab boolean,
          :kind string},
   :placementGroupId string,
   :tagSetting {:additionalKeyValues string,
                :includeClickTracking boolean,
                :includeClickThroughUrls boolean,
                :keywordOption string},
   :contentCategoryId string,
   :videoSettings {:publisherSpecificationId string,
                   :obaEnabled boolean,
                   :companionSettings CompanionSetting,
                   :obaSettings ObaIcon,
                   :skippableSettings SkippableSetting,
                   :orientation string,
                   :durationSeconds integer,
                   :transcodeSettings TranscodeSetting,
                   :kind string},
   :activeStatus string,
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:dimensionName string,
                                   :value string,
                                   :id string,
                                   :matchType string,
                                   :kind string,
                                   :etag string},
   :status string,
   :sslRequired boolean,
   :id string,
   :siteIdDimensionValue {:dimensionName string,
                          :value string,
                          :id string,
                          :matchType string,
                          :kind string,
                          :etag string},
   :kind string,
   :comment string,
   :lookbackConfiguration {:clickDuration integer,
                           :postImpressionActivitiesDuration integer},
   :lastModifiedInfo {:time string},
   :publisherUpdateInfo {:time string},
   :subaccountId string,
   :paymentApproved boolean,
   :accountId string,
   :paymentSource string}
  
  Updates an existing placement. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/placements"
     #{:id :profileId}
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

(defn generatetags$
  "https://developers.google.com/doubleclick-advertisers
  
  Required parameters: profileId
  
  Optional parameters: placementIds, campaignId, tagFormats
  
  Generates tags for a placement."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/placements/generatetags"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/doubleclick-advertisers
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Gets one placement by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/placements/{+id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:directorySiteId string,
   :placementGroupIdDimensionValue {:dimensionName string,
                                    :value string,
                                    :id string,
                                    :matchType string,
                                    :kind string,
                                    :etag string},
   :keyName string,
   :primary boolean,
   :siteId string,
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :id string,
                      :matchType string,
                      :kind string,
                      :etag string},
   :additionalSizes [{:id string,
                      :width integer,
                      :height integer,
                      :iab boolean,
                      :kind string}],
   :wrappingOptOut boolean,
   :pricingSchedule {:testingStartDate string,
                     :startDate string,
                     :endDate string,
                     :pricingType string,
                     :capCostOption string,
                     :flighted boolean,
                     :pricingPeriods [PricingSchedulePricingPeriod],
                     :floodlightActivityId string},
   :adBlockingOptOut boolean,
   :compatibility string,
   :tagFormats [string],
   :vpaidAdapterChoice string,
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :id string,
                                :matchType string,
                                :kind string,
                                :etag string},
   :name string,
   :placementStrategyId string,
   :campaignId string,
   :conversionDomainOverride {:conversionDomains [PlacementSingleConversionDomain]},
   :createInfo {:time string},
   :videoActiveViewOptOut boolean,
   :partnerWrappingData {:measurementPartner string,
                         :linkStatus string,
                         :wrappedTag string,
                         :tagWrappingMode string},
   :campaignIdDimensionValue {:dimensionName string,
                              :value string,
                              :id string,
                              :matchType string,
                              :kind string,
                              :etag string},
   :size {:id string,
          :width integer,
          :height integer,
          :iab boolean,
          :kind string},
   :placementGroupId string,
   :tagSetting {:additionalKeyValues string,
                :includeClickTracking boolean,
                :includeClickThroughUrls boolean,
                :keywordOption string},
   :contentCategoryId string,
   :videoSettings {:publisherSpecificationId string,
                   :obaEnabled boolean,
                   :companionSettings CompanionSetting,
                   :obaSettings ObaIcon,
                   :skippableSettings SkippableSetting,
                   :orientation string,
                   :durationSeconds integer,
                   :transcodeSettings TranscodeSetting,
                   :kind string},
   :activeStatus string,
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:dimensionName string,
                                   :value string,
                                   :id string,
                                   :matchType string,
                                   :kind string,
                                   :etag string},
   :status string,
   :sslRequired boolean,
   :id string,
   :siteIdDimensionValue {:dimensionName string,
                          :value string,
                          :id string,
                          :matchType string,
                          :kind string,
                          :etag string},
   :kind string,
   :comment string,
   :lookbackConfiguration {:clickDuration integer,
                           :postImpressionActivitiesDuration integer},
   :lastModifiedInfo {:time string},
   :publisherUpdateInfo {:time string},
   :subaccountId string,
   :paymentApproved boolean,
   :accountId string,
   :paymentSource string}
  
  Inserts a new placement."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/placements"
     #{:profileId}
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

(defn list$
  "https://developers.google.com/doubleclick-advertisers
  
  Required parameters: profileId
  
  Optional parameters: pricingTypes, minEndDate, campaignIds, contentCategoryIds, ids, searchString, groupIds, pageToken, compatibilities, sortField, minStartDate, advertiserIds, activeStatus, maxEndDate, sortOrder, sizeIds, placementStrategyIds, directorySiteIds, maxStartDate, paymentSource, maxResults, siteIds
  
  Retrieves a list of placements, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/placements"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/doubleclick-advertisers
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:directorySiteId string,
   :placementGroupIdDimensionValue {:dimensionName string,
                                    :value string,
                                    :id string,
                                    :matchType string,
                                    :kind string,
                                    :etag string},
   :keyName string,
   :primary boolean,
   :siteId string,
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :id string,
                      :matchType string,
                      :kind string,
                      :etag string},
   :additionalSizes [{:id string,
                      :width integer,
                      :height integer,
                      :iab boolean,
                      :kind string}],
   :wrappingOptOut boolean,
   :pricingSchedule {:testingStartDate string,
                     :startDate string,
                     :endDate string,
                     :pricingType string,
                     :capCostOption string,
                     :flighted boolean,
                     :pricingPeriods [PricingSchedulePricingPeriod],
                     :floodlightActivityId string},
   :adBlockingOptOut boolean,
   :compatibility string,
   :tagFormats [string],
   :vpaidAdapterChoice string,
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :id string,
                                :matchType string,
                                :kind string,
                                :etag string},
   :name string,
   :placementStrategyId string,
   :campaignId string,
   :conversionDomainOverride {:conversionDomains [PlacementSingleConversionDomain]},
   :createInfo {:time string},
   :videoActiveViewOptOut boolean,
   :partnerWrappingData {:measurementPartner string,
                         :linkStatus string,
                         :wrappedTag string,
                         :tagWrappingMode string},
   :campaignIdDimensionValue {:dimensionName string,
                              :value string,
                              :id string,
                              :matchType string,
                              :kind string,
                              :etag string},
   :size {:id string,
          :width integer,
          :height integer,
          :iab boolean,
          :kind string},
   :placementGroupId string,
   :tagSetting {:additionalKeyValues string,
                :includeClickTracking boolean,
                :includeClickThroughUrls boolean,
                :keywordOption string},
   :contentCategoryId string,
   :videoSettings {:publisherSpecificationId string,
                   :obaEnabled boolean,
                   :companionSettings CompanionSetting,
                   :obaSettings ObaIcon,
                   :skippableSettings SkippableSetting,
                   :orientation string,
                   :durationSeconds integer,
                   :transcodeSettings TranscodeSetting,
                   :kind string},
   :activeStatus string,
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:dimensionName string,
                                   :value string,
                                   :id string,
                                   :matchType string,
                                   :kind string,
                                   :etag string},
   :status string,
   :sslRequired boolean,
   :id string,
   :siteIdDimensionValue {:dimensionName string,
                          :value string,
                          :id string,
                          :matchType string,
                          :kind string,
                          :etag string},
   :kind string,
   :comment string,
   :lookbackConfiguration {:clickDuration integer,
                           :postImpressionActivitiesDuration integer},
   :lastModifiedInfo {:time string},
   :publisherUpdateInfo {:time string},
   :subaccountId string,
   :paymentApproved boolean,
   :accountId string,
   :paymentSource string}
  
  Updates an existing placement."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/placements"
     #{:profileId}
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
