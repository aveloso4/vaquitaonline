package com.proyecto.cero.controller;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public class ModelManager {
	
	public static void initializeModel(ModelAndView model, Facebook facebook) {
		model.addObject("isAthenticate", AuthenticationManager.isAthenticate());
		try {
			model.addObject("profileInfo", facebook.userOperations().getUserProfile());
		} catch (Exception e) {
		}
	}

	public static void initializeModel(Model model, Facebook facebook) {
		try {
			model.addAttribute("profileInfo", facebook.userOperations().getUserProfile());
		} catch (Exception e) {
		}
	}
}
