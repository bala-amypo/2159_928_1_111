package com.example.demo.config; 

import io.swagger.v3.oas.models.OpenAPI; 
import io.swagger.v3.oas.models.info.Info; 
import io.swagger.v3.oas.models.servers.Server; 
import io.swagger.v3.oas.models.security.SecurityRequirement; 
import io.swagger.v3.oas.models.security.SecurityScheme; 
import org.springframework.context.annotaƟon.Bean; 
import org.springframework.context.annotaƟon.ConfiguraƟon; 

import java.uƟl.List; 

@ConfiguraƟon 
public class SwaggerConfig { 

    private staƟc final String SECURITY_SCHEME_NAME = "BearerAuth"; 

    @Bean 
    public OpenAPI api() { 
        return new OpenAPI() 
                .servers(List.of( 
                        new Server() 
                                .url("hƩps://9096.32procr.amypo.ai") 
                                .descripƟon("Local Development Server") 
                )) 
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME)) 
                .components(new io.swagger.v3.oas.models.Components() 
                        .addSecuritySchemes(SECURITY_SCHEME_NAME, 
                                new SecurityScheme() 
                                        .name("AuthorizaƟon") 
                                        .type(SecurityScheme.Type.HTTP) 
                                        .scheme("bearer") 
                                        .bearerFormat("JWT") 
                        )) 
                .info(new Info() 
                        .Ɵtle("Hostel Roommate CompaƟbility Matcher API") 
                        .descripƟon("API for matching hostel roommates based on compaƟbility") 
                        .version("1.0")); 
    } 
} 
