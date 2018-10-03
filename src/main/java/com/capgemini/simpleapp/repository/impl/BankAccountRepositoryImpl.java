package com.capgemini.simpleapp.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.simpleapp.repository.BankAccountRepository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public double getBalance(long accountId) throws DataAccessException {
		try {
			return jdbcTemplate.queryForObject("select balance from bankAccount where account_id=?", new Object[] { accountId }, Double.class);
				}
		catch (DataAccessException e) {
			e.initCause(new EmptyResultDataAccessException("Expected 1 actual 0",1));
			throw e;
		}
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) throws DataAccessException {
		{
			int count = jdbcTemplate.update("UPDATE bankAccount set balance=? where account_id=?", new Object[] {newBalance, accountId});
		return (count!=0) ? true : false;
		}
	}
}
/*
 * @Override public double getBalance(long accountId) { try { return
 * jdbcTemplate.
 * queryForObject("select balance from bankAccount where account_Id=?", new
 * Object[] { accountId }, Double.class); } catch(Exception e) { return -1 ; }
 * 
 * }
 * 
 * @Override public boolean updateBalance(long accountId, double newBalance)
 * throws EmptyResultDataAccessException { int count =
 * jdbcTemplate.update("UPDATE bankAccount set balance=? where account_Id=?",
 * new Object[] { newBalance, (int) accountId }); return count != 0; }
 */
