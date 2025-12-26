package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;

import java.util.List;
import java.util.Optional;

public interface MatchAttemptService {

    // create
    MatchAttemptRecord logMatchAttempt(MatchAttemptRecord attempt);

    // update status
    MatchAttemptRecord updateAttemptStatus(Long attemptId, String status);

    // read
    Optional<MatchAttemptRecord> getMatchAttemptById(Long id);

    List<MatchAttemptRecord> getAttemptsByStudent(Long studentId);

    List<MatchAttemptRecord> getAllMatchAttempts();
}
