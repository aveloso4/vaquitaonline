package com.proyecto.cero.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.cero.account.dao.AccountDao;
import com.proyecto.cero.model.Account;
import com.proyecto.cero.signin.loginFail;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private AccountDao userDAO;

	public Account getUser(String login) {
		return userDAO.findByEmail(login);
	}

	public void createAccount(Account account) {
		userDAO.createAccount(account);
	}

	public List<Account> findAll() {
		return userDAO.finAll();
	}

	public Account logInAccount(Account account) throws loginFail {
		return userDAO.logInAccount(account);
	}
 
}
