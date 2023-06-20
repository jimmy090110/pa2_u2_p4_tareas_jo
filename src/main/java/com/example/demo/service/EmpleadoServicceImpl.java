package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EmpleadoRepo;
import com.example.demo.repository.modelo.Empleado;


@Service
public class EmpleadoServicceImpl implements EmpleadoService{
	
	@Autowired
	private EmpleadoRepo empleadoRepo;

	@Override
	public void agregar(Empleado empleado) {
		this.empleadoRepo.actualizar(empleado);
	}

	@Override
	public void modificar(Empleado empleado) {
		this.empleadoRepo.actualizar(empleado);
		
	}

	@Override
	public Empleado buscar(Integer id) {
		return this.empleadoRepo.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		this.empleadoRepo.elimianar(id);
		
	}

}
