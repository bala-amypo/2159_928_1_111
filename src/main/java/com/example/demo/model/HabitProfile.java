package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;

    private Integer studyHoursPerDay;
    private String sleepSchedule;
    private Integer cleanlinessLevel;
    private Integer noiseTolerance;
    private String socialPreference;

    private LocalDateTime updatedAt;

    // ===== GETTERS =====

    public Long getId() { return id; }
    public Long getStudentId() { return studentId; }
    public Integer getStudyHoursPerDay() { return studyHoursPerDay; }
    public String getSleepSchedule() { return sleepSchedule; }
    public Integer getCleanlinessLevel() { return cleanlinessLevel; }
    public Integer getNoiseTolerance() { return noiseTolerance; }
    public String getSocialPreference() { return socialPreference; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    // ===== SETTERS (FIXED) =====

    public void setId(Long id) { this.id = id; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public void setStudyHoursPerDay(Integer studyHoursPerDay) {
        this.studyHoursPerDay = studyHoursPerDay;
    }

    public void setSleepSchedule(String sleepSchedule) {
        this.sleepSchedule = sleepSchedule;
    }

    public void setCleanlinessLevel(Integer cleanlinessLevel) {
        this.cleanlinessLevel = cleanlinessLevel;
    }

    public void setNoiseTolerance(Integer noiseTolerance) {
        this.noiseTolerance = noiseTolerance;
    }

    public void setSocialPreference(String socialPreference) {
        this.socialPreference = socialPreference;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
