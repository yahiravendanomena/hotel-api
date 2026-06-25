package com.example.hotelapi.controller;

import com.example.hotelapi.entity.Rol;
import com.example.hotelapi.repository.RolRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@Tag(name = "Roles", description = "Gestión de roles y permisos del sistema")
public class RolController {

    private final RolRepository rolRepository;

    public RolController(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @GetMapping
    @Operation(summary = "Listar roles", description = "Obtiene todos los roles registrados en el sistema")
    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Crear rol", description = "Registra un nuevo rol para control de acceso")
    public Rol crear(@RequestBody Rol rol) {
        return rolRepository.save(rol);
    }
}