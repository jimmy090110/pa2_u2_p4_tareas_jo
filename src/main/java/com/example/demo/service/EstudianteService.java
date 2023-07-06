package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteService {
	public void guardar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public void eliminar(String cedula);
	public Estudiante buscar(String cedula);
	
public Estudiante buscarPorApellido(String apellido);
	
	public Estudiante seleccionarPorApellidoTyped(String apellido);
	public List<Estudiante> buscarListaPorApellido(String apellido);
	public Estudiante seleccionarPorApellidoyNombre(String apellido, String nombre);
	
	

	public Estudiante seleccionarPorApellidoNamed(String apellido);
	
	public Estudiante seleccionarPorApellidoNamedQuery(String apellido);
	
	public Estudiante seleccionarPorApellidoNativeQuery(String apellido);
	
	public Estudiante seleccionarPorApellidoTypedNativeQuery(String apellido);
	
	public Estudiante seleccionarPorNombreNamedQuery(String nombre);
	
	public Estudiante seleccionarPorNombreTypedNativeQuery(String nombre);
	
	public Estudiante seleccionarPorApellidoCriteriaAPIQuery(String apellido);

}
