import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../http/http';
import { Configuration} from '../configuration'

import { Address } from '../model/Address';
import { Coordinates } from '../model/Coordinates';
import { ErrorInvalidParamsInner } from '../model/ErrorInvalidParamsInner';
import { Measurement } from '../model/Measurement';
import { MeasurementTimeseries } from '../model/MeasurementTimeseries';
import { Meter } from '../model/Meter';
import { ModelError } from '../model/ModelError';
import { PerformanceScore } from '../model/PerformanceScore';
import { ScoringProvider } from '../model/ScoringProvider';
import { Site } from '../model/Site';
import { SiteMetadata } from '../model/SiteMetadata';
import { Timeserie } from '../model/Timeserie';
import { TimeserieValuesInner } from '../model/TimeserieValuesInner';

import { ObservableMeterApi } from "./ObservableAPI";
import { MeterApiRequestFactory, MeterApiResponseProcessor} from "../client/apis/MeterApi";

export interface MeterApiListMetersRequest {
    /**
     * 
     * @type string
     * @memberof MeterApilistMeters
     */
    siteId: string
}

export class ObjectMeterApi {
    private api: ObservableMeterApi

    public constructor(configuration: Configuration, requestFactory?: MeterApiRequestFactory, responseProcessor?: MeterApiResponseProcessor) {
        this.api = new ObservableMeterApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Retrieve all meters installed at a given site
     * Fetch Meters
     * @param param the request object
     */
    public listMetersWithHttpInfo(param: MeterApiListMetersRequest, options?: Configuration): Promise<HttpInfo<Array<Meter>>> {
        return this.api.listMetersWithHttpInfo(param.siteId,  options).toPromise();
    }

    /**
     * Retrieve all meters installed at a given site
     * Fetch Meters
     * @param param the request object
     */
    public listMeters(param: MeterApiListMetersRequest, options?: Configuration): Promise<Array<Meter>> {
        return this.api.listMeters(param.siteId,  options).toPromise();
    }

}

import { ObservablePerformanceScoreApi } from "./ObservableAPI";
import { PerformanceScoreApiRequestFactory, PerformanceScoreApiResponseProcessor} from "../client/apis/PerformanceScoreApi";

export interface PerformanceScoreApiCreatePerformanceScoresRequest {
    /**
     * 
     * @type string
     * @memberof PerformanceScoreApicreatePerformanceScores
     */
    siteId: string
    /**
     * Performance Score to be created
     * @type Array&lt;PerformanceScore&gt;
     * @memberof PerformanceScoreApicreatePerformanceScores
     */
    performanceScore?: Array<PerformanceScore>
}

export interface PerformanceScoreApiCreateSiteAssociationRequest {
    /**
     * 
     * @type string
     * @memberof PerformanceScoreApicreateSiteAssociation
     */
    siteId: string
    /**
     * Scoring Provider resource to be created
     * @type ScoringProvider
     * @memberof PerformanceScoreApicreateSiteAssociation
     */
    scoringProvider?: ScoringProvider
}

export interface PerformanceScoreApiListPerformanceScoresRequest {
    /**
     * 
     * @type string
     * @memberof PerformanceScoreApilistPerformanceScores
     */
    siteId: string
    /**
     * 
     * @type Array&lt;&#39;daily&#39; | &#39;monthly&#39; | &#39;localAverage&#39; | &#39;average&#39;&gt;
     * @memberof PerformanceScoreApilistPerformanceScores
     */
    type?: Array<'daily' | 'monthly' | 'localAverage' | 'average'>
    /**
     * 
     * @type Array&lt;&#39;energy&#39; | &#39;water&#39; | &#39;waste&#39; | &#39;transportation&#39; | &#39;humanExperience&#39; | &#39;reEntry&#39;&gt;
     * @memberof PerformanceScoreApilistPerformanceScores
     */
    category?: Array<'energy' | 'water' | 'waste' | 'transportation' | 'humanExperience' | 'reEntry'>
}

export class ObjectPerformanceScoreApi {
    private api: ObservablePerformanceScoreApi

