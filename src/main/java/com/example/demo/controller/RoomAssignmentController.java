package com.example.demo.controller; 

import com.example.demo.model.RoomAssignmentRecord; 
import com.example.demo.service.RoomAssignmentService; 
import org.springframework.hƩp.ResponseEnƟty; 
import org.springframework.web.bind.annotaƟon.*; 

import java.uƟl.List; 

@RestController 
@RequestMapping("/api/room-assignments") 
public class RoomAssignmentController { 
     
    private final RoomAssignmentService assignmentService; 

    public RoomAssignmentController(RoomAssignmentService assignmentService) { 
        this.assignmentService = assignmentService; 
    } 

    @PostMapping 
    public ResponseEnƟty<RoomAssignmentRecord> assign(@RequestBody RoomAssignmentRecord assignment) { 
        RoomAssignmentRecord created = assignmentService.assignRoom(assignment); 
        return ResponseEnƟty.ok(created); 
    } 

    @PutMapping("/{id}/status") 
    public ResponseEnƟty<RoomAssignmentRecord> updateStatus(@PathVariable Long id, @RequestParam String status) { 
        RoomAssignmentRecord updated = assignmentService.updateStatus(id, status); 
        return ResponseEnƟty.ok(updated); 
    } 

    @GetMapping("/student/{studentId}") 
    public ResponseEnƟty<List<RoomAssignmentRecord>> getByStudent(@PathVariable Long studentId) { 
        List<RoomAssignmentRecord> assignments = assignmentService.getAssignmentsByStudent(studentId); 
        return ResponseEnƟty.ok(assignments); 
    } 

    @GetMapping("/{id}") 
    public ResponseEnƟty<RoomAssignmentRecord> getById(@PathVariable Long id) { 
        RoomAssignmentRecord assignment = assignmentService.getAssignmentById(id); 
        return ResponseEnƟty.ok(assignment); 
    } 

    @GetMapping 
    public ResponseEnƟty<List<RoomAssignmentRecord>> getAll() { 
        List<RoomAssignmentRecord> assignments = assignmentService.getAllAssignments(); 
        return ResponseEnƟty.ok(assignments); 
    } 
} 
