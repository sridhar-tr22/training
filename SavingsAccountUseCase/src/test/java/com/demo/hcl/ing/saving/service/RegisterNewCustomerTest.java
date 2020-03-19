package com.demo.hcl.ing.saving.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.demo.hcl.ing.saving.dao.CustomerDao;
import com.demo.hcl.ing.saving.entity.Customer;
import com.demo.hcl.ing.saving.entity.CustomerCredentials;

@SpringBootTest
class RegisterNewCustomerTest {

	CustomerCredentials customerCredentials = null;
	CustomerCredentials customerCredentials2 = null;
	Customer customer = null;

	@Autowired
	RegisterNewCustomerImpl registerNewCustomerImpl;

	@MockBean
	CustomerDao customerDao;

	@BeforeEach
	public void before() {
		
		customerCredentials = new CustomerCredentials();
		customerCredentials.setEmail("dkasgar1@gmail.com");
		customerCredentials.setPassword("kasgar");
		
		customerCredentials2 = new CustomerCredentials();
		customerCredentials2.setEmail("dkasgar1@gmail.com");
		customerCredentials2.setPassword("kasgars");

		customer = new Customer();
		customer.setEmailAddress("dkasgar1@gmail.com");
		customer.setPassword("kasgar");
		customer.setFirstName("Deepak");

	}

	@Test
	public void testCheckLoginPositive() {

		Mockito.when(customerDao.findByEmailAddressAndPassword(customerCredentials.getEmail(),
				customerCredentials.getPassword())).thenReturn(customer);
		Boolean response = registerNewCustomerImpl.validateUser(customerCredentials);
		assertEquals(true, response);

	}

	@Test
	public void testCheckLoginException() {

		Mockito.when(customerDao.findByEmailAddressAndPassword(customerCredentials.getEmail(),
				customerCredentials.getPassword())).thenReturn(customer);
		registerNewCustomerImpl.validateUser(customerCredentials2);

	}

}
