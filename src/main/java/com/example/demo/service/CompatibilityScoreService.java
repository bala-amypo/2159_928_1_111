package com.example.demo.service;

import com.example.demo.model.CompatibilityScoreRecord;
import java.util.List;

public interface CompatibilityScoreService {
    CompatibilityScoreRecord createScore(CompatibilityScoreRecord score);
    CompatibilityScoreRecord updateScore(CompatibilityScoreRecord score);
    CompatibilityScoreRecord getScoreById(Long id);
    List<CompatibilityScoreRecord> getScoresForStudent(Long studentId);
    List<CompatibilityScoreRecord> getAllScores();
}
