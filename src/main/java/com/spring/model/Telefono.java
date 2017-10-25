package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the telefonos database table.
 * 
 */
@Entity
@Table(name="telefonos")
@NamedQuery(name="Telefono.findAll", query="SELECT t FROM Telefono t")
public class Telefono implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idtelefonos;

	private String telefono;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="idPersona")
	private Persona persona;

	public Telefono() {
	}

	public int getIdtelefonos() {
		return this.idtelefonos;
	}

	public void setIdtelefonos(int idtelefonos) {
		this.idtelefonos = idtelefonos;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Telefono [telefono=" + telefono + "]";
	}

	
	

}