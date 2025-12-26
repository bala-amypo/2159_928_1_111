package com.example.demo.dto;

public class HabitProfileDto {
    private Long studentId;
    private String cleanlinessLevel;
    private String sleepSchedule;
    private boolean smoker;

    public Long getStudentId() {
        return studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getCleanlinessLevel() {
        return cleanlinessLevel;
    }
    public void setCleanlinessLevel(String cleanlinessLevel) {
        this.cleanlinessLevel = cleanlinessLevel;
    }

    public String getSleepSchedule() {
        return sleepSchedule;
    }
    public void setSleepSchedule(String sleepSchedule) {
        this.sleepSchedule = sleepSchedule;
    }

    public boolean isSmoker() {
        return smoker;
    }
    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }
}
