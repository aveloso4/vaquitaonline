package com.proyecto.cero.signin;

import java.security.Principal;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.proyecto.cero.account.Account;
import com.proyecto.cero.account.AccountRepository;
import com.proyecto.cero.account.emailAlreadyInUse;
import com.proyecto.cero.singup.SignupForm;

@Controller
public class SigninController {

	private final Facebook facebook;
	private final AccountRepository accountRepository;
	private final ProviderSignInUtils providerSignInUtils;

	@Inject
	public SigninController(AccountRepository accountRepository, Facebook facebook) {
		this.accountRepository = accountRepository;
		this.providerSignInUtils = new ProviderSignInUtils();
		this.facebook = facebook;
	}
	
//	MAPPINGS
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String signin(Principal currentUser, Model model, WebRequest request) {
		try{
			model.addAttribute(accountRepository.findAccountByEmail(currentUser.getName()));
			model.addAttribute("profileInfo", facebook.userOperations().getUserProfile());
		} catch (Exception e){
			//TODO
		}
		request.setAttribute("redirectUri","/",WebRequest.SCOPE_SESSION);
		return "home";
	}

	@RequestMapping(value = "/previousPage", method = RequestMethod.GET)
	public String previousPage(WebRequest request) {
		 String referer = (String) request.getAttribute("redirectUri",WebRequest.SCOPE_SESSION);
		 request.removeAttribute("redirectUri", WebRequest.SCOPE_SESSION);
		 return "redirect:"+referer;
	}

	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public String signin(@Valid SigninForm form, BindingResult formBinding, WebRequest request) {
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
		if (formBinding.hasErrors()) {
			return null;
		}
    String referer = (String) request.getAttribute("redirectUri",WebRequest.SCOPE_SESSION);
    request.removeAttribute("redirectUri", WebRequest.SCOPE_SESSION);
		Account account = signInAccount(form, formBinding);
		System.out.println("EL ACCOUNT A LOGGUEAR: "+account);
		if (account != null) {
			SignInUtils.signin(account.getEmail());
			providerSignInUtils.doPostSignUp(account.getEmail(), request);
//			return (referer != null) ? "redirect:"+referer : "redirect:/";
		}
		return (referer != null) ? "redirect:"+referer : "redirect:/";
//		return null;
	}
	
	private Account signInAccount(SigninForm form, BindingResult formBinding) {
		try {
			Account account = new Account(form.getEmail(), null, null, form.getPassword(), null);
			return accountRepository.logInAccount(account);
		} catch (loginFail e) {
			formBinding.rejectValue("email", "user.duplicateEmail", "already in use");
			return null;
		}
	}
}
