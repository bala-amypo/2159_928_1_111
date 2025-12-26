package com.example.demo.service;

import com.example.demo.model.StudentProfile;
import java.util.List;
import java.util.Optional;

public interface StudentProfileService {

    StudentProfile createOrUpdate(StudentProfile profile);

    StudentProfile getById(Long id);

    Optional<StudentProfile> findByStudentId(Long studentId);

    List<StudentProfile> getAll();
}
