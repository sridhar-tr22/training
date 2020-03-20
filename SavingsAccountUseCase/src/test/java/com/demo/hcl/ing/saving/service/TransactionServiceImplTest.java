package com.demo.hcl.ing.saving.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.demo.hcl.ing.saving.dao.AccountDao;
import com.demo.hcl.ing.saving.dao.BeneficiaryDao;
import com.demo.hcl.ing.saving.dao.TransactionDao;
import com.demo.hcl.ing.saving.entity.Account;
import com.demo.hcl.ing.saving.entity.Beneficiary;
import com.demo.hcl.ing.saving.entity.Transaction;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
class TransactionServiceImplTest {
	
	@InjectMocks
	AccountServieImpl accountService;
	
	@InjectMocks
	TransactionServiceImpl transactionServiceImpl;
	
	@Mock
	AccountDao accountDao;
	
	@Mock
	TransactionDao transactionDao;
	
	@Mock
	BeneficiaryDao beneficiaryDao;
	
	 @Before(value = "")
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }
	 	
	

	@Test
	void testPerformTransaction() {
		testGetBalance();
		testValidateBalances();
		if(true)
		{
			testValidateBeneficiary();
			if(true)
			{
				Transaction tx = new Transaction(3546514204L,2581471714L,3576814587L,500.0,new Date());
				transactionDao.save(tx);
				verify(transactionDao,times(1)).save(tx);
			}
		}
	}
	
	

	@Test
	
	void testGetBalance() {
		when(accountDao.findByAccountNumber(1L)).thenReturn(new Account(1L,"Electronic City","ING0001",2000.0,"Savings"));
		Account accountDetails = accountService.findByAccountNumber(1L);		
		 assertEquals("Electronic City", accountDetails.getAccountBranch());
		 assertEquals("ING0001", accountDetails.getIfscCode());
		 assertEquals(2000.0, accountDetails.getBalance());
		 assertEquals("Savings", accountDetails.getAccountType());
		 assertEquals(1L, accountDetails.getAccountNumber());
	}

	@Test
	void testValidateBalances() {
		Double debitAccountBalance = 1000.0;
		Double amountToTransfer = 5000.0;
		assertTrue(debitAccountBalance != null && amountToTransfer != null);
		assertFalse(debitAccountBalance == null && amountToTransfer != null);
		assertTrue(debitAccountBalance <= amountToTransfer);
		assertFalse(debitAccountBalance > amountToTransfer);

	}

	@Test
	void testUpdateDebitAccountBalance() {
		Double amountToDebit = 500.0;
		when(accountDao.findByAccountNumber(1L)).thenReturn(new Account(1L,"Electronic City","ING0001",2000.0,"Savings"));
		Account accountDetails = accountService.findByAccountNumber(1L);
		 assertEquals("Electronic City", accountDetails.getAccountBranch());
		 assertEquals("ING0001", accountDetails.getIfscCode());
		 assertEquals(1500.0,accountDetails.getBalance()-amountToDebit);
		 assertEquals("Savings", accountDetails.getAccountType());
	}

	@Test
	void testUpdateCreditAccountBalance() {
		Double amountToCredit = 500.0;
		when(accountDao.findByAccountNumber(1L)).thenReturn(new Account(1L,"Electronic City","ING0001",2000.0,"Savings"));
		Account accountDetails = accountService.findByAccountNumber(1L);
		 assertEquals("Electronic City", accountDetails.getAccountBranch());
		 assertEquals("ING0001", accountDetails.getIfscCode());
		 assertEquals(2500.0,accountDetails.getBalance() + amountToCredit);
		 assertEquals("Savings", accountDetails.getAccountType());
	}

	@Test
	void testValidateBeneficiary() {
		List<Beneficiary> beneficiary = new ArrayList<Beneficiary>();
		Beneficiary beneficiary1 = new Beneficiary
				(1,8425641475L,"Deepak Kasgar","kasgar","Other Bank Transfers","Kormangala","Savings","DK",1551540145L);
		
		Beneficiary beneficiary2 = new Beneficiary
				(2,3115458522L,"Shridhar Rao","Sri","Other Bank Transfers","Kormangala","Savings","SR",1551540145L);
		
		Beneficiary beneficiary3 = new Beneficiary
				(3,1212007821L,"Krishnaveni","KV","Other Bank Transfers","Kormangala","Savings","KV",1551540145L);
		
		beneficiary.add(beneficiary1);
		beneficiary.add(beneficiary2);
		beneficiary.add(beneficiary3);
		
		when(beneficiaryDao.findByCustomerAccountNumber(1551540145L)).thenReturn(beneficiary);
		
		List<Beneficiary> bList= transactionServiceImpl.fetchListOfBeneficiaries(1551540145L);
		
		assertEquals(3,bList.size());
		 verify(beneficiaryDao, times(1)).findByCustomerAccountNumber(1551540145L);
	}

}
