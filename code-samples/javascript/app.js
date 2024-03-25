const {  getSiteApi, getMetersApi, getPerformanceScoreApi, 
    getTimeSeriesApi } = require('./src/invoker/example/index')

//Constants
const GET_METERS = 'GetMeters';
const GET_PERFORMANCE_SCORE = 'GetPerformanceScore';
const GET_SITE = 'GetSites';
const GET_TIMESERIES = 'GetTimeSeries';

const commandArguments = process.argv.slice(2);

const fileName = commandArguments.find((api) => api.startsWith('file='));
let file = fileName ? fileName.split('=')[1] : null;

    switch(file){
        case GET_METERS: getMetersApi(commandArguments);
        break;
        case GET_PERFORMANCE_SCORE: getPerformanceScoreApi(commandArguments);
        break;
        case GET_SITE: getSiteApi(commandArguments);
        break;
        case GET_TIMESERIES: getTimeSeriesApi(commandArguments);
        break;
        default: console.warn("Invalid API name.")
    }




