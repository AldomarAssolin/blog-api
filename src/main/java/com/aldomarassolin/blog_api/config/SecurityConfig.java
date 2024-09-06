package com.aldomarassolin.blog_api.config;

import com.aldomarassolin.blog_api.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/usuarios/signup", "/api/usuarios/login", "/swagger-ui/**", "/v3/api-docs/**").permitAll() // Permite acesso público para estas rotas
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Apenas ADMIN pode acessar rotas /admin
                        .requestMatchers("/author/**").hasRole("AUTHOR") // Apenas AUTHOR pode acessar rotas /author
                        .requestMatchers("/user/**").hasRole("USER") // Apenas USER pode acessar rotas /user
                        .anyRequest().authenticated() // Exige autenticação para todas as outras rotas
                );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
