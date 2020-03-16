package com.hcl.ing.TestDependencies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.ing.TestDependencies.dto.CustomerDto;
import com.hcl.ing.TestDependencies.entity.AccountTransaction;
import com.hcl.ing.TestDependencies.entity.Customer;
import com.hcl.ing.TestDependencies.service.AccountService;
import com.hcl.ing.TestDependencies.service.AccountTransactionInterface;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	@Autowired
	AccountTransactionInterface accountTransactionInterface;
	
	@PostMapping("/savecustomerdetails")
	public Customer saveCustomer(@RequestBody CustomerDto customerDto)
	{
		
		Customer customer = accountService.saveCustomer(customerDto.getCustomer());
		return customer;
	}

	
	@GetMapping("/findAllCustomers")
	public List<Customer> getCustomerDetails()
	{
		return  accountService.getAllCustomer();
	}
	
	
	@PostMapping("/savetransaction")
	public AccountTransaction saveTransaction(@RequestBody AccountTransaction accountTransaction)
	{
		
		AccountTransaction accountTransactionobj = accountTransactionInterface.saveTransaction(accountTransaction);
		return accountTransactionobj;
	}
	

	
}
