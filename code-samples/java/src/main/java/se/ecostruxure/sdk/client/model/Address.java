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
import se.ecostruxure.sdk.client.model.Coordinates;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Address
 */
@JsonPropertyOrder({
  Address.JSON_PROPERTY_ADDRESS,
  Address.JSON_PROPERTY_CITY,
  Address.JSON_PROPERTY_COUNTRY_ISO_CODE,
  Address.JSON_PROPERTY_ZIP_CODE,
  Address.JSON_PROPERTY_STATE_PROVINCE,
  Address.JSON_PROPERTY_TIMEZONE,
  Address.JSON_PROPERTY_COORDINATES
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-08-07T17:32:11.809634700+05:30[Asia/Calcutta]")
public class Address {
  public static final String JSON_PROPERTY_ADDRESS = "address";
  private String address;

  public static final String JSON_PROPERTY_CITY = "city";
  private String city;

  public static final String JSON_PROPERTY_COUNTRY_ISO_CODE = "countryIsoCode";
  private String countryIsoCode;

  public static final String JSON_PROPERTY_ZIP_CODE = "zipCode";
  private String zipCode;

  public static final String JSON_PROPERTY_STATE_PROVINCE = "stateProvince";
  private String stateProvince;

  public static final String JSON_PROPERTY_TIMEZONE = "timezone";
  private String timezone;

  public static final String JSON_PROPERTY_COORDINATES = "coordinates";
  private Coordinates coordinates;

  public Address() {
  }

  public Address address(String address) {
    
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "12 Baker Street", value = "")
  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAddress() {
    return address;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAddress(String address) {
    this.address = address;
  }


  public Address city(String city) {
    
    this.city = city;
    return this;
  }

   /**
   * Get city
   * @return city
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "London", value = "")
  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCity() {
    return city;
  }


  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCity(String city) {
    this.city = city;
  }


  public Address countryIsoCode(String countryIsoCode) {
    
    this.countryIsoCode = countryIsoCode;
    return this;
  }

   /**
   * Get countryIsoCode
   * @return countryIsoCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "UK", value = "")
  @JsonProperty(JSON_PROPERTY_COUNTRY_ISO_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCountryIsoCode() {
    return countryIsoCode;
  }


  @JsonProperty(JSON_PROPERTY_COUNTRY_ISO_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCountryIsoCode(String countryIsoCode) {
    this.countryIsoCode = countryIsoCode;
  }


  public Address zipCode(String zipCode) {
    
    this.zipCode = zipCode;
    return this;
  }

   /**
   * Get zipCode
   * @return zipCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "3338", value = "")
  @JsonProperty(JSON_PROPERTY_ZIP_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getZipCode() {
    return zipCode;
  }


  @JsonProperty(JSON_PROPERTY_ZIP_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }


  public Address stateProvince(String stateProvince) {
    
    this.stateProvince = stateProvince;
    return this;
  }

   /**
   * Get stateProvince
   * @return stateProvince
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "AZ", value = "")
  @JsonProperty(JSON_PROPERTY_STATE_PROVINCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getStateProvince() {
    return stateProvince;
  }


  @JsonProperty(JSON_PROPERTY_STATE_PROVINCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStateProvince(String stateProvince) {
    this.stateProvince = stateProvince;
  }


  public Address timezone(String timezone) {
    
    this.timezone = timezone;
    return this;
  }

   /**
   * Get timezone
   * @return timezone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "GMT", value = "")
  @JsonProperty(JSON_PROPERTY_TIMEZONE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTimezone() {
    return timezone;
  }


  @JsonProperty(JSON_PROPERTY_TIMEZONE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }


  public Address coordinates(Coordinates coordinates) {
    
    this.coordinates = coordinates;
    return this;
  }

   /**
   * Get coordinates
   * @return coordinates
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_COORDINATES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Coordinates getCoordinates() {
    return coordinates;
  }


  @JsonProperty(JSON_PROPERTY_COORDINATES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.address, address.address) &&
        Objects.equals(this.city, address.city) &&
        Objects.equals(this.countryIsoCode, address.countryIsoCode) &&
        Objects.equals(this.zipCode, address.zipCode) &&
        Objects.equals(this.stateProvince, address.stateProvince) &&
        Objects.equals(this.timezone, address.timezone) &&
        Objects.equals(this.coordinates, address.coordinates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, city, countryIsoCode, zipCode, stateProvince, timezone, coordinates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    countryIsoCode: ").append(toIndentedString(countryIsoCode)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
    sb.append("    stateProvince: ").append(toIndentedString(stateProvince)).append("\n");
    sb.append("    timezone: ").append(toIndentedString(timezone)).append("\n");
    sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
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

