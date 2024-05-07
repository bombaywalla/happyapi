(ns happygapi.sasportal.installer
  "SAS Portal API: installer.
  
  See: https://developers.google.com/spectrum-access-system/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn validate$
  "https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/installer/validate
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:secret string, :encodedSecret string, :installerId string}
  
  Validates the identity of a Certified Professional Installer (CPI)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/installer:validate"
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

(defn generateSecret$
  "https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/installer/generateSecret
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Generates a secret to be used with the ValidateInstaller."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sasportal"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/installer:generateSecret"
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
