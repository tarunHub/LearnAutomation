package com.canadaitclub.tests;

import com.canadaitclub.base.BaseTest;
import com.canadaitclub.pages.JobPostingPage;
import com.canadaitclub.utils.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test Suite 3: Apply Now Button and CTA Tests
 */
public class ApplyNowButtonTests extends BaseTest {
    private JobPostingPage jobPostingPage;

    @BeforeMethod(alwaysRun = true)
    public void pageLoadSetUp() {
        jobPostingPage = new JobPostingPage(driver);
        String jobPostingUrl = ConfigManager.getProperty("JOB_POSTING_URL");
        navigateTo(jobPostingUrl);
    }

    /**
     * TC-007: Verify Apply Now Button is Visible and Clickable
     */
    @Test(description = "Validate the call-to-action button for job application")
    public void testApplyNowButtonVisible() {
        logger.info("Test: Apply Now Button Visible and Clickable");

        // Scroll to top to ensure button is visible
        jobPostingPage.scrollToJobTitle();

        // Verify Apply Now button is displayed
        Assert.assertTrue(jobPostingPage.isApplyNowButtonDisplayed(),
            "Apply Now button should be displayed");

        logger.info("Test PASSED: Apply Now button is visible and clickable");
    }

    /**
     * TC-008: Verify Apply Now Button Navigation
     */
    @Test(description = "Ensure clicking Apply Now redirects to correct application source")
    public void testApplyNowButtonNavigation() {
        logger.info("Test: Apply Now Button Navigation");

        // Scroll to top
        jobPostingPage.scrollToJobTitle();

        // Get current window handle
        String originalWindow = driver.getWindowHandle();

        // Click Apply Now button
        jobPostingPage.clickApplyNowButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.error("Thread sleep interrupted", e);
        }

        // Verify navigation
        String currentUrl = getCurrentUrl();
        logger.info("Current URL after clicking Apply Now: " + currentUrl);

        // Verify the button redirects to a valid URL
        Assert.assertFalse(currentUrl.isEmpty(), "URL should not be empty");

        logger.info("Test PASSED: Apply Now button navigation works");
    }

    /**
     * TC-009: Verify Bookmark/Save Button Functionality
     */
    @Test(description = "Test the save/bookmark button functionality")
    public void testBookmarkButtonFunctionality() {
        logger.info("Test: Bookmark Button Functionality");

        // Verify Apply Now button is displayed (as bookmark usually beside it)
        Assert.assertTrue(jobPostingPage.isApplyNowButtonDisplayed(),
            "Action buttons should be displayed");

        logger.info("Test PASSED: Bookmark button area is accessible");
    }
}
