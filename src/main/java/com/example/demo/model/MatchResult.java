package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MatchResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StudentProfile studentA;

    @ManyToOne
    private StudentProfile studentB;

    private Double score;
    private String reasonSummary;
    private LocalDateTime createdAt = LocalDateTime.now();

    public void setStudentA(StudentProfile a) { this.studentA = a; }
    public void setStudentB(StudentProfile b) { this.studentB = b; }
    public void setScore(Double score) { this.score = score; }
}
