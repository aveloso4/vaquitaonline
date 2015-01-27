package com.proyecto.cero.viaje;

public class Viaje {

	public Viaje() {
		// Vacio
	}

	private String creador;
	private String desde;
	private String hasta;
	private int cupos;
	private String acompaniantes;
	private String costo;
	private String fecha;

	public Viaje(String creador, String desde, String hasta, int cupos, String acompaniantes, String costo, String fecha) {
		this.creador = creador;
		this.desde = desde;
		this.hasta = hasta;
		this.cupos = cupos;
		this.acompaniantes = acompaniantes;
		this.costo = costo;
		this.fecha = fecha;
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
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public int getCupos() {
		return cupos;
	}

	public void setCupos(int cupos) {
		this.cupos = cupos;
	}

	public String getAcompaniantes() {
		return acompaniantes;
	}

	public void setAcompaniantes(String acompaniantes) {
		this.acompaniantes = acompaniantes;
	}
	
	@Override
	public String toString() {
		return "Creador: "+this.getCreador() +" Desde: "+ this.getDesde() +" Hasta: "+ this.getHasta() +" Fecha: "+ this.getFecha() + " Costo: " + this.getCosto() + " Cupos: " + this.getCupos();
	}

}
