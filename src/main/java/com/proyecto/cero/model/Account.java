package com.proyecto.cero.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {
	@Id
	@Column(name = "Email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "Nombre", nullable = false, length = 60)
	private String nombre;
	
	@Column(name = "Apellido", nullable = false, length = 60)
	private String apellido;
	
	@Column(name = "Password", nullable = false, length = 60)
	private String password;
	
	@Column(name = "Telefono", nullable = false, length = 60)
	private String telefono;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="user_roles",
		joinColumns = {@JoinColumn(name="user_id", referencedColumnName="Email")},
		inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
	)
	private Role role;
	
	public Account(){
		//Vacio
	}

	public Account(String email, String nombre, String apellido, String contraseña, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = contraseña;
		this.telefono = telefono;
		this.role = new Role();
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public String getTelefono() {
		return telefono;
	}
	
	public Role getRole() {
		return role;
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

	public void setRole(Role role) {
		this.role = role;
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
