package com.fishyfriends.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.fishyfriends.util.ConnectionFactory;
import com.fishyfriends.util.ResourceCloser;
import com.fishyfriends.Model.Animal;


public class AnimalDAO {
	
	//declare private static to make a Singleton
	private static AnimalDAO animalList;
	
	//add a constructor
	private AnimalDAO() {}
	
	public static AnimalDAO getAnimals() {
		if(animalList == null) {
			animalList = new AnimalDAO();
		}
		return animalList;
	}
	
	public Set<Animal> findAllAnimals(){
		
		Set<Animal> animals = new HashSet<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from animals";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			System.out.println(set);
			
			while(set.next()) {
				animals.add(new Animal(
						set.getInt(1),
						set.getString(2),
						set.getFloat(6),
						set.getString(3),
						set.getBoolean(4),
						set.getString(5)
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
		return animals;
	}
	
}
