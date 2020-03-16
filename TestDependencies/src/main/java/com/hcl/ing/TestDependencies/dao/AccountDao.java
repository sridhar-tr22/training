package com.hcl.ing.TestDependencies.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.TestDependencies.entity.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {
	
	public Account findByAccountNumber(Long accountNumber);

}
