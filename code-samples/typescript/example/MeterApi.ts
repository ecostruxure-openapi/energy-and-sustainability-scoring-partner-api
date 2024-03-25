import { MeterApi, createConfiguration } from "..";
import { ConfigurationParameters } from "../configuration";
import { MeterApiListMetersRequest } from "../types/ObjectParamAPI";

// Constants
const STATUS_400: string = "400";
const SUCCESS_200: string = "200";
const BAD_REQUEST: string = "Bad Request";

export function getMetersApi(commandArguments: string[]): void {
  let accessToken: string | undefined = fetchCommandArgumentData(
    commandArguments,
    "token"
  );
  let siteId: string | undefined = fetchCommandArgumentData(
    commandArguments,
    "siteId"
  );

  if (commandArguments.length < 3) {
    throwBadRequestMessageForInvalidParams(
      ["accessToken", "siteId"].join(", ")
    );
    return;
  }

  if (!accessToken) {
    throwBadRequestMessageForInvalidParams("accessToken");
    return;
  }

  if (!siteId) {
    throwBadRequestMessageForInvalidParams("siteId");
    return;
  }
  const oAuth2CodeAccessToken: ConfigurationParameters =
    oAuth2CodetokenAccesstokenConfiguration(accessToken);
  const configuration = createConfiguration(oAuth2CodeAccessToken);
  const apiInstance = new MeterApi(configuration);

  let body: MeterApiListMetersRequest = {
    siteId: siteId,
  };
  
  apiInstance
    .listMeters(body.siteId)
    .then((data: any) => {
      console.log("Status= " + SUCCESS_200);
      console.log(JSON.stringify(data));
    })
    .catch((error: any) => {
      console.error("Status= " + error.response.status);
      console.error(error.response.data);
    });
}

function oAuth2CodetokenAccesstokenConfiguration(
  accessToken: string
): ConfigurationParameters {
  return {
    authMethods: {
      Oauth2AuthCode: {
        accessToken: accessToken,
      },
    },
  };
}

function fetchCommandArgumentData(
  commandArguments: string[],
  param: string
): string | undefined {
  const commanArgumentDataWithParam: string | undefined = commandArguments.find(
    (api: string) => api.startsWith(param)
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
    type: "/meters",
    title: BAD_REQUEST,
    status: STATUS_400,
    detail: param.concat(" cannot be empty"),
  };
  return JSON.stringify(errorMessage, null, 1);
}
