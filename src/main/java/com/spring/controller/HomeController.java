package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Persona;
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
		return model;
	}
	

	
}