    public constructor(configuration: Configuration, requestFactory?: PerformanceScoreApiRequestFactory, responseProcessor?: PerformanceScoreApiResponseProcessor) {
        this.api = new ObservablePerformanceScoreApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Creates performance scores for a given site. Supports multiple categories (e.g. energy) and types (e.g. monthly)
     * Update Performance Score
     * @param param the request object
     */
    public createPerformanceScoresWithHttpInfo(param: PerformanceScoreApiCreatePerformanceScoresRequest, options?: Configuration): Promise<HttpInfo<Array<PerformanceScore>>> {
        return this.api.createPerformanceScoresWithHttpInfo(param.siteId, param.performanceScore,  options).toPromise();
    }

    /**
     * Creates performance scores for a given site. Supports multiple categories (e.g. energy) and types (e.g. monthly)
     * Update Performance Score
     * @param param the request object
     */
    public createPerformanceScores(param: PerformanceScoreApiCreatePerformanceScoresRequest, options?: Configuration): Promise<Array<PerformanceScore>> {
        return this.api.createPerformanceScores(param.siteId, param.performanceScore,  options).toPromise();
    }

    /**
     * Creates a scoring provider resource to associate a site
     * Associate Scoring Application
     * @param param the request object
     */
    public createSiteAssociationWithHttpInfo(param: PerformanceScoreApiCreateSiteAssociationRequest, options?: Configuration): Promise<HttpInfo<ScoringProvider>> {
        return this.api.createSiteAssociationWithHttpInfo(param.siteId, param.scoringProvider,  options).toPromise();
    }

    /**
     * Creates a scoring provider resource to associate a site
     * Associate Scoring Application
     * @param param the request object
     */
    public createSiteAssociation(param: PerformanceScoreApiCreateSiteAssociationRequest, options?: Configuration): Promise<ScoringProvider> {
        return this.api.createSiteAssociation(param.siteId, param.scoringProvider,  options).toPromise();
    }

    /**
     * Retrieve all performance scores for a given site
     * Fetch Performance Score
     * @param param the request object
     */
    public listPerformanceScoresWithHttpInfo(param: PerformanceScoreApiListPerformanceScoresRequest, options?: Configuration): Promise<HttpInfo<Array<PerformanceScore>>> {
        return this.api.listPerformanceScoresWithHttpInfo(param.siteId, param.type, param.category,  options).toPromise();
    }

    /**
     * Retrieve all performance scores for a given site
     * Fetch Performance Score
     * @param param the request object
     */
    public listPerformanceScores(param: PerformanceScoreApiListPerformanceScoresRequest, options?: Configuration): Promise<Array<PerformanceScore>> {
        return this.api.listPerformanceScores(param.siteId, param.type, param.category,  options).toPromise();
    }

}

import { ObservableSiteApi } from "./ObservableAPI";
import { SiteApiRequestFactory, SiteApiResponseProcessor} from "../client/apis/SiteApi";

export interface SiteApiListSitesRequest {
}

export class ObjectSiteApi {
    private api: ObservableSiteApi

    public constructor(configuration: Configuration, requestFactory?: SiteApiRequestFactory, responseProcessor?: SiteApiResponseProcessor) {
        this.api = new ObservableSiteApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Retrieve all sites and related metadata
     * Fetch sites
     * @param param the request object
     */
    public listSitesWithHttpInfo(param: SiteApiListSitesRequest = {}, options?: Configuration): Promise<HttpInfo<Array<Site>>> {
        return this.api.listSitesWithHttpInfo( options).toPromise();
    }

    /**
     * Retrieve all sites and related metadata
     * Fetch sites
     * @param param the request object
     */
    public listSites(param: SiteApiListSitesRequest = {}, options?: Configuration): Promise<Array<Site>> {
        return this.api.listSites( options).toPromise();
    }

}

import { ObservableTimeseriesApi } from "./ObservableAPI";
import { TimeseriesApiRequestFactory, TimeseriesApiResponseProcessor} from "../client/apis/TimeseriesApi";

export interface TimeseriesApiListMetricsRequest {
    /**
     * 
     * @type string
     * @memberof TimeseriesApilistMetrics
     */
    siteId: string
    /**
     * 
     * @type Date
     * @memberof TimeseriesApilistMetrics
     */
    updatedAtGte?: Date
    /**
     * 
     * @type Date
     * @memberof TimeseriesApilistMetrics
     */
    updatedAtLt?: Date
}

export class ObjectTimeseriesApi {
    private api: ObservableTimeseriesApi

    public constructor(configuration: Configuration, requestFactory?: TimeseriesApiRequestFactory, responseProcessor?: TimeseriesApiResponseProcessor) {
        this.api = new ObservableTimeseriesApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Get all building measurement data to calculate scores
     * Fetch Timeseries
     * @param param the request object
     */
    public listMetricsWithHttpInfo(param: TimeseriesApiListMetricsRequest, options?: Configuration): Promise<HttpInfo<Array<Timeserie>>> {
        return this.api.listMetricsWithHttpInfo(param.siteId, param.updatedAtGte, param.updatedAtLt,  options).toPromise();
    }

    /**
     * Get all building measurement data to calculate scores
     * Fetch Timeseries
     * @param param the request object
     */
    public listMetrics(param: TimeseriesApiListMetricsRequest, options?: Configuration): Promise<Array<Timeserie>> {
        return this.api.listMetrics(param.siteId, param.updatedAtGte, param.updatedAtLt,  options).toPromise();
    }

}
