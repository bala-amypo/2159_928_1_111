package com.example.demo.service.impl; 

import com.example.demo.exception.ResourceNotFoundException; 
import com.example.demo.model.StudentProfile; 
import com.example.demo.repository.StudentProfileRepository; 
import com.example.demo.service.StudentProfileService; 
import org.springframework.stereotype.Service; 

import java.uƟl.List; 

@Service 
public class StudentProfileServiceImpl implements StudentProfileService { 

    private final StudentProfileRepository studentRepo; 

    public StudentProfileServiceImpl(StudentProfileRepository studentRepo) { 
        this.studentRepo = studentRepo; 
    } 

    @Override 
    public StudentProfile createStudent(StudentProfile student) { 
        return studentRepo.save(student); 
    } 

    @Override 
    public StudentProfile getStudentById(Long id) { 
        return studentRepo.findById(id) 
                .orElseThrow(() -> new ResourceNotFoundException("Student not found")); 
    } 

    @Override 
    public List<StudentProfile> getAllStudents() { 
        return studentRepo.findAll(); 
    } 

    @Override 
    public StudentProfile updateStudentStatus(Long id, Boolean acƟve) { 
        StudentProfile student = getStudentById(id); 
        student.setAcƟve(acƟve); 
        return studentRepo.save(student); 
    } 

    @Override 
    public java.uƟl.OpƟonal<StudentProfile> findByStudentId(String studentId) { 
        return studentRepo.findByStudentId(studentId); 
    } 
} 
