package com.example.demo.service;

import com.example.demo.model.RoomAssignmentRecord;
import java.util.List;

public interface RoomAssignmentService {

    RoomAssignmentRecord assignRoom(Long studentId, String roomNumber);

    RoomAssignmentRecord getById(Long id);

    List<RoomAssignmentRecord> getAssignmentsForStudent(Long studentId);

    List<RoomAssignmentRecord> getAllAssignments();
}
