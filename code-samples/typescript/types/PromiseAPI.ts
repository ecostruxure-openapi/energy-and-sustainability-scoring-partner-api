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
import { ObservableMeterApi } from './ObservableAPI';

import { MeterApiRequestFactory, MeterApiResponseProcessor} from "../client/apis/MeterApi";
export class PromiseMeterApi {
    private api: ObservableMeterApi

    public constructor(
        configuration: Configuration,
        requestFactory?: MeterApiRequestFactory,
        responseProcessor?: MeterApiResponseProcessor
    ) {
        this.api = new ObservableMeterApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Retrieve all meters installed at a given site
     * Fetch Meters
     * @param siteId 
     */
    public listMetersWithHttpInfo(siteId: string, _options?: Configuration): Promise<HttpInfo<Array<Meter>>> {
        const result = this.api.listMetersWithHttpInfo(siteId, _options);
        return result.toPromise();
    }

    /**
     * Retrieve all meters installed at a given site
     * Fetch Meters
     * @param siteId 
     */
    public listMeters(siteId: string, _options?: Configuration): Promise<Array<Meter>> {
        const result = this.api.listMeters(siteId, _options);
        return result.toPromise();
    }


}



import { ObservablePerformanceScoreApi } from './ObservableAPI';

import { PerformanceScoreApiRequestFactory, PerformanceScoreApiResponseProcessor} from "../client/apis/PerformanceScoreApi";
export class PromisePerformanceScoreApi {
    private api: ObservablePerformanceScoreApi

    public constructor(
        configuration: Configuration,
        requestFactory?: PerformanceScoreApiRequestFactory,
        responseProcessor?: PerformanceScoreApiResponseProcessor
    ) {
        this.api = new ObservablePerformanceScoreApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Creates performance scores for a given site. Supports multiple categories (e.g. energy) and types (e.g. monthly)
     * Update Performance Score
     * @param siteId 
     * @param performanceScore Performance Score to be created
     */
    public createPerformanceScoresWithHttpInfo(siteId: string, performanceScore?: Array<PerformanceScore>, _options?: Configuration): Promise<HttpInfo<Array<PerformanceScore>>> {
        const result = this.api.createPerformanceScoresWithHttpInfo(siteId, performanceScore, _options);
        return result.toPromise();
    }

    /**
     * Creates performance scores for a given site. Supports multiple categories (e.g. energy) and types (e.g. monthly)
     * Update Performance Score
     * @param siteId 
     * @param performanceScore Performance Score to be created
     */
    public createPerformanceScores(siteId: string, performanceScore?: Array<PerformanceScore>, _options?: Configuration): Promise<Array<PerformanceScore>> {
        const result = this.api.createPerformanceScores(siteId, performanceScore, _options);
        return result.toPromise();
    }

    /**
     * Creates a scoring provider resource to associate a site
     * Associate Scoring Application
     * @param siteId 
     * @param scoringProvider Scoring Provider resource to be created
     */
    public createSiteAssociationWithHttpInfo(siteId: string, scoringProvider?: ScoringProvider, _options?: Configuration): Promise<HttpInfo<ScoringProvider>> {
        const result = this.api.createSiteAssociationWithHttpInfo(siteId, scoringProvider, _options);
        return result.toPromise();
    }

    /**
     * Creates a scoring provider resource to associate a site
     * Associate Scoring Application
     * @param siteId 
     * @param scoringProvider Scoring Provider resource to be created
     */
    public createSiteAssociation(siteId: string, scoringProvider?: ScoringProvider, _options?: Configuration): Promise<ScoringProvider> {
        const result = this.api.createSiteAssociation(siteId, scoringProvider, _options);
        return result.toPromise();
    }

    /**
     * Retrieve all performance scores for a given site
     * Fetch Performance Score
     * @param siteId 
     * @param type 
     * @param category 
     */
    public listPerformanceScoresWithHttpInfo(siteId: string, type?: Array<'daily' | 'monthly' | 'localAverage' | 'average'>, category?: Array<'energy' | 'water' | 'waste' | 'transportation' | 'humanExperience' | 'reEntry'>, _options?: Configuration): Promise<HttpInfo<Array<PerformanceScore>>> {
        const result = this.api.listPerformanceScoresWithHttpInfo(siteId, type, category, _options);
        return result.toPromise();
    }

    /**
     * Retrieve all performance scores for a given site
     * Fetch Performance Score
     * @param siteId 
     * @param type 
     * @param category 
     */
    public listPerformanceScores(siteId: string, type?: Array<'daily' | 'monthly' | 'localAverage' | 'average'>, category?: Array<'energy' | 'water' | 'waste' | 'transportation' | 'humanExperience' | 'reEntry'>, _options?: Configuration): Promise<Array<PerformanceScore>> {
        const result = this.api.listPerformanceScores(siteId, type, category, _options);
        return result.toPromise();
    }


}



import { ObservableSiteApi } from './ObservableAPI';

import { SiteApiRequestFactory, SiteApiResponseProcessor} from "../client/apis/SiteApi";
export class PromiseSiteApi {
    private api: ObservableSiteApi

    public constructor(
        configuration: Configuration,
        requestFactory?: SiteApiRequestFactory,
        responseProcessor?: SiteApiResponseProcessor
    ) {
        this.api = new ObservableSiteApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Retrieve all sites and related metadata
     * Fetch sites
     */
    public listSitesWithHttpInfo(_options?: Configuration): Promise<HttpInfo<Array<Site>>> {
        const result = this.api.listSitesWithHttpInfo(_options);
        return result.toPromise();
    }

    /**
     * Retrieve all sites and related metadata
     * Fetch sites
     */
    public listSites(_options?: Configuration): Promise<Array<Site>> {
        const result = this.api.listSites(_options);
        return result.toPromise();
    }


}



import { ObservableTimeseriesApi } from './ObservableAPI';

import { TimeseriesApiRequestFactory, TimeseriesApiResponseProcessor} from "../client/apis/TimeseriesApi";
export class PromiseTimeseriesApi {
    private api: ObservableTimeseriesApi

    public constructor(
        configuration: Configuration,
        requestFactory?: TimeseriesApiRequestFactory,
        responseProcessor?: TimeseriesApiResponseProcessor
    ) {
        this.api = new ObservableTimeseriesApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Get all building measurement data to calculate scores
     * Fetch Timeseries
     * @param siteId 
     * @param updatedAtGte 
     * @param updatedAtLt 
     */
    public listMetricsWithHttpInfo(siteId: string, updatedAtGte?: Date, updatedAtLt?: Date, _options?: Configuration): Promise<HttpInfo<Array<Timeserie>>> {
        const result = this.api.listMetricsWithHttpInfo(siteId, updatedAtGte, updatedAtLt, _options);
        return result.toPromise();
    }

    /**
     * Get all building measurement data to calculate scores
     * Fetch Timeseries
     * @param siteId 
     * @param updatedAtGte 
     * @param updatedAtLt 
     */
    public listMetrics(siteId: string, updatedAtGte?: Date, updatedAtLt?: Date, _options?: Configuration): Promise<Array<Timeserie>> {
        const result = this.api.listMetrics(siteId, updatedAtGte, updatedAtLt, _options);
        return result.toPromise();
    }


}



