package com.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="departamentos")

public class Departamento implements Serializable {
	

    private static final long serialVersionUID = 144585071807476496L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id_departamentos;
	
	private String nombre;

	public int getId_departamentos() {
		return id_departamentos;
	}

	public void setId_departamentos(int id_departamentos) {
		this.id_departamentos = id_departamentos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Departamento(){}
	
	public Departamento(int id_departamentos, String nombre) {

		this.id_departamentos = id_departamentos;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Departamento [id_departamentos=" + id_departamentos + ", nombre=" + nombre + "]";
	}

	
	

}
