package com.proyecto.cero.controller;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.stereotype.Controller;

@Controller
public class ConnectController extends org.springframework.social.connect.web.ConnectController {

	@Inject
	public ConnectController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
		super(connectionFactoryLocator, connectionRepository);
	}

	@Override
	protected String connectedView(String providerId) {
		return "redirect:/";
	}
	

}
