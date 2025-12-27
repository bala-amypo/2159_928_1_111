package com.example.demo.security; 

import io.jsonwebtoken.Claims; 
import io.jsonwebtoken.Jwts; 
import io.jsonwebtoken.SignatureAlgorithm; 
import org.springframework.stereotype.Component; 

import java.uƟl.Date; 
import java.uƟl.HashMap; 
import java.uƟl.Map; 
import java.uƟl.funcƟon.FuncƟon; 

@Component 
public class JwtUƟl { 

    private final String SECRET_KEY = "secret_key_example"; 

    public String extractUsername(String token) { 
        return extractClaim(token, Claims::getSubject); 
    } 

    public Date extractExpiration(String token) { 
        return extractClaim(token, Claims::getExpiration); 
    } 

    public <T> T extractClaim(String token, FuncƟon<Claims, T> claimsResolver) { 
        final Claims claims = extractAllClaims(token); 
        return claimsResolver.apply(claims); 
    } 

    private Claims extractAllClaims(String token) { 
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody(); 
    } 

    private Boolean isTokenExpired(String token) { 
        return extractExpiration(token).before(new Date()); 
    } 

    public String generateToken(String username, String role, String email, String userId) { 
        Map<String, Object> claims = new HashMap<>(); 
        claims.put("role", role); 
        claims.put("email", email); 
        claims.put("userId", userId); 
        return createToken(claims, username); 
    } 

    private String createToken(Map<String, Object> claims, String subject) { 
        return Jwts.builder() 
                .setClaims(claims) 
                .setSubject(subject) 
                .setIssuedAt(new Date(System.currentTimeMillis())) 
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) 
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) 
                .compact(); 
    } 

    public Boolean validateToken(String token, String username) { 
        final String extractedUsername = extractUsername(token); 
        return (extractedUsername.equals(username) && !isTokenExpired(token)); 
    } 
} 
