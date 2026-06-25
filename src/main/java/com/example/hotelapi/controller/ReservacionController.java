package com.example.hotelapi.controller;

import com.example.hotelapi.entity.Reservacion;
import com.example.hotelapi.service.ReservacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservaciones")
@Tag(name = "Reservaciones", description = "Gestión de reservaciones de habitaciones")
public class ReservacionController {

    private final ReservacionService service;

    public ReservacionController(ReservacionService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar reservaciones", description = "Obtiene todas las reservaciones registradas")
    public List<Reservacion> listar() {
        return service.listar();
    }

    @PostMapping
    @Operation(summary = "Crear reservación", description = "Registra una nueva reservación")
    public Reservacion guardar(@RequestBody Reservacion reservacion) {
        return service.guardar(reservacion);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Cancelar reservación", description = "Cancela una reservación por ID")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}