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
		if (existingWeapon(item)) {
			System.out.println("Item already exists.");
			return;
		}
		String query = "INSERT INTO weapon VALUES (null, '" + item.name + "', '" + item.rClass + "', " +
				"'" + item.type + "', '" + item.level + "' , '" + item.str + "', '" + item.dex + "'," +
				" '" + item.intel + "', '" + item.AtkDmg + "', '"+ item.quality + "');";
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
			while (!rs.next()) {
				
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return true;
	}

	public static boolean existingUsername(String username) {
		String query = "SELECT username FROM karakter WHERE karakter.usename = '" + username + "'";
		try {
			ResultSet rs = null;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RPGame?user=bent&password=bentpw");
			stmt = conn.createStatement();
			stmt.executeQuery("use RPGame"); 
			
			rs = stmt.executeQuery(query);
			if (rs == null) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return true;
	}
	
	public static void addUser(CreateUser user) {

		String query = "UPDATE karakter SET (null, '" + user.username + "', '" + user.password + "', null)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RPGame?user=bent&password=bentpw");
			stmt = conn.createStatement();
			stmt.executeQuery("use RPGame"); 
			
			stmt.executeUpdate(query);
			System.out.println("User added");
			// PreparedStatements can use variables and are more efficient
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	// You need to close the resultSet
	private static void close() {
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
