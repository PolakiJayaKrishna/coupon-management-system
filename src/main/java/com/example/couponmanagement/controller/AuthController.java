package com.example.couponmanagement.controller;

import com.example.couponmanagement.config.DemoUserStore;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    public static class LoginRequest {
        public String email;
        public String password;
    }

    public static class LoginResponse {
        public boolean ok;
        public String message;
        public LoginResponse(boolean ok, String message) { this.ok = ok; this.message = message; }
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest req) {
        if (DemoUserStore.validate(req.email, req.password)) {
            return new LoginResponse(true, "Demo login success");
        } else {
            return new LoginResponse(false, "Invalid credentials");
        }
    }
}
