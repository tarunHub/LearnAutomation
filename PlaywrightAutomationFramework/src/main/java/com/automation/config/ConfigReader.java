package com.automation.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigReader class to read configuration properties
 */
public class ConfigReader {
    
    private static Properties properties;
    private static final String CONFIG_FILE_PATH = "src/test/resources/config.properties";
    
    static {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file");
        }
    }
    
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public static String getBrowser() {
        return properties.getProperty("browser", "chromium");
    }
    
    public static boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless", "false"));
    }
    
    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }
    
    public static int getBrowserTimeout() {
        return Integer.parseInt(properties.getProperty("browser.timeout", "30000"));
    }
    
    public static boolean isVideoEnabled() {
        return Boolean.parseBoolean(properties.getProperty("video.enabled", "true"));
    }
    
    public static String getVideoPath() {
        return properties.getProperty("video.path", "test-results/videos/");
    }
    
    public static String getEvidencePath() {
        return properties.getProperty("evidence.path", "test-results/evidence/");
    }
    
    public static boolean retainEvidenceOnPass() {
        return Boolean.parseBoolean(properties.getProperty("evidence.retain.on.pass", "false"));
    }
    
    public static boolean retainEvidenceOnFail() {
        return Boolean.parseBoolean(properties.getProperty("evidence.retain.on.fail", "true"));
    }
    
    public static int getVideoWidth() {
        return Integer.parseInt(properties.getProperty("video.size.width", "1280"));
    }
    
    public static int getVideoHeight() {
        return Integer.parseInt(properties.getProperty("video.size.height", "720"));
    }
}