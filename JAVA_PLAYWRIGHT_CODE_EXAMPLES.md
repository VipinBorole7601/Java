# Java + Playwright - Code Examples

## Basic Test

\\\java
@Test(groups = {"smoke"})
public void testValidLogin() {
    LoginPage loginPage = new LoginPage(page);
    loginPage.navigate();
    loginPage.login("user@example.com", "password123");
    Assert.assertTrue(page.url().contains("dashboard"));
}
\\\

## Page Object

\\\java
public class LoginPage extends BasePage {
    private final Locator emailInput = page.getByTestId("email");
    private final Locator passwordInput = page.getByTestId("password");
    private final Locator loginButton = page.getByRole("button");
    
    public LoginPage(Page page) {
        super(page);
    }
    
    public void login(String email, String password) {
        waitAndFill(emailInput, email);
        waitAndFill(passwordInput, password);
        waitAndClick(loginButton);
    }
}
\\\

## Locator Strategies

\\\java
page.getByTestId("id")                    // BEST
page.getByRole("button")                  // GOOD
page.getByLabel("Label")                  // GOOD
page.locator("css=selector")              // LESS
page.locator("xpath=//button")            // WORST
\\\

---
Last Updated: 2026
