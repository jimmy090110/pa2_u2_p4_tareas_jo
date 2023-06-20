package com.example.demo.service;

import com.example.demo.repository.modelo.Empleado;

public interface EmpleadoService {
	
	public void agregar(Empleado empleado);
	public void modificar(Empleado empleado);
	public Empleado buscar(Integer id);
	public void eliminar(Integer id);
	

}
