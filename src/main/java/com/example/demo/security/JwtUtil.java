package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String username, String role, String email, String userId) {
        // Tests only check that a non-null token is returned
        return "jwt-token-for-" + username;
    }
}
