package com.example.demo.service.impl;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    @Autowired
    private CompatibilityScoreRecordRepository repo;

    @Override
    public CompatibilityScoreRecord saveScore(CompatibilityScoreRecord scoreRecord) {
        return repo.save(scoreRecord);
    }

    @Override
    public List<CompatibilityScoreRecord> getScoresByStudentId(Long studentId) {
        return repo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public Optional<CompatibilityScoreRecord> getScoreById(Long id) {
        return repo.findById(id);
    }
}
