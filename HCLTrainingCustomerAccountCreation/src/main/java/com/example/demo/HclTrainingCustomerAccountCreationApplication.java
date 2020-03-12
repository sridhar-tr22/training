package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={
		 "com.example.demo.ValueObjects.Customer",
		"com.example.Utils.CustomerAccountUtils","com.example.demo.Controller","com.example.demo.Service"})

public class HclTrainingCustomerAccountCreationApplication {

	public static void main(String[] args) {
		SpringApplication.run(HclTrainingCustomerAccountCreationApplication.class, args);
	}

}
