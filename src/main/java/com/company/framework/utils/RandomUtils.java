package com.company.framework.utils;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomUtils {
    private static final Logger logger = LoggerFactory.getLogger(RandomUtils.class);
    private static final Random random = new Random();

    public static String generateRandomEmail() {
        String email = "qa_" + System.currentTimeMillis() + "_" + random.nextInt(10000) + "@example.com";
        logger.info("Generated email: {}", email);
        return email;
    }

    public static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(chars.charAt(random.nextInt(chars.length())));
        }
        return result.toString();
    }

    public static int generateRandomNumber(int max) {
        return random.nextInt(max);
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public static String getCurrentTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static <T> T getRandomFromList(List<T> list) {
        if (list.isEmpty()) return null;
        return list.get(random.nextInt(list.size()));
    }
}
