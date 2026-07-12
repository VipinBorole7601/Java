package com.company.framework.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    private final Locator emailInput = page.getByTestId("login-email");
    private final Locator passwordInput = page.getByTestId("login-password");
    private final Locator loginButton = page.getByRole("button", new Page.GetByRoleOptions().setName("Login"));
    private final Locator errorMessage = page.getByTestId("login-error");
    private final Locator loginForm = page.getByTestId("login-form");

    public LoginPage(Page page) {
        super(page);
    }

    public void navigate() {
        logger.info("Navigating to login page");
        page.navigate("/login");
    }

    public void login(String email, String password) {
        logger.info("Logging in with email: {}", email);
        waitAndFill(emailInput, email);
        waitAndFill(passwordInput, password);
        waitAndClick(loginButton);
    }

    public String getErrorMessage() {
        logger.info("Getting error message");
        return getText(errorMessage);
    }

    public boolean isLoginFormVisible() {
        logger.info("Checking if login form is visible");
        return isVisible(loginForm);
    }

    public String getCurrentPageTitle() {
        return page.title();
    }
}
