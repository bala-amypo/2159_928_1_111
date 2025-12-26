package com.example.demo.service.impl;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<StudentProfile> getStudentById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public StudentProfile updateStudentStatus(Long id, boolean active) {
        StudentProfile student = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        student.setActive(active);
        return repository.save(student);
    }
}
