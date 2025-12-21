package com.example.demo.controller;

import com.example.demo.dto.StudentProfileDto;
import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student Profiles", description = "Student profile management")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    @PostMapping
    public ResponseEntity<StudentProfile> createProfile(@Valid @RequestBody StudentProfileDto dto, 
                                                       @RequestParam Long userId) {
        StudentProfile profile = studentProfileService.createProfile(dto, userId);
        return ResponseEntity.ok(profile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentProfile> updateProfile(@PathVariable Long id, 
                                                       @Valid @RequestBody StudentProfileDto dto) {
        StudentProfile profile = studentProfileService.updateProfile(id, dto);
        return ResponseEntity.ok(profile);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getProfile(@PathVariable Long id) {
        StudentProfile profile = studentProfileService.getProfile(id);
        return ResponseEntity.ok(profile);
    }

    @GetMapping
    public ResponseEntity<List<StudentProfile>> getAllProfiles() {
        List<StudentProfile> profiles = studentProfileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }
}