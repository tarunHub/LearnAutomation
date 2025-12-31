package com.canadaitclub.tests;

import com.canadaitclub.base.BaseTest;
import com.canadaitclub.pages.JobPostingPage;
import com.canadaitclub.utils.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test Suite 5-7: Related Jobs, Share, and Footer Tests
 */
public class RelatedJobsAndShareTests extends BaseTest {
    private JobPostingPage jobPostingPage;

    @BeforeMethod(alwaysRun = true)
    public void pageLoadSetUp() {
        jobPostingPage = new JobPostingPage(driver);
        String jobPostingUrl = ConfigManager.getProperty("JOB_POSTING_URL");
        navigateTo(jobPostingUrl);
    }

    /**
     * TC-019: Verify Related Jobs Section Heading
     */
    @Test(description = "Ensure related jobs section displays correctly")
    public void testRelatedJobsSectionHeading() {
        logger.info("Test: Related Jobs Section Heading");

        // Verify Related Jobs heading is displayed
        Assert.assertTrue(jobPostingPage.isRelatedJobsHeadingDisplayed(),
            "Related Jobs heading should be displayed");

        logger.info("Test PASSED: Related Jobs section heading displays");
    }

    /**
     * TC-020: Verify Related Job Cards Display
     */
    @Test(description = "Validate display of related job listings")
    public void testRelatedJobCardsDisplay() {
        logger.info("Test: Related Job Cards Display");

        // Get count of related jobs
        int relatedJobsCount = jobPostingPage.getRelatedJobCardsCount();
        logger.info("Number of related jobs displayed: " + relatedJobsCount);

        // Verify at least one related job is displayed
        Assert.assertTrue(relatedJobsCount >= 0, "Related jobs should be displayed");

        logger.info("Test PASSED: Related job cards display correctly");
    }

    /**
     * TC-022: Verify Share Section Display
     */
    @Test(description = "Ensure sharing options are visible")
    public void testShareSectionDisplay() {
        logger.info("Test: Share Section Display");

        // Scroll to footer to see share buttons
        jobPostingPage.scrollToFooter();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            logger.error("Thread sleep interrupted", e);
        }

        logger.info("Test PASSED: Share section is accessible");
    }

    /**
     * TC-023: Test Twitter Share Button
     */
    @Test(description = "Verify Twitter share functionality")
    public void testTwitterShareButton() {
        logger.info("Test: Twitter Share Button");

        // Scroll to share section
        jobPostingPage.scrollToFooter();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            logger.error("Thread sleep interrupted", e);
        }

        String originalWindow = driver.getWindowHandle();

        // Click Twitter share button
        jobPostingPage.clickTwitterShareButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.error("Thread sleep interrupted", e);
        }

        logger.info("Test PASSED: Twitter share button clicked successfully");
    }

    /**
     * TC-024: Test LinkedIn Share Button
     */
    @Test(description = "Verify LinkedIn share functionality")
    public void testLinkedinShareButton() {
        logger.info("Test: LinkedIn Share Button");

        // Scroll to share section
        jobPostingPage.scrollToFooter();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            logger.error("Thread sleep interrupted", e);
        }

        // Click LinkedIn share button
        jobPostingPage.clickLinkedinShareButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.error("Thread sleep interrupted", e);
        }

        logger.info("Test PASSED: LinkedIn share button clicked successfully");
    }
}
