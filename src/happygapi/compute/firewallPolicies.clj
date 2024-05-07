(ns happygapi.compute.firewallPolicies
  "Compute Engine API: firewallPolicies.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/products/compute"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn cloneRules$
  "https://cloud.google.com/products/compute/v1/docs/firewallPolicies/cloneRules
  
  Required parameters: firewallPolicy
  
  Optional parameters: requestId, sourceFirewallPolicy
  
  Copies rules to the specified firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "locations/global/firewallPolicies/{firewallPolicy}/cloneRules"
     #{:firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn removeRule$
  "https://cloud.google.com/products/compute/v1/docs/firewallPolicies/removeRule
  
  Required parameters: firewallPolicy
  
  Optional parameters: priority, requestId
  
  Deletes a rule of the specified priority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "locations/global/firewallPolicies/{firewallPolicy}/removeRule"
     #{:firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/products/compute/v1/docs/firewallPolicies/get
  
  Required parameters: firewallPolicy
  
  Optional parameters: none
  
  Returns the specified firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:firewallPolicy})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "locations/global/firewallPolicies/{firewallPolicy}"
     #{:firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/products/compute/v1/docs/firewallPolicies/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :rules [Rule],
            :etag string},
   :bindings [{:role string,
               :members [string],
               :condition Expr,
               :bindingId string}],
   :etag string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "locations/global/firewallPolicies/{resource}/setIamPolicy"
     #{:resource}
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

(defn insert$
  "https://cloud.google.com/products/compute/v1/docs/firewallPolicies/insert
  
  Required parameters: none
  
  Optional parameters: parentId, requestId
  
  Body: 
  
  {:description string,
   :ruleTupleCount integer,
   :parent string,
   :creationTimestamp string,
   :displayName string,
   :name string,
   :selfLink string,
   :associations [{:name string,
                   :attachmentTarget string,
                   :firewallPolicyId string,
                   :shortName string,
                   :displayName string}],
   :rules [{:description string,
            :securityProfileGroup string,
            :ruleTupleCount integer,
            :disabled boolean,
            :ruleName string,
            :tlsInspect boolean,
            :targetSecureTags [FirewallPolicyRuleSecureTag],
            :enableLogging boolean,
            :priority integer,
            :kind string,
            :targetResources [string],
            :targetServiceAccounts [string],
            :action string,
            :direction string,
            :match FirewallPolicyRuleMatcher}],
   :region string,
   :shortName string,
   :selfLinkWithId string,
   :id string,
   :kind string,
   :fingerprint string}
  
  Creates a new policy in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "locations/global/firewallPolicies"
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

(defn patch$
  "https://cloud.google.com/products/compute/v1/docs/firewallPolicies/patch
  
  Required parameters: firewallPolicy
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :ruleTupleCount integer,
   :parent string,
   :creationTimestamp string,
   :displayName string,
   :name string,
   :selfLink string,
   :associations [{:name string,
                   :attachmentTarget string,
                   :firewallPolicyId string,
                   :shortName string,
                   :displayName string}],
   :rules [{:description string,
            :securityProfileGroup string,
            :ruleTupleCount integer,
            :disabled boolean,
            :ruleName string,
            :tlsInspect boolean,
            :targetSecureTags [FirewallPolicyRuleSecureTag],
            :enableLogging boolean,
            :priority integer,
            :kind string,
            :targetResources [string],
            :targetServiceAccounts [string],
            :action string,
            :direction string,
            :match FirewallPolicyRuleMatcher}],
   :region string,
   :shortName string,
   :selfLinkWithId string,
   :id string,
   :kind string,
   :fingerprint string}
  
  Patches the specified policy with the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:firewallPolicy})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "locations/global/firewallPolicies/{firewallPolicy}"
     #{:firewallPolicy}
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

