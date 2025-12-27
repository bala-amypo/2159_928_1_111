package com.example.demo.controller;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room-assignments")
public class RoomAssignmentController {

    private final RoomAssignmentService service;

    public RoomAssignmentController(RoomAssignmentService service) {
        this.service = service;
    }

    @PostMapping("/assign")
    public RoomAssignmentRecord assignRoom(@RequestBody RoomAssignmentRecord record) {
        return service.assignRoom(
                record.getStudent().getId(),
                record.getRoomNumber()
        );
    }

    @PutMapping("/{id}/status")
    public RoomAssignmentRecord updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @GetMapping("/{id}")
    public RoomAssignmentRecord getAssignmentById(@PathVariable Long id) {
        return service.getAssignmentById(id);
    }

    @GetMapping("/student/{studentId}")
    public List<RoomAssignmentRecord> getAssignmentsByStudent(
            @PathVariable Long studentId) {
        return service.getAssignmentsByStudent(studentId);
    }

    @GetMapping
    public List<RoomAssignmentRecord> getAllAssignments() {
        return service.getAllAssignments();
    }
}
