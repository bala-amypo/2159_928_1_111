package com.example.demo.service.impl;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository habitRepo;

    public HabitProfileServiceImpl(HabitProfileRepository habitRepo) {
        this.habitRepo = habitRepo;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile habit) {

        if (habit.getStudyHoursPerDay() == null || habit.getStudyHoursPerDay() < 0) {
            throw new IllegalArgumentException("Invalid study hours");
        }

        Optional<HabitProfile> existing =
                habitRepo.findByStudentId(habit.getStudentId());

        HabitProfile h = existing.orElse(new HabitProfile());

        h.setStudentId(habit.getStudentId());
        h.setStudyHoursPerDay(habit.getStudyHoursPerDay());
        h.setSleepSchedule(habit.getSleepSchedule());
        h.setCleanlinessLevel(habit.getCleanlinessLevel());
        h.setNoiseTolerance(habit.getNoiseTolerance());
        h.setSocialPreference(habit.getSocialPreference());
        h.setUpdatedAt(LocalDateTime.now());

        return habitRepo.save(h);
    }

    @Override
    public Optional<HabitProfile> getHabitById(Long id) {
        return habitRepo.findById(id);
    }

    @Override
    public HabitProfile getHabitByStudent(Long studentId) {
        return habitRepo.findByStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("Habit not found"));
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return habitRepo.findAll();
    }
}
