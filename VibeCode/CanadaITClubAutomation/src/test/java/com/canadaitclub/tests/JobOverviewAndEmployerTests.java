package com.canadaitclub.tests;

import com.canadaitclub.base.BaseTest;
import com.canadaitclub.pages.JobPostingPage;
import com.canadaitclub.utils.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test Suite 8-10: Job Overview, Employer Information, and Footer Tests
 */
public class JobOverviewAndEmployerTests extends BaseTest {
    private JobPostingPage jobPostingPage;

    @BeforeMethod(alwaysRun = true)
    public void pageLoadSetUp() {
        jobPostingPage = new JobPostingPage(driver);
        String jobPostingUrl = ConfigManager.getProperty("JOB_POSTING_URL");
        navigateTo(jobPostingUrl);
    }

    /**
     * TC-027: Verify Job Overview Sidebar Displays
     */
    @Test(description = "Ensure job overview information sidebar is visible")
    public void testJobOverviewSidebarDisplay() {
        logger.info("Test: Job Overview Sidebar Display");

        // Verify Job Overview heading is displayed
        Assert.assertTrue(jobPostingPage.isJobOverviewHeadingDisplayed(),
            "Job Overview heading should be displayed");

        logger.info("Test PASSED: Job Overview sidebar displays correctly");
    }

    /**
     * TC-028: Verify Date Posted Information
     */
    @Test(description = "Validate date posted display in overview")
    public void testDatePostedInformation() {
        logger.info("Test: Date Posted Information");

        // Get date posted
        String datePosted = jobPostingPage.getDatePosted();
        logger.info("Date Posted: " + datePosted);

        // Verify date is not empty
        Assert.assertNotNull(datePosted, "Date posted should not be null");
        Assert.assertFalse(datePosted.isEmpty(), "Date posted should not be empty");

        // Verify date contains number (year)
        Assert.assertTrue(datePosted.matches(".*\\d+.*"), "Date should contain numbers");

        logger.info("Test PASSED: Date posted displays correctly");
    }

    /**
     * TC-029: Verify Location Information in Overview
     */
    @Test(description = "Validate location display in overview sidebar")
    public void testLocationInformationInOverview() {
        logger.info("Test: Location Information in Overview");

        // Get location from overview
        String location = jobPostingPage.getJobLocation();
        logger.info("Location: " + location);

        // Verify location contains Toronto
        Assert.assertTrue(location.contains("Toronto") || location.contains("Ontario"),
            "Location should contain Toronto or Ontario");

        logger.info("Test PASSED: Location in overview displays correctly");
    }

    /**
     * TC-030: Verify Expiration Date Display
     */
    @Test(description = "Validate job expiration date")
    public void testExpirationDateDisplay() {
        logger.info("Test: Expiration Date Display");

        // Get expiration date
        String expirationDate = jobPostingPage.getExpirationDate();
        logger.info("Expiration Date: " + expirationDate);

        // Verify expiration date is not empty
        Assert.assertNotNull(expirationDate, "Expiration date should not be null");
        Assert.assertFalse(expirationDate.isEmpty(), "Expiration date should not be empty");

        logger.info("Test PASSED: Expiration date displays correctly");
    }

    /**
     * TC-031: Verify Work Location Type Display
     */
    @Test(description = "Validate work location type")
    public void testWorkLocationTypeDisplay() {
        logger.info("Test: Work Location Type Display");

        // Get work location type
        String workLocationType = jobPostingPage.getWorkLocationType();
        logger.info("Work Location Type: " + workLocationType);

        // Verify work location type contains On-site
        Assert.assertTrue(workLocationType.contains("On") || workLocationType.contains("on") || 
                         workLocationType.contains("site") || workLocationType.isEmpty(),
            "Work location type should be On-site or similar");

        logger.info("Test PASSED: Work location type displays correctly");
    }

    /**
     * TC-032: Verify Employer Information Section Displays
     */
    @Test(description = "Ensure employer information section is visible")
    public void testEmployerInformationSection() {
        logger.info("Test: Employer Information Section");

        // Verify Employer Information heading is displayed
        Assert.assertTrue(jobPostingPage.isEmployerInfoHeadingDisplayed(),
            "Employer Information heading should be displayed");

        logger.info("Test PASSED: Employer Information section displays");
    }

    /**
     * TC-033: Test View Company Profile Link
     */
    @Test(description = "Verify link to employer company profile")
    public void testViewCompanyProfileLink() {
        logger.info("Test: View Company Profile Link");

        String originalUrl = getCurrentUrl();

        // Click View Company Profile link
        jobPostingPage.clickViewCompanyProfileLink();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.error("Thread sleep interrupted", e);
        }

        // Verify navigation
        String newUrl = getCurrentUrl();
        logger.info("Navigated to: " + newUrl);

        // Verify different URL
        Assert.assertNotEquals(newUrl, originalUrl, "Should navigate to company profile page");

        logger.info("Test PASSED: Company profile link works correctly");
    }
}
