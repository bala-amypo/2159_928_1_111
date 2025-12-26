package com.example.demo.service.impl;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // 🔴 THIS IS MANDATORY
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repository;

    public StudentProfileServiceImpl(StudentProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentProfile create(StudentProfile profile) {
        return repository.save(profile);
    }

    @Override
    public StudentProfile getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<StudentProfile> getAll() {
        return repository.findAll();
    }
}
