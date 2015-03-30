package com.proyecto.cero.signin;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class SigninForm {

	@NotEmpty
	private String email;
	
	@Size(min = 6, message = "must be at least 6 characters")
	private String password;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
