package com.proyecto.cero.viaje;

public class ViajeInvalidoException extends Exception {
	public ViajeInvalidoException(String viaje) {
		super("El viaje a '" + viaje + "' tiene algun error.");
	}
}
