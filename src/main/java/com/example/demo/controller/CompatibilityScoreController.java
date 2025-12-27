package com.example.demo.controller;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compatibility")
public class CompatibilityScoreController {

    private final CompatibilityScoreService service;

    public CompatibilityScoreController(CompatibilityScoreService service) {
        this.service = service;
    }

    @PostMapping("/compute")
    public ResponseEntity<CompatibilityScoreRecord> compute(
            @RequestParam Long studentAId,
            @RequestParam Long studentBId) {
        return ResponseEntity.ok(service.computeScore(studentAId, studentBId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompatibilityScoreRecord> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getScoreById(id));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<CompatibilityScoreRecord>> getByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(service.getScoresForStudent(studentId));
    }

    @GetMapping
    public ResponseEntity<List<CompatibilityScoreRecord>> getAll() {
        return ResponseEntity.ok(service.getAllScores());
    }
}
