package com.aldomarassolin.blog_api.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/swagger-ui.html", "/v3/api-docs/**", "/webjars/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .csrf(csrf -> csrf.disable()); // Desabilitar CSRF apenas para desenvolvimento
//        return http.build();
//    }
//}
