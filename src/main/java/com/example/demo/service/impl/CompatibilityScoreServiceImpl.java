package com.example.demo.service.impl;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository repository;

    public CompatibilityScoreServiceImpl(CompatibilityScoreRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public CompatibilityScoreRecord saveScore(CompatibilityScoreRecord record) {
        return repository.save(record);
    }
}
