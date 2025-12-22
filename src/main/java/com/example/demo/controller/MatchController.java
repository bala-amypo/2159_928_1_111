package com.example.demo.controller;

import com.example.demo.model.MatchResult;
import com.example.demo.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService service;

    public MatchController(MatchService service) {
        this.service = service;
    }

    @PostMapping("/compute")
    public MatchResult compute(@RequestParam Long a,
                               @RequestParam Long b) {
        return service.computeMatch(a, b);
    }

    @GetMapping("/student/{studentId}")
    public List<MatchResult> getForStudent(@PathVariable Long studentId) {
        return service.getMatchesFor(studentId);
    }

    @GetMapping("/{id}")
    public MatchResult get(@PathVariable Long id) {
        return service.getById(id);
    }
}
