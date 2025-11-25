package com.example.couponmanagement.config;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/**
 * Very small demo user store so reviewers can login (if you expose a login endpoint).
 * This is just seed data holder. Passwords are plain-text because assignment only requests demo seed.
 */
public class DemoUserStore {
    private static final Map<String, String> STORE = new ConcurrentHashMap<>();

    public static void put(String email, String password) {
        STORE.put(email.toLowerCase(), password);
    }

    public static boolean validate(String email, String password) {
        if (email == null) return false;
        String p = STORE.get(email.toLowerCase());
        return p != null && p.equals(password);
    }
}
