package com.proyecto.cero.singup;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.social.connect.UserProfile;

public class SignupForm {

	@NotEmpty
	private String email;
	
	@NotEmpty
	private String nombre;

	@NotEmpty
	private String apellido;
	
	@Size(min = 6, message = "must be at least 6 characters")
	private String password;
	
	@NotEmpty
	private String telefono;


	public static SignupForm fromProviderUser(UserProfile providerUser) {
		SignupForm form = new SignupForm();
		form.setEmail(providerUser.getEmail());
		form.setNombre(providerUser.getFirstName());
		form.setApellido(providerUser.getLastName());
		return form;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
