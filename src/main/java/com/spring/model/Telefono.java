package com.spring.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="telefonos")

/**
 * 
 * @author Grupo01
 * 
 * La clase Telefono tiene incluidos los atributos de idtelefonos, telefono y trae el idpersonas de la clase Persona.
 * Tenemos constructores vacíos, constructores con los atributos y toString.
 * También hemos incluido el equals() y el hash(), me ha salido un warning de que puede que el equals y el hash den problemas, deberíamos tenerlo en cuenta si salen problemas.
 * 
 */

public class Telefono implements Serializable {
	
    private static final long serialVersionUID = 144585071807476496L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idtelefonos;
    private String telefono;
    
    @OneToOne(mappedBy="idpersonas",  cascade = CascadeType.ALL)
    @JoinColumn(name="idpersonas")
    private Persona idpersonas;
    
    
	public int getIdtelefonos() {
		return idtelefonos;
	}
	public void setIdtelefonos(int idtelefonos) {
		this.idtelefonos = idtelefonos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Persona getId() {
		return idpersonas;
	}
	public void setId(Persona idpersonas) {
		this.idpersonas = idpersonas;
	}
	
	
    public Telefono(){
    	
    }
    
    public Telefono(String telefono, Persona idpersonas){
    	this.telefono=telefono;
    	this.idpersonas=idpersonas;
    }
    
    
	@Override
	public String toString() {
		return "Telefono [idtelefonos=" + idtelefonos + ", telefono=" + telefono + ", idpersonas=" + idpersonas + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idpersonas == null) ? 0 : idpersonas.hashCode());
		result = prime * result + idtelefonos;
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefono other = (Telefono) obj;
		if (idpersonas == null) {
			if (other.idpersonas != null)
				return false;
		} else if (!idpersonas.equals(other.idpersonas))
			return false;
		if (idtelefonos != other.idtelefonos)
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
	
    
    

}
