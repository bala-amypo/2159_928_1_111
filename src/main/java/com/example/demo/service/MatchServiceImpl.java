package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.model.MatchResult;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.repository.MatchResultRepository;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchResultRepository matchResultRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final HabitProfileRepository habitProfileRepository;

    public MatchServiceImpl(MatchResultRepository matchResultRepository,
                           StudentProfileRepository studentProfileRepository,
                           HabitProfileRepository habitProfileRepository) {
        this.matchResultRepository = matchResultRepository;
        this.studentProfileRepository = studentProfileRepository;
        this.habitProfileRepository = habitProfileRepository;
    }

    @Override
    public MatchResult computeMatch(Long studentAId, Long studentBId) {
        StudentProfile studentA = studentProfileRepository.findById(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        StudentProfile studentB = studentProfileRepository.findById(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        HabitProfile habitA = habitProfileRepository.findByStudentId(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
        HabitProfile habitB = habitProfileRepository.findByStudentId(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        double score = calculateCompatibilityScore(habitA, habitB);
        
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0-100");
        }

        MatchResult result = new MatchResult(studentA, studentB, score);
        result.setReasonSummary("Compatibility based on habits and preferences");

        return matchResultRepository.save(result);
    }

    @Override
    public List<MatchResult> getMatchesFor(Long studentId) {
        return matchResultRepository.findByStudentAIdOrStudentBIdOrderByScoreDesc(studentId, studentId);
    }

    @Override
    public MatchResult getById(Long id) {
        return matchResultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
    }

    private double calculateCompatibilityScore(HabitProfile habitA, HabitProfile habitB) {
        double totalScore = 0;
        int factors = 0;

        // Smoking compatibility
        if (habitA.getSmoking() != null && habitB.getSmoking() != null) {
            totalScore += habitA.getSmoking().equals(habitB.getSmoking()) ? 20 : 0;
            factors++;
        }

        // Drinking compatibility
        if (habitA.getDrinking() != null && habitB.getDrinking() != null) {
            totalScore += habitA.getDrinking().equals(habitB.getDrinking()) ? 20 : 0;
            factors++;
        }

        // Sleep time compatibility
        if (habitA.getSleepTime() != null && habitB.getSleepTime() != null) {
            long timeDiff = Math.abs(habitA.getSleepTime().toSecondOfDay() - habitB.getSleepTime().toSecondOfDay());
            double sleepScore = Math.max(0, 20 - (timeDiff / 3600.0) * 2); // 2 points per hour difference
            totalScore += sleepScore;
            factors++;
        }

        // Cleanliness compatibility
        if (habitA.getCleanlinessLevel() != null && habitB.getCleanlinessLevel() != null) {
            int diff = Math.abs(habitA.getCleanlinessLevel() - habitB.getCleanlinessLevel());
            totalScore += Math.max(0, 20 - diff * 5);
            factors++;
        }

        // Noise preference compatibility
        if (habitA.getNoisePreference() != null && habitB.getNoisePreference() != null) {
            int diff = Math.abs(habitA.getNoisePreference() - habitB.getNoisePreference());
            totalScore += Math.max(0, 20 - diff * 5);
            factors++;
        }

        return factors > 0 ? totalScore / factors : 0;
    }
}