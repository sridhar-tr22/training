package com.demo.hcl.ing.saving.dao;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.demo.hcl.ing.saving.entity.Transaction;
import com.demo.hcl.ing.saving.service.customerdetails.Utils;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
class TransactionDaoTest {

	@Autowired
	TransactionDao transactionDao;
	
	@Test
	void test() {
		SoftAssertions assertions = new SoftAssertions();
		Utils u = new Utils();
		Transaction tx = u.getMockTransaction();
		Transaction trx = transactionDao.save(tx);
		
		assertions.assertThat(tx).as("Trans")
        .isEqualToComparingOnlyGivenFields(trx, "fromAccount","toAccount","balance");
		
		
	}

}
