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

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;

import com.proyecto.cero.model.Account;
import com.proyecto.cero.service.UserService;
import com.proyecto.cero.service.UserServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

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

//	TODO @RequestMapping(value = { "/crearViaje", "/createTravel" })
//	public String home(Principal currentUser, Model model, WebRequest request) {
//		try {
//			model.addAttribute("connectionsToProviders", getConnectionRepository().findAllConnections());
//			model.addAttribute(accountRepository.findAccountByEmail(currentUser.getName()));
//			model.addAttribute("profileInfo", facebook.userOperations().getUserProfile());
//		} catch (Exception e) {
//			// TODO: QUE HACEMOS SI NO ESTA LOGUEADO?
//		}
//		request.setAttribute("redirectUri", "/crearViaje", WebRequest.SCOPE_SESSION);
//		return "travelCreate";
//	}
//
//	private ConnectionRepository getConnectionRepository() {
//		return connectionRepositoryProvider.get();
//	}

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
		request.setAttribute("redirectUri", "/", WebRequest.SCOPE_SESSION);
		return "allAccounts";

	}
}
