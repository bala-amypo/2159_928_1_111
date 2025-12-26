package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RoomAssignmentService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository assignmentRepository;
    private final StudentProfileRepository studentRepository;

    public RoomAssignmentServiceImpl(
            RoomAssignmentRecordRepository assignmentRepository,
            StudentProfileRepository studentRepository) {
        this.assignmentRepository = assignmentRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public RoomAssignmentRecord assignRoom(Long studentId, String roomNumber) {

        StudentProfile student = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        RoomAssignmentRecord record = new RoomAssignmentRecord();
        record.setStudentId(student.getStudentId());
        record.setRoomNumber(roomNumber);

        return assignmentRepository.save(record);
    }

    @Override
    public RoomAssignmentRecord getById(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assignment not found"));
    }

    @Override
    public List<RoomAssignmentRecord> getAssignmentsForStudent(Long studentId) {
        return assignmentRepository.findByStudentId(studentId);
    }

    @Override
    public List<RoomAssignmentRecord> getAllAssignments() {
        return assignmentRepository.findAll();
    }
}
