package com.company.framework.utils;

import java.io.FileInputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigUtils {
    private static final Logger logger = LoggerFactory.getLogger(ConfigUtils.class);
    private static Properties properties;

    static {
        try {
            String env = System.getProperty("env", "qa");
            properties = new Properties();
            String configFile = "src/test/resources/config-" + env + ".properties";
            properties.load(new FileInputStream(configFile));
            logger.info("Configuration loaded from: {}", configFile);
        } catch (Exception e) {
            logger.error("Could not load configuration", e);
            throw new RuntimeException("Configuration loading failed", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public static String getBaseUrl() {
        return getProperty("BASE_URL");
    }

    public static String getBrowser() {
        return getProperty("BROWSER", "chromium");
    }

    public static int getTimeout() {
        return Integer.parseInt(getProperty("TIMEOUT_MS", "30000"));
    }

    public static boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(getProperty(key, "false"));
    }
}
