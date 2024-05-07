(ns happygapi.language.documents
  "Cloud Natural Language API: documents.
  Provides natural language understanding technologies, such as sentiment analysis, entity recognition, entity sentiment analysis, and other text annotations, to developers.
  See: https://cloud.google.com/natural-language/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn analyzeEntities$
  "https://cloud.google.com/natural-language/reference/rest/v2/documents/analyzeEntities
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:encodingType string,
   :document {:content string,
              :type string,
              :languageCode string,
              :gcsContentUri string}}
  
  Finds named entities (currently proper names and common nouns) in the text along with entity types, probability, mentions for each entity, and other properties."
  {:scopes ["https://www.googleapis.com/auth/cloud-language"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://language.googleapis.com/"
     "v2/documents:analyzeEntities"
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

(defn analyzeSentiment$
  "https://cloud.google.com/natural-language/reference/rest/v2/documents/analyzeSentiment
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:encodingType string,
   :document {:content string,
              :type string,
              :languageCode string,
              :gcsContentUri string}}
  
  Analyzes the sentiment of the provided text."
  {:scopes ["https://www.googleapis.com/auth/cloud-language"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://language.googleapis.com/"
     "v2/documents:analyzeSentiment"
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

(defn moderateText$
  "https://cloud.google.com/natural-language/reference/rest/v2/documents/moderateText
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:document {:content string,
              :type string,
              :languageCode string,
              :gcsContentUri string}}
  
  Moderates a document for harmful and sensitive categories."
  {:scopes ["https://www.googleapis.com/auth/cloud-language"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://language.googleapis.com/"
     "v2/documents:moderateText"
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

(defn classifyText$
  "https://cloud.google.com/natural-language/reference/rest/v2/documents/classifyText
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:document {:content string,
              :type string,
              :languageCode string,
              :gcsContentUri string}}
  
  Classifies a document into categories."
  {:scopes ["https://www.googleapis.com/auth/cloud-language"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://language.googleapis.com/"
     "v2/documents:classifyText"
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

(defn annotateText$
  "https://cloud.google.com/natural-language/reference/rest/v2/documents/annotateText
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:encodingType string,
   :document {:content string,
              :type string,
              :languageCode string,
              :gcsContentUri string},
   :features {:extractDocumentSentiment boolean,
              :moderateText boolean,
              :extractEntities boolean,
              :classifyText boolean}}
  
  A convenience method that provides all features in one call."
  {:scopes ["https://www.googleapis.com/auth/cloud-language"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://language.googleapis.com/"
     "v2/documents:annotateText"
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
