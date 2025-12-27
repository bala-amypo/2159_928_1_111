package com.example.demo.service;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoomAssignmentService {

    private final RoomAssignmentRecordRepository repo;

    public RoomAssignmentService(RoomAssignmentRecordRepository repo) { this.repo = repo; }

    public RoomAssignmentRecord createOrUpdateAssignment(RoomAssignmentRecord record) {
        return repo.save(record);
    }

    public Optional<RoomAssignmentRecord> getAssignmentById(Long id) {
        return repo.findById(id);
    }

    public List<RoomAssignmentRecord> getAssignmentsByStudent(Long studentId) {
        return repo.findByStudentAIdOrStudentBId(studentId, studentId);
    }
}
