package com.example.demo.service;

import com.example.demo.model.MatchResult;

public interface MatchService {
    MatchResult matchStudents(Long id1, Long id2);
}
