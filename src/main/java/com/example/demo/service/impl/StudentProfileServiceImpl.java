package com.example.demo.service.impl;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentProfile createStudent(StudentProfile student) {
        return repo.save(student);
    }

    @Override
    public StudentProfile updateStudent(StudentProfile student) {
        return repo.save(student);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repo.findAll();
    }
}
