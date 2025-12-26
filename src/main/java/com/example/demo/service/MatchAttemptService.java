package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;
import java.util.List;
import java.util.Optional;

public interface MatchAttemptService {

    MatchAttemptRecord createMatchAttempt(MatchAttemptRecord attempt);

    Optional<MatchAttemptRecord> getMatchAttemptById(Long id);

    List<MatchAttemptRecord> getAllMatchAttempts();
}
