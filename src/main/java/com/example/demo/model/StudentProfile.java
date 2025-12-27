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

    @Enumerated(EnumType.STRING)
    private RoomTypePreference roomTypePreference;

    public enum RoomTypePreference {
        SINGLE, SHARED
    }

    public StudentProfile() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public RoomTypePreference getRoomTypePreference() {
        return roomTypePreference;
    }

    public void setRoomTypePreference(RoomTypePreference roomTypePreference) {
        this.roomTypePreference = roomTypePreference;
    }
}
