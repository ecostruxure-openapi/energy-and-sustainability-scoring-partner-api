# EcoStruxureEnergySustainabilityScoringPartnerApi.TimeseriesApi

All URIs are relative to *https://se-exchange-uat-uat.apigee.net/ecostruxure/scoring/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**listMetrics**](TimeseriesApi.md#listMetrics) | **GET** /sites/{site-id}/timeseries | Fetch Timeseries



## listMetrics

> [Timeserie] listMetrics(siteId, opts)

Fetch Timeseries

Get all building measurement data to calculate scores

### Example

```javascript
import EcoStruxureEnergySustainabilityScoringPartnerApi from 'eco_struxure_energy__sustainability_scoring_partner_api';
let defaultClient = EcoStruxureEnergySustainabilityScoringPartnerApi.ApiClient.instance;
// Configure OAuth2 access token for authorization: Oauth2AuthCode
let Oauth2AuthCode = defaultClient.authentications['Oauth2AuthCode'];
Oauth2AuthCode.accessToken = 'YOUR ACCESS TOKEN';

let apiInstance = new EcoStruxureEnergySustainabilityScoringPartnerApi.TimeseriesApi();
let siteId = a483d4-e5be-4521-9f92-5400f5; // String | 
let opts = {
  'updatedAtGte': new Date("2013-10-20T19:20:30+01:00"), // Date | 
  'updatedAtLt': new Date("2013-10-20T19:20:30+01:00") // Date | 
};
apiInstance.listMetrics(siteId, opts, (error, data, response) => {
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
 **updatedAtGte** | **Date**|  | [optional] 
 **updatedAtLt** | **Date**|  | [optional] 

### Return type

[**[Timeserie]**](Timeserie.md)

### Authorization

[Oauth2AuthCode](../README.md#Oauth2AuthCode)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

