package com.proyecto.cero.signin;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.cero.controller.ModelManager;
import com.proyecto.cero.model.Account;
import com.proyecto.cero.service.UserService;

@Controller
public class SigninController {

	private final Facebook facebook;
	private final ProviderSignInUtils providerSignInUtils;
	private final UserService userService;

	@Inject
	public SigninController(UserService us, Facebook facebook) {
		this.userService = us;
		this.providerSignInUtils = new ProviderSignInUtils();
		this.facebook = facebook;
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin(WebRequest request, Model model) {
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
		ModelManager.initializeModel(model, facebook);
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Account account = signInAccount(email, password);

		if (account != null) {
			SignInUtils.signin(account.getEmail());
			providerSignInUtils.doPostSignUp(account.getEmail(), request);
			
		} else {
			return "redirect:/access?error=bad_credentials";
		}

		return "/";
	}

	private Account signInAccount(String email, String password) {
		try {
			Account account = new Account(email, null, null, password, null);
			return userService.logInAccount(account);
		} catch (Exception e) {
			return null;
		}
	}
}
