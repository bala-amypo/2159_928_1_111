package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habits")
public class HabitProfileController {

    @PostMapping
    public String saveHabit() {
        return "Habit saved";
    }

    @GetMapping
    public String getHabits() {
        return "All habits";
    }
}
