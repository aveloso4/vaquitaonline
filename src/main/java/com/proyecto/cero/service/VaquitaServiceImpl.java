package com.proyecto.cero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.cero.account.dao.VaquitaDao;
import com.proyecto.cero.model.Vaquita;

@Service
@Transactional
public class VaquitaServiceImpl implements VaquitaService{

	@Autowired
	private VaquitaDao vaquitaDAO;
	
	public Vaquita findVaquitaById(int id) {
		return vaquitaDAO.findVaquitaById(id);
	}

	public void createVaquita(Vaquita vaquita) {
		vaquitaDAO.createVaquita(vaquita);
	}

	public Vaquita getVaquita(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Vaquita> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateVaquita(Vaquita vaquita) {
		System.out.println("####################UPDATE VAQUITA######################");
		System.out.println(vaquita);
		vaquitaDAO.updateVaquita(vaquita);
		System.out.println("####################END OF UPDATE######################");
	}

}
