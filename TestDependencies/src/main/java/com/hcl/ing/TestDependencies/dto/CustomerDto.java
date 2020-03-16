package com.hcl.ing.TestDependencies.dto;

import com.hcl.ing.TestDependencies.entity.Customer;

public class CustomerDto {
	
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerDto(Customer customer) {
		super();
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerDto [customer=" + customer + "]";
	}

	public CustomerDto() {
		super();
	}
}