package com.geffry.proteccion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ProteccionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProteccionApplication.class, args);
	}

}
