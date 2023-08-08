/*
 * EcoStruxure™ Energy & Sustainability Scoring API
 * # Overview  EcoStruxure™ Energy and Sustainability Scoring API allows customers to configure buildings that need benchmarking by calculating performance scores using the building energy and sustainability data.  ## API overview and usage  This API enables the following operations:  **Sites** * Retrieve all sites to which the connected user has access, along site metadata needed for performance scores calculation (e.g. gross area, building occupants, operating hours, etc.)  **Performance Scores** * Allow the user to request site for performance score calculation  * Read current and historical scores for a given site * Supported Types: Daily, Monthly, Average, Local Average * Supported Categories: Energy, Water, Waste, Transportation, Human Experience, Re-Entry   ## How it works  This API works for any Schneider Electric customer who has an identity in Schneider Electric system, and site data associated with its identity.  **Step 1:** In order to enquire the customer data, the customer has to provide his/her consent to share their building measurement data with scoring partner.   * If purchaser is ISV application, then they should get customer consent using OAuth2AuthCode flow.  * If purchaser is customer, then customer should provide his/her consent while creating Personal Access Token (PAT).  **Step 2:** Enquire all the sites which the customer is authorized to calculate the performance scores.  **Step 3:** Send requests to calculate the performance score for a given site.  **Step 4:** Fetch all current and historical scores.  ![High-level flow diagram](https://raw.githubusercontent.com/ecostruxure-openapi/public-images/main/energy-sustainability-scoring/user-edition.png \"High level flow diagram\")  # Documentation      ## How to sign up      **Step 1:** [Register or login](https://exchange.se.com) with an Exchange account.  **Step 2:** Subscribe to the [API product in our Shop](https://exchange.se.com).  **Step 3:** After subscription, API credentials and usage details for the API are available in developer portal.  ## Authentication guide  This API supports the following authentication mechanisms:  **OAuth2 Authorization Code Flow**     Once subscription to the API is approved on [Exchange](https://exchange.se.com), API Subscription Client ID and Client Secret will be shared with the subscriber     The Client ID should be sent when calling the Authorize Endpoint to initiate the Authorization and Consent flow.      Once user consents to the scopes requested by the client app, an authorization code will be issued which needs to be sent to the Token Endpoint with grant_type as *authorization_code*, along with Client ID and Client Secret in order to retrieve an access_token and a refresh_token. In order to retrieve a new access_token, call the Token endpoint with grant_type as *refresh_token* and pass the refresh_token issued before.      Each access_token is valid for 1 hour and has to be provided to every API call as HTTP Request Header `Authorization: Bearer {access_token}`    ![Authorization Code Flow](https://raw.githubusercontent.com/ecostruxure-openapi/public-images/main/energy-sustainability-scoring/authorization-flow-user-edition.PNG \"Authorization Code Flow diagram\")  **Personal Access Token**      Personal Access Token(PAT) has to be generated from the Exchange Developer Portal on the product page after subscription.     The customer will have to provide their consent while generating PAT to share the building measurement data with scoring partner.    PAT is valid for user specified time period and has to be provided to every API call as HTTP Request Header `Authorization: Bearer {access_token}`   ## Sandbox Testing  **What is Sandbox Test Data?**  Sandbox test data refers to simulated data that can be used for testing or validating an API without manipulating real production data. It provides a safe environment for developers to experiment with the API, test different scenarios and identify errors before deploying it to the production server.  **Why is Sandbox Test Data Important?**  Working with live production data can be risky, especially during development and testing phases where unexpected changes can occur. Sandbox test data allows developers to create an isolated environment where they can test new features, fix bugs, and improve overall performance without causing any harm to the production data. This helps save time, money and minimizes the risk of introducing new issues into the production system.  Get access token for sandbox testing using Sandbox authorize endpoint mentioned below    > Sandbox authorize endpoint: https://se-exchange-uat-uat.apigee.net/ecostruxure/v1/oauth/sandbox-authorize   ## Operations and Resource Model  ![Operations and Resource Model diagram](https://raw.githubusercontent.com/ecostruxure-openapi/public-images/main/energy-sustainability-scoring/open-esx-energy-scoring.png \"Operations and Resource Model diagram\")  ## Code Samples  You can leverage the code samples provided to integrate faster in your application.  <div id=\"gitsample\"></div>   ## Support  Contact our Exchange support team at exchange.support@se.com and include,      - Endpoint URL     - Request/Response of the URL     - Any additional information like Screenshots, Postman collections  Get help from the community [here](https://community.se.com/t5/Green-Building-Scoring-and/bd-p/green-building-certification).  ---
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package se.ecostruxure.sdk.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import se.ecostruxure.sdk.client.model.Address;
import se.ecostruxure.sdk.client.model.SiteMetadata;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Site
 */
@JsonPropertyOrder({
  Site.JSON_PROPERTY_ID,
  Site.JSON_PROPERTY_NAME,
  Site.JSON_PROPERTY_TYPE,
  Site.JSON_PROPERTY_SOURCE_SYSTEM_ID,
  Site.JSON_PROPERTY_METADATA,
  Site.JSON_PROPERTY_POSTAL_ADDRESS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-08-07T17:32:11.809634700+05:30[Asia/Calcutta]")
public class Site {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_SOURCE_SYSTEM_ID = "sourceSystemId";
  private Integer sourceSystemId;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private SiteMetadata metadata;

  public static final String JSON_PROPERTY_POSTAL_ADDRESS = "postalAddress";
  private Address postalAddress;

  public Site() {
  }

  public Site id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "ac64ac6a-abfd-4f5e-9d38-81102c0ca", value = "")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }


  public Site name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "ACME Headquarters", value = "")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }


  public Site type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Retail", value = "")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(String type) {
    this.type = type;
  }


  public Site sourceSystemId(Integer sourceSystemId) {
    
    this.sourceSystemId = sourceSystemId;
    return this;
  }

   /**
   * Get sourceSystemId
   * @return sourceSystemId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "178654", value = "")
  @JsonProperty(JSON_PROPERTY_SOURCE_SYSTEM_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getSourceSystemId() {
    return sourceSystemId;
  }


  @JsonProperty(JSON_PROPERTY_SOURCE_SYSTEM_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSourceSystemId(Integer sourceSystemId) {
    this.sourceSystemId = sourceSystemId;
  }


  public Site metadata(SiteMetadata metadata) {
    
    this.metadata = metadata;
    return this;
  }

   /**
   * Get metadata
   * @return metadata
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SiteMetadata getMetadata() {
    return metadata;
  }


  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMetadata(SiteMetadata metadata) {
    this.metadata = metadata;
  }


  public Site postalAddress(Address postalAddress) {
    
    this.postalAddress = postalAddress;
    return this;
  }

   /**
   * Get postalAddress
   * @return postalAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_POSTAL_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Address getPostalAddress() {
    return postalAddress;
  }


  @JsonProperty(JSON_PROPERTY_POSTAL_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPostalAddress(Address postalAddress) {
    this.postalAddress = postalAddress;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Site site = (Site) o;
    return Objects.equals(this.id, site.id) &&
        Objects.equals(this.name, site.name) &&
        Objects.equals(this.type, site.type) &&
        Objects.equals(this.sourceSystemId, site.sourceSystemId) &&
        Objects.equals(this.metadata, site.metadata) &&
        Objects.equals(this.postalAddress, site.postalAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, type, sourceSystemId, metadata, postalAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Site {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    sourceSystemId: ").append(toIndentedString(sourceSystemId)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    postalAddress: ").append(toIndentedString(postalAddress)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

