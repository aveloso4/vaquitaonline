package com.proyecto.cero.account.dao;

import com.proyecto.cero.model.Vaquita;

public interface VaquitaDao {

  Vaquita findVaquitaById(int id);
  void createVaquita(Vaquita vaquita);
  
}
