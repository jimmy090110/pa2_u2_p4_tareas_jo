package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Ciudadano;
import com.example.demo.repository.modelo.Empleado;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.service.CiudadanoService;
import com.example.demo.service.EmpleadoService;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;

@SpringBootApplication
public class Pa2U2P4RaJoApplication implements CommandLineRunner {
	

	@Autowired 
	private CiudadanoService ciudadanoService;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private HabitacionService habitacionService;
	
	@Autowired
	private HotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4RaJoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Hotel hote = new Hotel();
		hote.setDireccion("Carapungo");
		hote.setNombre("Hotel");
		
		Habitacion habi = new Habitacion();
		habi.setHotel(hote);
		habi.setNumero("1b");
		habi.setValor(new BigDecimal(150));
		
		this.habitacionService.crear(habi);
		
		this.habitacionService.modificar(habi);
		
		this.habitacionService.buscar(1);
		
		this.habitacionService.eliminar(1);
		
	
	
		
		
	}
	
	

}
