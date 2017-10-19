package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="direcciones")
public class Direccion {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id_direcciones;
	
	private String direccion;
	private String conPostal;
	private String localidad;
	private String provincia;
	
	
	
	
}

