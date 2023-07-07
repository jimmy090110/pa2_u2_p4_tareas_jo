package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ProfesorRepository;
import com.example.demo.repository.modelo.Profesor;



@Service
public class ProfesorServiceImpl implements ProfesorService{
	
	@Autowired
	private ProfesorRepository profesorRepository;

	@Override
	public void insertar(Profesor profesor) {
		this.profesorRepository.insertar(profesor);
		
	}

	@Override
	public Profesor seleccionarporCedula(String cedula) {
		
		return this.profesorRepository.seleccionarporCedula(cedula);
	}

	@Override
	public List<Profesor> seleccionarPorSueldo(BigDecimal sueldo) {
		
		return this.profesorRepository.seleccionarPorSueldo(sueldo);
	}

	@Override
	public Profesor seleccionarPorEdad(Integer edad) {
		
		return this.profesorRepository.seleccionarPorEdad(edad);
	}

	@Override
	public List<Profesor> seleccionarPorNombre(String nombre) {
		
		return this.profesorRepository.seleccionarPorNombre(nombre);
	}

	@Override
	public Profesor seleccionarProfesorDinamico(String cedula, Integer edad, BigDecimal sueldo) {
		// TODO Auto-generated method stub
		return this.profesorRepository.seleccionarProfesorDinamico(cedula, edad, sueldo);
	}

	@Override
	public int eliminar(String nombre) {
		
		return this.profesorRepository.eliminar(nombre);
	}

	@Override
	public int actualizarPorNombre(String nombre, Integer edad) {
		// TODO Auto-generated method stub
		return this.profesorRepository.actualizarPorNombre(nombre, edad);
	}

}
