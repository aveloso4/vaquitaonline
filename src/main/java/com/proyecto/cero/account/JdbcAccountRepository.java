package com.proyecto.cero.account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.cero.signin.loginFail;
import com.proyecto.cero.viaje.Viaje;

@Repository
public class JdbcAccountRepository implements AccountRepository {

	private final JdbcTemplate jdbcTemplate;
	private final PasswordEncoder passwordEncoder;

	@Inject
	public JdbcAccountRepository(JdbcTemplate jdbcTemplate, PasswordEncoder passwordEncoder) {
		this.jdbcTemplate = jdbcTemplate;
		this.passwordEncoder = passwordEncoder;
		
	}

	@Transactional
	public void createAccount(Account user) throws emailAlreadyInUse {
		try {
			jdbcTemplate.update(
					"insert into Account (Email, Nombre, Apellido, Telefono, Password) values (?, ?, ?, ?, ?)",
					user.getEmail(), user.getNombre(), user.getApellido(), user.getTelefono(),
					passwordEncoder.encode(user.getPassword()));
			System.out.println(user);
		} catch (DuplicateKeyException e) {
			System.out.println("Ya existe una cuenta con ese email");
			throw new emailAlreadyInUse(user.getEmail());
		}
	}
	
	public Account findAccountByEmail(String email) {
		return jdbcTemplate.queryForObject("select email, nombre, apellido from Account where email = ?",
				new RowMapper<Account>() {
					public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new Account(rs.getString("email"), rs.getString("nombre"), rs.getString("apellido"),null, null);
					}
				}, email);
	}

	public Account logInAccount(Account user) throws loginFail {
try{
	Account dbAcc = jdbcTemplate.queryForObject("select Email, Nombre, Apellido, Telefono, Password from Account where Email = ?",
				new RowMapper<Account>() {
					public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new Account(rs.getString("Email"), rs.getString("Nombre"), rs.getString("Apellido") ,rs.getString("Password"), rs.getString("Telefono"));
					}
				}, user.getEmail());
	
	return (passwordEncoder.matches(user.getPassword(), dbAcc.getPassword())) ? dbAcc : null;
	
	} catch (EmptyResultDataAccessException e){
		System.out.println("Ninguna cuenta encontrada");
		throw new loginFail();
	}
	}
	
	public List<Account> findAll() {
		String sql = "select Email, Nombre, Apellido, Telefono, Password from Account";
		 
		List<Account> accounts = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Account.class));
	 
		for (Account account : accounts) {
			System.out.println(account);
		}
		return accounts;
		
	}

}
