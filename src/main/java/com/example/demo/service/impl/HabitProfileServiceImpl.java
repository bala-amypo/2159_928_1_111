package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import java.time.LocalDateTime;
import java.util.*;

public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repo;

    public HabitProfileServiceImpl(HabitProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile habit) {
        if (habit.getStudyHoursPerDay() <= 0) {
            throw new IllegalArgumentException("study hours");
        }

        Optional<HabitProfile> existing = repo.findByStudentId(habit.getStudentId());
        if (existing.isPresent()) {
            HabitProfile e = existing.get();
            habit.setId(e.getId());
        }
        habit.setUpdatedAt(LocalDateTime.now());
        return repo.save(habit);
    }

    @Override
    public HabitProfile getHabitByStudent(Long studentId) {
        return repo.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public Optional<HabitProfile> getHabitById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return repo.findAll();
    }
}
