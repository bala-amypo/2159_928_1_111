package com.example.demo.exception; 

import org.springframework.hƩp.HttpStatus; 
import org.springframework.hƩp.ResponseEnƟty; 
import org.springframework.web.bind.MethodArgumentNotValidException; 
import org.springframework.web.bind.annotaƟon.ControllerAdvice; 
import org.springframework.web.bind.annotaƟon.ExcepƟonHandler; 

import java.uƟl.HashMap; 
import java.uƟl.Map; 

@ControllerAdvice 
public class ApiExceptionHandler { 

    @ExcepƟonHandler(MethodArgumentNotValidException.class) 
    public ResponseEnƟty<Map<String, String>> handleValidaƟonErrors(MethodArgumentNotValidException ex) { 
        Map<String, String> errors = new HashMap<>(); 
        ex.getBindingResult().getFieldErrors().forEach(error -> 
                errors.put(error.getField(), error.getDefaultMessage())); 
        return new ResponseEnƟty<>(errors, HttpStatus.BAD_REQUEST); 
    } 

    @ExcepƟonHandler(ResourceNotFoundException.class) 
    public ResponseEnƟty<String> handleNotFound(ResourceNotFoundException ex) { 
        return new ResponseEnƟty<>(ex.getMessage(), HttpStatus.NOT_FOUND); 
    } 

    @ExcepƟonHandler(ExcepƟon.class) 
    public ResponseEnƟty<String> handleGeneric(ExcepƟon ex) { 
        return new ResponseEnƟty<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); 
    } 
} 
