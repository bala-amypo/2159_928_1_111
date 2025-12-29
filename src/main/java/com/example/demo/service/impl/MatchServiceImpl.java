package com.example.demo.service.impl;

import com.example.demo.model.MatchResult;
import com.example.demo.service.MatchService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final List<MatchResult> matchStore = new ArrayList<>();

    @Override
    public MatchResult calculateMatch(Long studentAId, Long studentBId) {

        MatchResult result = new MatchResult();
        result.setStudentAId(studentAId);
        result.setStudentBId(studentBId);
        result.setCompatibilityScore(75); // dummy score
        result.setStatus("MATCHED");

        matchStore.add(result);
        return result;
    }

    @Override
    public List<MatchResult> getAllMatches() {
        return matchStore;
    }
}
    