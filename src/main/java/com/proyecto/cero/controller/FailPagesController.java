package com.proyecto.cero.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FailPagesController {	
	
	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {
 
		ModelAndView model = new ModelAndView();
 
		if (user != null) {
			model.addObject("msg", "Hola " + user.getName() 
			+ ", no tenes permiso para acceder a esta pagina");
		} else {
			model.addObject("msg", 
			"No tenes permiso para acceder a esta pagina");
		}
 
		model.setViewName("403");
		return model;
 
	}
 
}
