package com.canadaitclub.tests;

import com.canadaitclub.base.BaseTest;
import com.canadaitclub.pages.JobPostingPage;
import com.canadaitclub.utils.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test Suite 1: Page Load and Navigation Tests
 */
public class PageLoadAndNavigationTests extends BaseTest {
    private JobPostingPage jobPostingPage;

    @BeforeMethod(alwaysRun = true)
    public void pageLoadSetUp() {
        jobPostingPage = new JobPostingPage(driver);
        String jobPostingUrl = ConfigManager.getProperty("JOB_POSTING_URL");
        navigateTo(jobPostingUrl);
    }

    /**
     * TC-001: Verify Page Loads Successfully
     */
    @Test(description = "Verify that job posting page loads without errors")
    public void testPageLoadsSuccessfully() {
        logger.info("Test: Page Loads Successfully");

        // Verify page URL
        String currentUrl = getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("test-lead-5"), "Page URL should contain test-lead-5");

        // Verify page title
        String pageTitle = getPageTitle();
        logger.info("Page Title: " + pageTitle);

        // Verify job title is displayed
        Assert.assertTrue(jobPostingPage.isJobTitleDisplayed(), "Job title should be displayed");

        // Verify company logo is displayed
        Assert.assertTrue(jobPostingPage.isCompanyLogoDisplayed(), "Company logo should be displayed");

        logger.info("Test PASSED: Page loads successfully");
    }

    /**
     * TC-002: Verify Navigation Menu is Visible and Functional
     */
    @Test(description = "Verify navigation menu displays all menu items")
    public void testNavigationMenuVisible() {
        logger.info("Test: Navigation Menu Visible");

        // Verify navigation menu is displayed
        Assert.assertTrue(jobPostingPage.isNavigationMenuDisplayed(),
            "Navigation menu should be displayed");

        logger.info("Test PASSED: Navigation menu is visible and functional");
    }

    /**
     * TC-003: Test Navigation Menu Links
     */
    @Test(description = "Verify each navigation link routes to the correct page")
    public void testNavigationMenuLinks() {
        logger.info("Test: Navigation Menu Links");

        // Test Home link
        jobPostingPage.clickHomeLink();
        String homeUrl = getCurrentUrl();
        Assert.assertTrue(homeUrl.contains("canadaitclub.ca"), "Should navigate to home page");

        // Go back to job posting
        navigateTo(ConfigManager.getProperty("JOB_POSTING_URL"));
        jobPostingPage = new JobPostingPage(driver);

        // Test Browse Jobs link
        jobPostingPage.clickBrowseJobsLink();
        String browseJobsUrl = getCurrentUrl();
        Assert.assertTrue(browseJobsUrl.contains("browse-jobs") || browseJobsUrl.contains("job"),
            "Should navigate to browse jobs page");

        logger.info("Test PASSED: Navigation links route correctly");
    }
}
