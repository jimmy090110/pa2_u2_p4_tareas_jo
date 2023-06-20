package com.example.demo.service;

import com.example.demo.repository.modelo.Habitacion;

public interface HabitacionService {
	
	public void crear(Habitacion habitacion );
	public void modificar(Habitacion habitacionl);
	public Habitacion buscar(Integer id);
	public void eliminar(Integer id);

}
