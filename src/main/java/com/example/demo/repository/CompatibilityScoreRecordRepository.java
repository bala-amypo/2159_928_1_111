package com.example.demo.repository;

import com.example.demo.model.CompatibilityScoreRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompatibilityScoreRecordRepository extends JpaRepository<CompatibilityScoreRecord, Long> {

    // Finds all compatibility scores where either studentAId or studentBId matches
    List<CompatibilityScoreRecord> findByStudentAIdOrStudentBId(Long studentAId, Long studentBId);
}
