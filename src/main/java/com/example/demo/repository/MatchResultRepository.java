package com.example.demo.repository; 

import com.example.demo.model.MatchResult; 
import org.springframework.data.jpa.repository.JpaRepository; 

import java.uƟl.List; 

public interface MatchResultRepository extends JpaRepository<MatchResult, Long> { 

    List<MatchResult> findByStudentAIdOrStudentBId(Long studentAId, Long studentBId); 
} 
