package com.geffry.proteccion.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "solicitudes")
public class Solicitud {
    @Id
    @Column(name = "solicitud_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tipo")
    private String tipo;
    private Integer prioridadManual;
    @Column(name = "fecha_creacion", updatable = false)
    @CreationTimestamp
    private Instant fechaCreacion;
    private String usuario;
}
