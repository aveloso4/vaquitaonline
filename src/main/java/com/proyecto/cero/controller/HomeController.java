/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.proyecto.cero.controller;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.cero.model.Account;
import com.proyecto.cero.service.UserService;

@Controller
public class HomeController {

	private final Facebook facebook;
	private final Provider<ConnectionRepository> connectionRepositoryProvider;
	private final UserService userService;

	@Inject
	public HomeController(Provider<ConnectionRepository> connectionRepositoryProvider, UserService us, Facebook facebook) {
		this.connectionRepositoryProvider = connectionRepositoryProvider;
		this.facebook = facebook;
		this.userService = us;
	}

	// MAPPINGS
	@RequestMapping(value = "/vaquitaCreada", method = RequestMethod.GET)
	public ModelAndView index(Principal currentUser, WebRequest request) {
		/* MODEL AND VIEW */
		ModelAndView model = new ModelAndView();
		model.addObject("content", "home");
		model.setViewName("home");

		return model;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView root(Principal currentUser, WebRequest request) {

		ModelAndView model = new ModelAndView();
		ModelManager.initializeModel(model, facebook);
		model.setViewName("home");
		
		return model;
	}

	@RequestMapping(value = { "/accounts" })
	public String accounts(Principal currentUser, Model model, WebRequest request) {
		try {
			List<Account> accounts = userService.findAll();
			if (accounts.size() == 0) {
				System.out.println("Lista vacia");
			}

			model.addAttribute("accounts", accounts);
		} catch (Exception e) {
			System.out.println(e);
		}

		return "allAccounts";
	}
}
