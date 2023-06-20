package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CiudadadoRepo;
import com.example.demo.repository.modelo.Ciudadano;

@Service
public class CiudadanoServiceImpl implements CiudadanoService  {

	@Autowired
	private CiudadadoRepo ciudadadoRepo;
	
	@Override
	public void crear(Ciudadano ciudadano) {
		this.ciudadadoRepo.actualizar(ciudadano);
		
	}

	@Override
	public void modificar(Ciudadano ciudadano) {
		this.ciudadadoRepo.actualizar(ciudadano);
		
	}

	@Override
	public Ciudadano buscar(Integer id) {
		return this.ciudadadoRepo.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {	
		this.ciudadadoRepo.eliminar(id);
		
	}

}
