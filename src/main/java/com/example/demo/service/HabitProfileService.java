package com.example.demo.service;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HabitProfileService {

    private final HabitProfileRepository repo;

    public HabitProfileService(HabitProfileRepository repo) {
        this.repo = repo;
    }

    public HabitProfile createOrUpdateHabit(HabitProfile habit) {
        return repo.save(habit);
    }

    public Optional<HabitProfile> getHabitById(Long id) {
        return repo.findById(id);
    }

    public List<HabitProfile> getAllHabits() {
        return repo.findAll();
    }
}
