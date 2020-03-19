package com.demo.hcl.ing.saving.utils;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountUtils {
	Logger logger = LoggerFactory.getLogger(AccountUtils.class);
	public Long generateNewAccountNumber() {
		Random rnd = new Random();
		char[] digits = new char[11];
		Long generatedAccountNumber= null;	
		try {
		digits[0] = (char) (rnd.nextInt(9) + '1');
		for (int i = 1; i < digits.length; i++) {
			digits[i] = (char) (rnd.nextInt(10) + '0');
		}
		generatedAccountNumber = Long.parseLong(new String(digits));
		}catch(Exception e) {
			logger.error("Exception occured while generating account number "+e);
			generatedAccountNumber=null;
		}		
		return generatedAccountNumber;
	}
	
	public String generateCustomerId() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(7);
		String generatedCustomerId = null;
		try {
			for (int i = 0; i < 7; i++) {
				int index = (int) (AlphaNumericString.length() * Math.random());
				sb.append(AlphaNumericString.charAt(index));
			}
			if (sb != null) {
				generatedCustomerId = sb.toString();
			}
		} catch (Exception e) {
			logger.error("Exception occured while generating Customer Id " + e);
		}
		return generatedCustomerId;

	}

	public Long generateNewTransactionId() {
		Random rnd = new Random();
		char[] digits = new char[11];
		Long generatedTransactionId = null;
		digits[0] = (char) (rnd.nextInt(9) + '1');
		try {
			for (int i = 1; i < digits.length; i++) {
				digits[i] = (char) (rnd.nextInt(10) + '0');
			}
			generatedTransactionId = Long.parseLong(new String(digits));
		} catch (Exception e) {
			logger.error("Error while generating Transaction Id" + e);
		}
		return generatedTransactionId;
	}

}