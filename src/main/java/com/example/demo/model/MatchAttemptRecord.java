package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class MatchAttemptRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;
    private String status;

    public MatchAttemptRecord() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentAId() {
        return studentAId;
    }

    public void setStudentAId(Long studentAId) {
        this.studentAId = studentAId;
    }

    public Long getStudentBId() {
        return studentBId;
    }

    public void setStudentBId(Long studentBId) {
        this.studentBId = studentBId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
