package com.example.demo.service.impl;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repository;

    public MatchAttemptServiceImpl(MatchAttemptRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public MatchAttemptRecord createMatchAttempt(MatchAttemptRecord attempt) {
        return repository.save(attempt);
    }

    @Override
    public Optional<MatchAttemptRecord> getMatchAttemptById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<MatchAttemptRecord> getAllMatchAttempts() {
        return repository.findAll();
    }
}
