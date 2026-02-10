package com.automation.pages;

import com.microsoft.playwright.Page;

/**
 * LoginPage - Page Object Model for Login functionality
 */
public class LoginPage extends BasePage {
    
    // Locators
    private final String usernameInput = "#user-name";
    private final String passwordInput = "#password";
    private final String loginButton = "#login-button";
    private final String errorMessage = "[data-test='error']";
    private final String productsTitle = ".title";
    
    public LoginPage(Page page) {
        super(page);
    }
    
    /**
     * Enter username
     */
    public void enterUsername(String username) {
        fill(usernameInput, username);
    }
    
    /**
     * Enter password
     */
    public void enterPassword(String password) {
        fill(passwordInput, password);
    }
    
    /**
     * Click login button
     */
    public void clickLogin() {
        click(loginButton);
    }
    
    /**
     * Perform complete login
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    
    /**
     * Check if error message is displayed
     */
    public boolean isErrorMessageDisplayed() {
        return isElementVisible(errorMessage);
    }
    
    /**
     * Get error message text
     */
    public String getErrorMessage() {
        return getText(errorMessage);
    }
    
    /**
     * Check if login was successful
     */
    public boolean isLoginSuccessful() {
        return isElementVisible(productsTitle);
    }
    
    /**
     * Get products page title
     */
    public String getProductsTitle() {
        waitForElement(productsTitle);
        return getText(productsTitle);
    }
}