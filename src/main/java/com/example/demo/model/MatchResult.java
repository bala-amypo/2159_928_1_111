package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "match_results")
public class MatchResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_a_id")
    private StudentProfile studentA;

    @ManyToOne
    @JoinColumn(name = "student_b_id")
    private StudentProfile studentB;

    @Min(value = 0, message = "Score must be between 0-100")
    @Max(value = 100, message = "Score must be between 0-100")
    private Double score;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private String reasonSummary;

    public MatchResult() {}

    public MatchResult(StudentProfile studentA, StudentProfile studentB, Double score) {
        this.studentA = studentA;
        this.studentB = studentB;
        this.score = score;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public StudentProfile getStudentA() { return studentA; }
    public void setStudentA(StudentProfile studentA) { this.studentA = studentA; }

    public StudentProfile getStudentB() { return studentB; }
    public void setStudentB(StudentProfile studentB) { this.studentB = studentB; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getReasonSummary() { return reasonSummary; }
    public void setReasonSummary(String reasonSummary) { this.reasonSummary = reasonSummary; }
}