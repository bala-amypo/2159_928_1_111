package com.example.demo.repository;

import com.example.demo.model.RoomAssignmentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomAssignmentRecordRepository extends JpaRepository<RoomAssignmentRecord, Long> {

    // Finds all records where either studentAId or studentBId matches
    List<RoomAssignmentRecord> findByStudentAIdOrStudentBId(Long studentAId, Long studentBId);
}
