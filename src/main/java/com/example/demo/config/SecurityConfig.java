package com.example.demo.config; 

import com.example.demo.security.JwtAuthenƟcaƟonFilter; 
import org.springframework.context.annotaƟon.Bean; 
import org.springframework.context.annotaƟon.ConfiguraƟon; 
import org.springframework.security.authenƟcaƟon.AuthenƟcaƟonManager; 
import org.springframework.security.config.annotaƟon.authenƟcaƟon.configuraƟon.AuthenƟcaƟonConfiguraƟon; 
import org.springframework.security.config.annotaƟon.web.builders.HƩpSecurity; 
import org.springframework.security.config.annotaƟon.web.configuraƟon.EnableWebSecurity; 
import org.springframework.security.config.hƩp.SessionCreaƟonPolicy; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.security.web.SecurityFilterChain; 
import org.springframework.security.web.authenƟcaƟon.UsernamePasswordAuthenƟcaƟonFilter; 

@ConfiguraƟon 
@EnableWebSecurity 
public class SecurityConfig { 

    private final JwtAuthenƟcaƟonFilter jwtAuthenƟcaƟonFilter; 

    public SecurityConfig(JwtAuthenƟcaƟonFilter jwtAuthenƟcaƟonFilter) { 
        this.jwtAuthenƟcaƟonFilter = jwtAuthenƟcaƟonFilter; 
    } 

    @Bean 
    public SecurityFilterChain filterChain(HƩpSecurity hƩp) throws ExcepƟon { 

        hƩp 
            .csrf(csrf -> csrf.disable()) 
            .sessionManagement(session -> 
                session.sessionCreaƟonPolicy(SessionCreaƟonPolicy.STATELESS) 
            ) 
            .authorizeHƩpRequests(auth -> auth 
                .requestMatchers( 
                        "/auth/**", 
                        "/swagger-ui/**", 
                        "/v3/api-docs/**" 
                ).permitAll() 
                .requestMatchers("/api/**").authenƟcated() 
                .anyRequest().denyAll() 
            ) 
            .addFilterBefore(jwtAuthenƟcaƟonFilter, UsernamePasswordAuthenƟcaƟonFilter.class); 

        return hƩp.build(); 
    } 

    @Bean 
    public AuthenƟcaƟonManager authenƟcaƟonManager( 
            AuthenƟcaƟonConfiguraƟon config) throws ExcepƟon { 
        return config.getAuthenƟcaƟonManager(); 
    } 

    @Bean 
    public PasswordEncoder passwordEncoder() { 
        return new BCryptPasswordEncoder(); 
    } 
} 
