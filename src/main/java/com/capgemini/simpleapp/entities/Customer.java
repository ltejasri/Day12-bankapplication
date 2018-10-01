package com.capgemini.simpleapp.entities;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class Customer {
	
	public interface loginCheck { 
	};
	
	@Positive(message = "CustomerId cannot be negative or 0",groups= loginCheck.class)
	@NotNull
	private long customerId;
	
	@NotBlank(message = "Name cannot be blank")
	private String customerName;
	
	@Size(min = 3, max = 27, message 
    = "Password must be between 3 and 27 characters",groups= loginCheck.class)
	private String password;
	
	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Email should be valid")
	private String email;
	
	@NotBlank(message = "Address cannot be blank")
	private String address;
	
	@NotNull (message = "DateOfBirth cannot be blank")
	@PastOrPresent(message = "D.O.B is invalid")
	private LocalDate dateOfBirth;
	private BankAccount account = new BankAccount();
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", password=" + password
				+ ", email=" + email + ", address=" + address + ", account=" + account + ", dateOfBirth=" + dateOfBirth
				+ "]";
	}

	
	

	public Customer() {
		super();
	}

	

	public Customer(long customerId, String customerName, String password, String email, String address,
			LocalDate dateOfBirth, BankAccount account) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.account = account;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

}