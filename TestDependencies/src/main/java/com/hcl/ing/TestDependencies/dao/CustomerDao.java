package com.hcl.ing.TestDependencies.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.TestDependencies.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
