package com.company.framework.core;

import com.microsoft.playwright.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserFactory {
    private static final Logger logger = LoggerFactory.getLogger(BrowserFactory.class);
    private static Playwright playwright;
    private static Browser browser;
    private static final ThreadLocal<Page> threadLocalPage = new ThreadLocal<>();

    public static Page createPage(String browserType, boolean headless) {
        try {
            if (playwright == null) {
                playwright = Playwright.create();
                logger.info("Playwright initialized");
            }

            BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                    .setHeadless(headless)
                    .setArgs("--disable-blink-features=AutomationControlled");

            browser = switch (browserType.toLowerCase()) {
                case "firefox" -> playwright.firefox().launch(options);
                case "webkit" -> playwright.webkit().launch(options);
                default -> playwright.chromium().launch(options);
            };

            logger.info("Browser launched: {}", browserType);

            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(1280, 720)
                    .setIgnoreHTTPSErrors(true));

            Page page = context.newPage();
            threadLocalPage.set(page);
            logger.info("New page created");
            return page;
        } catch (Exception e) {
            logger.error("Error creating browser", e);
            throw new RuntimeException("Failed to create browser", e);
        }
    }

    public static Page getPage() {
        Page page = threadLocalPage.get();
        if (page == null) throw new RuntimeException("Page not found in ThreadLocal");
        return page;
    }

    public static void closePage() {
        try {
            Page page = threadLocalPage.get();
            if (page != null) {
                page.close();
                threadLocalPage.remove();
                logger.info("Page closed");
            }
        } catch (Exception e) {
            logger.error("Error closing page", e);
        }
    }

    public static void closeBrowser() {
        try {
            if (browser != null) {
                browser.close();
                logger.info("Browser closed");
            }
            if (playwright != null) {
                playwright.close();
                logger.info("Playwright closed");
            }
        } catch (Exception e) {
            logger.error("Error closing browser", e);
        }
    }
}
