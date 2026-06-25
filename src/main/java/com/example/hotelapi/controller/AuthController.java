package com.example.hotelapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Autenticación", description = "Autenticación y seguridad")
public class AuthController {

    @PostMapping("/login")
    @Operation(summary = "Inicio de sesión")
    public Map<String,String> login(){

        return Map.of(
                "mensaje","Autenticación gestionada por Spring Security"
        );
    }

    @GetMapping("/perfil")
    @Operation(summary = "Perfil del usuario autenticado")
    public Map<String,String> perfil(){

        return Map.of(
                "usuario","admin",
                "rol","ROLE_ADMIN"
        );
    }

}