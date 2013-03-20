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
	
	static Connection conn = null;
	static Statement stmt = null;
	static PreparedStatement prepStmt = null;
	static ResultSet rs = null;
	
	ArrayList<Item> items = new ArrayList<Item>();

	public static void addItems(Item item) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RPGame?"
							+ "user=bent&password=bentpw");
			
			stmt = conn.createStatement();
			stmt.executeQuery("use RPGame"); 
			
			String query = "INSERT INTO weapon VALUES (null, '" + item.name + "', '" + item.rClass + "', " +
					"'" + item.type + "', '" + item.level + "' , '" + item.str + "', '" + item.dex + "'," +
							" '" + item.intel + "', '" + item.AtkDmg + "', '"+ item.quality + "');";
			System.out.println(query);
			stmt.executeUpdate(query);
			System.out.println("Item added");
			// PreparedStatements can use variables and are more efficient
			
			prepStmt = conn.prepareStatement("Select * from weapon");
			prepStmt.executeQuery();
			
//			prepStmt = conn.prepareStatement("delete from testTable ");
//			prepStmt.executeUpdate();

//			rs = stmt.executeQuery("select * from testTable");
//			writeMetaData(resultSet);

		} catch (SQLException e) {
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
}
