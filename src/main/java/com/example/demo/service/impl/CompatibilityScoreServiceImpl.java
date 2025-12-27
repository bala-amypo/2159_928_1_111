package com.example.demo.service.impl;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository repo;

    public CompatibilityScoreServiceImpl(CompatibilityScoreRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public CompatibilityScoreRecord createScore(CompatibilityScoreRecord score) {
        return repo.save(score);
    }

    @Override
    public CompatibilityScoreRecord updateScore(CompatibilityScoreRecord score) {
        return repo.save(score);
    }

    @Override
    public CompatibilityScoreRecord getScoreById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<CompatibilityScoreRecord> getScoresForStudent(Long studentId) {
        return repo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores() {
        return repo.findAll();
    }
}
