# Framework Best Practices & Standards

## Page Object Model - DO

\\\java
public class LoginPage extends BasePage {
    private final Locator emailInput = page.getByTestId("email");
    
    public LoginPage(Page page) { super(page); }
    
    public void login(String email, String password) {
        waitAndFill(emailInput, email);
    }
}
\\\

## Locator Priority

1. getByTestId()      ← BEST
2. getByRole()        ← GOOD
3. getByLabel()       ← GOOD
4. CSS               ← LESS
5. XPath             ← WORST

## Waits - DO (NOT Thread.sleep)

\\\java
locator.waitFor();
page.waitForLoadState("networkidle");
\\\

---
Last Updated: 2026
