package com.example.demo.service;

import com.example.demo.model.MatchAttempt;
import java.util.List;

public interface MatchAttemptService {

    MatchAttempt getMatchAttemptById(Long id);

    List<MatchAttempt> getAllMatchAttempts();
}
