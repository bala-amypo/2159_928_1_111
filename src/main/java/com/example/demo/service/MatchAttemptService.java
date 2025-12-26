package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;
import java.util.List;

public interface MatchAttemptService {

    MatchAttemptRecord createMatchAttempt(Long initiatorId, Long candidateId);

    MatchAttemptRecord getMatchAttemptById(Long id);

    List<MatchAttemptRecord> getAllMatchAttempts();
}
