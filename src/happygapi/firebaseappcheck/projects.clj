(ns happygapi.firebaseappcheck.projects
  "Firebase App Check API: projects.
  Firebase App Check works alongside other Firebase services to help protect your backend resources from abuse, such as billing fraud or phishing.
  See: https://firebase.google.com/docs/app-check"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn apps-generateAppAttestChallenge$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Generates a challenge that protects the integrity of an immediately following call to ExchangeAppAttestAttestation or ExchangeAppAttestAssertion. A challenge should not be reused for multiple calls."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+app}:generateAppAttestChallenge"
     #{:app}
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

(defn apps-exchangeDeviceCheckToken$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {:deviceToken string, :limitedUse boolean}
  
  Accepts a [`device_token`](https://developer.apple.com/documentation/devicecheck/dcdevice) issued by DeviceCheck, and attempts to validate it with Apple. If valid, returns an AppCheckToken."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+app}:exchangeDeviceCheckToken"
     #{:app}
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

(defn apps-exchangeDebugToken$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {:debugToken string, :limitedUse boolean}
  
  Validates a debug token secret that you have previously created using CreateDebugToken. If valid, returns an AppCheckToken. Note that a restrictive quota is enforced on this method to prevent accidental exposure of the app to abuse."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+app}:exchangeDebugToken"
     #{:app}
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

(defn apps-exchangePlayIntegrityToken$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {:playIntegrityToken string, :limitedUse boolean}
  
  Validates an [integrity verdict response token from Play Integrity](https://developer.android.com/google/play/integrity/verdict#decrypt-verify). If valid, returns an AppCheckToken."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+app}:exchangePlayIntegrityToken"
     #{:app}
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

(defn apps-generatePlayIntegrityChallenge$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Generates a challenge that protects the integrity of an immediately following integrity verdict request to the Play Integrity API. The next call to ExchangePlayIntegrityToken using the resulting integrity token will verify the presence and validity of the challenge. A challenge should not be reused for multiple calls."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+app}:generatePlayIntegrityChallenge"
     #{:app}
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

(defn apps-exchangeRecaptchaV3Token$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {:limitedUse boolean, :recaptchaV3Token string}
  
  Validates a [reCAPTCHA v3 response token](https://developers.google.com/recaptcha/docs/v3). If valid, returns an AppCheckToken."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+app}:exchangeRecaptchaV3Token"
     #{:app}
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

(defn apps-exchangeSafetyNetToken$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {:safetyNetToken string}
  
  Validates a [SafetyNet token](https://developer.android.com/training/safetynet/attestation#request-attestation-step). If valid, returns an AppCheckToken."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+app}:exchangeSafetyNetToken"
     #{:app}
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

(defn apps-exchangeCustomToken$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {:customToken string, :limitedUse boolean}
  
  Validates a custom token signed using your project's Admin SDK service account credentials. If valid, returns an AppCheckToken."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+app}:exchangeCustomToken"
     #{:app}
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

(defn apps-exchangeAppAttestAssertion$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {:challenge string,
   :artifact string,
   :assertion string,
   :limitedUse boolean}
  
  Accepts an App Attest assertion and an artifact previously obtained from ExchangeAppAttestAttestation and verifies those with Apple. If valid, returns an AppCheckToken."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+app}:exchangeAppAttestAssertion"
     #{:app}
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

(defn apps-exchangeAppAttestAttestation$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {:challenge string,
   :keyId string,
   :limitedUse boolean,
   :attestationStatement string}
  
  Accepts an App Attest CBOR attestation and verifies it with Apple using your preconfigured team and bundle IDs. If valid, returns an attestation artifact that can later be exchanged for an AppCheckToken using ExchangeAppAttestAssertion. For convenience and performance, this method's response object will also contain an AppCheckToken (if the verification is successful)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+app}:exchangeAppAttestAttestation"
     #{:app}
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

(defn apps-exchangeRecaptchaEnterpriseToken$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {:limitedUse boolean, :recaptchaEnterpriseToken string}
  
  Validates a [reCAPTCHA Enterprise response token](https://cloud.google.com/recaptcha-enterprise/docs/create-assessment#retrieve_token). If valid, returns an AppCheckToken."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+app}:exchangeRecaptchaEnterpriseToken"
     #{:app}
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

(defn apps-recaptchaEnterpriseConfig-patch$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:tokenTtl string, :siteKey string, :name string}
  
  Updates the RecaptchaEnterpriseConfig for the specified app. While this configuration is incomplete or invalid, the app will be unable to exchange reCAPTCHA Enterprise tokens for App Check tokens."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
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

(defn apps-recaptchaEnterpriseConfig-get$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the RecaptchaEnterpriseConfig for the specified app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
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

(defn apps-recaptchaEnterpriseConfig-batchGet$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: parent
  
  Optional parameters: names
  
  Atomically gets the RecaptchaEnterpriseConfigs for the specified list of apps."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+parent}/apps/-/recaptchaEnterpriseConfig:batchGet"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-appAttestConfig-batchGet$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: parent
  
  Optional parameters: names
  
  Atomically gets the AppAttestConfigs for the specified list of apps."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+parent}/apps/-/appAttestConfig:batchGet"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-appAttestConfig-get$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the AppAttestConfig for the specified app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
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

(defn apps-appAttestConfig-patch$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :tokenTtl string}
  
  Updates the AppAttestConfig for the specified app. While this configuration is incomplete or invalid, the app will be unable to exchange AppAttest tokens for App Check tokens."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
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

(defn apps-playIntegrityConfig-batchGet$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: parent
  
  Optional parameters: names
  
  Atomically gets the PlayIntegrityConfigs for the specified list of apps."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+parent}/apps/-/playIntegrityConfig:batchGet"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-playIntegrityConfig-patch$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:tokenTtl string, :name string}
  
  Updates the PlayIntegrityConfig for the specified app. While this configuration is incomplete or invalid, the app will be unable to exchange Play Integrity tokens for App Check tokens."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
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

(defn apps-playIntegrityConfig-get$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the PlayIntegrityConfig for the specified app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
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

(defn apps-recaptchaV3Config-batchGet$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: parent
  
  Optional parameters: names
  
  Atomically gets the RecaptchaV3Configs for the specified list of apps. For security reasons, the `site_secret` field is never populated in the response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+parent}/apps/-/recaptchaV3Config:batchGet"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-recaptchaV3Config-get$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the RecaptchaV3Config for the specified app. For security reasons, the `site_secret` field is never populated in the response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
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

(defn apps-recaptchaV3Config-patch$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :siteSecret string,
   :tokenTtl string,
   :siteSecretSet boolean}
  
  Updates the RecaptchaV3Config for the specified app. While this configuration is incomplete or invalid, the app will be unable to exchange reCAPTCHA tokens for App Check tokens. For security reasons, the `site_secret` field is never populated in the response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
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

(defn apps-debugTokens-patch$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:updateTime string, :name string, :token string, :displayName string}
  
  Updates the specified DebugToken. For security reasons, the `token` field cannot be updated, nor will it be populated in the response, but you can revoke the debug token using DeleteDebugToken."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
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

(defn apps-debugTokens-create$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:updateTime string, :name string, :token string, :displayName string}
  
  Creates a new DebugToken for the specified app. For security reasons, after the creation operation completes, the `token` field cannot be updated or retrieved, but you can revoke the debug token using DeleteDebugToken. Each app can have a maximum of 20 debug tokens."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+parent}/debugTokens"
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

(defn apps-debugTokens-delete$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified DebugToken. A deleted debug token cannot be used to exchange for an App Check token. Use this method when you suspect the secret `token` has been compromised or when you no longer need the debug token."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
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

(defn apps-debugTokens-list$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all DebugTokens for the specified app. For security reasons, the `token` field is never populated in the response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+parent}/debugTokens"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-debugTokens-get$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified DebugToken. For security reasons, the `token` field is never populated in the response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
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

(defn apps-safetyNetConfig-batchGet$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: parent
  
  Optional parameters: names
  
  Atomically gets the SafetyNetConfigs for the specified list of apps."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+parent}/apps/-/safetyNetConfig:batchGet"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-safetyNetConfig-get$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the SafetyNetConfig for the specified app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
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

(defn apps-safetyNetConfig-patch$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:tokenTtl string, :name string}
  
  Updates the SafetyNetConfig for the specified app. While this configuration is incomplete or invalid, the app will be unable to exchange SafetyNet tokens for App Check tokens."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
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

(defn apps-deviceCheckConfig-get$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the DeviceCheckConfig for the specified app. For security reasons, the `private_key` field is never populated in the response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
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

(defn apps-deviceCheckConfig-batchGet$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: parent
  
  Optional parameters: names
  
  Atomically gets the DeviceCheckConfigs for the specified list of apps. For security reasons, the `private_key` field is never populated in the response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+parent}/apps/-/deviceCheckConfig:batchGet"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-deviceCheckConfig-patch$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :keyId string,
   :privateKeySet boolean,
   :tokenTtl string,
   :privateKey string}
  
  Updates the DeviceCheckConfig for the specified app. While this configuration is incomplete or invalid, the app will be unable to exchange DeviceCheck tokens for App Check tokens. For security reasons, the `private_key` field is never populated in the response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
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

(defn services-batchUpdate$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:updateMask string,
               :service GoogleFirebaseAppcheckV1Service}],
   :updateMask string}
  
  Atomically updates the specified Service configurations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+parent}/services:batchUpdate"
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

(defn services-get$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the Service configuration for the specified service name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
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

(defn services-patch$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:enforcementMode string, :name string}
  
  Updates the specified Service configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
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

(defn services-list$
  "https://firebase.google.com/docs/app-check
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all Service configurations for the specified project. Only Services which were explicitly configured using UpdateService or BatchUpdateServices will be returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1/{+parent}/services"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
