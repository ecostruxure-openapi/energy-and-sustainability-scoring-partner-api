import { TimeseriesApi, createConfiguration } from "..";
import { ConfigurationParameters } from "../configuration";
import { TimeseriesApiListMetricsRequest } from "../types/ObjectParamAPI";

// Constants
const STATUS_400: string = "400";
const SUCCESS_200: string = "200";
const BAD_REQUEST: string = "Bad Request";

function getTimeSeriesApi(commandArguments: string[]): void {
  let accessToken: string | undefined = fetchCommandArgumentData(commandArguments, "token");
  let siteId: string | undefined = fetchCommandArgumentData(commandArguments, "siteId");
  let updatedAtLte: string | undefined = fetchCommandArgumentData(commandArguments, "updatedAtLte");
  let updatedAtGte: string | undefined = fetchCommandArgumentData(commandArguments, "updatedAtGte");

  if (!accessToken) {
    throwBadRequestMessageForInvalidParams("accessToken");
    return;
  }

  if (!siteId) {
    throwBadRequestMessageForInvalidParams("siteId");
    return;
  }

  if (!updatedAtLte) {
    throwBadRequestMessageForInvalidParams("updatedAtLte");
    return;
  }

  if (!updatedAtGte) {
    throwBadRequestMessageForInvalidParams("updatedAtGte");
    return;
  }

const oAuth2CodeAccessToken: ConfigurationParameters = oAuth2CodetokenAccesstokenConfiguration(accessToken);
const configuration = createConfiguration(oAuth2CodeAccessToken);
const apiInstance = new TimeseriesApi(configuration);

let body:TimeseriesApiListMetricsRequest = {
  siteId: siteId,
  updatedAtGte: new Date(updatedAtGte),
  updatedAtLt: new Date(updatedAtLte),
};

apiInstance.listMetrics(body?.siteId, body?.updatedAtGte, body?.updatedAtLt).then((data:any) => {
  console.log("STATUS: "+ SUCCESS_200);  
  console.log(JSON.stringify(data));
}).catch((error: any) => {
  console.error("Status= " + error.response.status);
  console.error(error.response.data);
});
}

function oAuth2CodetokenAccesstokenConfiguration(accessToken: string): ConfigurationParameters {
  return {
    authMethods: {
      Oauth2AuthCode: {
        accessToken: accessToken
      }
    }
  };
}

function fetchCommandArgumentData(commandArguments: string[], param: string): string | undefined {
  const commanArgumentDataWithParam: string | undefined = commandArguments.find((api: string) =>
    api.startsWith(param)
  );

  let data: string | undefined = commanArgumentDataWithParam
    ? commanArgumentDataWithParam.split("=")[1]
    : undefined;

  return data;
}

function throwBadRequestMessageForInvalidParams(param: string): void {
  console.warn("Status= " + STATUS_400);
  console.warn(formatBadRequestErrorMessage(param));
}

function formatBadRequestErrorMessage(param: string): string {
  let errorMessage: any = {
    type: "/time-series",
    title: BAD_REQUEST,
    status: STATUS_400,
    detail: param.concat(" cannot be empty"),
  };
  return JSON.stringify(errorMessage);
}

export { getTimeSeriesApi };
