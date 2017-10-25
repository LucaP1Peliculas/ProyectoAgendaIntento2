package com.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.IPersonaDAO;
import com.spring.model.Persona;

@Service
@Transactional
public class PersonaServiceImp implements IPersonaService{

	@Autowired
	private IPersonaDAO personaDAO;
	
	@Override
	public List<Persona> list() {
		return personaDAO.list();
	}

	@Override
	public Persona getDetalles(int id) {
		return personaDAO.getDetalles(id);
	}

	@Override
	public void saveOrUpdate(Persona persona) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	

	
	
	
	
}
