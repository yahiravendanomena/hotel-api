package com.example.hotelapi.service;

import com.example.hotelapi.entity.Habitacion;
import com.example.hotelapi.repository.HabitacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionService {

    private final HabitacionRepository repository;

    public HabitacionService(HabitacionRepository repository) {
        this.repository = repository;
    }

    public List<Habitacion> listar() {
        return repository.findAll();
    }

    public Habitacion guardar(Habitacion habitacion) {
        return repository.save(habitacion);
    }

    public Habitacion buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

}