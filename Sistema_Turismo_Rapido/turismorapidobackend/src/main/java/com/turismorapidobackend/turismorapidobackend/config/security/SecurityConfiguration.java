package com.turismorapidobackend.turismorapidobackend.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.httpBasic();
        http
        .authorizeHttpRequests()
        .requestMatchers(HttpMethod.GET, "/clients").hasRole("ADMIN")
        .requestMatchers(HttpMethod.GET, "/roteiros").permitAll()
        .requestMatchers(HttpMethod.GET, "/cidades").permitAll()
        .requestMatchers(HttpMethod.GET, "/hoteis").permitAll()
        .requestMatchers(HttpMethod.GET, "/atracoes").permitAll()
        .requestMatchers(HttpMethod.GET, "/alimentacao").permitAll()
        .requestMatchers(HttpMethod.POST, "/roteiros").hasRole("TURISMOLOGO")
        .requestMatchers(HttpMethod.POST, "/cidade").hasRole("TURISMOLOGO")
        .requestMatchers(HttpMethod.POST, "/hoteis").hasRole("TURISMOLOGO")
        .requestMatchers(HttpMethod.POST, "/atracoes").hasRole("TURISMOLOGO")
        .requestMatchers(HttpMethod.DELETE, "/alimentacao").hasRole("TURISMOLOGO")
        .requestMatchers(HttpMethod.DELETE, "/roteiros").hasRole("TURISMOLOGO")
        .requestMatchers(HttpMethod.DELETE, "/cidade").hasRole("TURISMOLOGO")
        .requestMatchers(HttpMethod.DELETE, "/hoteis").hasRole("TURISMOLOGO")
        .requestMatchers(HttpMethod.DELETE, "/atracoes").hasRole("TURISMOLOGO")
        .requestMatchers(HttpMethod.DELETE, "/alimentacao").hasRole("TURISMOLOGO")
        .requestMatchers(HttpMethod.POST, "/clients").hasRole("ADMIN")
        .requestMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")
        .anyRequest().authenticated();
        http.csrf().disable();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
