# BDD Test Cases Conversion - Canada IT Club Job Posting

## Overview
This document provides a comprehensive conversion of 67 manual test cases from the `test_cases_canadaitclub.md` file into BDD (Behavior-Driven Development) format using Gherkin syntax.

## What is BDD?
Behavior-Driven Development (BDD) is a testing methodology that uses natural language descriptions to define test scenarios. It bridges the gap between business requirements and technical implementation.

## Gherkin Syntax
Gherkin is the language used to write BDD scenarios. It uses simple keywords:

- **Feature**: Describes what functionality is being tested
- **Scenario**: Describes a specific test case
- **Given**: The initial state/precondition
- **When**: The action being performed
- **Then**: The expected outcome

### Example:
```gherkin
Scenario: User applies for a job
  Given I am on the job posting page
  When I click the Apply Now button
  Then I should be redirected to the application page
```

## File Structure

### 1. Feature File: `test_cases_canadaitclub.feature`
- **Format**: Gherkin
- **Location**: `src/test/resources/features/`
- **Total Scenarios**: 67 (aligned with original manual test cases)
- **Organization**: 17 test suites matching the original documentation

### 2. Step Definitions: `JobPostingPageSteps.java`
- **Format**: Java with Cucumber annotations
- **Location**: `src/test/java/com/canadaitclub/stepdefinitions/`
- **Purpose**: Implements the logic for each Gherkin step

### 3. Test Runner: `CucumberTestRunner.java`
- **Format**: Java with JUnit annotations
- **Purpose**: Executes Cucumber tests and generates reports

## Test Suite Breakdown

### Suite 1: Page Load and Navigation (3 scenarios)
- Page loads successfully
- Navigation menu is visible
- Navigation links work correctly

### Suite 2: Job Header Section (6 scenarios)
- Job title and metadata display
- Logo and company link visibility
- Job type badge display

### Suite 3: Apply Now Button (3 scenarios)
- Button visibility and clickability
- Navigation functionality
- Bookmark functionality

### Suite 4: Job Description (9 scenarios)
- Description structure
- Key details display
- Location information
- Experience requirements
- Responsibilities section
- Tools and technologies
- Candidate profile
- Contact email

### Suite 5: Related Jobs (3 scenarios)
- Section heading
- Job cards display
- Link functionality

### Suite 6: Share Section (3 scenarios)
- Share section display
- Twitter share button
- LinkedIn share button

### Suite 7: Related Jobs Carousel (2 scenarios)
- Carousel display
- Navigation functionality

### Suite 8: Job Overview Section (5 scenarios)
- Overview sidebar
- Date posted
- Location information
- Expiration date
- Work location type

### Suite 9: Employer Information (3 scenarios)
- Employer section display
- Company profile link
- Employer description

### Suite 10: Footer Section (6 scenarios)
- Helpful resources links
- Social media links
- Feedback section
- Copyright information

### Suite 11: Responsive Design (5 scenarios)
- Mobile responsiveness
- Tablet responsiveness
- Chrome compatibility
- Firefox compatibility
- Safari compatibility

### Suite 12: Performance & Accessibility (5 scenarios)
- Page load performance
- Text alternatives for images
- Heading hierarchy
- Color contrast
- Keyboard navigation

### Suite 13: Content Accuracy (5 scenarios)
- Email format validation
- External links functionality
- Date consistency
- Location consistency
- Job type consistency

### Suite 14: Error Handling (2 scenarios)
- 404 handling
- Network error handling

### Suite 15: Security (3 scenarios)
- Data exposure prevention
- HTTPS connection
- Form security

### Suite 16: Functional Edge Cases (4 scenarios)
- JavaScript disabled
- Page caching
- URL encoding
- Page title accuracy

### Suite 17: SEO & Metadata (3 scenarios)
- Meta description
- Open Graph tags
- Canonical tag

## Tags and Filtering

The feature file includes tags for running specific test subsets:

| Tag | Purpose |
|-----|---------|
| @CanadaITClub | All Canada IT Club tests |
| @Smoke | Critical smoke tests |
| @PageLoad | Page load tests |
| @Navigation | Navigation tests |
| @Links | Link functionality tests |
| @Header | Header section tests |
| @CTA | Call-to-action tests |
| @Description | Description section tests |
| @Related | Related jobs tests |
| @Share | Share functionality tests |
| @Carousel | Carousel tests |
| @Overview | Overview section tests |
| @Employer | Employer information tests |
| @Footer | Footer section tests |
| @Responsive | Responsive design tests |
| @CrossBrowser | Cross-browser tests |
| @Performance | Performance tests |
| @Accessibility | Accessibility tests |
| @Content | Content accuracy tests |
| @ErrorHandling | Error handling tests |
| @Security | Security tests |
| @EdgeCase | Edge case tests |
| @SEO | SEO tests |

