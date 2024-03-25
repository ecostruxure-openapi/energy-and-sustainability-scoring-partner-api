//Constants
const STATUS_400 = "400";
const SUCCESS_200 = "200";
const BAD_REQUEST = "Bad Request";

function getPerformanceScoreApi(commandArguments) {
  let accessToken = fetchCommandArgumentData(commandArguments, "token");
  let siteId = fetchCommandArgumentData(commandArguments, "siteId");
  let categoryList = fetchCommandArgumentDataForList(commandArguments, "category");
  let typeList = fetchCommandArgumentDataForList(commandArguments, "type");
  
  if (!accessToken) {
    throwBadRequestMessageForInvalidParams("accessToken");
    return;
  }

  if (!siteId) {
    throwBadRequestMessageForInvalidParams("siteId");
    return;
  }

  const EcoStruxureEnergySustainabilityScoringPartnerApi = require("../../../../../code-samples/javascript");

  let defaultClient =
    EcoStruxureEnergySustainabilityScoringPartnerApi.ApiClient.instance;
  let Oauth2AuthCode = defaultClient.authentications["Oauth2AuthCode"];
  Oauth2AuthCode.accessToken = accessToken;

  let api = new EcoStruxureEnergySustainabilityScoringPartnerApi.PerformanceScoreApi();
  let callback = function (error, data, response) {
    if (error) {
      console.error('Status= '+error?.status);
      console.error(error?.response?.body);
    } else {
      console.log("Status= "+ SUCCESS_200)
      console.log(JSON.stringify(data, 0, 1)
      );
    }
  };
  let opts = {
    category: categoryList?.length > 0 ? categoryList : null,
    type: typeList?.length > 0 ? typeList : null
  }
  api.listPerformanceScores(siteId, opts, callback);
}

function fetchCommandArgumentData(commandArguments, param) {
  const commanArgumentDataWithParam = commandArguments.find((api) =>
    api.startsWith(param)
  );
  let data = commanArgumentDataWithParam
    ? commanArgumentDataWithParam.split("=")[1]
    : null;
  return data;
}

function fetchCommandArgumentDataForList(commandArguments, param) {
  let dataList = [];
  commandArguments.forEach(listData => {
  if(listData.startsWith(param)){
    let data = listData.split("=")[1];
    dataList.push(data)
  }
 })
  return dataList;
}

function throwBadRequestMessageForInvalidParams(param) {
  console.warn("Status= " + STATUS_400);
  console.warn(formatBadRequestErrorMessage(param));
}

function formatBadRequestErrorMessage(param) {
  let errorMessage = {
    type: "/performanceScore",
    title: BAD_REQUEST,
    status: STATUS_400,
    detail: param.concat(" cannot be empty"),
  };
  return JSON.stringify(errorMessage, 0, 1);
}


module.exports = { getPerformanceScoreApi }
