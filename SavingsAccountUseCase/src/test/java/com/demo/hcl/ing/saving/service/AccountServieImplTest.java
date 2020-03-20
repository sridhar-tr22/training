package com.demo.hcl.ing.saving.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.demo.hcl.ing.saving.dao.AccountDao;
import com.demo.hcl.ing.saving.entity.Account;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
class AccountServieImplTest {

	@Mock
	AccountDao accountDao;

	@InjectMocks
	AccountServieImpl accountServieImpl;

	@Test
	void testFindByAccountNumber() {
		when(accountDao.findByAccountNumber(1L))
				.thenReturn(new Account(1L, "Electronic City", "ING0001", 2000.0, "Savings"));
		Account accountDetails = accountServieImpl.findByAccountNumber(1L);
		assertEquals("Electronic City", accountDetails.getAccountBranch());
		assertEquals("ING0001", accountDetails.getIfscCode());
		assertEquals(2000.0, accountDetails.getBalance());
		assertEquals("Savings", accountDetails.getAccountType());
	}
}
