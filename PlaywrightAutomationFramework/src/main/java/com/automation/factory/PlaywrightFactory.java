package com.automation.factory;

import com.automation.config.ConfigReader;
import com.automation.context.TestContext;
import com.microsoft.playwright.*;

import java.nio.file.Paths;

/**
 * PlaywrightFactory to initialize and manage Playwright instances
 */
public class PlaywrightFactory {
    
    private TestContext testContext;
    
    public PlaywrightFactory(TestContext testContext) {
        this.testContext = testContext;
    }
    
    /**
     * Initialize Playwright browser
     */
    public Page initializeBrowser() {
        // Create Playwright instance
        Playwright playwright = Playwright.create();
        testContext.setPlaywright(playwright);
        
        // Launch browser
        Browser browser = launchBrowser(playwright);
        testContext.setBrowser(browser);
        
        // Create browser context with video recording
        BrowserContext context = createBrowserContext(browser);
        testContext.setContext(context);
        
        // Create new page
        Page page = context.newPage();
        testContext.setPage(page);
        
        // Set timeout
        page.setDefaultTimeout(ConfigReader.getBrowserTimeout());
        
        return page;
    }
    
    /**
     * Launch browser based on configuration
     */
    private Browser launchBrowser(Playwright playwright) {
        String browserName = ConfigReader.getBrowser().toLowerCase();
        boolean headless = ConfigReader.isHeadless();
        
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(headless)
                .setSlowMo(50);
        
        switch (browserName) {
            case "chromium":
                return playwright.chromium().launch(launchOptions);
            case "firefox":
                return playwright.firefox().launch(launchOptions);
            case "webkit":
                return playwright.webkit().launch(launchOptions);
            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }
    }
    
    /**
     * Create browser context with video recording configuration
     */
    private BrowserContext createBrowserContext(Browser browser) {
        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions()
                .setViewportSize(ConfigReader.getVideoWidth(), ConfigReader.getVideoHeight());
        
        // Configure video recording if enabled
        if (ConfigReader.isVideoEnabled()) {
            String videoDir = ConfigReader.getVideoPath();
            
            contextOptions.setRecordVideoDir(Paths.get(videoDir))
                    .setRecordVideoSize(ConfigReader.getVideoWidth(), ConfigReader.getVideoHeight());
        }
        
        return browser.newContext(contextOptions);
    }
    
    /**
     * Close browser and cleanup
     */
    public void closeBrowser() {
        if (testContext.getPage() != null) {
            testContext.getPage().close();
        }
        
        if (testContext.getContext() != null) {
            testContext.getContext().close();
        }
        
        if (testContext.getBrowser() != null) {
            testContext.getBrowser().close();
        }
        
        if (testContext.getPlaywright() != null) {
            testContext.getPlaywright().close();
        }
    }
}