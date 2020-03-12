package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ValueObjects.Customer;

@Repository
	public interface NewCustomerDAO extends JpaRepository<Customer,Integer>{
	   
}
