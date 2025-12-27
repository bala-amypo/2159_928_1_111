package com.example.demo.controller; 
 
import com.example.demo.model.MatchResult; 
import com.example.demo.service.MatchService; 
import io.swagger.v3.oas.annota ons.Opera on; 
import io.swagger.v3.oas.annota ons.tags.Tag; 
import org.springframework.h p.ResponseEn ty; 
import org.springframework.web.bind.annota on.*; 
 
import java.u l.List; 
 
@RestController 
@RequestMapping("/api/matches") 
@Tag(name = "Matches", descrip on = "Compa bility matching") 
public class MatchController { 
     
    private final MatchService matchService; 
 
    public MatchController(MatchService matchService) { 
        this.matchService = matchService; 
    } 
 
    @PostMapping("/compute") 
    @Opera on(summary = "Compute compa bility match between two students") 
    public ResponseEn ty<MatchResult> computeMatch(@RequestParam Long studentAId, 
                                                   @RequestParam Long studentBId) { 
        MatchResult result = matchService.computeMatch(studentAId, studentBId); 
        return ResponseEn ty.ok(result); 
    } 
 
    @GetMapping("/student/{studentId}") 
    @Opera on(summary = "Get matches for a student") 
    public ResponseEn ty<List<MatchResult>> getMatchesForStudent(@PathVariable Long studentId) { 
        List<MatchResult> matches = matchService.getMatchesFor(studentId); 
        return ResponseEn ty.ok(matches); 
    } 
 
    @GetMapping("/{id}") 
    @Opera on(summary = "Get match result by ID") 
    public ResponseEn ty<MatchResult> getMatch(@PathVariable Long id) { 
        MatchResult match = matchService.getById(id); 
        return ResponseEn ty.ok(match); 
    } 
}