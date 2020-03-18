package com.demo.hcl.ing.saving.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.demo.hcl.ing.saving.dao.BeneficiaryDao;
import com.demo.hcl.ing.saving.entity.Beneficiary;
import com.demo.hcl.ing.saving.service.customerdetails.Utils;


@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
class BeneficiaryServiceImplTest {

	@Autowired
	RegisterNewBeneficiary beneficiaryService;
	
	@Mock
	BeneficiaryDao beneficiaryDao;
	
	
	@Test
	void test() {
		Utils util = new Utils();
		Beneficiary beneficiary  = 	util.getMockBeneficiary();
		Beneficiary beneficiaryfromMock = beneficiaryService.saveBeneficiary(beneficiary);
		
		
		
		
	}

}
