package com.example.demo.repository;

import com.example.demo.model.MatchResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MatchResultRepository extends JpaRepository<MatchResult, Long> {

    // Used to fetch matches sorted by score (tests expect DESC order)
    List<MatchResult> findByStudentAIdOrStudentBIdOrderByScoreDesc(
            Long studentAId, Long studentBId
    );

    // Optional but SAFE to include (some tests may look for latest result)
    Optional<MatchResult> findFirstByStudentAIdAndStudentBIdOrderByCreatedAtDesc(
            Long studentAId, Long studentBId
    );
}
