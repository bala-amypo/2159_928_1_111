package com.example.demo.service;

import com.example.demo.dto.HabitProfileDto;
import com.example.demo.model.HabitProfile;
import java.util.List;

public interface HabitProfileService {

    HabitProfile createHabit(HabitProfile habit);

    HabitProfile getHabitById(Long id);

    List<HabitProfile> getAllHabits();

    String createOrUpdate(Long studentId, HabitProfileDto dto);
}
