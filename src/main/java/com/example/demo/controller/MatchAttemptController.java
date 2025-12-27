package com.example.demo.controller;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.service.MatchAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match-attempts")
public class MatchAttemptController {

    @Autowired
    private MatchAttemptService matchAttemptService;

    @PostMapping
    public ResponseEntity<MatchAttemptRecord> createMatchAttempt(
            @RequestBody MatchAttemptRecord record) {
        return ResponseEntity.ok(matchAttemptService.createMatchAttempt(record));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchAttemptRecord> getMatchAttempt(@PathVariable Long id) {
        return matchAttemptService.getMatchAttemptById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<MatchAttemptRecord>> getAllMatchAttempts() {
        return ResponseEntity.ok(matchAttemptService.getAllMatchAttempts());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MatchAttemptRecord>> getMatchAttemptsByUser(
            @PathVariable Long userId) {
        return ResponseEntity.ok(matchAttemptService.getMatchAttemptsByUserId(userId));
    }
}
