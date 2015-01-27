package com.proyecto.cero.viaje;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JdbcViajeRepository implements ViajeRepository {

	private final JdbcTemplate jdbcTemplate;

	@Inject
	public JdbcViajeRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional
	public void createViaje(Viaje viaje) throws ViajeInvalidoException {
		try {
			jdbcTemplate.update("insert into Viaje (creador, desde, hasta, fecha, cupos, acompaniantes, costo) values (?,?, ?, ?, ?, ?, ?)", 
					viaje.getCreador(), viaje.getDesde(), viaje.getHasta(),viaje.getFecha(), viaje.getCupos(),
					viaje.getAcompaniantes(), viaje.getCosto());
		} catch (Exception e) {
			throw new ViajeInvalidoException(viaje.getDesde());
		}
	}

	// String sql =
	// "select desde, hasta, costo from Viaje where desde = ? AND hasta = ?";

	public List<Viaje> findAll() {
		String sql = "select creador, desde, hasta, cupos, acompaniantes, costo from Viaje";
		List<Viaje> viajes = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Viaje.class));
		return viajes;
	}

	public List<Viaje> findViajes(Viaje viaje) {
		String desde;
		String hasta;
		String costo;
		String fecha;

		if (viaje.getDesde() != "" && viaje.getDesde() != null)
			desde = viaje.getDesde();
		else 
			desde = "%";
		
		if (viaje.getHasta() != "" && viaje.getHasta() != null)
			hasta = viaje.getHasta();
		else
			hasta = "%";

		if (viaje.getCosto() != "" && viaje.getCosto() != null)
			costo = viaje.getCosto();
		else
			costo = "100000";
		
		if (viaje.getFecha() != "" && viaje.getFecha() != null)
			fecha = viaje.getFecha();
		 else 
			 fecha = "%";

		String sql = "select creador, desde, hasta, cupos, costo, acompaniantes, fecha from Viaje WHERE desde LIKE '" + desde + "' AND hasta LIKE '" + hasta + "' AND fecha LIKE '" + fecha + "' AND cupos NOT LIKE '0'";

		List<Viaje> viajes = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Viaje.class));
		return viajes;
	}

	public List<Viaje> findViajesByDesdeAndHasta(String desde, String hasta) {
		// TODO Auto-generated method stub
		return null;
	}
}
