package com.example.OnlineStore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(request ->
                        request
                                .requestMatchers("/user/registration", "/login", "/logout").permitAll()
                                .requestMatchers("/order/create", "/user/current", "/order/current", "/product/search/**", "/product/cat/**", "/product/all").hasRole("USER")
                                .requestMatchers("/order/all", "/user/all", "/user/get/**", "/order/get/**", "/product/add").hasRole("ADMIN")
                                .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .csrf().disable();
        return http.build();
    }
}


