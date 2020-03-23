(ns happy.oauth2-test
  (:require [cheshire.core :as json]
            [clojure.test :refer [deftest is testing]]
            [happy.oauth2 :as oauth2]
            [happy.oauth2-capture-redirect :as r]))

(deftest oauth2-test
  (let [config (-> (slurp "secret.json")
                   (json/parse-string true)
                   (:installed)
                   (assoc :redirect_uri "http://localhost:8888"))
        scopes ["https://www.googleapis.com/auth/spreadsheets"
                "https://www.googleapis.com/auth/drive"]]
    (clojure.java.browse/browse-url
      (oauth2/set-authorization-parameters config scopes nil))
    (let [code (r/wait-for-redirect config)]
      (is code)
      (let [credentials (oauth2/exchange-code config code)]
        (is credentials)
        (let [new-credentials (oauth2/refresh-token config credentials)]
          (is new-credentials)
          (oauth2/revoke-token new-credentials))))))
