package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitProfileController {

    @Autowired
    private HabitProfileService habitProfileService;

    @PostMapping
    public HabitProfile createHabit(@RequestBody HabitProfile habit) {
        return habitProfileService.createHabit(habit);
    }

    @GetMapping("/{id}")
    public HabitProfile getHabitById(@PathVariable Long id) {
        return habitProfileService.getHabitById(id);
    }

    @GetMapping
    public List<HabitProfile> getAllHabits() {
        return habitProfileService.getAllHabits();
    }
}
