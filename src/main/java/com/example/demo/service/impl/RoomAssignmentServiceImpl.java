package com.example.demo.service.impl;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    @Autowired
    private RoomAssignmentRecordRepository repo;

    @Override
    public RoomAssignmentRecord assignRoom(RoomAssignmentRecord record) {
        return repo.save(record);
    }

    @Override
    public List<RoomAssignmentRecord> getRoomsByStudentId(Long studentId) {
        // This uses the derived query in the repository
        return repo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public Optional<RoomAssignmentRecord> getRoomById(Long id) {
        return repo.findById(id);
    }
}
