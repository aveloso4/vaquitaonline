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
			jdbcTemplate.update(
					"insert into Viaje (desde, hasta, costo) values (?, ?, ?)",
					viaje.getDesde(), viaje.getHasta(), viaje.getCosto());
		} catch (Exception e) {
			throw new ViajeInvalidoException(viaje.getDesde());
		}
	}

	//String sql = "select desde, hasta, costo from Viaje where desde = ? AND hasta = ?";
	
	public List<Viaje> findAll(){
		String sql = "select desde, hasta, costo from Viaje";
			List<Viaje> viajes  = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Viaje.class));
			return viajes;
		}

	public List<Viaje> findViajesByDesdeAndHasta(String desde, String hasta) {
		// TODO crear el find bu desde hasta
		return findAll();
	}

	public List<Viaje> findViajes(Viaje viaje) {
		String desde;
		String hasta;
		String costo;
		
		if(viaje.getDesde() != null)
			desde = viaje.getDesde();
		else
			desde = "%"; 
		
		if(viaje.getHasta() != null)
			hasta = viaje.getHasta(); 
		else
			hasta = "%"; 
		
		if(viaje.getCosto() != null)
			costo = viaje.getCosto(); 
		else
			costo= "%"; 
		
		String sql = "select desde, hasta, costo from Viaje WHERE desde LIKE '"+desde+
																												"' AND hasta LIKE '"+hasta+
																												"' AND costo LIKE '"+costo+"'";
		
		List<Viaje> viajes  = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Viaje.class));
		return viajes;
	}
}
