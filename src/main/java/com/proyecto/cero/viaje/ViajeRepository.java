package com.proyecto.cero.viaje;

import java.util.List;

public interface ViajeRepository {
	
		void createViaje(Viaje viaje) throws ViajeInvalidoException;
		public List<Viaje> findAll();
		List<Viaje> findViajesByDesdeAndHasta(String desde, String hasta);
}
