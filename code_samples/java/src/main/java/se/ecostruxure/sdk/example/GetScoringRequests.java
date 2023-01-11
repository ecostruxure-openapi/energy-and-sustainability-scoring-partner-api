package se.ecostruxure.sdk.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.utils.URIBuilder;

public class GetScoringRequests {
    
    public static void main(String[] args) throws Exception, IOException, InterruptedException {
        
        String token = null;
        String baseUrl = null;
        String siteId = null;
        String id = null;
        
        for (int i = 0; i < args.length; i++) {
            String[] arr = args[i].split("=");
            
            switch(arr[0]) {
            case TOKEN_NAME:
                token = findArgument(arr);
                break;
            case BASEURL_NAME:
                baseUrl = findArgument(arr);
                break;
            case SITEID_NAME:
                siteId = findArgument(arr);
                break;
            case ID_NAME:
                id = findArgument(arr);
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
       
        // generate url
        String framedUrl = baseUrl.concat(END_POINTS.replace(SITEID_NAME, siteId));
        URIBuilder uri = new URIBuilder(framedUrl);
        if(!checkNull(id) ) {
            uri.addParameter("id", id);
        }
        //generate accesstoken
        String accessToken = getaccesstoken(token);
        
        //call the API
        HttpResponse<String> getCertificationRequestsResponse = GetCertificationRequestsHttpClient(accessToken, uri.toString());
        logger.log(Level.INFO,getCertificationRequestsResponse.body());
    }
    
    /**
     * statusMessage.
     * @param argument
     */
    private static void statusMessage(String argument) {
        String errorMessage = null;
        System.out.println("Status = "+STATUS);
        errorMessage = argument.concat(" cannot be empty");
        logger.log(Level.INFO,getDetailsErrorMessage(errorMessage).toString());
    }
    
    /**
     * checkNull.
     * @param arguments
     * @return condition
     */
    private static boolean checkNull(String arguments) {
        if(arguments == null) {
            return true;
        }
        return false;
    }
    
    /**
     * getDetailsErrorMessage.
     * @param errorMessage
     * @return error details
     */
    private static Map<String,Object> getDetailsErrorMessage(String errorMessage) {
        Map<String,Object> details = new HashMap<>();
        details.put("type", "/certification-requests");
        details.put("title",BAD_REQUEST);
        details.put("status",STATUS);
        details.put("detail",errorMessage);
        return details;
    }
    
    /**
     * findArgument.
     * @param arr String Array
     * @return value
     */
    private static String findArgument(String[] arr) {
        String values = null;
        if (arr.length == 2) {
            values = arr[1];
        }
        return values;
    }
    
    /**
     * getaccesstoken.
     * @param token
     * @return accesstoken
     * @throws IOException
     * @throws InterruptedException
     */
    public static String getaccesstoken(String token) throws IOException, InterruptedException {
        return BEARER.concat(token);
    }
    
    /**
     * HttpResponse
     * @param token
     * @param baseUrl
     * @return HttpResponse
     * @throws IOException
     * @throws InterruptedException
     */
    public static HttpResponse<String> GetCertificationRequestsHttpClient(String accessToken, String baseUrl)
            throws IOException, InterruptedException {
        URI uri = URI.create(baseUrl);
        HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().headers(AUTHORIZATION, accessToken).build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException e) {
            throw new IOException("Provided URL not Found.");
        } catch (InterruptedException ex) {
            throw new InterruptedException("Interrupted please check your request.");
        }
        return response;
    }
    
    // Constants
    private static final String END_POINTS = "/v1/sites/siteId/certification-requests";
    private static final String BEARER = "Bearer ";
    private static final String AUTHORIZATION = "Authorization";
    private static final String TOKEN_NAME = "token";
    private static final String BASEURL_NAME = "baseUrl";
    private static final String SITEID_NAME = "siteId";
    private static final String ID_NAME = "id";
    private static final Logger logger = Logger.getLogger("GetCertificationRequests");
    private static final String BAD_REQUEST = "Bad Request";
    private static final Integer STATUS = 400;
}
