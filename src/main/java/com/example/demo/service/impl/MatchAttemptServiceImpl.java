package com.example.demo.service.impl;

import com.example.demo.model.MatchAttempt;
import com.example.demo.repository.MatchAttemptRepository;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRepository repository;

    public MatchAttemptServiceImpl(MatchAttemptRepository repository) {
        this.repository = repository;
    }

    @Override
    public MatchAttempt createMatchAttempt(MatchAttempt attempt) {
        return repository.save(attempt);
    }

    @Override
    public Optional<MatchAttempt> getMatchAttemptById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<MatchAttempt> getAllMatchAttempts() {
        return repository.findAll();
    }
}
