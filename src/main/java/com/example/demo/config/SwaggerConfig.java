package com.example.demo.config; 
 
import io.swagger.v3.oas.models.OpenAPI; 
import io.swagger.v3.oas.models.info.Info; 
import io.swagger.v3.oas.models.servers.Server; 
import io.swagger.v3.oas.models.security.SecurityRequirement; 
import io.swagger.v3.oas.models.security.SecurityScheme; 
import org.springframework.context.annota on.Bean; 
import org.springframework.context.annota on.Configura on; 
 
import java.u l.List; 
 
@Configura on 
public class SwaggerConfig { 
 
    private sta c final String SECURITY_SCHEME_NAME = "BearerAuth"; 
 
    @Bean 
    public OpenAPI api() { 
        return new OpenAPI() 
                .servers(List.of( 
                        new Server() 
                                .url("h ps://9096.32procr.amypo.ai") 
                                .descrip on("Local Development Server") 
                )) 
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME)) 
                .components(new io.swagger.v3.oas.models.Components() 
                        .addSecuritySchemes(SECURITY_SCHEME_NAME, 
                                new SecurityScheme() 
                                        .name("Authoriza on") 
                                        .type(SecurityScheme.Type.HTTP) 
                                        .scheme("bearer") 
                                        .bearerFormat("JWT") 
                        )) 
                .info(new Info() 
                        . tle("Hostel Roommate Compa bility Matcher API") 
                        .descrip on("API for matching hostel roommates based on compa bility") 
                        .version("1.0")); 
    } 
}