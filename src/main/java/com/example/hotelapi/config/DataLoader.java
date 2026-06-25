package com.example.hotelapi.config;

import com.example.hotelapi.entity.Rol;
import com.example.hotelapi.entity.Usuario;
import com.example.hotelapi.repository.RolRepository;
import com.example.hotelapi.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initData(
            RolRepository rolRepository,
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            Rol adminRol = rolRepository.findByNombre("ROLE_ADMIN")
                    .orElseGet(() -> rolRepository.save(
                            Rol.builder().nombre("ROLE_ADMIN").build()
                    ));

            rolRepository.findByNombre("ROLE_USUARIO")
                    .orElseGet(() -> rolRepository.save(
                            Rol.builder().nombre("ROLE_USUARIO").build()
                    ));

            if (usuarioRepository.findByUsername("admin").isEmpty()) {
                Usuario admin = Usuario.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin123"))
                        .nombre("Administrador")
                        .correo("admin@hotel.com")
                        .rol(adminRol)
                        .build();

                usuarioRepository.save(admin);
            }
        };
    }
}