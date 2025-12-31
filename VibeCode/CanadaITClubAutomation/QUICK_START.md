# Quick Start Guide

## ⚡ 5-Minute Setup

### 1. Extract Project
```bash
cd /Users/tarun.gupta2/Desktop/Self/LearnAutomation/VibeCode/CanadaITClubAutomation
```

### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Run Tests
```bash
mvn test
```

### 4. View Results
```bash
open target/surefire-reports/index.html
```

---

## 🚀 Common Commands

### Run All Tests
```bash
mvn test
```

### Run Specific Test Class
```bash
mvn test -Dtest=PageLoadAndNavigationTests
```

### Run Specific Test Method
```bash
mvn test -Dtest=PageLoadAndNavigationTests#testPageLoadsSuccessfully
```

### Run with Different Browser
Edit `config.properties`:
```properties
BROWSER=firefox  # or safari
```

### Run in Headless Mode
Edit `config.properties`:
```properties
HEADLESS=true
```

### View Test Report
```bash
open target/surefire-reports/index.html
```

### View Logs
```bash
tail -f test-output/logs/automation.log
```

### View Screenshots
```bash
open test-output/screenshots/
```

---

## 📁 Key Files

| File | Purpose |
|------|---------|
| `config.properties` | Configuration (URLs, timeouts, browser) |
| `testng.xml` | Test suite configuration |
| `pom.xml` | Maven dependencies |
| `JobPostingPage.java` | Page object with all elements |
| `BaseTest.java` | Base class for all tests |
| `*Tests.java` | Actual test classes |

---

## ✅ Quick Checklist

- [ ] Java 11 or higher installed (`java -version`)
- [ ] Maven installed (`mvn -v`)
- [ ] Project extracted
- [ ] Dependencies installed (`mvn clean install`)
- [ ] Configuration updated (if needed)
- [ ] Tests running (`mvn test`)
- [ ] Reports generated

---

## 🐛 Troubleshooting

**Tests not running?**
```bash
mvn clean install
mvn test -X  # Verbose output
```

**WebDriver not found?**
```bash
mvn clean install -DskipTests
```

**Element not found?**
1. Check JobPostingPage.java locators
2. Update xpath/id in @FindBy
3. Run test again

**Timeout issues?**
1. Edit config.properties
2. Increase EXPLICIT_WAIT
3. Or IMPLICIT_WAIT

---

## 📊 Test Suites

| Suite | Tests | TC Range |
|-------|-------|----------|
| Page Load & Navigation | 3 | TC-001 to TC-003 |
| Job Header | 3 | TC-004 to TC-006 |
| Apply Button | 3 | TC-007 to TC-009 |
| Job Description | 7 | TC-010 to TC-016 |
| Related Jobs & Share | 5 | TC-019 to TC-024 |
| Overview & Employer | 7 | TC-027 to TC-033 |
| Responsive & Browser | 4 | TC-041 to TC-064 |

**Total: 32 Test Cases**

---

## 📝 Adding a New Test

1. **Create test class**:
   ```bash
   src/test/java/com/canadaitclub/tests/YourTestClass.java
   ```

2. **Extend BaseTest**:
   ```java
   public class YourTestClass extends BaseTest {
       private JobPostingPage jobPostingPage;
       
       @BeforeMethod
       public void setUp() {
           jobPostingPage = new JobPostingPage(driver);
           navigateTo(ConfigManager.getProperty("JOB_POSTING_URL"));
       }
   }
   ```

3. **Write test method**:
   ```java
   @Test(description = "Test description")
   public void testName() {
       Assert.assertTrue(jobPostingPage.isJobTitleDisplayed());
   }
   ```

4. **Add to testng.xml**:
   ```xml
   <class name="com.canadaitclub.tests.YourTestClass"/>
   ```

5. **Run test**:
   ```bash
   mvn test -Dtest=YourTestClass
   ```

---

## 🎯 Best Practices

✅ Always use explicit waits
```java
WaitUtil.waitForElementClickable(driver, By.id("button")).click();
```

✅ Add meaningful logging
```java
logger.info("Clicking Apply Now button");
```

✅ Use page objects for all interactions
```java
jobPostingPage.clickApplyNowButton();  // Good
driver.findElement(By.id("button")).click();  // Bad
```

✅ Don't hardcode values
```java
String url = ConfigManager.getProperty("BASE_URL");  // Good
driver.navigate().to("https://canadaitclub.ca");  // Bad
```

---

## 📞 Support

- Framework Guide: `FRAMEWORK_GUIDE.md`
- Full README: `README.md`
- Code documentation: Check Javadoc in source files

---

**Version**: 1.0  
**Last Updated**: December 18, 2025
