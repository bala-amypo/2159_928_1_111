package com.example.demo.service;

import com.example.demo.dto.StudentProfileDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileService {

    private final StudentProfileRepository repo;
    private final UserAccountRepository users;

    public StudentProfileService(StudentProfileRepository repo,
                                 UserAccountRepository users) {
        this.repo = repo;
        this.users = users;
    }

    public StudentProfile createProfile(StudentProfileDto dto, Long userId) {
        if (dto.age <= 0) throw new IllegalArgumentException("age");
        if (!dto.roomTypePreference.matches("SINGLE|DOUBLE|TRIPLE"))
            throw new IllegalArgumentException("room");

        UserAccount user = users.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        StudentProfile p = new StudentProfile();
        p.setUserAccount(user);
        p.setAge(dto.age);
        p.setRoomTypePreference(dto.roomTypePreference);

        return repo.save(p);
    }

    public StudentProfile updateProfile(Long id, StudentProfileDto dto) {
        StudentProfile p = getProfile(id);
        if (dto.age <= 0) throw new IllegalArgumentException("age");
        p.setAge(dto.age);
        return repo.save(p);
    }

    public StudentProfile getProfile(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    public List<StudentProfile> getAllProfiles() {
        return repo.findAll();
    }
}
