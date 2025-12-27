package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CompatibilityScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;
    private int score;

    @Enumerated(EnumType.STRING)
    private CompatibilityLevel compatibilityLevel;

    public enum CompatibilityLevel { LOW, MEDIUM, HIGH }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentAId() { return studentAId; }
    public void setStudentAId(Long studentAId) { this.studentAId = studentAId; }

    public Long getStudentBId() { return studentBId; }
    public void setStudentBId(Long studentBId) { this.studentBId = studentBId; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public CompatibilityLevel getCompatibilityLevel() { return compatibilityLevel; }
    public void setCompatibilityLevel(CompatibilityLevel compatibilityLevel) {
        this.compatibilityLevel = compatibilityLevel;
    }
}
