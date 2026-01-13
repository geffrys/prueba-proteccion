package com.geffry.proteccion.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tabla_ponderacion")
@Getter
@Setter
@RequiredArgsConstructor
public class TablaPonderacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(jakarta.persistence.EnumType.STRING)
    private TipoSolicitudEnum tipo;
    private Integer puntos;
}
