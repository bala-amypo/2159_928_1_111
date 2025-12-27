package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "room_assignment_records")
public class RoomAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_a_id")
    private Long studentAId;

    @Column(name = "student_b_id")
    private Long studentBId;

    @Column(name = "room_number")
    private String roomNumber;

    public RoomAssignmentRecord() {}

    public RoomAssignmentRecord(Long studentAId, Long studentBId, String roomNumber) {
        this.studentAId = studentAId;
        this.studentBId = studentBId;
        this.roomNumber = roomNumber;
    }

    public Long getId() { return id; }
    public Long getStudentAId() { return studentAId; }
    public void setStudentAId(Long studentAId) { this.studentAId = studentAId; }
    public Long getStudentBId() { return studentBId; }
    public void setStudentBId(Long studentBId) { this.studentBId = studentBId; }
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
}
