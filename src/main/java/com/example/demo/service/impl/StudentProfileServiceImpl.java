package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import java.util.*;

public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentProfile createStudent(StudentProfile profile) {
        if (repo.findByStudentId(profile.getStudentId()).isPresent()) {
            throw new IllegalArgumentException("studentId exists");
        }
        if (profile.getEmail() != null && repo.findByEmail(profile.getEmail()).isPresent()) {
            throw new IllegalArgumentException("student exists");
        }
        return repo.save(profile);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public StudentProfile updateStudentStatus(Long id, boolean active) {
        StudentProfile s = getStudentById(id);
        s.setActive(active);
        return repo.save(s);
    }

    @Override
    public Optional<StudentProfile> findByStudentId(String studentId) {
        return repo.findByStudentId(studentId);
    }
}
