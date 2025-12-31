package com.canadaitclub.pages;

import com.canadaitclub.utils.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Page Object for Job Posting Page
 * Contains all locators and methods for job posting page
 */
public class JobPostingPage {
    private static final Logger logger = LogManager.getLogger(JobPostingPage.class);
    private WebDriver driver;

    // Navigation Menu Locators
    @FindBy(xpath = "//nav[@class='navigation']")
    private WebElement navigationMenu;

    @FindBy(xpath = "//a[text()='Home']")
    private WebElement homeLink;

    @FindBy(xpath = "//a[text()='About Us']")
    private WebElement aboutUsLink;

    @FindBy(xpath = "//a[text()='Browse Jobs']")
    private WebElement browseJobsLink;

    // Header Section Locators
    @FindBy(xpath = "//h1[contains(text(), 'Test Lead')]")
    private WebElement jobTitle;

    @FindBy(xpath = "//div[contains(text(), 'Quality Assurance')]")
    private WebElement jobCategory;

    @FindBy(xpath = "//span[contains(text(), 'Ontario – Toronto')]")
    private WebElement jobLocation;

    @FindBy(xpath = "//span[contains(text(), 'Posted')]")
    private WebElement postedDate;

    // Logo and Company Locators
    @FindBy(xpath = "//img[@alt='Canada IT Club']")
    private WebElement companyLogo;

    @FindBy(xpath = "//a[contains(@href, 'employer/canada-it-club')]")
    private WebElement companyProfileLink;

    // Job Type Locator
    @FindBy(xpath = "//span[contains(text(), 'Contractor')]")
    private WebElement jobTypeBadge;

    // Apply Now Button
    @FindBy(xpath = "//a[contains(text(), 'Apply Now')]")
    private WebElement applyNowButton;

    // Bookmark/Save Button
    @FindBy(xpath = "//button[contains(@class, 'bookmark')]")
    private WebElement bookmarkButton;

    // Job Description Section
    @FindBy(xpath = "//h3[contains(text(), 'Job Description')]")
    private WebElement jobDescriptionHeading;

    @FindBy(xpath = "//div[@class='job-description']//p")
    private WebElement jobDescriptionText;

    // Key Details
    @FindBy(xpath = "//div[contains(text(), 'Contractor')]")
    private WebElement detailsJobType;

    @FindBy(xpath = "//div[contains(text(), 'Anywhere')]")
    private WebElement detailsLocation;

    // Experience Section
    @FindBy(xpath = "//span[contains(text(), '10+ years')]")
    private WebElement experienceText;

    // Key Responsibilities
    @FindBy(xpath = "//h3[contains(text(), 'Key Responsibilities')]")
    private WebElement responsibilitiesHeading;

    @FindBy(xpath = "//div[@class='responsibilities']//li")
    private List<WebElement> responsibilityItems;

    // Tools & Technologies
    @FindBy(xpath = "//h3[contains(text(), 'Tools & Technologies')]")
    private WebElement toolsHeading;

    @FindBy(xpath = "//div[@class='tools']//li")
    private List<WebElement> toolItems;

    // What We're Looking For
    @FindBy(xpath = "//h3[contains(text(), 'What We')]")
    private WebElement lookingForHeading;

    @FindBy(xpath = "//div[@class='looking-for']//p")
    private WebElement lookingForText;

    // Contact Email
    @FindBy(xpath = "//a[contains(@href, 'mailto:')]")
    private WebElement contactEmail;

    // Related Jobs Section
    @FindBy(xpath = "//h3[contains(text(), 'Related')]")
    private WebElement relatedJobsHeading;

    @FindBy(xpath = "//div[@class='related-job-card']")
    private List<WebElement> relatedJobCards;

    // Share Buttons
    @FindBy(xpath = "//a[contains(@href, 'twitter')]")
    private WebElement twitterShareButton;

    @FindBy(xpath = "//a[contains(@href, 'linkedin')]")
    private WebElement linkedinShareButton;

    // Job Overview Sidebar
    @FindBy(xpath = "//h3[contains(text(), 'Job Overview')]")
    private WebElement jobOverviewHeading;

    @FindBy(xpath = "//span[contains(text(), 'Date Posted')]/following-sibling::span")
    private WebElement datePostedValue;

    @FindBy(xpath = "//span[contains(text(), 'Expiration')]/following-sibling::span")
    private WebElement expirationDateValue;

    @FindBy(xpath = "//span[contains(text(), 'Work Location')]/following-sibling::span")
    private WebElement workLocationType;

    // Employer Information
    @FindBy(xpath = "//h3[contains(text(), 'Employer Information')]")
    private WebElement employerInfoHeading;

    @FindBy(xpath = "//a[contains(text(), 'View Company Profile')]")
    private WebElement viewCompanyProfileLink;

    // Footer
    @FindBy(xpath = "//footer//a[contains(text(), 'About Us')]")
    private WebElement footerAboutUsLink;

    @FindBy(xpath = "//footer//a[contains(text(), 'Privacy Policy')]")
    private WebElement footerPrivacyLink;

