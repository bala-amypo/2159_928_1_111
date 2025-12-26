package com.example.demo.service.impl;

import com.example.demo.dto.HabitProfileDto;
import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    @Override
    public HabitProfile createHabit(HabitProfile habit) {
        return habit;
    }

    @Override
    public HabitProfile getHabitById(Long id) {
        return new HabitProfile();
    }

    @Override
    public List<HabitProfile> getAllHabits() {
        return new ArrayList<>();
    }

    @Override
    public String createOrUpdate(Long studentId, HabitProfileDto dto) {
        return "Saved";
    }
}
