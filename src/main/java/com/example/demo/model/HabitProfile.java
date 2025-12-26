package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class HabitProfile {

    public enum SleepSchedule { EARLY, REGULAR, LATE }
    public enum CleanlinessLevel { LOW, MEDIUM, HIGH }
    public enum NoiseTolerance { LOW, MEDIUM, HIGH }
    public enum SocialPreference { INTROVERT, BALANCED, EXTROVERT }

    @Id
    @GeneratedValue
    private Long id;

    private Long studentId;
    private Integer studyHoursPerDay;

    @Enumerated(EnumType.STRING)
    private SleepSchedule sleepSchedule;

    @Enumerated(EnumType.STRING)
    private CleanlinessLevel cleanlinessLevel;

    @Enumerated(EnumType.STRING)
    private NoiseTolerance noiseTolerance;

    @Enumerated(EnumType.STRING)
    private SocialPreference socialPreference;

    private LocalDateTime updatedAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public Integer getStudyHoursPerDay() { return studyHoursPerDay; }
    public void setStudyHoursPerDay(Integer studyHoursPerDay) { this.studyHoursPerDay = studyHoursPerDay; }

    public void setUpdatedAt(LocalDateTime t) { this.updatedAt = t; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
