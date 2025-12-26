package com.example.demo.service;

import com.example.demo.model.StudentProfile;
import java.util.List;

public interface StudentProfileService {

    StudentProfile createStudent(StudentProfile student);

    StudentProfile updateStudent(Long id, StudentProfile student);

    void deleteStudent(Long id);

    StudentProfile getStudentById(Long id);

    List<StudentProfile> getAllStudents();
}
