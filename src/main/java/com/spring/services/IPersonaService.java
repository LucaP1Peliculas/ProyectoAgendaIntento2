package com.spring.services;

import java.util.List;

import com.spring.model.Persona;

public interface IPersonaService {
	
	public List<Persona> list();
	public Persona getDetalles(int id);	
	public void saveOrUpdate(Persona persona);
	public void delete(int id);
	
}
