package se.ecostruxure.sdk.example;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class CreateScoringRequests {
    
       public static void main(String [] args) throws IOException, InterruptedException {
           
            String token = null;
            String baseUrl = null;
            String siteId = null;
            
            for (int i=0;i<args.length;i++) {
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
           
           //build url
            String uriBuilder = generateUrl(baseUrl, END_POINTS, siteId);
            
           //build token
           String accessToken = createCertificationRequestsToken(token);
           
           // call the api
            String createCertificationRequestsResponse = createCertificationRequestsHttpClient(accessToken, uriBuilder);
            logger.log(Level.INFO,createCertificationRequestsResponse);
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
         * @param errorMessage
         * @return Map
         */
        public static Map<String,Object> getDetailsErrorMessage(String errorMessage) {
            Map<String,Object> details = new HashMap<>();
            details.put("type","/certification-requests");
            details.put("title",BAD_REQUEST);
            details.put("status",STATUS);
            details.put("detail",errorMessage);
            return details;
        }

        /**
         * check the value null.
         * @param arguments
         * @return
         */
        public static Boolean checkNull(String arguments) {
            if(arguments == null) {
                return true;
            }
            return false;
        }
    
       /**
        * findArgument.
        * @param arr String Array
        * @return
        */
       private static String findArgument(String[] arr) {
           String values = null;
           if (arr.length == 2) {
               values = arr[1];
           }
           return values;
       }
       
       /**
        * generateUrl.
        * @param baseUrl
        * @param endpoints
        * @param siteId
        * @return formedurl
        */
        public static String generateUrl(String baseUrl, String endpoints, String siteId) {
            return baseUrl.concat(endpoints.replace(SITEID_NAME, siteId));
        }
        
        /**
         * createCertificationRequests access token.
         * @param token
         * @param baseUrl
         * @return createCertificationRequests
         * @throws IOException
         * @throws InterruptedException
         */
        public static String createCertificationRequestsToken(String token) {
            return BEARER.concat(token);
        }
        
        /**
         * createCertificationRequestsHttpClient.
         * @param accessToken
         * @param baseUrl
         * @return createCertificationRequestsHttpClient
         * @throws IOException
         * @throws InterruptedException
         */
        public static String createCertificationRequestsHttpClient(
                String accessToken, String baseUrl) throws IOException, InterruptedException {
            URI uri = URI.create(baseUrl);
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(uri);
            post.setHeader(AUTHORIZATION, accessToken);
            HttpResponse response = null;
            String responseBody = null;
            try {
                ResponseHandler<String> responseHandler = new MyResponseHandlers();
                responseBody = client.execute(post, responseHandler);
            } catch (IOException e) {
                throw new IOException("Provided URL Not Found.");
            }
            return responseBody;
        }
        
        // Constants
        private static final Logger logger = Logger.getLogger("CreateCertificationRequests");
        private static final String TOKEN_NAME = "token";
        private static final String BASEURL_NAME = "baseUrl";
        private static final String SITEID_NAME = "siteId";
        private static final String END_POINTS = "/v1/sites/siteId/certification-requests";
        private static final String BEARER = "Bearer ";
        private static final String AUTHORIZATION = "Authorization";
        private static final String BAD_REQUEST = "Bad Request";
        private static final Integer STATUS = 400;
}

    class MyResponseHandlers implements ResponseHandler<String>{
        @Override
        public String handleResponse(final HttpResponse response) throws IOException{
            //Get the status of the response
            int status = response.getStatusLine().getStatusCode();
            System.out.println("status="+status);
            HttpEntity entity = response.getEntity();
            if(entity == null) {
                return "";
            } else {
                return EntityUtils.toString(entity);
            }
        }
    }