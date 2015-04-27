package com.proyecto.cero.service;

import java.util.List;

import com.proyecto.cero.model.Vaquita;

public interface VaquitaService {

	public Vaquita findVaquitaById(int id);

	public void createVaquita(Vaquita vaquita);

	public List<Vaquita> findAll();
	
}
