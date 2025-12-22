package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private UserAccount userAccount;

    private String name;
    private int age;
    private String course;
    private int yearOfStudy;
    private String gender;
    private String roomTypePreference;

    public Long getId() { return id; }
    public UserAccount getUserAccount() { return userAccount; }
    public void setUserAccount(UserAccount userAccount) { this.userAccount = userAccount; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public void setRoomTypePreference(String r) { this.roomTypePreference = r; }
}
