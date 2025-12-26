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
    public MatchAttemptRecord createMatchAttempt(Long initiatorId, Long candidateId) {
        MatchAttemptRecord record = new MatchAttemptRecord();
        record.setInitiatorStudentId(initiatorId);
        record.setCandidateStudentId(candidateId);
        return repository.save(record);
    }

    @Override
    public MatchAttemptRecord getMatchAttemptById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<MatchAttemptRecord> getAllMatchAttempts() {
        return repository.findAll();
    }
}
