package com.example.demo.service; 

import com.example.demo.model.MatchAƩemptRecord; 

import java.uƟl.List; 

public interface MatchAƩemptService { 

    MatchAƩemptRecord logMatchAƩempt(MatchAƩemptRecord aƩempt); 

    MatchAƩemptRecord updateAƩemptStatus(Long id, String status); 

    List<MatchAƩemptRecord> getAƩemptsByStudent(Long studentId); 

    MatchAƩemptRecord getAƩemptById(Long id); 

    List<MatchAƩemptRecord> getAllMatchAƩempts(); 
} 
