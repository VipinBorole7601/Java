# Project Structure Guide

## Directory Layout

\\\
java-playwright-framework/
├── src/main/java/com/company/framework/
│   ├── core/
│   │   ├── BrowserFactory.java
│   │   ├── BaseTest.java
│   │   └── TestListener.java
│   ├── pages/
│   │   ├── BasePage.java
│   │   └── LoginPage.java
│   ├── utils/
│   │   ├── WaitUtils.java
│   │   ├── ConfigUtils.java
│   │   └── RandomUtils.java
│   └── constants/
│       └── FrameworkConstants.java
├── src/test/java/com/company/tests/
│   ├── smoke/
│   │   └── LoginSmokeTest.java
│   ├── regression/
│   │   └── LoginRegressionTest.java
│   └── e2e/
├── src/test/resources/
│   ├── config.properties
│   ├── config-qa.properties
│   ├── testdata/
│   │   └── users.json
│   └── logback-test.xml
├── testng*.xml
├── pom.xml
└── scripts/
    ├── setup.bat
    └── setup.sh
\\\

---
Last Updated: 2026
