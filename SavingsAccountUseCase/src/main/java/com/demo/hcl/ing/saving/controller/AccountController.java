package com.demo.hcl.ing.saving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hcl.ing.saving.dto.BeneficiaryDTO;
import com.demo.hcl.ing.saving.dto.CustomerDTO;
import com.demo.hcl.ing.saving.dto.CustomerLoginDTO;
import com.demo.hcl.ing.saving.dto.TransactionDTO;
import com.demo.hcl.ing.saving.entity.Beneficiary;
import com.demo.hcl.ing.saving.entity.Customer;
import com.demo.hcl.ing.saving.entity.Transaction;
import com.demo.hcl.ing.saving.service.RegisterNewBeneficiary;
import com.demo.hcl.ing.saving.service.RegisterNewCustomer;
import com.demo.hcl.ing.saving.service.TransactionService;

@RestController
public class AccountController {

	@Autowired
	RegisterNewCustomer registerNewCustomer;
	@Autowired
	RegisterNewBeneficiary registerNewBeneficiary;
	@Autowired
	TransactionService transactionService;

	@PostMapping("/register")
	public ResponseEntity<String> newCustomerRegistrationDetails(@RequestBody CustomerDTO customer) {
		System.out.println("Customer is in controller " + customer);
		Customer customerDetails = registerNewCustomer.newCustomerDetails(customer.getCustomer());
		if (customerDetails != null) {
			return new ResponseEntity<>("Customer Details saved successfully!", HttpStatus.OK);
		} else
			return new ResponseEntity<>("Customer Details are not saved", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/login")
	public ResponseEntity<String> applogin(@RequestBody CustomerLoginDTO customerLoginDTO) {
		Boolean b = registerNewCustomer.validateUser(customerLoginDTO.getCustomerCredentials());

		if (b)
			return new ResponseEntity<>("Login Successfully!", HttpStatus.OK);
		else
			return new ResponseEntity<>("Login Unsuccessfull", HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/beneficiary")
	public ResponseEntity<String> addNewBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO) {
		Beneficiary savedBeneficiary = registerNewBeneficiary.saveBeneficiary(beneficiaryDTO.getBeneficiary());
		if (savedBeneficiary != null) {
			return new ResponseEntity<>("Beneficiary Details saved successfully!", HttpStatus.OK);
		} else
			return new ResponseEntity<>("Beneficiary Details are not saved", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/fundTransfer")
	public ResponseEntity<String> beneficiaryFundTransfer(@RequestBody TransactionDTO transactionDTO) {
		Transaction transaction = transactionService.performTransaction(transactionDTO.getTransaction());
		if(transaction!=null)
		{
			return new ResponseEntity<>("Transaction completed successfully!", HttpStatus.OK);
		}
		return new ResponseEntity<>("Transaction completed successfully!", HttpStatus.BAD_REQUEST);
	}
}
