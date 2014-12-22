package com.proyecto.cero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping(value = "/hello")
	public ModelAndView hello(@RequestParam(
			value = "name", required = false, defaultValue = "Default Value") String texto) {
		ModelAndView model = new ModelAndView();
		texto = "Puede entrar el que se le cante a esta pagina de mierda";
		model.addObject("texto", texto);
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Vos sos el Admin PAPUCHO");
		model.addObject("message", "Pagina HIPER protegida - Admin Page!");
		model.setViewName("admin");
		return model;
	}

	@RequestMapping(value = "/dba**", method = RequestMethod.GET)
	public ModelAndView dbaPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Pagina para los que manejan la base de datos");
		model.addObject("message", "Esta pagina esta protegida - Database Page!");
		model.setViewName("admin");
		return model;
	}
}
