package com.example.demo.dto;

public class HabitProfileDto {
    private Long studentId;
    private Integer studyHoursPerDay;

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public Integer getStudyHoursPerDay() { return studyHoursPerDay; }
    public void setStudyHoursPerDay(Integer studyHoursPerDay) {
        this.studyHoursPerDay = studyHoursPerDay;
    }
}
