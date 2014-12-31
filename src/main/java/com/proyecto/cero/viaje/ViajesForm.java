package com.proyecto.cero.viaje;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.social.connect.UserProfile;

import com.proyecto.cero.singup.SignupForm;

public class ViajesForm {
	
	public ViajesForm() {
		//Contructor Vacio
	}

	@NotEmpty
	private String desde;
	
	@NotEmpty
	private String hasta;
	
	@NotEmpty
	private String costo;

	public String getDesde() {
		return desde;
	}

	public void setDesde(String desde) {
		this.desde = desde;
	}

	public String getHasta() {
		return hasta;
	}

	public void setHasta(String hasta) {
		this.hasta = hasta;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}
	
}
