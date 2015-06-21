package com.proyecto.cero.controller;

import java.security.Principal;

import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.cero.service.UserService;

@Controller
public class AccessController {

	private final Facebook facebook;
	private final Provider<ConnectionRepository> connectionRepositoryProvider;
	private final UserService userService;

	@Inject
	public AccessController(Provider<ConnectionRepository> connectionRepositoryProvider, UserService us, Facebook facebook) {
		this.connectionRepositoryProvider = connectionRepositoryProvider;
		this.facebook = facebook;
		this.userService = us;
	}

	@RequestMapping(value = { "/access" }, method = RequestMethod.GET)
	public ModelAndView access(Principal currentUser, WebRequest request) {
		ModelAndView model = new ModelAndView();
		model.setViewName("access");

		model.addObject("isAthenticate", AuthenticationManager.isAthenticate());
		try {
			model.addObject("profileInfo", facebook.userOperations().getUserProfile());
		} catch (Exception e) {
		}
		
		return model;
	}
}
