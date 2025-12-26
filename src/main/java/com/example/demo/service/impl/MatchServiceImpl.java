package com.example.demo.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.model.MatchResult;
import com.example.demo.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

    @Override
    public MatchResult computeMatch(Long student1Id, Long student2Id) {
        return new MatchResult(student1Id, student2Id, 80.0);
    }

    @Override
    public List<MatchResult> getMatchesFor(Long studentId) {
        return new ArrayList<>();
    }

    @Override
    public MatchResult getById(Long matchId) {
        return new MatchResult(matchId, matchId, 75.0);
    }
}
