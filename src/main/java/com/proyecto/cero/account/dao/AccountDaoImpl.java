package com.proyecto.cero.account.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.cero.model.Account;
import com.proyecto.cero.signin.loginFail;
 
@Repository
@Transactional
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@SuppressWarnings("unchecked")
	public Account findByEmail(String email) {
		List<Account> userList = new ArrayList<Account>();
		Query query = openSession().createQuery("from Account u where u.email = :email");
		query.setParameter("email", email);
		userList = query.list();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;	
	}

	public void createAccount(Account account) {
		account.setPassword((passwordEncoder.encode(account.getPassword())));;
		openSession().persist(account);
		System.out.println("######Account ADD: "+account+"######");
	}
	
	public void removeAccount(int email){
		Account acc = (Account)openSession().load(Account.class, new Integer(email));
		if(acc != null){
			openSession().delete(acc);
			System.out.println("######Account Delete: "+acc+"######");
		}
	}

    public void updatePerson(Account acc) {
        openSession().update(acc);
        System.out.println("Account UPDATE: "+acc);
    }
	
	@SuppressWarnings("unchecked")
	public List<Account> finAll() {
		List<Account> allAcc = openSession().createQuery("from Account").list();
		for(Account acc : allAcc){
			System.out.println("######"+acc+"######");
		}
		return allAcc;
	}

	public Account logInAccount(Account account) throws loginFail {
			try{
				Account dbAcc = findByEmail(account.getEmail());	
				return (passwordEncoder.matches(account.getPassword(), dbAcc.getPassword())) ? dbAcc : null;
			} catch (EmptyResultDataAccessException e){
					System.out.println("Ninguna cuenta encontrada");
					throw new loginFail();
				}
				}
	}
