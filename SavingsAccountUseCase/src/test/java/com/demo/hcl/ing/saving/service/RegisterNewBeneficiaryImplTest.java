package com.demo.hcl.ing.saving.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.demo.hcl.ing.saving.dao.BeneficiaryDao;
import com.demo.hcl.ing.saving.entity.Beneficiary;
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
class RegisterNewBeneficiaryImplTest {

	
	@InjectMocks
	RegisterNewBeneficiaryImpl registerNewBeneficiaryImpl;
	
	@Mock
	BeneficiaryDao beneficiaryDao;
	
	 @Before(value = "")
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }
	 	
	@Test
	void testSaveBeneficiary() {
		Beneficiary beneficiary = new Beneficiary
				(1,8425641475L,"Deepak Kasgar","kasgar","Other Bank Transfers","Kormangala","Savings","DK",1551540145L);
		when(beneficiaryDao.save(beneficiary)).thenReturn(beneficiary);
		Beneficiary savedBeneficiary =registerNewBeneficiaryImpl.saveBeneficiary(beneficiary);
		assertEquals(1,savedBeneficiary.getId());
		assertEquals("Deepak Kasgar", savedBeneficiary.getAccountHolderName());
		assertEquals("Other Bank Transfers", savedBeneficiary.getRegisterPayerfor());
		assertEquals("Kormangala",savedBeneficiary.getAccountBranch());
		//verify(beneficiaryDao,times(1)).save(beneficiary);
		
		
	}

}
