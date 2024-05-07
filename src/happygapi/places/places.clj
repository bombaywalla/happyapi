(ns happygapi.places.places
  "Places API (New): places.
  
  See: https://mapsplatform.google.com/maps-products/#places-section"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn autocomplete$
  "https://mapsplatform.google.com/maps-products/#places-section/v1/docs/places/autocomplete
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:locationBias {:rectangle GoogleGeoTypeViewport,
                  :circle GoogleMapsPlacesV1Circle},
   :sessionToken string,
   :inputOffset integer,
   :locationRestriction {:circle GoogleMapsPlacesV1Circle,
                         :rectangle GoogleGeoTypeViewport},
   :includedRegionCodes [string],
   :includedPrimaryTypes [string],
   :languageCode string,
   :regionCode string,
   :origin {:latitude number, :longitude number},
   :input string,
   :includeQueryPredictions boolean}
  
  Returns predictions for the given input."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/maps-platform.places"
            "https://www.googleapis.com/auth/maps-platform.places.autocomplete"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://places.googleapis.com/"
     "v1/places:autocomplete"
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
  "https://mapsplatform.google.com/maps-products/#places-section/v1/docs/places/get
  
  Required parameters: name
  
  Optional parameters: languageCode, regionCode, sessionToken
  
  Get the details of a place based on its resource name, which is a string in the `places/{place_id}` format."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/maps-platform.places"
            "https://www.googleapis.com/auth/maps-platform.places.details"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://places.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn searchText$
  "https://mapsplatform.google.com/maps-products/#places-section/v1/docs/places/searchText
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:minRating number,
   :textQuery string,
   :locationBias {:circle GoogleMapsPlacesV1Circle,
                  :rectangle GoogleGeoTypeViewport},
   :maxResultCount integer,
   :locationRestriction {:rectangle GoogleGeoTypeViewport},
   :includedType string,
   :languageCode string,
   :openNow boolean,
   :strictTypeFiltering boolean,
   :regionCode string,
   :rankPreference string,
   :evOptions {:connectorTypes [string], :minimumChargingRateKw number},
   :priceLevels [string]}
  
  Text query based place search."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/maps-platform.places"
            "https://www.googleapis.com/auth/maps-platform.places.textsearch"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://places.googleapis.com/"
     "v1/places:searchText"
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

(defn searchNearby$
  "https://mapsplatform.google.com/maps-products/#places-section/v1/docs/places/searchNearby
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:maxResultCount integer,
   :locationRestriction {:circle GoogleMapsPlacesV1Circle},
   :includedPrimaryTypes [string],
   :excludedPrimaryTypes [string],
   :excludedTypes [string],
   :includedTypes [string],
   :languageCode string,
   :regionCode string,
   :rankPreference string}
  
  Search for places near locations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/maps-platform.places"
            "https://www.googleapis.com/auth/maps-platform.places.nearbysearch"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://places.googleapis.com/"
     "v1/places:searchNearby"
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

(defn photos-getMedia$
  "https://mapsplatform.google.com/maps-products/#places-section/v1/docs/places/photos/getMedia
  
  Required parameters: name
  
  Optional parameters: maxHeightPx, skipHttpRedirect, maxWidthPx
  
  Get a photo media with a photo reference string."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/maps-platform.places"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://places.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
