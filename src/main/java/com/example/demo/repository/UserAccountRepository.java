package com.example.demo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserAccountRepository {

    public boolean login(String username, String password) {
        // temporary logic
        return "admin".equals(username) && "admin".equals(password);
    }
}
