package com.automation.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

/**
 * BasePage class with common page operations
 */
public class BasePage {
    
    protected Page page;
    
    public BasePage(Page page) {
        this.page = page;
    }
    
    /**
     * Navigate to URL
     */
    public void navigateTo(String url) {
        page.navigate(url);
    }
    
    /**
     * Click on element
     */
    public void click(String selector) {
        page.click(selector);
    }
    
    /**
     * Fill text in input field
     */
    public void fill(String selector, String text) {
        page.fill(selector, text);
    }
    
    /**
     * Get text from element
     */
    public String getText(String selector) {
        return page.textContent(selector);
    }
    
    /**
     * Wait for element to be visible
     */
    public void waitForElement(String selector) {
        page.waitForSelector(selector, new Page.WaitForSelectorOptions()
                .setState(WaitForSelectorState.VISIBLE));
    }
    
    /**
     * Check if element is visible
     */
    public boolean isElementVisible(String selector) {
        try {
            return page.isVisible(selector);
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Get page title
     */
    public String getPageTitle() {
        return page.title();
    }
}