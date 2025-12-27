package com.example.demo.controller;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
public class CompatibilityScoreController {

    @Autowired
    private CompatibilityScoreService service;

    @PostMapping("/save")
    public CompatibilityScoreRecord saveScore(@RequestBody CompatibilityScoreRecord scoreRecord) {
        return service.saveScore(scoreRecord);
    }

    @GetMapping("/all/{studentId}")
    public List<CompatibilityScoreRecord> getAllScores(@PathVariable Long studentId) {
        return service.getAllScores(studentId);
    }

    @GetMapping("/{id}")
    public CompatibilityScoreRecord getScoreById(@PathVariable Long id) {
        return service.getScoreById(id);
    }
}
