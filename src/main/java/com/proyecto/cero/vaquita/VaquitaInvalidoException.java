package com.proyecto.cero.vaquita;

public class VaquitaInvalidoException extends Exception {
	/**
   * 
   */
  private static final long serialVersionUID = 1L;

  public VaquitaInvalidoException(String vaquita) {
		super("La Vaquita" + vaquita + "' tiene algun error.");
	}
}
