package com.example.demo.service.impl;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repository;

    public StudentProfileServiceImpl(StudentProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentProfile createStudent(StudentProfile profile) {
        return repository.save(profile);
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
