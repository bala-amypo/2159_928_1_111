package com.example.demo.controller;

import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-profiles")
public class StudentProfileController {

    @Autowired
    private StudentProfileService studentProfileService;

    @PostMapping
    public ResponseEntity<StudentProfile> createStudentProfile(
            @RequestBody StudentProfile studentProfile) {
        return ResponseEntity.ok(
                studentProfileService.createStudentProfile(studentProfile)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getStudentProfile(@PathVariable Long id) {
        return studentProfileService.getStudentProfileById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<StudentProfile>> getAllStudentProfiles() {
        return ResponseEntity.ok(
                studentProfileService.getAllStudentProfiles()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentProfile(@PathVariable Long id) {
        studentProfileService.deleteStudentProfile(id);
        return ResponseEntity.noContent().build();
    }
}
