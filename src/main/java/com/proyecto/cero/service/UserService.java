package com.proyecto.cero.service;

import java.util.List;

import com.proyecto.cero.account.emailAlreadyInUse;
import com.proyecto.cero.model.Account;
import com.proyecto.cero.signin.loginFail;

public interface UserService {
	
	public Account getUser(String login);

	public void createAccount(Account account) throws emailAlreadyInUse;

	public List<Account> findAll();
	
	public Account logInAccount(Account account) throws loginFail;
	
} 
