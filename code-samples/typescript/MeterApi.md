# .MeterApi

All URIs are relative to *https://se-exchange-uat-uat.apigee.net/ecostruxure/scoring/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**listMeters**](MeterApi.md#listMeters) | **GET** /sites/{site-id}/meters | Fetch Meters


# **listMeters**
> Array<Meter> listMeters()

Retrieve all meters installed at a given site

### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .MeterApi(configuration);

let body:.MeterApiListMetersRequest = {
  // string
  siteId: "a483d4-e5be-4521-9f92-5400f5",
};

apiInstance.listMeters(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **siteId** | [**string**] |  | defaults to undefined


### Return type

**Array<Meter>**

### Authorization

[Oauth2AuthCode](README.md#Oauth2AuthCode)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Found Meters |  -  |
**404** | Site Not found |  -  |
**500** | Internal Server Error |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)


