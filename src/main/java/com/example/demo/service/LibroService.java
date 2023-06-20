package com.example.demo.service;

import com.example.demo.repository.modelo.Libro;

public interface LibroService {
	public void agregar(Libro libro);
	public void actualizar(Libro libro);
	public Libro buscar(Integer id);
	public void borrar(Integer id);

}
