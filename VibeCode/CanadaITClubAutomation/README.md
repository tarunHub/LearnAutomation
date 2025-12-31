# Canada IT Club Job Posting Automation Framework

## Overview
This is a comprehensive Selenium Java automation framework built using the **Page Object Model (POM)** design pattern to test the Canada IT Club job posting page. The framework is designed for maintainability, reusability, and scalability.

**Project URL:** https://canadaitclub.ca/job/test-lead-5/

## Framework Architecture

### Project Structure
```
CanadaITClubAutomation/
├── src/
│   ├── main/
│   │   ├── java/com/canadaitclub/
│   │   │   └── utils/
│   │   │       ├── ConfigManager.java
│   │   │       ├── WebDriverFactory.java
│   │   │       ├── ScreenshotUtil.java
│   │   │       └── WaitUtil.java
│   │   └── resources/
│   │       ├── config.properties
│   │       └── log4j2.xml
│   └── test/
│       ├── java/com/canadaitclub/
│       │   ├── base/
│       │   │   └── BaseTest.java
│       │   ├── pages/
│       │   │   └── JobPostingPage.java
│       │   └── tests/
│       │       ├── PageLoadAndNavigationTests.java
│       │       ├── JobHeaderTests.java
│       │       ├── ApplyNowButtonTests.java
│       │       ├── JobDescriptionTests.java
│       │       ├── RelatedJobsAndShareTests.java
│       │       ├── JobOverviewAndEmployerTests.java
│       │       └── ResponsiveAndCrossBrowserTests.java
│       └── resources/
├── pom.xml
└── testng.xml
```

## Key Features

### 1. **Page Object Model (POM)**
- Centralized location for all page elements and actions
- Easy maintenance and updates
- Reduced code duplication
- Better test readability

### 2. **Configuration Management**
- Externalized configuration via `config.properties`
- Easy switching between environments
- Configurable browser, timeouts, and URLs

### 3. **WebDriver Management**
- Automatic WebDriver initialization
- Support for Chrome, Firefox, and Safari
- Headless mode support
- Implicit and explicit waits

### 4. **Utility Classes**
- **ConfigManager**: Handles configuration file reading
- **WebDriverFactory**: Manages WebDriver initialization
- **WaitUtil**: Provides wait mechanisms
- **ScreenshotUtil**: Captures screenshots on test failure

### 5. **Logging**
- Integrated Log4j2 logging
- Detailed console and file logs
- Rolling file appenders for better log management

### 6. **Base Test Class**
- Common setup/teardown for all tests
- Automatic screenshot on failure
- WebDriver cleanup

### 7. **Comprehensive Test Coverage**
- 7 test suites with 30+ test cases
- Page load and navigation testing
- UI element visibility and functionality
- Cross-browser compatibility
- Responsive design testing

## Configuration

### config.properties
Key configurations:
```properties
BASE_URL=https://canadaitclub.ca
JOB_POSTING_URL=https://canadaitclub.ca/job/test-lead-5/
BROWSER=chrome              # Options: chrome, firefox, safari
HEADLESS=false             # Headless mode
IMPLICIT_WAIT=10          # Implicit wait in seconds
EXPLICIT_WAIT=15          # Explicit wait in seconds
PAGE_LOAD_WAIT=30         # Page load wait in seconds
TAKE_SCREENSHOT_ON_FAILURE=true
```

## Installation & Setup

### Prerequisites
- Java 11 or higher
- Maven 3.6.0 or higher
- Git

### Steps

1. **Clone or Download Project**
   ```bash
   cd /path/to/CanadaITClubAutomation
   ```

2. **Install Dependencies**
   ```bash
   mvn clean install
   ```

3. **Update Configuration** (if needed)
   - Edit `src/main/resources/config.properties`
   - Update browser, URLs, and timeouts as needed

## Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Test Suite
```bash
mvn test -Dtest=PageLoadAndNavigationTests
```

### Run TestNG Suite
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Run with Specific Browser
```bash
# Update config.properties BROWSER property, then:
mvn clean test
```

### Run in Headless Mode
```bash
# Update config.properties:
# HEADLESS=true
# Then run tests
mvn test
```

## Test Suites Overview

### 1. Page Load and Navigation Tests (TC-001 to TC-003)
- Verify page loads successfully
- Navigation menu visibility and functionality
- Navigation links routing

### 2. Job Header Section Tests (TC-004 to TC-006)
- Job title and metadata display
- Company logo and profile link
- Job type badge display

### 3. Apply Now Button Tests (TC-007 to TC-009)
- Apply Now button visibility and functionality
- Button navigation
- Bookmark functionality

