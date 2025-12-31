# Canada IT Club Automation Framework - Comprehensive Guide

## Document Version: 1.0
## Date: December 18, 2025
## Project: Canada IT Club Job Posting Portal - Test Automation

---

## Table of Contents
1. [Framework Overview](#framework-overview)
2. [Architecture & Design Patterns](#architecture--design-patterns)
3. [Project Structure](#project-structure)
4. [Component Details](#component-details)
5. [Getting Started](#getting-started)
6. [Writing Tests](#writing-tests)
7. [Best Practices](#best-practices)
8. [Common Issues & Solutions](#common-issues--solutions)
9. [Configuration Guide](#configuration-guide)
10. [Maintenance & Updates](#maintenance--updates)

---

## Framework Overview

### Purpose
This framework provides a robust, maintainable, and scalable automation solution for testing the Canada IT Club job posting page using Selenium WebDriver with Java and the Page Object Model design pattern.

### Key Characteristics
- **Design Pattern**: Page Object Model (POM)
- **Test Framework**: TestNG
- **Browser Automation**: Selenium WebDriver 4.15.0
- **Logging**: Log4j2
- **Configuration Management**: Externalized properties file
- **Driver Management**: WebDriverManager
- **Reporting**: TestNG HTML Reports

### Supported Browsers
- Chrome (default)
- Firefox
- Safari

---

## Architecture & Design Patterns

### 1. Page Object Model (POM)

**Purpose**: Separate page-specific logic from test logic

**Benefits**:
- Improved code maintainability
- Reduced code duplication
- Better test readability
- Easy element locator updates
- Centralized page interactions

**Structure**:
```java
public class JobPostingPage {
    // Locators
    @FindBy(xpath = "//h1")
    private WebElement jobTitle;
    
    // Methods
    public String getJobTitle() {
        return jobTitle.getText();
    }
    
    public void clickApplyButton() {
        applyButton.click();
    }
}
```

### 2. Base Test Class

**Purpose**: Provide common setup, teardown, and utilities for all tests

**Features**:
- WebDriver initialization
- WebDriver cleanup
- Navigation methods
- Screenshot on failure
- Logging

### 3. Utility Classes

**ConfigManager**: Handles configuration properties
**WebDriverFactory**: Creates and manages WebDriver instances
**WaitUtil**: Provides wait mechanisms
**ScreenshotUtil**: Captures screenshots
**ActionUtil**: Common actions like scroll, click, etc.

---

## Project Structure

```
CanadaITClubAutomation/
│
├── src/main/java/com/canadaitclub/
│   └── utils/
│       ├── ConfigManager.java          # Configuration management
│       ├── WebDriverFactory.java       # WebDriver initialization
│       ├── WaitUtil.java               # Wait utilities
│       ├── ScreenshotUtil.java         # Screenshot capture
│       └── ActionUtil.java             # Common actions
│
├── src/main/resources/
│   ├── config.properties               # Configuration file
│   └── log4j2.xml                      # Logging configuration
│
├── src/test/java/com/canadaitclub/
│   ├── base/
│   │   └── BaseTest.java               # Base test class
│   ├── pages/
│   │   └── JobPostingPage.java         # Page object
│   └── tests/
│       ├── PageLoadAndNavigationTests.java
│       ├── JobHeaderTests.java
│       ├── ApplyNowButtonTests.java
│       ├── JobDescriptionTests.java
│       ├── RelatedJobsAndShareTests.java
│       ├── JobOverviewAndEmployerTests.java
│       └── ResponsiveAndCrossBrowserTests.java
│
├── pom.xml                              # Maven configuration
├── testng.xml                           # TestNG suite configuration
└── README.md                            # Project readme
```

---

## Component Details

### 1. ConfigManager.java

**Responsibility**: Read and provide configuration properties

**Key Methods**:
```java
// Get string property
String value = ConfigManager.getProperty("BASE_URL");

// Get with default value
String value = ConfigManager.getProperty("BROWSER", "chrome");

// Get integer property
int timeout = ConfigManager.getIntProperty("IMPLICIT_WAIT", 10);

// Get boolean property
boolean flag = ConfigManager.getBooleanProperty("HEADLESS", false);
```

**Configuration File** (`config.properties`):
```properties
BASE_URL=https://canadaitclub.ca
JOB_POSTING_URL=https://canadaitclub.ca/job/test-lead-5/
BROWSER=chrome
HEADLESS=false
IMPLICIT_WAIT=10
EXPLICIT_WAIT=15
TAKE_SCREENSHOT_ON_FAILURE=true
```

### 2. WebDriverFactory.java

**Responsibility**: Initialize and manage WebDriver instances

**Key Methods**:
```java
// Initialize driver
WebDriver driver = WebDriverFactory.initializeDriver();

// Quit driver
WebDriverFactory.quitDriver(driver);
```

**Supported Browsers**:
- Chrome
- Firefox
- Safari

**Capabilities**:
- Headless mode
- Window management
- Implicit/Explicit waits
- DisableNotifications
- User agent customization

### 3. WaitUtil.java

**Responsibility**: Provide wait strategies for element visibility and interaction

**Key Methods**:
```java
// Wait for element to be present
WebElement element = WaitUtil.waitForElementPresent(driver, locator);

// Wait for element to be visible
WebElement element = WaitUtil.waitForElementVisible(driver, locator);

// Wait for element to be clickable
WebElement element = WaitUtil.waitForElementClickable(driver, locator);

// Wait for URL to change
boolean result = WaitUtil.waitForUrlContains(driver, "test-lead");

// Check if element exists without explicit wait
boolean exists = WaitUtil.isElementPresent(driver, locator);
```

**Wait Types**:
- Implicit Wait: Default for all elements (IMPLICIT_WAIT)
- Explicit Wait: For specific conditions (EXPLICIT_WAIT)
- Page Load Wait: For page load timeout (PAGE_LOAD_WAIT)

### 4. ScreenshotUtil.java

**Responsibility**: Capture screenshots for debugging and reporting

**Key Methods**:
```java
// Take screenshot
String filepath = ScreenshotUtil.takeScreenshot(driver, "TestName");

// Take failure screenshot
String filepath = ScreenshotUtil.takeFailureScreenshot(driver, "TestName");

// Take success screenshot
String filepath = ScreenshotUtil.takeSuccessScreenshot(driver, "TestName");
```

**Screenshot Location**: `test-output/screenshots/`

### 5. ActionUtil.java

**Responsibility**: Provide common web actions

**Key Methods**:
```java
// JavaScript click
ActionUtil.jsClick(driver, element);

// Scroll to element
ActionUtil.scrollToElement(driver, element);

// Scroll to top/bottom
ActionUtil.scrollToTop(driver);
ActionUtil.scrollToBottom(driver);

// Click on element
ActionUtil.clickElement(driver, locator);

// Enter text
ActionUtil.enterText(driver, locator, "text");

// Get page URL/title
String url = ActionUtil.getCurrentPageUrl(driver);
String title = ActionUtil.getCurrentPageTitle(driver);

// Navigate
ActionUtil.navigateToUrl(driver, "https://example.com");
ActionUtil.refreshPage(driver);
ActionUtil.goBack(driver);
```

### 6. BaseTest.java

**Responsibility**: Provide base setup and teardown for all tests

**Features**:
```java
// Setup (runs before each test)
@BeforeMethod
public void setUp() {
    driver = WebDriverFactory.initializeDriver();
}

// Teardown (runs after each test)
@AfterMethod
public void tearDown(ITestResult result) {
    if (result.getStatus() == ITestResult.FAILURE) {
        ScreenshotUtil.takeFailureScreenshot(driver, result.getName());
    }
    WebDriverFactory.quitDriver(driver);
}
```

### 7. JobPostingPage.java

**Responsibility**: Encapsulate all page elements and interactions for the job posting page

**Locators** (Using @FindBy annotation):
- Navigation elements
- Header elements (title, logo, location)
- Job description elements
- Responsibilities and tools sections
- Related jobs elements
- Footer elements

**Methods**:
- `isJobTitleDisplayed()` - Verify element visibility
- `getJobTitle()` - Get element text
- `clickApplyNowButton()` - Interact with elements
- `scrollToResponsibilities()` - Scroll operations
- `getResponsibilityItemsCount()` - Get list counts

---

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6.0 or higher
- Git (optional)

### Installation Steps

1. **Extract Project**
   ```bash
   cd /path/to/CanadaITClubAutomation
   ```

2. **Install Dependencies**
   ```bash
   mvn clean install
   ```

3. **Verify Installation**
   ```bash
   mvn -v
   mvn test -Dtest=PageLoadAndNavigationTests#testPageLoadsSuccessfully
   ```

### First Test Run

1. **Update config.properties** (if needed)
   ```bash
   vi src/main/resources/config.properties
   ```

2. **Run all tests**
   ```bash
   mvn test
   ```

3. **View results**
   ```bash
   open target/surefire-reports/index.html
   ```

---

## Writing Tests

### Test Class Structure

```java
package com.canadaitclub.tests;

import com.canadaitclub.base.BaseTest;
import com.canadaitclub.pages.JobPostingPage;
import com.canadaitclub.utils.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YourTestClass extends BaseTest {
    private JobPostingPage jobPostingPage;

    @BeforeMethod(alwaysRun = true)
    public void pageLoadSetUp() {
        // Initialize page object
        jobPostingPage = new JobPostingPage(driver);
        
        // Navigate to page
        String jobPostingUrl = ConfigManager.getProperty("JOB_POSTING_URL");
        navigateTo(jobPostingUrl);
    }

    @Test(description = "Test description")
    public void testCase1() {
        logger.info("Test: Test Case 1");
        
        // Verify something
        Assert.assertTrue(jobPostingPage.isJobTitleDisplayed(),
            "Job title should be displayed");
        
        // Interact with page
        jobPostingPage.clickApplyNowButton();
        
        // Verify result
        String currentUrl = getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("linkedin"),
            "Should navigate to LinkedIn");
        
        logger.info("Test PASSED");
    }
}
```

### Test Annotation Examples

```java
// Basic test
@Test
public void testName() { }

// Test with description
@Test(description = "Clear description of what is being tested")
public void testName() { }

// Test with priority
@Test(priority = 1)
public void testName() { }

// Test with groups
@Test(groups = {"smoke", "regression"})
public void testName() { }

// Test that can fail
@Test(expectedExceptions = NoSuchElementException.class)
public void testName() { }
```

### Assertion Examples

```java
// Assert true/false
Assert.assertTrue(condition, "message");
Assert.assertFalse(condition, "message");

// Assert equality
Assert.assertEquals(actual, expected, "message");
Assert.assertNotEquals(actual, expected, "message");

// Assert null/not null
Assert.assertNull(object, "message");
Assert.assertNotNull(object, "message");

// Soft assert (doesn't stop test on failure)
SoftAssert softAssert = new SoftAssert();
softAssert.assertTrue(condition, "message");
softAssert.assertAll();
```

---

## Best Practices

### 1. **Page Object Naming**
```java
// Good
public boolean isJobTitleDisplayed() { }
public void clickApplyNowButton() { }
public String getJobTitle() { }

// Bad
public void test1() { }
public void doSomething() { }
```

### 2. **Logging**
```java
// Always log test start and end
logger.info("Test: Test Name");
// ... test code ...
logger.info("Test PASSED/FAILED");

// Log important steps
logger.info("Clicking Apply Now button");
logger.info("Navigated to: " + getCurrentUrl());

// Log errors
logger.error("Failed to find element", exception);
```

### 3. **Wait Strategies**
```java
// Use explicit waits for reliability
WaitUtil.waitForElementClickable(driver, By.id("button")).click();

// Don't use Thread.sleep() unless necessary
Thread.sleep(1000); // Only for animations, etc.

// Use isElementPresent() for optional elements
if (WaitUtil.isElementPresent(driver, By.id("optional"))) {
    // interact with element
}
```

### 4. **Configuration Usage**
```java
// Don't hardcode values
// Bad
driver.navigate().to("https://canadaitclub.ca/job/test-lead-5/");

// Good
String url = ConfigManager.getProperty("JOB_POSTING_URL");
navigateTo(url);
```

### 5. **Exception Handling**
```java
try {
    // Risky operation
} catch (NoSuchElementException e) {
    logger.error("Element not found", e);
    Assert.fail("Required element was not found");
} catch (TimeoutException e) {
    logger.error("Timeout waiting for element", e);
    ScreenshotUtil.takeFailureScreenshot(driver, "timeout");
}
```

### 6. **Test Independence**
```java
// Each test should be independent
@BeforeMethod
public void setUp() {
    // Initialize fresh state
    driver = WebDriverFactory.initializeDriver();
    jobPostingPage = new JobPostingPage(driver);
    navigateTo(ConfigManager.getProperty("JOB_POSTING_URL"));
}

// Don't depend on other tests
// Bad
if (previousTestPassed) { // Don't do this
    // ...
}
```

---

## Common Issues & Solutions

### Issue 1: WebDriver not found
**Error**: `WebDriver executable does not exist`

**Solution**:
```bash
mvn clean install -DskipTests
mvn test
```

### Issue 2: Element not found
**Error**: `NoSuchElementException`

**Solution**:
1. Verify element locator in JobPostingPage
2. Check if UI has changed
3. Add explicit wait:
   ```java
   WaitUtil.waitForElementVisible(driver, By.id("element"));
   ```

### Issue 3: Timeout exceptions
**Error**: `TimeoutException`

**Solution**:
1. Increase EXPLICIT_WAIT in config.properties
2. Check network connectivity
3. Verify element conditions with wait

### Issue 4: Tests pass locally but fail in CI/CD
**Cause**: Environment differences

**Solution**:
1. Use headless mode: `HEADLESS=true`
2. Update BASE_URL for different environments
3. Add more explicit waits
4. Use ActionUtil.wait() for dynamic content

### Issue 5: Flaky tests
**Cause**: Race conditions, timing issues

**Solution**:
1. Use explicit waits instead of Thread.sleep()
2. Ensure elements are clickable before clicking
3. Wait for URL changes
4. Use ActionUtil.wait() for animations

---

## Configuration Guide

### config.properties

```properties
# ============================================
# Application URLs
# ============================================
BASE_URL=https://canadaitclub.ca
JOB_POSTING_URL=https://canadaitclub.ca/job/test-lead-5/
HOME_URL=https://canadaitclub.ca/
ABOUT_US_URL=https://canadaitclub.ca/about-us/
BROWSE_JOBS_URL=https://canadaitclub.ca/browse-jobs/
COMPANY_PROFILE_URL=https://canadaitclub.ca/employer/canada-it-club/

# ============================================
# Browser Configuration
# ============================================
BROWSER=chrome                    # chrome, firefox, safari
HEADLESS=false                   # true for headless mode
WINDOW_SIZE=1920,1080            # Browser window size

# ============================================
# Wait Configuration (in seconds)
# ============================================
IMPLICIT_WAIT=10                 # Default wait for all elements
EXPLICIT_WAIT=15                 # Wait for specific conditions
PAGE_LOAD_WAIT=30                # Page load timeout

# ============================================
# Screenshot Configuration
# ============================================
TAKE_SCREENSHOT_ON_FAILURE=true  # Auto screenshot on failure
SCREENSHOT_PATH=test-output/screenshots/

# ============================================
# Log Configuration
# ============================================
LOG_PATH=test-output/logs/
LOG_LEVEL=INFO                   # DEBUG, INFO, WARN, ERROR

# ============================================
# Report Configuration
# ============================================
REPORT_PATH=test-output/reports/
REPORT_TITLE=Canada IT Club Job Posting Automation Report

# ============================================
# Retry Configuration
# ============================================
RETRY_COUNT=2                    # Retry failed tests
RETRY_WAIT=1000                  # Wait between retries (ms)

# ============================================
# Parallel Execution
# ============================================
PARALLEL_EXECUTION=false         # Enable parallel test execution
THREAD_COUNT=3                   # Number of parallel threads

# ============================================
# Operating System
# ============================================
OS=mac                           # mac, windows, linux
```

### Environment-Specific Configuration

For different environments, create multiple property files:

```
config.properties          # Default (development)
config-qa.properties       # QA environment
config-staging.properties  # Staging environment
config-prod.properties     # Production environment
```

**Usage**:
```bash
mvn test -Dconfig=qa
```

---

## Maintenance & Updates

### When UI Changes
1. Update locators in JobPostingPage.java
2. Update corresponding methods
3. Run affected tests to verify

### When Adding New Tests
1. Create new test class extending BaseTest
2. Use existing page object methods
3. Follow naming conventions
4. Add proper logging and assertions

### When Updating Page Object
1. Update @FindBy locators if UI changed
2. Add new methods for new elements
3. Update Javadoc comments
4. Run all tests to verify changes

### Version Control
```bash
# Good commit messages
git commit -m "Add tests for job header section"
git commit -m "Update job posting page locators"
git commit -m "Fix flaky navigation test"
```

### Documentation
- Keep README.md updated
- Add comments to complex methods
- Document new utilities or configurations
- Update this guide for significant changes

---

## Continuous Integration (CI/CD)

### GitHub Actions Example
```yaml
name: Automation Tests

on: [push, pull_request]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - name: Set up Java
        uses: actions/setup-java@v2
        with:
          java-version: '11'
      - name: Run tests
        run: mvn clean test -Dconfig=qa -DHEADLESS=true
      - name: Upload results
        uses: actions/upload-artifact@v2
        if: always()
        with:
          name: test-reports
          path: target/surefire-reports/
```

---

## Summary

This framework provides a solid foundation for test automation with:
- ✅ Page Object Model pattern for maintainability
- ✅ Externalized configuration for flexibility
- ✅ Comprehensive utility classes for reusability
- ✅ Proper logging and reporting
- ✅ Cross-browser support
- ✅ Easy to extend and maintain

**Happy Testing! 🚀**

---

**Document Version**: 1.0  
**Last Updated**: December 18, 2025  
**Author**: QA Automation Team  
**Project**: Canada IT Club Job Posting Portal
