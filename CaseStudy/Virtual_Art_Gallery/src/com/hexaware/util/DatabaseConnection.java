package com.hexaware.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static Connection connection;
	
	public DatabaseConnection() {
		
	}
	public static Connection getconnection(String propertyFilePath) {
		String connectionString = DBPropertyUtil.getPropertyString(propertyFilePath);
		if(connection==null) {
			try {
				connection=DriverManager.getConnection(connectionString);
				System.out.println("Connection established");
			}catch(SQLException e) {
				System.out.println("connection failed "+e.getMessage());
				
			}
		}
		return connection;
	}
	
	public static void main(String[] args) {
		getconnection("src/com.hexaware.util/db.properties");
	}

}

