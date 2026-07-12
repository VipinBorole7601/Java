package com.company.framework.utils;

import com.microsoft.playwright.Locator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaitUtils {
    private static final Logger logger = LoggerFactory.getLogger(WaitUtils.class);
    private static final int DEFAULT_TIMEOUT = 30000;

    public static void waitForElement(Locator locator) {
        logger.info("Waiting for element");
        locator.waitFor(new Locator.WaitForOptions().setTimeout(DEFAULT_TIMEOUT));
    }

    public static void waitForElement(Locator locator, int timeoutMs) {
        logger.info("Waiting for element with timeout: {}ms", timeoutMs);
        locator.waitFor(new Locator.WaitForOptions().setTimeout(timeoutMs));
    }

    public static void waitForElementToBeClickable(Locator locator) {
        logger.info("Waiting for element to be clickable");
        locator.waitFor(new Locator.WaitForOptions().setTimeout(DEFAULT_TIMEOUT));
    }
}
