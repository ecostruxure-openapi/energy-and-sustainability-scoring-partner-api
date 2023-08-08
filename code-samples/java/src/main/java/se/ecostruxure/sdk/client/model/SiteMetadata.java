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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * SiteMetadata
 */
@JsonPropertyOrder({
  SiteMetadata.JSON_PROPERTY_GROSS_AREA,
  SiteMetadata.JSON_PROPERTY_BUILDING_OCCUPANTS,
  SiteMetadata.JSON_PROPERTY_DAYS_PER_WEEK_WITH_VISITORS,
  SiteMetadata.JSON_PROPERTY_NUMBER_OF_VISITORS_PER_DAY,
  SiteMetadata.JSON_PROPERTY_VISIT_DURATION,
  SiteMetadata.JSON_PROPERTY_WEEKLY_OPERATING_HOURS
})
@JsonTypeName("Site_metadata")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-08-07T17:32:11.809634700+05:30[Asia/Calcutta]")
public class SiteMetadata {
  public static final String JSON_PROPERTY_GROSS_AREA = "grossArea";
  private Integer grossArea;

  public static final String JSON_PROPERTY_BUILDING_OCCUPANTS = "buildingOccupants";
  private Integer buildingOccupants;

  public static final String JSON_PROPERTY_DAYS_PER_WEEK_WITH_VISITORS = "daysPerWeekWithVisitors";
  private Integer daysPerWeekWithVisitors;

  public static final String JSON_PROPERTY_NUMBER_OF_VISITORS_PER_DAY = "numberOfVisitorsPerDay";
  private Integer numberOfVisitorsPerDay;

  public static final String JSON_PROPERTY_VISIT_DURATION = "visitDuration";
  private Double visitDuration;

  public static final String JSON_PROPERTY_WEEKLY_OPERATING_HOURS = "weeklyOperatingHours";
  private Integer weeklyOperatingHours;

  public SiteMetadata() {
  }

  public SiteMetadata grossArea(Integer grossArea) {
    
    this.grossArea = grossArea;
    return this;
  }

   /**
   * Get grossArea
   * @return grossArea
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "421", value = "")
  @JsonProperty(JSON_PROPERTY_GROSS_AREA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getGrossArea() {
    return grossArea;
  }


  @JsonProperty(JSON_PROPERTY_GROSS_AREA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGrossArea(Integer grossArea) {
    this.grossArea = grossArea;
  }


  public SiteMetadata buildingOccupants(Integer buildingOccupants) {
    
    this.buildingOccupants = buildingOccupants;
    return this;
  }

   /**
   * Get buildingOccupants
   * @return buildingOccupants
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "49", value = "")
  @JsonProperty(JSON_PROPERTY_BUILDING_OCCUPANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getBuildingOccupants() {
    return buildingOccupants;
  }


  @JsonProperty(JSON_PROPERTY_BUILDING_OCCUPANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBuildingOccupants(Integer buildingOccupants) {
    this.buildingOccupants = buildingOccupants;
  }


  public SiteMetadata daysPerWeekWithVisitors(Integer daysPerWeekWithVisitors) {
    
    this.daysPerWeekWithVisitors = daysPerWeekWithVisitors;
    return this;
  }

   /**
   * Get daysPerWeekWithVisitors
   * @return daysPerWeekWithVisitors
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "7", value = "")
  @JsonProperty(JSON_PROPERTY_DAYS_PER_WEEK_WITH_VISITORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getDaysPerWeekWithVisitors() {
    return daysPerWeekWithVisitors;
  }


  @JsonProperty(JSON_PROPERTY_DAYS_PER_WEEK_WITH_VISITORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDaysPerWeekWithVisitors(Integer daysPerWeekWithVisitors) {
    this.daysPerWeekWithVisitors = daysPerWeekWithVisitors;
  }


  public SiteMetadata numberOfVisitorsPerDay(Integer numberOfVisitorsPerDay) {
    
    this.numberOfVisitorsPerDay = numberOfVisitorsPerDay;
    return this;
  }

   /**
   * Get numberOfVisitorsPerDay
   * @return numberOfVisitorsPerDay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "548", value = "")
  @JsonProperty(JSON_PROPERTY_NUMBER_OF_VISITORS_PER_DAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getNumberOfVisitorsPerDay() {
    return numberOfVisitorsPerDay;
  }


  @JsonProperty(JSON_PROPERTY_NUMBER_OF_VISITORS_PER_DAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNumberOfVisitorsPerDay(Integer numberOfVisitorsPerDay) {
    this.numberOfVisitorsPerDay = numberOfVisitorsPerDay;
  }


  public SiteMetadata visitDuration(Double visitDuration) {
    
    this.visitDuration = visitDuration;
    return this;
  }

   /**
   * Get visitDuration
   * @return visitDuration
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "0.0208", value = "")
  @JsonProperty(JSON_PROPERTY_VISIT_DURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getVisitDuration() {
    return visitDuration;
  }


  @JsonProperty(JSON_PROPERTY_VISIT_DURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVisitDuration(Double visitDuration) {
    this.visitDuration = visitDuration;
  }


  public SiteMetadata weeklyOperatingHours(Integer weeklyOperatingHours) {
    
    this.weeklyOperatingHours = weeklyOperatingHours;
    return this;
  }

   /**
   * Get weeklyOperatingHours
   * @return weeklyOperatingHours
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "168", value = "")
  @JsonProperty(JSON_PROPERTY_WEEKLY_OPERATING_HOURS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getWeeklyOperatingHours() {
    return weeklyOperatingHours;
  }


  @JsonProperty(JSON_PROPERTY_WEEKLY_OPERATING_HOURS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWeeklyOperatingHours(Integer weeklyOperatingHours) {
    this.weeklyOperatingHours = weeklyOperatingHours;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SiteMetadata siteMetadata = (SiteMetadata) o;
    return Objects.equals(this.grossArea, siteMetadata.grossArea) &&
        Objects.equals(this.buildingOccupants, siteMetadata.buildingOccupants) &&
        Objects.equals(this.daysPerWeekWithVisitors, siteMetadata.daysPerWeekWithVisitors) &&
        Objects.equals(this.numberOfVisitorsPerDay, siteMetadata.numberOfVisitorsPerDay) &&
        Objects.equals(this.visitDuration, siteMetadata.visitDuration) &&
        Objects.equals(this.weeklyOperatingHours, siteMetadata.weeklyOperatingHours);
  }

  @Override
  public int hashCode() {
    return Objects.hash(grossArea, buildingOccupants, daysPerWeekWithVisitors, numberOfVisitorsPerDay, visitDuration, weeklyOperatingHours);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SiteMetadata {\n");
    sb.append("    grossArea: ").append(toIndentedString(grossArea)).append("\n");
    sb.append("    buildingOccupants: ").append(toIndentedString(buildingOccupants)).append("\n");
    sb.append("    daysPerWeekWithVisitors: ").append(toIndentedString(daysPerWeekWithVisitors)).append("\n");
    sb.append("    numberOfVisitorsPerDay: ").append(toIndentedString(numberOfVisitorsPerDay)).append("\n");
    sb.append("    visitDuration: ").append(toIndentedString(visitDuration)).append("\n");
    sb.append("    weeklyOperatingHours: ").append(toIndentedString(weeklyOperatingHours)).append("\n");
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

