package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private StudentProfile student;

    private boolean smoking;
    private boolean drinking;
    private int cleanlinessLevel;
    private int noisePreference;

    public void setStudent(StudentProfile student) { this.student = student; }
    public boolean isSmoking() { return smoking; }
    public boolean isDrinking() { return drinking; }
    public int getCleanlinessLevel() { return cleanlinessLevel; }
    public int getNoisePreference() { return noisePreference; }
}
