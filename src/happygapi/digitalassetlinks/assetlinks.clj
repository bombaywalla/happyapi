(ns happygapi.digitalassetlinks.assetlinks
  "Digital Asset Links API: assetlinks.
  Discovers relationships between online assets such as websites or mobile apps.
  See: https://developers.google.com/digital-asset-links/docs/reference/rest/v1/assetlinks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn check$
  "https://developers.google.com/digital-asset-links/api/reference/rest/v1/assetlinks/check
  
  Required parameters: none
  
  Optional parameters: source.web.site, source.androidApp.packageName, source.androidApp.certificate.sha256Fingerprint, relation, target.web.site, target.androidApp.packageName, target.androidApp.certificate.sha256Fingerprint
  
  Determines whether the specified (directional) relationship exists between the specified source and target assets. The relation describes the intent of the link between the two assets as claimed by the source asset. An example for such relationships is the delegation of privileges or permissions. This command is most often used by infrastructure systems to check preconditions for an action. For example, a client may want to know if it is OK to send a web URL to a particular mobile app instead. The client can check for the relevant asset link from the website to the mobile app to decide if the operation should be allowed. A note about security: if you specify a secure asset as the source, such as an HTTPS website or an Android app, the API will ensure that any statements used to generate the response have been made in a secure way by the owner of that asset. Conversely, if the source asset is an insecure HTTP website (that is, the URL starts with `http://` instead of `https://`), the API cannot verify its statements securely, and it is not possible to ensure that the website's statements have not been altered by a third party. For more information, see the [Digital Asset Links technical design specification](https://github.com/google/digitalassetlinks/blob/master/well-known/details.md)."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://digitalassetlinks.googleapis.com/"
     "v1/assetlinks:check"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn bulkCheck$
  "https://developers.google.com/digital-asset-links/api/reference/rest/v1/assetlinks/bulkCheck
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:statements [{:source Asset, :relation string, :target Asset}],
   :defaultSource {:web WebAsset, :androidApp AndroidAppAsset},
   :defaultRelation string,
   :defaultTarget {:web WebAsset, :androidApp AndroidAppAsset},
   :allowGoogleInternalDataSources boolean,
   :skipCacheLookup boolean}
  
  Send a bundle of statement checks in a single RPC to minimize latency and service load. Statements need not be all for the same source and/or target. We recommend using this method when you need to check more than one statement in a short period of time."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://digitalassetlinks.googleapis.com/"
     "v1/assetlinks:bulkCheck"
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
