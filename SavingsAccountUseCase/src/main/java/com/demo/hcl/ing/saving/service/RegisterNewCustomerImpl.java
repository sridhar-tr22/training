package com.demo.hcl.ing.saving.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hcl.ing.saving.dao.CustomerDao;
import com.demo.hcl.ing.saving.entity.Customer;
import com.demo.hcl.ing.saving.entity.CustomerCredentials;
import com.demo.hcl.ing.saving.utils.AccountUtils;

@Service
public class RegisterNewCustomerImpl implements RegisterNewCustomer {

	@Autowired
	AccountUtils accountUtils;

	@Autowired
	CustomerDao customerDao;

	@Override
	public Customer newCustomerDetails(Customer customer) {
		assignCustomerIdAndAccountNumber(customer);
		customerDao.save(customer);

		return customer;
	}

	public Customer assignCustomerIdAndAccountNumber(Customer customer) {
		customer.setCustomerId(accountUtils.generateCustomerId());
		return customer;
	}

	@Override
	public Boolean validateUser(CustomerCredentials customerCredentials) {
		Customer customer = null;
		Boolean flag = false;
		customer = customerDao.findByEmailAddressAndPassword(customerCredentials.getEmail(),
				customerCredentials.getPassword());
		if (customer != null)
			flag = true;

		return flag;
	}

}