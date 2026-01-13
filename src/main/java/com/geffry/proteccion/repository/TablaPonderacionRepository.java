package com.geffry.proteccion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geffry.proteccion.model.TablaPonderacion;

public interface TablaPonderacionRepository extends JpaRepository<TablaPonderacion, Long> {
    Optional<Integer> findTopByTipoOrderByIdDesc(String tipoSolicitud);
}
