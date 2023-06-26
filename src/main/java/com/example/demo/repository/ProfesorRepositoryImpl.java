package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Profesor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProfesorRepositoryImpl implements ProfesorRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Profesor profesor) {
		this.entityManager.persist(profesor);
		
	}

	@Override
	public Profesor seleccionarporCedula(String cedula) {
		Query myQuery = this.entityManager.createQuery("Select p from Profesor p WHERE p.cedula  =: datoCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Profesor) myQuery.getSingleResult();
	}

	@Override
	public List<Profesor> seleccionarPorSueldo(BigDecimal sueldo) {
		Query myQuery = this.entityManager.createQuery("Select p from Profesor p WHERE p.sueldo =: datoSueldo ");
		myQuery.setParameter("datoSueldo", sueldo);
		return myQuery.getResultList();
	}

	@Override
	public Profesor seleccionarPorEdad(Integer edad) {
		TypedQuery<Profesor> myQuery= this.entityManager.createQuery("Select p from Profesor p WHERE p.edad =: datoEdad",Profesor.class);
		myQuery.setParameter("datoEdad", edad);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Profesor> seleccionarPorNombre(String nombre) {
		TypedQuery<Profesor>myQuery = this.entityManager.createQuery("Select p from Profesor p WHERE p.nombre =: datoNombre",Profesor.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}

}
