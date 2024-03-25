import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../http/http';
import { Configuration} from '../configuration'
import { Observable, of, from } from '../rxjsStub';
import {mergeMap, map} from  '../rxjsStub';
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

import { MeterApiRequestFactory, MeterApiResponseProcessor} from "../client/apis/MeterApi";
export class ObservableMeterApi {
    private requestFactory: MeterApiRequestFactory;
    private responseProcessor: MeterApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: MeterApiRequestFactory,
        responseProcessor?: MeterApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new MeterApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new MeterApiResponseProcessor();
    }

    /**
     * Retrieve all meters installed at a given site
     * Fetch Meters
     * @param siteId 
     */
    public listMetersWithHttpInfo(siteId: string, _options?: Configuration): Observable<HttpInfo<Array<Meter>>> {
        const requestContextPromise = this.requestFactory.listMeters(siteId, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.listMetersWithHttpInfo(rsp)));
            }));
    }

    /**
     * Retrieve all meters installed at a given site
     * Fetch Meters
     * @param siteId 
     */
    public listMeters(siteId: string, _options?: Configuration): Observable<Array<Meter>> {
        return this.listMetersWithHttpInfo(siteId, _options).pipe(map((apiResponse: HttpInfo<Array<Meter>>) => apiResponse.data));
    }

}

import { PerformanceScoreApiRequestFactory, PerformanceScoreApiResponseProcessor} from "../client/apis/PerformanceScoreApi";
export class ObservablePerformanceScoreApi {
    private requestFactory: PerformanceScoreApiRequestFactory;
    private responseProcessor: PerformanceScoreApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: PerformanceScoreApiRequestFactory,
        responseProcessor?: PerformanceScoreApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new PerformanceScoreApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new PerformanceScoreApiResponseProcessor();
    }

    /**
     * Creates performance scores for a given site. Supports multiple categories (e.g. energy) and types (e.g. monthly)
     * Update Performance Score
     * @param siteId 
     * @param performanceScore Performance Score to be created
     */
    public createPerformanceScoresWithHttpInfo(siteId: string, performanceScore?: Array<PerformanceScore>, _options?: Configuration): Observable<HttpInfo<Array<PerformanceScore>>> {
        const requestContextPromise = this.requestFactory.createPerformanceScores(siteId, performanceScore, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.createPerformanceScoresWithHttpInfo(rsp)));
            }));
    }

    /**
     * Creates performance scores for a given site. Supports multiple categories (e.g. energy) and types (e.g. monthly)
     * Update Performance Score
     * @param siteId 
     * @param performanceScore Performance Score to be created
     */
    public createPerformanceScores(siteId: string, performanceScore?: Array<PerformanceScore>, _options?: Configuration): Observable<Array<PerformanceScore>> {
        return this.createPerformanceScoresWithHttpInfo(siteId, performanceScore, _options).pipe(map((apiResponse: HttpInfo<Array<PerformanceScore>>) => apiResponse.data));
    }

    /**
     * Creates a scoring provider resource to associate a site
     * Associate Scoring Application
     * @param siteId 
     * @param scoringProvider Scoring Provider resource to be created
     */
    public createSiteAssociationWithHttpInfo(siteId: string, scoringProvider?: ScoringProvider, _options?: Configuration): Observable<HttpInfo<ScoringProvider>> {
        const requestContextPromise = this.requestFactory.createSiteAssociation(siteId, scoringProvider, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.createSiteAssociationWithHttpInfo(rsp)));
            }));
    }

    /**
     * Creates a scoring provider resource to associate a site
     * Associate Scoring Application
     * @param siteId 
     * @param scoringProvider Scoring Provider resource to be created
     */
    public createSiteAssociation(siteId: string, scoringProvider?: ScoringProvider, _options?: Configuration): Observable<ScoringProvider> {
        return this.createSiteAssociationWithHttpInfo(siteId, scoringProvider, _options).pipe(map((apiResponse: HttpInfo<ScoringProvider>) => apiResponse.data));
    }

    /**
     * Retrieve all performance scores for a given site
     * Fetch Performance Score
     * @param siteId 
     * @param type 
     * @param category 
     */
    public listPerformanceScoresWithHttpInfo(siteId: string, type?: Array<'daily' | 'monthly' | 'localAverage' | 'average'>, category?: Array<'energy' | 'water' | 'waste' | 'transportation' | 'humanExperience' | 'reEntry'>, _options?: Configuration): Observable<HttpInfo<Array<PerformanceScore>>> {
        const requestContextPromise = this.requestFactory.listPerformanceScores(siteId, type, category, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.listPerformanceScoresWithHttpInfo(rsp)));
            }));
    }

    /**
     * Retrieve all performance scores for a given site
     * Fetch Performance Score
     * @param siteId 
     * @param type 
     * @param category 
     */
    public listPerformanceScores(siteId: string, type?: Array<'daily' | 'monthly' | 'localAverage' | 'average'>, category?: Array<'energy' | 'water' | 'waste' | 'transportation' | 'humanExperience' | 'reEntry'>, _options?: Configuration): Observable<Array<PerformanceScore>> {
        return this.listPerformanceScoresWithHttpInfo(siteId, type, category, _options).pipe(map((apiResponse: HttpInfo<Array<PerformanceScore>>) => apiResponse.data));
    }

}

