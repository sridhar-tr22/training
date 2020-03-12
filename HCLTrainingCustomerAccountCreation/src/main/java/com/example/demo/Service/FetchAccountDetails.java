package com.example.demo.Service;

import com.example.demo.ValueObjects.Account;

public interface FetchAccountDetails {
	
	public <List>Account getAccountDetailsByIfsc(String ifsc);
	

}
