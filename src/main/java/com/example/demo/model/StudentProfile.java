package com.example.demo.model; 

import jakarta.persistence.*; 

@Entity 
public class StudentProfile { 

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 

    private String studentId; 
    private String name; 
    private Integer age; 
    private String course; 
    private Integer yearOfStudy; 
    private String gender; 
    private String roomTypePreference; 
    private Boolean acƟve; 

    public StudentProfile() {} 

    public Long getId() { return id; } 
    public void setId(Long id) { this.id = id; } 

    public String getStudentId() { return studentId; } 
    public void setStudentId(String studentId) { this.studentId = studentId; } 

    public String getName() { return name; } 
    public void setName(String name) { this.name = name; } 

    public Integer getAge() { return age; } 
    public void setAge(Integer age) { this.age = age; } 

    public String getCourse() { return course; } 
    public void setCourse(String course) { this.course = course; } 

    public Integer getYearOfStudy() { return yearOfStudy; } 
    public void setYearOfStudy(Integer yearOfStudy) { this.yearOfStudy = yearOfStudy; } 

    public String getGender() { return gender; } 
    public void setGender(String gender) { this.gender = gender; } 

    public String getRoomTypePreference() { return roomTypePreference; } 
    public void setRoomTypePreference(String roomTypePreference) { this.roomTypePreference = roomTypePreference; } 

    public Boolean getAcƟve() { return acƟve; } 
    public void setAcƟve(Boolean acƟve) { this.acƟve = acƟve; } 
} 
