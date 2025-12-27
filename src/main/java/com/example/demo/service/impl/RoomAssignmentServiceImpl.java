package com.example.demo.service.impl; 

import com.example.demo.exception.ResourceNotFoundException; 
import com.example.demo.model.RoomAssignmentRecord; 
import com.example.demo.repository.RoomAssignmentRecordRepository; 
import com.example.demo.service.RoomAssignmentService; 
import org.springframework.stereotype.Service; 

import java.uƟl.List; 

@Service 
public class RoomAssignmentServiceImpl implements RoomAssignmentService { 

    private final RoomAssignmentRecordRepository assignmentRepo; 

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository assignmentRepo) { 
        this.assignmentRepo = assignmentRepo; 
    } 

    @Override 
    public RoomAssignmentRecord assignRoom(RoomAssignmentRecord assignment) { 
        return assignmentRepo.save(assignment); 
    } 

    @Override 
    public RoomAssignmentRecord updateStatus(Long id, String status) { 
        RoomAssignmentRecord assignment = assignmentRepo.findById(id) 
                .orElseThrow(() -> new ResourceNotFoundException("Room assignment not found")); 
        assignment.setStatus(status); 
        return assignmentRepo.save(assignment); 
    } 

    @Override 
    public List<RoomAssignmentRecord> getAssignmentsByStudent(Long studentId) { 
        return assignmentRepo.findByStudentId(studentId); 
    } 

    @Override 
    public RoomAssignmentRecord getAssignmentById(Long id) { 
        return assignmentRepo.findById(id) 
                .orElseThrow(() -> new ResourceNotFoundException("Room assignment not found")); 
    } 

    @Override 
    public List<RoomAssignmentRecord> getAllAssignments() { 
        return assignmentRepo.findAll(); 
    } 
} 
