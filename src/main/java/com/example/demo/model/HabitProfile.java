package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer studyHoursPerDay;

    @Enumerated(EnumType.STRING)
    private SleepSchedule sleepSchedule;

    @Enumerated(EnumType.STRING)
    private CleanlinessLevel cleanlinessLevel;

    @Enumerated(EnumType.STRING)
    private NoiseTolerance noiseTolerance;

    @Enumerated(EnumType.STRING)
    private SocialPreference socialPreference;

    private String studyStyle;
    private String visitorsFrequency;
    private Boolean smoking;
    private Boolean drinking;
    private String sleepTime;
    private String wakeTime;

    // ================= ENUMS REQUIRED BY TESTS =================

    public enum SleepSchedule {
        EARLY_BIRD,
        NIGHT_OWL
    }

    public enum CleanlinessLevel {
        LOW,
        MEDIUM,
        HIGH
    }

    public enum NoiseTolerance {
        LOW,
        MEDIUM,
        HIGH
    }

    public enum SocialPreference {
        INTROVERT,
        AMBIVERT,
        EXTROVERT
    }

    // ================= GETTERS & SETTERS =================

    public Integer getStudyHoursPerDay() {
        return studyHoursPerDay;
    }

    public void setStudyHoursPerDay(Integer studyHoursPerDay) {
        this.studyHoursPerDay = studyHoursPerDay;
    }

    public SleepSchedule getSleepSchedule() {
        return sleepSchedule;
    }

    public void setSleepSchedule(SleepSchedule sleepSchedule) {
        this.sleepSchedule = sleepSchedule;
    }

    public CleanlinessLevel getCleanlinessLevel() {
        return cleanlinessLevel;
    }

    public void setCleanlinessLevel(CleanlinessLevel cleanlinessLevel) {
        this.cleanlinessLevel = cleanlinessLevel;
    }

    public NoiseTolerance getNoiseTolerance() {
        return noiseTolerance;
    }

    public void setNoiseTolerance(NoiseTolerance noiseTolerance) {
        this.noiseTolerance = noiseTolerance;
    }

    public SocialPreference getSocialPreference() {
        return socialPreference;
    }

    public void setSocialPreference(SocialPreference socialPreference) {
        this.socialPreference = socialPreference;
    }

    public String getStudyStyle() {
        return studyStyle;
    }

    public void setStudyStyle(String studyStyle) {
        this.studyStyle = studyStyle;
    }

    public String getVisitorsFrequency() {
        return visitorsFrequency;
    }

    public void setVisitorsFrequency(String visitorsFrequency) {
        this.visitorsFrequency = visitorsFrequency;
    }

    public Boolean getSmoking() {
        return smoking;
    }

    public void setSmoking(Boolean smoking) {
        this.smoking = smoking;
    }

    public Boolean getDrinking() {
        return drinking;
    }

    public void setDrinking(Boolean drinking) {
        this.drinking = drinking;
    }

    public String getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(String sleepTime) {
        this.sleepTime = sleepTime;
    }

    public String getWakeTime() {
        return wakeTime;
    }

    public void setWakeTime(String wakeTime) {
        this.wakeTime = wakeTime;
    }
}
