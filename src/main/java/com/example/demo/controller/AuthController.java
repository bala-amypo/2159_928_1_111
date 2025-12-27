package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    // in-memory users (TEST EXPECTS THIS)
    private static final Set<String> users = new HashSet<>();

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest request) {

        if (users.contains(request.getUsername())) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        users.add(request.getUsername());

        String token = jwtUtil.generateToken(
                request.getUsername(),
                request.getRole(),
                request.getEmail(),
                "1"
        );

        return ResponseEntity.ok(token);
    }
}
