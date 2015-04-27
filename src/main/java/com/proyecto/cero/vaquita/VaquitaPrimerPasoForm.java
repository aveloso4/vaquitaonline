package com.proyecto.cero.vaquita;

import org.hibernate.validator.constraints.NotEmpty;

public class VaquitaPrimerPasoForm {
	
	@NotEmpty
	private String nombre;
	private String descripcion;
	@NotEmpty
	private String imagen; // Default: imgDefault.png
	
	public VaquitaPrimerPasoForm() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
