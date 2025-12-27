package com.example.demo.controller; 
 
import com.example.demo.model.HabitProfile; 
import com.example.demo.service.HabitProfileService; 
import org.springframework.h p.ResponseEn ty; 
import org.springframework.web.bind.annota on.*; 
 
import java.u l.List; 
 
@RestController 
@RequestMapping("/api/habits") 
public class HabitProfileController { 
     
    private final HabitProfileService habitService; 
 
    public HabitProfileController(HabitProfileService habitService) { 
        this.habitService = habitService; 
    } 
 
    @PostMapping 
    public ResponseEn ty<HabitProfile> create(@RequestBody HabitProfile habit) { 
        HabitProfile created = habitService.createOrUpdateHabit(habit); 
        return ResponseEn ty.ok(created); 
    } 
 
    @GetMapping("/student/{studentId}") 
    public ResponseEn ty<HabitProfile> getByStudent(@PathVariable Long studentId) { 
        HabitProfile habit = habitService.getHabitByStudent(studentId); 
        return ResponseEn ty.ok(habit); 
    } 
 
    @GetMapping("/{id}") 
    public ResponseEn ty<HabitProfile> getById(@PathVariable Long id) { 
        return habitService.getHabitById(id) 
                .map(ResponseEn ty::ok) 
                .orElse(ResponseEn ty.notFound().build()); 
    } 
 
    @GetMapping 
    public ResponseEn ty<List<HabitProfile>> getAll() { 
        List<HabitProfile> habits = habitService.getAllHabitProfiles(); 
        return ResponseEn ty.ok(habits); 
    } 
}