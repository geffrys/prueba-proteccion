package com.geffry.proteccion.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geffry.proteccion.model.TablaPonderacion;
import com.geffry.proteccion.service.TablaPonderacionService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/api/v1/ponderacion")
@RequiredArgsConstructor
public class TablaPonderacionController {

    private final TablaPonderacionService tablaPonderacionService;

    @PostMapping()
    public TablaPonderacion postTablaPonderacion(@RequestBody TablaPonderacion tablaPonderacion) {
        return tablaPonderacionService.crearTablaPonderacion(tablaPonderacion);        
    }   

    @GetMapping()
    public List<TablaPonderacion> getPonderaciones() {
        return tablaPonderacionService.obtenerTodasLasPonderaciones();
    }
    
    
    
}
