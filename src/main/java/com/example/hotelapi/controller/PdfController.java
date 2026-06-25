package com.example.hotelapi.controller;

import com.example.hotelapi.service.PdfService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pdf")
@Tag(name = "PDF", description = "Generación de reportes en formato PDF")
public class PdfController {

    private final PdfService pdfService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping("/reservaciones")
    @Operation(summary = "Generar PDF de reservaciones", description = "Genera un reporte PDF con todas las reservaciones registradas")
    public ResponseEntity<byte[]> generarPdfReservaciones() {

        byte[] pdf = pdfService.generarReporteReservaciones();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reservaciones.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}