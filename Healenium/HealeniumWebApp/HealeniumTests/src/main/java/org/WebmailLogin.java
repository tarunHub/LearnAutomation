package org;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;

import java.util.Properties;


public class WebmailLogin {

    public static void loginToWebmail(String host, String storeType, String username, String password) {
        try {
            // Set mail server properties
            Properties properties = new Properties();
            properties.put("mail.pop3s.host", host);
            properties.put("mail.pop3s.port", "995");
            properties.put("mail.pop3s.starttls.enable", "true");

            // Create session with authentication
            Session emailSession = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            // Connect to the mail store
                      // inbox.close(false);
            //store.close();

        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String host = "pop.gmail.com"; // or your webmail server
        String storeType = "pop3";
        String username = "your_email@example.com";
        String password = "your_password";

        loginToWebmail(host, storeType, username, password);
    }
}