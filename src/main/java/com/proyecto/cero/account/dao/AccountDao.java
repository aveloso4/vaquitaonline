package com.proyecto.cero.account.dao;

import java.util.List;

import com.proyecto.cero.model.Account;
import com.proyecto.cero.signin.loginFail;

public interface AccountDao {

	Account findByEmail(String username);

	void createAccount(Account account);

	List<Account> finAll();

	Account logInAccount(Account account) throws loginFail;

}