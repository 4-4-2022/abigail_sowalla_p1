package com.fishyfriends.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fishyfriends.util.ConnectionFactory;
import com.fishyfriends.util.ResourceCloser;
import com.fishyfriends.Model.Animal;
import com.fishyfriends.Model.User;
import com.fishyfriends.client.AppUI;
import com.fishyfriends.client.Flows;

public class UserDAO {
	
	final static Logger logger = LoggerFactory.getLogger(Flows.class);
	
	private static UserDAO userList;
	
	private UserDAO() {}
	
	private static synchronized UserDAO getUsers() {
		if(userList==null) {
			userList=new UserDAO();
		}
		return userList;
	}
	
	//To generate an arraylist from the database table for Users:
		public static ArrayList<User> findAllUsers(){
			
			ArrayList<User> users = new ArrayList<>();
			
			Connection conn = null;
			Statement stmt = null;
			ResultSet set = null;
			final String SQL = "select * from users";
			
			try {
				conn = ConnectionFactory.getConnection();
				stmt = conn.createStatement();
				set = stmt.executeQuery(SQL);
				//System.out.println(set);
				
				while(set.next()) {
					users.add(new User(
							set.getString(2),
							set.getInt(1),
							set.getString(3),
							set.getBoolean(4),
							set.getString(5),
							set.getString(6),
							set.getString(7),
							set.getInt(8),
							set.getString(9),
							set.getInt(10),
							set.getBoolean(11),
							set.getBoolean(12)
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
			return users;
		}
		
		public static ArrayList<User> findUsersByID(){
			
			int userID = AppUI.getUsersID();
			
			ArrayList<User> usersID = new ArrayList<>();
			
			Connection conn = null;
			Statement stmt = null;
			ResultSet set = null;
			final String SQL = "select * from users where user_account_id="+userID;
			
			try {
				conn = ConnectionFactory.getConnection();
				stmt = conn.createStatement();
				set = stmt.executeQuery(SQL);
				
				while(set.next()) {
					usersID.add(new User(
							set.getString(2),
							set.getInt(1),
							set.getString(3),
							set.getBoolean(4),
							set.getString(5),
							set.getString(6),
							set.getString(7),
							set.getInt(8),
							set.getString(9),
							set.getInt(10),
							set.getBoolean(11),
							set.getBoolean(12)
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
			return usersID;
		}
		
		//retrieve user info when a user logs in
		public static User getCurrentUser(String userName){
			
			User currentUser = new User(userName);
			
			Connection conn = null;
			Statement stmt = null;
			ResultSet set = null;
			final String SQL = "select * from users where user_name='"+userName+"'";
			
			try {
				conn = ConnectionFactory.getConnection();
				stmt = conn.createStatement();
				set = stmt.executeQuery(SQL);
				
				set.next();
				
				currentUser.userAccountId=set.getInt(1);
				currentUser.password=set.getString(3);
				currentUser.isPrimary=set.getBoolean(4);
				currentUser.street=set.getString(5);
				currentUser.city=set.getString(6);
				currentUser.state=set.getString(7);
				currentUser.zip=set.getInt(8);
				currentUser.email=set.getString(9);
				currentUser.birthday=set.getInt(10);
				currentUser.isEmployee=set.getBoolean(11);
				currentUser.isAdmin=set.getBoolean(12);

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
			return currentUser;
		}
		
		public static void addUser(String name, int id, String password, boolean isPrimary, String street, String city, String state, int zip, String email, int birthday, boolean isEmployee, boolean isAdmin) {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			final String SQL = "insert into users values(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			try {
				conn = ConnectionFactory.getConnection();
				stmt = conn.prepareStatement(SQL);
				stmt.setString(2,name);
				stmt.setInt(1,id);
				stmt.setString(3,password);
				stmt.setBoolean(4,isPrimary);
				stmt.setString(5,street);
				stmt.setString(6,city);
				stmt.setString(7,state);
				stmt.setInt(8,zip);
				stmt.setString(9,email);
				stmt.setInt(10,birthday);
				stmt.setBoolean(11,isEmployee);
				stmt.setBoolean(12,isAdmin);
				stmt.execute();
			}catch(SQLException e) {
				//e.printStackTrace();
				System.out.println("Sorry, that username was already taken. Please try again.");
			}finally {
				ResourceCloser.closeConnection(conn);
				ResourceCloser.closeStatement(stmt);
			}
		}
		
		public static void addUser(String name, int id, String password, String email) {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			final String SQL = "insert into users values(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			try {
				conn = ConnectionFactory.getConnection();
				stmt = conn.prepareStatement(SQL);
				stmt.setString(2,name);
				stmt.setInt(1,id);
				stmt.setString(3,password);
				stmt.setBoolean(4,false);
				stmt.setString(5,null);
				stmt.setString(6,null);
				stmt.setString(7,null);
				stmt.setInt(8,0);
				stmt.setString(9,email);
				stmt.setInt(10,0);
				stmt.setBoolean(11,false);
				stmt.setBoolean(12,false);
				stmt.execute();
				System.out.println(name+" has been added!\n");
				logger.info("New user added to account #"+id);
			}catch(SQLException e) {
				//e.printStackTrace();
				System.out.println("Sorry, that username was already taken. Please try again.");
			}finally {
				ResourceCloser.closeConnection(conn);
				ResourceCloser.closeStatement(stmt);
			}
		}
		
		public static void removeUser(int id) {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			final String SQL = "delete from users where user_account_id=?";
			
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
		
		public static void removeSingleUser(String userName) {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			final String SQL = "delete from users where user_name=?";
			
			try {
				conn = ConnectionFactory.getConnection();
				stmt = conn.prepareStatement(SQL);
				stmt.setString(1,userName);
				stmt.execute();
				logger.info(userName+" has been removed.");
				System.out.println(userName+" has been removed!\n");
			}catch(SQLException e) {
				System.out.println("Sorry, we couldn't find that user. Double-check that you have the correct username.");
			}finally {
				ResourceCloser.closeConnection(conn);
				ResourceCloser.closeStatement(stmt);
			}
		}
		
		public static void editUserName(String oldName, String newName) {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			final String SQL = "update users set user_name = ? where user_name=?";
			
			try {
				conn = ConnectionFactory.getConnection();
				stmt = conn.prepareStatement(SQL);
				stmt.setString(1,newName);
				stmt.setString(2,oldName);
				stmt.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				ResourceCloser.closeConnection(conn);
				ResourceCloser.closeStatement(stmt);
			}
		}
		
		public static void editUserPassword(String oldName, String newPassword) {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			final String SQL = "update users set user_password = ? where user_name=?";
			
			try {
				conn = ConnectionFactory.getConnection();
				stmt = conn.prepareStatement(SQL);
				stmt.setString(1,newPassword);
				stmt.setString(2,oldName);
				stmt.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				ResourceCloser.closeConnection(conn);
				ResourceCloser.closeStatement(stmt);
			}
		}
		
		public static void editUserEmail(String oldName, String newEmail) {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			final String SQL = "update users set user_email = ? where user_name=?";
			
			try {
				conn = ConnectionFactory.getConnection();
				stmt = conn.prepareStatement(SQL);
				stmt.setString(1,newEmail);
				stmt.setString(2,oldName);
				stmt.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				ResourceCloser.closeConnection(conn);
				ResourceCloser.closeStatement(stmt);
			}
		}
		
		public static void editUserBirthday(String oldName, int newBday) {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			final String SQL = "update users set user_birthday = ? where user_name=?";
			
			try {
				conn = ConnectionFactory.getConnection();
				stmt = conn.prepareStatement(SQL);
				stmt.setInt(1,newBday);
				stmt.setString(2,oldName);
				stmt.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				ResourceCloser.closeConnection(conn);
				ResourceCloser.closeStatement(stmt);
			}
		}
		
		public static void editUserAddress(String oldName, String street, String city, String state, int zip) {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			final String SQL = "update users set user_street = ?, user_city = ?, user_state = ?, user_zip = ? where user_name=?";
			
			try {
				conn = ConnectionFactory.getConnection();
				stmt = conn.prepareStatement(SQL);
				stmt.setString(1,street);
				stmt.setString(2,city);
				stmt.setString(3,state);
				stmt.setInt(4,zip);
				stmt.setString(5,oldName);
				stmt.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				ResourceCloser.closeConnection(conn);
				ResourceCloser.closeStatement(stmt);
			}
		}
}
