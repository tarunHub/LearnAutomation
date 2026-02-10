package com.automation.utils;

import com.automation.config.ConfigReader;
import com.automation.context.TestContext;
import com.microsoft.playwright.Page;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ScreenshotUtil class to capture screenshots
 */
public class ScreenshotUtil {
    
    private TestContext testContext;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
    
    public ScreenshotUtil(TestContext testContext) {
        this.testContext = testContext;
        initializeDirectory();
    }
    
    /**
     * Initialize screenshot directory
     */
    private void initializeDirectory() {
        try {
            String screenshotPath = ConfigReader.getProperty("screenshot.path");
            Files.createDirectories(Paths.get(screenshotPath));
        } catch (IOException e) {
            System.err.println("Error creating screenshot directory: " + e.getMessage());
        }
    }
    
    /**
     * Capture screenshot
     */
    public byte[] captureScreenshot(String screenshotName) {
        try {
            Page page = testContext.getPage();
            if (page != null) {
                String timestamp = dateFormat.format(new Date());
                String fileName = screenshotName + "_" + timestamp + ".png";
                Path screenshotPath = Paths.get(
                    ConfigReader.getProperty("screenshot.path") + fileName
                );
                
                byte[] screenshot = page.screenshot(new Page.ScreenshotOptions()
                        .setPath(screenshotPath)
                        .setFullPage(true));
                
                System.out.println("Screenshot captured: " + screenshotPath);
                return screenshot;
            }
        } catch (Exception e) {
            System.err.println("Error capturing screenshot: " + e.getMessage());
        }
        return null;
    }
    
    /**
     * Capture screenshot on failure
     */
    public byte[] captureFailureScreenshot(String scenarioName) {
        return captureScreenshot(scenarioName + "_FAILED");
    }
}