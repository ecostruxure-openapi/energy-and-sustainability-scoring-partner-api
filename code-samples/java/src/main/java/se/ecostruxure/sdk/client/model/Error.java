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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Set;
import se.ecostruxure.sdk.client.model.ErrorInvalidParamsInner;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Error occurred while handling the request (based on rfc7807)
 */
@ApiModel(description = "Error occurred while handling the request (based on rfc7807)")
@JsonPropertyOrder({
  Error.JSON_PROPERTY_TYPE,
  Error.JSON_PROPERTY_TITLE,
  Error.JSON_PROPERTY_STATUS,
  Error.JSON_PROPERTY_INSTANCE,
  Error.JSON_PROPERTY_DETAIL,
  Error.JSON_PROPERTY_DEBUGGING,
  Error.JSON_PROPERTY_INVALID_PARAMS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-08-07T17:32:11.809634700+05:30[Asia/Calcutta]")
public class Error {
  public static final String JSON_PROPERTY_TYPE = "type";
  private URI type;

  public static final String JSON_PROPERTY_TITLE = "title";
  private String title;

  public static final String JSON_PROPERTY_STATUS = "status";
  private BigDecimal status;

  public static final String JSON_PROPERTY_INSTANCE = "instance";
  private String instance;

  public static final String JSON_PROPERTY_DETAIL = "detail";
  private String detail;

  public static final String JSON_PROPERTY_DEBUGGING = "debugging";
  private String debugging;

  public static final String JSON_PROPERTY_INVALID_PARAMS = "invalid-params";
  private Set<ErrorInvalidParamsInner> invalidParams = null;

  public Error() {
  }

  public Error type(URI type) {
    
    this.type = type;
    return this;
  }

   /**
   * A URI reference [RFC3986] that identifies the problem type.
   * @return type
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A URI reference [RFC3986] that identifies the problem type.")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public URI getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(URI type) {
    this.type = type;
  }


  public Error title(String title) {
    
    this.title = title;
    return this;
  }

   /**
   * A short, human-readable summary of the problem type.
   * @return title
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A short, human-readable summary of the problem type.")
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTitle() {
    return title;
  }


  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTitle(String title) {
    this.title = title;
  }


  public Error status(BigDecimal status) {
    
    this.status = status;
    return this;
  }

   /**
   * The HTTP status code ([RFC7231], Section 6) generated by the origin server for this occurrence of the problem.
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The HTTP status code ([RFC7231], Section 6) generated by the origin server for this occurrence of the problem.")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getStatus() {
    return status;
  }


  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(BigDecimal status) {
    this.status = status;
  }


  public Error instance(String instance) {
    
    this.instance = instance;
    return this;
  }

   /**
   * A URI reference that identifies the specific occurrence of the problem.
   * @return instance
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A URI reference that identifies the specific occurrence of the problem.")
  @JsonProperty(JSON_PROPERTY_INSTANCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInstance() {
    return instance;
  }


  @JsonProperty(JSON_PROPERTY_INSTANCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInstance(String instance) {
    this.instance = instance;
  }


  public Error detail(String detail) {
    
    this.detail = detail;
    return this;
  }

   /**
   * A human-readable explanation specific to this occurrence of the problem.
   * @return detail
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A human-readable explanation specific to this occurrence of the problem.")
  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDetail() {
    return detail;
  }


  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDetail(String detail) {
    this.detail = detail;
  }


  public Error debugging(String debugging) {
    
    this.debugging = debugging;
    return this;
  }

   /**
   * Debugging information for DEV and QA environments.
   * @return debugging
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Debugging information for DEV and QA environments.")
  @JsonProperty(JSON_PROPERTY_DEBUGGING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDebugging() {
    return debugging;
  }


  @JsonProperty(JSON_PROPERTY_DEBUGGING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDebugging(String debugging) {
    this.debugging = debugging;
  }


  public Error invalidParams(Set<ErrorInvalidParamsInner> invalidParams) {
    
    this.invalidParams = invalidParams;
    return this;
  }

  public Error addInvalidParamsItem(ErrorInvalidParamsInner invalidParamsItem) {
    if (this.invalidParams == null) {
      this.invalidParams = new LinkedHashSet<>();
    }
    this.invalidParams.add(invalidParamsItem);
    return this;
  }

   /**
   * An array of validation errors.
   * @return invalidParams
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An array of validation errors.")
  @JsonProperty(JSON_PROPERTY_INVALID_PARAMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Set<ErrorInvalidParamsInner> getInvalidParams() {
    return invalidParams;
  }


  @JsonDeserialize(as = LinkedHashSet.class)
  @JsonProperty(JSON_PROPERTY_INVALID_PARAMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInvalidParams(Set<ErrorInvalidParamsInner> invalidParams) {
    this.invalidParams = invalidParams;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.type, error.type) &&
        Objects.equals(this.title, error.title) &&
        Objects.equals(this.status, error.status) &&
        Objects.equals(this.instance, error.instance) &&
        Objects.equals(this.detail, error.detail) &&
        Objects.equals(this.debugging, error.debugging) &&
        Objects.equals(this.invalidParams, error.invalidParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, title, status, instance, detail, debugging, invalidParams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    debugging: ").append(toIndentedString(debugging)).append("\n");
    sb.append("    invalidParams: ").append(toIndentedString(invalidParams)).append("\n");
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

