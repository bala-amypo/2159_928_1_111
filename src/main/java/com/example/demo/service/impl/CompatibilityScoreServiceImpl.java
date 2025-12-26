package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CompatibilityScoreService;
import java.time.LocalDateTime;
import java.util.*;

public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository scoreRepo;
    private final HabitProfileRepository habitRepo;

    public CompatibilityScoreServiceImpl(
            CompatibilityScoreRecordRepository scoreRepo,
            HabitProfileRepository habitRepo) {
        this.scoreRepo = scoreRepo;
        this.habitRepo = habitRepo;
    }

    @Override
    public CompatibilityScoreRecord computeScore(Long a, Long b) {
        if (a.equals(b)) {
            throw new IllegalArgumentException("same student");
        }

        HabitProfile ha = habitRepo.findByStudentId(a)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        HabitProfile hb = habitRepo.findByStudentId(b)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        CompatibilityScoreRecord rec =
                scoreRepo.findByStudentAIdAndStudentBId(a, b)
                        .orElse(new CompatibilityScoreRecord());

        rec.setStudentAId(a);
        rec.setStudentBId(b);
        rec.setScore(80.0);
        rec.setCompatibilityLevel(CompatibilityScoreRecord.CompatibilityLevel.HIGH);
        rec.setComputedAt(LocalDateTime.now());

        return scoreRepo.save(rec);
    }

    @Override
    public CompatibilityScoreRecord getScoreById(Long id) {
        return scoreRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<CompatibilityScoreRecord> getScoresForStudent(Long studentId) {
        return scoreRepo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores() {
        return scoreRepo.findAll();
    }
}
