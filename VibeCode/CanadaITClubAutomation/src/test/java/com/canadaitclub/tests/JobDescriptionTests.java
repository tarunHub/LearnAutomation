package com.canadaitclub.tests;

import com.canadaitclub.base.BaseTest;
import com.canadaitclub.pages.JobPostingPage;
import com.canadaitclub.utils.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test Suite 4: Job Description Section Tests
 */
public class JobDescriptionTests extends BaseTest {
    private JobPostingPage jobPostingPage;

    @BeforeMethod(alwaysRun = true)
    public void pageLoadSetUp() {
        jobPostingPage = new JobPostingPage(driver);
        String jobPostingUrl = ConfigManager.getProperty("JOB_POSTING_URL");
        navigateTo(jobPostingUrl);
    }

    /**
     * TC-010: Verify Job Description Title and Structure
     */
    @Test(description = "Ensure job description section is properly formatted")
    public void testJobDescriptionStructure() {
        logger.info("Test: Job Description Title and Structure");

        // Verify Job Description heading is displayed
        Assert.assertTrue(jobPostingPage.isJobDescriptionHeadingDisplayed(),
            "Job Description heading should be displayed");

        logger.info("Test PASSED: Job description structure is correct");
    }

    /**
     * TC-011: Verify Key Details Display
     */
    @Test(description = "Validate job details metadata in description section")
    public void testKeyDetailsDisplay() {
        logger.info("Test: Key Details Display");

        // Verify job type badge is displayed
        Assert.assertTrue(jobPostingPage.isJobTypeBadgeDisplayed(),
            "Job type should be displayed");

        // Verify location is displayed
        Assert.assertTrue(jobPostingPage.isJobLocationDisplayed(),
            "Location should be displayed");

        logger.info("Test PASSED: Key details are displayed correctly");
    }

    /**
     * TC-015: Verify Key Responsibilities Section
     */
    @Test(description = "Validate display of job responsibilities")
    public void testResponsibilitiesSection() {
        logger.info("Test: Key Responsibilities Section");

        // Scroll to responsibilities section
        jobPostingPage.scrollToResponsibilities();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            logger.error("Thread sleep interrupted", e);
        }

        // Verify Responsibilities heading is displayed
        Assert.assertTrue(jobPostingPage.isResponsibilitiesHeadingDisplayed(),
            "Responsibilities heading should be displayed");

        // Verify responsibilities items are present
        int responsibilityCount = jobPostingPage.getResponsibilityItemsCount();
        logger.info("Number of responsibilities: " + responsibilityCount);
        Assert.assertTrue(responsibilityCount > 0, "Should have at least one responsibility");

        logger.info("Test PASSED: Responsibilities section displays correctly");
    }

    /**
     * TC-016: Verify Tools & Technologies Section
     */
    @Test(description = "Ensure all required tools and technologies are listed")
    public void testToolsAndTechnologiesSection() {
        logger.info("Test: Tools & Technologies Section");

        // Scroll to tools section
        jobPostingPage.scrollToResponsibilities();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            logger.error("Thread sleep interrupted", e);
        }

        // Verify Tools heading is displayed
        Assert.assertTrue(jobPostingPage.isToolsHeadingDisplayed(),
            "Tools heading should be displayed");

        // Verify tools items are present
        int toolsCount = jobPostingPage.getToolItemsCount();
        logger.info("Number of tools listed: " + toolsCount);
        Assert.assertTrue(toolsCount > 0, "Should have at least one tool listed");

        logger.info("Test PASSED: Tools and Technologies section displays correctly");
    }

    /**
     * TC-012: Verify Job Description Main Text
     */
    @Test(description = "Ensure main job description is readable and complete")
    public void testJobDescriptionText() {
        logger.info("Test: Job Description Main Text");

        // Get job description text
        String descriptionText = jobPostingPage.getJobDescriptionText();
        logger.info("Job Description: " + descriptionText);

        // Verify description is not empty
        Assert.assertNotNull(descriptionText, "Job description should not be null");
        Assert.assertFalse(descriptionText.isEmpty(), "Job description should not be empty");

        logger.info("Test PASSED: Job description text is readable");
    }

    /**
     * TC-013: Verify Location Information Display
     */
    @Test(description = "Validate location details in job description")
    public void testLocationInformationDisplay() {
        logger.info("Test: Location Information Display");

        // Verify location is displayed
        Assert.assertTrue(jobPostingPage.isJobLocationDisplayed(),
            "Location should be displayed");

        // Get location text
        String location = jobPostingPage.getJobLocation();
        logger.info("Location: " + location);

        // Verify location contains Toronto or Ontario
        Assert.assertTrue(location.contains("Toronto") || location.contains("Ontario"),
            "Location should contain Toronto or Ontario");

        logger.info("Test PASSED: Location information displays correctly");
    }

    /**
     * TC-014: Verify Experience Requirements Display
     */
    @Test(description = "Ensure experience requirements are clearly stated")
    public void testExperienceRequirements() {
        logger.info("Test: Experience Requirements Display");

        // Verify experience text is displayed
        Assert.assertTrue(jobPostingPage.isExperienceTextDisplayed(),
            "Experience requirements should be displayed");

        // Get experience text
        String experienceText = jobPostingPage.getExperienceText();
        logger.info("Experience Requirements: " + experienceText);

        // Verify it contains years requirement
        Assert.assertTrue(experienceText.contains("10+") || experienceText.contains("years"),
            "Experience should mention years requirement");

        logger.info("Test PASSED: Experience requirements display correctly");
    }
}
