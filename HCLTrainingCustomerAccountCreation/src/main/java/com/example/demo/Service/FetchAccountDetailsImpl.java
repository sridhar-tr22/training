package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.NewAccountDAO;
import com.example.demo.ValueObjects.Account;


@Service
public class FetchAccountDetailsImpl implements FetchAccountDetails {

	@Autowired
	NewAccountDAO newAccountDAO;
	
	
	@Override
	public <List> Account getAccountDetailsByIfsc(String ifscCode) {
		
		System.out.println("IFSCCODE" +ifscCode );
		newAccountDAO.findByIFSC();
		return null;
	}


	

}
