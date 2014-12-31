package com.proyecto.cero.viaje;

public class Viaje {

	public Viaje() {
		// Vacio
	}
	
	private String desde;
	private String hasta;
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

	public Viaje(String desde, String hasta, String costo) {
		this.desde = desde;
		this.hasta = hasta;
		this.costo = costo;
	}
}
