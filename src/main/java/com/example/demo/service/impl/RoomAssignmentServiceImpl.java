package com.example.demo.service.impl;

import com.example.demo.model.RoomAssignment;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    @Override
    public RoomAssignment assignRoom(RoomAssignment assignment) {
        return assignment;
    }

    @Override
    public RoomAssignment getById(Long id) {
        return new RoomAssignment();
    }

    @Override
    public List<RoomAssignment> getAll() {
        return new ArrayList<>();
    }
}
