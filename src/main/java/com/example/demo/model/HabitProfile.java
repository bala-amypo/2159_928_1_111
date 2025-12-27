package com.example.demo.model; 

import jakarta.persistence.*; 

import java.Ɵme.LocalTime; 

@EnƟty 
public class HabitProfile { 

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 

    private Long studentId; 
    private Boolean smoking; 
    private Boolean drinking; 
    private LocalTime sleepTime; 
    private LocalTime wakeTime; 
    private Integer cleanlinessLevel; 
    private Integer noisePreference; 
    private String studyStyle; 
    private String socialPreference; 
    private String visitorsFrequency; 

    public HabitProfile() {} 

    public Long getId() { return id; } 
    public void setId(Long id) { this.id = id; } 

    public Long getStudentId() { return studentId; } 
    public void setStudentId(Long studentId) { this.studentId = studentId; } 

    public Boolean getSmoking() { return smoking; } 
    public void setSmoking(Boolean smoking) { this.smoking = smoking; } 

    public Boolean getDrinking() { return drinking; } 
    public void setDrinking(Boolean drinking) { this.drinking = drinking; } 

    public LocalTime getSleepTime() { return sleepTime; } 
    public void setSleepTime(LocalTime sleepTime) { this.sleepTime = sleepTime; } 

    public LocalTime getWakeTime() { return wakeTime; } 
    public void setWakeTime(LocalTime wakeTime) { this.wakeTime = wakeTime; } 

    public Integer getCleanlinessLevel() { return cleanlinessLevel; } 
    public void setCleanlinessLevel(Integer cleanlinessLevel) { this.cleanlinessLevel = cleanlinessLevel; } 

    public Integer getNoisePreference() { return noisePreference; } 
    public void setNoisePreference(Integer noisePreference) { this.noisePreference = noisePreference; } 

    public String getStudyStyle() { return studyStyle; } 
    public void setStudyStyle(String studyStyle) { this.studyStyle = studyStyle; } 

    public String getSocialPreference() { return socialPreference; } 
    public void setSocialPreference(String socialPreference) { this.socialPreference = socialPreference; } 

    public String getVisitorsFrequency() { return visitorsFrequency; } 
    public void setVisitorsFrequency(String visitorsFrequency) { this.visitorsFrequency = visitorsFrequency; } 
} 
