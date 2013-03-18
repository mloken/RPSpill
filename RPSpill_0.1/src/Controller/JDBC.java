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
			conn = DriverManager.getConnection("jdbc:mysql://localhost/RPGame?"
							+ "user=bent&password=bent");
			
			System.out.println("Connected. Skal nå legge til item.");
			
			stmt = conn.createStatement();
			stmt.executeQuery("use RPGame");
			stmt.executeUpdate("INSERT INTO items values ( " + item.ID + ", " + item.name + ", " + item.rClass +
					", " + item.rLevel + ", " + item.str + ", " + item.dex + ", " + item.intel + ", " + item.AtkDmg + ", "
					+ item.SpellDmg + ", " + item.rStr + ", " + item.rDex + ", " +  item.rInt + ", " + item.quality + ")");
//			writeResultSet(rs);
			System.out.println("Nå burde itemet være lagt inn, men..?");
			// PreparedStatements can use variables and are more efficient
			prepStmt = conn.prepareStatement("insert into  testTable values (1, 'yo', 'yoyo@email')");
			prepStmt.executeUpdate();
			
			prepStmt = conn.prepareStatement("Select * from items");
			prepStmt.executeQuery();
			
			prepStmt = conn.prepareStatement("delete from testTable ");
			prepStmt.executeUpdate();

			rs = stmt.executeQuery("select * from testTable");
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
