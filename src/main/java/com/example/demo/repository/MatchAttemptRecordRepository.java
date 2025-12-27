package com.example.demo.repository; 

import com.example.demo.model.MatchAƩemptRecord; 
import org.springframework.data.jpa.repository.JpaRepository; 

import java.uƟl.List; 

public interface MatchAƩemptRecordRepository extends JpaRepository<MatchAƩemptRecord, Long> { 

    List<MatchAƩemptRecord> findByStudentId(Long studentId); 
} 
