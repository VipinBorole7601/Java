# Java + Playwright - Quick Start Guide

## 5-Minute Setup

\\\ash
mvn clean install
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
mvn test -Dtest=LoginSmokeTest#testLoginPageLoads
mvn allure:serve
\\\

## Your First Test

\\\java
public class MyFirstTest extends BaseTest {
    @Test
    public void testExample() {
        page.navigate("https://example.com");
        page.getByTestId("button").click();
        Assert.assertTrue(page.url().contains("success"));
    }
}
\\\

## Common Commands

| Command | Purpose |
|---------|---------|
| \mvn test\ | Run all tests |
| \mvn test -Dtest=LoginTest\ | Specific test |
| \mvn test -Dheadless=false\ | See browser |
| \mvn allure:serve\ | View reports |

---
Last Updated: 2026
