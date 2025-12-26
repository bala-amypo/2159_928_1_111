package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.dto.HabitProfileDto;
import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    @Override
    public HabitProfile createOrUpdate(Long studentId, HabitProfileDto dto) {

        HabitProfile profile = new HabitProfile();
        profile.setStudentId(studentId);

        profile.setCleanlinessLevel(
            HabitProfile.CleanlinessLevel.valueOf(dto.getCleanlinessLevel())
        );

        profile.setSleepSchedule(
            HabitProfile.SleepSchedule.valueOf(dto.getSleepSchedule())
        );

        return profile;
    }

    @Override
    public HabitProfile getForStudent(Long studentId) {
        HabitProfile profile = new HabitProfile();
        profile.setStudentId(studentId);
        return profile;
    }
}
