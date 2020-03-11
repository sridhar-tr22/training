package com.hcl.bank.ing.CustomerAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerAccountController {

	@Autowired
	NewAccountService newAccountService;
	
	 @GetMapping("/")
	public String checkstatus()
	{
		return "Server is up";
	}
	
	
	@PostMapping("/newcustomer")
	CustomerDetails newCustomer(@RequestBody CustomerDetails customerDetails) {
		
		System.out.println("IN New Customer Controller" + customerDetails);
		newAccountService.newAccountCreation(customerDetails);
		return customerDetails ;		
	}
}
