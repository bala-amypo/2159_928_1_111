package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "compatibility_score_records")
public class CompatibilityScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_a_id")
    private Long studentAId;

    @Column(name = "student_b_id")
    private Long studentBId;

    @Column(name = "score")
    private Double score;

    public CompatibilityScoreRecord() {}

    public CompatibilityScoreRecord(Long studentAId, Long studentBId, Double score) {
        this.studentAId = studentAId;
        this.studentBId = studentBId;
        this.score = score;
    }

    public Long getId() { return id; }
    public Long getStudentAId() { return studentAId; }
    public void setStudentAId(Long studentAId) { this.studentAId = studentAId; }
    public Long getStudentBId() { return studentBId; }
    public void setStudentBId(Long studentBId) { this.studentBId = studentBId; }
    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }
}
