package com.example.demo.service;

import com.example.demo.model.CompatibilityScoreRecord;
import java.util.List;

public interface CompatibilityScoreService {
    CompatibilityScoreRecord saveScore(CompatibilityScoreRecord scoreRecord);
    List<CompatibilityScoreRecord> getAllScores(Long studentId);
    CompatibilityScoreRecord getScoreById(Long id);
}
