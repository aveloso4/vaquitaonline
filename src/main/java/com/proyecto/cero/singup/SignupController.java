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

import com.proyecto.cero.account.emailAlreadyInUse;
import com.proyecto.cero.message.Message;
import com.proyecto.cero.message.MessageType;
import com.proyecto.cero.model.Account;
import com.proyecto.cero.service.UserService;
import com.proyecto.cero.service.UserServiceImpl;
import com.proyecto.cero.signin.SignInUtils;

@Controller
public class SignupController {

	private final UserService userService;
	private final ProviderSignInUtils providerSignInUtils;

	@Inject
	public SignupController(UserService us) {
		this.providerSignInUtils = new ProviderSignInUtils();
		this.userService = us;
	}

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public SignupForm signupForm(WebRequest request) {
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
		request.setAttribute("redirectUri", request.getHeader("Referer"),WebRequest.SCOPE_SESSION);
		if (connection != null) {
			request.setAttribute("message", new Message(MessageType.INFO, "No estas asociado, por favor asociate."), WebRequest.SCOPE_REQUEST);
			return SignupForm.fromProviderUser(connection.fetchUserProfile());
		} else {
			return new SignupForm();
		}
	}

	@RequestMapping(value="/signupExtra", method=RequestMethod.GET)
	public SignupForm signupExtraForm(WebRequest request) {
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
		request.setAttribute("redirectUri", request.getHeader("Referer"),WebRequest.SCOPE_SESSION);
		if (connection != null) {
			request.setAttribute("message", new Message(MessageType.INFO, "No estas asociado, por favor asociate."), WebRequest.SCOPE_REQUEST);
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
		Account account = createAccount(form, formBinding);
		if (account != null) {
			SignInUtils.signin(account.getEmail());
			providerSignInUtils.doPostSignUp(account.getEmail(), request);
			return (referer != null) ? "redirect:"+referer : "redirect:/";
		}
		return null;
	}

	// internal helpers
	
	private Account createAccount(SignupForm form, BindingResult formBinding) {
		try {
			Account account = new Account(form.getEmail(), form.getNombre(), form.getApellido(), form.getPassword(), form.getTelefono());
			userService.createAccount(account);
			return account;
		} catch (emailAlreadyInUse e) {
			formBinding.rejectValue("email", "user.duplicateEmail", "already in use");
			return null;
		}
	}

}
