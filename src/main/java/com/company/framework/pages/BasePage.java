package com.company.framework.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    protected final Page page;
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    private static final int TIMEOUT = 30000;

    public BasePage(Page page) {
        this.page = page;
    }

    protected void waitAndFill(Locator locator, String text) {
        logger.info("Filling element");
        locator.waitFor(new Locator.WaitForOptions().setTimeout(TIMEOUT));
        locator.clear();
        locator.fill(text);
    }

    protected void waitAndClick(Locator locator) {
        logger.info("Clicking element");
        locator.waitFor(new Locator.WaitForOptions().setTimeout(TIMEOUT));
        locator.click();
    }

    protected void waitForElement(Locator locator) {
        logger.info("Waiting for element");
        locator.waitFor(new Locator.WaitForOptions().setTimeout(TIMEOUT));
    }

    protected String getText(Locator locator) {
        waitForElement(locator);
        return locator.textContent();
    }

    protected boolean isVisible(Locator locator) {
        try {
            return locator.isVisible();
        } catch (Exception e) {
            return false;
        }
    }
}
