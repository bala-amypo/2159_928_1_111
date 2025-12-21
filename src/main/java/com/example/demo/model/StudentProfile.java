package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_account_id", unique = true)
    private UserAccount userAccount;

    @NotBlank
    private String name;

    @Min(value = 1, message = "Age must be > 0")
    private Integer age;

    private String course;
    private Integer yearOfStudy;
    private String gender;

    @Enumerated(EnumType.STRING)
    private RoomType roomTypePreference;

    private LocalTime sleepTime;
    private LocalTime wakeTime;
    private Boolean smoking;
    private Boolean drinking;
    private Integer noiseTolerance;
    private String studyTime;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public StudentProfile() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserAccount getUserAccount() { return userAccount; }
    public void setUserAccount(UserAccount userAccount) { this.userAccount = userAccount; }

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

    public RoomType getRoomTypePreference() { return roomTypePreference; }
    public void setRoomTypePreference(RoomType roomTypePreference) { this.roomTypePreference = roomTypePreference; }

    public LocalTime getSleepTime() { return sleepTime; }
    public void setSleepTime(LocalTime sleepTime) { this.sleepTime = sleepTime; }

    public LocalTime getWakeTime() { return wakeTime; }
    public void setWakeTime(LocalTime wakeTime) { this.wakeTime = wakeTime; }

    public Boolean getSmoking() { return smoking; }
    public void setSmoking(Boolean smoking) { this.smoking = smoking; }

    public Boolean getDrinking() { return drinking; }
    public void setDrinking(Boolean drinking) { this.drinking = drinking; }

    public Integer getNoiseTolerance() { return noiseTolerance; }
    public void setNoiseTolerance(Integer noiseTolerance) { this.noiseTolerance = noiseTolerance; }

    public String getStudyTime() { return studyTime; }
    public void setStudyTime(String studyTime) { this.studyTime = studyTime; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}