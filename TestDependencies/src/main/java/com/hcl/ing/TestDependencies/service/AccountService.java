package com.hcl.ing.TestDependencies.service;

import java.util.List;

import com.hcl.ing.TestDependencies.entity.Account;
import com.hcl.ing.TestDependencies.entity.AccountTransaction;
import com.hcl.ing.TestDependencies.entity.Customer;

public interface AccountService {
	public Customer saveCustomer(Customer customer);
	
	public List<Customer> getAllCustomer();
	public Account findByAccountNumber(Long accountNumber);
	
	

}
