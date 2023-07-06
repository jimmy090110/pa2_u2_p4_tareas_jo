package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Profesor;



public interface ProfesorRepository {
	
	public void insertar(Profesor profesor);
	
	public Profesor seleccionarporCedula(String cedula);
	
	public List<Profesor> seleccionarPorSueldo(BigDecimal sueldo);
	
	public Profesor seleccionarPorEdad(Integer edad);

	public List<Profesor>seleccionarPorNombre(String nombre);
	
	public Profesor seleccionarProfesorDinamico(String cedula, Integer edad, BigDecimal sueldo);
	
	 

}
