package com.example.demo.service.impl;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repository;

    public HabitProfileServiceImpl(HabitProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile habit) {
        return repository.save(habit);
    }

    @Override
    public HabitProfile getHabitByStudent(Long studentId) {
        return repository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found for student"));
    }

    @Override
    public Optional<HabitProfile> getHabitById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return repository.findAll();
    }
}
