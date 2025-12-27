package com.example.demo.controller; 

import com.example.demo.model.MatchResult; 
import com.example.demo.service.MatchService; 
import io.swagger.v3.oas.annotaƟons.OperaƟon; 
import io.swagger.v3.oas.annotaƟons.tags.Tag; 
import org.springframework.hƩp.ResponseEnƟty; 
import org.springframework.web.bind.annotaƟon.*; 

import java.uƟl.List; 

@RestController 
@RequestMapping("/api/matches") 
@Tag(name = "Matches", descripƟon = "CompaƟbility matching") 
public class MatchController { 
     
    private final MatchService matchService; 

    public MatchController(MatchService matchService) { 
        this.matchService = matchService; 
    } 

    @PostMapping("/compute") 
    @OperaƟon(summary = "Compute compaƟbility match between two students") 
    public ResponseEnƟty<MatchResult> computeMatch(@RequestParam Long studentAId, 
                                                   @RequestParam Long studentBId) { 
        MatchResult result = matchService.computeMatch(studentAId, studentBId); 
        return ResponseEnƟty.ok(result); 
    } 

    @GetMapping("/student/{studentId}") 
    @OperaƟon(summary = "Get matches for a student") 
    public ResponseEnƟty<List<MatchResult>> getMatchesForStudent(@PathVariable Long studentId) { 
        List<MatchResult> matches = matchService.getMatchesFor(studentId); 
        return ResponseEnƟty.ok(matches); 
    } 

    @GetMapping("/{id}") 
    @OperaƟon(summary = "Get match result by ID") 
    public ResponseEnƟty<MatchResult> getMatch(@PathVariable Long id) { 
        MatchResult match = matchService.getById(id); 
        return ResponseEnƟty.ok(match); 
    } 
} 
