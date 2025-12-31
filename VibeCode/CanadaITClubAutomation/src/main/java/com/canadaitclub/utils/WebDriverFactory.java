package com.canadaitclub.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

/**
 * WebDriver Manager to handle WebDriver initialization and management
 */
public class WebDriverFactory {
    private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);

    /**
     * Initialize WebDriver based on browser configuration
     */
    public static WebDriver initializeDriver() {
        String browser = ConfigManager.getProperty("BROWSER", "chrome").toLowerCase();
        boolean headless = ConfigManager.getBooleanProperty("HEADLESS", false);
        String windowSize = ConfigManager.getProperty("WINDOW_SIZE", "1920,1080");

        WebDriver driver = null;

        try {
            switch (browser) {
                case "chrome":
                    driver = initializeChromeDriver(headless);
                    break;
                case "firefox":
                    driver = initializeFirefoxDriver(headless);
                    break;
                case "safari":
                    driver = initializeSafariDriver();
                    break;
                default:
                    logger.error("Unsupported browser: " + browser);
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            // Set window size
            setWindowSize(driver, windowSize);

            // Set timeouts
            int implicitWait = ConfigManager.getIntProperty("IMPLICIT_WAIT", 10);
            driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(implicitWait));

            logger.info("WebDriver initialized successfully for browser: " + browser);
            return driver;

        } catch (Exception e) {
            logger.error("Failed to initialize WebDriver: ", e);
            throw new RuntimeException("Failed to initialize WebDriver", e);
        }
    }

    /**
     * Initialize Chrome WebDriver
     */
    private static WebDriver initializeChromeDriver(boolean headless) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        if (headless) {
            options.addArguments("--headless");
        }

        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addExcludedArgument("enable-automation");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");

        logger.info("Initializing Chrome WebDriver");
        return new ChromeDriver(options);
    }

    /**
     * Initialize Firefox WebDriver
     */
    private static WebDriver initializeFirefoxDriver(boolean headless) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();

        if (headless) {
            options.addArguments("--headless");
        }

        options.addArguments("--start-maximized");
        logger.info("Initializing Firefox WebDriver");
        return new FirefoxDriver(options);
    }

    /**
     * Initialize Safari WebDriver
     */
    private static WebDriver initializeSafariDriver() {
        logger.info("Initializing Safari WebDriver");
        return new SafariDriver();
    }

    /**
     * Set window size
     */
    private static void setWindowSize(WebDriver driver, String windowSize) {
        try {
            String[] dimensions = windowSize.split(",");
            if (dimensions.length == 2) {
                int width = Integer.parseInt(dimensions[0].trim());
                int height = Integer.parseInt(dimensions[1].trim());
                driver.manage().window().setSize(new org.openqa.selenium.Dimension(width, height));
                logger.info("Window size set to: " + width + "x" + height);
            }
        } catch (Exception e) {
            logger.warn("Failed to set window size: ", e);
        }
    }

    /**
     * Quit WebDriver
     */
    public static void quitDriver(WebDriver driver) {
        if (driver != null) {
            try {
                driver.quit();
                logger.info("WebDriver quit successfully");
            } catch (Exception e) {
                logger.error("Error while quitting driver: ", e);
            }
        }
    }
}
