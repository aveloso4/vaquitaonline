package com.proyecto.cero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
	public ModelAndView hello(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		ModelAndView model = new ModelAndView();
		name = "Puede entrar el que se le cante a esta pagina de mierda";
		model.addObject("name", name);
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Vos sos el Admin PAPUCHO");
		model.addObject("message", "This is protected page - Admin Page!");
		model.setViewName("admin");
		return model;
	}

	@RequestMapping(value = "/dba**", method = RequestMethod.GET)
	public ModelAndView dbaPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page - Database Page!");
		model.setViewName("admin");
		return model;
	}
}