### 4. Job Description Tests (TC-010 to TC-016)
- Job description structure
- Key details display
- Responsibilities section
- Tools & Technologies section
- Location information
- Experience requirements

### 5. Related Jobs & Share Tests (TC-019 to TC-024)
- Related jobs section
- Share buttons (Twitter, LinkedIn)
- Job card display

### 6. Job Overview & Employer Tests (TC-027 to TC-033)
- Job overview sidebar
- Date posted, expiration date, work type
- Employer information section
- Company profile link

### 7. Responsive & Cross-Browser Tests (TC-041 to TC-064)
- Mobile responsiveness
- Tablet responsiveness
- Chrome compatibility
- Page title accuracy

## Test Reports

### HTML Report
After test execution, view the report at:
```
target/surefire-reports/
```

### Log Files
Log files are generated at:
```
test-output/logs/automation.log
```

### Screenshots
Failure screenshots are saved at:
```
test-output/screenshots/
```

## Page Object Model Details

### JobPostingPage Class
Provides:
- Locators for all page elements
- Methods to interact with elements
- Verification methods for assertions
- Scroll methods for different sections
- Reusable methods for common actions

### Common Methods
```java
// Navigation
jobPostingPage.clickHomeLink();
jobPostingPage.clickAboutUsLink();

// Verification
jobPostingPage.isJobTitleDisplayed();
jobPostingPage.isApplyNowButtonDisplayed();

// Data Retrieval
String jobTitle = jobPostingPage.getJobTitle();
String location = jobPostingPage.getJobLocation();

// Interaction
jobPostingPage.clickApplyNowButton();
jobPostingPage.scrollToResponsibilities();
```

## Utility Classes

### ConfigManager
```java
String baseUrl = ConfigManager.getProperty("BASE_URL");
int waitTime = ConfigManager.getIntProperty("EXPLICIT_WAIT", 15);
boolean takeScreenshot = ConfigManager.getBooleanProperty("TAKE_SCREENSHOT_ON_FAILURE", true);
```

### WaitUtil
```java
WaitUtil.waitForElementVisible(driver, By.id("element"));
WaitUtil.waitForElementClickable(driver, By.xpath("//button"));
WaitUtil.waitForUrlContains(driver, "test-lead");
boolean isPresent = WaitUtil.isElementPresent(driver, By.id("element"));
```

### ScreenshotUtil
```java
String filepath = ScreenshotUtil.takeScreenshot(driver, "TC-001");
ScreenshotUtil.takeFailureScreenshot(driver, testName);
ScreenshotUtil.takeSuccessScreenshot(driver, testName);
```

## Best Practices

1. **Use Page Object Model**: All page interactions should go through page objects
2. **Explicit Waits**: Use WaitUtil for reliable element waits
3. **Logging**: Add logger statements for debugging
4. **Configuration**: Use config.properties for environment-specific settings
5. **Base Class**: Inherit from BaseTest for setup/teardown
6. **Error Handling**: Catch exceptions and log appropriately
7. **Assertions**: Use TestNG assertions for test validations

## Troubleshooting

### Issue: WebDriver not found
**Solution**: Run `mvn clean install` to download WebDriver binaries

### Issue: Element not found
**Solution**: Check locators in JobPostingPage.java and update if UI changed

### Issue: Timeout exceptions
**Solution**: Increase EXPLICIT_WAIT or IMPLICIT_WAIT in config.properties

### Issue: Screenshot not captured
**Solution**: Verify TAKE_SCREENSHOT_ON_FAILURE is true and SCREENSHOT_PATH exists

## Dependencies

- **Selenium WebDriver 4.15.0**: Web automation
- **WebDriverManager 5.6.3**: Automatic driver management
- **TestNG 7.8.1**: Test framework
- **Log4j2 2.20.0**: Logging framework
- **ExtentReports 5.0.9**: Test reporting
- **Apache Commons IO 2.11.0**: Utility library

## Future Enhancements

1. Add API testing for backend validation
2. Implement data-driven testing with TestNG DataProvider
3. Add performance testing
4. Integrate with CI/CD pipeline (Jenkins, GitHub Actions)
5. Add Extent Reports integration for advanced reporting
6. Implement retry logic for flaky tests
7. Add database validation tests
8. Create custom annotations for test categorization

## Contributing

1. Follow the existing code structure
2. Add meaningful comments and documentation
3. Update test cases when UI changes
4. Create separate test classes for new features
5. Ensure all tests pass before committing

## Contact & Support

For questions or issues:
- Email: test@canadaitclub.ca
- GitHub Issues: (if applicable)

## Version History

- **1.0.0** (Dec 18, 2025): Initial framework setup with 7 test suites

## License

This project is proprietary and intended for Canada IT Club testing purposes.

---

**Happy Testing! 🚀**
