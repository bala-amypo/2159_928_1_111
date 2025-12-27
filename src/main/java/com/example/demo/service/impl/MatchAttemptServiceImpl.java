package com.example.demo.service.impl;

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
    public MatchAttemptRecord updateAttemptStatus(long id, String status) {
        MatchAttemptRecord record = repository.findById(id).orElseThrow();
        record.setStatus(MatchAttemptRecord.Status.valueOf(status.toUpperCase()));
        return repository.save(record);
    }

    @Override
    public List<MatchAttemptRecord> getAllMatchAttempts() {
        return repository.findAll();
    }
}
