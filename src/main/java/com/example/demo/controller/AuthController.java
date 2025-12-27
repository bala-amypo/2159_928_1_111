package com.example.demo.controller; 

import com.example.demo.dto.AuthRequest; 
import com.example.demo.security.JwtUƟl; 
import org.springframework.hƩp.ResponseEnƟty; 
import org.springframework.web.bind.annotaƟon.*; 
import com.example.demo.repository.UserAccountRepository; 

import java.uƟl.HashMap; 
import java.uƟl.Map; 

@RestController 
@RequestMapping("/auth") 
public class AuthController { 
     
    private final JwtUƟl jwtUƟl; 
    private final Map<String, String> users = new HashMap<>(); 

    public AuthController(JwtUƟl jwtUƟl) { 
        this.jwtUƟl = jwtUƟl; 
    } 

    @PostMapping("/register") 
    public ResponseEnƟty<?> register(@RequestBody AuthRequest request) { 
        if (users.containsKey(request.getUsername())) { 
            return ResponseEnƟty.badRequest().body("User already exists"); 
        } 

        users.put(request.getUsername(), request.getPassword()); 
        String token = jwtUƟl.generateToken(request.getUsername(),  
                request.getRole() != null ? request.getRole() : "USER",  
                request.getEmail(), "1"); 
        return ResponseEnƟty.ok(Map.of("token", token)); 
    } 

    @PostMapping("/login") 
    public ResponseEnƟty<?> login(@RequestBody AuthRequest request) { 
        String storedPassword = users.get(request.getUsername()); 
        if (storedPassword == null || !storedPassword.equals(request.getPassword())) { 
            return ResponseEnƟty.status(401).body("Invalid credenƟals"); 
        } 
         
        String token = jwtUƟl.generateToken(request.getUsername(), "USER",  
                request.getEmail(), "1"); 
        return ResponseEnƟty.ok(Map.of("token", token)); 
    } 
} 
