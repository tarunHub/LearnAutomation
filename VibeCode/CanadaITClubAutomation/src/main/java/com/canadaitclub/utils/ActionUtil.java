package com.canadaitclub.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Common Action Utility for reusable operations
 */
public class ActionUtil {
    private static final Logger logger = LogManager.getLogger(ActionUtil.class);

    /**
     * Click on element using JavaScript
     */
    public static void jsClick(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            logger.info("JavaScript click performed");
        } catch (Exception e) {
            logger.error("JavaScript click failed: ", e);
            throw e;
        }
    }

    /**
     * Scroll to element
     */
    public static void scrollToElement(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", element);
            logger.info("Scrolled to element");
        } catch (Exception e) {
            logger.error("Scroll to element failed: ", e);
            throw e;
        }
    }

    /**
     * Scroll to top of page
     */
    public static void scrollToTop(WebDriver driver) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("window.scrollTo(0, 0);");
            logger.info("Scrolled to top of page");
        } catch (Exception e) {
            logger.error("Scroll to top failed: ", e);
        }
    }

    /**
     * Scroll to bottom of page
     */
    public static void scrollToBottom(WebDriver driver) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            logger.info("Scrolled to bottom of page");
        } catch (Exception e) {
            logger.error("Scroll to bottom failed: ", e);
        }
    }

    /**
     * Get page source
     */
    public static String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    /**
     * Execute JavaScript and return result
     */
    public static Object executeScript(WebDriver driver, String script) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            return executor.executeScript(script);
        } catch (Exception e) {
            logger.error("Script execution failed: ", e);
            throw e;
        }
    }

    /**
     * Check if element is visible
     */
    public static boolean isElementVisible(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            logger.warn("Element not visible: ", e);
            return false;
        }
    }

    /**
     * Get element text
     */
    public static String getElementText(WebDriver driver, By locator) {
        try {
            WebElement element = WaitUtil.waitForElementVisible(driver, locator);
            return element.getText();
        } catch (Exception e) {
            logger.error("Failed to get element text: ", e);
            return "";
        }
    }

    /**
     * Click on element
     */
    public static void clickElement(WebDriver driver, By locator) {
        try {
            WebElement element = WaitUtil.waitForElementClickable(driver, locator);
            element.click();
            logger.info("Element clicked: " + locator);
        } catch (Exception e) {
            logger.error("Failed to click element: ", e);
            throw e;
        }
    }

    /**
     * Enter text in element
     */
    public static void enterText(WebDriver driver, By locator, String text) {
        try {
            WebElement element = WaitUtil.waitForElementVisible(driver, locator);
            element.clear();
            element.sendKeys(text);
            logger.info("Text entered in element: " + text);
        } catch (Exception e) {
            logger.error("Failed to enter text: ", e);
            throw e;
        }
    }

    /**
     * Clear element
     */
    public static void clearElement(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            element.clear();
            logger.info("Element cleared");
        } catch (Exception e) {
            logger.error("Failed to clear element: ", e);
        }
    }

    /**
     * Get element attribute value
     */
    public static String getElementAttribute(WebDriver driver, By locator, String attributeName) {
        try {
            WebElement element = driver.findElement(locator);
            return element.getAttribute(attributeName);
        } catch (Exception e) {
            logger.error("Failed to get element attribute: ", e);
            return "";
        }
    }

    /**
     * Check if page contains text
     */
    public static boolean pageContainsText(WebDriver driver, String text) {
        try {
            return driver.getPageSource().contains(text);
        } catch (Exception e) {
            logger.error("Failed to check page text: ", e);
            return false;
        }
    }

    /**
     * Wait for specific time (in milliseconds)
     */
    public static void wait(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
            logger.info("Waited for " + milliseconds + " milliseconds");
        } catch (InterruptedException e) {
            logger.error("Thread sleep interrupted: ", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Get current page URL
     */
    public static String getCurrentPageUrl(WebDriver driver) {
        String url = driver.getCurrentUrl();
        logger.info("Current URL: " + url);
        return url;
    }

    /**
     * Get current page title
     */
    public static String getCurrentPageTitle(WebDriver driver) {
        String title = driver.getTitle();
        logger.info("Current Page Title: " + title);
        return title;
    }

    /**
     * Navigate to URL
     */
    public static void navigateToUrl(WebDriver driver, String url) {
        try {
            driver.navigate().to(url);
            logger.info("Navigated to: " + url);
        } catch (Exception e) {
            logger.error("Failed to navigate to URL: ", e);
            throw e;
        }
    }

    /**
     * Refresh page
     */
    public static void refreshPage(WebDriver driver) {
        try {
            driver.navigate().refresh();
            logger.info("Page refreshed");
        } catch (Exception e) {
            logger.error("Failed to refresh page: ", e);
        }
    }

    /**
     * Go back
     */
    public static void goBack(WebDriver driver) {
        try {
            driver.navigate().back();
            logger.info("Navigated back");
        } catch (Exception e) {
            logger.error("Failed to navigate back: ", e);
        }
    }

    /**
     * Go forward
     */
    public static void goForward(WebDriver driver) {
        try {
            driver.navigate().forward();
            logger.info("Navigated forward");
        } catch (Exception e) {
            logger.error("Failed to navigate forward: ", e);
        }
    }
}
