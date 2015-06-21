package com.proyecto.cero.singup;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.proyecto.cero.account.emailAlreadyInUse;
import com.proyecto.cero.controller.ModelManager;
import com.proyecto.cero.model.Account;
import com.proyecto.cero.service.UserService;
import com.proyecto.cero.signin.SignInUtils;

@Controller
public class SignupController {

	private final Facebook facebook;
	private final UserService userService;
	private final ProviderSignInUtils providerSignInUtils;

	@Inject
	public SignupController(UserService us, Facebook facebook) {
		this.providerSignInUtils = new ProviderSignInUtils();
		this.userService = us;
		this.facebook = facebook;
	}

	@RequestMapping(value="/signup", method=RequestMethod.GET)
		public String facebookSignup(Principal currentUser, Model model, WebRequest request) throws emailAlreadyInUse {
		
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
		ModelManager.initializeModel(model, facebook);
		String name, lastName, password, email, telephone;
		
		if(connection != null){
			//Facebook Signup
			UserProfile userProfile = connection.fetchUserProfile();
			name = userProfile.getFirstName();
			lastName = userProfile.getLastName();
			password = "23%&/2423&/3435ÑsdjNsadI";
			email = userProfile.getEmail();
			telephone = null;
			
		} else {
			//Application Signup
			name = request.getParameter("name");
			lastName = request.getParameter("lastName");
			password = request.getParameter("password");
			email = request.getParameter("email");
			telephone = request.getParameter("telephone");
		}
			
			Account account = createAccount(email, name, lastName, password, telephone);
			System.out.println(account);

			if(account != null) {
				//If not duplicated account
				SignInUtils.signin(account.getEmail());
				providerSignInUtils.doPostSignUp(account.getEmail(), request);
				return "redirect:/";
			}
			return "redirect:/duplicateAccount";
		}

	// internal helpers
	
	private Account createAccount(String email, String name, String lastName, String password, String telefono) {
		try {
			Account account = new Account(email, name, lastName, password, telefono);
			userService.createAccount(account);
			return account;
		} catch (emailAlreadyInUse e) {
			return null;
		}
	}

}
