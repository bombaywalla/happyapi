(ns happyapi.oauth2.credentials
  "Reference for how to manage credentials.
  For a web app, you should implement something like this but use your database for credential storage.
  secret, scopes, fetch, save have default implementations that you can replace with init!"
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(set! *warn-on-reflection* true)

;; TODO: Nope, this needs to be provider specific (at least!)

(def *credentials-cache
  (atom nil))

(defn read-credentials [user]
  (or (get @*credentials-cache user)
      (let [credentials-file (io/file "tokens" (str user ".edn"))]
        (when (.exists credentials-file)
          (edn/read-string (slurp credentials-file))))))

(defn delete-credentials [user]
  (swap! *credentials-cache dissoc user)
  (.delete (io/file (io/file "tokens")
                    (str user ".edn"))))

(defn write-credentials [user credentials]
  (swap! *credentials-cache assoc user credentials)
  (spit (io/file (doto (io/file "tokens") (.mkdirs))
                 (str user ".edn"))
        credentials))

(defn save-credentials [user new-credentials]
  (when (not= @*credentials-cache new-credentials)
    (if new-credentials
      (write-credentials user new-credentials)
      (delete-credentials user))))
