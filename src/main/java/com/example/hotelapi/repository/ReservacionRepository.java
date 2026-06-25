package com.example.hotelapi.repository;

import com.example.hotelapi.entity.Reservacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservacionRepository extends JpaRepository<Reservacion, Long> {
}