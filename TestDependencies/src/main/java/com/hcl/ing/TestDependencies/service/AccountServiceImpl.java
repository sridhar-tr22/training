package com.hcl.ing.TestDependencies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.TestDependencies.dao.AccountDao;
import com.hcl.ing.TestDependencies.dao.CustomerDao;
import com.hcl.ing.TestDependencies.entity.Account;
import com.hcl.ing.TestDependencies.entity.Customer;


@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	AccountDao accountDao;
	

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerDao.save(customer);
		
	}


	@Override
	public List<Customer> getAllCustomer() {		
		return customerDao.findAll();
	}
	
	
	public Account findByAccountNumber(Long accountNumber)
	{
		Account account = accountDao.findByAccountNumber(accountNumber);
		return account;
		
	}
	
	
}
