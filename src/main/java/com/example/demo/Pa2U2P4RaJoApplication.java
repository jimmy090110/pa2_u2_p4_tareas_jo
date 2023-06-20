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
import com.example.demo.service.AutorService;
import com.example.demo.service.CiudadanoService;
import com.example.demo.service.EmpleadoService;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;
import com.example.demo.service.LibroService;

@SpringBootApplication
public class Pa2U2P4RaJoApplication implements CommandLineRunner {
	
	@Autowired
	private LibroService libroService;
	
	@Autowired
	private AutorService autorService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4RaJoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		Set<Libro>listaBib = new HashSet<>();
	
		Autor aut1 = new Autor();

		Libro lib = new Libro();
		Libro lib2 = new Libro();

		lib.setEditorial("Frank");
		lib.setTitulo("Animales pedidos");
		
		lib2.setTitulo("La Odisea");
		lib2.setEditorial("Fernandez");
		
		
		aut1.setNombre("Pedro");
		aut1.setApellido("Quintanilla");
		listaBib.add(lib);
		listaBib.add(lib2);
		aut1.setLibros(listaBib);
		
		this.autorService.agregar(aut1);
		
		this.autorService.actualizar(aut1);
		
		this.autorService.buscar(1);
		
		this.autorService.eliminar(1);
		
		
		

		
	
		
	
		
		
		
	
	
		
		
	}
	
	

}
