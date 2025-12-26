package com.example.demo.controller;

import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping
    public StudentProfile createStudent(@RequestBody StudentProfile student) {
        return service.createStudent(student);
    }

    @GetMapping("/{id}")
    public StudentProfile getStudentById(@PathVariable Long id) {
        return service.getStudentById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @GetMapping
    public List<StudentProfile> getAllStudents() {
        return service.getAllStudents();
    }

    @PutMapping("/{id}/status")
    public StudentProfile updateStudentStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateStudentStatus(id, active);
    }
}
