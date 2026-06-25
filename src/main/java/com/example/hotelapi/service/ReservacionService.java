package com.example.hotelapi.service;

import com.example.hotelapi.entity.Reservacion;
import com.example.hotelapi.repository.ReservacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservacionService {

    private final ReservacionRepository repository;
    private final EmailService emailService;

    public ReservacionService(ReservacionRepository repository, EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    public List<Reservacion> listar() {
        return repository.findAll();
    }

    public Reservacion guardar(Reservacion reservacion) {
        Reservacion nueva = repository.save(reservacion);

        emailService.enviarCorreo(
                "04menayahir@gmail.com",
                "Reservación registrada",
                "Se registró una nueva reservación para el cliente: "
                        + reservacion.getCliente()
                        + "\nFecha entrada: " + reservacion.getFechaEntrada()
                        + "\nFecha salida: " + reservacion.getFechaSalida()
        );

        return nueva;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}