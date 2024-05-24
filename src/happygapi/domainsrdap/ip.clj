(ns happygapi.domainsrdap.ip
  "Domains RDAP API: ip.
  Read-only public API that lets users search for information about domain names.
  See: https://developers.google.com/domains/rdap/docs/reference/rest/v1/ip"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/domains/rdap/api/reference/rest/v1/ip/get
  
  Required parameters: ipId, ipId1
  
  Optional parameters: none
  
  The RDAP API recognizes this command from the RDAP specification but does not support it. The response is a formatted 501 error."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:ipId1 :ipId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domainsrdap.googleapis.com/"
     "v1/ip/{ipId}/{ipId1}"
     #{:ipId1 :ipId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
