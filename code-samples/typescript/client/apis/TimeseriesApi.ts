// TODO: better import syntax?
import {BaseAPIRequestFactory, RequiredError, COLLECTION_FORMATS} from '../../apis/baseapi';
import { Configuration } from '../../configuration';
import {RequestContext, HttpMethod, ResponseContext, HttpFile, HttpInfo} from '../../http/http';
import {ObjectSerializer} from '../../models/ObjectSerializer';
import { ApiException } from '../../apis/exception';
import {canConsumeForm, isCodeInRange} from '../../util';
import {SecurityAuthentication} from '../../auth/auth';


import { Timeserie } from '../../model/Timeserie';

/**
 * no description
 */
export class TimeseriesApiRequestFactory extends BaseAPIRequestFactory {

    /**
     * Get all building measurement data to calculate scores
     * Fetch Timeseries
     * @param siteId 
     * @param updatedAtGte 
     * @param updatedAtLt 
     */
    public async listMetrics(siteId: string, updatedAtGte?: Date, updatedAtLt?: Date, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'siteId' is not null or undefined
        if (siteId === null || siteId === undefined) {
            throw new RequiredError("TimeseriesApi", "listMetrics", "siteId");
        }




        // Path Params
        const localVarPath = '/sites/{site-id}/timeseries'
            .replace('{' + 'site-id' + '}', encodeURIComponent(String(siteId)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.GET);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")

        // Query Params
        if (updatedAtGte !== undefined) {
            requestContext.setQueryParam("updatedAt[gte]", ObjectSerializer.serialize(updatedAtGte, "Date", "date-time"));
        }

        // Query Params
        if (updatedAtLt !== undefined) {
            requestContext.setQueryParam("updatedAt[lt]", ObjectSerializer.serialize(updatedAtLt, "Date", "date-time"));
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

export class TimeseriesApiResponseProcessor {

    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to listMetrics
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async listMetricsWithHttpInfo(response: ResponseContext): Promise<HttpInfo<Array<Timeserie> >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.status)) {
            const body: Array<Timeserie> = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.data, contentType),
                "Array<Timeserie>", ""
            ) as Array<Timeserie>;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, response.status, body);
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
            const body: Array<Timeserie> = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Array<Timeserie>", ""
            ) as Array<Timeserie>;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, response.status, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }

}
