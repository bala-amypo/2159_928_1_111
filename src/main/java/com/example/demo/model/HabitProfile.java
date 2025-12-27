package com.example.demo.model;

import jakarta.persistence.*;

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

    private String studyStyle;
    private String visitorsFrequency;
    private Boolean smoking;
    private Boolean drinking;
    private String sleepTime;
    private String wakeTime;

    public HabitProfile() {
    }

    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Integer getStudyHoursPerDay() {
        return studyHoursPerDay;
    }

    public String getSleepSchedule() {
        return sleepSchedule;
    }

    public Integer getCleanlinessLevel() {
        return cleanlinessLevel;
    }

    public Integer getNoiseTolerance() {
        return noiseTolerance;
    }

    public String getSocialPreference() {
        return socialPreference;
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

    public void setStudyStyle(String studyStyle) {
        this.studyStyle = studyStyle;
    }

    public void setVisitorsFrequency(String visitorsFrequency) {
        this.visitorsFrequency = visitorsFrequency;
    }

    public void setSmoking(Boolean smoking) {
        this.smoking = smoking;
    }

    public void setDrinking(Boolean drinking) {
        this.drinking = drinking;
    }

    public void setSleepTime(String sleepTime) {
        this.sleepTime = sleepTime;
    }

    public void setWakeTime(String wakeTime) {
        this.wakeTime = wakeTime;
    }
}
