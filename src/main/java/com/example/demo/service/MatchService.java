package com.example.demo.service;

import com.example.demo.model.MatchResult;
import java.util.List;

public interface MatchService {

    MatchResult calculateMatch(Long studentAId, Long studentBId);

    List<MatchResult> getAllMatches();
}
