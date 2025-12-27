package com.example.demo.service; 

import com.example.demo.model.HabitProfile; 

import java.uƟl.List; 
import java.uƟl.OpƟonal; 

public interface HabitProfileService { 

    HabitProfile createOrUpdateHabit(HabitProfile habit); 

    HabitProfile getHabitByStudent(Long studentId); 

    OpƟonal<HabitProfile> getHabitById(Long id); 

    List<HabitProfile> getAllHabitProfiles(); 
} 
