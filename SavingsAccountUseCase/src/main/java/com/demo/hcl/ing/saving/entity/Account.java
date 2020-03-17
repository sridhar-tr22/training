package com.demo.hcl.ing.saving.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountNumber;
	private String accountBranch;
	private String ifscCode;

	public Account(Long accountNumber, String accountBranch, String ifscCode) {
		super();
		this.accountNumber = accountNumber;
		this.accountBranch = accountBranch;
		this.ifscCode = ifscCode;
	}

	public Account() {
		super();
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
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

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountBranch=" + accountBranch + ", ifscCode=" + ifscCode
				+ "]";
	}

}
