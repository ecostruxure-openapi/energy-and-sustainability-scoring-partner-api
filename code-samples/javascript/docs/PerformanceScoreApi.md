# EcoStruxureEnergySustainabilityScoringPartnerApi.PerformanceScoreApi

All URIs are relative to *https://se-exchange-uat-uat.apigee.net/ecostruxure/scoring/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPerformanceScores**](PerformanceScoreApi.md#createPerformanceScores) | **POST** /sites/{site-id}/performance-scores | Update Performance Score
[**createSiteAssociation**](PerformanceScoreApi.md#createSiteAssociation) | **POST** /sites/{site-id}/scoring-providers | Associate Scoring Application
[**listPerformanceScores**](PerformanceScoreApi.md#listPerformanceScores) | **GET** /sites/{site-id}/performance-scores | Fetch Performance Score



## createPerformanceScores

> [PerformanceScore] createPerformanceScores(siteId, opts)

Update Performance Score

Creates performance scores for a given site. Supports multiple categories (e.g. energy) and types (e.g. monthly)

### Example

```javascript
import EcoStruxureEnergySustainabilityScoringPartnerApi from 'eco_struxure_energy__sustainability_scoring_partner_api';
let defaultClient = EcoStruxureEnergySustainabilityScoringPartnerApi.ApiClient.instance;
// Configure OAuth2 access token for authorization: Oauth2AuthCode
let Oauth2AuthCode = defaultClient.authentications['Oauth2AuthCode'];
Oauth2AuthCode.accessToken = 'YOUR ACCESS TOKEN';

let apiInstance = new EcoStruxureEnergySustainabilityScoringPartnerApi.PerformanceScoreApi();
let siteId = a483d4-e5be-4521-9f92-5400f5; // String | 
let opts = {
  'performanceScore': [new EcoStruxureEnergySustainabilityScoringPartnerApi.PerformanceScore()] // [PerformanceScore] | Performance Score to be created
};
apiInstance.createPerformanceScores(siteId, opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **siteId** | **String**|  | 
 **performanceScore** | [**[PerformanceScore]**](PerformanceScore.md)| Performance Score to be created | [optional] 

### Return type

[**[PerformanceScore]**](PerformanceScore.md)

### Authorization

[Oauth2AuthCode](../README.md#Oauth2AuthCode)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## createSiteAssociation

> ScoringProvider createSiteAssociation(siteId, opts)

Associate Scoring Application

Creates a scoring provider resource to associate a site

### Example

```javascript
import EcoStruxureEnergySustainabilityScoringPartnerApi from 'eco_struxure_energy__sustainability_scoring_partner_api';
let defaultClient = EcoStruxureEnergySustainabilityScoringPartnerApi.ApiClient.instance;
// Configure OAuth2 access token for authorization: Oauth2AuthCode
let Oauth2AuthCode = defaultClient.authentications['Oauth2AuthCode'];
Oauth2AuthCode.accessToken = 'YOUR ACCESS TOKEN';

let apiInstance = new EcoStruxureEnergySustainabilityScoringPartnerApi.PerformanceScoreApi();
let siteId = a483d4-e5be-4521-9f92-5400f5; // String | 
let opts = {
  'scoringProvider': new EcoStruxureEnergySustainabilityScoringPartnerApi.ScoringProvider() // ScoringProvider | Scoring Provider resource to be created
};
apiInstance.createSiteAssociation(siteId, opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **siteId** | **String**|  | 
 **scoringProvider** | [**ScoringProvider**](ScoringProvider.md)| Scoring Provider resource to be created | [optional] 

### Return type

[**ScoringProvider**](ScoringProvider.md)

### Authorization

[Oauth2AuthCode](../README.md#Oauth2AuthCode)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## listPerformanceScores

> [PerformanceScore] listPerformanceScores(siteId, opts)

Fetch Performance Score

Retrieve all performance scores for a given site

### Example

```javascript
import EcoStruxureEnergySustainabilityScoringPartnerApi from 'eco_struxure_energy__sustainability_scoring_partner_api';
let defaultClient = EcoStruxureEnergySustainabilityScoringPartnerApi.ApiClient.instance;
// Configure OAuth2 access token for authorization: Oauth2AuthCode
let Oauth2AuthCode = defaultClient.authentications['Oauth2AuthCode'];
Oauth2AuthCode.accessToken = 'YOUR ACCESS TOKEN';

let apiInstance = new EcoStruxureEnergySustainabilityScoringPartnerApi.PerformanceScoreApi();
let siteId = a483d4-e5be-4521-9f92-5400f5; // String | 
let opts = {
  'type': ["daily"], // [String] | 
  'category': ["energy"] // [String] | 
};
apiInstance.listPerformanceScores(siteId, opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **siteId** | **String**|  | 
 **type** | [**[String]**](String.md)|  | [optional] 
 **category** | [**[String]**](String.md)|  | [optional] 

### Return type

[**[PerformanceScore]**](PerformanceScore.md)

### Authorization

[Oauth2AuthCode](../README.md#Oauth2AuthCode)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

