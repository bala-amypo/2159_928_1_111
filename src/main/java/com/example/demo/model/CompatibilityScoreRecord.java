package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "compatibility_score_records")
public class CompatibilityScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_a_id", nullable = false)
    private Long studentAId;

    @Column(name = "student_b_id", nullable = false)
    private Long studentBId;

    @Column(name = "score", nullable = false)
    private Integer score;

    public CompatibilityScoreRecord() {}

    public CompatibilityScoreRecord(Long id, Long studentAId, Long studentBId, Integer score) {
        this.id = id;
        this.studentAId = studentAId;
        this.studentBId = studentBId;
        this.score = score;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentAId() { return studentAId; }
    public void setStudentAId(Long studentAId) { this.studentAId = studentAId; }

    public Long getStudentBId() { return studentBId; }
    public void setStudentBId(Long studentBId) { this.studentBId = studentBId; }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
}
