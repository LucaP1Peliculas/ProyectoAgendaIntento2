package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="categorias")
public class Categoria {
	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id_categorias;
	
	private String nombre;
	private String descripcion;
	
	
	public int getId_categorias() {
		return id_categorias;
	}
	public void setId_categorias(int id_categorias) {
		this.id_categorias = id_categorias;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Categoria(){}
	
	public Categoria(int id_categorias, String nombre, String descripcion) {
		super();
		this.id_categorias = id_categorias;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Categoria [id_categorias=" + id_categorias + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ "]";
	}
	
	

	
}
