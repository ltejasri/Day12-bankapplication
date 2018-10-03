package com.capgemini.simpleapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.simpleapp.controller.CustomerController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleappApplicationTests {
	
	@Autowired
	CustomerController customercontroller;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	

	@Test
	public void contextLoads() {
	}

}
