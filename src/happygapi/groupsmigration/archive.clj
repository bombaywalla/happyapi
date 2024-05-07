(ns happygapi.groupsmigration.archive
  "Groups Migration API: archive.
  The Groups Migration API allows domain administrators to archive emails into Google groups.
  See: https://developers.google.com/admin-sdk/groups-migration/v1/guides/overview"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/admin-sdk/groups-migration/v1/guides/overview
  
  Required parameters: groupId
  
  Optional parameters: none
  
  Inserts a new mail into the archive of the Google group."
  {:scopes ["https://www.googleapis.com/auth/apps.groups.migration"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:groupId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://groupsmigration.googleapis.com/"
     "groups/v1/groups/{groupId}/archive"
     #{:groupId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
