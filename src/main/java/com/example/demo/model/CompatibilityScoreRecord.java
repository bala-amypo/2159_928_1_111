package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CompatibilityScoreRecord {

    public enum CompatibilityLevel { POOR, AVERAGE, GOOD, EXCELLENT }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;
    private int score;

    @Enumerated(EnumType.STRING)
    private CompatibilityLevel level;

    private String detailsJson;

    public CompatibilityScoreRecord() {}
    public CompatibilityScoreRecord(Long studentAId, Long studentBId, int score,
                                    CompatibilityLevel level, String detailsJson) {
        this.studentAId = studentAId;
        this.studentBId = studentBId;
        this.score = score;
        this.level = level;
        this.detailsJson = detailsJson;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public Long getStudentAId() { return studentAId; }
    public void setStudentAId(Long studentAId) { this.studentAId = studentAId; }

    public Long getStudentBId() { return studentBId; }
    public void setStudentBId(Long studentBId) { this.studentBId = studentBId; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public CompatibilityLevel getLevel() { return level; }
    public void setLevel(CompatibilityLevel level) { this.level = level; }

    public String getDetailsJson() { return detailsJson; }
    public void setDetailsJson(String detailsJson) { this.detailsJson = detailsJson; }
}
