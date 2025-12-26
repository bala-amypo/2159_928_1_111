package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.dto.HabitProfileDto;
import com.example.demo.model.HabitProfile;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    @Override
    public HabitProfile createOrUpdate(Long studentId, HabitProfileDto dto) {
        HabitProfile profile = new HabitProfile();
        profile.setStudentId(studentId);
        profile.setCleanlinessLevel(dto.getCleanlinessLevel());
        profile.setSleepSchedule(dto.getSleepSchedule());
        profile.setSmoker(dto.isSmoker());
        return profile;
    }

    @Override
    public HabitProfile getForStudent(Long studentId) {
        HabitProfile profile = new HabitProfile();
        profile.setStudentId(studentId);
        return profile;
    }
}
