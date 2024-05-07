(ns happygapi.essentialcontacts.organizations
  "Essential Contacts API: organizations.
  
  See: https://cloud.google.com/resource-manager/docs/managing-notification-contacts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn contacts-list$
  "https://cloud.google.com/resource-manager/docs/managing-notification-contacts
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists the contacts that have been set on a resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://essentialcontacts.googleapis.com/"
     "v1/{+parent}/contacts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn contacts-compute$
  "https://cloud.google.com/resource-manager/docs/managing-notification-contacts
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, notificationCategories
  
  Lists all contacts for the resource that are subscribed to the specified notification categories, including contacts inherited from any parent resources."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://essentialcontacts.googleapis.com/"
     "v1/{+parent}/contacts:compute"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn contacts-patch$
  "https://cloud.google.com/resource-manager/docs/managing-notification-contacts
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:languageTag string,
   :validateTime string,
   :validationState string,
   :name string,
   :notificationCategorySubscriptions [string],
   :email string}
  
  Updates a contact. Note: A contact's email address cannot be changed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://essentialcontacts.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn contacts-sendTestMessage$
  "https://cloud.google.com/resource-manager/docs/managing-notification-contacts
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:contacts [string], :notificationCategory string}
  
  Allows a contact admin to send a test message to contact to verify that it has been configured correctly."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://essentialcontacts.googleapis.com/"
     "v1/{+resource}/contacts:sendTestMessage"
     #{:resource}
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

(defn contacts-delete$
  "https://cloud.google.com/resource-manager/docs/managing-notification-contacts
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a contact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://essentialcontacts.googleapis.com/"
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

(defn contacts-create$
  "https://cloud.google.com/resource-manager/docs/managing-notification-contacts
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:languageTag string,
   :validateTime string,
   :validationState string,
   :name string,
   :notificationCategorySubscriptions [string],
   :email string}
  
  Adds a new contact for a resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://essentialcontacts.googleapis.com/"
     "v1/{+parent}/contacts"
     #{:parent}
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

(defn contacts-get$
  "https://cloud.google.com/resource-manager/docs/managing-notification-contacts
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a single contact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://essentialcontacts.googleapis.com/"
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
