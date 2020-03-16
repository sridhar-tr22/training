package com.hcl.ing.TestDependencies.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountNumber;
	private String ifscCode;
	private String bankAddress;
	private Double balance;
	

	

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Account(Long accountNumber, String ifscCode, String bankAddress, Double balance) {
		super();
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.bankAddress = bankAddress;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", ifscCode=" + ifscCode + ", bankAddress=" + bankAddress
				+ ", balance=" + balance + "]";
	}

	public Account(Long accountNumber, String ifscCode, String bankAddress) {
		super();
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.bankAddress = bankAddress;
	}
	
	public Account()
	{
		
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	
	
	
	

}
