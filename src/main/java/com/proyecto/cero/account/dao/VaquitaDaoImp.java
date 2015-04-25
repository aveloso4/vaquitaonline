package com.proyecto.cero.account.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proyecto.cero.model.Vaquita;

@Repository
public class VaquitaDaoImp implements VaquitaDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public Vaquita findVaquitaById(int id) {
		List<Vaquita> userList = new ArrayList<Vaquita>();
		Query query = openSession().createQuery("from Vaquita u where u.id = :id");
		query.setParameter("id", id);
		userList = query.list();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;	
	}

	public void createVaquita(Vaquita vaquita) {
		openSession().saveOrUpdate(vaquita);
	}

}
