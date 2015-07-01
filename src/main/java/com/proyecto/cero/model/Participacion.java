package com.proyecto.cero.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Participaciones")
public class Participacion {
	
	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = true)
	private String id;
	
	@Column(name = "user_id", nullable = false)
	private Integer userID;
	
	@Column(name = "vaquita_id", nullable = false)
	private Integer vaquitaID;

	@Column(name = "mp_estado", nullable = false)
	private Integer mercadoPagoEstado;

	@Column(name = "mensaje", nullable = true)
	private String mensaje;
	
	@Column(name = "privacidad", nullable = false)
	private boolean privacidad;
	
	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "telefono", nullable = true)
	private String telefono;

	@Column(name = "monto", nullable = false)
	private int monto;
	

	public Participacion() {
		// VACIO
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getVaquitaID() {
		return vaquitaID;
	}

	public void setVaquitaID(Integer vaquitaID) {
		this.vaquitaID = vaquitaID;
	}

	public Integer getMercadoPagoEstado() {
		return mercadoPagoEstado;
	}

	public void setMercadoPagoEstado(Integer mercadoPagoEstado) {
		this.mercadoPagoEstado = mercadoPagoEstado;
	}

	public boolean isPrivacidad() {
		return privacidad;
	}

	public void setPrivacidad(boolean privacidad) {
		this.privacidad = privacidad;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}
	
	
}
