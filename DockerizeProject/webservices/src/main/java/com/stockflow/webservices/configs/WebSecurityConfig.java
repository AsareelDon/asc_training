package com.stockflow.webservices.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.stockflow.webservices.utility.JwtUtil;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtUtil jwtUtil;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests((auth) -> auth
                .requestMatchers("/").permitAll()
                .requestMatchers("/signup").permitAll()
                .requestMatchers("/signin").permitAll()
                .requestMatchers("/api/v1/**").authenticated()
                .anyRequest().permitAll()
            )
            .csrf((csrf) -> csrf.disable())
            .httpBasic((basic) -> basic.disable())
            .sessionManagement((session) -> session.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS
            ))
            .addFilterBefore(
                new JwtAuthenticationFilter(jwtUtil), 
                UsernamePasswordAuthenticationFilter.class
            )
            .build();
    }
}
