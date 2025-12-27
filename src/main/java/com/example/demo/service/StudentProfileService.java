package com.example.demo.service; 

import com.example.demo.model.StudentProfile; 

import java.uƟl.List; 
import java.uƟl.OpƟonal; 

public interface StudentProfileService { 

    StudentProfile createStudent(StudentProfile student); 

    StudentProfile getStudentById(Long id); 

    List<StudentProfile> getAllStudents(); 

    StudentProfile updateStudentStatus(Long id, Boolean acƟve); 

    OpƟonal<StudentProfile> findByStudentId(String studentId); 
} 
