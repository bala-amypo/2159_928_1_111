package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final StudentProfileRepository students;
    private final HabitProfileRepository habits;
    private final MatchResultRepository matches;

    public MatchService(StudentProfileRepository students,
                        HabitProfileRepository habits,
                        MatchResultRepository matches) {
        this.students = students;
        this.habits = habits;
        this.matches = matches;
    }

    public MatchResult computeMatch(Long a, Long b) {

        StudentProfile sa = students.findById(a)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        StudentProfile sb = students.findById(b)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        HabitProfile ha = habits.findByStudentId(a)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
        HabitProfile hb = habits.findByStudentId(b)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        double score = 100;
        score -= Math.abs(ha.getCleanlinessLevel() - hb.getCleanlinessLevel()) * 5;
        score -= Math.abs(ha.getNoisePreference() - hb.getNoisePreference()) * 5;

        score = Math.max(0, Math.min(100, score));

        MatchResult r = new MatchResult();
        r.setStudentA(sa);
        r.setStudentB(sb);
        r.setScore(score);

        return matches.save(r);
    }

    public List<MatchResult> getMatchesFor(Long studentId) {
        return matches.findByStudentAIdOrStudentBIdOrderByScoreDesc(studentId, studentId);
    }

    public MatchResult getById(Long id) {
        return matches.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
    }
}
