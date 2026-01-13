package com.geffry.proteccion.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<TablaPonderacion> obtenerPonderacionPorTipo(TipoSolicitudEnum tipoSolicitud) {
        return tablaPonderacionRepository.findTopByTipoOrderByIdDesc(tipoSolicitud);
    }

    public TablaPonderacion crearTablaPonderacion(TablaPonderacion tablaPonderacion) {
        return tablaPonderacionRepository.save(tablaPonderacion);
    }

    public void eliminarTablaPonderacion(Long id) {
        tablaPonderacionRepository.deleteById(id);
    }

    public List<TablaPonderacion> obtenerTodasLasPonderaciones() {
        List<TipoSolicitudEnum> tipos = List.of(TipoSolicitudEnum.values());
        return tipos.stream()
            .map(tipo -> tablaPonderacionRepository.findTopByTipoOrderByIdDesc(tipo).orElse(null))
            .toList();
    }
}
