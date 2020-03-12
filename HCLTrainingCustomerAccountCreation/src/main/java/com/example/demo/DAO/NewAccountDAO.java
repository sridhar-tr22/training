package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.ValueObjects.Account;
@Repository
public interface NewAccountDAO extends JpaRepository<Account, Long> {

	
	@Query(value = "SELECT * FROM ACCOUNT u WHERE u.ifsc = ING00784")
			List<Account> findByIFSC();
}
