package com.demo.hcl.ing.saving;

import java.util.ArrayList;
import java.util.List;

import com.demo.hcl.ing.saving.entity.Account;
import com.demo.hcl.ing.saving.entity.Beneficiary;
import com.demo.hcl.ing.saving.entity.Customer;
import com.demo.hcl.ing.saving.entity.Transaction;

public class Utils {

	public Customer getCreatedCustomer() {
		Customer customer = new Customer();
		Account account = new Account();
		List<Account> list = new ArrayList<Account>();
		customer.setCustomerId("1");
		customer.setFirstName("Deepak");
		customer.setMiddleName("");
		customer.setLastName("Kasgar");
		customer.setGender("male");
		customer.setAddress1("203 Prem ganj");
		customer.setAddress2("Sipri Bazar");
		customer.setCity("Jhansi");
		customer.setState("Uttar Pradesh");
		customer.setZipCode(284003);
		customer.setPhoneNumber("+91 9972207104");
		customer.setEmailAddress("dkasgar1@gmail.com");
		customer.setAccountOpeningBalance(1000);
		customer.setDateOfBirth("16/09/1989");
		customer.setCitizenship("Indian");
		customer.setAadharNumber("120076511771");
		customer.setAccountType("Savings");
		customer.setPassword("kasgar");
		account.setAccountNumber(1L);
		account.setAccountBranch("Electronic City");
		account.setIfscCode("ING00001");
		account.setBalance(2000.0);
		list.add(account);
		customer.setAccount(list);
		return customer;

	}

	public Beneficiary getMockBeneficiary() {
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setBeneficiaryAccountNumber(3L);
		beneficiary.setAccountHolderName("Deepak");
		beneficiary.setNickName("DK");
		beneficiary.setRegisterPayerfor("Other Bank Transfers");
		beneficiary.setAccountBranch("Kormangla");
		beneficiary.setAccountType("Savings");
		beneficiary.setCreatedBy("DK");
		beneficiary.setCustomerAccountNumber(2L);

		return beneficiary;
	}

	public Transaction getMockTransaction() {
		Transaction trans = new Transaction();
		trans.setTransactionId(121452521L);
		trans.setBalance(500.0);
		trans.setFromAccount(1L);
		trans.setToAccount(2L);
		return trans;
	}

}
