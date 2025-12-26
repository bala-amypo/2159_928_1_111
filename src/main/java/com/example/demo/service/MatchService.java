package com.example.demo.service;

import java.util.List;
import com.example.demo.model.MatchResult;

public interface MatchService {

    MatchResult computeMatch(Long student1Id, Long student2Id);

    List<MatchResult> getMatchesFor(Long studentId);

    MatchResult getById(Long matchId);
}
