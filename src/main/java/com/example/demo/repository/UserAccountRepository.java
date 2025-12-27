package com.example.demo.repository; 

import com.example.demo.model.UserAccount; 
import org.springframework.data.jpa.repository.JpaRepository; 

import java.uƟl.OpƟonal; 

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> { 

    OpƟonal<UserAccount> findByUsername(String username); 
} 
