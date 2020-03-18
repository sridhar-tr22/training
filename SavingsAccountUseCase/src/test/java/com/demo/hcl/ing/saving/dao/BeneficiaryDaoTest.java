package com.demo.hcl.ing.saving.dao;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.demo.hcl.ing.saving.entity.Beneficiary;
import com.demo.hcl.ing.saving.service.customerdetails.Utils;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
class BeneficiaryDaoTest {

	@Autowired
	BeneficiaryDao beneficiaryDao;
	
	
	@Test
	void test() {
		Utils u = new Utils();
		
		Beneficiary beneficiary = u.getMockBeneficiary(); 
		Beneficiary  savedBeneficiary= beneficiaryDao.save(beneficiary);
		
		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThat(beneficiary).as("Test")
        .isEqualToComparingOnlyGivenFields(savedBeneficiary, "accountHolderName","nickName","registerPayerfor",
        		"accountBranch","accountType","customerAccountNumber");
		
	}

}
