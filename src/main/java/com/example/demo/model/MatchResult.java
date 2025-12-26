package com.example.demo.model;

public class MatchResult {
    private Long student1;
    private Long student2;
    private double score;

    public MatchResult(Long student1, Long student2, double score) {
        this.student1 = student1;
        this.student2 = student2;
        this.score = score;
    }

    public Long getStudent1() {
        return student1;
    }
    public Long getStudent2() {
        return student2;
    }
    public double getScore() {
        return score;
    }
}
