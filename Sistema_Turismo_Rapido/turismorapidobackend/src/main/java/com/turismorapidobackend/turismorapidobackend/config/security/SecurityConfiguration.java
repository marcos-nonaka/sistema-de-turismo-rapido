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
                // .requestMatchers(HttpMethod.GET, "/clients").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/roteiros").permitAll()
                .requestMatchers(HttpMethod.GET, "/cidades").permitAll()
                .requestMatchers(HttpMethod.GET, "/hoteis").permitAll()
                .requestMatchers(HttpMethod.GET, "/atracoes").permitAll()
                .requestMatchers(HttpMethod.GET, "/alimentacao").permitAll()
                .requestMatchers(HttpMethod.POST, "/clients").permitAll()
                .requestMatchers(HttpMethod.POST, "/roteiros").hasAnyRole("ADMIN", "TURISMOLOGO")
                .requestMatchers(HttpMethod.POST, "/cidades").hasAnyRole("ADMIN", "TURISMOLOGO")
                .requestMatchers(HttpMethod.POST, "/hoteis").hasAnyRole("ADMIN", "TURISMOLOGO")
                .requestMatchers(HttpMethod.POST, "/atracoes").hasAnyRole("ADMIN", "TURISMOLOGO")
                .requestMatchers(HttpMethod.POST, "/alimentacao").hasAnyRole("ADMIN", "TURISMOLOGO")
                .requestMatchers(HttpMethod.DELETE, "/roteiros").hasAnyRole("ADMIN", "TURISMOLOGO")
                .requestMatchers(HttpMethod.DELETE, "/cidades").hasAnyRole("ADMIN", "TURISMOLOGO")
                .requestMatchers(HttpMethod.DELETE, "/hoteis").hasAnyRole("ADMIN", "TURISMOLOGO")
                .requestMatchers(HttpMethod.DELETE, "/atracoes").hasAnyRole("ADMIN", "TURISMOLOGO")
                .requestMatchers(HttpMethod.DELETE, "/alimentacao").hasAnyRole("ADMIN", "TURISMOLOGO")
                // .requestMatchers(HttpMethod.POST, "/clients").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/quatour/**").authenticated()
                .anyRequest().hasAnyRole("ADMIN");
        http.csrf().disable();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}