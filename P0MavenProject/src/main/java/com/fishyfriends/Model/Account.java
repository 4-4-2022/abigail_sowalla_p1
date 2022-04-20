package com.fishyfriends.Model;

public class Account {

	public int accountID;
	public String accountName;
	public float accountBalance;
	
	public Account(int accountID, String accountName, float accountBalance) {
		super();
		
		this.accountID = accountID;
		this.accountName = accountName;
		this.accountBalance = accountBalance;
	}
	
	//set how accounts will be printed
	@Override
	public String toString() {
		return "ID#: " + accountID + ") Account name: " + accountName + ". Balance: " + accountBalance + ".";
	}
}
