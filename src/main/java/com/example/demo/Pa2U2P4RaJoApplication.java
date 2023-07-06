package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Profesor;
import com.example.demo.service.ProfesorService;



@SpringBootApplication
public class Pa2U2P4RaJoApplication implements CommandLineRunner {
	
	
	@Autowired
	private ProfesorService profesorService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4RaJoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Profesor prof = new Profesor();
		prof.setCedula("11111");
		prof.setEdad(45);
		prof.setNombre("Ignacio");
		prof.setSueldo(new BigDecimal(500));
		
		this.profesorService.insertar(prof);
		
		//El sueldo aumenta un 50% si pasa la edad de 40 años
		System.out.println("El sueldo es: "+this.profesorService.seleccionarProfesorDinamico("11111", 45, new BigDecimal(500)));
		
		
		
		
		
		
		
	
		

		
		
		

		
	
		
	
		
		
		
	
	
		
		
	}
	
	

}
