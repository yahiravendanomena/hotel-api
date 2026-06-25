package com.example.hotelapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/v3/api-docs/**",
                                "/api-docs/**"
                        ).permitAll()

                        .requestMatchers("/api/habitaciones/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/api/reservaciones/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USUARIO")
                        .requestMatchers("/api/pdf/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USUARIO")
                        .requestMatchers("/api/usuarios/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/api/roles/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/api/auth/**")
                        .hasAnyAuthority("ROLE_ADMIN","ROLE_USUARIO")
                        .anyRequest().authenticated()
                )

                .formLogin(login -> login.permitAll())

                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}