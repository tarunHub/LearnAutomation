package com.canadaitclub.base;

import com.canadaitclub.utils.ConfigManager;
import com.canadaitclub.utils.ScreenshotUtil;
import com.canadaitclub.utils.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Base Test Class for all test classes
 * Handles WebDriver setup, teardown, and common utilities
 */
public class BaseTest {
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected WebDriver driver;

    /**
     * Setup method executed before each test
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        logger.info("===== Starting Test Setup =====");
        try {
            driver = WebDriverFactory.initializeDriver();
            logger.info("WebDriver initialized successfully");
        } catch (Exception e) {
            logger.error("Failed to initialize WebDriver: ", e);
            throw new RuntimeException("Failed to initialize WebDriver", e);
        }
    }

    /**
     * Teardown method executed after each test
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        logger.info("===== Starting Test Teardown =====");

        // Take screenshot on failure
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.error("Test FAILED: " + result.getName());
            boolean takeScreenshot = ConfigManager.getBooleanProperty("TAKE_SCREENSHOT_ON_FAILURE", true);
            if (takeScreenshot && driver != null) {
                ScreenshotUtil.takeFailureScreenshot(driver, result.getName());
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.info("Test PASSED: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.warn("Test SKIPPED: " + result.getName());
        }

        // Close WebDriver
        if (driver != null) {
            WebDriverFactory.quitDriver(driver);
            logger.info("WebDriver closed successfully");
        }

        logger.info("===== Test Completed =====");
    }

    /**
     * Navigate to URL
     */
    protected void navigateTo(String url) {
        logger.info("Navigating to: " + url);
        driver.navigate().to(url);
        int pageLoadWait = ConfigManager.getIntProperty("PAGE_LOAD_WAIT", 30);
        logger.info("Page load wait set to: " + pageLoadWait + " seconds");
    }

    /**
     * Get current URL
     */
    protected String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        logger.info("Current URL: " + url);
        return url;
    }

    /**
     * Get page title
     */
    protected String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Page title: " + title);
        return title;
    }

    /**
     * Refresh page
     */
    protected void refreshPage() {
        logger.info("Refreshing page");
        driver.navigate().refresh();
    }

    /**
     * Go back
     */
    protected void goBack() {
        logger.info("Going back to previous page");
        driver.navigate().back();
    }
}
