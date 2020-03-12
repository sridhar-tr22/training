package com.example.demo.Service;

import com.example.demo.ValueObjects.Customer;

public interface NewCustomerAccountCreation {

	public Long generateAccountNumber();
	public String generateCustomerId();
	public Customer saveCustomerDetails(Customer customer);
	
	
}
