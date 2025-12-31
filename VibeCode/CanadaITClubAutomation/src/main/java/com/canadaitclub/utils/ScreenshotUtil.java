package com.canadaitclub.utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Screenshot Utility to capture screenshots
 */
public class ScreenshotUtil {
    private static final Logger logger = LogManager.getLogger(ScreenshotUtil.class);
    private static final String SCREENSHOT_PATH = ConfigManager.getProperty("SCREENSHOT_PATH", "test-output/screenshots/");

    /**
     * Take screenshot of the entire page
     */
    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        try {
            // Create directory if not exists
            File directory = new File(SCREENSHOT_PATH);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Generate timestamp for unique filename
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
            String filename = screenshotName + "_" + timestamp + ".png";
            String filepath = SCREENSHOT_PATH + filename;

            // Take screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(filepath));

            logger.info("Screenshot captured: " + filepath);
            return filepath;

        } catch (Exception e) {
            logger.error("Failed to take screenshot: ", e);
            return null;
        }
    }

    /**
     * Take screenshot on failure
     */
    public static String takeFailureScreenshot(WebDriver driver, String testName) {
        return takeScreenshot(driver, "FAILURE_" + testName);
    }

    /**
     * Take screenshot on success
     */
    public static String takeSuccessScreenshot(WebDriver driver, String testName) {
        return takeScreenshot(driver, "SUCCESS_" + testName);
    }
}
