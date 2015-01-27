package com.proyecto.cero.viaje;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

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
	
	@NotNull
	private Integer cupos;

	@NotEmpty
	private String fecha;
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getCupos() {
		return cupos;
	}

	public void setCupos(Integer cupos) {
		this.cupos = cupos;
	}

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
