package com.example.demo.model; 

import jakarta.persistence.*; 

@EnƟty 
public class MatchResult { 

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 

    private Long studentAId; 
    private Long studentBId; 
    private Double compaƟbilityScore; 

    public MatchResult() {} 

    public Long getId() { return id; } 
    public void setId(Long id) { this.id = id; } 

    public Long getStudentAId() { return studentAId; } 
    public void setStudentAId(Long studentAId) { this.studentAId = studentAId; } 

    public Long getStudentBId() { return studentBId; } 
    public void setStudentBId(Long studentBId) { this.studentBId = studentBId; } 

    public Double getCompaƟbilityScore() { return compaƟbilityScore; } 
    public void setCompaƟbilityScore(Double compaƟbilityScore) { this.compaƟbilityScore = compaƟbilityScore; } 
} 
