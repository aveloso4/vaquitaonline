package com.proyecto.cero.account;

public class Account {
	
	public Account(){
		//Vacio
	}

	private String nombre;

	private String apellido;

	private String email;

	private String password;

	private String telefono;

	public Account(String email, String nombre, String apellido, String contraseña, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = contraseña;
		this.telefono = telefono;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		System.out.println(
				  "Nombre: " + this.nombre 
				+ " Apellido: " + this.apellido 
				+ " Email: " + this.email 
				+ " Contraseña: "+ this.password 
				+ " Telefono: "+ this.telefono);
		return super.toString();
	}
}
