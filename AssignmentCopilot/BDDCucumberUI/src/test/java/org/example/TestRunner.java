package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/featurefiles", // Path to the feature files
    glue = "stepdefinitions", // Package containing step definitions
    plugin = {"pretty", "html:target/cucumber-reports.html"}, // Report generation
    monochrome = true // Makes console output more readable
)
public class TestRunner {
}