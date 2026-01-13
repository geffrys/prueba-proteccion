package com.geffry.proteccion.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geffry.proteccion.model.Solicitud;
import com.geffry.proteccion.service.SolicitudService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/solicitudes")
@RequiredArgsConstructor
public class SolicitudController {

    private final SolicitudService solicitudService;

    // Listar solicitudes sin ponderacion
    @GetMapping
    public List<Solicitud> getSolicitudes() {
        return solicitudService.getAllSolicitudes().orElse(List.of()); 
    }

    // Listar solicitudes con ponderacion
    @GetMapping("/priorizadas")
    public List<Solicitud> getSolicitudesPriorizadas() {
        return solicitudService.getSolicitudesPriorizadas().orElse(List.of());
    }

    // Crear nueva solicitud
    @PostMapping
    public Solicitud createSolicitud(@RequestBody Solicitud solicitud) {
        return solicitudService.createSolicitud(solicitud);
    }

    // Actualizar prioridad manual de una solicitud
    @PostMapping("/{id}/prioridad")
    public String updatePrioridadManual() {
        return null;
    }

    
}
