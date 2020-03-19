package com.demo.hcl.ing.saving.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hcl.ing.saving.dao.BeneficiaryDao;
import com.demo.hcl.ing.saving.entity.Beneficiary;
import com.demo.hcl.ing.saving.utils.AccountUtils;

@Service
public class RegisterNewBeneficiaryImpl implements RegisterNewBeneficiary {
	Logger logger = LoggerFactory.getLogger(RegisterNewBeneficiaryImpl.class);
	@Autowired
	BeneficiaryDao beneficiaryDao;
	@Autowired
	AccountUtils accountUtils;

	@Override
	public Beneficiary saveBeneficiary(Beneficiary beneficiary) {
		Beneficiary savedbeneficiary = null;
		try {
				savedbeneficiary = beneficiaryDao.save(beneficiary);
			
		} catch (Exception e) {
			logger.error("Error occured while saving beneficiary" + e);
			e.printStackTrace();
		}
		return savedbeneficiary;
	}
}
