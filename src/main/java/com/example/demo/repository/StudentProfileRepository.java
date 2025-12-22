package com.example.demo.repository;

import com.example.demo.model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {

    // Used when creating profile from userId
    Optional<StudentProfile> findByUserAccountId(Long userId);
}
