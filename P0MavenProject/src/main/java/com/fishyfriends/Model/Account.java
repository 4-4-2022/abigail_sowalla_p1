package com.fishyfriends.Model;

public class Account {

	public int accountID;
	public String accountName;
	public float accountBalance;
	
	public Account(int accountId, String accountName, float accountBalance) {
		super();
		
		this.accountID = accountID;
		this.accountName = accountName;
		this.accountBalance = accountBalance;
	}
}
