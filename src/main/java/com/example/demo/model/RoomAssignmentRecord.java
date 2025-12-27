package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RoomAssignmentRecord {

    public enum Status { ACTIVE, PENDING_REVIEW, COMPLETED }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    private Status status;

    public RoomAssignmentRecord() {}
    public RoomAssignmentRecord(Long studentAId, Long studentBId, String roomNumber, Status status) {
        this.studentAId = studentAId;
        this.studentBId = studentBId;
        this.roomNumber = roomNumber;
        this.status = status;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public Long getStudentAId() { return studentAId; }
    public void setStudentAId(Long studentAId) { this.studentAId = studentAId; }

    public Long getStudentBId() { return studentBId; }
    public void setStudentBId(Long studentBId) { this.studentBId = studentBId; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
