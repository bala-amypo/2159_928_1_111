package com.example.demo.service;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository repo;

    public CompatibilityScoreService(CompatibilityScoreRecordRepository repo) {
        this.repo = repo;
    }

    public CompatibilityScoreRecord createOrUpdateScore(CompatibilityScoreRecord score) {
        return repo.save(score);
    }

    public Optional<CompatibilityScoreRecord> getScoreById(Long id) {
        return repo.findById(id);
    }

    public List<CompatibilityScoreRecord> getScoresForStudent(Long studentId) {
        return repo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    public List<CompatibilityScoreRecord> getAllScores() {
        return repo.findAll();
    }
}
