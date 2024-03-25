# EcoStruxureEnergySustainabilityScoringPartnerApi.SiteApi

All URIs are relative to *https://se-exchange-uat-uat.apigee.net/ecostruxure/scoring/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**listSites**](SiteApi.md#listSites) | **GET** /sites | Fetch sites



## listSites

> [Site] listSites()

Fetch sites

Retrieve all sites and related metadata

### Example

```javascript
import EcoStruxureEnergySustainabilityScoringPartnerApi from 'eco_struxure_energy__sustainability_scoring_partner_api';
let defaultClient = EcoStruxureEnergySustainabilityScoringPartnerApi.ApiClient.instance;
// Configure OAuth2 access token for authorization: Oauth2AuthCode
let Oauth2AuthCode = defaultClient.authentications['Oauth2AuthCode'];
Oauth2AuthCode.accessToken = 'YOUR ACCESS TOKEN';

let apiInstance = new EcoStruxureEnergySustainabilityScoringPartnerApi.SiteApi();
apiInstance.listSites((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**[Site]**](Site.md)

### Authorization

[Oauth2AuthCode](../README.md#Oauth2AuthCode)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

