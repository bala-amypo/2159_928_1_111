package com.example.demo.repository; 

import com.example.demo.model.StudentProfile; 
import org.springframework.data.jpa.repository.JpaRepository; 

import java.uƟl.OpƟonal; 

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> { 

    OpƟonal<StudentProfile> findByStudentId(String studentId); 
} 
