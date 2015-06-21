package com.proyecto.cero.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationManager {

	public static boolean isAthenticate(){
		return !(SecurityContextHolder.getContext().getAuthentication().getClass() == AnonymousAuthenticationToken.class);
	}
	
}
