package com.hcl.ing.TestDependencies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.TestDependencies.dao.AccountDao;
import com.hcl.ing.TestDependencies.dao.AccountTransactionDao;
import com.hcl.ing.TestDependencies.entity.Account;
import com.hcl.ing.TestDependencies.entity.AccountTransaction;
import com.hcl.ing.TestDependencies.utils.AccountUtils;

@Service
public class AccountTransactionImpl implements AccountTransactionInterface {

	@Autowired
	AccountUtils accountUtils;

	@Autowired
	AccountService accountService;

	@Autowired
	AccountTransactionDao accountTransactionDao;

	@Autowired
	AccountDao accountDao;

	@Override
	public AccountTransaction saveTransaction(AccountTransaction accountTransaction) {
		AccountTransaction transaction = null;
		Boolean status = false;
		Double amountToTransfer = accountTransaction.getBalance();
		Double debitAccountBalance = getBalance(accountTransaction.getFromAccount());

		status = validateBalances(debitAccountBalance, amountToTransfer);

		if (status) {
			accountTransaction.setTransactionId(accountUtils.generateAccountNumber());
			transaction = accountTransactionDao.save(accountTransaction);
		}

		updateDebitAccountBalance(accountTransaction, debitAccountBalance);

		Double creditAccountBalance = getBalance(accountTransaction.getToAccount());
		updateCreditAccountBalance(accountTransaction, creditAccountBalance);

		return transaction;
	}

	public Double getBalance(Long accountNumber) {
		Account accountdetails = accountService.findByAccountNumber(accountNumber);

		return accountdetails.getBalance();
	}

	public Boolean validateBalances(Double debitAccountBalance, Double amountToTransfer) {
		Boolean status = false;
		if (debitAccountBalance < amountToTransfer) {
			status = false;
		} else {
			status = true;
		}
		return status;
	}

	public void updateDebitAccountBalance(AccountTransaction accountTransaction, Double debitAccountBalance) {
		Account accountdetails = accountService.findByAccountNumber(accountTransaction.getFromAccount());
		Account account = new Account();
		account.setAccountNumber(accountTransaction.getFromAccount());
		account.setBalance(debitAccountBalance - (accountTransaction.getBalance()));
		account.setBankAddress(accountdetails.getBankAddress());
		account.setIfscCode(accountdetails.getIfscCode());
		accountDao.save(account);
	}

	public void updateCreditAccountBalance(AccountTransaction accountTransaction, Double creditAccountBalance) {
		System.out.println("creditAccountBalance" + creditAccountBalance);
		Account accountdetails = accountService.findByAccountNumber(accountTransaction.getToAccount());
		Account account = new Account();
		account.setAccountNumber(accountTransaction.getToAccount());
		account.setBalance(creditAccountBalance + (accountTransaction.getBalance()));
		account.setBankAddress(accountdetails.getBankAddress());
		account.setIfscCode(accountdetails.getIfscCode());
		System.out.println("Updated Account " + account);
		accountDao.save(account);
	}

}
