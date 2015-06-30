package com.proyecto.cero.participacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.cero.account.dao.ParticipacionesDao;
import com.proyecto.cero.model.Participacion;
import com.proyecto.cero.service.ParticipacionesService;

@Service
@Transactional
public class ParticipacionesServiceImpl implements ParticipacionesService{

	@Autowired
	private ParticipacionesDao participacionDao;
	
	
	public void addParticipacion(Participacion participacion) {
		participacionDao.crateParticipacion(participacion);
	}

	
	
}
