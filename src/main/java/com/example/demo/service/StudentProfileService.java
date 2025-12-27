package com.example.demo.service;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileService(StudentProfileRepository repo) { this.repo = repo; }

    public StudentProfile createOrUpdateStudent(StudentProfile student) {
        return repo.save(student);
    }

    public Optional<StudentProfile> getStudentById(Long id) {
        return repo.findById(id);
    }

    public List<StudentProfile> getAllStudents() {
        return repo.findAll();
    }
}
