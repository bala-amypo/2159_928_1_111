package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.security.Role;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final JwtUtil jwtUtil;
    private final Map<String, UserAccount> users = new HashMap<>();

    public AuthService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse register(AuthRequest request) {
        if (users.containsKey(request.getUsername())) {
            return new AuthResponse("User already exists");
        }

        UserAccount user = new UserAccount();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.valueOf(request.getRole()));
        user.setActive(true);

        users.put(user.getUsername(), user);

        String token = jwtUtil.generateToken(
                user.getUsername(),
                user.getRole().name(),   // ✅ FIX
                user.getEmail(),
                "0"
        );

        return new AuthResponse(
                token,
                0L,
                user.getRole().name(),   // ✅ FIX
                user.getEmail()
        );
    }

    public AuthResponse login(AuthRequest request) {
        UserAccount user = users.get(request.getUsername());
        if (user == null || !user.getPassword().equals(request.getPassword())) {
            return new AuthResponse("Invalid credentials");
        }

        String token = jwtUtil.generateToken(
                user.getUsername(),
                user.getRole().name(),   // ✅ FIX
                user.getEmail(),
                "0"
        );

        return new AuthResponse(
                token,
                0L,
                user.getRole().name(),   // ✅ FIX
                user.getEmail()
        );
    }
}
