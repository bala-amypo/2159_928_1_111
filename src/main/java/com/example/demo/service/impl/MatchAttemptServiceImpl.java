package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.*;
import com.example.demo.service.MatchAttemptService;
import java.util.*;

public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository matchRepo;
    private final CompatibilityScoreRecordRepository scoreRepo;

    public MatchAttemptServiceImpl(
            MatchAttemptRecordRepository matchRepo,
            CompatibilityScoreRecordRepository scoreRepo) {
        this.matchRepo = matchRepo;
        this.scoreRepo = scoreRepo;
    }

    @Override
    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord attempt) {
        if (attempt.getResultScoreId() != null &&
                scoreRepo.findById(attempt.getResultScoreId()).isPresent()) {
            attempt.setStatus(MatchAttemptRecord.Status.MATCHED);
        } else {
            attempt.setStatus(MatchAttemptRecord.Status.PENDING_REVIEW);
        }
        return matchRepo.save(attempt);
    }

    @Override
    public MatchAttemptRecord updateAttemptStatus(Long id, String status) {
        MatchAttemptRecord a = matchRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        a.setStatus(MatchAttemptRecord.Status.valueOf(status));
        return matchRepo.save(a);
    }

    @Override
    public List<MatchAttemptRecord> getAttemptsByStudent(Long studentId) {
        return matchRepo.findByInitiatorStudentIdOrCandidateStudentId(studentId, studentId);
    }

    @Override
    public List<MatchAttemptRecord> getAllMatchAttempts() {
        return matchRepo.findAll();
    }
}
