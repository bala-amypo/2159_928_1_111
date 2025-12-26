package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RoomAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private String roomNumber;

    // getters and setters
}
