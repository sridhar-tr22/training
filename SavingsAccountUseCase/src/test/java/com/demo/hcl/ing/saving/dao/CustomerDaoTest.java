package com.demo.hcl.ing.saving.dao;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.demo.hcl.ing.saving.entity.Customer;
import com.demo.hcl.ing.saving.service.customerdetails.Utils;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
public class CustomerDaoTest {

	@Autowired
	CustomerDao customerDao;
	
	
	@Test
	void test() {
		SoftAssertions assertions = new SoftAssertions();
		Utils customerDetails = new Utils();
		Customer customer = customerDetails.getCreatedCustomer();
		Customer customersaved = customerDao.save(customer);	
		assertions.assertThat(customer).as("Book")
        .isEqualToComparingOnlyGivenFields(customersaved, "firstName","lastName","gender","dateOfBirth","citizenship","state");
	}
	
	
	
}
