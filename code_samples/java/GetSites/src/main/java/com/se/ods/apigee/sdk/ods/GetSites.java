package com.se.ods.apigee.sdk.ods;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class GetSites {
    private static String endpoints = "/v1/sites";
    public static void main(String [] args) throws IOException, InterruptedException {
        if (args.length != 2) {
            System.out.println("token and baseUrl arguments should be passed");
        }
        String token = args[0];
        String baseUrl = args[1];
        HttpResponse<String> getSitesResponse = getSites(token, baseUrl+endpoints);
        System.out.println(getSitesResponse.body());
    }
    public static HttpResponse<String> getSites(String token, String baseUrl) throws IOException, InterruptedException {
        String accessToken = "Bearer " + token;
        return GetSitesHttpClient(accessToken, baseUrl);
    }
    public static HttpResponse<String> GetSitesHttpClient(
            String accessToken, String baseUrl) throws IOException, InterruptedException {
        URI uri = URI.create(baseUrl);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .headers("Authorization", accessToken)
                .build();
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
}
