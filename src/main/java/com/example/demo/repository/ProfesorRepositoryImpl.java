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
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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

	@Override
	public Profesor seleccionarProfesorDinamico(String cedula, Integer edad, BigDecimal sueldo) {
		// TODO Auto-generated method stub

			// 0. declaro un constructor
			CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
			// 1. Tipo de retorno que tiene mi Query
			CriteriaQuery<Profesor> myCriteriaQuery = myBuilder.createQuery(Profesor.class);
			
			Root<Profesor> myTablaFrom = myCriteriaQuery.from(Profesor.class); // 
			
			Predicate pCedula = myBuilder.equal(myTablaFrom.get("cedula"), cedula);

			
			Predicate pSueldo = myBuilder.equal(myTablaFrom.get("sueldo"), sueldo);
			Predicate pSueldo2 = myBuilder.equal(myTablaFrom.get("sueldo"), sueldo.multiply(new BigDecimal(1.5)));
			Predicate predicadoFinal = null;
			if (edad.compareTo(edad) <= 40) {
				predicadoFinal = myBuilder.or(pCedula, pSueldo);
			} else {
				
				
				predicadoFinal = myBuilder.and(pCedula, pSueldo2);
				
			}

			// 4. Armamos mi SQL final
			myCriteriaQuery.select(myTablaFrom).where(predicadoFinal);

			// 5. Laejecución del Query la realizamos con TypedQuery
			TypedQuery<Profesor> myQueryFinal = this.entityManager.createQuery(myCriteriaQuery);
			return myQueryFinal.getSingleResult();
	}

}