(defn testIamPermissions$
  "https://cloud.google.com/products/compute/v1/docs/firewallPolicies/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "locations/global/firewallPolicies/{resource}/testIamPermissions"
     #{:resource}
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

(defn move$
  "https://cloud.google.com/products/compute/v1/docs/firewallPolicies/move
  
  Required parameters: firewallPolicy
  
  Optional parameters: parentId, requestId
  
  Moves the specified firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "locations/global/firewallPolicies/{firewallPolicy}/move"
     #{:firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/products/compute/v1/docs/firewallPolicies/delete
  
  Required parameters: firewallPolicy
  
  Optional parameters: requestId
  
  Deletes the specified policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:firewallPolicy})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "locations/global/firewallPolicies/{firewallPolicy}"
     #{:firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn removeAssociation$
  "https://cloud.google.com/products/compute/v1/docs/firewallPolicies/removeAssociation
  
  Required parameters: firewallPolicy
  
  Optional parameters: name, requestId
  
  Removes an association for the specified firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "locations/global/firewallPolicies/{firewallPolicy}/removeAssociation"
     #{:firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://cloud.google.com/products/compute/v1/docs/firewallPolicies/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: optionsRequestedPolicyVersion
  
  Gets the access control policy for a resource. May be empty if no such policy or resource exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "locations/global/firewallPolicies/{resource}/getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patchRule$
  "https://cloud.google.com/products/compute/v1/docs/firewallPolicies/patchRule
  
  Required parameters: firewallPolicy
  
  Optional parameters: priority, requestId
  
  Body: 
  
  {:description string,
   :securityProfileGroup string,
   :ruleTupleCount integer,
   :disabled boolean,
   :ruleName string,
   :tlsInspect boolean,
   :targetSecureTags [{:name string, :state string}],
   :enableLogging boolean,
   :priority integer,
   :kind string,
   :targetResources [string],
   :targetServiceAccounts [string],
   :action string,
   :direction string,
   :match {:destFqdns [string],
           :srcThreatIntelligences [string],
           :srcSecureTags [FirewallPolicyRuleSecureTag],
           :srcRegionCodes [string],
           :srcFqdns [string],
           :destRegionCodes [string],
           :layer4Configs [FirewallPolicyRuleMatcherLayer4Config],
           :srcAddressGroups [string],
           :destIpRanges [string],
           :destThreatIntelligences [string],
           :destAddressGroups [string],
           :srcIpRanges [string]}}
  
  Patches a rule of the specified priority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "locations/global/firewallPolicies/{firewallPolicy}/patchRule"
     #{:firewallPolicy}
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

(defn addRule$
  "https://cloud.google.com/products/compute/v1/docs/firewallPolicies/addRule
  
  Required parameters: firewallPolicy
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :securityProfileGroup string,
   :ruleTupleCount integer,
   :disabled boolean,
   :ruleName string,
   :tlsInspect boolean,
   :targetSecureTags [{:name string, :state string}],
   :enableLogging boolean,
   :priority integer,
   :kind string,
   :targetResources [string],
   :targetServiceAccounts [string],
   :action string,
   :direction string,
   :match {:destFqdns [string],
           :srcThreatIntelligences [string],
           :srcSecureTags [FirewallPolicyRuleSecureTag],
           :srcRegionCodes [string],
           :srcFqdns [string],
           :destRegionCodes [string],
           :layer4Configs [FirewallPolicyRuleMatcherLayer4Config],
           :srcAddressGroups [string],
           :destIpRanges [string],
           :destThreatIntelligences [string],
           :destAddressGroups [string],
           :srcIpRanges [string]}}
  
  Inserts a rule into a firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "locations/global/firewallPolicies/{firewallPolicy}/addRule"
     #{:firewallPolicy}
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

(defn list$
  "https://cloud.google.com/products/compute/v1/docs/firewallPolicies/list
  
  Required parameters: none
  
  Optional parameters: filter, maxResults, orderBy, pageToken, parentId, returnPartialSuccess
  
  Lists all the policies that have been configured for the specified folder or organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "locations/global/firewallPolicies"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getRule$
  "https://cloud.google.com/products/compute/v1/docs/firewallPolicies/getRule
  
  Required parameters: firewallPolicy
  
  Optional parameters: priority
  
  Gets a rule of the specified priority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:firewallPolicy})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "locations/global/firewallPolicies/{firewallPolicy}/getRule"
     #{:firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn addAssociation$
  "https://cloud.google.com/products/compute/v1/docs/firewallPolicies/addAssociation
  
  Required parameters: firewallPolicy
  
  Optional parameters: replaceExistingAssociation, requestId
  
  Body: 
  
  {:name string,
   :attachmentTarget string,
   :firewallPolicyId string,
   :shortName string,
   :displayName string}
  
  Inserts an association for the specified firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "locations/global/firewallPolicies/{firewallPolicy}/addAssociation"
     #{:firewallPolicy}
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

(defn getAssociation$
  "https://cloud.google.com/products/compute/v1/docs/firewallPolicies/getAssociation
  
  Required parameters: firewallPolicy
  
  Optional parameters: name
  
  Gets an association with the specified name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:firewallPolicy})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "locations/global/firewallPolicies/{firewallPolicy}/getAssociation"
     #{:firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listAssociations$
  "https://cloud.google.com/products/compute/v1/docs/firewallPolicies/listAssociations
  
  Required parameters: none
  
  Optional parameters: targetResource
  
  Lists associations of a specified target, i.e., organization or folder."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "locations/global/firewallPolicies/listAssociations"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
