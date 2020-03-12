package com.example.demo.ValueObjects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
@EnableAutoConfiguration
@Entity
@Table(name="ACCOUNT")
public class Account {

@Id	

private Long accountNumber;
private String	ifsc;
private String	accountType;
private Double	 availableBalance;
private String	accountStatus;


public Long getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(Long accountNumber) {
	this.accountNumber = accountNumber;
}
public String getIfsc() {
	return ifsc;
}
public void setIfsc(String ifsc) {
	this.ifsc = ifsc;
}
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
public Double getAvailableBalance() {
	return availableBalance;
}
public void setAvailableBalance(Double availableBalance) {
	this.availableBalance = availableBalance;
}
public String getAccountStatus() {
	return accountStatus;
}
public void setAccountStatus(String accountStatus) {
	this.accountStatus = accountStatus;
}
@Override
public String toString() {
	return "Account [accountNumber=" + accountNumber + ", ifsc=" + ifsc + ", accountType=" + accountType
			+ ", availableBalance=" + availableBalance + ", accountStatus=" + accountStatus + "]";
}


}
