package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CompatibilityScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long student1Id;
    private Long student2Id;
    private int score;

    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public Long getStudent1Id() {
        return student1Id;
    }

    public void setStudent1Id(Long student1Id) {
        this.student1Id = student1Id;
    }

    public Long getStudent2Id() {
        return student2Id;
    }

    public void setStudent2Id(Long student2Id) {
        this.student2Id = student2Id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
