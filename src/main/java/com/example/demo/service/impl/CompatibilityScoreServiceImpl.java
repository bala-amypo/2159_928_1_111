package com.example.demo.service.impl;

import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    @Override
    public String calculateScore(Long studentAId, Long studentBId) {
        return "Score calculated";
    }

    @Override
    public String getScoresForStudent(Long studentId) {
        return "Scores";
    }
}
