package com.geffry.proteccion.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geffry.proteccion.model.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    Optional<List<Solicitud>> findAllByOrderByPrioridadManualAscFechaCreacionAsc();    
}
