package com.example.demo.controller;

import com.example.demo.dto.StudentProfileDto;
import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping
    public StudentProfile create(@RequestParam Long userId,
                                 @RequestBody StudentProfileDto dto) {
        return service.createProfile(dto, userId);
    }

    @PutMapping("/{id}")
    public StudentProfile update(@PathVariable Long id,
                                 @RequestBody StudentProfileDto dto) {
        return service.updateProfile(id, dto);
    }

    @GetMapping("/{id}")
    public StudentProfile get(@PathVariable Long id) {
        return service.getProfile(id);
    }

    @GetMapping
    public List<StudentProfile> all() {
        return service.getAllProfiles();
    }
}
