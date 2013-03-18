package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Item;

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
			
//			(id, name, class, rLevel, str, dex, intel, AtkDmg, SpellDmg, rStr, rDex, rInt, quality);
			
			stmt = conn.createStatement();
			stmt.executeQuery("use RPGame"); 
			// Bytt ut * med RPGame => ???
//			stmt.executeQuery("GRANT usage ON * to bent identified by 'bentpw'");
//			stmt.executeQuery("GRANT ALL privileges ON RPGame.* TO bent@localhost;");
			
			//Kan bruke stmt.executeUpdate(String), men ser på String query og stmt.executeUpdate(query);
			String query = "INSERT INTO items VALUES ( '" + item.ID + "', '" + item.name + "', '" + item.rClass + "', " +
					"'" + item.rLevel + "', '" + item.str + "', '" + item.dex + "', '" + item.intel + "', '" + item.AtkDmg + "', '"
					+ item.SpellDmg + "', '" + item.rStr + "', '" + item.rDex + "', '" +  item.rInt + "', '" + item.quality + "')";
			stmt.executeUpdate(query);
			System.out.println("Item # " + item.ID + " was added to table items in database RPGame.");
			// PreparedStatements can use variables and are more efficient
			
			prepStmt = conn.prepareStatement("Select * from items");
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
