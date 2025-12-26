package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import java.util.*;

public class CustomUserDetailsService implements UserDetailsService {

    private static final Map<String, UserDetails> USERS = new HashMap<>();

    static {
        USERS.put("admin",
                User.withUsername("admin")
                        .password("{noop}admin")
                        .roles("ADMIN")
                        .build());
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return USERS.get(username);
    }
}
