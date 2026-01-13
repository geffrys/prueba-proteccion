package com.geffry.proteccion.service;

import org.springframework.stereotype.Service;

import com.geffry.proteccion.model.TablaPonderacion;
import com.geffry.proteccion.model.TipoSolicitudEnum;
import com.geffry.proteccion.repository.TablaPonderacionRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class TablaPonderacionService {

    private final TablaPonderacionRepository tablaPonderacionRepository;

    public int obtenerPonderacionPorTipo(TipoSolicitudEnum tipoSolicitud) {
        return tablaPonderacionRepository.findTopByTipoOrderByIdDesc(tipoSolicitud.toString())
                .orElse(0);
    }

    public TablaPonderacion crearTablaPonderacion(TablaPonderacion tablaPonderacion) {
        return tablaPonderacionRepository.save(tablaPonderacion);
    }
}
