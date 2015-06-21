package com.proyecto.cero.signin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

	// Just for setting the default target URL
	public LogoutSuccessHandler(String defaultTargetURI) {
		this.setDefaultTargetUrl(defaultTargetURI);
	}

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

		// do whatever you want
		super.onLogoutSuccess(request, response, authentication);
	}
}