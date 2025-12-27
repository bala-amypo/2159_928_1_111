package com.example.demo.controller; 

import com.example.demo.model.MatchAƩemptRecord; 
import com.example.demo.service.MatchAƩemptService; 
import org.springframework.hƩp.ResponseEnƟty; 
import org.springframework.web.bind.annotaƟon.*; 

import java.uƟl.List; 

@RestController 
@RequestMapping("/api/match-aƩempts") 
public class MatchAƩemptController { 
     
    private final MatchAƩemptService aƩemptService; 

    public MatchAƩemptController(MatchAƩemptService aƩemptService) { 
        this.aƩemptService = aƩemptService; 
    } 

    @PostMapping 
    public ResponseEnƟty<MatchAƩemptRecord> log(@RequestBody MatchAƩemptRecord aƩempt) { 
        MatchAƩemptRecord logged = aƩemptService.logMatchAƩempt(aƩempt); 
        return ResponseEnƟty.ok(logged); 
    } 

    @PutMapping("/{id}/status") 
    public ResponseEnƟty<MatchAƩemptRecord> updateStatus(@PathVariable Long id, @RequestParam String status) { 
        MatchAƩemptRecord updated = aƩemptService.updateAƩemptStatus(id, status); 
        return ResponseEnƟty.ok(updated); 
    } 

    @GetMapping("/student/{studentId}") 
    public ResponseEnƟty<List<MatchAƩemptRecord>> getByStudent(@PathVariable Long studentId) { 
        List<MatchAƩemptRecord> aƩempts = aƩemptService.getAƩemptsByStudent(studentId); 
        return ResponseEnƟty.ok(aƩempts); 
    } 

    @GetMapping("/{id}") 
    public ResponseEnƟty<MatchAƩemptRecord> getById(@PathVariable Long id) { 
        MatchAƩemptRecord aƩempt = aƩemptService.getAƩemptById(id); 
        return ResponseEnƟty.ok(aƩempt); 
    } 

    @GetMapping 
    public ResponseEnƟty<List<MatchAƩemptRecord>> getAll() { 
        List<MatchAƩemptRecord> aƩempts = aƩemptService.getAllMatchAƩempts(); 
        return ResponseEnƟty.ok(aƩempts); 
    } 
} 
