package com.hcl.bank.ing.CustomerAccount;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewCustomerRepo extends JpaRepository<CustomerDetails, Integer> {

}
