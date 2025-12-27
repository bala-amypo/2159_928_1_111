package com.example.demo.controller; 

import com.example.demo.model.StudentProfile; 
import com.example.demo.service.StudentProfileService; 
import org.springframework.hƩp.ResponseEnƟty; 
import org.springframework.web.bind.annotaƟon.*; 

import java.uƟl.List; 

@RestController 
@RequestMapping("/api/students") 
public class StudentProfileController { 
     
    private final StudentProfileService studentService; 

    public StudentProfileController(StudentProfileService studentService) { 
        this.studentService = studentService; 
    } 

    @PostMapping 
    public ResponseEnƟty<StudentProfile> create(@RequestBody StudentProfile student) { 
        StudentProfile created = studentService.createStudent(student); 
        return ResponseEnƟty.ok(created); 
    } 

    @GetMapping("/{id}") 
    public ResponseEnƟty<StudentProfile> getById(@PathVariable Long id) { 
        StudentProfile student = studentService.getStudentById(id); 
        return ResponseEnƟty.ok(student); 
    } 

    @GetMapping 
    public ResponseEnƟty<List<StudentProfile>> getAll() { 
        List<StudentProfile> students = studentService.getAllStudents(); 
        return ResponseEnƟty.ok(students); 
    } 

    @PutMapping("/{id}/status") 
    public ResponseEnƟty<StudentProfile> updateStatus(@PathVariable Long id, @RequestParam Boolean acƟve) { 
        StudentProfile updated = studentService.updateStudentStatus(id, acƟve); 
        return ResponseEnƟty.ok(updated); 
    } 

    @GetMapping("/lookup/{studentId}") 
    public ResponseEnƟty<StudentProfile> lookupByStudentId(@PathVariable String studentId) { 
        return studentService.findByStudentId(studentId) 
                .map(ResponseEnƟty::ok) 
                .orElse(ResponseEnƟty.notFound().build()); 
    } 
} 
