package com.example.demo.service.impl; 

import com.example.demo.exception.ResourceNotFoundException; 
import com.example.demo.model.MatchAƩemptRecord; 
import com.example.demo.repository.MatchAƩemptRecordRepository; 
import com.example.demo.service.MatchAƩemptService; 
import org.springframework.stereotype.Service; 

import java.uƟl.List; 

@Service 
public class MatchAƩemptServiceImpl implements MatchAƩemptService { 

    private final MatchAƩemptRecordRepository aƩemptRepo; 

    public MatchAƩemptServiceImpl(MatchAƩemptRecordRepository aƩemptRepo) { 
        this.aƩemptRepo = aƩemptRepo; 
    } 

    @Override 
    public MatchAƩemptRecord logMatchAƩempt(MatchAƩemptRecord aƩempt) { 
        return aƩemptRepo.save(aƩempt); 
    } 

    @Override 
    public MatchAƩemptRecord updateAƩemptStatus(Long id, String status) { 
        MatchAƩemptRecord aƩempt = aƩemptRepo.findById(id) 
                .orElseThrow(() -> new ResourceNotFoundException("Match aƩempt not found")); 
        aƩempt.setStatus(status); 
        return aƩemptRepo.save(aƩempt); 
    } 

    @Override 
    public List<MatchAƩemptRecord> getAƩemptsByStudent(Long studentId) { 
        return aƩemptRepo.findByStudentId(studentId); 
    } 

    @Override 
    public MatchAƩemptRecord getAƩemptById(Long id) { 
        return aƩemptRepo.findById(id) 
                .orElseThrow(() -> new ResourceNotFoundException("Match aƩempt not found")); 
    } 

    @Override 
    public List<MatchAƩemptRecord> getAllMatchAƩempts() { 
        return aƩemptRepo.findAll(); 
    } 
} 