## Running BDD Tests

### Run All Tests
```bash
mvn test -Dtest=CucumberTestRunner
```

### Run Specific Tag
```bash
mvn test -Dtest=CucumberTestRunner -Dcucumber.filter.tags="@Smoke"
```

### Run Multiple Tags
```bash
mvn test -Dtest=CucumberTestRunner -Dcucumber.filter.tags="@Smoke or @Navigation"
```

### Run Excluding Tags
```bash
mvn test -Dtest=CucumberTestRunner -Dcucumber.filter.tags="@CanadaITClub and not @EdgeCase"
```

### Generate HTML Reports
```bash
mvn cucumber:reportonly
```

## Test Reports

After running tests, reports are generated in:
- `target/cucumber-reports/cucumber.html` - HTML report
- `target/cucumber-reports/cucumber.json` - JSON report
- `target/cucumber-reports/cucumber.xml` - JUnit XML report

## Mapping: Manual Tests to BDD Scenarios

| TC ID | Manual Test | BDD Scenario | Feature File Line |
|-------|-------------|--------------|-------------------|
| TC-001 | Verify Page Loads Successfully | Verify page loads successfully | Line ~25 |
| TC-002 | Verify Navigation Menu is Visible | Verify navigation menu is visible | Line ~35 |
| TC-003 | Test Navigation Menu Links | Test navigation menu links | Line ~50 |
| TC-004 | Verify Job Title Display | Verify job title and key info | Line ~70 |
| TC-005 | Verify Logo and Link | Verify employer logo | Line ~85 |
| TC-006 | Verify Job Type Badge | Verify job type badge | Line ~105 |
| TC-007 | Verify Apply Button | Verify Apply Now button | Line ~125 |
| TC-008 | Apply Button Navigation | Verify Apply Now navigation | Line ~140 |
| TC-009 | Bookmark Functionality | Verify bookmark functionality | Line ~155 |
| TC-010 | Description Structure | Verify description structure | Line ~175 |
| TC-011 | Key Details Display | Verify key details display | Line ~190 |
| TC-012 | Description Main Text | Verify description main text | Line ~205 |
| TC-013 | Location Information | Verify location information | Line ~220 |
| TC-014 | Experience Requirements | Verify experience requirements | Line ~235 |
| TC-015 | Responsibilities Section | Verify responsibilities section | Line ~250 |
| TC-016 | Tools & Technologies | Verify tools and technologies | Line ~270 |
| TC-017 | Candidate Profile | Verify candidate profile | Line ~290 |
| TC-018 | Contact Email | Verify contact email | Line ~305 |
| TC-019 | Related Jobs Heading | Verify related jobs heading | Line ~325 |
| TC-020 | Related Job Cards | Verify related job cards | Line ~335 |
| TC-021 | Related Job Links | Test related job links | Line ~350 |
| TC-022 | Share Section | Verify share section | Line ~370 |
| TC-023 | Twitter Share | Test Twitter share button | Line ~385 |
| TC-024 | LinkedIn Share | Test LinkedIn share button | Line ~400 |
| TC-025 | Carousel Display | Verify carousel display | Line ~420 |
| TC-026 | Carousel Navigation | Verify carousel navigation | Line ~435 |
| TC-027 | Overview Sidebar | Verify overview sidebar | Line ~455 |
| TC-028 | Date Posted | Verify date posted | Line ~470 |
| TC-029 | Location in Overview | Verify location in overview | Line ~485 |
| TC-030 | Expiration Date | Verify expiration date | Line ~500 |
| TC-031 | Work Location Type | Verify work location type | Line ~515 |
| TC-032 | Employer Section | Verify employer section | Line ~535 |
| TC-033 | Company Profile Link | Test company profile link | Line ~550 |
| TC-034 | Employer Description | Verify employer description | Line ~565 |
| TC-035 | Resources Section | Verify resources section | Line ~585 |
| TC-036 | Resource Links | Test resource links | Line ~600 |
| TC-037 | Social Media Links | Verify social media links | Line ~620 |
| TC-038 | Social Media Links | Test social media links | Line ~635 |
| TC-039 | Feedback Section | Verify feedback section | Line ~655 |
| TC-040 | Copyright Info | Verify copyright info | Line ~670 |
| TC-041 | Mobile Responsive | Verify mobile responsive | Line ~690 |
| TC-042 | Tablet Responsive | Verify tablet responsive | Line ~705 |
| TC-043 | Chrome Compatibility | Test Chrome compatibility | Line ~720 |
| TC-044 | Firefox Compatibility | Test Firefox compatibility | Line ~735 |
| TC-045 | Safari Compatibility | Test Safari compatibility | Line ~750 |
| TC-046 | Performance | Verify performance | Line ~770 |
| TC-047 | Alt Text | Verify alt text | Line ~785 |
| TC-048 | Heading Hierarchy | Verify heading hierarchy | Line ~800 |
| TC-049 | Color Contrast | Verify color contrast | Line ~820 |
| TC-050 | Keyboard Navigation | Verify keyboard navigation | Line ~835 |
| TC-051 | Email Format | Verify email format | Line ~855 |
| TC-052 | External Links | Verify external links | Line ~870 |
| TC-053 | Date Consistency | Verify date consistency | Line ~885 |
| TC-054 | Location Consistency | Verify location consistency | Line ~900 |
| TC-055 | Job Type Consistency | Verify job type consistency | Line ~915 |
| TC-056 | 404 Handling | Verify 404 handling | Line ~935 |
| TC-057 | Network Error | Verify network error | Line ~950 |
| TC-058 | Data Security | Verify data security | Line ~970 |
| TC-059 | HTTPS Connection | Verify HTTPS | Line ~985 |
| TC-060 | Form Security | Verify form security | Line ~1000 |
| TC-061 | JavaScript Disabled | Verify JavaScript disabled | Line ~1020 |
| TC-062 | Caching | Verify caching | Line ~1035 |
| TC-063 | URL Encoding | Verify URL encoding | Line ~1050 |
| TC-064 | Page Title | Verify page title | Line ~1065 |
| TC-065 | Meta Description | Verify meta description | Line ~1085 |
| TC-066 | Open Graph | Verify open graph tags | Line ~1100 |
| TC-067 | Canonical Tag | Verify canonical tag | Line ~1115 |

