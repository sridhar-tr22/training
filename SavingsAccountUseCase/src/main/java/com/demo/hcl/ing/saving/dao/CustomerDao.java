package com.demo.hcl.ing.saving.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.hcl.ing.saving.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

}
