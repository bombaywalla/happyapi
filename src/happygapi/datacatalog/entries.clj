(ns happygapi.datacatalog.entries
  "Google Cloud Data Catalog API: entries.
  A fully managed and highly scalable data discovery and metadata management service. 
  See: https://cloud.google.com/data-catalog/docs/docs/reference/rest/v1/entries"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn lookup$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/entries/lookup
  
  Required parameters: none
  
  Optional parameters: linkedResource, sqlResource, fullyQualifiedName, project, location
  
  Gets an entry by its target resource name. The resource name comes from the source Google Cloud Platform service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/entries:lookup"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