import { SiteApiRequestFactory, SiteApiResponseProcessor} from "../client/apis/SiteApi";
export class ObservableSiteApi {
    private requestFactory: SiteApiRequestFactory;
    private responseProcessor: SiteApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: SiteApiRequestFactory,
        responseProcessor?: SiteApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new SiteApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new SiteApiResponseProcessor();
    }

    /**
     * Retrieve all sites and related metadata
     * Fetch sites
     */
    public listSitesWithHttpInfo(_options?: Configuration): Observable<HttpInfo<Array<Site>>> {
        const requestContextPromise = this.requestFactory.listSites(_options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.listSitesWithHttpInfo(rsp)));
            }));
    }

    /**
     * Retrieve all sites and related metadata
     * Fetch sites
     */
    public listSites(_options?: Configuration): Observable<Array<Site>> {
        return this.listSitesWithHttpInfo(_options).pipe(map((apiResponse: HttpInfo<Array<Site>>) => apiResponse.data));
    }

}

import { TimeseriesApiRequestFactory, TimeseriesApiResponseProcessor} from "../client/apis/TimeseriesApi";
export class ObservableTimeseriesApi {
    private requestFactory: TimeseriesApiRequestFactory;
    private responseProcessor: TimeseriesApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: TimeseriesApiRequestFactory,
        responseProcessor?: TimeseriesApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new TimeseriesApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new TimeseriesApiResponseProcessor();
    }

    /**
     * Get all building measurement data to calculate scores
     * Fetch Timeseries
     * @param siteId 
     * @param updatedAtGte 
     * @param updatedAtLt 
     */
    public listMetricsWithHttpInfo(siteId: string, updatedAtGte?: Date, updatedAtLt?: Date, _options?: Configuration): Observable<HttpInfo<Array<Timeserie>>> {
        const requestContextPromise = this.requestFactory.listMetrics(siteId, updatedAtGte, updatedAtLt, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.listMetricsWithHttpInfo(rsp)));
            }));
    }

    /**
     * Get all building measurement data to calculate scores
     * Fetch Timeseries
     * @param siteId 
     * @param updatedAtGte 
     * @param updatedAtLt 
     */
    public listMetrics(siteId: string, updatedAtGte?: Date, updatedAtLt?: Date, _options?: Configuration): Observable<Array<Timeserie>> {
        return this.listMetricsWithHttpInfo(siteId, updatedAtGte, updatedAtLt, _options).pipe(map((apiResponse: HttpInfo<Array<Timeserie>>) => apiResponse.data));
    }

}
