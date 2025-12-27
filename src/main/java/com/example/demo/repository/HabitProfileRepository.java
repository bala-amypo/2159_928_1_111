package com.example.demo.repository; 

import com.example.demo.model.HabitProfile; 
import org.springframework.data.jpa.repository.JpaRepository; 

import java.uƟl.OpƟonal; 

public interface HabitProfileRepository extends JpaRepository<HabitProfile, Long> { 

    OpƟonal<HabitProfile> findByStudentId(Long studentId); 
} 
