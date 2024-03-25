# .PerformanceScoreApi

All URIs are relative to *https://se-exchange-uat-uat.apigee.net/ecostruxure/scoring/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPerformanceScores**](PerformanceScoreApi.md#createPerformanceScores) | **POST** /sites/{site-id}/performance-scores | Update Performance Score
[**createSiteAssociation**](PerformanceScoreApi.md#createSiteAssociation) | **POST** /sites/{site-id}/scoring-providers | Associate Scoring Application
[**listPerformanceScores**](PerformanceScoreApi.md#listPerformanceScores) | **GET** /sites/{site-id}/performance-scores | Fetch Performance Score


# **createPerformanceScores**
> Array<PerformanceScore> createPerformanceScores()

Creates performance scores for a given site. Supports multiple categories (e.g. energy) and types (e.g. monthly)

### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .PerformanceScoreApi(configuration);

let body:.PerformanceScoreApiCreatePerformanceScoresRequest = {
  // string
  siteId: "a483d4-e5be-4521-9f92-5400f5",
  // Array<PerformanceScore> | Performance Score to be created (optional)
  performanceScore: [
    {
      date: new Date('1970-01-01').toISOString().split('T')[0];,
      score: 94.99,
      type: "daily",
      category: "energy",
      updatedAt: new Date('1970-01-01T00:00:00.00Z'),
    },
  ],
};

apiInstance.createPerformanceScores(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **performanceScore** | **Array<PerformanceScore>**| Performance Score to be created |
 **siteId** | [**string**] |  | defaults to undefined


### Return type

**Array<PerformanceScore>**

### Authorization

[Oauth2AuthCode](README.md#Oauth2AuthCode)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Successfully Created |  -  |
**400** | Bad Request |  -  |
**404** | Site Not found |  -  |
**500** | Internal Server Error |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **createSiteAssociation**
> ScoringProvider createSiteAssociation()

Creates a scoring provider resource to associate a site

### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .PerformanceScoreApi(configuration);

let body:.PerformanceScoreApiCreateSiteAssociationRequest = {
  // string
  siteId: "a483d4-e5be-4521-9f92-5400f5",
  // ScoringProvider | Scoring Provider resource to be created (optional)
  scoringProvider: {
    leedId: 8000015697,
    leedName: "Mcdonald's Melton South",
  },
};

apiInstance.createSiteAssociation(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scoringProvider** | **ScoringProvider**| Scoring Provider resource to be created |
 **siteId** | [**string**] |  | defaults to undefined


### Return type

**ScoringProvider**

### Authorization

[Oauth2AuthCode](README.md#Oauth2AuthCode)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Successfully Created |  -  |
**400** | Bad Request |  -  |
**404** | Site Not found |  -  |
**500** | Internal Server Error |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **listPerformanceScores**
> Array<PerformanceScore> listPerformanceScores()

Retrieve all performance scores for a given site

### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .PerformanceScoreApi(configuration);

let body:.PerformanceScoreApiListPerformanceScoresRequest = {
  // string
  siteId: "a483d4-e5be-4521-9f92-5400f5",
  // Array<'daily' | 'monthly' | 'localAverage' | 'average'> (optional)
  type: [
    "daily",
  ],
  // Array<'energy' | 'water' | 'waste' | 'transportation' | 'humanExperience' | 'reEntry'> (optional)
  category: [
    "energy",
  ],
};

apiInstance.listPerformanceScores(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **siteId** | [**string**] |  | defaults to undefined
 **type** | **Array<&#39;daily&#39; &#124; &#39;monthly&#39; &#124; &#39;localAverage&#39; &#124; &#39;average&#39;>** |  | (optional) defaults to undefined
 **category** | **Array<&#39;energy&#39; &#124; &#39;water&#39; &#124; &#39;waste&#39; &#124; &#39;transportation&#39; &#124; &#39;humanExperience&#39; &#124; &#39;reEntry&#39;>** |  | (optional) defaults to undefined


### Return type

**Array<PerformanceScore>**

### Authorization

[Oauth2AuthCode](README.md#Oauth2AuthCode)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Found Scores |  -  |
**400** | Bad Request |  -  |
**404** | Site Not found |  -  |
**500** | Internal Server Error |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)


