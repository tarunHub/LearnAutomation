package com.automatiom.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * TestRunner class to execute Cucumber tests
 */

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.automatiom.steps", "com.automatiom.hooks"},
        plugin = {
                "pretty",
                "html:test-results/reports/cucumber-report.html",
                "json:test-results/reports/cucumber-report.json",
        },
        monochrome = true,
        tags = "@login"
)




public class TestRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = false)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}

