# Java + Playwright - Utilities Reference

## WaitUtils

\\\java
WaitUtils.waitForElement(locator);
WaitUtils.waitForElement(locator, 10000);
WaitUtils.waitForElementToBeClickable(locator);
WaitUtils.waitForElementToDisappear(locator);
\\\

## ConfigUtils

\\\java
String baseUrl = ConfigUtils.getBaseUrl();
String browser = ConfigUtils.getBrowser();
int timeout = ConfigUtils.getTimeout();
\\\

## RandomUtils

\\\java
String email = RandomUtils.generateRandomEmail();
String random = RandomUtils.generateRandomString(10);
int number = RandomUtils.generateRandomNumber(100);
String uuid = RandomUtils.generateUUID();
\\\

---
Last Updated: 2026
