package com.example.demo.ValueObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
@EnableAutoConfiguration
@Entity
@Table(name="CUSTOMER")
public class Customer {

	@Id
	
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
private Integer id;	
	@Column(name="NAME")
private String	customerName;
	
	@Column(name="ADDRESS")
private String	customerAddress;
	
	@Column(name="CONTACT")
private String	customerContact;
	
	@Column(name="EMAIL")
private String	customerEmail;
	
	@Column(name="DOB")
private String	customerDOB;
	@Column(name="ELIGIBLE")
private String	isEligible;


public Customer(Integer id, String customerName, String customerAddress, String customerContact, String customerEmail,
		String customerDOB, String isEligible) {
	super();
	this.id = id;
	this.customerName = customerName;
	this.customerAddress = customerAddress;
	this.customerContact = customerContact;
	this.customerEmail = customerEmail;
	this.customerDOB = customerDOB;
	this.isEligible = isEligible;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getCustomerAddress() {
	return customerAddress;
}
public void setCustomerAddress(String customerAddress) {
	this.customerAddress = customerAddress;
}
public String getCustomerContact() {
	return customerContact;
}
public void setCustomerContact(String customerContact) {
	this.customerContact = customerContact;
}
public String getCustomerEmail() {
	return customerEmail;
}
public void setCustomerEmail(String customerEmail) {
	this.customerEmail = customerEmail;
}
public String getCustomerDOB() {
	return customerDOB;
}
public void setCustomerDOB(String customerDOB) {
	this.customerDOB = customerDOB;
}
public String getIsEligible() {
	return isEligible;
}
public void setIsEligible(String isEligible) {
	this.isEligible = isEligible;
}
@Override
public String toString() {
	return "Customer [customerName=" + customerName + ", customerAddress=" + customerAddress + ", customerContact="
			+ customerContact + ", customerEmail=" + customerEmail + ", customerDOB=" + customerDOB + ", isEligible="
			+ isEligible + "]";
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}



}
