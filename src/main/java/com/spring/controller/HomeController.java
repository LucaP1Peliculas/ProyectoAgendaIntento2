package com.spring.controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Persona;
import com.spring.model.Telefono;
import com.spring.model.Direccione;
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
	
	@RequestMapping(value = "/search")
	public String Search(@RequestParam("searchString") String searchString, ModelAndView model) {

	    if(searchString != null){
	        List<Persona> searchResult = personaService.search(searchString);
	        model.addObject("searchResult", searchResult);  
	    }

	    return "search";
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
		
		Telefono telefono1= t.get(1);
		
		String nombre=personaService.getDetalles(id).getNombre();
		String apellido1=personaService.getDetalles(id).getApellido1();
		String apellido2=personaService.getDetalles(id).getApellido2();
		String dni=personaService.getDetalles(id).getDni();
		Date fecha=personaService.getDetalles(id).getFechaNacimiento();
		List<Direccione> d=personaService.getDetalles(id).getDirecciones();
		String direccion= d.get(0).getDireccion();
		String cp=d.get(0).getCodPostal();
		String provincia=d.get(0).getCodPostal();
		String localidad= d.get(0).getLocalidad();
		
		////////////////////////////////////////////////
		
		
		ModelAndView model = new ModelAndView("index");
		model.addObject("personList", listPersonas);
		model.addObject("telefono2", telefono2);
		
		
		/////////CODIGO PABLO//////////
		
		model.addObject("dni", dni);
		model.addObject("nombre", nombre);
		model.addObject("apellido1", apellido1);
		model.addObject("apellido2", apellido2);
		model.addObject("fecha", fecha);
		model.addObject("direccion", direccion);
		model.addObject("cp", cp);
		model.addObject("provincia", provincia);
		model.addObject("localidad", localidad);
		model.addObject("telefono1", telefono1);
		//////////////////////////////
		
		return model;
	}
	

	
}
