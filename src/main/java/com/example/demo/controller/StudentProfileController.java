package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentProfileController {

    @PostMapping
    public String createStudent() {
        return "Student created";
    }

    @GetMapping("/{id}")
    public String getStudent(@PathVariable Long id) {
        return "Student id = " + id;
    }

    @GetMapping
    public String getAllStudents() {
        return "All students";
    }
}
