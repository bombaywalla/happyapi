(ns happygapi.speech.speech
  "Cloud Speech-to-Text API: speech.
  Converts audio to text by applying powerful neural network models.
  See: https://cloud.google.com/speech-to-text/docs/quickstart-protocoldocs/reference/rest/v1/speech"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn recognize$
  "https://cloud.google.com/speech-to-text/docs/quickstart-protocolapi/reference/rest/v1/speech/recognize
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:config {:encoding string,
            :maxAlternatives integer,
            :enableAutomaticPunctuation boolean,
            :enableSpokenPunctuation boolean,
            :enableWordTimeOffsets boolean,
            :alternativeLanguageCodes [string],
            :enableSeparateRecognitionPerChannel boolean,
            :adaptation SpeechAdaptation,
            :speechContexts [SpeechContext],
            :enableSpokenEmojis boolean,
            :sampleRateHertz integer,
            :transcriptNormalization TranscriptNormalization,
            :languageCode string,
            :profanityFilter boolean,
            :enableWordConfidence boolean,
            :audioChannelCount integer,
            :metadata RecognitionMetadata,
            :useEnhanced boolean,
            :diarizationConfig SpeakerDiarizationConfig,
            :model string},
   :audio {:content string, :uri string}}
  
  Performs synchronous speech recognition: receive results after all audio has been sent and processed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://speech.googleapis.com/"
     "v1/speech:recognize"
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

(defn longrunningrecognize$
  "https://cloud.google.com/speech-to-text/docs/quickstart-protocolapi/reference/rest/v1/speech/longrunningrecognize
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:config {:encoding string,
            :maxAlternatives integer,
            :enableAutomaticPunctuation boolean,
            :enableSpokenPunctuation boolean,
            :enableWordTimeOffsets boolean,
            :alternativeLanguageCodes [string],
            :enableSeparateRecognitionPerChannel boolean,
            :adaptation SpeechAdaptation,
            :speechContexts [SpeechContext],
            :enableSpokenEmojis boolean,
            :sampleRateHertz integer,
            :transcriptNormalization TranscriptNormalization,
            :languageCode string,
            :profanityFilter boolean,
            :enableWordConfidence boolean,
            :audioChannelCount integer,
            :metadata RecognitionMetadata,
            :useEnhanced boolean,
            :diarizationConfig SpeakerDiarizationConfig,
            :model string},
   :audio {:content string, :uri string},
   :outputConfig {:gcsUri string}}
  
  Performs asynchronous speech recognition: receive results via the google.longrunning.Operations interface. Returns either an `Operation.error` or an `Operation.response` which contains a `LongRunningRecognizeResponse` message. For more information on asynchronous speech recognition, see the [how-to](https://cloud.google.com/speech-to-text/docs/async-recognize)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://speech.googleapis.com/"
     "v1/speech:longrunningrecognize"
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
