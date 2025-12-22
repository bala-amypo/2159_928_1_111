package com.example.demo.controller;

import com.example.demo.dto.HabitProfileDto;
import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/habits")
public class HabitProfileController {

    private final HabitProfileService service;

    public HabitProfileController(HabitProfileService service) {
        this.service = service;
    }

    @PostMapping("/{studentId}")
    public HabitProfile createOrUpdate(@PathVariable Long studentId,
                                       @RequestBody HabitProfileDto dto) {
        return service.createOrUpdate(studentId, dto);
    }

    @GetMapping("/{studentId}")
    public HabitProfile get(@PathVariable Long studentId) {
        return service.getForStudent(studentId);
    }
}
