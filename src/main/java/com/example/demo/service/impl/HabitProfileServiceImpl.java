package com.example.demo.service.impl;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repo;

    public HabitProfileServiceImpl(HabitProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public HabitProfile getForStudent(Long studentId) {
        return repo.findByStudentId(studentId).orElse(null);
    }

    @Override
    public HabitProfile save(HabitProfile habitProfile) {
        return repo.save(habitProfile);
    }

    @Override
    public List<HabitProfile> getAll() {
        return repo.findAll();
    }
}
