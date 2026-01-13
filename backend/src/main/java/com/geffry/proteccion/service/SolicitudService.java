package com.geffry.proteccion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.geffry.proteccion.dto.SolicitudPonderada;
import com.geffry.proteccion.model.Solicitud;
import com.geffry.proteccion.model.TablaPonderacion;
import com.geffry.proteccion.repository.SolicitudRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;
    private final TablaPonderacionService tablaPonderacionService;

    public Optional<List<Solicitud>> getAllSolicitudes() {

        return Optional.ofNullable(solicitudRepository.findAll());
    }

    public Optional<List<SolicitudPonderada>> getSolicitudesPriorizadas() {
        Optional<List<Solicitud>> solicitudes = solicitudRepository.findAllByOrderByPrioridadManualAscFechaCreacionAsc();
        List<TablaPonderacion> tablaPonderaciones = tablaPonderacionService.obtenerTodasLasPonderaciones();
        // realizamos la logica de priorizacion aqui
        // ponderamos de acuerdo al tipo de solicitud y otros factores
        if (solicitudes.isPresent()) {
            List<Solicitud> solicitudesList = solicitudes.get();
            List<SolicitudPonderada> solicitudesPonderadas = new ArrayList<>();

            for (Solicitud solicitud : solicitudesList) {
                SolicitudPonderada solicitudPonderada = new SolicitudPonderada();
                // Aquí se realiza la lógica de mapeo y ponderación
                solicitudPonderada.setId(solicitud.getId());
                solicitudPonderada.setTipo(solicitud.getTipo().name());
                solicitudPonderada.setPrioridadManual(solicitud.getPrioridadManual());
                solicitudPonderada.setPriorizacionCalculada(0);
                solicitudPonderada.setFechaCreacion(solicitud.getFechaCreacion().toString());
                solicitudPonderada.setUsuario(solicitud.getUsuario());


                // ponderacion por prioridad manual
                solicitudPonderada.setPriorizacionCalculada(solicitudPonderada.getPriorizacionCalculada() + ponderarPorPrioridadManual(solicitud.getPrioridadManual()));

                // Lógica de ponderación por tipo de solicitud
                for (TablaPonderacion tablaPonderacion : tablaPonderaciones) {
                    if (tablaPonderacion.getTipo() == solicitud.getTipo()) {
                        solicitudPonderada.setPriorizacionCalculada(solicitudPonderada.getPriorizacionCalculada() + tablaPonderacion.getPuntos());
                        break;
                    }
                }

                // Ponderacion por antiguedad
                int antiguedadDias = (int) ((System.currentTimeMillis() - solicitud.getFechaCreacion().toEpochMilli()) / (1000 * 60 * 60 * 24));
                solicitudPonderada.setPriorizacionCalculada(solicitudPonderada.getPriorizacionCalculada() + ponderarPorAntiguedad(antiguedadDias));
                solicitudesPonderadas.add(solicitudPonderada);
            }
            // ordenamos
            solicitudesPonderadas.sort((s1, s2) -> Integer.compare(s2.getPriorizacionCalculada(), s1.getPriorizacionCalculada()));
            return Optional.of(solicitudesPonderadas);
            
            
            

        }

    return null;

    }

    public Solicitud createSolicitud(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    private int ponderarPorPrioridadManual(Integer prioridadManual) {
        if (prioridadManual == null) {
            return 0;
        }
        switch (prioridadManual) {
            case 1:
                return 5;
            case 2:
                return 4;
            case 3:
                return 3;
            case 4:
                return 2;
            case 5:
                return 1;
            default:
                return 0;
        }
    }

    private int ponderarPorAntiguedad(int antiguedadDias) {
        if (antiguedadDias == 1) {
            return 1;
        }
        if(antiguedadDias <= 2) {
            return 3;
        }
        if (antiguedadDias >= 4) {
            return 6;
        }
        return 0;
    }
}
