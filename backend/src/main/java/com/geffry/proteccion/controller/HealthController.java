package com.geffry.proteccion.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {
    @RequestMapping
    public Map<String, String> checkHealth() {
        return Map.of("status", "UP");
    }
}
