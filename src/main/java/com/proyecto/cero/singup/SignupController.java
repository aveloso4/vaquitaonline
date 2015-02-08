package com.proyecto.cero.singup;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.proyecto.cero.account.Account;
import com.proyecto.cero.account.AccountRepository;
import com.proyecto.cero.account.UsernameAlreadyInUseException;
import com.proyecto.cero.message.Message;
import com.proyecto.cero.message.MessageType;
import com.proyecto.cero.signin.SignInUtils;

@Controller
public class SignupController {

	private final AccountRepository accountRepository;
	private final ProviderSignInUtils providerSignInUtils;

	@Inject
	public SignupController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		this.providerSignInUtils = new ProviderSignInUtils();
	}

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public SignupForm signupForm(WebRequest request) {
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
		request.setAttribute("redirectUri", request.getHeader("Referer"),WebRequest.SCOPE_SESSION);
		if (connection != null) {
			request.setAttribute("message", new Message(MessageType.INFO, "Your " + StringUtils.capitalize(connection.getKey().getProviderId()) + " account is not associated with a Spring Social Showcase account. If you're new, please sign up."), WebRequest.SCOPE_REQUEST);
			return SignupForm.fromProviderUser(connection.fetchUserProfile());
		} else {
			return new SignupForm();
		}
	}

	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@Valid SignupForm form, BindingResult formBinding, WebRequest request) {
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
		if (formBinding.hasErrors()) {
			return null;
		}
		
    String referer = (String) request.getAttribute("redirectUri",WebRequest.SCOPE_SESSION);
    request.removeAttribute("redirectUri", WebRequest.SCOPE_SESSION);
		Account account = createAccount(form, formBinding, connection.fetchUserProfile());
		if (account != null) {
			SignInUtils.signin(account.getUsername());
			providerSignInUtils.doPostSignUp(account.getUsername(), request);
			return "redirect:"+referer;
		}
		return null;
	}

	// internal helpers
	
	private Account createAccount(SignupForm form, BindingResult formBinding, UserProfile providerUser) {
		try {
			Account account = new Account(form.getUsername(), form.getPassword(), providerUser.getFirstName(), providerUser.getLastName());
			accountRepository.createAccount(account);
			return account;
		} catch (UsernameAlreadyInUseException e) {
			formBinding.rejectValue("username", "user.duplicateUsername", "already in use");
			return null;
		}
	}

}
