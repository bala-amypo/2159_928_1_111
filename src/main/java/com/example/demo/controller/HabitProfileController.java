package com.example.demo.controller;

import com.example.demo.dto.HabitProfileDto;
import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/habits")
@Tag(name = "Habit Profiles", description = "Habit profile management")
public class HabitProfileController {

    private final HabitProfileService habitProfileService;

    public HabitProfileController(HabitProfileService habitProfileService) {
        this.habitProfileService = habitProfileService;
    }

    @PostMapping("/{studentId}")
    public ResponseEntity<HabitProfile> createOrUpdateProfile(@PathVariable Long studentId, 
                                                             @Valid @RequestBody HabitProfileDto dto) {
        HabitProfile profile = habitProfileService.createOrUpdate(studentId, dto);
        return ResponseEntity.ok(profile);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<HabitProfile> getProfile(@PathVariable Long studentId) {
        HabitProfile profile = habitProfileService.getForStudent(studentId);
        return ResponseEntity.ok(profile);
    }
}