# EcoStruxureEnergySustainabilityScoringPartnerApi.MeterApi

All URIs are relative to *https://se-exchange-uat-uat.apigee.net/ecostruxure/scoring/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**listMeters**](MeterApi.md#listMeters) | **GET** /sites/{site-id}/meters | Fetch Meters



## listMeters

> [Meter] listMeters(siteId)

Fetch Meters

Retrieve all meters installed at a given site

### Example

```javascript
import EcoStruxureEnergySustainabilityScoringPartnerApi from 'eco_struxure_energy__sustainability_scoring_partner_api';
let defaultClient = EcoStruxureEnergySustainabilityScoringPartnerApi.ApiClient.instance;
// Configure OAuth2 access token for authorization: Oauth2AuthCode
let Oauth2AuthCode = defaultClient.authentications['Oauth2AuthCode'];
Oauth2AuthCode.accessToken = 'YOUR ACCESS TOKEN';

let apiInstance = new EcoStruxureEnergySustainabilityScoringPartnerApi.MeterApi();
let siteId = a483d4-e5be-4521-9f92-5400f5; // String | 
apiInstance.listMeters(siteId, (error, data, response) => {
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

### Return type

[**[Meter]**](Meter.md)

### Authorization

[Oauth2AuthCode](../README.md#Oauth2AuthCode)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

