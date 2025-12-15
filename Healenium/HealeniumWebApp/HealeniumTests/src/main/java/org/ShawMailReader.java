package org;

import jakarta.mail.*;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.search.FlagTerm;
import java.util.Properties;

public class ShawMailReader {

    public static void main(String[] args) throws MessagingException {
        String username = "siatTest38163@shaw.ca";
        String password = "238163";

        Properties props = new Properties();
        props.put("mail.store.protocol", "imaps");
        props.put("mail.imaps.host", "imap.shaw.ca");
      //  props.put("mail.imaps.port", "993");
        props.put("mail.imaps.ssl.enable", "true");

        Session session = Session.getInstance(props);
        session.setDebug(true);

        Store store = session.getStore("imaps");
        store.connect("imap.shaw.ca", username,password);


        try {


            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Fetch only unread messages
            Message[] messages = inbox.getMessages();

            System.out.println("Unread messages: " + messages.length);

            for (Message message : messages) {
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Subject: " + message.getSubject());
                System.out.println("Sent: " + message.getSentDate());
                System.out.println("-----------------------");

                Object content = message.getContent();
                if (content instanceof String) {
                    System.out.println("Body: " + content);
                } else if (content instanceof Multipart) {
                    Multipart multipart = (Multipart) content;
                    for (int i = 0; i < multipart.getCount(); i++) {
                        BodyPart part = multipart.getBodyPart(i);
                        if (part.isMimeType("text/plain")) {
                            System.out.println("Body: " + part.getContent());
                        }
                    }
                }
                System.out.println("=======================");
            }

            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
