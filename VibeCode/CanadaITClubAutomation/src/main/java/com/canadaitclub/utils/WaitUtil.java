package com.canadaitclub.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Wait Utility for handling explicit waits
 */
public class WaitUtil {
    private static final Logger logger = LogManager.getLogger(WaitUtil.class);

    /**
     * Wait for element to be present
     */
    public static WebElement waitForElementPresent(WebDriver driver, By locator) {
        try {
            int explicitWait = ConfigManager.getIntProperty("EXPLICIT_WAIT", 15);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
            logger.info("Waiting for element: " + locator);
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            logger.error("Element not found: " + locator, e);
            throw e;
        }
    }

    /**
     * Wait for element to be visible
     */
    public static WebElement waitForElementVisible(WebDriver driver, By locator) {
        try {
            int explicitWait = ConfigManager.getIntProperty("EXPLICIT_WAIT", 15);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
            logger.info("Waiting for element to be visible: " + locator);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            logger.error("Element not visible: " + locator, e);
            throw e;
        }
    }

    /**
     * Wait for element to be clickable
     */
    public static WebElement waitForElementClickable(WebDriver driver, By locator) {
        try {
            int explicitWait = ConfigManager.getIntProperty("EXPLICIT_WAIT", 15);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
            logger.info("Waiting for element to be clickable: " + locator);
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            logger.error("Element not clickable: " + locator, e);
            throw e;
        }
    }

    /**
     * Wait for all elements to be present
     */
    public static List<WebElement> waitForAllElementsPresent(WebDriver driver, By locator) {
        try {
            int explicitWait = ConfigManager.getIntProperty("EXPLICIT_WAIT", 15);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
            logger.info("Waiting for all elements: " + locator);
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            logger.error("Elements not found: " + locator, e);
            throw e;
        }
    }

    /**
     * Wait for URL to change
     */
    public static boolean waitForUrlContains(WebDriver driver, String urlPortion) {
        try {
            int explicitWait = ConfigManager.getIntProperty("EXPLICIT_WAIT", 15);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
            logger.info("Waiting for URL to contain: " + urlPortion);
            return wait.until(ExpectedConditions.urlContains(urlPortion));
        } catch (Exception e) {
            logger.error("URL not changed: " + urlPortion, e);
            return false;
        }
    }

    /**
     * Wait for element to disappear
     */
    public static boolean waitForElementDisappear(WebDriver driver, By locator) {
        try {
            int explicitWait = ConfigManager.getIntProperty("EXPLICIT_WAIT", 15);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
            logger.info("Waiting for element to disappear: " + locator);
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            logger.error("Element still visible: " + locator, e);
            return false;
        }
    }

    /**
     * Check if element exists without waiting
     */
    public static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            driver.findElement(locator);
            driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(ConfigManager.getIntProperty("IMPLICIT_WAIT", 10))
            );
            return true;
        } catch (NoSuchElementException e) {
            driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(ConfigManager.getIntProperty("IMPLICIT_WAIT", 10))
            );
            return false;
        }
    }
}
