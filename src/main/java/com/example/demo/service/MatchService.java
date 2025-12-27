package com.example.demo.service;

import com.example.demo.model.MatchResult;

import java.util.List;

public interface MatchService {

    MatchResult findMatch(Long studentId);

    List<MatchResult> getAllMatches();

    MatchResult getMatchById(Long id);
}
