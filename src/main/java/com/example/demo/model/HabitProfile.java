package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;

    private String studyStyle;
    private String visitorsFrequency;
    private Boolean smoking;
    private Boolean drinking;
    private String sleepTime;
    private String wakeTime;

    public HabitProfile() {}

    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getStudyStyle() {
        return studyStyle;
    }

    public String getVisitorsFrequency() {
        return visitorsFrequency;
    }

    public Boolean getSmoking() {
        return smoking;
    }

    public Boolean getDrinking() {
        return drinking;
    }

    public String getSleepTime() {
        return sleepTime;
    }

    public String getWakeTime() {
        return wakeTime;
    }
}
