# .TimeseriesApi

All URIs are relative to *https://se-exchange-uat-uat.apigee.net/ecostruxure/scoring/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**listMetrics**](TimeseriesApi.md#listMetrics) | **GET** /sites/{site-id}/timeseries | Fetch Timeseries


# **listMetrics**
> Array<Timeserie> listMetrics()

Get all building measurement data to calculate scores

### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .TimeseriesApi(configuration);

let body:.TimeseriesApiListMetricsRequest = {
  // string
  siteId: "a483d4-e5be-4521-9f92-5400f5",
  // Date (optional)
  updatedAtGte: new Date('1970-01-01T00:00:00.00Z'),
  // Date (optional)
  updatedAtLt: new Date('1970-01-01T00:00:00.00Z'),
};

apiInstance.listMetrics(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **siteId** | [**string**] |  | defaults to undefined
 **updatedAtGte** | [**Date**] |  | (optional) defaults to undefined
 **updatedAtLt** | [**Date**] |  | (optional) defaults to undefined


### Return type

**Array<Timeserie>**

### Authorization

[Oauth2AuthCode](README.md#Oauth2AuthCode)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Found Timeseries |  -  |
**404** | Site Not found |  -  |
**500** | Internal Server Error |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)


