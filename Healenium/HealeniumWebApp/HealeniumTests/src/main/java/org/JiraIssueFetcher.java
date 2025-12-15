package org;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class JiraIssueFetcher {

    public static void main(String[] args) {
        String apiToken = "Replace the token shared on rogers email here";
        String issueKey = "STCX-14154";
        String jiraDomain = "reqcentral.com";

        try {
            String url = "https://" + jiraDomain + "/rest/api/2/issue/" + issueKey;

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // Set request method
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Bearer " + apiToken);
            con.setRequestProperty("Accept", "application/json");
            // Read response
            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print result
            System.out.println("Response:\n" + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}