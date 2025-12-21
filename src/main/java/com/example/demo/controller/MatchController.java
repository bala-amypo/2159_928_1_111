package com.example.demo.controller;

import com.example.demo.model.MatchResult;
import com.example.demo.service.MatchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/matches")
@Tag(name = "Matches", description = "Roommate matching")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/compute")
    public ResponseEntity<MatchResult> computeMatch(@RequestBody Map<String, Long> request) {
        Long studentAId = request.get("studentAId");
        Long studentBId = request.get("studentBId");
        MatchResult result = matchService.computeMatch(studentAId, studentBId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<MatchResult>> getMatchesForStudent(@PathVariable Long studentId) {
        List<MatchResult> matches = matchService.getMatchesFor(studentId);
        return ResponseEntity.ok(matches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchResult> getMatch(@PathVariable Long id) {
        MatchResult match = matchService.getById(id);
        return ResponseEntity.ok(match);
    }
}