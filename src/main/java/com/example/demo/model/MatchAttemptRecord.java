package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MatchAttemptRecord {

    public enum Status { MATCHED, NOT_COMPATIBLE, PENDING_REVIEW }

    @Id
    @GeneratedValue
    private Long id;

    private Long initiatorStudentId;
    private Long candidateStudentId;
    private Long resultScoreId;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime attemptedAt = LocalDateTime.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getInitiatorStudentId() { return initiatorStudentId; }
    public void setInitiatorStudentId(Long i) { this.initiatorStudentId = i; }

    public Long getCandidateStudentId() { return candidateStudentId; }
    public void setCandidateStudentId(Long c) { this.candidateStudentId = c; }

    public Long getResultScoreId() { return resultScoreId; }
    public void setResultScoreId(Long r) { this.resultScoreId = r; }

    public Status getStatus() { return status; }
    public void setStatus(Status s) { this.status = s; }
}
