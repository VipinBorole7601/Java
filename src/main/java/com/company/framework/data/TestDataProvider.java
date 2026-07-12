package com.company.framework.data;

import java.util.HashMap;
import java.util.Map;

public class TestDataProvider {
    
    public static Map<String, String> getValidLoginData() {
        Map<String, String> data = new HashMap<>();
        data.put("email", "validuser@example.com");
        data.put("password", "password123");
        return data;
    }
    
    public static Map<String, String> getInvalidLoginData() {
        Map<String, String> data = new HashMap<>();
        data.put("email", "invalid@example.com");
        data.put("password", "wrongpassword");
        return data;
    }
}
