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

import com.example.demo.repository.modelo.Autor;
import com.example.demo.repository.modelo.Ciudadano;
import com.example.demo.repository.modelo.Empleado;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Libro;
import com.example.demo.repository.modelo.Profesor;
import com.example.demo.service.AutorService;
import com.example.demo.service.CiudadanoService;
import com.example.demo.service.EmpleadoService;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;
import com.example.demo.service.LibroService;
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
		prof.setNombre("Pedro");
		prof.setEdad(25);
		prof.setSueldo(new BigDecimal(1000));
		prof.setCedula("040");
		
		Profesor prof2 = new Profesor();
		prof2.setNombre("Fabricio");
		prof2.setEdad(40);
		prof2.setSueldo(new BigDecimal(1000));
		prof2.setCedula("030");
		
		//this.profesorService.insertar(prof);
		//this.profesorService.insertar(prof2);
		
		//1 Ejemplo de Query con single result
		System.out.println(this.profesorService.seleccionarporCedula("020"));
		
		//2 Ejemplo de Query con result list
		System.out.println(this.profesorService.seleccionarPorSueldo(new BigDecimal(1000)));
		
		//3 Ejemplo de TypedQuery con single result
		System.out.println(this.profesorService.seleccionarPorEdad(25));
		
		//4 Ejemplo de TypedQuery con result list
		System.out.println(this.profesorService.seleccionarPorNombre("Fabricio"));
		
		

		
	
		
	
		
		
		
	
	
		
		
	}
	
	

}