    @FindBy(xpath = "//footer//a[contains(text(), 'Terms')]")
    private WebElement footerTermsLink;

    // Social Media Links
    @FindBy(xpath = "//a[contains(@href, 'linkedin.com/company')]")
    private WebElement linkedinSocialLink;

    @FindBy(xpath = "//a[contains(@href, 'whatsapp')]")
    private WebElement whatsappLink;

    @FindBy(xpath = "//a[contains(@href, 'youtube')]")
    private WebElement youtubeLink;

    @FindBy(xpath = "//a[contains(@href, 'instagram')]")
    private WebElement instagramLink;

    // Feedback Section
    @FindBy(xpath = "//a[contains(@href, 'mailto:hello')]")
    private WebElement feedbackEmail;

    // Constructor
    public JobPostingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger.info("JobPostingPage initialized");
    }

    // Navigation Methods
    public void clickHomeLink() {
        logger.info("Clicking Home link");
        WaitUtil.waitForElementClickable(driver, By.xpath("//a[text()='Home']")).click();
    }

    public void clickAboutUsLink() {
        logger.info("Clicking About Us link");
        WaitUtil.waitForElementClickable(driver, By.xpath("//a[text()='About Us']")).click();
    }

    public void clickBrowseJobsLink() {
        logger.info("Clicking Browse Jobs link");
        WaitUtil.waitForElementClickable(driver, By.xpath("//a[text()='Browse Jobs']")).click();
    }

    // Header Verification Methods
    public boolean isJobTitleDisplayed() {
        logger.info("Verifying job title is displayed");
        try {
            WaitUtil.waitForElementVisible(driver, By.xpath("//h1[contains(text(), 'Test Lead')]"));
            return jobTitle.isDisplayed();
        } catch (Exception e) {
            logger.error("Job title not displayed", e);
            return false;
        }
    }

    public String getJobTitle() {
        logger.info("Getting job title");
        return jobTitle.getText();
    }

    public boolean isJobCategoryDisplayed() {
        logger.info("Verifying job category is displayed");
        try {
            return jobCategory.isDisplayed();
        } catch (Exception e) {
            logger.error("Job category not displayed", e);
            return false;
        }
    }

    public boolean isJobLocationDisplayed() {
        logger.info("Verifying job location is displayed");
        try {
            return jobLocation.isDisplayed();
        } catch (Exception e) {
            logger.error("Job location not displayed", e);
            return false;
        }
    }

    public String getJobLocation() {
        logger.info("Getting job location");
        return jobLocation.getText();
    }

    public boolean isPostedDateDisplayed() {
        logger.info("Verifying posted date is displayed");
        try {
            return postedDate.isDisplayed();
        } catch (Exception e) {
            logger.error("Posted date not displayed", e);
            return false;
        }
    }

    // Logo Methods
    public boolean isCompanyLogoDisplayed() {
        logger.info("Verifying company logo is displayed");
        try {
            return companyLogo.isDisplayed();
        } catch (Exception e) {
            logger.error("Company logo not displayed", e);
            return false;
        }
    }

    public void clickCompanyLogo() {
        logger.info("Clicking company logo");
        WaitUtil.waitForElementClickable(driver, By.xpath("//img[@alt='Canada IT Club']")).click();
    }

    // Apply Now Button Methods
    public boolean isApplyNowButtonDisplayed() {
        logger.info("Verifying Apply Now button is displayed");
        try {
            return applyNowButton.isDisplayed();
        } catch (Exception e) {
            logger.error("Apply Now button not displayed", e);
            return false;
        }
    }

    public void clickApplyNowButton() {
        logger.info("Clicking Apply Now button");
        WaitUtil.waitForElementClickable(driver, By.xpath("//a[contains(text(), 'Apply Now')]")).click();
    }

    // Job Description Methods
    public boolean isJobDescriptionHeadingDisplayed() {
        logger.info("Verifying Job Description heading is displayed");
        try {
            return jobDescriptionHeading.isDisplayed();
        } catch (Exception e) {
            logger.error("Job Description heading not displayed", e);
            return false;
        }
    }

    public String getJobDescriptionText() {
        logger.info("Getting job description text");
        return jobDescriptionText.getText();
    }

    // Experience Methods
    public boolean isExperienceTextDisplayed() {
        logger.info("Verifying experience text is displayed");
        try {
            return experienceText.isDisplayed();
        } catch (Exception e) {
            logger.error("Experience text not displayed", e);
            return false;
        }
    }

    public String getExperienceText() {
        logger.info("Getting experience text");
        return experienceText.getText();
    }

    // Responsibilities Methods
    public boolean isResponsibilitiesHeadingDisplayed() {
        logger.info("Verifying Responsibilities heading is displayed");
        try {
            return responsibilitiesHeading.isDisplayed();
        } catch (Exception e) {
            logger.error("Responsibilities heading not displayed", e);
            return false;
        }
    }

    public int getResponsibilityItemsCount() {
        logger.info("Getting responsibilities count");
        return responsibilityItems.size();
    }

    public List<WebElement> getResponsibilityItems() {
        logger.info("Getting responsibility items");
        return responsibilityItems;
    }

    // Tools & Technologies Methods
    public boolean isToolsHeadingDisplayed() {
        logger.info("Verifying Tools heading is displayed");
        try {
            return toolsHeading.isDisplayed();
        } catch (Exception e) {
            logger.error("Tools heading not displayed", e);
            return false;
        }
    }

    public int getToolItemsCount() {
        logger.info("Getting tools count");
        return toolItems.size();
    }

    public List<WebElement> getToolItems() {
        logger.info("Getting tool items");
        return toolItems;
    }

    // Related Jobs Methods
    public boolean isRelatedJobsHeadingDisplayed() {
        logger.info("Verifying Related Jobs heading is displayed");
        try {
            return relatedJobsHeading.isDisplayed();
        } catch (Exception e) {
            logger.error("Related Jobs heading not displayed", e);
            return false;
        }
    }

    public int getRelatedJobCardsCount() {
        logger.info("Getting related jobs count");
        return relatedJobCards.size();
    }

    // Share Methods
    public void clickTwitterShareButton() {
        logger.info("Clicking Twitter share button");
        WaitUtil.waitForElementClickable(driver, By.xpath("//a[contains(@href, 'twitter')]")).click();
    }

    public void clickLinkedinShareButton() {
        logger.info("Clicking LinkedIn share button");
        WaitUtil.waitForElementClickable(driver, By.xpath("//a[contains(@href, 'linkedin')]")).click();
    }

    // Job Overview Methods
    public boolean isJobOverviewHeadingDisplayed() {
        logger.info("Verifying Job Overview heading is displayed");
        try {
            return jobOverviewHeading.isDisplayed();
        } catch (Exception e) {
            logger.error("Job Overview heading not displayed", e);
            return false;
        }
    }

    public String getDatePosted() {
        logger.info("Getting date posted");
        return datePostedValue.getText();
    }

    public String getExpirationDate() {
        logger.info("Getting expiration date");
        return expirationDateValue.getText();
    }

    public String getWorkLocationType() {
        logger.info("Getting work location type");
        return workLocationType.getText();
    }

    // Employer Information Methods
    public boolean isEmployerInfoHeadingDisplayed() {
        logger.info("Verifying Employer Information heading is displayed");
        try {
            return employerInfoHeading.isDisplayed();
        } catch (Exception e) {
            logger.error("Employer Information heading not displayed", e);
            return false;
        }
    }

    public void clickViewCompanyProfileLink() {
        logger.info("Clicking View Company Profile link");
        WaitUtil.waitForElementClickable(driver, By.xpath("//a[contains(text(), 'View Company Profile')]")).click();
    }

    // Footer Methods
    public void clickFooterAboutUsLink() {
        logger.info("Clicking footer About Us link");
        WaitUtil.waitForElementClickable(driver, By.xpath("//footer//a[contains(text(), 'About Us')]")).click();
    }

    public void clickFooterPrivacyLink() {
        logger.info("Clicking footer Privacy link");
        WaitUtil.waitForElementClickable(driver, By.xpath("//footer//a[contains(text(), 'Privacy Policy')]")).click();
    }

    // Social Media Methods
    public void clickLinkedinSocialLink() {
        logger.info("Clicking LinkedIn social link");
        WaitUtil.waitForElementClickable(driver, By.xpath("//a[contains(@href, 'linkedin.com/company')]")).click();
    }

    public void clickYoutubeSocialLink() {
        logger.info("Clicking YouTube social link");
        WaitUtil.waitForElementClickable(driver, By.xpath("//a[contains(@href, 'youtube')]")).click();
    }

    public void clickInstagramSocialLink() {
        logger.info("Clicking Instagram social link");
        WaitUtil.waitForElementClickable(driver, By.xpath("//a[contains(@href, 'instagram')]")).click();
    }

    // Scroll Methods
    public void scrollToJobTitle() {
        logger.info("Scrolling to job title");
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", jobTitle);
    }

    public void scrollToResponsibilities() {
        logger.info("Scrolling to responsibilities section");
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", responsibilitiesHeading);
    }

    public void scrollToFooter() {
        logger.info("Scrolling to footer");
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // Utility Methods
    public boolean isNavigationMenuDisplayed() {
        logger.info("Verifying navigation menu is displayed");
        try {
            return navigationMenu.isDisplayed();
        } catch (Exception e) {
            logger.error("Navigation menu not displayed", e);
            return false;
        }
    }

    public boolean isJobTypeBadgeDisplayed() {
        logger.info("Verifying job type badge is displayed");
        try {
            return jobTypeBadge.isDisplayed();
        } catch (Exception e) {
            logger.error("Job type badge not displayed", e);
            return false;
        }
    }

    public String getJobTypeBadgeText() {
        logger.info("Getting job type badge text");
        return jobTypeBadge.getText();
    }
}
