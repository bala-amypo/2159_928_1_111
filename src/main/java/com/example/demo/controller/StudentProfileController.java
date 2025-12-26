package com.example.demo.controller;

import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentProfileController {

    @Autowired
    private StudentProfileService studentProfileService;

    @PostMapping
    public StudentProfile createStudent(@RequestBody StudentProfile student) {
        return studentProfileService.createStudent(student);
    }

    @GetMapping("/{id}")
    public StudentProfile getStudentById(@PathVariable Long id) {
        return studentProfileService.getStudentById(id);
    }

    @GetMapping
    public List<StudentProfile> getAllStudents() {
        return studentProfileService.getAllStudents();
    }

    @PutMapping("/{id}")
    public StudentProfile updateStudent(
            @PathVariable Long id,
            @RequestBody StudentProfile student) {
        return studentProfileService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentProfileService.deleteStudent(id);
    }
}
