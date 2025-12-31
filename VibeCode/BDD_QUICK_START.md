# BDD Test Cases - Quick Start Guide

## Overview
This guide provides step-by-step instructions to set up and run BDD (Behavior-Driven Development) tests for the Canada IT Club job posting page.

## What's Included

| File | Purpose |
|------|---------|
| `test_cases_canadaitclub.feature` | Gherkin feature file with 67 test scenarios |
| `JobPostingPageSteps.java` | Step definitions implementing Gherkin steps |
| `CucumberTestRunner.java` | Test runner to execute Cucumber tests |
| `pom_bdd.xml` | Maven configuration for BDD dependencies |
| `BDD_TEST_CASES_GUIDE.md` | Detailed BDD documentation |

## Prerequisites

1. **Java 11+** installed
   ```bash
   java -version
   ```

2. **Maven 3.6.0+** installed
   ```bash
   mvn -version
   ```

3. **Git** (optional, for version control)

4. **Chrome/Firefox/Safari** browser installed

## Project Setup

### Step 1: Directory Structure
Create the following project structure:
```
CanadaITClubBDD/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/canadaitclub/utils/
│   └── test/
│       ├── java/
│       │   ├── com/canadaitclub/runners/
│       │   │   └── CucumberTestRunner.java
│       │   └── com/canadaitclub/stepdefinitions/
│       │       └── JobPostingPageSteps.java
│       └── resources/
│           ├── features/
│           │   └── job_posting.feature
│           └── config/
│               └── config.properties
├── pom.xml
└── README.md
```

### Step 2: Copy Files
1. Place `test_cases_canadaitclub.feature` in `src/test/resources/features/`
2. Place `JobPostingPageSteps.java` in `src/test/java/com/canadaitclub/stepdefinitions/`
3. Place `CucumberTestRunner.java` in `src/test/java/com/canadaitclub/runners/`
4. Use `pom_bdd.xml` as reference for dependencies

### Step 3: Update pom.xml
Add Cucumber and Selenium dependencies to your `pom.xml`:

```xml
<dependencies>
    <!-- Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.15.0</version>
    </dependency>

    <!-- Cucumber Java -->
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.14.0</version>
    </dependency>

    <!-- Cucumber JUnit -->
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-junit</artifactId>
        <version>7.14.0</version>
        <scope>test</scope>
    </dependency>

    <!-- JUnit -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>

    <!-- WebDriverManager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.6.3</version>
    </dependency>
</dependencies>
```

## Running BDD Tests

### 1. Run All Tests
```bash
mvn test -Dtest=CucumberTestRunner
```

### 2. Run Specific Feature
```bash
mvn test -Dtest=CucumberTestRunner -Dcucumber.filter.name="Verify page loads"
```

### 3. Run by Tag - Smoke Tests Only
```bash
mvn test -Dtest=CucumberTestRunner -Dcucumber.filter.tags="@Smoke"
```

### 4. Run by Tag - Navigation Tests
```bash
mvn test -Dtest=CucumberTestRunner -Dcucumber.filter.tags="@Navigation"
```

### 5. Run Multiple Tags
```bash
mvn test -Dtest=CucumberTestRunner -Dcucumber.filter.tags="@Smoke or @Navigation"
```

### 6. Run All Except Edge Cases
```bash
mvn test -Dtest=CucumberTestRunner -Dcucumber.filter.tags="not @EdgeCase"
```

### 7. Run with Dry Run (No Execution)
```bash
mvn test -Dtest=CucumberTestRunner -Dcucumber.dryRun=true
```

## Test Execution Examples

### Example 1: Run Smoke Tests (Critical Tests)
```bash
mvn clean test -Dtest=CucumberTestRunner -Dcucumber.filter.tags="@Smoke"
```
**Expected Output**: 3 scenarios executed (Page Load, Navigation, Apply Button)

### Example 2: Run All Accessibility Tests
```bash
mvn clean test -Dtest=CucumberTestRunner -Dcucumber.filter.tags="@Accessibility"
```
**Expected Output**: 5 scenarios executed

### Example 3: Run Security & Performance Tests
```bash
mvn clean test -Dtest=CucumberTestRunner -Dcucumber.filter.tags="@Security or @Performance"
```
**Expected Output**: 8 scenarios executed

### Example 4: Full Test Suite
```bash
mvn clean test -Dtest=CucumberTestRunner
```
**Expected Output**: All 67 scenarios executed

## Test Reports

After running tests, reports are generated in:

### HTML Report
```
target/cucumber-reports/cucumber.html
```
Open in browser:
```bash
open target/cucumber-reports/cucumber.html  # macOS
start target/cucumber-reports/cucumber.html  # Windows
```

### JSON Report
```
target/cucumber-reports/cucumber.json
```

### JUnit XML Report
```
target/cucumber-reports/cucumber.xml
```

## Available Tags

