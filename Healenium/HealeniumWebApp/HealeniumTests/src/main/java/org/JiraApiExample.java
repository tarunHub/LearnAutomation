package org;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class JiraApiExample {
    public static void main(String[] args) {
        String email = "CSV.Auto10BOT@rci.rogers.com";
        String apiToken = "TmTdUUUbK02SPklWaYIhKi0u3J2iIEpRm3sYsm";
        String jiraDomain = "https://reqcentral.com/";
        String projectKey = "STCX";

        try {
            String auth = email + ":" + apiToken;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            String url1 = "https://reqcentral.com/rest/api/2/issue/STCX-17403";
        //    String url2 = "https://reqcentral.com/rest/api/3/project/STCX-17403";
            String url2 = "https://reqcentral.com/rest/api/2/issue/STCX-14154";
          //  URL url = new URL("https://" + jiraDomain + "/rest/api/3/project/STCX-17403" + projectKey);
            URL url = new URL(url2);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Basic " + encodedAuth);
            conn.setRequestProperty("Accept", "application/json");

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println("Response: " + response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}