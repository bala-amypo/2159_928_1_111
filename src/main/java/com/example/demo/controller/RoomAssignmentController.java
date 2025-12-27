package com.example.demo.controller;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomAssignmentController {

    @Autowired
    private RoomAssignmentService service;

    @PostMapping("/assign")
    public RoomAssignmentRecord assignRoom(@RequestBody RoomAssignmentRecord record) {
        return service.assignRoom(record);
    }

    @GetMapping("/student/{id}")
    public List<RoomAssignmentRecord> getAssignmentsByStudent(@PathVariable Long id) {
        return service.getAssignmentsByStudent(id);
    }
}
