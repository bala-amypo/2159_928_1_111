package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String course;
    private int yearOfStudy;
    private String gender;
    private String roomTypePreference;
    private boolean active = true;

    // Constructors
    public StudentProfile() {}
    public StudentProfile(String name, int age, String course, int yearOfStudy,
                          String gender, String roomTypePreference) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.yearOfStudy = yearOfStudy;
        this.gender = gender;
        this.roomTypePreference = roomTypePreference;
        this.active = true;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public int getYearOfStudy() { return yearOfStudy; }
    public void setYearOfStudy(int yearOfStudy) { this.yearOfStudy = yearOfStudy; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getRoomTypePreference() { return roomTypePreference; }
    public void setRoomTypePreference(String roomTypePreference) { this.roomTypePreference = roomTypePreference; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
