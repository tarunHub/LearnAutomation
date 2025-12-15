package stepdefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationSteps {
    WebDriver driver;
    RegistrationPage registrationPage;

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        driver = new ChromeDriver();
        driver.get("http://localhost:3001/signup");
        registrationPage = new RegistrationPage(driver);
    }

    @When("I enter valid registration details")
    public void iEnterValidRegistrationDetails() {
        registrationPage.enterUsername("newuser");
        registrationPage.enterEmail("newuser@example.com");
        registrationPage.enterPhone("9898989898");
        registrationPage.enterAddress("123 Main St, City, Country");
        registrationPage.enterPassword("password123");
        registrationPage.confirmPassword("password123");
    }

    @And("I click the register button")
    public void iClickTheRegisterButton() {
        registrationPage.clickRegisterButton();
    }

    @Then("I should see a success message")
    public void iShouldSeeASuccessMessage() {
        assertTrue(registrationPage.isSuccessMessageDisplayed());
        driver.quit();
    }
}