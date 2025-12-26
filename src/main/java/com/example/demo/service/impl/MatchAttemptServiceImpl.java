package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.service.MatchAttemptService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repository;

    public MatchAttemptServiceImpl(MatchAttemptRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord attempt) {
        return repository.save(attempt);
    }

    @Override
    public MatchAttemptRecord updateAttemptStatus(Long id, String status) {
        MatchAttemptRecord record = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Match attempt not found"));
        record.setStatus(status);
        return repository.save(record);
    }

    @Override
    public List<MatchAttemptRecord> getAttemptsByStudent(Long studentId) {
        return repository.findByStudentId(studentId);
    }

    @Override
    public List<MatchAttemptRecord> getAllMatchAttempts() {
        return repository.findAll();
    }
}
