package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CompatibilityScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentOneId;
    private Long studentTwoId;
    private Double score;

    public CompatibilityScoreRecord() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentOneId() {
        return studentOneId;
    }

    public void setStudentOneId(Long studentOneId) {
        this.studentOneId = studentOneId;
    }

    public Long getStudentTwoId() {
        return studentTwoId;
    }

    public void setStudentTwoId(Long studentTwoId) {
        this.studentTwoId = studentTwoId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
