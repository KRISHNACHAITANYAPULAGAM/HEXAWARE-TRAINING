package com.company.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/hmbank"; // Update with your DB name
    private static final String USER = "root"; // Update with your DB username
    private static final String PASSWORD = "1670"; // Update with your DB password
    private static Connection connection;

    // Method to get DB connection
    public static Connection getDBConn() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // Register JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Open a connection
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Method to close DB connection
    public static void closeDBConn() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
