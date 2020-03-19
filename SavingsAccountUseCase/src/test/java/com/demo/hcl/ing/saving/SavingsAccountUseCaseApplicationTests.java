package com.demo.hcl.ing.saving;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import com.demo.hcl.ing.saving.service.AccountService;
import com.demo.hcl.ing.saving.service.AccountServieImpl;
import com.demo.hcl.ing.saving.service.RegisterNewBeneficiary;
import com.demo.hcl.ing.saving.service.RegisterNewBeneficiaryImpl;
import com.demo.hcl.ing.saving.service.RegisterNewCustomer;
import com.demo.hcl.ing.saving.service.RegisterNewCustomerImpl;
import com.demo.hcl.ing.saving.service.TransactionService;
import com.demo.hcl.ing.saving.service.TransactionServiceImpl;
import com.demo.hcl.ing.saving.utils.AccountUtils;

@SpringBootTest
class SavingsAccountUseCaseApplicationTests {

	@Test
	void contextLoads() {
	}

	@Bean
	public RegisterNewCustomer getRegisterNewCustomer() {
		return new RegisterNewCustomerImpl();
	}
	
	@Bean
	public RegisterNewBeneficiary getRegisterNewBeneficiary() {
		return new RegisterNewBeneficiaryImpl();
	}
	
	@Bean
	public TransactionService getTransactionService() {
		return new TransactionServiceImpl();
	}
	
	@Bean
	public AccountUtils getAccountUtils() {
		return new AccountUtils();
	}
	
	@Bean
	public AccountService getAccountService() {
		return new AccountServieImpl();
	}
}
