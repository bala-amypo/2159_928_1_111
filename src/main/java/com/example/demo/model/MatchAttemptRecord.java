package com.example.demo.model; 

import jakarta.persistence.*; 

import java.Ɵme.LocalDateTime; 

@Entity 
public class MatchAƩemptRecord { 

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 

    private Long studentId; 
    private LocalDateTime aƩemptTime; 
    private String status; 

    public MatchAƩemptRecord() {} 

    public Long getId() { return id; } 
    public void setId(Long id) { this.id = id; } 

    public Long getStudentId() { return studentId; } 
    public void setStudentId(Long studentId) { this.studentId = studentId; } 

    public LocalDateTime getAƩemptTime() { return aƩemptTime; } 
    public void setAƩemptTime(LocalDateTime aƩemptTime) { this.aƩemptTime = aƩemptTime; } 

    public String getStatus() { return status; } 
    public void setStatus(String status) { this.status = status; } 
} 
