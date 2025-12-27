package com.example.demo.controller;

import com.example.demo.model.MatchResult;
import com.example.demo.service.MatchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
@Tag(name = "Match Controller")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping("/{userId}")
    public ResponseEntity<MatchResult> findMatch(@PathVariable Long userId) {
        return ResponseEntity.ok(matchService.findMatch(userId));
    }

    @GetMapping
    public ResponseEntity<List<MatchResult>> getAllMatches() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchResult> getMatchById(@PathVariable Long id) {
        return ResponseEntity.ok(matchService.getMatchById(id));
    }
}
