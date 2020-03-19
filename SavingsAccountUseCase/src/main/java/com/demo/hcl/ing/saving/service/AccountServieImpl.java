package com.demo.hcl.ing.saving.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hcl.ing.saving.dao.AccountDao;
import com.demo.hcl.ing.saving.entity.Account;

@Service
public class AccountServieImpl implements AccountService {
	Logger logger = LoggerFactory.getLogger(AccountServieImpl.class);
	@Autowired
	AccountDao accountDao;

	@Override
	public Account findByAccountNumber(Long accountNumber) {
		Account accountdetails = null;
		try {
			accountdetails = accountDao.findByAccountNumber(accountNumber);
		} catch (Exception e) {
			logger.error("Error while getting accound details by accountNumber " + e);
		}
		return accountdetails;
	}
}
