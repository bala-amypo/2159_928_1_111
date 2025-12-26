package com.example.demo.service.impl;

import com.example.demo.model.MatchAttempt;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    @Override
    public MatchAttempt getMatchAttemptById(Long id) {
        return new MatchAttempt();
    }

    @Override
    public List<MatchAttempt> getAllMatchAttempts() {
        return new ArrayList<>();
    }
}
