import {
  AuthMethodsConfiguration,
  OAuth2Configuration,
  SiteApi,
  createConfiguration,
} from "..";
import { ConfigurationParameters } from "../configuration";
// Constants
const STATUS_400: string = "400";
const SUCCESS_200: string = "200";
const BAD_REQUEST: string = "Bad Request";

export function getSiteApi(commandArguments: string[]): any {
  let accessToken: string | undefined = fetchCommandArgumentData(
    commandArguments,
    "token"
  );

  if (commandArguments.length < 2) {
    throwBadRequestMessageForInvalidParams(["accessToken"].join(", "));
    return;
  }

  if (!accessToken) {
    throwBadRequestMessageForInvalidParams("accessToken");
    return;
  }

  const oAuth2CodeAccessToken: ConfigurationParameters = oAuth2CodetokenAccesstokenConfiguration(accessToken);
  const configuration = createConfiguration(oAuth2CodeAccessToken);
  const apiInstance = new SiteApi(configuration);

  apiInstance
    .listSites()
    .then((data) => {
      console.log("Status= "+SUCCESS_200);
      console.log(JSON.stringify(data));
      
      //console.log(JSON.stringify(data));
    })
    .catch((error: any) => {
      console.error("Status= " + error?.response?.status);
      console.error(error?.response?.data);
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
    type: "/sites",
    title: BAD_REQUEST,
    status: STATUS_400,
    detail: param.concat(" cannot be empty"),
  };
  return JSON.stringify(errorMessage, null, 1);
}


