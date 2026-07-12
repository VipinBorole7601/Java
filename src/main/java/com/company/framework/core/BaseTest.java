package com.company.framework.core;

import com.microsoft.playwright.Page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    protected Page page;
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    private static final boolean HEADLESS = Boolean.parseBoolean(System.getProperty("headless", "true"));
    private static final String BROWSER = System.getProperty("browser", "chromium");

    @BeforeMethod
    public void setUp() {
        logger.info("Setting up test - Browser: {}, Headless: {}", BROWSER, HEADLESS);
        page = BrowserFactory.createPage(BROWSER, HEADLESS);
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Tearing down test");
        BrowserFactory.closePage();
    }
}
