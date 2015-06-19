package com.proyecto.cero.account;

public class emailAlreadyInUse extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6965467975330908585L;

	public emailAlreadyInUse(String email) {
		super("The email '" + email + "' is already in use.");
	}
}
