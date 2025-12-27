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

    public MatchResult() {
    }

    public MatchResult(StudentProfile studentA, StudentProfile studentB,
                       Double score, String reasonSummary) {
        this.studentA = studentA;
        this.studentB = studentB;
        this.score = score;
        this.reasonSummary = reasonSummary;
    }

    public Long getId() {
        return id;
    }

    public StudentProfile getStudentA() {
        return studentA;
    }

    public StudentProfile getStudentB() {
        return studentB;
    }

    public Double getScore() {
        return score;
    }

    public String getReasonSummary() {
        return reasonSummary;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
