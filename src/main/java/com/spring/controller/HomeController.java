package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Persona;
import com.spring.model.Telefono;
import com.spring.services.IPersonaService;

@Controller
public class HomeController {
	
	//Autowired de la capa servicios
	@Autowired
	private IPersonaService personaService;
	
	
	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		System.out.println("Aceptada la respuesta al mapeo /");
		List<Persona> listPersonas = personaService.list();
		ModelAndView model = new ModelAndView("index");
		model.addObject("personList", listPersonas);
		List<Telefono> t = personaService.getDetalles(1).getTelefonos();
		
		return model;
	}
	
	@RequestMapping("/detalles")
	public ModelAndView handleRequestDetalles(HttpServletRequest request) throws Exception{
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("El id del usuario es : " + id);
		
		System.out.println("-- Entrando en detalles");
		List<Persona> listPersonas = personaService.list();
	
		List<Telefono> t = personaService.getDetalles(id).getTelefonos();
		Telefono telefono2 = t.get(0);
		
		////////////////CODIGO PABLO/////////////////////
		
		
		
		
		////////////////////////////////////////////////
		
		
		ModelAndView model = new ModelAndView("index");
		model.addObject("personList", listPersonas);
		model.addObject("telefono2", telefono2);
		
		return model;
	}
	

	
}
