package com.canadaitclub.utils;

import java.io.*;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Configuration Manager to read properties from config.properties file
 */
public class ConfigManager {
    private static final Logger logger = LogManager.getLogger(ConfigManager.class);
    private static Properties properties;
    private static final String CONFIG_FILE = "config.properties";

    static {
        properties = new Properties();
        try (InputStream input = ConfigManager.class.getClassLoader()
                .getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                logger.error("Config file not found: " + CONFIG_FILE);
                throw new RuntimeException("Config file not found");
            }
            properties.load(input);
            logger.info("Configuration loaded successfully");
        } catch (IOException e) {
            logger.error("Failed to load configuration: ", e);
            throw new RuntimeException("Failed to load configuration", e);
        }
    }

    /**
     * Get property value as String
     */
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            logger.warn("Property not found: " + key);
        }
        return value;
    }

    /**
     * Get property value as String with default value
     */
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    /**
     * Get property value as Integer
     */
    public static int getIntProperty(String key, int defaultValue) {
        try {
            return Integer.parseInt(properties.getProperty(key, String.valueOf(defaultValue)));
        } catch (NumberFormatException e) {
            logger.warn("Invalid integer value for property: " + key, e);
            return defaultValue;
        }
    }

    /**
     * Get property value as Boolean
     */
    public static boolean getBooleanProperty(String key, boolean defaultValue) {
        try {
            return Boolean.parseBoolean(properties.getProperty(key, String.valueOf(defaultValue)));
        } catch (Exception e) {
            logger.warn("Invalid boolean value for property: " + key, e);
            return defaultValue;
        }
    }

    /**
     * Get all properties
     */
    public static Properties getAllProperties() {
        return properties;
    }
}
