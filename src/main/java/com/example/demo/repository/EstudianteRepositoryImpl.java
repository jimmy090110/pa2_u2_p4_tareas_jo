package com.example.demo.repository;


import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
		
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);
		
	}

	@Override
	public void borrar(String cedula) {
		Estudiante estu = this.seleccioanr(cedula);
		this.entityManager.remove(estu);
		
	}

	@Override
	public Estudiante seleccioanr(String cedula) {
		
		return this.entityManager.find(Estudiante.class, cedula);
	}
	


}
