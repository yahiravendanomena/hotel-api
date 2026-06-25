package com.example.hotelapi.service;

import com.example.hotelapi.entity.Reservacion;
import com.example.hotelapi.repository.ReservacionRepository;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfService {

    private final ReservacionRepository reservacionRepository;

    public PdfService(ReservacionRepository reservacionRepository) {
        this.reservacionRepository = reservacionRepository;
    }

    public byte[] generarReporteReservaciones() {

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("REPORTE DE RESERVACIONES"));
            document.add(new Paragraph("Sistema de Gestión de Hotel"));
            document.add(new Paragraph(" "));

            List<Reservacion> reservaciones = reservacionRepository.findAll();

            for (Reservacion r : reservaciones) {
                document.add(new Paragraph("Reservación ID: " + r.getId()));
                document.add(new Paragraph("Cliente: " + r.getCliente()));
                document.add(new Paragraph("Fecha entrada: " + r.getFechaEntrada()));
                document.add(new Paragraph("Fecha salida: " + r.getFechaSalida()));

                if (r.getHabitacion() != null) {
                    document.add(new Paragraph("Habitación ID: " + r.getHabitacion().getId()));
                }

                document.add(new Paragraph("-----------------------------"));
            }

            document.close();

            return baos.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Error al generar PDF", e);
        }
    }
}