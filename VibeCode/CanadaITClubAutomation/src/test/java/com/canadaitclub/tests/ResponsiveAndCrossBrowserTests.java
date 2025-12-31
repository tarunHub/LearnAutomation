package com.canadaitclub.tests;

import com.canadaitclub.base.BaseTest;
import com.canadaitclub.pages.JobPostingPage;
import com.canadaitclub.utils.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test Suite 11: Responsive Design & Cross-Browser Tests
 */
public class ResponsiveAndCrossBrowserTests extends BaseTest {
    private JobPostingPage jobPostingPage;

    @BeforeMethod(alwaysRun = true)
    public void pageLoadSetUp() {
        jobPostingPage = new JobPostingPage(driver);
        String jobPostingUrl = ConfigManager.getProperty("JOB_POSTING_URL");
        navigateTo(jobPostingUrl);
    }

    /**
     * TC-041: Verify Page Responsive on Mobile
     */
    @Test(description = "Test page layout on mobile devices")
    public void testResponsiveDesignMobile() {
        logger.info("Test: Responsive Design Mobile");

        // Resize window to mobile size
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(375, 667));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.error("Thread sleep interrupted", e);
        }

        // Verify page loads on mobile
        Assert.assertTrue(jobPostingPage.isJobTitleDisplayed(), "Job title should be visible on mobile");

        // Restore window size
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));

        logger.info("Test PASSED: Page is responsive on mobile");
    }

    /**
     * TC-042: Verify Page Responsive on Tablet
     */
    @Test(description = "Test page layout on tablet devices")
    public void testResponsiveDesignTablet() {
        logger.info("Test: Responsive Design Tablet");

        // Resize window to tablet size
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(768, 1024));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.error("Thread sleep interrupted", e);
        }

        // Verify page loads on tablet
        Assert.assertTrue(jobPostingPage.isJobTitleDisplayed(), "Job title should be visible on tablet");

        // Restore window size
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));

        logger.info("Test PASSED: Page is responsive on tablet");
    }

    /**
     * TC-043: Test Browser Compatibility - Chrome
     * Note: This test runs in Chrome by default as per config
     */
    @Test(description = "Verify page works correctly in Chrome browser")
    public void testChromeCompatibility() {
        logger.info("Test: Chrome Compatibility");

        // Verify page loads in Chrome
        Assert.assertTrue(jobPostingPage.isJobTitleDisplayed(), "Page should load in Chrome");

        // Verify apply button works
        Assert.assertTrue(jobPostingPage.isApplyNowButtonDisplayed(), "Apply button should work in Chrome");

        logger.info("Test PASSED: Page works correctly in Chrome");
    }

    /**
     * TC-064: Verify Page Title Accuracy
     */
    @Test(description = "Ensure browser tab title is accurate")
    public void testPageTitleAccuracy() {
        logger.info("Test: Page Title Accuracy");

        // Get page title
        String pageTitle = getPageTitle();
        logger.info("Page Title: " + pageTitle);

        // Verify page title is not empty
        Assert.assertNotNull(pageTitle, "Page title should not be null");
        Assert.assertFalse(pageTitle.isEmpty(), "Page title should not be empty");

        // Verify page title contains relevant keywords
        Assert.assertTrue(pageTitle.contains("Test Lead") || pageTitle.contains("Job") || 
                         pageTitle.contains("Canada IT Club"),
            "Page title should contain relevant keywords");

        logger.info("Test PASSED: Page title is accurate");
    }
}
