package com.example.demo.service.impl;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
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
    public CompatibilityScoreRecord computeScore(Long aId, Long bId) {
        if (aId.equals(bId)) {
            throw new IllegalArgumentException("Cannot compute score for same student");
        }

        HabitProfile a = habitRepo.findByStudentId(aId)
                .orElseThrow(() -> new RuntimeException("Habit not found"));
        HabitProfile b = habitRepo.findByStudentId(bId)
                .orElseThrow(() -> new RuntimeException("Habit not found"));

        double score = 0;

        if (a.getSleepSchedule() != null && a.getSleepSchedule().equals(b.getSleepSchedule())) {
            score += 20;
        }

        if (a.getCleanlinessLevel() != null && a.getCleanlinessLevel().equals(b.getCleanlinessLevel())) {
            score += 15;
        }

        if (a.getNoiseTolerance() != null && a.getNoiseTolerance().equals(b.getNoiseTolerance())) {
            score += 15;
        }

        if (a.getSocialPreference() != null && a.getSocialPreference().equals(b.getSocialPreference())) {
            score += 20;
        }

        score += Math.max(0, 30 - Math.abs(a.getStudyHoursPerDay() - b.getStudyHoursPerDay()) * 5);

        CompatibilityScoreRecord record =
                scoreRepo.findByStudentAIdAndStudentBId(aId, bId)
                        .orElse(new CompatibilityScoreRecord());

        record.setStudentAId(aId);
        record.setStudentBId(bId);
        record.setScore(score);
        record.setComputedAt(LocalDateTime.now());

        return scoreRepo.save(record);
    }

    @Override
    public List<CompatibilityScoreRecord> getScoresForStudent(Long id) {
        return scoreRepo.findByStudentAIdOrStudentBId(id, id);
    }

    @Override
    public CompatibilityScoreRecord getScoreById(Long id) {
        return scoreRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Score not found"));
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores() {
        return scoreRepo.findAll();
    }
}
