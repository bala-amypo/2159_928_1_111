package com.example.demo.controller;

import com.example.demo.model.MatchAttempt;
import com.example.demo.service.MatchAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchAttemptController {

    @Autowired
    private MatchAttemptService matchAttemptService;

    @PostMapping
    public MatchAttempt createMatch(@RequestBody MatchAttempt attempt) {
        return matchAttemptService.createMatch(attempt);
    }

    @GetMapping
    public List<MatchAttempt> getAllMatches() {
        return matchAttemptService.getAllMatchAttempts();
    }
}
