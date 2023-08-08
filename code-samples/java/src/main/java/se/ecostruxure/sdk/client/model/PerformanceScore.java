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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * PerformanceScore
 */
@JsonPropertyOrder({
  PerformanceScore.JSON_PROPERTY_DATE,
  PerformanceScore.JSON_PROPERTY_SCORE,
  PerformanceScore.JSON_PROPERTY_TYPE,
  PerformanceScore.JSON_PROPERTY_CATEGORY,
  PerformanceScore.JSON_PROPERTY_UPDATED_AT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-08-07T17:32:11.809634700+05:30[Asia/Calcutta]")
public class PerformanceScore {
  public static final String JSON_PROPERTY_DATE = "date";
  private LocalDate date;

  public static final String JSON_PROPERTY_SCORE = "score";
  private BigDecimal score;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    DAILY("daily"),
    
    MONTHLY("monthly"),
    
    LOCALAVERAGE("localAverage"),
    
    AVERAGE("average");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeEnum type;

  /**
   * Gets or Sets category
   */
  public enum CategoryEnum {
    ENERGY("energy"),
    
    WATER("water"),
    
    WASTE("waste"),
    
    TRANSPORTATION("transportation"),
    
    HUMANEXPERIENCE("humanExperience"),
    
    REENTRY("reEntry");

    private String value;

    CategoryEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CategoryEnum fromValue(String value) {
      for (CategoryEnum b : CategoryEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_CATEGORY = "category";
  private CategoryEnum category;

  public static final String JSON_PROPERTY_UPDATED_AT = "updatedAt";
  private OffsetDateTime updatedAt;

  public PerformanceScore() {
  }

  public PerformanceScore date(LocalDate date) {
    
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_DATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public LocalDate getDate() {
    return date;
  }


  @JsonProperty(JSON_PROPERTY_DATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDate(LocalDate date) {
    this.date = date;
  }


  public PerformanceScore score(BigDecimal score) {
    
    this.score = score;
    return this;
  }

   /**
   * Get score
   * @return score
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "94.99", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SCORE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BigDecimal getScore() {
    return score;
  }


  @JsonProperty(JSON_PROPERTY_SCORE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setScore(BigDecimal score) {
    this.score = score;
  }


  public PerformanceScore type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "daily", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TypeEnum getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(TypeEnum type) {
    this.type = type;
  }


  public PerformanceScore category(CategoryEnum category) {
    
    this.category = category;
    return this;
  }

   /**
   * Get category
   * @return category
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "energy", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CATEGORY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public CategoryEnum getCategory() {
    return category;
  }


  @JsonProperty(JSON_PROPERTY_CATEGORY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCategory(CategoryEnum category) {
    this.category = category;
  }


  public PerformanceScore updatedAt(OffsetDateTime updatedAt) {
    
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Get updatedAt
   * @return updatedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_UPDATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }


  @JsonProperty(JSON_PROPERTY_UPDATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PerformanceScore performanceScore = (PerformanceScore) o;
    return Objects.equals(this.date, performanceScore.date) &&
        Objects.equals(this.score, performanceScore.score) &&
        Objects.equals(this.type, performanceScore.type) &&
        Objects.equals(this.category, performanceScore.category) &&
        Objects.equals(this.updatedAt, performanceScore.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, score, type, category, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PerformanceScore {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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

