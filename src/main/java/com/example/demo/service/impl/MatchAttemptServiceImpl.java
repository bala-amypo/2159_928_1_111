package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.service.MatchAttemptService;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository attemptRepo;
    private final CompatibilityScoreRecordRepository scoreRepo;

    public MatchAttemptServiceImpl(
            MatchAttemptRecordRepository attemptRepo,
            CompatibilityScoreRecordRepository scoreRepo) {
        this.attemptRepo = attemptRepo;
        this.scoreRepo = scoreRepo;
    }

    @Override
    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord record) {
        return attemptRepo.save(record);
    }

    @Override
    public List<MatchAttemptRecord> getAllAttempts() {
        return attemptRepo.findAll();
    }
}
