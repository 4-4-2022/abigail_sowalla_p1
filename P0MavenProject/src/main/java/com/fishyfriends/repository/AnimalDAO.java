package com.fishyfriends.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fishyfriends.util.ConnectionFactory;
import com.fishyfriends.util.ResourceCloser;
import com.fishyfriends.Model.Animal;


public class AnimalDAO {
	
	//declare private static to make a Singleton
	private static AnimalDAO animalList;
	
	//add a constructor
	private AnimalDAO() {}
	
	public static synchronized AnimalDAO getAnimals() {
		if(animalList == null) {
			animalList = new AnimalDAO();
		}
		return animalList;
	}
	
	//To generate an arraylist from the database table for Animals:
	public static ArrayList<Animal> findAllAnimals(){
		
		ArrayList<Animal> animals = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from animals";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			//System.out.println(set);
			
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
	
	//to add an animal:
	public static void addAnimal(String name, String difficulty, boolean isSocial, String waterType, float price) {
		
		int id = 14;
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "insert into animals values(?,?,?,?,?,?)";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1,id);
			stmt.setString(2,name);
			stmt.setString(3,difficulty);
			stmt.setBoolean(4,isSocial);
			stmt.setString(5,waterType);
			stmt.setFloat(6,price);
			stmt.execute();
			
			//code to add an animal
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			/*try {
				conn.close();
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}*/
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
	}
	
	public static void removeAnimal(int id) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "delete from animals where animal_id=?";
		
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
	
	public static void editAnimalPrice(int id, float price) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "update animals set animal_price = ? where animal_id=?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setFloat(1,price);
			stmt.setInt(2,id);
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
	}
	
	public static void editAnimalName(int id, String name) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "update animals set animal_name = ? where animal_id=?";
		
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
	
	public static void editAnimalDifficulty(int id, String difficulty) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "update animals set animal_difficulty = ? where animal_id=?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1,difficulty);
			stmt.setInt(2,id);
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
	}
	
	public static void editAnimalSocial(int id, boolean isSocial) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "update animals set animal_issocial = ? where animal_id=?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setBoolean(1,isSocial);
			stmt.setInt(2,id);
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
	}
	
	public static void editAnimalWater(int id, String water) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "update animals set animal_watertype = ? where animal_id=?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1,water);
			stmt.setInt(2,id);
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
	}
	
}
