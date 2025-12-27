package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public boolean validate(String token) {
        return token != null && !token.isBlank();
    }
}
