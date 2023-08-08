package se.ecostruxure.sdk.client;

import se.ecostruxure.sdk.client.invoker.ApiClient;

import se.ecostruxure.sdk.client.model.Error;
import se.ecostruxure.sdk.client.model.Site;

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
@Component("se.ecostruxure.sdk.client.SiteApi")
public class SiteApi {
    private ApiClient apiClient;

    public SiteApi() {
        this(new ApiClient());
    }

    @Autowired
    public SiteApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Fetch sites
     * Retrieve all sites and related metadata
     * <p><b>200</b> - Found Sites
     * <p><b>500</b> - Internal Server Error
     * @return List&lt;Site&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Site> listSites() throws RestClientException {
        return listSitesWithHttpInfo().getBody();
    }

    /**
     * Fetch sites
     * Retrieve all sites and related metadata
     * <p><b>200</b> - Found Sites
     * <p><b>500</b> - Internal Server Error
     * @return ResponseEntity&lt;List&lt;Site&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Site>> listSitesWithHttpInfo() throws RestClientException {
        Object localVarPostBody = null;
        

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

        String[] localVarAuthNames = new String[] { "OAuth2AuthCode", "OAuth2AuthCode-Sandbox", "PersonalAccessToken" };

        ParameterizedTypeReference<List<Site>> localReturnType = new ParameterizedTypeReference<List<Site>>() {};
        return apiClient.invokeAPI("/sites", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
