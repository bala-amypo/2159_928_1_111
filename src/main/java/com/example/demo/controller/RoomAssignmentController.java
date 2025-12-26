package com.example.demo.controller;

import com.example.demo.model.RoomAssignment;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomAssignmentController {

    @Autowired
    private RoomAssignmentService roomAssignmentService;

    @PostMapping
    public RoomAssignment assignRoom(@RequestBody RoomAssignment assignment) {
        return roomAssignmentService.assignRoom(assignment);
    }

    @GetMapping
    public List<RoomAssignment> getAllAssignments() {
        return roomAssignmentService.getAllAssignments();
    }
}
