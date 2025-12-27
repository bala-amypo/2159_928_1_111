package com.example.demo.service;

import com.example.demo.model.HabitProfile;
import java.util.List;

public interface HabitProfileService {
    HabitProfile createHabit(HabitProfile habit);        // matches controller
    HabitProfile updateHabit(HabitProfile habit);
    HabitProfile getHabitByStudent(Long studentId);     // matches controller
    List<HabitProfile> getAllHabits();
}
