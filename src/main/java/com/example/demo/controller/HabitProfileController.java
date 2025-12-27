package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habit-profiles")
public class HabitProfileController {

    @Autowired
    private HabitProfileService habitProfileService;

    @PostMapping
    public ResponseEntity<HabitProfile> createHabitProfile(@RequestBody HabitProfile habitProfile) {
        return ResponseEntity.ok(habitProfileService.createHabitProfile(habitProfile));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitProfile> getHabitProfile(@PathVariable Long id) {
        return habitProfileService.getHabitProfileById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<HabitProfile>> getAllHabitProfiles() {
        return ResponseEntity.ok(habitProfileService.getAllHabitProfiles());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabitProfile(@PathVariable Long id) {
        habitProfileService.deleteHabitProfile(id);
        return ResponseEntity.noContent().build();
    }
}