| Tag | Description | Scenarios |
|-----|-------------|-----------|
| @Smoke | Critical smoke tests | 3 |
| @PageLoad | Page load tests | 1 |
| @Navigation | Navigation tests | 2 |
| @Header | Header section tests | 3 |
| @CTA | Call-to-action tests | 3 |
| @Description | Description section tests | 9 |
| @Related | Related jobs tests | 3 |
| @Share | Share functionality tests | 3 |
| @Carousel | Carousel tests | 2 |
| @Overview | Overview section tests | 5 |
| @Employer | Employer information tests | 3 |
| @Footer | Footer section tests | 6 |
| @Responsive | Responsive design tests | 3 |
| @CrossBrowser | Cross-browser tests | 3 |
| @Performance | Performance tests | 1 |
| @Accessibility | Accessibility tests | 5 |
| @Content | Content accuracy tests | 5 |
| @ErrorHandling | Error handling tests | 2 |
| @Security | Security tests | 3 |
| @EdgeCase | Edge case tests | 4 |
| @SEO | SEO tests | 3 |

## Customizing Tests

### 1. Change Base URL
Edit `JobPostingPageSteps.java`:
```java
private static final String BASE_URL = "https://your-site.com/job/your-job/";
```

### 2. Change Timeout
Edit `JobPostingPageSteps.java`:
```java
private static final int TIMEOUT_SECONDS = 15;  // Default is 10
```

### 3. Change Browser
Edit `setUp()` method in `JobPostingPageSteps.java`:
```java
// For Firefox
driver = new FirefoxDriver();

// For Safari
driver = new SafariDriver();
```

### 4. Add New Scenarios
1. Add scenario to `test_cases_canadaitclub.feature`
2. Implement step definitions in `JobPostingPageSteps.java`
3. Run tests with new scenario

## Troubleshooting

### Issue: "No feature files found"
**Solution**: Ensure feature file is in `src/test/resources/features/` directory

### Issue: "Step not found"
**Solution**: 
- Check step definition method matches Gherkin step exactly
- Verify glue path in `CucumberTestRunner.java` is correct

### Issue: WebDriver errors
**Solution**:
- Install WebDriverManager dependency
- Ensure browser is installed
- Check browser version compatibility

### Issue: Tests fail with timeout
**Solution**:
- Increase `TIMEOUT_SECONDS` in `JobPostingPageSteps.java`
- Check internet connectivity
- Verify website is accessible

### Issue: "Chrome driver not found"
**Solution**:
```bash
# Add WebDriverManager dependency - it auto-downloads drivers
<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.6.3</version>
</dependency>
```

## Best Practices

1. **Run Smoke Tests First**: Verify basic functionality
   ```bash
   mvn test -Dtest=CucumberTestRunner -Dcucumber.filter.tags="@Smoke"
   ```

2. **Use Tags for Organization**: Group related tests
   - `@Navigation` for navigation tests
   - `@Security` for security tests
   - etc.

3. **Maintain Step Definitions**: Keep step definitions simple and reusable

4. **Update Feature Files**: Keep feature files in sync with actual functionality

5. **Run Full Suite Before Deployment**: Ensure all tests pass
   ```bash
   mvn clean test -Dtest=CucumberTestRunner
   ```

## Continuous Integration

### Jenkins Pipeline
```groovy
pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                sh 'mvn clean test -Dtest=CucumberTestRunner'
            }
        }
        stage('Report') {
            steps {
                publishHTML([
                    reportDir: 'target/cucumber-reports',
                    reportFiles: 'cucumber.html',
                    reportName: 'Cucumber Report'
                ])
            }
        }
    }
}
```

### GitHub Actions
```yaml
name: BDD Tests
on: [push, pull_request]
jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - uses: actions/setup-java@v2
        with:
          java-version: '11'
      - run: mvn clean test -Dtest=CucumberTestRunner
      - uses: actions/upload-artifact@v2
        if: always()
        with:
          name: cucumber-reports
          path: target/cucumber-reports/
```

## Key Files Summary

### test_cases_canadaitclub.feature (67 scenarios)
- 17 test suites
- Given-When-Then format
- Organized by feature area
- Includes tags for filtering

### JobPostingPageSteps.java (120+ step definitions)
- Implements all Gherkin steps
- WebDriver initialization
- Element locators
- Assertion methods

### CucumberTestRunner.java
- Configures Cucumber execution
- Sets up report generation
- Defines glue path
- Configures tags and features

## Support & Resources

- **Cucumber Documentation**: https://cucumber.io/docs/
- **Gherkin Reference**: https://cucumber.io/docs/gherkin/reference/
- **Selenium WebDriver**: https://www.selenium.dev/
- **BDD Best Practices**: https://cucumber.io/docs/bdd/

## Next Steps

1. ✅ Set up project structure
2. ✅ Add dependencies to pom.xml
3. ✅ Copy feature files
4. ✅ Copy step definitions
5. ✅ Run smoke tests
6. ✅ Verify reports generation
7. ✅ Run full test suite
8. ✅ Integrate with CI/CD

## Summary

- **Total Scenarios**: 67
- **Test Suites**: 17
- **Tags**: 20+
- **Step Definitions**: 120+
- **Coverage**: 100% of manual test cases

---

**Last Updated**: December 2025  
**Version**: 1.0  
**Framework**: Cucumber 7.14.0 + Selenium 4.15.0
