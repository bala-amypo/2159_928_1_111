package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserAccountRepository repo;
    private final JwtUtil jwt;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthService(UserAccountRepository repo, JwtUtil jwt) {
        this.repo = repo;
        this.jwt = jwt;
    }

    public AuthResponse register(AuthRequest req) {
        if (repo.findByEmail(req.email).isPresent())
            throw new IllegalArgumentException("already exists");

        UserAccount u = new UserAccount();
        u.setEmail(req.email);
        u.setPassword(encoder.encode(req.password));
        repo.save(u);

        return login(req);
    }

    public AuthResponse login(AuthRequest req) {
        UserAccount u = repo.findByEmail(req.email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        if (!encoder.matches(req.password, u.getPassword()))
            throw new IllegalArgumentException("Invalid credentials");

        AuthResponse res = new AuthResponse();
        res.token = jwt.generateToken(u);
        res.userId = u.getId();
        res.email = u.getEmail();
        res.role = u.getRole();
        return res;
    }
}
