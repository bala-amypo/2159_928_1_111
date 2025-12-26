package com.example.demo.service;

import com.example.demo.model.RoomAssignment;
import java.util.List;

public interface RoomAssignmentService {

    RoomAssignment assignRoom(RoomAssignment assignment);

    RoomAssignment getById(Long id);

    List<RoomAssignment> getAll();
}
