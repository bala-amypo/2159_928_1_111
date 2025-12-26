package com.example.demo.service;

import com.example.demo.model.MatchAttempt;
import java.util.List;
import java.util.Optional;

public interface MatchAttemptService {

    MatchAttempt createMatchAttempt(MatchAttempt attempt);

    Optional<MatchAttempt> getMatchAttemptById(Long id);

    List<MatchAttempt> getAllMatchAttempts();
}
