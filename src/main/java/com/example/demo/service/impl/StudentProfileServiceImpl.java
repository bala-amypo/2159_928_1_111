package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repository;

    public StudentProfileServiceImpl(StudentProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentProfile createStudent(StudentProfile student) {
        return repository.save(student);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repository.findAll();
    }
}
