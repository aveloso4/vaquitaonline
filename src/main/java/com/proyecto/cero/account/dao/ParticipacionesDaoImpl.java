package com.proyecto.cero.account.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.cero.model.Participacion;

@Repository
@Transactional
public class ParticipacionesDaoImpl implements ParticipacionesDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void crateParticipacion(Participacion participacion) {
		openSession().persist(participacion);
	}
	
	
}
