package com.company.framework.core;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test started: {}", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed: {}", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: {}", result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test skipped: {}", result.getName());
    }
}
