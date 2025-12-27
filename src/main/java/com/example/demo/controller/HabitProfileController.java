package com.example.demo.controller; 

import com.example.demo.model.HabitProfile; 
import com.example.demo.service.HabitProfileService; 
import org.springframework.hƩp.ResponseEnƟty; 
import org.springframework.web.bind.annotaƟon.*; 

import java.uƟl.List; 

@RestController 
@RequestMapping("/api/habits") 
public class HabitProfileController { 
     
    private final HabitProfileService habitService; 

    public HabitProfileController(HabitProfileService habitService) { 
        this.habitService = habitService; 
    } 

    @PostMapping 
    public ResponseEnƟty<HabitProfile> create(@RequestBody HabitProfile habit) { 
        HabitProfile created = habitService.createOrUpdateHabit(habit); 
        return ResponseEnƟty.ok(created); 
    } 

    @GetMapping("/student/{studentId}") 
    public ResponseEnƟty<HabitProfile> getByStudent(@PathVariable Long studentId) { 
        HabitProfile habit = habitService.getHabitByStudent(studentId); 
        return ResponseEnƟty.ok(habit); 
    } 

    @GetMapping("/{id}") 
    public ResponseEnƟty<HabitProfile> getById(@PathVariable Long id) { 
        return habitService.getHabitById(id) 
                .map(ResponseEnƟty::ok) 
                .orElse(ResponseEnƟty.notFound().build()); 
    } 

    @GetMapping 
    public ResponseEnƟty<List<HabitProfile>> getAll() { 
        List<HabitProfile> habits = habitService.getAllHabitProfiles(); 
        return ResponseEnƟty.ok(habits); 
    } 
} 
