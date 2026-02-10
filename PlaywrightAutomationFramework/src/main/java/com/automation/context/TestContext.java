package com.automation.context;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.HashMap;
import java.util.Map;

/**
 * TestContext class to share context between steps
 */
public class TestContext {
    
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;
    private Map<String, Object> scenarioContext;
    private String scenarioName;
    private String videoPath;
    
    public TestContext() {
        scenarioContext = new HashMap<>();
    }
    
    public Playwright getPlaywright() {
        return playwright;
    }
    
    public void setPlaywright(Playwright playwright) {
        this.playwright = playwright;
    }
    
    public Browser getBrowser() {
        return browser;
    }
    
    public void setBrowser(Browser browser) {
        this.browser = browser;
    }
    
    public BrowserContext getContext() {
        return context;
    }
    
    public void setContext(BrowserContext context) {
        this.context = context;
    }
    
    public Page getPage() {
        return page;
    }
    
    public void setPage(Page page) {
        this.page = page;
    }
    
    public void setContextData(String key, Object value) {
        scenarioContext.put(key, value);
    }
    
    public Object getContextData(String key) {
        return scenarioContext.get(key);
    }
    
    public String getScenarioName() {
        return scenarioName;
    }
    
    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }
    
    public String getVideoPath() {
        return videoPath;
    }
    
    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
    
    public void clearContext() {
        scenarioContext.clear();
    }
}