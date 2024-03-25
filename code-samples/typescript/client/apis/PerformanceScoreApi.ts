import {BaseAPIRequestFactory, RequiredError, COLLECTION_FORMATS} from '../../apis/baseapi';
import { Configuration } from '../../configuration';
import {RequestContext, HttpMethod, ResponseContext, HttpFile, HttpInfo} from '../../http/http';
import {ObjectSerializer} from '../../models/ObjectSerializer';
import { ApiException } from '../../apis/exception';
import {canConsumeForm, isCodeInRange} from '../../util';
import {SecurityAuthentication} from '../../auth/auth';


import { PerformanceScore } from '../../model/PerformanceScore';
import { ScoringProvider } from '../../model/ScoringProvider';

/**
 * no description
 */
export class PerformanceScoreApiRequestFactory extends BaseAPIRequestFactory {

    /**
     * Creates performance scores for a given site. Supports multiple categories (e.g. energy) and types (e.g. monthly)
     * Update Performance Score
     * @param siteId 
     * @param performanceScore Performance Score to be created
     */
    public async createPerformanceScores(siteId: string, performanceScore?: Array<PerformanceScore>, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'siteId' is not null or undefined
        if (siteId === null || siteId === undefined) {
            throw new RequiredError("PerformanceScoreApi", "createPerformanceScores", "siteId");
        }



        // Path Params
        const localVarPath = '/sites/{site-id}/performance-scores'
            .replace('{' + 'site-id' + '}', encodeURIComponent(String(siteId)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.POST);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")


        // Body Params
        const contentType = ObjectSerializer.getPreferredMediaType([
            "application/json"
        ]);
        requestContext.setHeaderParam("Content-Type", contentType);
        const serializedBody = ObjectSerializer.stringify(
            ObjectSerializer.serialize(performanceScore, "Array<PerformanceScore>", ""),
            contentType
        );
        requestContext.setBody(serializedBody);

        let authMethod: SecurityAuthentication | undefined;
        // Apply auth methods
        authMethod = _config.authMethods["Oauth2AuthCode"]
        if (authMethod?.applySecurityAuthentication) {
            await authMethod?.applySecurityAuthentication(requestContext);
        }
        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Creates a scoring provider resource to associate a site
     * Associate Scoring Application
     * @param siteId 
     * @param scoringProvider Scoring Provider resource to be created
     */
    public async createSiteAssociation(siteId: string, scoringProvider?: ScoringProvider, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'siteId' is not null or undefined
        if (siteId === null || siteId === undefined) {
            throw new RequiredError("PerformanceScoreApi", "createSiteAssociation", "siteId");
        }



        // Path Params
        const localVarPath = '/sites/{site-id}/scoring-providers'
            .replace('{' + 'site-id' + '}', encodeURIComponent(String(siteId)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.POST);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")


        // Body Params
        const contentType = ObjectSerializer.getPreferredMediaType([
            "application/json"
        ]);
        requestContext.setHeaderParam("Content-Type", contentType);
        const serializedBody = ObjectSerializer.stringify(
            ObjectSerializer.serialize(scoringProvider, "ScoringProvider", ""),
            contentType
        );
        requestContext.setBody(serializedBody);

        let authMethod: SecurityAuthentication | undefined;
        // Apply auth methods
        authMethod = _config.authMethods["Oauth2AuthCode"]
        if (authMethod?.applySecurityAuthentication) {
            await authMethod?.applySecurityAuthentication(requestContext);
        }
        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Retrieve all performance scores for a given site
     * Fetch Performance Score
     * @param siteId 
     * @param type 
     * @param category 
     */
    public async listPerformanceScores(siteId: string, type?: Array<'daily' | 'monthly' | 'localAverage' | 'average'>, category?: Array<'energy' | 'water' | 'waste' | 'transportation' | 'humanExperience' | 'reEntry'>, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'siteId' is not null or undefined
        if (siteId === null || siteId === undefined) {
            throw new RequiredError("PerformanceScoreApi", "listPerformanceScores", "siteId");
        }




        // Path Params
        const localVarPath = '/sites/{site-id}/performance-scores'
            .replace('{' + 'site-id' + '}', encodeURIComponent(String(siteId)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.GET);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")

        // Query Params
        if (type !== undefined) {
            requestContext.setQueryParam("type", ObjectSerializer.serialize(type, "Array<'daily' | 'monthly' | 'localAverage' | 'average'>", ""));
        }

        // Query Params
        if (category !== undefined) {
            requestContext.setQueryParam("category", ObjectSerializer.serialize(category, "Array<'energy' | 'water' | 'waste' | 'transportation' | 'humanExperience' | 'reEntry'>", ""));
        }


        let authMethod: SecurityAuthentication | undefined;
        // Apply auth methods
        authMethod = _config.authMethods["Oauth2AuthCode"]
        if (authMethod?.applySecurityAuthentication) {
            await authMethod?.applySecurityAuthentication(requestContext);
        }
        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

}

export class PerformanceScoreApiResponseProcessor {

    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to createPerformanceScores
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async createPerformanceScoresWithHttpInfo(response: ResponseContext): Promise<HttpInfo<Array<PerformanceScore> >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("201", response.httpStatusCode)) {
            const body: Array<PerformanceScore> = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Array<PerformanceScore>", ""
            ) as Array<PerformanceScore>;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, response.status, body);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Error = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Error", ""
            ) as Error;
            throw new ApiException<Error>(response.httpStatusCode, "Bad Request", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Error = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Error", ""
            ) as Error;
            throw new ApiException<Error>(response.httpStatusCode, "Site Not found", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Error = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Error", ""
            ) as Error;
            throw new ApiException<Error>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: Array<PerformanceScore> = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Array<PerformanceScore>", ""
            ) as Array<PerformanceScore>;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, response.status, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }

    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to createSiteAssociation
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async createSiteAssociationWithHttpInfo(response: ResponseContext): Promise<HttpInfo<ScoringProvider >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("201", response.httpStatusCode)) {
            const body: ScoringProvider = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "ScoringProvider", ""
            ) as ScoringProvider;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, response.status, body);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Error = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Error", ""
            ) as Error;
            throw new ApiException<Error>(response.httpStatusCode, "Bad Request", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Error = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Error", ""
            ) as Error;
            throw new ApiException<Error>(response.httpStatusCode, "Site Not found", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Error = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Error", ""
            ) as Error;
            throw new ApiException<Error>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: ScoringProvider = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "ScoringProvider", ""
            ) as ScoringProvider;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, response.status, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }

    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to listPerformanceScores
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async listPerformanceScoresWithHttpInfo(response: ResponseContext): Promise<HttpInfo<Array<PerformanceScore> >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.status)) {
            const body: Array<PerformanceScore> = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.data, contentType),
                "Array<PerformanceScore>", ""
            ) as Array<PerformanceScore>;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, response.status, body);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Error = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Error", ""
            ) as Error;
            throw new ApiException<Error>(response.httpStatusCode, "Bad Request", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Error = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Error", ""
            ) as Error;
            throw new ApiException<Error>(response.httpStatusCode, "Site Not found", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Error = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Error", ""
            ) as Error;
            throw new ApiException<Error>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: Array<PerformanceScore> = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Array<PerformanceScore>", ""
            ) as Array<PerformanceScore>;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, response.status, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }

}
