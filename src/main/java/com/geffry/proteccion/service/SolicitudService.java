package com.geffry.proteccion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.geffry.proteccion.model.Solicitud;
import com.geffry.proteccion.repository.SolicitudRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;

    public Optional<List<Solicitud>> getAllSolicitudes() {

        return Optional.ofNullable(solicitudRepository.findAll());
    }

    public Optional<List<Solicitud>> getSolicitudesPriorizadas() {

        return solicitudRepository.findAllByOrderByPrioridadManualDescFechaCreacionAsc();
    }

    public Solicitud createSolicitud(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    
}
