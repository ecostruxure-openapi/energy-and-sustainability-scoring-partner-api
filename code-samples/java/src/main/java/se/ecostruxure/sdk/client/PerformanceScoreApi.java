package se.ecostruxure.sdk.client;

import se.ecostruxure.sdk.client.invoker.ApiClient;

import se.ecostruxure.sdk.client.model.Error;
import se.ecostruxure.sdk.client.model.PerformanceScore;
import se.ecostruxure.sdk.client.model.ScoringRequest;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-08-07T17:32:11.809634700+05:30[Asia/Calcutta]")
@Component("se.ecostruxure.sdk.client.PerformanceScoreApi")
public class PerformanceScoreApi {
    private ApiClient apiClient;

    public PerformanceScoreApi() {
        this(new ApiClient());
    }

    @Autowired
    public PerformanceScoreApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create Scoring Request
     * User select a site for scoring and thus automatically share timeseries related information to calculate scores
     * <p><b>201</b> - Created
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>500</b> - Internal Server Error
     * @param siteId  (required)
     * @return ScoringRequest
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ScoringRequest createScoringRequest(String siteId) throws RestClientException {
        return createScoringRequestWithHttpInfo(siteId).getBody();
    }

    /**
     * Create Scoring Request
     * User select a site for scoring and thus automatically share timeseries related information to calculate scores
     * <p><b>201</b> - Created
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>500</b> - Internal Server Error
     * @param siteId  (required)
     * @return ResponseEntity&lt;ScoringRequest&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ScoringRequest> createScoringRequestWithHttpInfo(String siteId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'siteId' is set
        if (siteId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'siteId' when calling createScoringRequest");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("site-id", siteId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2AuthCode", "PersonalAccessToken" };

        ParameterizedTypeReference<ScoringRequest> localReturnType = new ParameterizedTypeReference<ScoringRequest>() {};
        return apiClient.invokeAPI("/sites/{site-id}/scoring-requests", HttpMethod.POST, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Scoring Request Status
     * Allows end user to check the status of the site configured for performance scoring.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>500</b> - Internal Server Error
     * @param siteId  (required)
     * @param id  (optional)
     * @return List&lt;ScoringRequest&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<ScoringRequest> getScoringRequestStatus(String siteId, Integer id) throws RestClientException {
        return getScoringRequestStatusWithHttpInfo(siteId, id).getBody();
    }

    /**
     * Scoring Request Status
     * Allows end user to check the status of the site configured for performance scoring.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>500</b> - Internal Server Error
     * @param siteId  (required)
     * @param id  (optional)
     * @return ResponseEntity&lt;List&lt;ScoringRequest&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<ScoringRequest>> getScoringRequestStatusWithHttpInfo(String siteId, Integer id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'siteId' is set
        if (siteId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'siteId' when calling getScoringRequestStatus");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("site-id", siteId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "id", id));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2AuthCode", "PersonalAccessToken" };

        ParameterizedTypeReference<List<ScoringRequest>> localReturnType = new ParameterizedTypeReference<List<ScoringRequest>>() {};
        return apiClient.invokeAPI("/sites/{site-id}/scoring-requests", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get Performance Score
     * Retrieve all performance scores for a given site
     * <p><b>200</b> - Found Scores
     * <p><b>400</b> - Bad Request
     * <p><b>404</b> - Site Not found
     * <p><b>500</b> - Internal Server Error
     * @param siteId  (required)
     * @param type  (optional)
     * @param category  (optional)
     * @return List&lt;PerformanceScore&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<PerformanceScore> listPerformanceScores(String siteId, List<String> type, List<String> category) throws RestClientException {
        return listPerformanceScoresWithHttpInfo(siteId, type, category).getBody();
    }

    /**
     * Get Performance Score
     * Retrieve all performance scores for a given site
     * <p><b>200</b> - Found Scores
     * <p><b>400</b> - Bad Request
     * <p><b>404</b> - Site Not found
     * <p><b>500</b> - Internal Server Error
     * @param siteId  (required)
     * @param type  (optional)
     * @param category  (optional)
     * @return ResponseEntity&lt;List&lt;PerformanceScore&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<PerformanceScore>> listPerformanceScoresWithHttpInfo(String siteId, List<String> type, List<String> category) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'siteId' is set
        if (siteId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'siteId' when calling listPerformanceScores");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("site-id", siteId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "type", type));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "category", category));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2AuthCode", "PersonalAccessToken" };

        ParameterizedTypeReference<List<PerformanceScore>> localReturnType = new ParameterizedTypeReference<List<PerformanceScore>>() {};
        return apiClient.invokeAPI("/sites/{site-id}/performance-scores", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
