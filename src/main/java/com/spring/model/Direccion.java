package com.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="direcciones")
public class Direccion implements Serializable{
	

    private static final long serialVersionUID = 144585071807476496L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id_direcciones;
	
	private String direccion;
	private String conPostal;
	private String localidad;
	private String provincia;
	
	
	@JoinColumn(name = "idPersona", referencedColumnName = "idpersonas")
    @OneToOne
    private Persona personaId;
	
	public Direccion(String direccion, String codPostal, String localidad, String provincia){
		this.direccion = direccion;
		this.conPostal = codPostal;
		this.localidad = localidad;
		this.provincia = provincia;
	}

	public int getId_direcciones() {
		return id_direcciones;
	}

	public void setId_direcciones(int id_direcciones) {
		this.id_direcciones = id_direcciones;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getConPostal() {
		return conPostal;
	}

	public void setConPostal(String conPostal) {
		this.conPostal = conPostal;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Persona getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Persona personaId) {
		this.personaId = personaId;
	}

	@Override
	public String toString() {
		return "Direccion [id_direcciones=" + id_direcciones + ", direccion=" + direccion + ", conPostal=" + conPostal
				+ ", localidad=" + localidad + ", provincia=" + provincia + ", personaId=" + personaId + "]";
	}
	
	
	
	
}

