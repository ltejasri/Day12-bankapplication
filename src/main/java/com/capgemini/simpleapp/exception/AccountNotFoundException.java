package com.capgemini.simpleapp.exception;


public class AccountNotFoundException extends Exception {

	public AccountNotFoundException(String message)
	{
		super(message);
	}
}