package com.proyecto.cero.account;

import java.util.List;

import com.proyecto.cero.signin.loginFail;

public interface AccountRepository {
	
	void createAccount(Account account) throws emailAlreadyInUse;

		Account findAccountByEmail(String email);
	  Account logInAccount(Account user) throws loginFail;
	  List<Account> findAll();
}
