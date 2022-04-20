package com.fishyfriends.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;

import com.fishyfriends.util.ConnectionFactory;
import com.fishyfriends.util.ResourceCloser;
import com.fishyfriends.Model.Account;
import com.fishyfriends.Model.Animal;

public class AccountDAO {
	private static AccountDAO accountList;
	
	private AccountDAO() {}
	
	public static synchronized AccountDAO getAccounts() {
		if(accountList == null) {
			accountList = new AccountDAO();
		}
		return accountList;
	}
	
	//generate Arraylist from database for accounts
	public static ArrayList<Account> findAllAccounts(){
		
		ArrayList<Account> accounts = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from accounts";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			//System.out.println(set);
			
			while(set.next()) {
				accounts.add(new Account(
						set.getInt(1),
						set.getString(2),
						set.getFloat(3)
						));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeResultSet(set);
			ResourceCloser.closeStatement(stmt);
		}
		return accounts;
	}	
	
	//to add an account
	public static void addAccount(int id, String name, float balance) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "insert into accounts values(?,?,?)";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1,id);
			stmt.setString(2,name);
			stmt.setFloat(3,balance);
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
	}
	
	//remove an account
	public static void removeAccount(int id) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "delete from accounts where account_id=?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1,id);
			stmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
	}
	
	public static void editAccountBalance(int id, float balance) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "update accounts set account_balance = ? where account_id=?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setFloat(1,balance);
			stmt.setInt(2,id);
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
	}
	
	public static void editAccountName(int id, String name) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "update accounts set account_name = ? where account_id=?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1,name);
			stmt.setInt(2,id);
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
	}
	
	public static float getAccountBalance(int id) {
		
		float balance=0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select account_balance from accounts where account_id="+id;
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			set.next();
			balance = set.getFloat(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
		 return balance;
	}
	
	public static int getAccountID(String username) {
		
		int id=0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select user_account_id from users where user_name='"+username+"'";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			set.next();
			id = set.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
		 return id;
	}
	
	
	
}
