package com.example.demo.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/hello", "/swagger-ui/**", "/v3/api-docs/**").permitAll() // public routes
                        .anyRequest().authenticated() // all others need auth
                )
                .httpBasic(Customizer.withDefaults()) // enables basic auth (username/password prompt)
                .csrf(csrf -> csrf.disable()); // disable CSRF for APIs

        return http.build();
    }
}
