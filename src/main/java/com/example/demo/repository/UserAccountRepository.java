package com.example.demo.repository;

import com.example.demo.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    // Used by AuthService & CustomUserDetailsService
    Optional<UserAccount> findByEmail(String email);
}
