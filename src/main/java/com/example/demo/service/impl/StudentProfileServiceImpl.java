package com.example.demo.service.impl;

import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    @Override
    public StudentProfile createStudent(StudentProfile student) {
        return student;
    }

    @Override
    public StudentProfile updateStudent(Long id, StudentProfile student) {
        return student;
    }

    @Override
    public void deleteStudent(Long id) {
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return new StudentProfile();
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return new ArrayList<>();
    }
}
