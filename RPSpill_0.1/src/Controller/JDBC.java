package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Item;
import model.Monsters;
import model.Skills;

public class JDBC {
	
	static Connection conn = null;
	static Statement stmt = null;
	static PreparedStatement prepStmt = null;
	static ResultSet rs = null;
	ArrayList<Item> items = new ArrayList<Item>();

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
		return tryCatch(query);
	}

	public static void addUser(CreateUser user) {
		String query = "INSERT INTO user VALUES (null, '" + user.u + "', '" + user.p + "')";
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
	
	public static boolean existingUsername(String username) {
		String query = "SELECT username FROM user WHERE user.username = '" + username + "'";
		return tryCatch(query);
	}
	
	public static boolean logIn(String username, String password) {
		String query = "SELECT username FROM user WHERE user.username = '" + username + "' " +
				"AND user.password = '" + password + "'";
		return tryCatch(query);
	}

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

	public static boolean existingCharacterName(String u) {
		String query = "SELECT name FROM karakter WHERE karakter.name = '" + u + "'";
		return (tryCatch(query));
	}
	
	public static void deleteCharacter(String name) {
		String query = "DELETE FROM karakter WHERE name = '" + name + "'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RPGame?user=bent&password=bentpw");
			stmt = conn.createStatement();
			stmt.executeQuery("use RPGame"); 
			
			stmt.executeUpdate(query);
			System.out.println("\nCharacter '" + name + "' deleted.\n");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static boolean tryCatch(String q) {
		try {
			ResultSet rs = null;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RPGame?user=bent&password=bentpw");
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(q);
			if (!rs.next())
				return false; 

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return true;
	}
	
	public static ArrayList<String> characterList(String owner) {
		String query = "SELECT name FROM karakter WHERE karakter.user_owner = '"
				+ owner + "' GROUP BY id";
		ArrayList<String> list = new ArrayList<String>();
		try {
			ResultSet rs = null;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/RPGame?user=bent&password=bentpw");
			stmt = conn.createStatement();

			rs = stmt.executeQuery(query);
			while (rs.next()) {
				list.add(rs.getString("name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void createMonster(Monsters mon) {
		String query = "INSERT INTO monster values(null, '" + mon.name + "', '" + mon.level + "', '" +
				mon.hp + "', '" + mon.mp + "', '" + mon.armour + "', '" + mon.expReward + "')";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RPGame?user=bent&password=bentpw");
				stmt = conn.createStatement();
				stmt.executeQuery("use RPGame"); 
				
				stmt.executeUpdate(query);
				System.out.println("\nCharacter '" + mon.name + "' created.\n");
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}


	public static boolean existingMonster(String name) {
		String query = "SELECT name FROM monster WHERE monster.name = '" + name + "'";
		return tryCatch(query);
	}
	
	public static void createSkills(Skills skill) {
		if (existingSkill(skill.name)) {
			System.out.println("Skill already exists.");
			return;
		}
		String query = "INSERT INTO monster values(null, '" + skill.name + "', '" + skill.dmg + "')";
		try {		Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RPGame?user=bent&password=bentpw");
				stmt = conn.createStatement();
				stmt.executeQuery("use RPGame"); 
				
				stmt.executeUpdate(query);
				System.out.println("\nSkill '" + skill.name + "' created.\n");
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}
	
	public static boolean existingSkill(String name) {
		String query = "SELECT name FROM skills WHERE skills.name = '" + name + "'";
		return tryCatch(query);
	}

		// TODO Auto-generated method stub
		
	
	
	

}
