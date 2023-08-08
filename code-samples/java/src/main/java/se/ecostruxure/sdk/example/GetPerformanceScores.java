package se.ecostruxure.sdk.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.ecostruxure.sdk.client.PerformanceScoreApi;
import se.ecostruxure.sdk.client.invoker.ApiClient;
import se.ecostruxure.sdk.client.model.PerformanceScore;

public class GetPerformanceScores {

    public static void main(String[] args) {
        String token = null;
        String baseUrl = null;
        String siteId = null;
        List<String> typeList = new ArrayList<>();
        List<String> categoryList = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            String[] argumentsData = args[i].split("=");

            switch (argumentsData[0]) {
            case TOKEN_NAME:
                token = findArgument(argumentsData);
                break;
            case BASEURL_NAME:
                baseUrl = findArgument(argumentsData);
                break;
            case SITEID_NAME:
                siteId = findArgument(argumentsData);
                break;
            case TYPE:
                typeList.add(findArgument(argumentsData));
                break;
            case CATEGORY:
                categoryList.add(findArgument(argumentsData));
                break;
            default: break;
            }
        }
      //To check the null conditions
        if (Boolean.TRUE.equals(checkNull(token))) {
            statusMessage(TOKEN_NAME);
            return;
        }
        if (Boolean.TRUE.equals(checkNull(baseUrl))) {
            statusMessage(BASEURL_NAME);
            return;
        }
        if (Boolean.TRUE.equals(checkNull(siteId))) {
            statusMessage(SITEID_NAME);
            return;
        }
        if (typeList.isEmpty()) {
            statusMessage(TYPE);
            return;
        }
        if (categoryList.isEmpty()) {
            statusMessage(CATEGORY);
            return;
        }
        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath(baseUrl);
        defaultClient.setBearerToken(token);
        PerformanceScoreApi apiInstance = new PerformanceScoreApi(defaultClient);
        try {
            System.out.println(apiInstance.listPerformanceScores(siteId, typeList, categoryList));
            List<PerformanceScore> result = apiInstance.listPerformanceScores(siteId, typeList, categoryList);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } 

    }
    /**
     * check the value null.
     * @param arguments
     * @return
     */
    public static Boolean checkNull(String arguments) {
        if (arguments == null) {
            return true;
        }
        return false;
    }

    /**
     * To check whether we get only 2 arguments.
     * @param arguments
     * @return String
     */
    private static String findArgument(String[] arguments) {
        String values = null;
        if (arguments.length == 2) {
            values = arguments[1];
        }
        return values;
    }
    /**
     * statusMessage.
     * @param argument
     */
    private static void statusMessage(String argument) {
        String errorMessage = null;
        errorMessage = argument.concat(" cannot be empty");
        System.out.println(getDetailsErrorMessage(errorMessage).toString());
    }

    /**
     * @param errorMessage
     * @return Map
     */
    public static Map<String, Object> getDetailsErrorMessage(String errorMessage) {
        Map<String, Object> details = new HashMap<>();
        details.put("type", URL_PATH);
        details.put("title", BAD_REQUEST);
        details.put("status", STATUS);
        details.put("detail", errorMessage);
        return details;
    }

    // Constants
    private static final String TOKEN_NAME = "token";
    private static final String BASEURL_NAME = "baseUrl";
    private static final String TYPE = "type";
    private static final String SITEID_NAME = "siteId";
    private static final String CATEGORY = "category";
    private static final String BAD_REQUEST = "Bad Request";
    private static final String URL_NOT_FOUND = "Provided URL not Found.";
    private static final String INTERRUPTED = "Interrupted please check your request.";
    private static final Integer STATUS = 400;
    private static final String URL_PATH = "/certification-scores";
}
