package com.proyecto.cero.signin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
public class SigninController {

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public void signin(WebRequest request) {
		request.setAttribute("redirectUri","/signin",WebRequest.SCOPE_SESSION);
	}

	@RequestMapping(value = "/previousPage", method = RequestMethod.GET)
	public String previousPage(WebRequest request) {
		 String referer = (String) request.getAttribute("redirectUri",WebRequest.SCOPE_SESSION);
		 request.removeAttribute("redirectUri", WebRequest.SCOPE_SESSION);
		 return "redirect:"+referer;
		
	}

}
