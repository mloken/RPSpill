package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Item;

public class JDBC {

	public static void addItems(Item item) throws Exception {
		System.out.println("Adding item...");
		if (existingWeapon(item)) {
			System.out.println("Item already exists.");
			return;
		}
		String query = "INSERT INTO weapon VALUES (null, '" + item.name + "', " +
				"'" + item.type + "', '" + item.level + "' , '" + item.str + "', '" + item.dex + "'," +
				" '" + item.intel + "', '" + item.dmg + "', '"+ item.quality + "');";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RPGame?"
							+ "user=bent&password=bentpw");
			
			stmt = conn.createStatement();
			stmt.executeQuery("use RPGame"); 
			
			stmt.executeUpdate(query);
			System.out.println("Item added");
			// PreparedStatements can use variables and are more efficient
			
			prepStmt = conn.prepareStatement("Select * from weapon");
			prepStmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public static boolean existingWeapon(Item item) {
		String query = "SELECT name FROM weapon WHERE weapon.name = '" + item.name + "'";
		try {
			ResultSet rs = null;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RPGame?user=bent&password=bentpw");
			stmt = conn.createStatement();
			stmt.executeQuery("use RPGame"); 
			
			rs = stmt.executeQuery(query);
			if (!rs.next()) 
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return true;
	}

	public static void addUser(CreateUser user) {
		String query = "INSERT INTO user VALUES (null, '" + user.u + "', '" + user.p + "', '0')";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RPGame?user=bent&password=bentpw");
			stmt = conn.createStatement();
			stmt.executeQuery("use RPGame"); 
			
			stmt.executeUpdate(query);
			System.out.println("\nUser '" + user.u + "' created.\n");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static boolean UsernameExists(String username) {
		String query = "SELECT username FROM user WHERE user.username = '" + username + "'";
		try {
			ResultSet rs = null;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RPGame?user=bent&password=bentpw");
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			if (!rs.next())
				//ResultSet is empty 
				return false; //Username doesn't exist

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return true;
	}
	
	public static boolean logIn(String username, String password) {
		String query = "SELECT username FROM user WHERE user.username = '" + username + "' " +
				"AND user.password = '" + password + "'";
		try {
			ResultSet rs = null;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RPGame?user=bent&password=bentpw");
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			if (!rs.next())
				//ResultSet is empty 
				return false; //Username/Password doesn't exist/is wrong

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return true;
	}
	// You need to close the resultSet
	

	public static void createCharacter(String owner, String username) {
		String query = "INSERT INTO karakter values(null, '" + owner + "', '" + username + "', '" +
			"1', '0', '100', '100', '1', '1', '1')";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RPGame?user=bent&password=bentpw");
			stmt = conn.createStatement();
			stmt.executeQuery("use RPGame"); 
			
			stmt.executeUpdate(query);
			System.out.println("\nCharacter '" + username + "' created.\n");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			
			if (stmt != null) {
				stmt.close();
			}
			
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static Connection conn = null;
	static Statement stmt = null;
	static PreparedStatement prepStmt = null;
	static ResultSet rs = null;
	ArrayList<Item> items = new ArrayList<Item>();

}
