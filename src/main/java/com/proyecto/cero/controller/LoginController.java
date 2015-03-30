package com.proyecto.cero.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login(Principal user, @RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hola  " + user.getName());
			model.addObject("isLogin", true);
		} else {
			model.addObject("isLogin", false);
			if (error != null) {
				model.addObject("msg", "Email y Password invalidos");
			}
			if (logout != null) {
				model.addObject("msg", "Hasta Luego!");
			}
			model.setViewName("signup");
		}

		return model;
	}

}
