package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver driver;

    // Locators
    private By usernameField = By.id(":r1:");
    private By emailField = By.id(":r3:");
    private By passwordField = By.id(":r7:");
    private By confirmPasswordField = By.id(":r9:");
    private By phoneNumber = By.id(":r5:");
    private By fullAddress = By.id(":rb:");
    private By registerButton = By.xpath("//button[@type='submit']");
    private By successMessage = By.xpath("//button[@type='submit']");

    // Constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneNumber).sendKeys(phone);
    }

    public void enterAddress(String address) {
        driver.findElement(fullAddress).sendKeys(address);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void confirmPassword(String password) {
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }
}