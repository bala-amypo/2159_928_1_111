package com.example.demo.controller;

import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentProfile> create(@RequestBody StudentProfile s) {
        return ResponseEntity.ok(service.createStudent(s));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentProfile>> all() {
        return ResponseEntity.ok(service.getAllStudents());
    }
}
