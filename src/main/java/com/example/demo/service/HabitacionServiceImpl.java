package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.HabitacionRepo;
import com.example.demo.repository.modelo.Habitacion;



@Service
public class HabitacionServiceImpl implements HabitacionService {
	
	@Autowired
	private HabitacionRepo habitacionRepo;

	@Override
	public void crear(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.habitacionRepo.insertar(habitacion);
		
	}

	@Override
	public void modificar(Habitacion habitacionl) {
		// TODO Auto-generated method stub
		this.habitacionRepo.actualizar(habitacionl);
		
	}

	@Override
	public Habitacion buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.habitacionRepo.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.habitacionRepo.eliminar(id);
		
	}



}
