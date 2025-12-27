package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "room_assignment_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_a_id", nullable = false)
    private Long studentAId;

    @Column(name = "student_b_id", nullable = true)
    private Long studentBId;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    // You can add more fields if needed
}
