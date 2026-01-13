package com.geffry.proteccion.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolicitudPonderada {
    private Long id;
    private String tipo;
    private Integer prioridadManual;
    private Integer priorizacionCalculada;
    private String usuario;
    private String fechaCreacion;
}
