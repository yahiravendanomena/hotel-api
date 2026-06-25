package com.example.hotelapi.controller;

import com.example.hotelapi.entity.Habitacion;
import com.example.hotelapi.service.HabitacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
@Tag(name = "Habitaciones", description = "Gestión de habitaciones o cuartos del hotel")
public class HabitacionController {

    private final HabitacionService service;

    public HabitacionController(HabitacionService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar habitaciones", description = "Obtiene todas las habitaciones registradas")
    public List<Habitacion> listar() {
        return service.listar();
    }

    @PostMapping
    @Operation(summary = "Crear habitación", description = "Registra una nueva habitación")
    public Habitacion guardar(@RequestBody Habitacion habitacion) {
        return service.guardar(habitacion);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar habitación", description = "Busca una habitación por su identificador")
    public Habitacion buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar habitación", description = "Elimina una habitación por ID")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}