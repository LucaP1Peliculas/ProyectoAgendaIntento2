package com.spring.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="telefonos")

public class Telefono implements Serializable {
	
    private static final long serialVersionUID = 144585071807476496L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idtelefonos;
    private String telefono;
    private int id;
    
    
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
    
	

}
