package com.example.demo.service.impl;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.CompatibilityScoreService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository scoreRepository;
    private final HabitProfileRepository habitRepository;

    public CompatibilityScoreServiceImpl(
            CompatibilityScoreRecordRepository scoreRepository,
            HabitProfileRepository habitRepository) {
        this.scoreRepository = scoreRepository;
        this.habitRepository = habitRepository;
    }

    @Override
    public CompatibilityScoreRecord computeScore(Long student1Id, Long student2Id) {

        HabitProfile h1 = habitRepository.findByStudentId(student1Id)
                .orElseThrow(() -> new ResourceNotFoundException("Student 1 habit not found"));

        HabitProfile h2 = habitRepository.findByStudentId(student2Id)
                .orElseThrow(() -> new ResourceNotFoundException("Student 2 habit not found"));

        int score = 0;
        if (h1.getSleepTime().equals(h2.getSleepTime())) score += 25;
        if (h1.isSmoking() == h2.isSmoking()) score += 25;
        if (h1.isDrinking() == h2.isDrinking()) score += 25;
        if (h1.isStudyLateNight() == h2.isStudyLateNight()) score += 25;

        CompatibilityScoreRecord record = new CompatibilityScoreRecord();
        record.setStudent1Id(student1Id);
        record.setStudent2Id(student2Id);
        record.setScore(score);
        record.setCreatedAt(LocalDateTime.now());

        return scoreRepository.save(record);
    }

    @Override
    public CompatibilityScoreRecord getScoreById(Long id) {
        return scoreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Score not found"));
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores() {
        return scoreRepository.findAll();
    }

    @Override
    public List<CompatibilityScoreRecord> getScoresForStudent(Long studentId) {
        return scoreRepository.findByStudent1IdOrStudent2Id(studentId, studentId);
    }
}
