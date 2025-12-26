package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentProfile findByStudentId(String studentId) {
        return repo.findByStudentId(studentId).orElse(null);
    }

    @Override
    public StudentProfile save(StudentProfile student) {
        return repo.save(student);
    }

    @Override
    public void updateStudentStatus(long id, boolean status) {
        StudentProfile s = repo.findById(id).orElse(null);
        if (s != null) {
            s.setActive(status);
            repo.save(s);
        }
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repo.findAll();
    }
}
