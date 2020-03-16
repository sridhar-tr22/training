package com.hcl.ing.TestDependencies.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounttransaction")
public class AccountTransaction {
	@Id
	private Long transactionId;
	private Long fromAccount;
	private Long toAccount;
	private Double balance;
	private String transactionDate;
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public Long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Long getToAccount() {
		return toAccount;
	}
	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public AccountTransaction(Long transactionId, Long fromAccount, Long toAccount, Double balance,
			String transactionDate) {
		super();
		this.transactionId = transactionId;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.balance = balance;
		this.transactionDate = transactionDate;
	}
	@Override
	public String toString() {
		return "AccountTransaction [transactionId=" + transactionId + ", fromAccount=" + fromAccount + ", toAccount="
				+ toAccount + ", balance=" + balance + ", transactionDate=" + transactionDate + "]";
	}
	
	public AccountTransaction()
	{
		super();
	}
	
	
	

}
