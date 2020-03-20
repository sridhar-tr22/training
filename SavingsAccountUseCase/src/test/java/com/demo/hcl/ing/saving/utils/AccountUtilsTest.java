package com.demo.hcl.ing.saving.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class AccountUtilsTest {

	AccountUtils accountUtils = new AccountUtils();

	@Test
	void positiveTestForGenerateNewAccountNumber() {

		Long generatedAccountNumber = accountUtils.generateNewAccountNumber();
		System.out.println("generatedAccountNumber" + generatedAccountNumber);
		assertThat(generatedAccountNumber instanceof java.lang.Long);
	}

	@Test
	void negativeTestForGenerateNewAccountNumber() {

		Long generatedAccountNumber = accountUtils.generateNewAccountNumber();
		System.out.println("generatedAccountNumber" + generatedAccountNumber);
		assertFalse(!(generatedAccountNumber instanceof java.lang.Long));
	}

	@Test
	void positiveTestGenerateCustomerId() {
		String generatedCustomerId = accountUtils.generateCustomerId();
		assertFalse(!(generatedCustomerId instanceof java.lang.String));
	}

	@Test
	void negativeTestGenerateCustomerId() {
		String generatedCustomerId = accountUtils.generateCustomerId();
		assertThat(!(generatedCustomerId instanceof java.lang.String));
	}

	@Test
	void positiveTestGenerateNewTransactionId() {
		Long generatedTransactionId = accountUtils.generateNewTransactionId();
		assertThat(generatedTransactionId instanceof java.lang.Long);
	}

	@Test
	void negativeTestGenerateNewTransactionId() {
		Long generatedTransactionId = accountUtils.generateNewTransactionId();
		assertFalse(!(generatedTransactionId instanceof java.lang.Long));
	}
}
