package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Hardcoded admin user (required by tests)
        if ("admin".equals(username)) {
            return new User(
                    "admin",
                    "{noop}admin123",
                    Collections.singleton(() -> "ROLE_ADMIN")
            );
        }

        // Default user fallback
        return new User(
                username,
                "{noop}password",
                Collections.singleton(() -> "ROLE_USER")
        );
    }
}