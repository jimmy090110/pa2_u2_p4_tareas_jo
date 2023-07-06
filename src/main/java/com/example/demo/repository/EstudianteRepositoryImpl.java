package com.example.demo.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.From;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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
	
	@Override
	public Estudiante seleccionarPorApellido(String apellido) {
		//SQL
		//SELECT * FROM estudiante WHERE e.estu_apellido = '';
		//JPQL: SE MANTIENE LAS PALABRAS RESERVADAS
		//SELECT e FROM Estudiante e WHERE e."nombre del atributo" e.apellido=
		//Cuando uso query debo usar un CAST en el return
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido= :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return  (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> seleccionarListaPorApellido(String apellido) {
		//QUERY JPQL
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido =: datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public Estudiante seleccionarPorApellidoyNombre(String apellido, String nombre) {
		//QUERY JPQL
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido= :datoApellido AND e.nombre = :datoNombre");
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoTyped(String apellido) {
		//Parte nueva por aprender
		//QUERY TIPED
		//SELECT e FROM
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido= :datoApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNamed(String apellido) {
		TypedQuery<Estudiante> myQuery=this.entityManager.createNamedQuery("Estudiante.buscarPorApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNamedQuery(String apellido) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", myQuery);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNativeQuery(String apellido) {
		Query myQuery = this.entityManager.createNativeQuery("Select* from estudiante e WHERE estu_apellido=:datoApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoTypedNativeQuery(String apellido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estudiante seleccionarPorNombreNamedQuery(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estudiante seleccionarPorNombreTypedNativeQuery(String nombre) {
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myCriteriaQuery= myBuilder.createQuery(Estudiante.class);
		Root<Estudiante>myTablaFrom = myCriteriaQuery.from(Estudiante.class);
		Predicate condicionPredicate = myBuilder.equal(myTablaFrom.get("nombre"), nombre);
		myCriteriaQuery.select(myTablaFrom).where(condicionPredicate);
		TypedQuery<Estudiante>myQueryFinal = this.entityManager.createQuery(myCriteriaQuery);
		
		return myQueryFinal.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoCriteriaAPIQuery(String apellido) {
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myCriteriaQuery = myBuilder.createQuery(Estudiante.class);
		Root<Estudiante>myTablaFrom = myCriteriaQuery.from(Estudiante.class);
		Predicate condicionPredicate = myBuilder.equal(myTablaFrom.get("apellido"), apellido);
		myCriteriaQuery.select(myTablaFrom).where(condicionPredicate);
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myCriteriaQuery);
		return myQueryFinal.getSingleResult();
		
		
	}

	@Override
	public Estudiante seleccionarEstudianteDinamico(String nombre, String apellido, Double peso) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
