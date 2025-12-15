package org;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JiraBearerAuthExample {

    public static void main(String[] args) {
        String bearerToken = "TmTdUUUbK02SPklWaYIhKi0u3J2iIEpRm3sYsm";  // Replace with actual token
        String issueKey = "STCX-14154";
        String jiraDomain = "reqcentral.com";  // Replace with your Jira domain

        try {
            String url = "https://" + jiraDomain + "/rest/api/2/issue/" + issueKey;
            System.out.println(url);
            HttpClient client = HttpClient.newHttpClient();

            // Create HttpRequest with Authorization header
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Authorization", "Bearer " + bearerToken)
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            // Send request and get response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            // Print response
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}