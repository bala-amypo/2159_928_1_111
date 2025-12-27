package com.example.demo.repository; 

import com.example.demo.model.RoomAssignmentRecord; 
import org.springframework.data.jpa.repository.JpaRepository; 

import java.uƟl.List; 

public interface RoomAssignmentRecordRepository extends JpaRepository<RoomAssignmentRecord, Long> { 

    List<RoomAssignmentRecord> findByStudentId(Long studentId); 
} 
