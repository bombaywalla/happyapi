(ns happygapi.dfareporting.accountUserProfiles
  "Campaign Manager 360 API: accountUserProfiles.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Gets one account user profile by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{profileId}/accountUserProfiles/{+id}"
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
  
  {:campaignFilter {:objectIds [string], :status string, :kind string},
   :traffickerType string,
   :email string,
   :locale string,
   :userRoleId string,
   :name string,
   :comments string,
   :userRoleFilter {:objectIds [string], :status string, :kind string},
   :userAccessType string,
   :siteFilter {:objectIds [string], :status string, :kind string},
   :active boolean,
   :id string,
   :kind string,
   :advertiserFilter {:objectIds [string], :status string, :kind string},
   :subaccountId string,
   :accountId string}
  
  Inserts a new account user profile."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/accountUserProfiles"
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
  
  Optional parameters: userRoleId, ids, searchString, pageToken, sortField, active, sortOrder, subaccountId, maxResults
  
  Retrieves a list of account user profiles, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/accountUserProfiles"
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
  
  {:campaignFilter {:objectIds [string], :status string, :kind string},
   :traffickerType string,
   :email string,
   :locale string,
   :userRoleId string,
   :name string,
   :comments string,
   :userRoleFilter {:objectIds [string], :status string, :kind string},
   :userAccessType string,
   :siteFilter {:objectIds [string], :status string, :kind string},
   :active boolean,
   :id string,
   :kind string,
   :advertiserFilter {:objectIds [string], :status string, :kind string},
   :subaccountId string,
   :accountId string}
  
  Updates an existing account user profile."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/accountUserProfiles"
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

(defn patch$
  "https://developers.google.com/doubleclick-advertisers
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Body: 
  
  {:campaignFilter {:objectIds [string], :status string, :kind string},
   :traffickerType string,
   :email string,
   :locale string,
   :userRoleId string,
   :name string,
   :comments string,
   :userRoleFilter {:objectIds [string], :status string, :kind string},
   :userAccessType string,
   :siteFilter {:objectIds [string], :status string, :kind string},
   :active boolean,
   :id string,
   :kind string,
   :advertiserFilter {:objectIds [string], :status string, :kind string},
   :subaccountId string,
   :accountId string}
  
  Updates an existing user role. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/accountUserProfiles"
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
