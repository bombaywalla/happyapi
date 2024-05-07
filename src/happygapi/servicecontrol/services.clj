(ns happygapi.servicecontrol.services
  "Service Control API: services.
  Provides admission control and telemetry reporting for services integrated with Service Infrastructure. 
  See: https://cloud.google.com/service-infrastructure/docs"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn check$
  "https://cloud.google.com/service-infrastructure/docs
  
  Required parameters: serviceName
  
  Optional parameters: none
  
  Body: 
  
  {:serviceConfigId string,
   :attributes {:origin Peer,
                :source Peer,
                :destination Peer,
                :request Request,
                :response Response,
                :resource Resource,
                :api Api,
                :extensions [{}]},
   :resources [{:name string,
                :type string,
                :permission string,
                :container string,
                :location string}],
   :flags string}
  
  Private Preview. This feature is only available for approved services. This method provides admission control for services that are integrated with [Service Infrastructure](https://cloud.google.com/service-infrastructure). It checks whether an operation should be allowed based on the service configuration and relevant policies. It must be called before the operation is executed. For more information, see [Admission Control](https://cloud.google.com/service-infrastructure/docs/admission-control). NOTE: The admission control has an expected policy propagation delay of 60s. The caller **must** not depend on the most recent policy changes. NOTE: The admission control has a hard limit of 1 referenced resources per call. If an operation refers to more than 1 resources, the caller must call the Check method multiple times. This method requires the `servicemanagement.services.check` permission on the specified service. For more information, see [Service Control API Access Control](https://cloud.google.com/service-infrastructure/docs/service-control/access-control)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/servicecontrol"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:serviceName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicecontrol.googleapis.com/"
     "v2/services/{serviceName}:check"
     #{:serviceName}
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

(defn report$
  "https://cloud.google.com/service-infrastructure/docs
  
  Required parameters: serviceName
  
  Optional parameters: none
  
  Body: 
  
  {:serviceConfigId string,
   :operations [{:origin Peer,
                 :source Peer,
                 :destination Peer,
                 :request Request,
                 :response Response,
                 :resource Resource,
                 :api Api,
                 :extensions [{}]}]}
  
  Private Preview. This feature is only available for approved services. This method provides telemetry reporting for services that are integrated with [Service Infrastructure](https://cloud.google.com/service-infrastructure). It reports a list of operations that have occurred on a service. It must be called after the operations have been executed. For more information, see [Telemetry Reporting](https://cloud.google.com/service-infrastructure/docs/telemetry-reporting). NOTE: The telemetry reporting has a hard limit of 1000 operations and 1MB per Report call. It is recommended to have no more than 100 operations per call. This method requires the `servicemanagement.services.report` permission on the specified service. For more information, see [Service Control API Access Control](https://cloud.google.com/service-infrastructure/docs/service-control/access-control)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/servicecontrol"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:serviceName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicecontrol.googleapis.com/"
     "v2/services/{serviceName}:report"
     #{:serviceName}
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
