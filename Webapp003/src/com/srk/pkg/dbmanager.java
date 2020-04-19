package com.srk.pkg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class dbmanager {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?serverTimezone=UTC","root","Z1X2c3v4$");
			return conn;
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			return null;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}	
		
	}

	
	
	public void createTable() throws SQLException {
		Connection con = getConnection();
		try {
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Tabla_001(id int NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), PRIMARY KEY(id))");
			create.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insertTable(String variable1, String variable2) {
		Connection con = getConnection();
		try {
			
			System.out.print(variable1);			
			System.out.print(variable2);
			
			PreparedStatement statement = con.prepareStatement("INSERT INTO world.tabla_001 (first,last) VALUES ('" + variable1 +"','" + variable2 +"');");
			int result = statement.executeUpdate();
			if(result != 2) 
				return 1;
				else	
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public ResultSet selectTable() throws SQLException {
		Connection con = getConnection();
		try {
			PreparedStatement statement = con.prepareStatement("Select first, last from Tabla_001");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				System.out.print(result.getString(1));
				
				System.out.print(result.getString(2));
				array.add(result.getString("last"));
			}
			System.out.print("All records have been selected");
			return statement.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
