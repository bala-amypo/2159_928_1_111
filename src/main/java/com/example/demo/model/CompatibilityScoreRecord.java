package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CompatibilityScoreRecord {

    public enum CompatibilityLevel { LOW, MEDIUM, HIGH, EXCELLENT }

    @Id
    @GeneratedValue
    private Long id;

    private Long studentAId;
    private Long studentBId;
    private Double score;

    @Enumerated(EnumType.STRING)
    private CompatibilityLevel compatibilityLevel;

    private LocalDateTime computedAt;
    private String detailsJson;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentAId() { return studentAId; }
    public void setStudentAId(Long studentAId) { this.studentAId = studentAId; }

    public Long getStudentBId() { return studentBId; }
    public void setStudentBId(Long studentBId) { this.studentBId = studentBId; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public CompatibilityLevel getCompatibilityLevel() { return compatibilityLevel; }
    public void setCompatibilityLevel(CompatibilityLevel c) { this.compatibilityLevel = c; }

    public void setComputedAt(LocalDateTime t) { this.computedAt = t; }
    public LocalDateTime getComputedAt() { return computedAt; }

    public String getDetailsJson() { return detailsJson; }
    public void setDetailsJson(String d) { this.detailsJson = d; }
}
