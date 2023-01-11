package se.ecostruxure.sdk.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.apache.http.client.utils.URIBuilder;

public class GetPerformanceScores {

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

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

        //To get Token
        String accessToken = getSitesToken(token);

        //To generate Url
        String concatenatedUrl = baseUrl.concat(GET_CERTIFICATION_SCORES.replace("{siteId}", siteId));

        // To add the required query params
        URIBuilder uri = new URIBuilder(concatenatedUrl);
        typeList.stream().map(type -> uri.addParameter(TYPE, type)).collect(Collectors.toList());
        categoryList.stream().map(category -> uri.addParameter(CATEGORY, category)).collect(Collectors.toList());

        //To call the API
        HttpResponse<String> getCertificationScoreResponse = getCertificateScoreResponse(uri.toString(), accessToken);

        // Response
        logger.log(Level.INFO,getCertificationScoreResponse.body());
    }

    /**
     * Process and produce response.
     * @param baseUrl
     * @param accessToken
     * @return HttpResponse<String>
     * @throws IOException
     * @throws InterruptedException
     */
    public static HttpResponse<String> getCertificateScoreResponse(String baseUrl, String accessToken)
            throws IOException, InterruptedException {
        URI uri = URI.create(baseUrl);
        HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().headers(AUTHORIZATION, accessToken).build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new IOException(URL_NOT_FOUND);
        } catch (InterruptedException e) {
            throw new InterruptedException(INTERRUPTED);
        }
        return response;
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
     * To frame access token.
     * @param token
     * @param baseUrl
     * @return HttpResponse
     * @throws IOException
     * @throws InterruptedException
     */
    public static String getSitesToken(String token) {
        return BEARER.concat(token);
    }

    /**
     * statusMessage.
     * @param argument
     */
    private static void statusMessage(String argument) {
        String errorMessage = null;
        errorMessage = argument.concat(" cannot be empty");
        logger.log(Level.INFO, getDetailsErrorMessage(errorMessage).toString());
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
    private static final String GET_CERTIFICATION_SCORES = "/v1/sites/{siteId}/certification-scores";
    private static final String BEARER = "Bearer ";
    private static final String AUTHORIZATION = "Authorization";
    private static final String BAD_REQUEST = "Bad Request";
    private static final String URL_NOT_FOUND = "Provided URL not Found.";
    private static final String INTERRUPTED = "Interrupted please check your request.";
    private static final Integer STATUS = 400;
    private static final String URL_PATH = "/certification-scores";
    private static final Logger logger = Logger.getLogger("GetCertificationScores");

}
