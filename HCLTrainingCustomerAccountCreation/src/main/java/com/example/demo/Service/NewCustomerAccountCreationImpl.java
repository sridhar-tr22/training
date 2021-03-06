package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Utils.CustomerAccountUtils;
import com.example.demo.DAO.NewAccountDAO;
import com.example.demo.DAO.NewCustomerDAO;
import com.example.demo.ValueObjects.Account;
import com.example.demo.ValueObjects.Customer;
@Service

public class NewCustomerAccountCreationImpl implements NewCustomerAccountCreation {

	
//	  @Autowired
//	private  CustomerAccountUtils customerAccountUtils;
	 
	@Autowired
	NewAccountDAO newAccountDAO;
	
	@Autowired
	private NewCustomerDAO newCustomerDAO;
	
	
	@Override
	public Long generateAccountNumber() {	
		CustomerAccountUtils customerAccountUtils = new CustomerAccountUtils ();
	Long generatedAccountNo = customerAccountUtils.generateNewAccountNumber();	
	System.out.println("Account No generated by Utils = " +generatedAccountNo);
		return generatedAccountNo;		
	}

	@Override
	public String generateCustomerId() {
		return null;		
	}

	@Override
	public Customer saveCustomerDetails(Customer customer)
	{
		
		 newCustomerDAO.save(customer);		
		 createCustomerAccount();
		return customer;
		
	}
	
	public void createCustomerAccount()
	{		
		Account account = new Account();
		account.setAccountNumber(generateAccountNumber());
		account.setAccountStatus("Active");
		account.setAccountType("Savings");
		account.setAvailableBalance(15700.00);
		account.setIfsc("ING00784");
		System.out.println("Account Details"+account);
		System.out.println("IN createCustomerAccount-- "+account);
		newAccountDAO.save(account);
		
	}
	
}
