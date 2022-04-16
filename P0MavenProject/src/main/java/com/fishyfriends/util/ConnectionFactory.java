package com.fishyfriends.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//create the connection factory class
public class ConnectionFactory {
	
	//create a method to generate & return a connection. Henceforth, ConnectionFactory.getConnection(); will be called to return connections.
	public static Connection getConnection() {
		Connection conn = null;
		try {
		conn = DriverManager.getConnection(System.getenv("db_url"), 
				System.getenv("db_username"), 
				System.getenv("db_password")
				);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}