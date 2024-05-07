(ns happygapi.cloudbilling.projects
  "Cloud Billing API: projects.
  Allows developers to manage billing for their Google Cloud Platform projects programmatically.
  See: https://cloud.google.com/billing/docs/apis"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getBillingInfo$
  "https://cloud.google.com/billing/docs/reference/rest/v1/projects/getBillingInfo
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the billing information for a project. The current authenticated user must have the `resourcemanager.projects.get` permission for the project, which can be granted by assigning the [Project Viewer](https://cloud.google.com/iam/docs/understanding-roles#predefined_roles) role."
  {:scopes ["https://www.googleapis.com/auth/cloud-billing"
            "https://www.googleapis.com/auth/cloud-billing.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbilling.googleapis.com/"
     "v1/{+name}/billingInfo"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updateBillingInfo$
  "https://cloud.google.com/billing/docs/reference/rest/v1/projects/updateBillingInfo
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :projectId string,
   :billingAccountName string,
   :billingEnabled boolean}
  
  Sets or updates the billing account associated with a project. You specify the new billing account by setting the `billing_account_name` in the `ProjectBillingInfo` resource to the resource name of a billing account. Associating a project with an open billing account enables billing on the project and allows charges for resource usage. If the project already had a billing account, this method changes the billing account used for resource usage charges. *Note:* Incurred charges that have not yet been reported in the transaction history of the Google Cloud Console might be billed to the new billing account, even if the charge occurred before the new billing account was assigned to the project. The current authenticated user must have ownership privileges for both the [project](https://cloud.google.com/docs/permissions-overview#h.bgs0oxofvnoo ) and the [billing account](https://cloud.google.com/billing/docs/how-to/billing-access). You can disable billing on the project by setting the `billing_account_name` field to empty. This action disassociates the current billing account from the project. Any billable activity of your in-use services will stop, and your application could stop functioning as expected. Any unbilled charges to date will be billed to the previously associated account. The current authenticated user must be either an owner of the project or an owner of the billing account for the project. Note that associating a project with a *closed* billing account will have much the same effect as disabling billing on the project: any paid resources used by the project will be shut down. Thus, unless you wish to disable billing, you should always call this method with the name of an *open* billing account."
  {:scopes ["https://www.googleapis.com/auth/cloud-billing"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://cloudbilling.googleapis.com/"
     "v1/{+name}/billingInfo"
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
