# Java + Playwright - Quick Reference Cheat Sheet

## Installation

\\\ash
mvn clean install
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
\\\

## Running Tests

\\\ash
mvn test
mvn test -DsuiteXmlFile=testng-smoke.xml
mvn -Dtest=LoginSmokeTest test
mvn -Dtest=LoginSmokeTest#testMethod test
\\\

## Common Actions

\\\java
page.navigate("url");
locator.click();
locator.fill("text");
locator.selectOption("value");
locator.check();
locator.waitFor();
String text = locator.textContent();
\\\

## Reports

\\\ash
mvn allure:serve
mvn allure:report
\\\

---
Last Updated: 2026
