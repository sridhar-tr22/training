package com.hcl.bank.ing.CustomerAccount;

import org.springframework.beans.factory.annotation.Autowired;

public class NewAccountService {

	@Autowired
	GeneratorUtils generatorUtils;
	@Autowired
	AccountDetails accountDetails;
	
	
	
	public void newAccountCreation(CustomerDetails customerDetails)
	{
		System.out.println("in service");
		customerDetails.setCustId(generatorUtils.generateCustomerId());
		accountDetails.setCustomerDetails(customerDetails);
		
		Branch branch = new Branch();
		branch.setBranchCity("Bengaluru");
		branch.setBranchId("ING004391");
		branch.setBranchName("Electronic City");
		accountDetails.setBranch(branch);
		
		
		
	}
}
