package com.canadaitclub.tests;

import com.canadaitclub.base.BaseTest;
import com.canadaitclub.pages.JobPostingPage;
import com.canadaitclub.utils.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test Suite 2: Job Header Section Tests
 */
public class JobHeaderTests extends BaseTest {
    private JobPostingPage jobPostingPage;

    @BeforeMethod(alwaysRun = true)
    public void pageLoadSetUp() {
        jobPostingPage = new JobPostingPage(driver);
        String jobPostingUrl = ConfigManager.getProperty("JOB_POSTING_URL");
        navigateTo(jobPostingUrl);
    }

    /**
     * TC-004: Verify Job Title and Key Information Display
     */
    @Test(description = "Ensure job title and critical metadata are displayed correctly")
    public void testJobTitleAndMetadata() {
        logger.info("Test: Job Title and Key Information Display");

        // Verify job title is displayed
        Assert.assertTrue(jobPostingPage.isJobTitleDisplayed(), "Job title should be displayed");

        // Verify job title text
        String jobTitle = jobPostingPage.getJobTitle();
        Assert.assertTrue(jobTitle.contains("Test Lead"), "Job title should contain 'Test Lead'");

        // Verify job category is displayed
        Assert.assertTrue(jobPostingPage.isJobCategoryDisplayed(), "Job category should be displayed");

        // Verify location is displayed
        Assert.assertTrue(jobPostingPage.isJobLocationDisplayed(), "Job location should be displayed");

        // Verify location text
        String location = jobPostingPage.getJobLocation();
        Assert.assertTrue(location.contains("Toronto") || location.contains("Ontario"),
            "Location should contain Toronto or Ontario");

        // Verify posted date is displayed
        Assert.assertTrue(jobPostingPage.isPostedDateDisplayed(), "Posted date should be displayed");

        logger.info("Test PASSED: Job title and metadata display correctly");
    }

    /**
     * TC-005: Verify Employer Logo and Company Link
     */
    @Test(description = "Validate the employer logo and company profile link")
    public void testCompanyLogoAndLink() {
        logger.info("Test: Employer Logo and Company Link");

        // Verify company logo is displayed
        Assert.assertTrue(jobPostingPage.isCompanyLogoDisplayed(), "Company logo should be displayed");

        // Click on company logo
        jobPostingPage.clickCompanyLogo();

        // Wait for navigation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.error("Thread sleep interrupted", e);
        }

        // Verify navigation to company profile
        String currentUrl = getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("employer") || currentUrl.contains("company"),
            "Should navigate to company profile page");

        logger.info("Test PASSED: Company logo and link work correctly");
    }

    /**
     * TC-006: Verify Job Type Badge Display
     */
    @Test(description = "Ensure job type indicator is correctly displayed")
    public void testJobTypeBadgeDisplay() {
        logger.info("Test: Job Type Badge Display");

        // Verify job type badge is displayed
        Assert.assertTrue(jobPostingPage.isJobTypeBadgeDisplayed(), "Job type badge should be displayed");

        // Verify job type text
        String jobType = jobPostingPage.getJobTypeBadgeText();
        Assert.assertEquals(jobType, "Contractor", "Job type should be 'Contractor'");

        logger.info("Test PASSED: Job type badge displays correctly");
    }
}
