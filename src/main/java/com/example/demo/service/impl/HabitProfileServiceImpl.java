package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository habitRepo;

    public HabitProfileServiceImpl(HabitProfileRepository habitRepo) {
        this.habitRepo = habitRepo;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile habit) {
        return habitRepo.save(habit);
    }

    @Override
    public HabitProfile getHabitByStudentId(Long studentId) {
        return habitRepo.findByStudentId(studentId).orElse(null);
    }

    @Override
    public List<HabitProfile> getAllHabits() {
        return habitRepo.findAll();
    }
}
