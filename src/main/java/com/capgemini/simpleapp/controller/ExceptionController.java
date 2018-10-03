package com.capgemini.simpleapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capgemini.simpleapp.entities.Customer;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler 
{
	@ExceptionHandler(value = { Exception.class })
	protected String handleConflict(Exception ex,WebRequest request) 
	{
		System.out.println("Handler");
		request.setAttribute("exception", ex, 0);
		return "errorMessages";
	}
}
	