package com.automatiom.steps;

import com.automation.config.ConfigReader;
import com.automation.context.TestContext;
import com.automation.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


/**
 * Step Definitions for Login Feature
 */
public class LoginSteps {
    
    private TestContext testContext;
    private LoginPage loginPage;
    
    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
        this.loginPage = new LoginPage(testContext.getPage());
    }
    
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        String baseUrl = ConfigReader.getBaseUrl();
        loginPage.navigateTo(baseUrl);
        System.out.println("Navigated to login page: " + baseUrl);
    }
    
    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        loginPage.enterUsername(username);
        System.out.println("Entered username: " + username);
    }
    
    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        loginPage.enterPassword(password);
        System.out.println("Entered password");
    }
    
    @And("I click on login button")
    public void iClickOnLoginButton() {
        loginPage.clickLogin();
        System.out.println("Clicked on login button");
        
        // Wait a moment for the page to process
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        boolean isLoggedIn = loginPage.isLoginSuccessful();

        Assert.assertTrue(isLoggedIn, "Login was not successful");
        System.out.println("Login successful - verification passed");
    }
    
    @And("I should see {string} title")
    public void iShouldSeeTitle(String expectedTitle) {
        String actualTitle = loginPage.getProductsTitle();
        Assert.assertEquals(expectedTitle, "Title mismatch", actualTitle);
        System.out.println("Title verified: " + actualTitle);
    }
    
    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        boolean isErrorDisplayed = loginPage.isErrorMessageDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Login was not successful");
        String errorMessage = loginPage.getErrorMessage();
        System.out.println("Error message displayed: " + errorMessage);
    }
    
    @Then("login should {string}")
    public void loginShouldResult(String expectedResult) {
        if (expectedResult.equalsIgnoreCase("pass")) {
            boolean isLoggedIn = loginPage.isLoginSuccessful();
            Assert.assertTrue(isLoggedIn, "Login was not successful");
        } else {
            boolean isErrorDisplayed = loginPage.isErrorMessageDisplayed();
            Assert.assertTrue(isErrorDisplayed, "Login was not successful");
        }
    }
}