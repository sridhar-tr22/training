package com.demo.hcl.ing.saving.dto;

import com.demo.hcl.ing.saving.entity.CustomerCredentials;

public class CustomerLoginDTO {
	
	private CustomerCredentials customerCredentials;

	public CustomerCredentials getCustomerCredentials() {
		return customerCredentials;
	}

	public void setCustomerCredentials(CustomerCredentials customerCredentials) {
		this.customerCredentials = customerCredentials;
	}	
	public CustomerLoginDTO()
	{
		super();
	}
}
