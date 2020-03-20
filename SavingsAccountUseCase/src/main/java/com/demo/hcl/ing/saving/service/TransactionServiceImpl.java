package com.demo.hcl.ing.saving.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hcl.ing.saving.dao.AccountDao;
import com.demo.hcl.ing.saving.dao.BeneficiaryDao;
import com.demo.hcl.ing.saving.dao.TransactionDao;
import com.demo.hcl.ing.saving.entity.Account;
import com.demo.hcl.ing.saving.entity.Beneficiary;
import com.demo.hcl.ing.saving.entity.Transaction;
import com.demo.hcl.ing.saving.utils.AccountUtils;

@Service
public class TransactionServiceImpl implements TransactionService {

	Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
	@Autowired
	TransactionDao transactionDao;
	@Autowired
	AccountUtils accountUtils;
	@Autowired
	AccountService accountService;
	@Autowired
	AccountDao accountDao;
	@Autowired
	BeneficiaryDao beneficiaryDao;

	public Transaction performTransaction(Transaction trans) {
		Transaction transaction = null;
		Boolean status = false;
		Boolean flag = false;
		try {
			Double amountToTransfer = trans.getBalance();
			Double debitAccountBalance = getBalance(trans.getFromAccount());
			if (debitAccountBalance != null) {
				status = validateBalances(debitAccountBalance, amountToTransfer);
				if (status) {
					flag = validateBeneficiary(trans);
					logger.info("perform trans Flag = " + flag);
					if (flag) {
						if (status) {
							trans.setTransactionId(accountUtils.generateNewTransactionId());
							trans.setTransactionDate(new Date());
							transaction = transactionDao.save(trans);
						}
						updateDebitAccountBalance(trans, debitAccountBalance);
						Double creditAccountBalance = getBalance(trans.getToAccount());
						updateCreditAccountBalance(trans, creditAccountBalance);
					} else {
						logger.info("Account is not associated with beneficiary");
					}
				}
			} else {
				logger.info("unbale to find balance for debit account details");
			}
		} catch (Exception e) {
			logger.error("Exception occured while performing transaction" + e);
			transaction = null;

		}
		return transaction;

	}

	public Double getBalance(Long accountNumber) {
		Account accountdetails = null;
		Double balance = null;
		try {
			accountdetails = accountService.findByAccountNumber(accountNumber);
			if (accountdetails != null) {
				balance = accountdetails.getBalance();
			} else {
				logger.info("Account details not found in DB");
			}
		} catch (Exception e) {
			logger.error("Exception occured while getting balance" + e);
		}
		return balance;
	}

	public Boolean validateBalances(Double debitAccountBalance, Double amountToTransfer) {
		Boolean status = false;
		try {
			if (debitAccountBalance != null && amountToTransfer != null) {
				if (debitAccountBalance < amountToTransfer) {
					status = false;
				} else {
					status = true;
				}
			} else {
				logger.info("debitAccountBalance and debitAccountBalance cannot be null");
			}
		} catch (Exception e) {
			logger.error("Exception occured while validating balance" + e);
		}
		return status;
	}

	public void updateDebitAccountBalance(Transaction accountTransaction, Double debitAccountBalance) {
		Account accountdetails = accountService.findByAccountNumber(accountTransaction.getFromAccount());
		try {
			if (accountdetails != null) {
				Account account = new Account();
				account.setAccountNumber(accountTransaction.getFromAccount());
				account.setBalance(debitAccountBalance - (accountTransaction.getBalance()));
				account.setAccountBranch(accountdetails.getAccountBranch());
				account.setIfscCode(accountdetails.getIfscCode());
				accountDao.save(account);
			}
		} catch (Exception e) {
			logger.error("Error while updating balance in sender account");
		}
	}

	public void updateCreditAccountBalance(Transaction accountTransaction, Double creditAccountBalance) {
		try {
			Account accountdetails = accountService.findByAccountNumber(accountTransaction.getToAccount());
			if (accountdetails != null) {
				Account account = new Account();
				account.setAccountNumber(accountTransaction.getToAccount());
				account.setBalance(creditAccountBalance + (accountTransaction.getBalance()));
				account.setAccountBranch(accountdetails.getAccountBranch());
				account.setIfscCode(accountdetails.getIfscCode());
				accountDao.save(account);
			}
		} catch (Exception e) {
			logger.error("Error while updating balance in credit account");
		}

	}

	public Boolean validateBeneficiary(Transaction transaction) {
		Boolean flag = false;
		try {
			logger.info("Transaction details are = " + transaction);
			List<Beneficiary> beneficiaryList = fetchListOfBeneficiaries(transaction.getFromAccount());
			if (beneficiaryList != null) {
				logger.info("List of beneficiaryList " + beneficiaryList);
				for (Beneficiary bf : beneficiaryList) {
					if (bf.getBeneficiaryAccountNumber().equals(transaction.getToAccount())) {
						flag = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.error("Exception occured while validating beneficiary");
		}
		logger.info("flag = " + flag);
		return flag;
	}
	
	public List<Beneficiary> fetchListOfBeneficiaries(Long customerNumber){
		
		List<Beneficiary> beneficiaryList =null;
		 beneficiaryList = beneficiaryDao.findByCustomerAccountNumber(customerNumber);
		
		return beneficiaryList;
		
	}
	

}
