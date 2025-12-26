package com.example.demo.service;

public interface CompatibilityScoreService {

    String calculateScore(Long studentAId, Long studentBId);

    String getScoresForStudent(Long studentId);
}
