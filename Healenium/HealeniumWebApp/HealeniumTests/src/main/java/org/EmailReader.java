//package org;
//
//import org.apache.logging.log4j.Logger;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import rogers.automation.core.logging.LoggingUtils;
//import rogers.automation.core.utils.EncryptDecryptUtil;
//import rogers.automation.core.utils.PropertyConstants;
//import rogers.automation.core.utils.PropertyUtil;
//import rogers.automation.core.vault.VaultSecrets;
//
//import javax.mail.*;
//import javax.mail.internet.MimeMultipart;
//import javax.mail.search.*;
//import java.text.SimpleDateFormat;
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class EmailReader {
//    private static Logger logger = LoggingUtils.getNamedLogger(EmailReader.class.getSimpleName());
//    private static Properties properties = new Properties();
//
//
//    public String fetchOtp(String subject, String recipient) {
//        logger.debug("Fetching OTP for subject : " + subject);
//        List<Message> messages = fetchAllMessages(subject, recipient);
//        Date date = new Date(System.currentTimeMillis() - 3600 * 1000);
//        try {
//            for (Message message : messages) {
//                if (message.getReceivedDate().after(date)) {
//                    String otp = message.getSubject().split("MyRogers: ")[1].split(" ")[0];
//                    logger.debug("OTP Found as :" + message.getSubject());
//                    return otp;
//                }
//            }
//        } catch (Exception e) {
//            logger.error("Exception occurred while fetching otp from email", e);
//            return "";
//        }
//        return "";
//    }
//
//    public List<Message> fetchAllMessages(String subject, String recipient) {
//        logger.debug("Fetching messages from email with subject : " + subject);
//        String HOST = PropertyUtil.getStringValue(PropertyConstants.AUTOMATION_FRAMEWORK_EMAIL_HOST_SMTP),
//                USER = PropertyUtil.getStringValue(PropertyConstants.AUTOMATION_FRAMEWORK_EMAIL_USERNAME),
//                PASSWORD = EncryptDecryptUtil.decrypt(PropertyUtil.getStringValue(PropertyConstants.AUTOMATION_FRAMEWORK_EMAIL_KEY));
//        Message[] messages = null;
//        List<Message> filteredMessages = new ArrayList<>();
//        Folder inbox = null;
//        Store store = null;
//        try {
//            Session session = Session.getDefaultInstance(properties);
//            store = session.getStore("imaps");
//            store.connect(HOST, USER, PASSWORD);
//            inbox = store.getFolder("INBOX");
//            inbox.open(Folder.READ_WRITE);
//
//            int messageCount = inbox.getMessageCount();
//            logger.info("Total Messages" + messageCount);
//
//            messages = inbox.search(new FlagTerm(new Flags(
//                    Flags.Flag.SEEN), false));
//
//            Arrays.sort(messages, (m1, m2) -> {
//                try {
//                    return m2.getSentDate().compareTo(m1.getSentDate());
//                } catch (MessagingException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//
//            for (Message message : messages) {
//                boolean recipientFound = false;
//                if (message.getSubject().contains(subject)) {
//                    for (Address address : message.getAllRecipients()
//                    ) {
//                        if (address.toString().contains(recipient)) {
//                            recipientFound = true;
//                        }
//                    }
//                    if (!recipientFound) {
//                        continue;
//                    }
//                    filteredMessages.add(message);
//                    System.out.println(message.getAllRecipients()[0].toString());
//                    message.setFlag(Flags.Flag.SEEN, true);
//                    logger.info("---------------------------------");
//                    logger.info("Subject: " + message.getSubject());
//                    logger.info("From: " + message.getFrom()[0]);
//                }
//            }
//            logger.error("Total messages found with subject are : " + filteredMessages.size());
//            return filteredMessages;
//        } catch (Exception e) {
//            logger.error("Exception occurred while fetching message from email ", e);
//        } finally {
//            try {
//                inbox.close(false);
//                store.close();
//            } catch (MessagingException e) {
//
//            }
//        }
//        return null;
//    }
//
//
//    public String fetchOtp(String email, String password, String subject, String recipient) {
//        logger.debug("Fetching OTP for subject : " + subject);
//        List<Message> messages = fetchAllMessages(email, password, subject, recipient);
//        String otp = null;
//        Folder inbox = null;  // Declare inbox here for resource management
//        Store store = null;   // Declare store here for resource management
//        // Check if there is a message to process
//        if (messages.isEmpty()) {
//            logger.info("No messages found for the given criteria.");
//            return otp; // Return null if no messages
//        }
//
//        // Initialize a variable to track the latest message
//        Message latestMessage = null;
//        Date latestReceivedDate = null;
//        // Process the content of the filtered messages
//        try {
//            for (Message message : messages) {
//                // Process only the latest message
//                if (latestMessage == null || message.getReceivedDate().after(latestMessage.getReceivedDate())) {
//                    latestMessage = message; // Update latestMessage to the current one
//
//                    Object content = latestMessage.getContent();
//                    if (content instanceof String) {
//                        String body = (String) content;
//                        logger.info("Body: " + body);
//
//                        // Extract OTP from HTML content if available
//                        Document doc = Jsoup.parse(body);
//                        Element otpElement = doc.selectFirst("td[style*='font-size: 28px; font-weight:600']");
//                        if (otpElement != null) {
//                            otp = otpElement.text().trim();
//                            logger.info("OTP: " + otp);
//                        } else {
//                            logger.info("OTP not found.");
//                        }
//                    } else if (content instanceof MimeMultipart) {
//                        String body = getTextFromMimeMultipart((MimeMultipart) content);
//                        logger.info("Body: " + body);
//                        otp = extractOtpGmail(body);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            logger.error("Exception occurred while fetching OTP from email", e);
//        } finally {
//            closeResources(inbox, store);
//        }
//        return otp;
//    }
//
//    public List<Message> fetchAllMessages(String email, String password, String subject, String recipient) {
//        logger.debug("Fetching messages from email with subject : {}", subject);
//
//        String HOST = "imap.mail.yahoo.com";
//        final String USER = email;
//        final String PASSWORD = password;
//        /*String HOST = PropertyUtil.getStringValue(PropertyConstants.AUTOMATION_FRAMEWORK_EMAIL_HOST_SMTP),
//        USER = PropertyUtil.getStringValue(PropertyConstants.AUTOMATION_FRAMEWORK_DISNEY_EMAIL_USERNAME),
//        PASSWORD = VaultSecrets.getSecret("igniteWeb", USER);*/
//        List<Message> filteredMessages = new ArrayList<>();
//        if(email.contains("shaw.ca"))
//            HOST = "imap.shaw.ca";
//
//        Folder inbox = null;
//        Store store = null;
//
//        try {
//            Session session = Session.getDefaultInstance(properties);
//            store = session.getStore("imaps");
//            store.connect(HOST, USER, PASSWORD);
//            inbox = store.getFolder("INBOX");
//            inbox.open(Folder.READ_WRITE);
//
//            int messageCount = inbox.getMessageCount();
//            logger.info("Total Messages readed : {}", messageCount);
//
//            // Get current time and 15 minutes ago in the specified timezone (America/Toronto)
//            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Toronto"));
//            Date currentTime = calendar.getTime();
//            logger.info("Current Time (Toronto): {}", currentTime);
//            if (subject.toLowerCase().contains("disney")) {
//                calendar.add(Calendar.MINUTE, -15); // Subtract 15 minutes
//            } else {
//                calendar.add(Calendar.MINUTE, -10); // Subtract 10 minutes
//            }
//            //calendar.add(Calendar.HOUR, -48);
//            Date fifteenMinutesAgo = calendar.getTime();
//            logger.info("Fifteen Minutes Ago (Toronto) : {}", fifteenMinutesAgo);
//
//            // Create search terms
//            SearchTerm subjectTerm = new SubjectTerm(subject);
//            SearchTerm unseenTerm = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
//            SearchTerm combinedTerm1 = new AndTerm(subjectTerm, unseenTerm);
//
//            // added term to only fetch last 15 mins old mails records
//            SearchTerm newerThan = new ReceivedDateTerm(ComparisonTerm.GT, fifteenMinutesAgo);
//            SearchTerm combinedTerm2  = new AndTerm(combinedTerm1, newerThan);
//
//            // Search for emails with the specified subject line and unseen status
//            Message[] messages = inbox.search(combinedTerm2);
//            logger.info("Messages found matching the criteria : {}", messages.length);
//
//            // Sort messages by sent date in descending order
//            Arrays.sort(messages, (m1, m2) -> {
//                try {
//                    return m2.getSentDate().compareTo(m1.getSentDate());
//                } catch (MessagingException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//
//            // Process the filtered messages
//            for (Message message : messages) {
//                if (isWithinTimeWindow(message.getReceivedDate(), fifteenMinutesAgo, currentTime) &&
//                        isRecipientFound(message.getAllRecipients(), recipient)) {
//                    filteredMessages.add(message);
//                    message.setFlag(Flags.Flag.SEEN, true);
//                    logMessageDetails(message);
//                }
//            }
//
//            logger.info("Total messages found with subject and recipient : {}", filteredMessages.size());
//            return filteredMessages;
//        } catch (Exception e) {
//            logger.error("Exception occurred while fetching message from email : {}", e.getMessage());
//            e.printStackTrace();
//        }
//        return Collections.emptyList(); // Return an empty list instead of null if no messages are found
//    }
//
//    private boolean isWithinTimeWindow(Date receivedDate, Date fifteenMinutesAgo, Date currentTime) {
//        if (receivedDate == null) return false;
//        if (receivedDate.before(fifteenMinutesAgo) || receivedDate.after(currentTime)) {
//            logger.info("Email is outside the 15-minute window. Received Date: " + receivedDate);
//            return false;
//        }
//        return true;
//    }
//
//    private boolean isRecipientFound(Address[] recipients, String recipient) {
//        if (recipients != null) {
//            for (Address address : recipients) {
//                if (address.toString().contains(recipient)) {
//                    return true; // Recipient found
//                }
//            }
//        }
//        logger.info("Recipient not found for email.");
//        return false;
//    }
//
//    private void logMessageDetails(Message message) throws MessagingException {
//        Date receivedDate = message.getReceivedDate();
//        logger.info("Matching email found.");
//        logger.info("Subject: " + message.getSubject());
//        logger.info("Received Date: " + receivedDate);
//        logger.info("---------------------------------");
//    }
//
//    private void closeResources(Folder inbox, Store store) {
//        try {
//            if (inbox != null) inbox.close(false);
//            if (store != null) store.close();
//        } catch (MessagingException e) {
//            logger.error("Error while closing inbox/store", e);
//        }
//    }
//
//
//    private String extractOtp(String emailBody) {
//        // Regex pattern to match the OTP (6 digits)
//        Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
//        Matcher matcher = pattern.matcher(emailBody);
//        if (matcher.find()) {
//            String otp = matcher.group(); // Return the first matched OTP
//            if (!otp.equals("000000")) {
//                return otp; // Return the first matched OTP that is not "000000"
//            }
//        }
//        // If regex doesn't find an OTP, try to parse HTML content using Jsoup
//        Document doc = Jsoup.parse(emailBody);
//        Element otpElement = null;
//
//        // Look for <b> tags to identify the "Verification Code:"
//        for (Element bElement : doc.select("b")) {
//            // Check if the text of the <b> element matches "Verification Code:"
//            if (bElement.text().toLowerCase().contains("verification code")) {
//                // Get the next sibling element, which should be the <a> tag or a similar element
//                otpElement = bElement.nextElementSibling();
//                if (otpElement != null) {
//                    // If the next sibling is an <a> tag, return its text
//                    if (otpElement.tagName().equals("a")) {
//                        return otpElement.text();
//                    }
//                    // If the next sibling is not an <a> tag, check for its text content
//                    String otpText = otpElement.ownText(); // Get text directly from the element
//                    if (!otpText.isEmpty()) {
//                        return otpText; // Return the text if it's not empty
//                    }
//                }
//            }
//        }
//
//        // If all else fails, check for any 6-digit number in the body again as a last resort
//        matcher.reset(); // Reset the matcher to search again
//        while (matcher.find()) {
//            return matcher.group(); // Return the first matched OTP
//        }
//
//        return null; // Return null if no OTP found
//    }
//
//    private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
//        StringBuilder result = new StringBuilder();
//        int count = mimeMultipart.getCount();
//        for (int i = 0; i < count; i++) {
//            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
//            if (bodyPart.isMimeType("text/plain")) {
//                result.append(bodyPart.getContent());
//            } else if (bodyPart.isMimeType("text/html")) {
//                String html = (String) bodyPart.getContent();
//                result.append(html);
//            } else if (bodyPart.getContent() instanceof MimeMultipart) {
//                result.append(getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent()));
//            }
//        }
//        return result.toString();
//    }
//
//    public List<String> fetchOtpFromGmail(String email, String appPassword, String subject, String recipient) {
//        logger.debug("Fetching OTP from master email rogerswestcsv@gmail.com with subject: " + subject);
//        List<Message> messages = fetchAllMessagesFromGmail(email, appPassword, subject, recipient);
//        List<String> otpList = new ArrayList<>();
//        String otp = null;
//        Folder inbox = null;
//        Store store = null;
//
//        if (messages.isEmpty()) {
//            logger.info("No messages found for the given criteria.");
//            return otpList;
//        }
//
//        Message latestMessage = null;
//        try {
//            for (Message message : messages) {
//               /* if (latestMessage == null || message.getReceivedDate().after(latestMessage.getReceivedDate())) {*/
//                    latestMessage = message;
//
//                    Object content = latestMessage.getContent();
//                    if (content instanceof String) {
//                        String body = (String) content;
//                        logger.info("Email Body: " + body);
//
//                        // Extract OTP from HTML content
//                        Document doc = Jsoup.parse(body);
//                        Element otpElement = doc.selectFirst("td[style*='font-size: 28px; font-weight:600']");
//                        if (otpElement != null) {
//                            otp = otpElement.text().trim();
//                            logger.info("Extracted OTP: " + otp);
//                            otpList.add(otp);
//                        } else {
//                            logger.info("OTP not found in email body.");
//                        }
//                    } else if (content instanceof MimeMultipart) {
//                        String body = getTextFromMimeMultipart((MimeMultipart) content);
//                        logger.info("Parsed Email Body: " + body);
//                        otp = extractOtpGmail(body);
//                        otpList.add(otp);
//                    }
//               /* }*/
//            }
//        } catch (Exception e) {
//            logger.error("Error occurred while fetching OTP from Gmail", e);
//        } finally {
//            try {
//                if (inbox != null) inbox.close(true);
//                if (store != null) store.close();
//            } catch (MessagingException e) {
//                logger.error("Error while closing inbox/store", e);
//            }
//        }
//        return otpList;
//    }
//
//    public List<Message> fetchAllMessagesFromGmail(String email, String appPassword, String subject, String recipient) {
//        logger.debug("Fetching messages from Gmail with subject: {}", subject);
//
//        final String HOST = "imap.gmail.com";
//        final String USER = email;
//        final String PASSWORD = appPassword;
//        List<Message> filteredMessages = new ArrayList<>();
//
//        Folder inbox = null;
//        Store store = null;
//
//        try {
//            // Set Gmail IMAP properties
//            Properties properties = new Properties();
//            properties.put("mail.store.protocol", "imaps");
//            properties.put("mail.imaps.host", HOST);
//            properties.put("mail.imaps.port", "993");
//            properties.put("mail.imaps.ssl.enable", "true");
//
//            // Create session and connect to Gmail
//            logger.debug("Connecting to Gmail IMAP server...");
//            Session session = Session.getInstance(properties);
//            store = session.getStore("imaps");
//            store.connect(HOST, USER, PASSWORD);
//            logger.info("Connected to Gmail IMAP server successfully.");
//
//            inbox = store.getFolder("INBOX");
//            inbox.open(Folder.READ_WRITE);
//
//            int messageCount = inbox.getMessageCount();
//            logger.info("Total Messages in inbox: {}", messageCount);
//
//            // Get current time and 15 minutes ago in the specified timezone (America/Toronto)
//            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Toronto"));
//            Date currentTime = calendar.getTime();
//            logger.info("Current Time (Toronto): {}", currentTime);
//
//            calendar.add(Calendar.MINUTE, -5); // Subtract 5 minutes
//            Date fifteenMinutesAgo = calendar.getTime();
//            logger.info("Time window start (Toronto): {}", fifteenMinutesAgo);
//
//            // Create search terms
//            SearchTerm subjectTerm = new SubjectTerm(subject);
//            /*SearchTerm unseenTerm = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
//            SearchTerm combinedTerm1 = new AndTerm(subjectTerm, unseenTerm);*/
//            SearchTerm combinedTerm1 = subjectTerm; // Only subject-based filtering
//
//            // Filter emails received in the last 10-15 minutes
//            SearchTerm newerThan = new ReceivedDateTerm(ComparisonTerm.GT, fifteenMinutesAgo);
//            SearchTerm combinedTerm2 = new AndTerm(combinedTerm1, newerThan);
//
//            // Search for matching emails
//            logger.debug("Searching for emails matching subject and time window...");
//            Message[] messages = inbox.search(combinedTerm2);
//            logger.info("Messages found matching criteria: {}", messages.length);
//
//            // Sort messages by sent date (newest first)
//            Arrays.sort(messages, (m1, m2) -> {
//                try {
//                    return m2.getSentDate().compareTo(m1.getSentDate());
//                } catch (MessagingException e) {
//                    logger.error("Error comparing message dates: {}", e.getMessage());
//                    throw new RuntimeException(e);
//                }
//            });
//
//            // Process the filtered messages
//            for (Message message : messages) {
//                if (isWithinTimeWindow(message.getReceivedDate(), fifteenMinutesAgo, currentTime) &&
//                        isRecipientFound(message.getAllRecipients(), recipient)) {
//                    filteredMessages.add(message);
//                    //message.setFlag(Flags.Flag.SEEN, true);
//                    logMessageDetails(message);
//                }
//            }
//
//            // Explicitly expunge the folder to ensure synchronization with Gmail
//            /*try {
//                inbox.expunge(); // Sync changes immediately with the server
//                logger.debug("Changes synchronized with Gmail.");
//            } catch (MessagingException e) {
//                logger.error("Error during expunge operation: {}", e.getMessage());
//            }
//*/
//            logger.info("Total messages found with subject and recipient: {}", filteredMessages.size());
//            return filteredMessages;
//        } catch (Exception e) {
//            logger.error("Error fetching messages from Gmail: {}", e.getMessage(), e);
//        }
//
//        return Collections.emptyList(); // Return an empty list instead of null if no messages are found
//    }
////working
//    /*private String extractOtpGmail(String emailBody) {
//        // Regex pattern to match a 6-digit OTP, but allow for extra spaces or surrounding characters
//        Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
//        Matcher matcher = pattern.matcher(emailBody);
//
//        // Check for OTP via regex
//        if (matcher.find()) {
//            String otp = matcher.group();
//            if (!otp.equals("000000") && !otp.equals("333333")) {
//                logger.debug("OTP found via regex: {}", otp); // Log the OTP found via regex
//                return otp;
//            }
//        }
//
//        // Parse the HTML content using Jsoup
//        Document doc = Jsoup.parse(emailBody);
//
//        // Look for <b> tags to identify the "Verification Code:"
//        for (Element bElement : doc.select("b")) {
//            // Check if the text of the <b> element matches "Verification code:"
//            if (bElement.text().toLowerCase().contains("verification code")) {
//                logger.debug("Found 'Verification code' in <b> tag: {}", bElement.text()); // Log the matched <b> tag text
//
//                // Now, look for the sibling <span> or adjacent element where the OTP is located
//                Element otpElement = bElement.parent().select("span").first();
//
//                if (otpElement != null) {
//                    // Extract OTP directly from the span tag
//                    String otpText = otpElement.text().trim();
//                    logger.debug("OTP extracted from <span>: {}", otpText); // Log the extracted OTP from span
//
//                    // Validate and return OTP
//                    if (otpText.matches("\\d{6}")) {
//                        return otpText;
//                    }
//                }
//            }
//        }
//
//        // If all else fails, check for any 6-digit number in the body again as a last resort
//        matcher.reset(); // Reset the matcher to search again
//        while (matcher.find()) {
//            String otp = matcher.group();
//            if (!otp.equals("000000") && !otp.equals("333333")) {
//                logger.debug("OTP found as last resort: {}", otp); // Log the OTP found as last resort
//                return otp; // Return the first matched OTP
//            }
//        }
//
//        // Log if no valid OTP is found
//        logger.debug("No valid OTP found.");
//        return null; // Return null if no OTP found
//    }*/
//
//    public String extractOtpGmail(String emailBody) {
//        // Parse the HTML content of the email
//        Document doc = Jsoup.parse(emailBody);
//
//        // First, try to find the OTP using key phrases like "Verification code: "
//        String otp = extractOtpFromVerificationCode(doc);
//        if (otp != null) {
//            return otp; // Return if a valid OTP is found
//        }
//
//        // If the first method fails, attempt to extract any 6-digit number in the body
//        otp = extractOtpFromRegex(emailBody);
//        return otp;
//    }
//
//    private String extractOtpFromVerificationCode(Document doc) {
//        // Search for elements that contain the text "Verification code:"
//        Elements elements = doc.body().getElementsContainingText("Verification code:");
//        for (Element element : elements) {
//            // Extract the text after "Verification code:" and trim any spaces
//            String text = element.text();
//            int index = text.toLowerCase().indexOf("verification code:");
//            if (index != -1) {
//                // Extract the part after "Verification code:"
//                String otpText = text.substring(index + "Verification code:".length()).trim();
//
//                // Match the 6-digit OTP in the extracted text
//                Pattern otpPattern = Pattern.compile("\\b\\d{6}\\b");
//                Matcher matcher = otpPattern.matcher(otpText);
//                if (matcher.find()) {
//                    String otp = matcher.group();
//                    if (!isInvalidOtp(otp) && isOtpContextValid(text)) {
//                        return otp; // Return the OTP if it's valid and correctly contextualized
//                    }
//                }
//            }
//        }
//        return null; // Return null if no valid OTP was found in the verification code text
//    }
//
//    private String extractOtpFromRegex(String emailBody) {
//        // Regex pattern to match any 6-digit OTP
//        Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
//        Matcher matcher = pattern.matcher(emailBody);
//        while (matcher.find()) {
//            String otp = matcher.group();
//            if (!isInvalidOtp(otp)) {
//                return otp; // Return the first valid OTP
//            }
//        }
//        return null; // Return null if no valid OTP found
//    }
//
//    private boolean isInvalidOtp(String otp) {
//        // Check if OTP is invalid (e.g., "000000" or "333333")
//        return otp.equals("000000") || otp.equals("333333");
//    }
//
//    private boolean isOtpContextValid(String text) {
//        // Ensure the OTP is found in the correct context (e.g., "Verification code" or similar)
//        return text.toLowerCase().contains("verification code");
//    }
//
//    public static void main(String[] args) {
//        EmailReader emailReader=new EmailReader();
//        emailReader.fetchOtp("siattest38163@shaw.ca","238163","Here is your verification code","siattest38163@shaw.ca");
//    }
//}
