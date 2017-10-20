package com.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Persona;

@Repository
public class PersonaDAOImp implements IPersonaDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public PersonaDAOImp(){
		
	}

	
	public PersonaDAOImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public List<Persona> list() {
		@SuppressWarnings("unchecked")
		List<Persona> listUser = (List<Persona>) sessionFactory.getCurrentSession()
				.createCriteria(Persona.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}

	@Override
	public Persona get(int id) {
		
		return null;
	}

	@Override
	public void saveOrUpdate(Persona persona) {
	
		
	}

	@Override
	public void delete(int id) {
	
		
	}

}
