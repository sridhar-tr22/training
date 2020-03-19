package com.demo.hcl.ing.saving.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hcl.ing.saving.dao.CustomerDao;
import com.demo.hcl.ing.saving.entity.Account;
import com.demo.hcl.ing.saving.entity.Customer;
import com.demo.hcl.ing.saving.entity.CustomerCredentials;
import com.demo.hcl.ing.saving.utils.AccountUtils;

@Service("registerNewCustomer")
public class RegisterNewCustomerImpl implements RegisterNewCustomer {
	Logger logger = LoggerFactory.getLogger(RegisterNewCustomerImpl.class);
	@Autowired
	AccountUtils accountUtils;

	@Autowired
	CustomerDao customerDao;

	@Override
	public Customer newCustomerDetails(Customer customer) {
		Customer savedCustomer = null;
		try {
			if (customer != null) {
				assignCustomerIdAndAccountNumber(customer);
				savedCustomer = customerDao.save(customer);
			}
		} catch (Exception e) {
			logger.error("Exception occured while saving user details");
			e.printStackTrace();
		}
		return savedCustomer;
	}

	public Customer assignCustomerIdAndAccountNumber(Customer customer) {
		try {
			if (customer != null) {
				List<Account> list = new ArrayList<Account>();
				customer.setCustomerId(accountUtils.generateCustomerId());
				List<Account> acc = customer.getAccount();
				if (acc != null) {
					for (Account ac : acc) {
						ac.setAccountNumber(accountUtils.generateNewAccountNumber());
						list.add(ac);
					}
					customer.setAccount(list);
				}
			} else {
				logger.info("Customer Details are not available");
				return null;
			}
		} catch (Exception e) {
			logger.error("Error while generating account number and customer Id" + e);
		}
		return customer;

	}

	@Override
	public Boolean validateUser(CustomerCredentials customerCredentials) {
		Customer customer = null;
		Boolean flag = false;
		try {
			customer = customerDao.findByEmailAddressAndPassword(customerCredentials.getEmail(),
					customerCredentials.getPassword());
			if (customer != null) {
				flag = true;
			}
		} catch (Exception e) {
			logger.error("Error while validaing user details " + e);
			return flag;
		}
		return flag;
	}

}