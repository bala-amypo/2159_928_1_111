package com.example.demo.repository;

import com.example.demo.model.HabitProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HabitProfileRepository extends JpaRepository<HabitProfile, Long> {

    // Ensures one habit profile per student
    Optional<HabitProfile> findByStudentId(Long studentId);
}
