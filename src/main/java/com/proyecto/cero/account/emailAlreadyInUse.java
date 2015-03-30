package com.proyecto.cero.account;

public class emailAlreadyInUse extends Exception {
	public emailAlreadyInUse(String email) {
		super("The email '" + email + "' is already in use.");
	}
}
