package com.demo.hcl.ing.saving.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.hcl.ing.saving.controller.AccountController;
import com.demo.hcl.ing.saving.controller.response.ResponseObject;
import com.demo.hcl.ing.saving.dto.BeneficiaryDTO;
import com.demo.hcl.ing.saving.dto.CustomerDTO;
import com.demo.hcl.ing.saving.entity.Account;
import com.demo.hcl.ing.saving.entity.Beneficiary;
import com.demo.hcl.ing.saving.entity.Customer;
import com.demo.hcl.ing.saving.entity.CustomerCredentials;
import com.demo.hcl.ing.saving.service.RegisterNewBeneficiary;
import com.demo.hcl.ing.saving.service.RegisterNewCustomer;
import com.demo.hcl.ing.saving.service.TransactionService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.Matchers.any;

@WebMvcTest
public class AccountControllerTest {
	
	private CustomerCredentials customerCredentials;
	private Customer customer;
	
	private Beneficiary beneficiary;
	private BeneficiaryDTO beneficiaryDTO;
	
	private String registerJsonData = "{\r\n" + 
			"    \"customer\": {\r\n" + 
			"        \"firstName\": \"Deepak\",\r\n" + 
			"        \"middleName\": \"\",\r\n" + 
			"        \"lastName\": \"kasgar\",\r\n" + 
			"        \"gender\": \"male\",\r\n" + 
			"        \"address1\": \"203 Prem ganj\",\r\n" + 
			"        \"address2\": \"Sipri Bazar\",\r\n" + 
			"        \"city\": \"Jhansi\",\r\n" + 
			"        \"state\": \"Uttar Pradesh\",\r\n" + 
			"        \"zipCode\": \"284003\",\r\n" + 
			"        \"phoneNumber\": \"+91 9972207104\",\r\n" + 
			"        \"emailAddress\": \"dkasgar1@gmail.com\",\r\n" + 
			"        \"accountOpeningBalance\": 1000,\r\n" + 
			"        \"dateOfBirth\": \"16/09/1989\",\r\n" + 
			"        \"citizenship\": \"Indian\",\r\n" + 
			"        \"aadharNumber\": \"120076511771\",\r\n" + 
			"        \"passportNumber\": \"K7T891\",\r\n" + 
			"        \"accountType\": \"Savings\",\r\n" + 
			"        \"password\": \"kasgar\",\r\n" + 
			"        \"account\": [\r\n" + 
			"            {\r\n" + 
			"                \"ifscCode\": \"Savings\",\r\n" + 
			"                \"accountBranch\": \"Electronic City\",\r\n" + 
			"                \"balance\": 2000\r\n" + 
			"            }\r\n" + 
			"        ]\r\n" + 
			"    }\r\n" + 
			"}";
	
	
	@InjectMocks
	private AccountController accountController;

	private MockMvc mockMvc;
	
	@MockBean
	private RegisterNewCustomer registerNewCustomer;
	
	@MockBean
	private RegisterNewBeneficiary registerNewBeneficiary;
	
	@MockBean
	private TransactionService transactionService;
	
	@BeforeEach
	public void setup( ) {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
		
		customerCredentials = new CustomerCredentials();
		customerCredentials.setEmail("dkasgar1@gmail.com");
		customerCredentials.setPassword("kasgar");

		customer = new Customer();
		customer.setEmailAddress("dkasgar1@gmail.com");
		customer.setPassword("kasgar");
	}
	
	
	@Test
	public void newCustomerRegistrationDetailsTest() throws Exception
	{
		Customer customer = new Customer();
	        Account account = new Account();
	        List<Account> list = new ArrayList<Account>();
	        customer.setCustomerId("1");
	        customer.setFirstName("Deepak");
	        customer.setMiddleName("");
	        customer.setLastName("Kasgar");
	        customer.setGender("male");
	        customer.setAddress1("203 Prem ganj");
	        customer.setAddress2("Sipri Bazar");
	        customer.setCity("Jhansi");
	        customer.setState("Uttar Pradesh");
	        customer.setZipCode(284003);
	        customer.setPhoneNumber("+91 9972207104");
	        customer.setEmailAddress("dkasgar1@gmail.com");
	        customer.setAccountOpeningBalance(1000);
	        customer.setDateOfBirth("16/09/1989");
	        customer.setCitizenship("Indian");
	        customer.setAadharNumber("120076511771");
	        customer.setAccountType("Savings");
	        customer.setPassword("kasgar");
	        account.setAccountNumber(1L);
	        account.setAccountBranch("Electronic City");
	        account.setIfscCode("ING00001");
	        account.setBalance(2000.0);
	        list.add(account);
	        customer.setAccount(list);
	        
	        beneficiary = new Beneficiary();
			beneficiaryDTO = new BeneficiaryDTO();
			beneficiaryDTO.setBeneficiary(beneficiary);
			beneficiary.setAccountHolderName("Deepak Kasgar");
			beneficiary.setAccountBranch("Kormangla");
			beneficiary.setAccountType("Savings");
			beneficiary.setBeneficiaryAccountNumber(3L);
			beneficiary.setCreatedBy("Dk");
			beneficiary.setCustomerAccountNumber(1L);
			beneficiary.setNickName("Deepak");
			beneficiary.setRegisterPayerfor("Other Bank Transfers");
			beneficiary.setId(1);
		
		ResponseObject responseObject;
		
		Mockito.when(registerNewCustomer.newCustomerDetails(customer)).thenReturn(customer);
		
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomer(customer);
		
		ResponseEntity<ResponseObject> responseEntity = accountController.newCustomerRegistrationDetails(customerDTO);
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		
		  MvcResult andReturn = mockMvc.perform(post("/bank/register") .content(registerJsonData)
		  .contentType(MediaType.APPLICATION_JSON))
		  .andReturn();
		  /*.andExpect(jsonPath("$.message.statusCode", is("200")))
		  .andExpect(jsonPath("$.message.message",
		 is("Account Created Successfully."))) .andExpect(status().isOk());*/
		 
		  
		 // MockMvcRequestBuilders builders
	}
	
	@Test
	public void testCheckLoginPositive() {
		Mockito.when(registerNewCustomer.validateUser(customerCredentials)).thenReturn(true);
		boolean response = registerNewCustomer.validateUser(customerCredentials).booleanValue();
		assertEquals(true, response);
	}
	
	@Test
	public void testNewBeneficiaryPositive() {
		
		beneficiary = new Beneficiary();
		beneficiaryDTO = new BeneficiaryDTO();
		beneficiaryDTO.setBeneficiary(beneficiary);
		beneficiary.setAccountHolderName("Deepak Kasgar");
		beneficiary.setAccountBranch("Kormangla");
		beneficiary.setAccountType("Savings");
		beneficiary.setBeneficiaryAccountNumber(3L);
		beneficiary.setCreatedBy("Dk");
		beneficiary.setCustomerAccountNumber(1L);
		beneficiary.setNickName("Deepak");
		beneficiary.setRegisterPayerfor("Other Bank Transfers");
		beneficiary.setId(1);
		Mockito.when(registerNewBeneficiary.saveBeneficiary(beneficiary)).thenReturn(beneficiary);
		ResponseEntity<ResponseObject> response = accountController.addNewBeneficiary(beneficiaryDTO);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@Disabled
	public void testNewBeneficiaryNegative() {
		Beneficiary beneficiary1 = new Beneficiary();
		Mockito.when(registerNewBeneficiary.saveBeneficiary(beneficiary1)).thenReturn(beneficiary1);
		ResponseEntity<ResponseObject> response = accountController.addNewBeneficiary(beneficiaryDTO);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
