package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room-assignment")
public class RoomAssignmentController {

    @PostMapping("/{matchId}")
    public ResponseEntity<String> assignRoom(@PathVariable Long matchId) {
        return ResponseEntity.ok("Room assigned successfully for match ID: " + matchId);
    }
}
