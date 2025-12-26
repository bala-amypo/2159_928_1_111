package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomAssignmentController {

    @PostMapping
    public String assignRoom() {
        return "Room assigned";
    }

    @GetMapping
    public String getRooms() {
        return "Room list";
    }
}