## Integration with CI/CD

### GitHub Actions Example
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
      - run: mvn test -Dtest=CucumberTestRunner
      - uses: actions/upload-artifact@v2
        if: always()
        with:
          name: cucumber-reports
          path: target/cucumber-reports/
```

## Advantages of BDD

1. **Clear Communication**: Non-technical stakeholders can understand test cases
2. **Living Documentation**: Feature files serve as up-to-date documentation
3. **Easier Maintenance**: Changes to requirements reflect in feature files
4. **Better Collaboration**: Developers, testers, and business analysts can work together
5. **Reduced Ambiguity**: Natural language removes technical jargon

## Step Definition Best Practices

1. **Keep Steps Simple**: Each step should represent one action
2. **Use Clear Language**: Steps should be readable and understandable
3. **Avoid Logic in Steps**: Complex logic should be in page objects
4. **Reuse Steps**: Create generic steps that can be reused across scenarios
5. **Handle Waits Properly**: Use explicit waits for dynamic content

## Common Issues and Solutions

### Issue: Step not found
**Solution**: Ensure step definition class is in the correct package and runner has correct glue path

### Issue: WebDriver timeout
**Solution**: Increase timeout in `wait` object or use explicit waits

### Issue: Element not found
**Solution**: Update XPath selectors to match current page structure

### Issue: Tests pass locally but fail in CI
**Solution**: Ensure same browser versions and dependencies in CI environment

## Future Enhancements

1. **Data-Driven Scenarios**: Use Examples tables for multiple data sets
2. **API Testing**: Add API scenarios alongside UI scenarios
3. **Performance Testing**: Add performance thresholds to scenarios
4. **Visual Testing**: Integrate visual regression testing
5. **Mobile Testing**: Add mobile-specific scenarios
6. **Parallel Execution**: Run scenarios in parallel for faster feedback

## References

- [Cucumber Documentation](https://cucumber.io/docs/cucumber/)
- [Gherkin Reference](https://cucumber.io/docs/gherkin/reference/)
- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [BDD Best Practices](https://cucumber.io/docs/bdd/)

## Support

For issues or questions regarding these BDD test cases:
1. Check the step definitions in `JobPostingPageSteps.java`
2. Verify feature file syntax is valid
3. Ensure all dependencies are installed
4. Check CI/CD logs for detailed error messages

---

**Generated Date**: December 2025
**Total Scenarios**: 67
**Total Step Definitions**: 120+
**Test Coverage**: 100% of manual test cases
