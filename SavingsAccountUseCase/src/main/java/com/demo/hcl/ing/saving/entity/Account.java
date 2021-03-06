package com.demo.hcl.ing.saving.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	private Long accountNumber;
	private String accountBranch;
	private String ifscCode;
	private Double balance;
	private String accountType;
	
	public Account()
	{
		super();
	}
	
	
	public String getAccountBranch() {
		return accountBranch;
	}
	public void setAccountBranch(String accountBranch) {
		this.accountBranch = accountBranch;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountBranch=" + accountBranch + ", ifscCode=" + ifscCode
				+ ", balance=" + balance + ", accountType=" + accountType + "]";
	}


	public Account(Long accountNumber, String accountBranch, String ifscCode, Double balance, String accountType) {
		super();
		this.accountNumber = accountNumber;
		this.accountBranch = accountBranch;
		this.ifscCode = ifscCode;
		this.balance = balance;
		this.accountType = accountType;
	}


	public Long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}
