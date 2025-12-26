package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matches")
public class MatchAttemptController {

    @PostMapping
    public String createMatch() {
        return "Match created";
    }

    @GetMapping
    public String getMatches() {
        return "All matches";
    }
}
