package com.proyecto.cero.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.cero.account.dao.ParticipacionesDao;
import com.proyecto.cero.model.Participacion;

public class ParticipacionesServiceImpl implements ParticipacionesService{

	@Autowired
	private ParticipacionesDao partDao;
	
	@Override
	public void addParticipacion(Participacion participacion) {
		partDao.crateParticipacion(participacion);
	}

}
