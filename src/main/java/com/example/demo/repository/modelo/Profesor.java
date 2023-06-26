package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="profesor")
public class Profesor {
	
	@Id
	@GeneratedValue(generator = "seq_profesor",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_profesor",sequenceName = "seq_profesor", allocationSize = 1)
	@Column(name="prof_id")
	private Integer id;
	
	@Column(name="prof_nombre")
	private String nombre;
	
	@Column(name="prof_cedula")
	private String cedula;
	
	@Column(name="prof_sueldo")
	private BigDecimal sueldo;
	
	@Column(name="prof_edad")
	private  Integer edad;

	
	
	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", cedula=" + cedula + ", sueldo=" + sueldo + ", edad="
				+ edad + "]";
	}

	//Set and Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	

}
