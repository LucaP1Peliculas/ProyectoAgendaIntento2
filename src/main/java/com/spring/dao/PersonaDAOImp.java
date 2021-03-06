package com.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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
		List<Persona> listUser = (List<Persona>) sessionFactory.getCurrentSession().createCriteria(Persona.class).addOrder(Order.asc("nombre")).list();
		
//		List<Persona> listUser = (List<Persona>) sessionFactory.getCurrentSession()
//				.createCriteria(Persona.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}

	@Override
	public Persona getDetalles(int id) {
		Persona p1 = (Persona) sessionFactory.getCurrentSession().createCriteria(Persona.class).add(Restrictions.eq("idpersonas", id)).uniqueResult();
		System.out.println("-- entrando en get detalles telefono: "+ p1.getTelefonos());
		return p1;
	}

	@Override
	public void saveOrUpdate(Persona persona) {
		sessionFactory.getCurrentSession().save(persona);
		
	}

	@Override
	public void delete(int id) {
	
		
	}
	/////CODIGO BUSQUEDA PABLO////////////
	@Override
	public List<Persona> search(String s){
		@SuppressWarnings("unchecked")
		//List<Persona> p2=(List<Persona>) sessionFactory.getCurrentSession().createCriteria(Persona.class).add(Restrictions.or(Restrictions.like("nombre", s+"%"))).list();
		List<Persona> p3=(List<Persona>) sessionFactory.getCurrentSession().createCriteria(Persona.class).add(
				Restrictions.disjunction().add(Restrictions.like("nombre", s+"%")).add(Restrictions.like("telefono1", "%"+s+"%" ))).list();

		return  p3;
	}
	//En teoría esto nos tendría que filtrar si una persona mete la primera letra del nombre o las primeras, y le da a enter.
	////////////////////////////////////////////

}
