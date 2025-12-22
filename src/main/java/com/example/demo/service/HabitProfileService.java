package com.example.demo.service;

import com.example.demo.dto.HabitProfileDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

@Service
public class HabitProfileService {

    private final HabitProfileRepository habits;
    private final StudentProfileRepository students;

    public HabitProfileService(HabitProfileRepository habits,
                               StudentProfileRepository students) {
        this.habits = habits;
        this.students = students;
    }

    public HabitProfile createOrUpdate(Long studentId, HabitProfileDto dto) {

        if (dto.cleanlinessLevel < 1 || dto.cleanlinessLevel > 5)
            throw new IllegalArgumentException("1-5");

        StudentProfile student = students.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        HabitProfile profile = habits.findByStudentId(studentId)
                .orElse(new HabitProfile());

        profile.setStudent(student);
        return habits.save(profile);
    }

    public HabitProfile getForStudent(Long studentId) {
        return habits.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
    }
}
