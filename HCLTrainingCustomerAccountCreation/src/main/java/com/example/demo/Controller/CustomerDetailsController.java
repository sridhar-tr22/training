package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.FetchAccountDetailsImpl;
import com.example.demo.Service.NewCustomerAccountCreation;
import com.example.demo.ValueObjects.Customer;


@Component
@RestController
public class CustomerDetailsController {
	
	@Autowired
	NewCustomerAccountCreation newCustomerAccountCreation;
	@Autowired
	FetchAccountDetailsImpl fetchAccountDetailsImpl;

	@GetMapping("/")
	public String insideApp()
	{
		return "hitting services";
	}
	
	@PostMapping(path = "/newaccountopening")
	public Customer newAccountCustomerDetails(@RequestBody Customer customer)
	{				
		System.out.println("In Post Method" +customer);
		newCustomerAccountCreation.saveCustomerDetails(customer);
		return customer;
	}
	
	@GetMapping("searchbyifsccode/{ifsc}")
	public String getUser(@PathVariable String ifsc)
	{
		fetchAccountDetailsImpl.getAccountDetailsByIfsc(ifsc);
		System.out.println(ifsc);
	 return "HTTP Get was called";
	}
}
