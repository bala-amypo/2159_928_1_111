package com.example.demo.service.impl;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    @Autowired
    private CompatibilityScoreRecordRepository repo;

    @Override
    public CompatibilityScoreRecord saveScore(CompatibilityScoreRecord scoreRecord) {
        return repo.save(scoreRecord);
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores(Long studentId) {
        return repo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public CompatibilityScoreRecord getScoreById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
