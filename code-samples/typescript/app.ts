import { getMetersApi, getPerformanceScoreApi, getTimeSeriesApi } from "./example";
import { getSiteApi } from "./example/SiteApi";

// Constants
const GET_METERS: string = 'GetMeters';
const GET_PERFORMANCE_SCORE: string = 'GetPerformanceScore';
const GET_SITE: string = 'GetSites';
const GET_TIMESERIES: string = 'GetTimeSeries';

let commandArguments = process.argv.slice(2);

let fileName = commandArguments.find(api => api.startsWith('file='));
let file = fileName ? fileName.split('=')[1] : null;

switch (file) {
  case GET_METERS:
    getMetersApi(commandArguments);
    break;
  case GET_PERFORMANCE_SCORE:
    getPerformanceScoreApi(commandArguments);
    break;
  case GET_SITE:
    getSiteApi(commandArguments);
    break;
  case GET_TIMESERIES:
    getTimeSeriesApi(commandArguments);
    break;
  default:
    console.warn("Invalid API name.");
}
