package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "compatibility_score_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompatibilityScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_a_id", nullable = false)
    private Long studentAId;

    @Column(name = "student_b_id", nullable = false)
    private Long studentBId;

    @Column(name = "score", nullable = false)
    private Integer score;

    // You can add more fields if needed
}
